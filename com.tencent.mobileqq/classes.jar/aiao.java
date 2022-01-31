import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.UploadStreamStruct;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.qphone.base.util.QLog;

public class aiao
  extends MessageObserver
{
  public aiao(BuddyTransfileProcessor paramBuddyTransfileProcessor) {}
  
  protected void a(boolean paramBoolean, MessageFactoryReceiver.UploadStreamStruct paramUploadStreamStruct)
  {
    if ((paramUploadStreamStruct != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "onUpdateUploadStreamFinished Key:" + paramUploadStreamStruct.jdField_a_of_type_JavaLangString + " seq:" + paramUploadStreamStruct.jdField_a_of_type_Short + " Layer:" + paramUploadStreamStruct.jdField_a_of_type_Int + " RespCode:" + paramUploadStreamStruct.b);
    }
    if ((this.a.a != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "isSuccess:" + paramBoolean + "　FilePath:" + this.a.a.c + " isStreamPttSuccess:" + this.a.d);
    }
    this.a.c(2);
    if ((paramUploadStreamStruct == null) || (paramUploadStreamStruct.jdField_a_of_type_JavaLangString == null) || (!paramUploadStreamStruct.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.a.a.c))) {
      return;
    }
    if (!paramBoolean)
    {
      BuddyTransfileProcessor.a(this.a, false, paramUploadStreamStruct);
      return;
    }
    BuddyTransfileProcessor.a(this.a, true, paramUploadStreamStruct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiao
 * JD-Core Version:    0.7.0.1
 */