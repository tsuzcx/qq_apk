package com.tencent.mm.protocal.c;

public final class pj
  extends com.tencent.mm.bv.a
{
  public String bQZ;
  public String mPk;
  public String nAu;
  public int sNe;
  public String title;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.bQZ != null) {
        paramVarArgs.d(2, this.bQZ);
      }
      if (this.mPk != null) {
        paramVarArgs.d(3, this.mPk);
      }
      if (this.nAu != null) {
        paramVarArgs.d(4, this.nAu);
      }
      paramVarArgs.gB(5, this.sNe);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label379;
      }
    }
    label379:
    for (int i = d.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bQZ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bQZ);
      }
      i = paramInt;
      if (this.mPk != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.mPk);
      }
      paramInt = i;
      if (this.nAu != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.nAu);
      }
      return paramInt + d.a.a.a.gy(5, this.sNe);
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
        pj localpj = (pj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localpj.title = locala.xpH.readString();
          return 0;
        case 2: 
          localpj.bQZ = locala.xpH.readString();
          return 0;
        case 3: 
          localpj.mPk = locala.xpH.readString();
          return 0;
        case 4: 
          localpj.nAu = locala.xpH.readString();
          return 0;
        }
        localpj.sNe = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.pj
 * JD-Core Version:    0.7.0.1
 */