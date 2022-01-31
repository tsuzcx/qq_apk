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

public class adrt
  extends acjb
{
  public adrt(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected acjc a()
  {
    return new adrv(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, acjc paramacjc, View paramView, LinearLayout paramLinearLayout, acmv paramacmv)
  {
    paramLinearLayout = (adrv)paramacjc;
    paramacjc = paramView;
    if (paramView == null)
    {
      paramacjc = LayoutInflater.from(this.a).inflate(2131493228, null);
      paramLinearLayout.b = ((TextView)paramacjc.findViewById(2131311534));
      paramLinearLayout.c = ((TextView)paramacjc.findViewById(2131299132));
    }
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForTimDouFuGuide)))
    {
      paramMessageRecord = ((MessageForTimDouFuGuide)paramMessageRecord).config;
      if (paramMessageRecord != null)
      {
        paramLinearLayout.b.setText(paramMessageRecord.tipsHighLight);
        paramView = new SpannableString(paramMessageRecord.tipsMsg + ajjy.a(2131649144));
        int i = paramView.length();
        paramView.setSpan(new ForegroundColorSpan(paramacjc.getResources().getColor(2131101272)), i - 4, i, 33);
        paramLinearLayout.c.setText(paramView);
        paramacjc.setOnClickListener(new adru(this, paramMessageRecord));
      }
    }
    return paramacjc;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bakj[] a(View paramView)
  {
    return new bakh().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adrt
 * JD-Core Version:    0.7.0.1
 */