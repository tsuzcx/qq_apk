import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.qphone.base.util.QLog;

public class aaaa
  implements Runnable
{
  public aaaa(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable) {}
  
  public void run()
  {
    QLog.i("ARWorldCupGlobalSceneRenderable", 1, "zoomOutWorldCupSparks.");
    if (ARWorldCupGlobalSceneRenderable.a(this.a) != null) {
      ARWorldCupGlobalSceneRenderable.a(this.a).native_hiddenBigScreen();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaaa
 * JD-Core Version:    0.7.0.1
 */