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

public class advd
  extends actm
{
  public advd(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected actn a()
  {
    return new adve(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actn paramactn, View paramView, LinearLayout paramLinearLayout, acxj paramacxj)
  {
    paramLinearLayout = (adve)paramactn;
    paramactn = paramView;
    if (paramView == null)
    {
      paramactn = LayoutInflater.from(this.a).inflate(2131558782, null);
      paramLinearLayout.b = ((TextView)paramactn.findViewById(2131367153));
    }
    paramLinearLayout.b.setMovementMethod(null);
    paramLinearLayout.b.setGravity(17);
    if ((paramMessageRecord instanceof MessageForMyEnterTroop))
    {
      paramMessageRecord = (MessageForMyEnterTroop)paramMessageRecord;
      paramMessageRecord = this.a.getString(2131697478);
      paramLinearLayout.b.setText(paramMessageRecord);
      paramView = this.a.getResources().getColorStateList(2131165359);
      if (paramView != null) {
        paramLinearLayout.b.setTextColor(paramView);
      }
      paramactn.setContentDescription(paramMessageRecord);
    }
    return paramactn;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bbmh[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     advd
 * JD-Core Version:    0.7.0.1
 */