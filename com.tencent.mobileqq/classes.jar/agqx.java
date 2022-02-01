import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTimDouFuGuide;
import com.tencent.mobileqq.data.MessageRecord;

public class agqx
  extends aexf
{
  public agqx(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected aexg a()
  {
    return new agqz(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aexg paramaexg, View paramView, LinearLayout paramLinearLayout, afce paramafce)
  {
    paramLinearLayout = (agqz)paramaexg;
    paramaexg = paramView;
    if (paramView == null)
    {
      paramaexg = LayoutInflater.from(this.a).inflate(2131558897, null);
      paramLinearLayout.b = ((TextView)paramaexg.findViewById(2131378707));
      paramLinearLayout.c = ((TextView)paramaexg.findViewById(2131365073));
    }
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForTimDouFuGuide)))
    {
      paramMessageRecord = ((MessageForTimDouFuGuide)paramMessageRecord).config;
      if (paramMessageRecord != null)
      {
        paramLinearLayout.b.setText(paramMessageRecord.tipsHighLight);
        paramView = new SpannableString(paramMessageRecord.tipsMsg + amtj.a(2131713968));
        int i = paramView.length();
        paramView.setSpan(new ForegroundColorSpan(paramaexg.getResources().getColor(2131167024)), i - 4, i, 33);
        paramLinearLayout.c.setText(paramView);
        paramaexg.setOnClickListener(new agqy(this, paramMessageRecord));
      }
    }
    return paramaexg;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bgbb[] a(View paramView)
  {
    return new bgaz().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqx
 * JD-Core Version:    0.7.0.1
 */