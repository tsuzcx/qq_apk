import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IThumbController;
import com.tencent.mobileqq.filemanager.fileviewer.data.DefaultImageInfo;
import com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.ImageFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnThumbEventListener;

public class adlc
  implements IThumbController
{
  public adlc(DefaultFileModel paramDefaultFileModel) {}
  
  public void a(FileBrowserModelBase.ImageFileInfo paramImageFileInfo)
  {
    IFileViewerAdapter localIFileViewerAdapter = ((DefaultImageInfo)paramImageFileInfo).a();
    if (localIFileViewerAdapter != null)
    {
      if (1 != localIFileViewerAdapter.c()) {
        break label147;
      }
      if (!localIFileViewerAdapter.a().isZipInnerFile) {
        break label91;
      }
      paramImageFileInfo = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localIFileViewerAdapter.a());
      if ((paramImageFileInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener.a(String.valueOf(localIFileViewerAdapter.a()), paramImageFileInfo);
      }
    }
    label91:
    while (2 != localIFileViewerAdapter.c())
    {
      do
      {
        return;
        paramImageFileInfo = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localIFileViewerAdapter.a(), 7);
      } while ((paramImageFileInfo == null) || (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener == null));
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener.a(localIFileViewerAdapter.c(), paramImageFileInfo);
      return;
    }
    label147:
    FileManagerEngine localFileManagerEngine = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str = localIFileViewerAdapter.e();
    if (localIFileViewerAdapter.a() == null) {}
    for (paramImageFileInfo = null;; paramImageFileInfo = localIFileViewerAdapter.a().e)
    {
      paramImageFileInfo = localFileManagerEngine.a(str, paramImageFileInfo, 7, localIFileViewerAdapter);
      if ((paramImageFileInfo == null) || (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener == null)) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener.a(localIFileViewerAdapter.e(), paramImageFileInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adlc
 * JD-Core Version:    0.7.0.1
 */