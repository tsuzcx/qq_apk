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
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;

public class agbd
  extends aekw
{
  public agbd(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected aekx a()
  {
    return new agbe(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aekx paramaekx, View paramView, LinearLayout paramLinearLayout, aeov paramaeov)
  {
    paramaekx = (agbe)paramaekx;
    paramaekx = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558821, null);
      paramaekx = (TextView)paramView.findViewById(2131367282);
      paramaekx.setMovementMethod(null);
      paramaekx.setGravity(17);
      paramaekx = paramView;
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramaekx = (TextView)paramView.findViewById(2131367627);
        paramLinearLayout = (TextView)paramView.findViewById(2131367628);
        paramaekx.setBackgroundColor(2130842174);
        paramLinearLayout.setBackgroundColor(2130842174);
        paramaekx = paramView;
      }
    }
    paramView = (TextView)paramaekx.findViewById(2131367282);
    if ((paramMessageRecord.istroop == 1) && (nav.a().a(paramMessageRecord.senderuin)))
    {
      paramView.setTextColor(nav.d);
      return paramaekx;
    }
    paramView.setTextColor(paramaekx.getResources().getColorStateList(2131165500));
    return paramaekx;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bdlb[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agbd
 * JD-Core Version:    0.7.0.1
 */