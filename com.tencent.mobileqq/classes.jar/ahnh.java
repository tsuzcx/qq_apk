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

public class ahnh
  extends afuu
{
  public ahnh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected afuv a()
  {
    return new ahni(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afuv paramafuv, View paramView, LinearLayout paramLinearLayout, afzq paramafzq)
  {
    paramafuv = (ahni)paramafuv;
    paramafuv = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558892, null);
      paramafuv = (TextView)paramView.findViewById(2131367600);
      paramafuv.setMovementMethod(null);
      paramafuv.setGravity(17);
      paramafuv = paramView;
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramafuv = (TextView)paramView.findViewById(2131367944);
        paramLinearLayout = (TextView)paramView.findViewById(2131367945);
        paramafuv.setBackgroundColor(2130842497);
        paramLinearLayout.setBackgroundColor(2130842497);
        paramafuv = paramView;
      }
    }
    paramView = (TextView)paramafuv.findViewById(2131367600);
    if ((paramMessageRecord.istroop == 1) && (njo.a().a(paramMessageRecord.senderuin)))
    {
      paramView.setTextColor(njo.d);
      return paramafuv;
    }
    paramView.setTextColor(paramafuv.getResources().getColorStateList(2131165537));
    return paramafuv;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bguj[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahnh
 * JD-Core Version:    0.7.0.1
 */