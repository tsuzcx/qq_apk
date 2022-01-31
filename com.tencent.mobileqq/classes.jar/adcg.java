import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserManager.IModelCreater;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileViewerParamParser;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel;
import java.util.List;

public class adcg
  implements FileBrowserManager.IModelCreater
{
  public adcg(TroopFileViewerParamParser paramTroopFileViewerParamParser, BaseActivity paramBaseActivity) {}
  
  public FileBrowserModelBase a()
  {
    Object localObject2 = null;
    List localList = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerTroopFileViewerParamParser.a();
    Object localObject1 = localObject2;
    if (localList != null)
    {
      localObject1 = localObject2;
      if (localList.size() > 0) {
        localObject1 = new TroopFileModel(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localList, TroopFileViewerParamParser.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerTroopFileViewerParamParser));
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adcg
 * JD-Core Version:    0.7.0.1
 */