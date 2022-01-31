import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.OnMagicPlayEnd;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class acoo
  implements MagicfaceViewController.OnMagicPlayEnd
{
  acoo(acon paramacon, String paramString) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicEmoticonInfo", 2, "[play back] ready to send msg,magicvalue:" + this.jdField_a_of_type_Acon.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue);
    }
    this.jdField_a_of_type_Acon.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue = this.jdField_a_of_type_JavaLangString;
    ChatActivityFacade.a(this.jdField_a_of_type_Acon.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Acon.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Acon.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Acon.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
    ReportController.b(this.jdField_a_of_type_Acon.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, this.jdField_a_of_type_Acon.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acoo
 * JD-Core Version:    0.7.0.1
 */