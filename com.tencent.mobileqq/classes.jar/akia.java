import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import java.lang.ref.WeakReference;

public class akia
  extends WeakReference
  implements VasManager.CompleteListener
{
  public akia(VasManager.CompleteListener paramCompleteListener)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akia
 * JD-Core Version:    0.7.0.1
 */