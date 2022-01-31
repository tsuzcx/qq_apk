import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.scribble.ScribbleBaseOperator;
import com.tencent.qphone.base.util.QLog;

public class ahpy
  implements Runnable
{
  public ahpy(ScribbleBaseOperator paramScribbleBaseOperator, MessageForScribble paramMessageForScribble) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleBaseOperator.a.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble, this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleBaseOperator.a.getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleBaseOperator.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble, this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.localFildPath, null);
    QLog.i("SCRIBBLEMSG", 2, "!!!addMessage uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpy
 * JD-Core Version:    0.7.0.1
 */