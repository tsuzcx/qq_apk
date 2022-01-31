package com.tencent.mm.protocal.c;

public final class brj
  extends com.tencent.mm.bv.a
{
  public String bZc;
  public String bZd;
  public String iln;
  public String stb;
  public String stc;
  public int std;
  public String tIg;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bZc != null) {
        paramVarArgs.d(1, this.bZc);
      }
      if (this.iln != null) {
        paramVarArgs.d(2, this.iln);
      }
      if (this.bZd != null) {
        paramVarArgs.d(3, this.bZd);
      }
      if (this.stb != null) {
        paramVarArgs.d(4, this.stb);
      }
      if (this.stc != null) {
        paramVarArgs.d(5, this.stc);
      }
      paramVarArgs.gB(6, this.std);
      if (this.tIg != null) {
        paramVarArgs.d(7, this.tIg);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bZc == null) {
        break label497;
      }
    }
    label497:
    for (int i = d.a.a.b.b.a.e(1, this.bZc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iln != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.iln);
      }
      i = paramInt;
      if (this.bZd != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bZd);
      }
      paramInt = i;
      if (this.stb != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.stb);
      }
      i = paramInt;
      if (this.stc != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.stc);
      }
      i += d.a.a.a.gy(6, this.std);
      paramInt = i;
      if (this.tIg != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.tIg);
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
        brj localbrj = (brj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbrj.bZc = locala.xpH.readString();
          return 0;
        case 2: 
          localbrj.iln = locala.xpH.readString();
          return 0;
        case 3: 
          localbrj.bZd = locala.xpH.readString();
          return 0;
        case 4: 
          localbrj.stb = locala.xpH.readString();
          return 0;
        case 5: 
          localbrj.stc = locala.xpH.readString();
          return 0;
        case 6: 
          localbrj.std = locala.xpH.oD();
          return 0;
        }
        localbrj.tIg = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.brj
 * JD-Core Version:    0.7.0.1
 */