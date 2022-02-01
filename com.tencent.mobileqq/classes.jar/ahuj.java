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

public class ahuj
  extends agem
{
  public ahuj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected agen a()
  {
    return new ahul(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    paramLinearLayout = (ahul)paramagen;
    paramagen = paramView;
    if (paramView == null)
    {
      paramagen = LayoutInflater.from(this.a).inflate(2131558889, null);
      paramLinearLayout.b = ((TextView)paramagen.findViewById(2131378936));
      paramLinearLayout.c = ((TextView)paramagen.findViewById(2131365046));
    }
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForTimDouFuGuide)))
    {
      paramMessageRecord = ((MessageForTimDouFuGuide)paramMessageRecord).config;
      if (paramMessageRecord != null)
      {
        paramLinearLayout.b.setText(paramMessageRecord.tipsHighLight);
        paramView = new SpannableString(paramMessageRecord.tipsMsg + anzj.a(2131713736));
        int i = paramView.length();
        paramView.setSpan(new ForegroundColorSpan(paramagen.getResources().getColor(2131167002)), i - 4, i, 33);
        paramLinearLayout.c.setText(paramView);
        paramagen.setOnClickListener(new ahuk(this, paramMessageRecord));
      }
    }
    return paramagen;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bhum[] a(View paramView)
  {
    return new bhuk().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahuj
 * JD-Core Version:    0.7.0.1
 */