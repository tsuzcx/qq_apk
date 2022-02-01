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

public class ahwr
  extends agem
{
  public ahwr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected agen a()
  {
    return new ahws(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    paramagen = (ahws)paramagen;
    paramagen = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558890, null);
      paramagen = (TextView)paramView.findViewById(2131367669);
      paramagen.setMovementMethod(null);
      paramagen.setGravity(17);
      paramagen = paramView;
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramagen = (TextView)paramView.findViewById(2131368014);
        paramLinearLayout = (TextView)paramView.findViewById(2131368015);
        paramagen.setBackgroundColor(2130842510);
        paramLinearLayout.setBackgroundColor(2130842510);
        paramagen = paramView;
      }
    }
    paramView = (TextView)paramagen.findViewById(2131367669);
    if ((paramMessageRecord.istroop == 1) && (nlj.a().a(paramMessageRecord.senderuin)))
    {
      paramView.setTextColor(nlj.d);
      return paramagen;
    }
    paramView.setTextColor(paramagen.getResources().getColorStateList(2131165537));
    return paramagen;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bhum[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwr
 * JD-Core Version:    0.7.0.1
 */