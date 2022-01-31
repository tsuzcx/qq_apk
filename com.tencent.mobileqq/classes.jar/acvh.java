import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.widget.FileWebView.TitilebarEventInterface;

public class acvh
  implements FileWebView.TitilebarEventInterface
{
  public acvh(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void a() {}
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    if ((this.a.jdField_a_of_type_Boolean) || (this.a.f)) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.l = "3";
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.e = System.currentTimeMillis();
    }
    this.a.runOnUiThread(new acvi(this));
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acvh
 * JD-Core Version:    0.7.0.1
 */