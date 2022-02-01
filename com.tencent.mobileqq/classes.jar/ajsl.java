import com.tencent.mobileqq.activity.history.ChatHistoryC2CMediaFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ajsl
  extends atfq
{
  public ajsl(ChatHistoryC2CMediaFragment paramChatHistoryC2CMediaFragment) {}
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    if ((bmqx.a(paramInt)) && (this.a.jdField_a_of_type_MqqOsMqqHandler != null)) {
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(102);
    }
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((bmqx.a(paramInt)) && (this.a.jdField_a_of_type_MqqOsMqqHandler != null)) {
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(102);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryMediaBaseFragment", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong2);
    if ((paramString1 != null) && (paramString1.nOpType == 6) && (bmqx.a(paramInt2)) && (this.a.jdField_a_of_type_MqqOsMqqHandler != null)) {
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(102);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsl
 * JD-Core Version:    0.7.0.1
 */