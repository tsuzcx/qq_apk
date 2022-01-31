package com.tencent.mm.protocal.c;

public final class bgl
  extends com.tencent.mm.bv.a
{
  public String bIW;
  public String bQC;
  public boolean tBe;
  public int tBf;
  public String url;
  public int version;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aA(1, this.tBe);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.bIW != null) {
        paramVarArgs.d(3, this.bIW);
      }
      paramVarArgs.gB(4, this.version);
      paramVarArgs.gB(5, this.tBf);
      if (this.bQC != null) {
        paramVarArgs.d(6, this.bQC);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.b.b.a.dQ(1) + 1 + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.bIW != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bIW);
      }
      i = i + d.a.a.a.gy(4, this.version) + d.a.a.a.gy(5, this.tBf);
      paramInt = i;
    } while (this.bQC == null);
    return i + d.a.a.b.b.a.e(6, this.bQC);
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
      bgl localbgl = (bgl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbgl.tBe = locala.cUr();
        return 0;
      case 2: 
        localbgl.url = locala.xpH.readString();
        return 0;
      case 3: 
        localbgl.bIW = locala.xpH.readString();
        return 0;
      case 4: 
        localbgl.version = locala.xpH.oD();
        return 0;
      case 5: 
        localbgl.tBf = locala.xpH.oD();
        return 0;
      }
      localbgl.bQC = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bgl
 * JD-Core Version:    0.7.0.1
 */