import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMyEnterTroop;
import com.tencent.mobileqq.data.MessageRecord;

public class adke
  extends acjb
{
  public adke(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected acjc a()
  {
    return new adkf(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, acjc paramacjc, View paramView, LinearLayout paramLinearLayout, acmv paramacmv)
  {
    paramLinearLayout = (adkf)paramacjc;
    paramacjc = paramView;
    if (paramView == null)
    {
      paramacjc = LayoutInflater.from(this.a).inflate(2131493226, null);
      paramLinearLayout.b = ((TextView)paramacjc.findViewById(2131301543));
    }
    paramLinearLayout.b.setMovementMethod(null);
    paramLinearLayout.b.setGravity(17);
    if ((paramMessageRecord instanceof MessageForMyEnterTroop))
    {
      paramMessageRecord = (MessageForMyEnterTroop)paramMessageRecord;
      paramMessageRecord = this.a.getString(2131631765);
      paramLinearLayout.b.setText(paramMessageRecord);
      paramView = this.a.getResources().getColorStateList(2131099822);
      if (paramView != null) {
        paramLinearLayout.b.setTextColor(paramView);
      }
      paramacjc.setContentDescription(paramMessageRecord);
    }
    return paramacjc;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bakj[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adke
 * JD-Core Version:    0.7.0.1
 */