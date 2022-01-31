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

public class agfs
  extends aepl
{
  public agfs(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected aepm a()
  {
    return new agft(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aepm paramaepm, View paramView, LinearLayout paramLinearLayout, aetk paramaetk)
  {
    paramaepm = (agft)paramaepm;
    paramaepm = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558820, null);
      paramaepm = (TextView)paramView.findViewById(2131367292);
      paramaepm.setMovementMethod(null);
      paramaepm.setGravity(17);
      paramaepm = paramView;
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramaepm = (TextView)paramView.findViewById(2131367637);
        paramLinearLayout = (TextView)paramView.findViewById(2131367638);
        paramaepm.setBackgroundColor(2130842187);
        paramLinearLayout.setBackgroundColor(2130842187);
        paramaepm = paramView;
      }
    }
    paramView = (TextView)paramaepm.findViewById(2131367292);
    if ((paramMessageRecord.istroop == 1) && (nav.a().a(paramMessageRecord.senderuin)))
    {
      paramView.setTextColor(nav.d);
      return paramaepm;
    }
    paramView.setTextColor(paramaepm.getResources().getColorStateList(2131165500));
    return paramaepm;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bdpk[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agfs
 * JD-Core Version:    0.7.0.1
 */