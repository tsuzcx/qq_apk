import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class ajif
{
  private Map<Integer, ajhx> a = new ConcurrentHashMap();
  
  public static ajif a()
  {
    return ajig.a();
  }
  
  private ajhx b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 91: 
      return new ajhv();
    }
    return new ajhz();
  }
  
  public ajhx a(int paramInt)
  {
    Object localObject = (ajhx)this.a.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      try
      {
        ajhx localajhx2 = (ajhx)this.a.get(Integer.valueOf(paramInt));
        localObject = localajhx2;
        if (localajhx2 == null)
        {
          localajhx2 = b(paramInt);
          localObject = localajhx2;
          if (localajhx2 != null)
          {
            this.a.put(Integer.valueOf(paramInt), localajhx2);
            localObject = localajhx2;
          }
        }
        return localObject;
      }
      finally {}
    }
    return localajhx1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajif
 * JD-Core Version:    0.7.0.1
 */