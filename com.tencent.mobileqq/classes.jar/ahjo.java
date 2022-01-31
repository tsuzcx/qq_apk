import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.service.AVPbInfo;
import com.tencent.av.service.QavWrapper;
import com.tencent.av.service.QavWrapper.OnReadyListener;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.qphone.base.util.QLog;

public final class ahjo
  implements QavWrapper.OnReadyListener
{
  public ahjo(byte[] paramArrayOfByte, long paramLong1, String paramString1, String paramString2, MessageHandler paramMessageHandler, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean) {}
  
  public void a(QavWrapper paramQavWrapper)
  {
    AVPbInfo localAVPbInfo = paramQavWrapper.a(this.jdField_a_of_type_ArrayOfByte);
    if (localAVPbInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("decodeC2CMsgPkg_QCall", 2, "ret, bindId:" + localAVPbInfo.bindId + ", bindIdType:" + localAVPbInfo.bindIdType + ", phoneNum:" + localAVPbInfo.phoneNum);
      }
      if ((!VcSystemInfo.c()) || (!VcSystemInfo.d())) {
        if (QLog.isColorLevel()) {
          QLog.d("decodeC2CMsgPkg_QCall", 2, "Discard video message cause device not support");
        }
      }
    }
    for (;;)
    {
      paramQavWrapper.a();
      return;
      if (this.jdField_a_of_type_Long >= 60L)
      {
        if ((!this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) && (!localAVPbInfo.phoneNum.equals("0")))
        {
          if (!localAVPbInfo.phoneNum.startsWith("+")) {
            localAVPbInfo.phoneNum = ("+" + localAVPbInfo.phoneNum);
          }
          QCallFacade localQCallFacade = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getManager(37);
          VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b, 25, 6, false, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, false, null, false);
          localQCallFacade.a(this.jdField_b_of_type_JavaLangString, 8, null, localAVPbInfo.phoneNum);
        }
        if (QLog.isColorLevel()) {
          QLog.d("decodeC2CMsgPkg_QCall", 2, "Discard video message because of time out " + this.jdField_a_of_type_Long + " s");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("decodeC2CMsgPkg_QCall", 2, "===========handleSharpVideoMessageResp 1234========");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ArrayOfByte, this.c, (int)this.d, this.jdField_a_of_type_Boolean);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("decodeC2CMsgPkg_QCall", 2, "ret, decode failed!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahjo
 * JD-Core Version:    0.7.0.1
 */