import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.Conversation.49.1;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

public class ajco
  extends BroadcastReceiver
{
  public ajco(Conversation paramConversation) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("wording");
    int i = paramIntent.getIntExtra("timetowait", 360000);
    this.a.jdField_a_of_type_Akho.jdField_a_of_type_Int = i;
    this.a.jdField_a_of_type_Akho.jdField_a_of_type_JavaLangString = paramContext;
    this.a.jdField_a_of_type_Akho.a(22, 2);
    this.a.jdField_a_of_type_Akho.a(-1, null);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class).postDelayed(new Conversation.49.1(this), i);
    bcef.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_PushBanner", "showBanner", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajco
 * JD-Core Version:    0.7.0.1
 */