import java.lang.ref.WeakReference;

public class alwy
{
  private static WeakReference<alxa> a;
  private static WeakReference<alwz> b;
  
  public static void a()
  {
    if (b != null) {}
    for (alwz localalwz = (alwz)b.get();; localalwz = null)
    {
      if (localalwz != null) {
        localalwz.i();
      }
      return;
    }
  }
  
  public static void a(int paramInt)
  {
    if (b != null) {}
    for (alwz localalwz = (alwz)b.get();; localalwz = null)
    {
      if (localalwz != null) {
        localalwz.b(paramInt);
      }
      return;
    }
  }
  
  public static void a(alwz paramalwz)
  {
    b = new WeakReference(paramalwz);
  }
  
  public static void a(alxa paramalxa)
  {
    a = new WeakReference(paramalxa);
  }
  
  public static void a(String paramString)
  {
    if (b != null) {}
    for (alwz localalwz = (alwz)b.get();; localalwz = null)
    {
      if (localalwz != null) {
        localalwz.c(paramString);
      }
      return;
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (a != null) {}
    for (alxa localalxa = (alxa)a.get();; localalxa = null)
    {
      if (localalxa != null) {
        localalxa.a(paramString, paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alwy
 * JD-Core Version:    0.7.0.1
 */