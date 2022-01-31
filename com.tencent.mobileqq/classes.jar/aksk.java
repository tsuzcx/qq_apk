import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;

class aksk
  implements Runnable
{
  aksk(aksi paramaksi) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentOpenBaseTicketUtils.a();
    if (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a != null)
    {
      if (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a() <= 2) {
        ((TMAssistantCallYYB_V1)this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a()).startToAuthorized(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a, "2");
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a = null;
        return;
        ((TMAssistantCallYYB_V2)this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a()).startToAuthorized(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a, "2");
      }
    }
    LogUtility.e("MyAppApi", "startToAuthorizedDirect->onGetA1Fail mLastAuthorizeParam = null, needCarryQQIdentity = true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aksk
 * JD-Core Version:    0.7.0.1
 */