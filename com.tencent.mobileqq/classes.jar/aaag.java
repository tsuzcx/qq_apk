import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.mobileqq.arcard.ARcardSound;

public class aaag
  implements Runnable
{
  public aaag(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable) {}
  
  public void run()
  {
    if (ARWorldCupGlobalSceneRenderable.a(this.a) != null)
    {
      ARWorldCupGlobalSceneRenderable.a(this.a).a();
      ARWorldCupGlobalSceneRenderable.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaag
 * JD-Core Version:    0.7.0.1
 */