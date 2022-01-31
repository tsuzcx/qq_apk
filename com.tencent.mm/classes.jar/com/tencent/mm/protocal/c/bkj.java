package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class bkj
  extends com.tencent.mm.bv.a
{
  public int hQR;
  public int jxx;
  public b sQA;
  public int tAu;
  public String tEd;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEd != null) {
        paramVarArgs.d(1, this.tEd);
      }
      paramVarArgs.gB(2, this.hQR);
      paramVarArgs.gB(3, this.jxx);
      paramVarArgs.gB(4, this.tAu);
      if (this.sQA != null) {
        paramVarArgs.b(5, this.sQA);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEd == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = d.a.a.b.b.a.e(1, this.tEd) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.hQR) + d.a.a.a.gy(3, this.jxx) + d.a.a.a.gy(4, this.tAu);
      paramInt = i;
      if (this.sQA != null) {
        paramInt = i + d.a.a.a.a(5, this.sQA);
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
        bkj localbkj = (bkj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbkj.tEd = locala.xpH.readString();
          return 0;
        case 2: 
          localbkj.hQR = locala.xpH.oD();
          return 0;
        case 3: 
          localbkj.jxx = locala.xpH.oD();
          return 0;
        case 4: 
          localbkj.tAu = locala.xpH.oD();
          return 0;
        }
        localbkj.sQA = locala.cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bkj
 * JD-Core Version:    0.7.0.1
 */