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

public class afze
  extends aekw
{
  public afze(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected aekx a()
  {
    return new afzg(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aekx paramaekx, View paramView, LinearLayout paramLinearLayout, aeov paramaeov)
  {
    paramLinearLayout = (afzg)paramaekx;
    paramaekx = paramView;
    if (paramView == null)
    {
      paramaekx = LayoutInflater.from(this.a).inflate(2131558820, null);
      paramLinearLayout.b = ((TextView)paramaekx.findViewById(2131377884));
      paramLinearLayout.c = ((TextView)paramaekx.findViewById(2131364770));
    }
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForTimDouFuGuide)))
    {
      paramMessageRecord = ((MessageForTimDouFuGuide)paramMessageRecord).config;
      if (paramMessageRecord != null)
      {
        paramLinearLayout.b.setText(paramMessageRecord.tipsHighLight);
        paramView = new SpannableString(paramMessageRecord.tipsMsg + alpo.a(2131715316));
        int i = paramView.length();
        paramView.setSpan(new ForegroundColorSpan(paramaekx.getResources().getColor(2131166913)), i - 4, i, 33);
        paramLinearLayout.c.setText(paramView);
        paramaekx.setOnClickListener(new afzf(this, paramMessageRecord));
      }
    }
    return paramaekx;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bdlb[] a(View paramView)
  {
    return new bdkz().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afze
 * JD-Core Version:    0.7.0.1
 */