import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.qphone.base.util.QLog;

class agro
  extends ameq
{
  agro(agrn paramagrn) {}
  
  protected void d(boolean paramBoolean, String paramString)
  {
    if ((this.a.w != 2) && (paramBoolean) && (this.a.b != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin.equals(paramString)) && (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.hasPostRedPoint())) {
      this.a.b.a(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString + "Q.hotchat.aio_post_red_point", 2, "onBuluoHotChatRedPointComing, troopUin:" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agro
 * JD-Core Version:    0.7.0.1
 */