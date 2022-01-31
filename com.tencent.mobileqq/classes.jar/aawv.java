import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Conversation.45.1;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

public class aawv
  extends BroadcastReceiver
{
  public aawv(Conversation paramConversation) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("wording");
    int i = paramIntent.getIntExtra("timetowait", 360000);
    this.a.jdField_a_of_type_Ahkd.jdField_a_of_type_Int = i;
    this.a.jdField_a_of_type_Ahkd.jdField_a_of_type_JavaLangString = paramContext;
    this.a.jdField_a_of_type_Ahkd.a(19, 2);
    this.a.jdField_a_of_type_Ahkd.a(-1, null);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class).postDelayed(new Conversation.45.1(this), i);
    axqy.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_PushBanner", "showBanner", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aawv
 * JD-Core Version:    0.7.0.1
 */