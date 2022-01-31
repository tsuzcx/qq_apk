import java.lang.ref.WeakReference;

public class ahwt
{
  private static WeakReference<ahwv> a;
  private static WeakReference<ahwu> b;
  
  public static void a()
  {
    if (b != null) {}
    for (ahwu localahwu = (ahwu)b.get();; localahwu = null)
    {
      if (localahwu != null) {
        localahwu.j();
      }
      return;
    }
  }
  
  public static void a(int paramInt)
  {
    if (b != null) {}
    for (ahwu localahwu = (ahwu)b.get();; localahwu = null)
    {
      if (localahwu != null) {
        localahwu.b(paramInt);
      }
      return;
    }
  }
  
  public static void a(ahwu paramahwu)
  {
    b = new WeakReference(paramahwu);
  }
  
  public static void a(ahwv paramahwv)
  {
    a = new WeakReference(paramahwv);
  }
  
  public static void a(String paramString)
  {
    if (b != null) {}
    for (ahwu localahwu = (ahwu)b.get();; localahwu = null)
    {
      if (localahwu != null) {
        localahwu.c(paramString);
      }
      return;
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (a != null) {}
    for (ahwv localahwv = (ahwv)a.get();; localahwv = null)
    {
      if (localahwv != null) {
        localahwv.a(paramString, paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahwt
 * JD-Core Version:    0.7.0.1
 */