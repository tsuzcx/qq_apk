import com.tencent.qphone.base.util.BaseApplication;

public class alqf
{
  public static alqb a(int paramInt)
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
      return new alqx(BaseApplication.getContext());
    case 16: 
      return new alqp(BaseApplication.getContext());
    case 10: 
      return new alqk(BaseApplication.getContext());
    case 11: 
    case 29: 
      return new alqr(BaseApplication.getContext(), false);
    case 24: 
      return new alqh(BaseApplication.getContext());
    case 13: 
      return new alqg(BaseApplication.getContext());
    case 5: 
      return new bnth(BaseApplication.getContext());
    case 14: 
    case 27: 
      return new alqu(BaseApplication.getContext());
    case 7: 
      return new alqn(BaseApplication.getContext());
    case 22: 
      return new alqv(BaseApplication.getContext());
    case 3: 
      return new alqq(BaseApplication.getContext(), 1);
    case 2: 
      return new alqq(BaseApplication.getContext(), 0);
    case 21: 
      return new alqj(BaseApplication.getContext());
    case 8: 
      return new alqs(BaseApplication.getContext());
    case 4: 
      return new alqo(BaseApplication.getContext());
    case 9: 
      return new alqy(BaseApplication.getContext());
    case 12: 
      return new alqt(BaseApplication.getContext());
    case 6: 
      return new alql(BaseApplication.getContext());
    case 20: 
      return new alqc(BaseApplication.getContext(), "");
    }
    return new alqw(BaseApplication.getContext());
  }
  
  public static Object a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    alqb localalqb = null;
    Object localObject1 = localalqb;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        localObject1 = localalqb;
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
      localalqb = a(paramInt);
      if (localalqb == null) {
        break;
      }
      localalqb.a(paramArrayOfByte);
      return localalqb;
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
    } while (!(paramObject instanceof alqd));
    return ((alqd)paramObject).a();
    return ((String)paramObject).getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alqf
 * JD-Core Version:    0.7.0.1
 */