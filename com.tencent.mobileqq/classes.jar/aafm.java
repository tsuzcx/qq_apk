import com.tencent.mobileqq.ar.arengine.ARCloudControl;
import com.tencent.mobileqq.ar.arengine.ARCloudControl.ARCloudControlCallback;
import com.tencent.qphone.base.util.QLog;

public class aafm
  implements Runnable
{
  public aafm(ARCloudControl paramARCloudControl) {}
  
  public void run()
  {
    if ((ARCloudControl.a(this.a) != null) && (ARCloudControl.e(this.a)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
      if (!ARCloudControl.a(this.a)) {}
    }
    else
    {
      return;
    }
    ARCloudControl.a(this.a, true);
    ARCloudControl.a(this.a).a(1, null);
    ARCloudControl.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aafm
 * JD-Core Version:    0.7.0.1
 */