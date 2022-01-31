package com.tencent.mm.protocal.c;

public final class avh
  extends com.tencent.mm.bv.a
{
  public String bOL;
  public int pyo;
  public int sCy;
  public int tmZ;
  public int tqL;
  public int tqM;
  public String tqN;
  public int tqO;
  public String username;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bOL != null) {
        paramVarArgs.d(1, this.bOL);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      paramVarArgs.gB(3, this.tmZ);
      paramVarArgs.gB(4, this.sCy);
      paramVarArgs.gB(5, this.pyo);
      paramVarArgs.gB(6, this.tqL);
      paramVarArgs.gB(7, this.tqM);
      if (this.tqN != null) {
        paramVarArgs.d(8, this.tqN);
      }
      paramVarArgs.gB(9, this.tqO);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bOL == null) {
        break label519;
      }
    }
    label519:
    for (paramInt = d.a.a.b.b.a.e(1, this.bOL) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.username);
      }
      i = i + d.a.a.a.gy(3, this.tmZ) + d.a.a.a.gy(4, this.sCy) + d.a.a.a.gy(5, this.pyo) + d.a.a.a.gy(6, this.tqL) + d.a.a.a.gy(7, this.tqM);
      paramInt = i;
      if (this.tqN != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tqN);
      }
      return paramInt + d.a.a.a.gy(9, this.tqO);
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
        avh localavh = (avh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localavh.bOL = locala.xpH.readString();
          return 0;
        case 2: 
          localavh.username = locala.xpH.readString();
          return 0;
        case 3: 
          localavh.tmZ = locala.xpH.oD();
          return 0;
        case 4: 
          localavh.sCy = locala.xpH.oD();
          return 0;
        case 5: 
          localavh.pyo = locala.xpH.oD();
          return 0;
        case 6: 
          localavh.tqL = locala.xpH.oD();
          return 0;
        case 7: 
          localavh.tqM = locala.xpH.oD();
          return 0;
        case 8: 
          localavh.tqN = locala.xpH.readString();
          return 0;
        }
        localavh.tqO = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.avh
 * JD-Core Version:    0.7.0.1
 */