import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable;

public class aabp
  implements Runnable
{
  public aabp(MultiFragmentAnimRenderable paramMultiFragmentAnimRenderable) {}
  
  public void run()
  {
    this.a.d();
    if (MultiFragmentAnimRenderable.a(this.a) != null) {
      MultiFragmentAnimRenderable.a(this.a).a(1, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aabp
 * JD-Core Version:    0.7.0.1
 */