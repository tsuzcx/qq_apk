import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.confess.ConfessPlugin;
import com.tencent.qphone.base.util.QLog;

public class ablb
  implements Runnable
{
  public ablb(ConfessPlugin paramConfessPlugin, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      QRUtils.a(this.jdField_a_of_type_Int, this.b);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("ConfessPlugin", 1, "showQQToast error: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ablb
 * JD-Core Version:    0.7.0.1
 */