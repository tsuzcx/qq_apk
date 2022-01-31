import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbSendMsgReq;

class akqd
  implements akop
{
  akqd(akqb paramakqb, String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_Akqb.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_JavaLangString);
    localToServiceMsg.extraData.putByte("cmd", (byte)0);
    localToServiceMsg.extraData.putByte("keyType", (byte)0);
    localToServiceMsg.extraData.putByte("sendType", (byte)0);
    localToServiceMsg.extraData.putInt("busiType", 1025);
    localToServiceMsg.extraData.putString("toUin", this.jdField_a_of_type_JavaLangString);
    localToServiceMsg.extraData.putLong("sessionid", this.jdField_a_of_type_Long);
    localToServiceMsg.extraData.putInt("random", this.jdField_a_of_type_Int);
    localToServiceMsg.extraData.putLong("msgsize", 0L);
    localToServiceMsg.addAttribute("_tag_LOGSTR", String.valueOf(this.jdField_b_of_type_Long));
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 9);
    localToServiceMsg.extraData.putInt("transC2CCmd", this.jdField_b_of_type_Int);
    axax localaxax = new axax();
    localaxax.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    localaxax.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localToServiceMsg.putWupBuffer(axaq.a(this.jdField_a_of_type_Akqb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 9, this.jdField_a_of_type_JavaLangString, localaxax, this.jdField_b_of_type_Long, this.jdField_a_of_type_Int).toByteArray());
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akqd
 * JD-Core Version:    0.7.0.1
 */