package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cgg
  extends com.tencent.mm.bv.a
{
  public String tVo;
  public String tVp;
  public LinkedList<String> tVq = new LinkedList();
  public int tVr;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tVo != null) {
        paramVarArgs.d(1, this.tVo);
      }
      if (this.tVp != null) {
        paramVarArgs.d(2, this.tVp);
      }
      paramVarArgs.d(3, 1, this.tVq);
      paramVarArgs.gB(4, this.tVr);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tVo == null) {
        break label320;
      }
    }
    label320:
    for (paramInt = d.a.a.b.b.a.e(1, this.tVo) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tVp != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tVp);
      }
      return i + d.a.a.a.c(3, 1, this.tVq) + d.a.a.a.gy(4, this.tVr);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tVq.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        cgg localcgg = (cgg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcgg.tVo = locala.xpH.readString();
          return 0;
        case 2: 
          localcgg.tVp = locala.xpH.readString();
          return 0;
        case 3: 
          localcgg.tVq.add(locala.xpH.readString());
          return 0;
        }
        localcgg.tVr = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cgg
 * JD-Core Version:    0.7.0.1
 */