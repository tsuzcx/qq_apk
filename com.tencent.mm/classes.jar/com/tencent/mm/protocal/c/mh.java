package com.tencent.mm.protocal.c;

public final class mh
  extends com.tencent.mm.bv.a
{
  public String bOL;
  public String code;
  public String iln;
  public String sJd;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.iln != null) {
        paramVarArgs.d(1, this.iln);
      }
      if (this.code != null) {
        paramVarArgs.d(2, this.code);
      }
      if (this.sJd != null) {
        paramVarArgs.d(3, this.sJd);
      }
      if (this.bOL != null) {
        paramVarArgs.d(4, this.bOL);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.iln == null) {
        break label344;
      }
    }
    label344:
    for (int i = d.a.a.b.b.a.e(1, this.iln) + 0;; i = 0)
    {
      paramInt = i;
      if (this.code != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.code);
      }
      i = paramInt;
      if (this.sJd != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sJd);
      }
      paramInt = i;
      if (this.bOL != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.bOL);
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
        mh localmh = (mh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localmh.iln = locala.xpH.readString();
          return 0;
        case 2: 
          localmh.code = locala.xpH.readString();
          return 0;
        case 3: 
          localmh.sJd = locala.xpH.readString();
          return 0;
        }
        localmh.bOL = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.mh
 * JD-Core Version:    0.7.0.1
 */