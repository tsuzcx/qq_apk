package com.tencent.mm.protocal.c;

public final class bws
  extends com.tencent.mm.bv.a
{
  public String tMY;
  public int tMZ;
  public int tNa;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tMY != null) {
        paramVarArgs.d(1, this.tMY);
      }
      paramVarArgs.gB(2, this.tMZ);
      paramVarArgs.gB(3, this.tNa);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tMY == null) {
        break label246;
      }
    }
    label246:
    for (paramInt = d.a.a.b.b.a.e(1, this.tMY) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.tMZ) + d.a.a.a.gy(3, this.tNa);
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
        bws localbws = (bws)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbws.tMY = locala.xpH.readString();
          return 0;
        case 2: 
          localbws.tMZ = locala.xpH.oD();
          return 0;
        }
        localbws.tNa = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bws
 * JD-Core Version:    0.7.0.1
 */