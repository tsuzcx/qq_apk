import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool.GetChoiceListCallback;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class akea
  extends DownloadListener
{
  public akea(GroupCatalogTool paramGroupCatalogTool, File paramFile, String paramString, GroupCatalogTool.GetChoiceListCallback paramGetChoiceListCallback) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if ((paramDownloadTask.a == 0) && (this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogTool.b(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString) != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogTool.a(BaseApplicationImpl.getContext())))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogTool.a(BaseApplicationImpl.getContext(), System.currentTimeMillis());
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogTool$GetChoiceListCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogTool$GetChoiceListCallback.a(true);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogTool$GetChoiceListCallback != null))
      {
        QLog.e("GroupCatalogTool", 1, "getChoiceListFromServer failed!");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogTool$GetChoiceListCallback.a(false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akea
 * JD-Core Version:    0.7.0.1
 */