package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class gk
  extends com.tencent.mm.bv.a
{
  public int sAr;
  public int sAs;
  public LinkedList<String> sAt = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sAr);
      paramVarArgs.gB(2, this.sAs);
      paramVarArgs.d(3, 1, this.sAt);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.sAr) + 0 + d.a.a.a.gy(2, this.sAs) + d.a.a.a.c(3, 1, this.sAt);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sAt.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
      gk localgk = (gk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localgk.sAr = locala.xpH.oD();
        return 0;
      case 2: 
        localgk.sAs = locala.xpH.oD();
        return 0;
      }
      localgk.sAt.add(locala.xpH.readString());
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.gk
 * JD-Core Version:    0.7.0.1
 */