package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;

public final class h
  extends d
{
  public h(i parami)
  {
    this.xqq = 2064;
    this.xqr = 3;
    this.xqt = parami;
  }
  
  public final int z(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    f localf = new f();
    g localg = new g();
    int i = super.Z(paramArrayOfByte, paramInt1 + 2);
    super.cUC();
    int j = paramInt1 + 5;
    switch (i)
    {
    case 3: 
    case 4: 
    default: 
      y(paramArrayOfByte, j, this.xqf - j - 1);
      return i;
    case 2: 
      paramInt2 = localf.B(paramArrayOfByte, j, this.xqf - j);
      paramInt1 = paramInt2;
      if (paramInt2 >= 0)
      {
        this.xqt.xqy = localf;
        paramInt2 = localg.B(paramArrayOfByte, j, this.xqf - j);
        paramInt1 = paramInt2;
        if (paramInt2 >= 0)
        {
          this.xqt.xqz = localg;
          return i;
        }
      }
      break;
    case 5: 
      super.y(paramArrayOfByte, j, this.xqf - j - 1);
      return i;
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.h
 * JD-Core Version:    0.7.0.1
 */