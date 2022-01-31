import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;

public class aagd
  implements Runnable
{
  public aagd(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable) {}
  
  public void run()
  {
    if ((ARWorldCupGlobalSceneRenderable.a(this.a) != null) && (this.a.b <= 4)) {
      ARWorldCupGlobalSceneRenderable.a(this.a).native_startTranversalAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aagd
 * JD-Core Version:    0.7.0.1
 */