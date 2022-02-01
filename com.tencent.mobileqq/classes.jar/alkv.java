import com.tencent.qphone.base.util.BaseApplication;

public class alkv
{
  public static alkr a(int paramInt)
  {
    switch (paramInt)
    {
    case 15: 
    case 18: 
    case 19: 
    case 25: 
    case 26: 
    case 28: 
    default: 
      return null;
    case 17: 
      return new alln(BaseApplication.getContext());
    case 16: 
      return new allf(BaseApplication.getContext());
    case 10: 
      return new alla(BaseApplication.getContext());
    case 11: 
    case 29: 
      return new allh(BaseApplication.getContext(), false);
    case 24: 
      return new alkx(BaseApplication.getContext());
    case 13: 
      return new alkw(BaseApplication.getContext());
    case 5: 
      return new bmjx(BaseApplication.getContext());
    case 14: 
    case 27: 
      return new allk(BaseApplication.getContext());
    case 7: 
      return new alld(BaseApplication.getContext());
    case 22: 
      return new alll(BaseApplication.getContext());
    case 3: 
      return new allg(BaseApplication.getContext(), 1);
    case 2: 
      return new allg(BaseApplication.getContext(), 0);
    case 21: 
      return new alkz(BaseApplication.getContext());
    case 8: 
      return new alli(BaseApplication.getContext());
    case 4: 
      return new alle(BaseApplication.getContext());
    case 9: 
      return new allo(BaseApplication.getContext());
    case 12: 
      return new allj(BaseApplication.getContext());
    case 6: 
      return new allb(BaseApplication.getContext());
    case 20: 
      return new alks(BaseApplication.getContext(), "");
    }
    return new allm(BaseApplication.getContext());
  }
  
  public static Object a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    alkr localalkr = null;
    Object localObject1 = localalkr;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        localObject1 = localalkr;
      }
    }
    else {
      return localObject1;
    }
    switch (paramInt)
    {
    }
    for (localObject1 = localObject2;; localObject1 = new String(paramArrayOfByte))
    {
      localalkr = a(paramInt);
      if (localalkr == null) {
        break;
      }
      localalkr.a(paramArrayOfByte);
      return localalkr;
    }
  }
  
  public static byte[] a(int paramInt, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      switch (paramInt)
      {
      }
    } while (!(paramObject instanceof alkt));
    return ((alkt)paramObject).a();
    return ((String)paramObject).getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkv
 * JD-Core Version:    0.7.0.1
 */