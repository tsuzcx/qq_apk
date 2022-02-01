import com.tencent.qphone.base.util.BaseApplication;

public class aknw
{
  public static akns a(int paramInt)
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
      return new akoo(BaseApplication.getContext());
    case 16: 
      return new akog(BaseApplication.getContext());
    case 10: 
      return new akob(BaseApplication.getContext());
    case 11: 
    case 29: 
      return new akoi(BaseApplication.getContext(), false);
    case 24: 
      return new akny(BaseApplication.getContext());
    case 13: 
      return new aknx(BaseApplication.getContext());
    case 5: 
      return new bkyo(BaseApplication.getContext());
    case 14: 
    case 27: 
      return new akol(BaseApplication.getContext());
    case 7: 
      return new akoe(BaseApplication.getContext());
    case 22: 
      return new akom(BaseApplication.getContext());
    case 3: 
      return new akoh(BaseApplication.getContext(), 1);
    case 2: 
      return new akoh(BaseApplication.getContext(), 0);
    case 21: 
      return new akoa(BaseApplication.getContext());
    case 8: 
      return new akoj(BaseApplication.getContext());
    case 4: 
      return new akof(BaseApplication.getContext());
    case 9: 
      return new akop(BaseApplication.getContext());
    case 12: 
      return new akok(BaseApplication.getContext());
    case 6: 
      return new akoc(BaseApplication.getContext());
    case 20: 
      return new aknt(BaseApplication.getContext(), "");
    }
    return new akon(BaseApplication.getContext());
  }
  
  public static Object a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    akns localakns = null;
    Object localObject1 = localakns;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        localObject1 = localakns;
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
      localakns = a(paramInt);
      if (localakns == null) {
        break;
      }
      localakns.a(paramArrayOfByte);
      return localakns;
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
    } while (!(paramObject instanceof aknu));
    return ((aknu)paramObject).a();
    return ((String)paramObject).getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aknw
 * JD-Core Version:    0.7.0.1
 */