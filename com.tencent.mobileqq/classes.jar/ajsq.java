import java.lang.ref.WeakReference;

public class ajsq
{
  private static WeakReference<ajss> a;
  private static WeakReference<ajsr> b;
  
  public static void a()
  {
    if (b != null) {}
    for (ajsr localajsr = (ajsr)b.get();; localajsr = null)
    {
      if (localajsr != null) {
        localajsr.i();
      }
      return;
    }
  }
  
  public static void a(int paramInt)
  {
    if (b != null) {}
    for (ajsr localajsr = (ajsr)b.get();; localajsr = null)
    {
      if (localajsr != null) {
        localajsr.b(paramInt);
      }
      return;
    }
  }
  
  public static void a(ajsr paramajsr)
  {
    b = new WeakReference(paramajsr);
  }
  
  public static void a(ajss paramajss)
  {
    a = new WeakReference(paramajss);
  }
  
  public static void a(String paramString)
  {
    if (b != null) {}
    for (ajsr localajsr = (ajsr)b.get();; localajsr = null)
    {
      if (localajsr != null) {
        localajsr.c(paramString);
      }
      return;
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (a != null) {}
    for (ajss localajss = (ajss)a.get();; localajss = null)
    {
      if (localajss != null) {
        localajss.a(paramString, paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsq
 * JD-Core Version:    0.7.0.1
 */