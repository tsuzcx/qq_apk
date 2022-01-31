import com.tencent.mobileqq.data.MessageForInteractAndFollow;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;

public class accs
  implements Runnable
{
  public accs(MsgBoxInterFollowManager paramMsgBoxInterFollowManager, MessageForInteractAndFollow paramMessageForInteractAndFollow) {}
  
  public void run()
  {
    MsgBoxInterFollowManager.access$000(this.jdField_a_of_type_ComTencentMobileqqDataMsgBoxInterFollowManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageForInteractAndFollow);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     accs
 * JD-Core Version:    0.7.0.1
 */