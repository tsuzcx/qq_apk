package com.tencent.mm.protocal.c;

public final class cmx
  extends com.tencent.mm.bv.a
{
  public String session_id;
  public String tYI;
  public int tZA;
  public boolean tZB = false;
  public boolean tZC = false;
  public int tZx;
  public int tZy;
  public String tZz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tZx);
      paramVarArgs.gB(2, this.tZy);
      if (this.session_id != null) {
        paramVarArgs.d(3, this.session_id);
      }
      if (this.tZz != null) {
        paramVarArgs.d(4, this.tZz);
      }
      if (this.tYI != null) {
        paramVarArgs.d(5, this.tYI);
      }
      paramVarArgs.gB(6, this.tZA);
      paramVarArgs.aA(7, this.tZB);
      paramVarArgs.aA(8, this.tZC);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.tZx) + 0 + d.a.a.a.gy(2, this.tZy);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.session_id);
      }
      i = paramInt;
      if (this.tZz != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.tZz);
      }
      paramInt = i;
      if (this.tYI != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tYI);
      }
      return paramInt + d.a.a.a.gy(6, this.tZA) + (d.a.a.b.b.a.dQ(7) + 1) + (d.a.a.b.b.a.dQ(8) + 1);
    }
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
      cmx localcmx = (cmx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcmx.tZx = locala.xpH.oD();
        return 0;
      case 2: 
        localcmx.tZy = locala.xpH.oD();
        return 0;
      case 3: 
        localcmx.session_id = locala.xpH.readString();
        return 0;
      case 4: 
        localcmx.tZz = locala.xpH.readString();
        return 0;
      case 5: 
        localcmx.tYI = locala.xpH.readString();
        return 0;
      case 6: 
        localcmx.tZA = locala.xpH.oD();
        return 0;
      case 7: 
        localcmx.tZB = locala.cUr();
        return 0;
      }
      localcmx.tZC = locala.cUr();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cmx
 * JD-Core Version:    0.7.0.1
 */