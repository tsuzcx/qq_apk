import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import java.lang.ref.WeakReference;

public class ajtt
  extends WeakReference
  implements VasManager.CompleteListener
{
  public ajtt(VasManager.CompleteListener paramCompleteListener)
  {
    super(paramCompleteListener);
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    VasManager.CompleteListener localCompleteListener = (VasManager.CompleteListener)get();
    if (localCompleteListener != null) {
      localCompleteListener.a(paramObject1, paramObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajtt
 * JD-Core Version:    0.7.0.1
 */