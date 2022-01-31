import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploader;

public class ajng
  implements Runnable
{
  public ajng(TroopFileUploader paramTroopFileUploader) {}
  
  public void run()
  {
    if (TroopFileUploader.a(this.a)) {
      return;
    }
    TroopFileUploader.a(this.a, TroopFileUploader.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajng
 * JD-Core Version:    0.7.0.1
 */