import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import java.lang.ref.WeakReference;

public class akpp
  extends WeakReference
  implements VasManager.CompleteListener
{
  public akpp(VasManager.CompleteListener paramCompleteListener)
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
 * Qualified Name:     akpp
 * JD-Core Version:    0.7.0.1
 */