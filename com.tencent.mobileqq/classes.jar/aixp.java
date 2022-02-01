import com.tencent.mobileqq.activity.history.ChatHistoryMediaBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aixp
  extends asbj
{
  private aixp(ChatHistoryMediaBaseFragment paramChatHistoryMediaBaseFragment) {}
  
  protected void onFileTransferEnd(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryMediaBaseFragment", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong2);
    if ((paramString1 != null) && (paramString1.nOpType == 6) && (bleg.a(paramInt2)) && (this.a.jdField_a_of_type_MqqOsMqqHandler != null)) {
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(102);
    }
  }
  
  protected void onOfflineSendToWeiYunFaild(int paramInt, long paramLong, String paramString)
  {
    if ((bleg.a(paramInt)) && (this.a.jdField_a_of_type_MqqOsMqqHandler != null)) {
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(102);
    }
  }
  
  protected void onOfflineSendToWeiYunSuccess(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((bleg.a(paramInt)) && (this.a.jdField_a_of_type_MqqOsMqqHandler != null)) {
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(102);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixp
 * JD-Core Version:    0.7.0.1
 */