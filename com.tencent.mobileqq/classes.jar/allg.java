import java.lang.ref.WeakReference;

public class allg
{
  private static WeakReference<alli> a;
  private static WeakReference<allh> b;
  
  public static void a()
  {
    if (b != null) {}
    for (allh localallh = (allh)b.get();; localallh = null)
    {
      if (localallh != null) {
        localallh.i();
      }
      return;
    }
  }
  
  public static void a(int paramInt)
  {
    if (b != null) {}
    for (allh localallh = (allh)b.get();; localallh = null)
    {
      if (localallh != null) {
        localallh.b(paramInt);
      }
      return;
    }
  }
  
  public static void a(allh paramallh)
  {
    b = new WeakReference(paramallh);
  }
  
  public static void a(alli paramalli)
  {
    a = new WeakReference(paramalli);
  }
  
  public static void a(String paramString)
  {
    if (b != null) {}
    for (allh localallh = (allh)b.get();; localallh = null)
    {
      if (localallh != null) {
        localallh.c(paramString);
      }
      return;
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (a != null) {}
    for (alli localalli = (alli)a.get();; localalli = null)
    {
      if (localalli != null) {
        localalli.a(paramString, paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allg
 * JD-Core Version:    0.7.0.1
 */