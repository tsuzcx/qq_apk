import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.TorchInfo;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;

public class afqv
  implements Runnable
{
  public afqv(OlympicManager paramOlympicManager, TorchInfo paramTorchInfo) {}
  
  public void run()
  {
    synchronized (OlympicManager.b(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager))
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
        localObjectOutputStream.writeObject(this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo);
        localObjectOutputStream.close();
        localByteArrayOutputStream.close();
        FileUtils.a(new File(BaseApplicationImpl.sApplication.getFilesDir(), "olympic_torchinfo_" + this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager.a.getAccount()).getAbsolutePath(), localByteArrayOutputStream.toByteArray(), false);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afqv
 * JD-Core Version:    0.7.0.1
 */