import com.tencent.mobileqq.filemanager.core.FileUploader;

public class addz
  implements Runnable
{
  public addz(FileUploader paramFileUploader) {}
  
  public void run()
  {
    if (FileUploader.a(this.a)) {
      return;
    }
    this.a.a(FileUploader.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     addz
 * JD-Core Version:    0.7.0.1
 */