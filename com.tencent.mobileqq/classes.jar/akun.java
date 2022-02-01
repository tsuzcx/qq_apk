import java.lang.ref.WeakReference;

public class akun
{
  private static WeakReference<akup> a;
  private static WeakReference<akuo> b;
  
  public static void a()
  {
    if (b != null) {}
    for (akuo localakuo = (akuo)b.get();; localakuo = null)
    {
      if (localakuo != null) {
        localakuo.d();
      }
      return;
    }
  }
  
  public static void a(int paramInt)
  {
    if (b != null) {}
    for (akuo localakuo = (akuo)b.get();; localakuo = null)
    {
      if (localakuo != null) {
        localakuo.b(paramInt);
      }
      return;
    }
  }
  
  public static void a(akuo paramakuo)
  {
    b = new WeakReference(paramakuo);
  }
  
  public static void a(akup paramakup)
  {
    a = new WeakReference(paramakup);
  }
  
  public static void a(String paramString)
  {
    if (b != null) {}
    for (akuo localakuo = (akuo)b.get();; localakuo = null)
    {
      if (localakuo != null) {
        localakuo.b(paramString);
      }
      return;
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (a != null) {}
    for (akup localakup = (akup)a.get();; localakup = null)
    {
      if (localakup != null) {
        localakup.a(paramString, paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akun
 * JD-Core Version:    0.7.0.1
 */