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

public class adts
  extends acjb
{
  public adts(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected acjc a()
  {
    return new adtt(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, acjc paramacjc, View paramView, LinearLayout paramLinearLayout, acmv paramacmv)
  {
    paramacjc = (adtt)paramacjc;
    paramacjc = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493229, null);
      paramacjc = (TextView)paramView.findViewById(2131301543);
      paramacjc.setMovementMethod(null);
      paramacjc.setGravity(17);
      paramacjc = paramView;
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramacjc = (TextView)paramView.findViewById(2131301882);
        paramLinearLayout = (TextView)paramView.findViewById(2131301883);
        paramacjc.setBackgroundColor(2130841928);
        paramLinearLayout.setBackgroundColor(2130841928);
        paramacjc = paramView;
      }
    }
    paramView = (TextView)paramacjc.findViewById(2131301543);
    if ((paramMessageRecord.istroop == 1) && (mnf.a().a(paramMessageRecord.senderuin)))
    {
      paramView.setTextColor(mnf.d);
      return paramacjc;
    }
    paramView.setTextColor(paramacjc.getResources().getColorStateList(2131099880));
    return paramacjc;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bakj[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adts
 * JD-Core Version:    0.7.0.1
 */