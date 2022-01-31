import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class akgv
  extends WeakReference
{
  private final String a;
  
  public akgv(String paramString, Object paramObject, ReferenceQueue paramReferenceQueue)
  {
    super(paramObject, paramReferenceQueue);
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akgv
 * JD-Core Version:    0.7.0.1
 */