import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IThumbController;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.ImageFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.PictureFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.PictureFileViewer;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import java.util.List;

public class adel
  implements AdapterView.OnItemSelectedListener
{
  public adel(PictureFilePresenter paramPictureFilePresenter) {}
  
  public void a(AdapterView paramAdapterView) {}
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    PictureFilePresenter.a(this.a, paramInt);
    this.a.a(paramInt);
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.a(paramInt);
    }
    paramAdapterView = (FileBrowserModelBase.ImageFileInfo)PictureFilePresenter.a(this.a).get(paramInt);
    if (paramAdapterView == null)
    {
      FMToastUtil.b(BaseApplicationImpl.getContext().getString(2131428256));
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a().a(paramAdapterView);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(paramInt, paramAdapterView);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.c();
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.d();
    }
    if (this.a.b)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.a(true);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.a(false);
      PictureFilePresenter.a(this.a, true);
    }
    this.a.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adel
 * JD-Core Version:    0.7.0.1
 */