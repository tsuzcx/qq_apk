import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbSendMsgReq;

class akbr
  implements akae
{
  akbr(akbq paramakbq, String paramString, FMTransC2CMsgInfo paramFMTransC2CMsgInfo, int paramInt, byte[] paramArrayOfByte) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_Akbq.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_JavaLangString);
    localToServiceMsg.extraData.putLong("msgsize", 0L);
    localToServiceMsg.extraData.putLong("uniseq", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.uniseq);
    localToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
    localToServiceMsg.extraData.putString("uuid", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.uuid);
    localToServiceMsg.extraData.putByte("cmd", (byte)0);
    localToServiceMsg.extraData.putByte("keyType", (byte)0);
    localToServiceMsg.extraData.putInt("busiType", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.busiType);
    localToServiceMsg.extraData.putString("toUin", this.jdField_a_of_type_JavaLangString);
    localToServiceMsg.extraData.putLong("queueSeq", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.queueSeq);
    localToServiceMsg.extraData.putLong("sessionid", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.sessionId);
    localToServiceMsg.extraData.putInt("random", awbk.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.msgUid));
    localToServiceMsg.addAttribute("_tag_LOGSTR", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.msgSeq));
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
    localToServiceMsg.extraData.putInt("transC2CCmd", this.jdField_a_of_type_Int);
    awbn localawbn = new awbn();
    localawbn.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.subCmd;
    localawbn.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    msg_svc.PbSendMsgReq localPbSendMsgReq = awbg.a(this.jdField_a_of_type_Akbq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 13, this.jdField_a_of_type_JavaLangString, localawbn, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.msgSeq, awbk.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.msgUid));
    akbq.a(this.jdField_a_of_type_Akbq, localPbSendMsgReq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo);
    akbq.a(this.jdField_a_of_type_Akbq, localPbSendMsgReq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo, localawbn);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.entity != null) {
      localToServiceMsg.extraData.putLong("tmpSessionType", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.entity.tmpSessionType);
    }
    localToServiceMsg.putWupBuffer(localPbSendMsgReq.toByteArray());
    localToServiceMsg.extraData.putLong(aofk.class.getName(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.observerSeq);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akbr
 * JD-Core Version:    0.7.0.1
 */