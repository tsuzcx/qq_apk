import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable;
import com.tencent.mobileqq.widget.QQToast;

public class aaib
  implements Runnable
{
  public aaib(MultiFragmentAnimRenderable paramMultiFragmentAnimRenderable) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, "目前多段动画只支持普通视频、透明视频、边下边播！", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaib
 * JD-Core Version:    0.7.0.1
 */