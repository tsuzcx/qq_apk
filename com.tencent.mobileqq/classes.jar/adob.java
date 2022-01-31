import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public class adob
  implements Runnable
{
  public adob(SimpleFileViewer paramSimpleFileViewer, String paramString) {}
  
  public void run()
  {
    SimpleFileViewer.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer).setText(FileManagerUtil.a(this.jdField_a_of_type_JavaLangString, false, SimpleFileViewer.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer).getMeasuredWidth(), SimpleFileViewer.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer).getPaint(), 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adob
 * JD-Core Version:    0.7.0.1
 */