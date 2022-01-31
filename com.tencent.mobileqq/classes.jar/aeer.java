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

public class aeer
  extends actq
{
  public aeer(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected actr a()
  {
    return new aees(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actr paramactr, View paramView, LinearLayout paramLinearLayout, acxn paramacxn)
  {
    paramactr = (aees)paramactr;
    paramactr = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558785, null);
      paramactr = (TextView)paramView.findViewById(2131367153);
      paramactr.setMovementMethod(null);
      paramactr.setGravity(17);
      paramactr = paramView;
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramactr = (TextView)paramView.findViewById(2131367499);
        paramLinearLayout = (TextView)paramView.findViewById(2131367500);
        paramactr.setBackgroundColor(2130842021);
        paramLinearLayout.setBackgroundColor(2130842021);
        paramactr = paramView;
      }
    }
    paramView = (TextView)paramactr.findViewById(2131367153);
    if ((paramMessageRecord.istroop == 1) && (mye.a().a(paramMessageRecord.senderuin)))
    {
      paramView.setTextColor(mye.d);
      return paramactr;
    }
    paramView.setTextColor(paramactr.getResources().getColorStateList(2131165465));
    return paramactr;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bblt[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeer
 * JD-Core Version:    0.7.0.1
 */