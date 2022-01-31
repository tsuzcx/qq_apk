package com.tencent.mm.protocal.c;

public final class avc
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public int svx;
  public String tqI;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tqI != null) {
        paramVarArgs.d(1, this.tqI);
      }
      if (this.bGw != null) {
        paramVarArgs.d(2, this.bGw);
      }
      paramVarArgs.gB(3, this.svx);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tqI == null) {
        break label269;
      }
    }
    label269:
    for (paramInt = d.a.a.b.b.a.e(1, this.tqI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bGw != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.bGw);
      }
      return i + d.a.a.a.gy(3, this.svx);
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
        avc localavc = (avc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localavc.tqI = locala.xpH.readString();
          return 0;
        case 2: 
          localavc.bGw = locala.xpH.readString();
          return 0;
        }
        localavc.svx = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.avc
 * JD-Core Version:    0.7.0.1
 */