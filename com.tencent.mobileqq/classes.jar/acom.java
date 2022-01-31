import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.OnMagicPlayEnd;
import com.tencent.qphone.base.util.QLog;

class acom
  implements MagicfaceViewController.OnMagicPlayEnd
{
  acom(acol paramacol, String paramString) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicEmoticonInfo", 2, "forward, [play back] ready to send msg,magicvalue:" + this.jdField_a_of_type_Acol.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.magicValue);
    }
    this.jdField_a_of_type_Acol.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.magicValue = this.jdField_a_of_type_JavaLangString;
    ChatActivityFacade.a(this.jdField_a_of_type_Acol.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Acol.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Acol.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Acol.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acom
 * JD-Core Version:    0.7.0.1
 */