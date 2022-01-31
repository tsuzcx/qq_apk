import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.qphone.base.util.QLog;

public class aagn
  implements Runnable
{
  public aagn(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable) {}
  
  public void run()
  {
    QLog.i("ARWorldCupGlobalSceneRenderable", 1, "zoomOutWorldCupSparks. hasDrawedFrame = " + ARWorldCupGlobalSceneRenderable.c(this.a));
    if ((ARWorldCupGlobalSceneRenderable.a(this.a) != null) && (ARWorldCupGlobalSceneRenderable.c(this.a))) {
      ARWorldCupGlobalSceneRenderable.a(this.a).native_zoomOutWorldCupSparks();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aagn
 * JD-Core Version:    0.7.0.1
 */