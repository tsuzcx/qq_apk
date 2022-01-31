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

public class afrq
  extends aekw
{
  public afrq(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected aekx a()
  {
    return new afrr(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aekx paramaekx, View paramView, LinearLayout paramLinearLayout, aeov paramaeov)
  {
    paramLinearLayout = (afrr)paramaekx;
    paramaekx = paramView;
    if (paramView == null)
    {
      paramaekx = LayoutInflater.from(this.a).inflate(2131558818, null);
      paramLinearLayout.b = ((TextView)paramaekx.findViewById(2131367282));
    }
    paramLinearLayout.b.setMovementMethod(null);
    paramLinearLayout.b.setGravity(17);
    if ((paramMessageRecord instanceof MessageForMyEnterTroop))
    {
      paramMessageRecord = (MessageForMyEnterTroop)paramMessageRecord;
      paramMessageRecord = this.a.getString(2131697653);
      paramLinearLayout.b.setText(paramMessageRecord);
      paramView = this.a.getResources().getColorStateList(2131165394);
      if (paramView != null) {
        paramLinearLayout.b.setTextColor(paramView);
      }
      paramaekx.setContentDescription(paramMessageRecord);
    }
    return paramaekx;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bdlb[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrq
 * JD-Core Version:    0.7.0.1
 */