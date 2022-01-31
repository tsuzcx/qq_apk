import java.lang.ref.WeakReference;

public class ajob
{
  private static WeakReference<ajod> a;
  private static WeakReference<ajoc> b;
  
  public static void a()
  {
    if (b != null) {}
    for (ajoc localajoc = (ajoc)b.get();; localajoc = null)
    {
      if (localajoc != null) {
        localajoc.i();
      }
      return;
    }
  }
  
  public static void a(int paramInt)
  {
    if (b != null) {}
    for (ajoc localajoc = (ajoc)b.get();; localajoc = null)
    {
      if (localajoc != null) {
        localajoc.b(paramInt);
      }
      return;
    }
  }
  
  public static void a(ajoc paramajoc)
  {
    b = new WeakReference(paramajoc);
  }
  
  public static void a(ajod paramajod)
  {
    a = new WeakReference(paramajod);
  }
  
  public static void a(String paramString)
  {
    if (b != null) {}
    for (ajoc localajoc = (ajoc)b.get();; localajoc = null)
    {
      if (localajoc != null) {
        localajoc.c(paramString);
      }
      return;
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (a != null) {}
    for (ajod localajod = (ajod)a.get();; localajod = null)
    {
      if (localajod != null) {
        localajod.a(paramString, paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajob
 * JD-Core Version:    0.7.0.1
 */