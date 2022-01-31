package com.tencent.mm.protocal.c;

public final class wi
  extends com.tencent.mm.bv.a
{
  public String kRZ;
  public int kWl;
  public int sFS;
  public String sSo;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRZ != null) {
        paramVarArgs.d(1, this.kRZ);
      }
      paramVarArgs.gB(2, this.sFS);
      if (this.sSo != null) {
        paramVarArgs.d(3, this.sSo);
      }
      paramVarArgs.gB(4, this.kWl);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kRZ == null) {
        break label308;
      }
    }
    label308:
    for (paramInt = d.a.a.b.b.a.e(1, this.kRZ) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sFS);
      paramInt = i;
      if (this.sSo != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.sSo);
      }
      return paramInt + d.a.a.a.gy(4, this.kWl);
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
        wi localwi = (wi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localwi.kRZ = locala.xpH.readString();
          return 0;
        case 2: 
          localwi.sFS = locala.xpH.oD();
          return 0;
        case 3: 
          localwi.sSo = locala.xpH.readString();
          return 0;
        }
        localwi.kWl = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.wi
 * JD-Core Version:    0.7.0.1
 */