import android.text.TextUtils;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchWorker;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils.TroopFileReportResultCode;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class ajmd
  implements Runnable
{
  public ajmd(TroopFileThumbnailFetchWorker paramTroopFileThumbnailFetchWorker) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_Boolean)
    {
      TroopFileTransferUtil.Log.b("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] start. had stoped");
      return;
    }
    this.a.c();
    this.a.e = this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_Int);
    this.a.d = (this.a.e + ".ttmp");
    if (FileUtils.b(this.a.e))
    {
      TroopFileTransferUtil.Log.b("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] thumb had exsited");
      this.a.a(true);
      return;
    }
    if (!NetworkUtil.g(BaseApplication.getContext()))
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] no network");
      this.a.d(TroopTechReportUtils.TroopFileReportResultCode.k);
      return;
    }
    if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath))
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] filepath is null");
      this.a.d(TroopTechReportUtils.TroopFileReportResultCode.w);
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajmd
 * JD-Core Version:    0.7.0.1
 */