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

public class ahbu
  extends afor
{
  public ahbu(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected afos a()
  {
    return new ahbv(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    paramLinearLayout = (ahbv)paramafos;
    paramafos = paramView;
    if (paramView == null)
    {
      paramafos = LayoutInflater.from(this.a).inflate(2131558922, null);
      paramLinearLayout.b = ((TextView)paramafos.findViewById(2131367837));
    }
    paramLinearLayout.b.setMovementMethod(null);
    paramLinearLayout.b.setGravity(17);
    if ((paramMessageRecord instanceof MessageForMyEnterTroop))
    {
      paramMessageRecord = (MessageForMyEnterTroop)paramMessageRecord;
      paramMessageRecord = this.a.getString(2131696948);
      paramLinearLayout.b.setText(paramMessageRecord);
      paramView = this.a.getResources().getColorStateList(2131165442);
      if (paramView != null) {
        paramLinearLayout.b.setTextColor(paramView);
      }
      paramafos.setContentDescription(paramMessageRecord);
    }
    return paramafos;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bhjs[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbu
 * JD-Core Version:    0.7.0.1
 */