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

public class aeep
  extends actm
{
  public aeep(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected actn a()
  {
    return new aeeq(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actn paramactn, View paramView, LinearLayout paramLinearLayout, acxj paramacxj)
  {
    paramactn = (aeeq)paramactn;
    paramactn = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558785, null);
      paramactn = (TextView)paramView.findViewById(2131367153);
      paramactn.setMovementMethod(null);
      paramactn.setGravity(17);
      paramactn = paramView;
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramactn = (TextView)paramView.findViewById(2131367499);
        paramLinearLayout = (TextView)paramView.findViewById(2131367500);
        paramactn.setBackgroundColor(2130842022);
        paramLinearLayout.setBackgroundColor(2130842022);
        paramactn = paramView;
      }
    }
    paramView = (TextView)paramactn.findViewById(2131367153);
    if ((paramMessageRecord.istroop == 1) && (myb.a().a(paramMessageRecord.senderuin)))
    {
      paramView.setTextColor(myb.d);
      return paramactn;
    }
    paramView.setTextColor(paramactn.getResources().getColorStateList(2131165465));
    return paramactn;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bbmh[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeep
 * JD-Core Version:    0.7.0.1
 */