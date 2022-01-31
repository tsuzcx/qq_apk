package com.tencent.mm.protocal.c;

public final class xr
  extends com.tencent.mm.bv.a
{
  public String hPY;
  public int hQq;
  public String hRf;
  public String sRZ;
  public String sUr;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPY != null) {
        paramVarArgs.d(1, this.hPY);
      }
      if (this.sUr != null) {
        paramVarArgs.d(2, this.sUr);
      }
      if (this.hRf != null) {
        paramVarArgs.d(3, this.hRf);
      }
      if (this.sRZ != null) {
        paramVarArgs.d(4, this.sRZ);
      }
      paramVarArgs.gB(5, this.hQq);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hPY == null) {
        break label379;
      }
    }
    label379:
    for (int i = d.a.a.b.b.a.e(1, this.hPY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sUr != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sUr);
      }
      i = paramInt;
      if (this.hRf != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.hRf);
      }
      paramInt = i;
      if (this.sRZ != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sRZ);
      }
      return paramInt + d.a.a.a.gy(5, this.hQq);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        xr localxr = (xr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localxr.hPY = locala.xpH.readString();
          return 0;
        case 2: 
          localxr.sUr = locala.xpH.readString();
          return 0;
        case 3: 
          localxr.hRf = locala.xpH.readString();
          return 0;
        case 4: 
          localxr.sRZ = locala.xpH.readString();
          return 0;
        }
        localxr.hQq = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.xr
 * JD-Core Version:    0.7.0.1
 */