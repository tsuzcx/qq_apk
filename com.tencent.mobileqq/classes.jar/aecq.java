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

public class aecq
  extends actm
{
  public aecq(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected actn a()
  {
    return new aecs(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actn paramactn, View paramView, LinearLayout paramLinearLayout, acxj paramacxj)
  {
    paramLinearLayout = (aecs)paramactn;
    paramactn = paramView;
    if (paramView == null)
    {
      paramactn = LayoutInflater.from(this.a).inflate(2131558784, null);
      paramLinearLayout.b = ((TextView)paramactn.findViewById(2131377350));
      paramLinearLayout.c = ((TextView)paramactn.findViewById(2131364691));
    }
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForTimDouFuGuide)))
    {
      paramMessageRecord = ((MessageForTimDouFuGuide)paramMessageRecord).config;
      if (paramMessageRecord != null)
      {
        paramLinearLayout.b.setText(paramMessageRecord.tipsHighLight);
        paramView = new SpannableString(paramMessageRecord.tipsMsg + ajya.a(2131714944));
        int i = paramView.length();
        paramView.setSpan(new ForegroundColorSpan(paramactn.getResources().getColor(2131166866)), i - 4, i, 33);
        paramLinearLayout.c.setText(paramView);
        paramactn.setOnClickListener(new aecr(this, paramMessageRecord));
      }
    }
    return paramactn;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bbmh[] a(View paramView)
  {
    return new bbmf().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aecq
 * JD-Core Version:    0.7.0.1
 */