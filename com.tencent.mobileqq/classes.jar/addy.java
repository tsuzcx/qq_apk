import com.tencent.mobileqq.filemanager.core.FileUploader;
import com.tencent.mobileqq.filemanager.core.FileUploader.IFileUploaderSink;

public class addy
  implements Runnable
{
  public addy(FileUploader paramFileUploader) {}
  
  public void run()
  {
    if ((FileUploader.a(this.a) != null) && (FileUploader.a(this.a) != null)) {
      this.a.a();
    }
    FileUploader.a(this.a).a(true, FileUploader.a(this.a), 9303, "readfilefail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     addy
 * JD-Core Version:    0.7.0.1
 */