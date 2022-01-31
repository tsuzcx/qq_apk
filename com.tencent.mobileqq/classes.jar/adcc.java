import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserManager.IModelCreater;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerParamParser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.DatalineFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.DeviceFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.MPcFileModel;
import java.util.ArrayList;
import java.util.List;

public class adcc
  implements FileBrowserManager.IModelCreater
{
  public adcc(FileViewerParamParser paramFileViewerParamParser, BaseActivity paramBaseActivity) {}
  
  public FileBrowserModelBase a()
  {
    Object localObject3 = null;
    int i = 0;
    Object localObject1;
    switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerParamParser.a())
    {
    default: 
      localObject1 = null;
    }
    int k;
    for (;;)
    {
      Object localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject2 = localObject3;
        if (((List)localObject1).size() > 0)
        {
          localObject2 = (IFileViewerAdapter)((List)localObject1).get(i);
          int j = ((IFileViewerAdapter)localObject2).c();
          k = ((IFileViewerAdapter)localObject2).b();
          if (j != 7) {
            break;
          }
          localObject2 = new MPcFileModel(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
        }
      }
      return localObject2;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerParamParser.a();
      i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerParamParser.b();
      continue;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerParamParser.a();
      i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerParamParser.b();
      continue;
      localObject1 = new ArrayList(1);
      ((List)localObject1).add(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerParamParser.a());
    }
    switch (k)
    {
    default: 
      return new C2CFileModel(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
    case 6000: 
      return new DatalineFileModel(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
    }
    return new DeviceFileModel(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adcc
 * JD-Core Version:    0.7.0.1
 */