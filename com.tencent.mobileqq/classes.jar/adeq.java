import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public class adeq
  implements View.OnClickListener
{
  public adeq(SimpleFilePresenter paramSimpleFilePresenter) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368827: 
      paramView = FMConfig.b();
      FileManagerUtil.a(this.a.jdField_a_of_type_AndroidAppActivity, paramView);
      FileManagerReporter.a("0X8008469");
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adeq
 * JD-Core Version:    0.7.0.1
 */