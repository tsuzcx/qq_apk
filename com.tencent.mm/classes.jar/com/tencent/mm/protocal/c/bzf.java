package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class bzf
  extends com.tencent.mm.bv.a
{
  public int tPo;
  public int tPp;
  public String tPq;
  public b tPr;
  public int tPs;
  public int tPt;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tPo);
      paramVarArgs.gB(2, this.tPp);
      if (this.tPq != null) {
        paramVarArgs.d(3, this.tPq);
      }
      if (this.tPr != null) {
        paramVarArgs.b(4, this.tPr);
      }
      paramVarArgs.gB(5, this.tPs);
      paramVarArgs.gB(6, this.tPt);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.tPo) + 0 + d.a.a.a.gy(2, this.tPp);
      paramInt = i;
      if (this.tPq != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.tPq);
      }
      i = paramInt;
      if (this.tPr != null) {
        i = paramInt + d.a.a.a.a(4, this.tPr);
      }
      return i + d.a.a.a.gy(5, this.tPs) + d.a.a.a.gy(6, this.tPt);
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
      bzf localbzf = (bzf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbzf.tPo = locala.xpH.oD();
        return 0;
      case 2: 
        localbzf.tPp = locala.xpH.oD();
        return 0;
      case 3: 
        localbzf.tPq = locala.xpH.readString();
        return 0;
      case 4: 
        localbzf.tPr = locala.cUs();
        return 0;
      case 5: 
        localbzf.tPs = locala.xpH.oD();
        return 0;
      }
      localbzf.tPt = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bzf
 * JD-Core Version:    0.7.0.1
 */