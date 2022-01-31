import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.MusicFileViewer;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public class adft
  implements Runnable
{
  public adft(MusicFileViewer paramMusicFileViewer, String paramString) {}
  
  public void run()
  {
    MusicFileViewer.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer).setText(FileManagerUtil.a(this.jdField_a_of_type_JavaLangString, false, MusicFileViewer.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer).getMeasuredWidth(), MusicFileViewer.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer).getPaint(), 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adft
 * JD-Core Version:    0.7.0.1
 */