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

public class ahjn
  extends afor
{
  public ahjn(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected afos a()
  {
    return new ahjp(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    paramLinearLayout = (ahjp)paramafos;
    paramafos = paramView;
    if (paramView == null)
    {
      paramafos = LayoutInflater.from(this.a).inflate(2131558924, null);
      paramLinearLayout.b = ((TextView)paramafos.findViewById(2131379001));
      paramLinearLayout.c = ((TextView)paramafos.findViewById(2131365157));
    }
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForTimDouFuGuide)))
    {
      paramMessageRecord = ((MessageForTimDouFuGuide)paramMessageRecord).config;
      if (paramMessageRecord != null)
      {
        paramLinearLayout.b.setText(paramMessageRecord.tipsHighLight);
        paramView = new SpannableString(paramMessageRecord.tipsMsg + anvx.a(2131714315));
        int i = paramView.length();
        paramView.setSpan(new ForegroundColorSpan(paramafos.getResources().getColor(2131167038)), i - 4, i, 33);
        paramLinearLayout.c.setText(paramView);
        paramafos.setOnClickListener(new ahjo(this, paramMessageRecord));
      }
    }
    return paramafos;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bhjs[] a(View paramView)
  {
    return new bhjq().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjn
 * JD-Core Version:    0.7.0.1
 */