import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ptt.PttBuffer;
import com.tencent.mobileqq.receipt.ReceiptMsgManager;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import java.util.ArrayList;

public class agre
  implements Runnable
{
  public agre(ReceiptMsgManager paramReceiptMsgManager, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, String paramString, int paramInt3, boolean paramBoolean, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMsgManager.a.voiceLength = QQRecorder.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMsgManager.a.voiceChangeFlag = this.b;
    this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMsgManager.a.voiceType = this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.c;
    this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMsgManager.a.fullLocalPath = this.jdField_a_of_type_JavaLangString;
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMsgManager.a);
    PttBuffer.b(this.jdField_a_of_type_JavaLangString);
    Bundle localBundle = new Bundle();
    localBundle.putString("ReceiptMsgManager.EXTRA_KEY_PTT_PATH", this.jdField_a_of_type_JavaLangString);
    localBundle.putInt("ReceiptMsgManager.EXTRA_KEY_PTT_SEND_SOURCE", this.c);
    localBundle.putBoolean("ReceiptMsgManager.EXTRA_KEY_PTT_COMPRESS_FINISHED", this.jdField_a_of_type_Boolean);
    ReceiptMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMsgManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ReceiptMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMsgManager, 3), false, localArrayList, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     agre
 * JD-Core Version:    0.7.0.1
 */