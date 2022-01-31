package com.tencent.mm.protocal.c;

public final class bjg
  extends com.tencent.mm.bv.a
{
  public String lRD;
  public String lRE;
  public String lRF;
  public String lRG;
  public int ssk;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.ssk);
      if (this.lRD != null) {
        paramVarArgs.d(2, this.lRD);
      }
      if (this.lRE != null) {
        paramVarArgs.d(3, this.lRE);
      }
      if (this.lRF != null) {
        paramVarArgs.d(4, this.lRF);
      }
      if (this.lRG != null) {
        paramVarArgs.d(5, this.lRG);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.ssk) + 0;
      paramInt = i;
      if (this.lRD != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.lRD);
      }
      i = paramInt;
      if (this.lRE != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.lRE);
      }
      paramInt = i;
      if (this.lRF != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.lRF);
      }
      i = paramInt;
    } while (this.lRG == null);
    return paramInt + d.a.a.b.b.a.e(5, this.lRG);
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
      bjg localbjg = (bjg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbjg.ssk = locala.xpH.oD();
        return 0;
      case 2: 
        localbjg.lRD = locala.xpH.readString();
        return 0;
      case 3: 
        localbjg.lRE = locala.xpH.readString();
        return 0;
      case 4: 
        localbjg.lRF = locala.xpH.readString();
        return 0;
      }
      localbjg.lRG = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bjg
 * JD-Core Version:    0.7.0.1
 */