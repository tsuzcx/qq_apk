import java.lang.ref.WeakReference;

public class ahkb
{
  private static WeakReference<ahkd> a;
  private static WeakReference<ahkc> b;
  
  public static void a()
  {
    if (b != null) {}
    for (ahkc localahkc = (ahkc)b.get();; localahkc = null)
    {
      if (localahkc != null) {
        localahkc.j();
      }
      return;
    }
  }
  
  public static void a(int paramInt)
  {
    if (b != null) {}
    for (ahkc localahkc = (ahkc)b.get();; localahkc = null)
    {
      if (localahkc != null) {
        localahkc.b(paramInt);
      }
      return;
    }
  }
  
  public static void a(ahkc paramahkc)
  {
    b = new WeakReference(paramahkc);
  }
  
  public static void a(ahkd paramahkd)
  {
    a = new WeakReference(paramahkd);
  }
  
  public static void a(String paramString)
  {
    if (b != null) {}
    for (ahkc localahkc = (ahkc)b.get();; localahkc = null)
    {
      if (localahkc != null) {
        localahkc.c(paramString);
      }
      return;
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (a != null) {}
    for (ahkd localahkd = (ahkd)a.get();; localahkd = null)
    {
      if (localahkd != null) {
        localahkd.a(paramString, paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahkb
 * JD-Core Version:    0.7.0.1
 */