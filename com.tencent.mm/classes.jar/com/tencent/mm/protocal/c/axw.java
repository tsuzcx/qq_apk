package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class axw
  extends com.tencent.mm.bv.a
{
  public int sDZ;
  public String sLD;
  public String sLE;
  public int tub;
  public b tuc;
  public String tud;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sDZ);
      paramVarArgs.gB(2, this.tub);
      if (this.tuc != null) {
        paramVarArgs.b(3, this.tuc);
      }
      if (this.tud != null) {
        paramVarArgs.d(4, this.tud);
      }
      if (this.sLD != null) {
        paramVarArgs.d(5, this.sLD);
      }
      if (this.sLE != null) {
        paramVarArgs.d(6, this.sLE);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.sDZ) + 0 + d.a.a.a.gy(2, this.tub);
      paramInt = i;
      if (this.tuc != null) {
        paramInt = i + d.a.a.a.a(3, this.tuc);
      }
      i = paramInt;
      if (this.tud != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.tud);
      }
      paramInt = i;
      if (this.sLD != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sLD);
      }
      i = paramInt;
    } while (this.sLE == null);
    return paramInt + d.a.a.b.b.a.e(6, this.sLE);
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
      axw localaxw = (axw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localaxw.sDZ = locala.xpH.oD();
        return 0;
      case 2: 
        localaxw.tub = locala.xpH.oD();
        return 0;
      case 3: 
        localaxw.tuc = locala.cUs();
        return 0;
      case 4: 
        localaxw.tud = locala.xpH.readString();
        return 0;
      case 5: 
        localaxw.sLD = locala.xpH.readString();
        return 0;
      }
      localaxw.sLE = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.axw
 * JD-Core Version:    0.7.0.1
 */