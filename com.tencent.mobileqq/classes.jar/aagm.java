import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.qphone.base.util.QLog;

public class aagm
  implements Runnable
{
  public aagm(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable) {}
  
  public void run()
  {
    this.a.e = 0;
    QLog.i("ARWorldCupGlobalSceneRenderable", 1, "cleanWorldCupSparks. mInsertedSparkTotalCnt = 0, hasDrawedFrame = " + ARWorldCupGlobalSceneRenderable.c(this.a));
    if ((ARWorldCupGlobalSceneRenderable.a(this.a) != null) && (ARWorldCupGlobalSceneRenderable.c(this.a))) {
      ARWorldCupGlobalSceneRenderable.a(this.a).native_cleanWorldCupSparks();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aagm
 * JD-Core Version:    0.7.0.1
 */