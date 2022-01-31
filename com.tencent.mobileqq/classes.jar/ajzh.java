import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class ajzh
  extends WeakReference
{
  private final String a;
  
  public ajzh(String paramString, Object paramObject, ReferenceQueue paramReferenceQueue)
  {
    super(paramObject, paramReferenceQueue);
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajzh
 * JD-Core Version:    0.7.0.1
 */