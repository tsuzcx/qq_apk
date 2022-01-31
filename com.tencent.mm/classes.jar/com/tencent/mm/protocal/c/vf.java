package com.tencent.mm.protocal.c;

public final class vf
  extends com.tencent.mm.bv.a
{
  public String kSC;
  public int ndo;
  public String sRu;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kSC != null) {
        paramVarArgs.d(1, this.kSC);
      }
      if (this.sRu != null) {
        paramVarArgs.d(2, this.sRu);
      }
      paramVarArgs.gB(3, this.ndo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kSC == null) {
        break label269;
      }
    }
    label269:
    for (paramInt = d.a.a.b.b.a.e(1, this.kSC) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sRu != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sRu);
      }
      return i + d.a.a.a.gy(3, this.ndo);
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
        vf localvf = (vf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localvf.kSC = locala.xpH.readString();
          return 0;
        case 2: 
          localvf.sRu = locala.xpH.readString();
          return 0;
        }
        localvf.ndo = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.vf
 * JD-Core Version:    0.7.0.1
 */