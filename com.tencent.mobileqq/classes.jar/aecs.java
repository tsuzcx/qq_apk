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

public class aecs
  extends actq
{
  public aecs(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected actr a()
  {
    return new aecu(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actr paramactr, View paramView, LinearLayout paramLinearLayout, acxn paramacxn)
  {
    paramLinearLayout = (aecu)paramactr;
    paramactr = paramView;
    if (paramView == null)
    {
      paramactr = LayoutInflater.from(this.a).inflate(2131558784, null);
      paramLinearLayout.b = ((TextView)paramactr.findViewById(2131377350));
      paramLinearLayout.c = ((TextView)paramactr.findViewById(2131364692));
    }
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForTimDouFuGuide)))
    {
      paramMessageRecord = ((MessageForTimDouFuGuide)paramMessageRecord).config;
      if (paramMessageRecord != null)
      {
        paramLinearLayout.b.setText(paramMessageRecord.tipsHighLight);
        paramView = new SpannableString(paramMessageRecord.tipsMsg + ajyc.a(2131714933));
        int i = paramView.length();
        paramView.setSpan(new ForegroundColorSpan(paramactr.getResources().getColor(2131166866)), i - 4, i, 33);
        paramLinearLayout.c.setText(paramView);
        paramactr.setOnClickListener(new aect(this, paramMessageRecord));
      }
    }
    return paramactr;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bblt[] a(View paramView)
  {
    return new bblr().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aecs
 * JD-Core Version:    0.7.0.1
 */