import com.tencent.mobileqq.ar.ARRenderModel.ARBaseRender;
import com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable;
import java.util.concurrent.locks.ReentrantLock;

public class aabo
  implements Runnable
{
  public aabo(MultiFragmentAnimRenderable paramMultiFragmentAnimRenderable) {}
  
  public void run()
  {
    MultiFragmentAnimRenderable.a(this.a).lock();
    if (MultiFragmentAnimRenderable.a(this.a) != null)
    {
      MultiFragmentAnimRenderable.a(this.a).d();
      MultiFragmentAnimRenderable.a(this.a, null);
    }
    MultiFragmentAnimRenderable.a(this.a).unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aabo
 * JD-Core Version:    0.7.0.1
 */