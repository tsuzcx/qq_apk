import com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker;
import com.tencent.qphone.base.util.QLog;

public class acyd
  extends acxm
{
  public acyd(OnlineFileSessionWorker paramOnlineFileSessionWorker)
  {
    super(paramOnlineFileSessionWorker);
  }
  
  protected String a()
  {
    return "StateRefuseByPCWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    OnlineFileSessionWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 6);
    OnlineFileSessionWorker.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 6);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acxm.a() + "->StateRefuseByPC)");
    this.jdField_a_of_type_Acxm = new acyc(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acyd
 * JD-Core Version:    0.7.0.1
 */