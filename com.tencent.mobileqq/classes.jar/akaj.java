import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class akaj
  implements Runnable
{
  public akaj(String paramString) {}
  
  public void run()
  {
    File localFile = new File(this.a);
    if ((localFile.exists()) && (localFile.isFile()))
    {
      boolean bool = localFile.delete();
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.VoiceIntro", 2, "delete result=" + bool + " f.path=" + this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akaj
 * JD-Core Version:    0.7.0.1
 */