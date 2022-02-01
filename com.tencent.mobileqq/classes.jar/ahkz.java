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

public class ahkz
  extends afuu
{
  public ahkz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected afuv a()
  {
    return new ahlb(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afuv paramafuv, View paramView, LinearLayout paramLinearLayout, afzq paramafzq)
  {
    paramLinearLayout = (ahlb)paramafuv;
    paramafuv = paramView;
    if (paramView == null)
    {
      paramafuv = LayoutInflater.from(this.a).inflate(2131558891, null);
      paramLinearLayout.b = ((TextView)paramafuv.findViewById(2131378776));
      paramLinearLayout.c = ((TextView)paramafuv.findViewById(2131364999));
    }
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForTimDouFuGuide)))
    {
      paramMessageRecord = ((MessageForTimDouFuGuide)paramMessageRecord).config;
      if (paramMessageRecord != null)
      {
        paramLinearLayout.b.setText(paramMessageRecord.tipsHighLight);
        paramView = new SpannableString(paramMessageRecord.tipsMsg + anni.a(2131713627));
        int i = paramView.length();
        paramView.setSpan(new ForegroundColorSpan(paramafuv.getResources().getColor(2131166998)), i - 4, i, 33);
        paramLinearLayout.c.setText(paramView);
        paramafuv.setOnClickListener(new ahla(this, paramMessageRecord));
      }
    }
    return paramafuv;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bguj[] a(View paramView)
  {
    return new bguh().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkz
 * JD-Core Version:    0.7.0.1
 */