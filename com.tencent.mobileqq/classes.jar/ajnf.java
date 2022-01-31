import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploader;

public class ajnf
  implements Runnable
{
  public ajnf(TroopFileUploader paramTroopFileUploader) {}
  
  public void run()
  {
    if ((TroopFileUploader.a(this.a) != null) && (this.a.a != null)) {
      this.a.a();
    }
    this.a.a(true, TroopFileUploader.a(this.a), 9303, "readfilefail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnf
 * JD-Core Version:    0.7.0.1
 */