package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class cen
  extends com.tencent.mm.bv.a
{
  public long sSU;
  public int tTA;
  public int tTB;
  public b tTC;
  public long tTo;
  public int tTy;
  public int tTz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.Y(1, this.tTo);
      paramVarArgs.Y(2, this.sSU);
      paramVarArgs.gB(3, this.tTy);
      paramVarArgs.gB(4, this.tTz);
      paramVarArgs.gB(5, this.tTA);
      paramVarArgs.gB(6, this.tTB);
      if (this.tTC != null) {
        paramVarArgs.b(7, this.tTC);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.X(1, this.tTo) + 0 + d.a.a.a.X(2, this.sSU) + d.a.a.a.gy(3, this.tTy) + d.a.a.a.gy(4, this.tTz) + d.a.a.a.gy(5, this.tTA) + d.a.a.a.gy(6, this.tTB);
      paramInt = i;
    } while (this.tTC == null);
    return i + d.a.a.a.a(7, this.tTC);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      cen localcen = (cen)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcen.tTo = locala.xpH.oE();
        return 0;
      case 2: 
        localcen.sSU = locala.xpH.oE();
        return 0;
      case 3: 
        localcen.tTy = locala.xpH.oD();
        return 0;
      case 4: 
        localcen.tTz = locala.xpH.oD();
        return 0;
      case 5: 
        localcen.tTA = locala.xpH.oD();
        return 0;
      case 6: 
        localcen.tTB = locala.xpH.oD();
        return 0;
      }
      localcen.tTC = locala.cUs();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cen
 * JD-Core Version:    0.7.0.1
 */