package com.tencent.mm.protocal.c;

public final class bez
  extends com.tencent.mm.bv.a
{
  public String qlZ;
  public String sQT;
  public int tjw;
  public String tzM;
  public String tzN;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tzM != null) {
        paramVarArgs.d(1, this.tzM);
      }
      if (this.tzN != null) {
        paramVarArgs.d(2, this.tzN);
      }
      if (this.qlZ != null) {
        paramVarArgs.d(3, this.qlZ);
      }
      if (this.sQT != null) {
        paramVarArgs.d(4, this.sQT);
      }
      paramVarArgs.gB(5, this.tjw);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tzM == null) {
        break label379;
      }
    }
    label379:
    for (int i = d.a.a.b.b.a.e(1, this.tzM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tzN != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tzN);
      }
      i = paramInt;
      if (this.qlZ != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.qlZ);
      }
      paramInt = i;
      if (this.sQT != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sQT);
      }
      return paramInt + d.a.a.a.gy(5, this.tjw);
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
        bez localbez = (bez)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbez.tzM = locala.xpH.readString();
          return 0;
        case 2: 
          localbez.tzN = locala.xpH.readString();
          return 0;
        case 3: 
          localbez.qlZ = locala.xpH.readString();
          return 0;
        case 4: 
          localbez.sQT = locala.xpH.readString();
          return 0;
        }
        localbez.tjw = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bez
 * JD-Core Version:    0.7.0.1
 */