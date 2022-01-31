package com.tencent.mm.protocal.c;

public final class axl
  extends com.tencent.mm.bv.a
{
  public int hQR;
  public String kVl;
  public String nFs;
  public String ttR;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kVl != null) {
        paramVarArgs.d(1, this.kVl);
      }
      if (this.ttR != null) {
        paramVarArgs.d(2, this.ttR);
      }
      if (this.nFs != null) {
        paramVarArgs.d(3, this.nFs);
      }
      paramVarArgs.gB(4, this.hQR);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kVl == null) {
        break label324;
      }
    }
    label324:
    for (int i = d.a.a.b.b.a.e(1, this.kVl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ttR != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.ttR);
      }
      i = paramInt;
      if (this.nFs != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.nFs);
      }
      return i + d.a.a.a.gy(4, this.hQR);
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
        axl localaxl = (axl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaxl.kVl = locala.xpH.readString();
          return 0;
        case 2: 
          localaxl.ttR = locala.xpH.readString();
          return 0;
        case 3: 
          localaxl.nFs = locala.xpH.readString();
          return 0;
        }
        localaxl.hQR = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.axl
 * JD-Core Version:    0.7.0.1
 */