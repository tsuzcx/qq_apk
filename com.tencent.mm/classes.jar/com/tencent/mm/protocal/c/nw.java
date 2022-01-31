package com.tencent.mm.protocal.c;

public final class nw
  extends com.tencent.mm.bv.a
{
  public String iQL;
  public int iQi;
  public String iQj;
  public String iQn;
  public int sLo;
  public String sLp;
  public String sLq;
  public int sLr;
  public String sLs;
  public int sLt;
  public String sLu;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sLo);
      if (this.iQL != null) {
        paramVarArgs.d(2, this.iQL);
      }
      if (this.sLp != null) {
        paramVarArgs.d(3, this.sLp);
      }
      if (this.sLq != null) {
        paramVarArgs.d(4, this.sLq);
      }
      paramVarArgs.gB(5, this.sLr);
      if (this.sLs != null) {
        paramVarArgs.d(6, this.sLs);
      }
      paramVarArgs.gB(7, this.sLt);
      if (this.iQn != null) {
        paramVarArgs.d(8, this.iQn);
      }
      if (this.sLu != null) {
        paramVarArgs.d(9, this.sLu);
      }
      paramVarArgs.gB(10, this.iQi);
      if (this.iQj != null) {
        paramVarArgs.d(11, this.iQj);
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
      i = d.a.a.a.gy(1, this.sLo) + 0;
      paramInt = i;
      if (this.iQL != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.iQL);
      }
      i = paramInt;
      if (this.sLp != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sLp);
      }
      paramInt = i;
      if (this.sLq != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sLq);
      }
      i = paramInt + d.a.a.a.gy(5, this.sLr);
      paramInt = i;
      if (this.sLs != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sLs);
      }
      i = paramInt + d.a.a.a.gy(7, this.sLt);
      paramInt = i;
      if (this.iQn != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.iQn);
      }
      i = paramInt;
      if (this.sLu != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sLu);
      }
      i += d.a.a.a.gy(10, this.iQi);
      paramInt = i;
    } while (this.iQj == null);
    return i + d.a.a.b.b.a.e(11, this.iQj);
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
      nw localnw = (nw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localnw.sLo = locala.xpH.oD();
        return 0;
      case 2: 
        localnw.iQL = locala.xpH.readString();
        return 0;
      case 3: 
        localnw.sLp = locala.xpH.readString();
        return 0;
      case 4: 
        localnw.sLq = locala.xpH.readString();
        return 0;
      case 5: 
        localnw.sLr = locala.xpH.oD();
        return 0;
      case 6: 
        localnw.sLs = locala.xpH.readString();
        return 0;
      case 7: 
        localnw.sLt = locala.xpH.oD();
        return 0;
      case 8: 
        localnw.iQn = locala.xpH.readString();
        return 0;
      case 9: 
        localnw.sLu = locala.xpH.readString();
        return 0;
      case 10: 
        localnw.iQi = locala.xpH.oD();
        return 0;
      }
      localnw.iQj = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.nw
 * JD-Core Version:    0.7.0.1
 */