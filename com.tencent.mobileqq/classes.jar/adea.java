import com.tencent.mobileqq.filemanager.core.FileUploader;
import com.tencent.mobileqq.filemanager.core.FileUploader.IFileUploaderSink;

public class adea
  implements Runnable
{
  public adea(FileUploader paramFileUploader) {}
  
  public void run()
  {
    if (FileUploader.a(this.a)) {
      return;
    }
    if (FileUploader.a(this.a) != null) {
      FileUploader.a(this.a).i();
    }
    FileUploader.a(this.a, 0L);
    this.a.a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adea
 * JD-Core Version:    0.7.0.1
 */