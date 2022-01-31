package com.tencent.mm.protocal.c;

public final class cgt
  extends com.tencent.mm.bv.a
{
  public String bFq;
  public String bFr;
  public String tVG;
  public long timestamp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bFq != null) {
        paramVarArgs.d(1, this.bFq);
      }
      if (this.bFr != null) {
        paramVarArgs.d(2, this.bFr);
      }
      if (this.tVG != null) {
        paramVarArgs.d(3, this.tVG);
      }
      paramVarArgs.Y(4, this.timestamp);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bFq == null) {
        break label324;
      }
    }
    label324:
    for (int i = d.a.a.b.b.a.e(1, this.bFq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bFr != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bFr);
      }
      i = paramInt;
      if (this.tVG != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tVG);
      }
      return i + d.a.a.a.X(4, this.timestamp);
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
        cgt localcgt = (cgt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcgt.bFq = locala.xpH.readString();
          return 0;
        case 2: 
          localcgt.bFr = locala.xpH.readString();
          return 0;
        case 3: 
          localcgt.tVG = locala.xpH.readString();
          return 0;
        }
        localcgt.timestamp = locala.xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cgt
 * JD-Core Version:    0.7.0.1
 */