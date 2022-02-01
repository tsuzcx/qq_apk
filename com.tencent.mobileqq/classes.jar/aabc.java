import java.lang.ref.WeakReference;

public class aabc
  implements aadm
{
  private WeakReference<aabb> a;
  
  aabc(aabb paramaabb)
  {
    this.a = new WeakReference(paramaabb);
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    if (this.a != null)
    {
      aabb localaabb = (aabb)this.a.get();
      if (localaabb != null) {
        localaabb.a(paramArrayOfObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aabc
 * JD-Core Version:    0.7.0.1
 */