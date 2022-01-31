package com.tencent.mm.protocal.c;

public final class bhn
  extends com.tencent.mm.bv.a
{
  public String jwY;
  public String sUm;
  public int tCm;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.jwY != null) {
        paramVarArgs.d(1, this.jwY);
      }
      paramVarArgs.gB(2, this.tCm);
      if (this.sUm != null) {
        paramVarArgs.d(3, this.sUm);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.jwY == null) {
        break label273;
      }
    }
    label273:
    for (paramInt = d.a.a.b.b.a.e(1, this.jwY) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tCm);
      paramInt = i;
      if (this.sUm != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.sUm);
      }
      return paramInt;
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
        bhn localbhn = (bhn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbhn.jwY = locala.xpH.readString();
          return 0;
        case 2: 
          localbhn.tCm = locala.xpH.oD();
          return 0;
        }
        localbhn.sUm = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bhn
 * JD-Core Version:    0.7.0.1
 */