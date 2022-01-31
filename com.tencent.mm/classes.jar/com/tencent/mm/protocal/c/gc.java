package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class gc
  extends com.tencent.mm.bv.a
{
  public int jwX;
  public int pyo;
  public b sAj;
  public b sAk;
  public int sAl;
  public b sAm;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sAj != null) {
        paramVarArgs.b(1, this.sAj);
      }
      paramVarArgs.gB(2, this.jwX);
      if (this.sAk != null) {
        paramVarArgs.b(3, this.sAk);
      }
      paramVarArgs.gB(4, this.sAl);
      if (this.sAm != null) {
        paramVarArgs.b(5, this.sAm);
      }
      paramVarArgs.gB(6, this.pyo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sAj == null) {
        break label397;
      }
    }
    label397:
    for (paramInt = d.a.a.a.a(1, this.sAj) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.jwX);
      paramInt = i;
      if (this.sAk != null) {
        paramInt = i + d.a.a.a.a(3, this.sAk);
      }
      i = paramInt + d.a.a.a.gy(4, this.sAl);
      paramInt = i;
      if (this.sAm != null) {
        paramInt = i + d.a.a.a.a(5, this.sAm);
      }
      return paramInt + d.a.a.a.gy(6, this.pyo);
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
        gc localgc = (gc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localgc.sAj = locala.cUs();
          return 0;
        case 2: 
          localgc.jwX = locala.xpH.oD();
          return 0;
        case 3: 
          localgc.sAk = locala.cUs();
          return 0;
        case 4: 
          localgc.sAl = locala.xpH.oD();
          return 0;
        case 5: 
          localgc.sAm = locala.cUs();
          return 0;
        }
        localgc.pyo = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.gc
 * JD-Core Version:    0.7.0.1
 */