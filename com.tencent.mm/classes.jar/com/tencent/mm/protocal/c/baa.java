package com.tencent.mm.protocal.c;

public final class baa
  extends com.tencent.mm.bv.a
{
  public int ijY;
  public int kQt;
  public String sDq;
  public int tvT;
  public int tvU;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sDq != null) {
        paramVarArgs.d(1, this.sDq);
      }
      paramVarArgs.gB(2, this.tvT);
      paramVarArgs.gB(3, this.kQt);
      paramVarArgs.gB(4, this.tvU);
      paramVarArgs.gB(5, this.ijY);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sDq == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = d.a.a.b.b.a.e(1, this.sDq) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.tvT) + d.a.a.a.gy(3, this.kQt) + d.a.a.a.gy(4, this.tvU) + d.a.a.a.gy(5, this.ijY);
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
        baa localbaa = (baa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbaa.sDq = locala.xpH.readString();
          return 0;
        case 2: 
          localbaa.tvT = locala.xpH.oD();
          return 0;
        case 3: 
          localbaa.kQt = locala.xpH.oD();
          return 0;
        case 4: 
          localbaa.tvU = locala.xpH.oD();
          return 0;
        }
        localbaa.ijY = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.baa
 * JD-Core Version:    0.7.0.1
 */