import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;

class agrr
  implements audq
{
  agrr(agrp paramagrp, MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct) {}
  
  public void onNo() {}
  
  public void onYes()
  {
    ((abkw)this.jdField_a_of_type_Agrp.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceSingleStruct);
    agrp.b(this.jdField_a_of_type_Agrp, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceSingleStruct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrr
 * JD-Core Version:    0.7.0.1
 */