package com.tencent.mm.protocal.c;

public final class bkb
  extends com.tencent.mm.bv.a
{
  public String jwY;
  public String sAE;
  public int tCm;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.jwY != null) {
        paramVarArgs.d(1, this.jwY);
      }
      if (this.sAE != null) {
        paramVarArgs.d(2, this.sAE);
      }
      paramVarArgs.gB(3, this.tCm);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jwY == null) {
        break label269;
      }
    }
    label269:
    for (paramInt = d.a.a.b.b.a.e(1, this.jwY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sAE != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sAE);
      }
      return i + d.a.a.a.gy(3, this.tCm);
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
        bkb localbkb = (bkb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbkb.jwY = locala.xpH.readString();
          return 0;
        case 2: 
          localbkb.sAE = locala.xpH.readString();
          return 0;
        }
        localbkb.tCm = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bkb
 * JD-Core Version:    0.7.0.1
 */