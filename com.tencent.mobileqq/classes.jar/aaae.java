import java.util.concurrent.ConcurrentHashMap;

public class aaae
{
  private static ConcurrentHashMap<String, zzz> a = new ConcurrentHashMap();
  
  public static zzz a(zzy paramzzy)
  {
    zzz localzzz = (zzz)a.get(paramzzy.a());
    if (localzzz == null) {
      try
      {
        localzzz = new zzz(paramzzy);
        a.put(paramzzy.a(), localzzz);
        return localzzz;
      }
      finally {}
    }
    return localzzz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaae
 * JD-Core Version:    0.7.0.1
 */