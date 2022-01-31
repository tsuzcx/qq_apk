import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;

public class acrf
  implements Runnable
{
  public acrf(FileBrowserActivity paramFileBrowserActivity, String paramString) {}
  
  public void run()
  {
    int i = FileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity).getMeasuredWidth();
    String str2 = (String)TextUtils.ellipsize(this.jdField_a_of_type_JavaLangString, FileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity).getPaint(), i - 15, TextUtils.TruncateAt.END);
    String str1 = str2;
    if (str2.length() > 2)
    {
      str1 = str2;
      if (str2.substring(str2.length() - 1).equals(FileBrowserActivity.a())) {
        str1 = str2.substring(0, str2.length() - 1) + FileBrowserActivity.b();
      }
    }
    FileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity).setText(str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acrf
 * JD-Core Version:    0.7.0.1
 */