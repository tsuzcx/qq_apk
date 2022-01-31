import com.tencent.mobileqq.ar.arengine.ARCloudControl;
import com.tencent.mobileqq.ar.arengine.ARCloudControl.ARCloudControlCallback;
import com.tencent.qphone.base.util.QLog;

public class aalz
  implements Runnable
{
  public aalz(ARCloudControl paramARCloudControl) {}
  
  public void run()
  {
    if ((ARCloudControl.a(this.a) != null) && (ARCloudControl.b(this.a)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "onARCloudUploadImgComplete .isTimeOut= ");
      if (!ARCloudControl.a(this.a)) {}
    }
    else
    {
      return;
    }
    ARCloudControl.a(this.a, true);
    ARCloudControl.a(this.a).a(1, null);
    this.a.b = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aalz
 * JD-Core Version:    0.7.0.1
 */