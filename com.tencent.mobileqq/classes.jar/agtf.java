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

public class agtf
  extends aexf
{
  public agtf(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected aexg a()
  {
    return new agtg(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aexg paramaexg, View paramView, LinearLayout paramLinearLayout, afce paramafce)
  {
    paramaexg = (agtg)paramaexg;
    paramaexg = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558898, null);
      paramaexg = (TextView)paramView.findViewById(2131367701);
      paramaexg.setMovementMethod(null);
      paramaexg.setGravity(17);
      paramaexg = paramView;
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramaexg = (TextView)paramView.findViewById(2131368049);
        paramLinearLayout = (TextView)paramView.findViewById(2131368050);
        paramaexg.setBackgroundColor(2130842556);
        paramLinearLayout.setBackgroundColor(2130842556);
        paramaexg = paramView;
      }
    }
    paramView = (TextView)paramaexg.findViewById(2131367701);
    if ((paramMessageRecord.istroop == 1) && (nmy.a().a(paramMessageRecord.senderuin)))
    {
      paramView.setTextColor(nmy.d);
      return paramaexg;
    }
    paramView.setTextColor(paramaexg.getResources().getColorStateList(2131165545));
    return paramaexg;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bgbb[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agtf
 * JD-Core Version:    0.7.0.1
 */