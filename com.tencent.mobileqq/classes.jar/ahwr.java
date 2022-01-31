import java.lang.ref.WeakReference;

public class ahwr
{
  private static WeakReference<ahwt> a;
  private static WeakReference<ahws> b;
  
  public static void a()
  {
    if (b != null) {}
    for (ahws localahws = (ahws)b.get();; localahws = null)
    {
      if (localahws != null) {
        localahws.j();
      }
      return;
    }
  }
  
  public static void a(int paramInt)
  {
    if (b != null) {}
    for (ahws localahws = (ahws)b.get();; localahws = null)
    {
      if (localahws != null) {
        localahws.b(paramInt);
      }
      return;
    }
  }
  
  public static void a(ahws paramahws)
  {
    b = new WeakReference(paramahws);
  }
  
  public static void a(ahwt paramahwt)
  {
    a = new WeakReference(paramahwt);
  }
  
  public static void a(String paramString)
  {
    if (b != null) {}
    for (ahws localahws = (ahws)b.get();; localahws = null)
    {
      if (localahws != null) {
        localahws.c(paramString);
      }
      return;
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (a != null) {}
    for (ahwt localahwt = (ahwt)a.get();; localahwt = null)
    {
      if (localahwt != null) {
        localahwt.a(paramString, paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahwr
 * JD-Core Version:    0.7.0.1
 */