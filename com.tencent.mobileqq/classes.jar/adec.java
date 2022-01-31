import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public class adec
  implements View.OnClickListener
{
  public adec(FileBrowserPresenterBase paramFileBrowserPresenterBase) {}
  
  public void onClick(View paramView)
  {
    FileManagerUtil.b(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b());
    this.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adec
 * JD-Core Version:    0.7.0.1
 */