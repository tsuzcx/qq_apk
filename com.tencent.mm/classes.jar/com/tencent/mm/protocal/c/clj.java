package com.tencent.mm.protocal.c;

public final class clj
  extends com.tencent.mm.bv.a
{
  public String bIW;
  public int sEr;
  public int tYF;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tYF);
      paramVarArgs.gB(2, this.sEr);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.bIW != null) {
        paramVarArgs.d(4, this.bIW);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.tYF) + 0 + d.a.a.a.gy(2, this.sEr);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.url);
      }
      i = paramInt;
    } while (this.bIW == null);
    return paramInt + d.a.a.b.b.a.e(4, this.bIW);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      clj localclj = (clj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localclj.tYF = locala.xpH.oD();
        return 0;
      case 2: 
        localclj.sEr = locala.xpH.oD();
        return 0;
      case 3: 
        localclj.url = locala.xpH.readString();
        return 0;
      }
      localclj.bIW = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.clj
 * JD-Core Version:    0.7.0.1
 */