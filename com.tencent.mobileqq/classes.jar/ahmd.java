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

public class ahmd
  extends afor
{
  public ahmd(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected afos a()
  {
    return new ahme(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    paramafos = (ahme)paramafos;
    paramafos = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558925, null);
      paramafos = (TextView)paramView.findViewById(2131367837);
      paramafos.setMovementMethod(null);
      paramafos.setGravity(17);
      paramafos = paramView;
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramafos = (TextView)paramView.findViewById(2131368184);
        paramLinearLayout = (TextView)paramView.findViewById(2131368185);
        paramafos.setBackgroundColor(2130842586);
        paramLinearLayout.setBackgroundColor(2130842586);
        paramafos = paramView;
      }
    }
    paramView = (TextView)paramafos.findViewById(2131367837);
    if ((paramMessageRecord.istroop == 1) && (nty.a().a(paramMessageRecord.senderuin)))
    {
      paramView.setTextColor(nty.d);
      return paramafos;
    }
    paramView.setTextColor(paramafos.getResources().getColorStateList(2131165551));
    return paramafos;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bhjs[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmd
 * JD-Core Version:    0.7.0.1
 */