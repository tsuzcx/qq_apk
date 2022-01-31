package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class cgl
  extends com.tencent.mm.bv.a
{
  public String category;
  public int eAK;
  public b sRj;
  public int tGT;
  public int tVt;
  public int tVu;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.eAK);
      paramVarArgs.gB(2, this.tVt);
      if (this.category != null) {
        paramVarArgs.d(3, this.category);
      }
      if (this.sRj != null) {
        paramVarArgs.b(4, this.sRj);
      }
      paramVarArgs.gB(5, this.tGT);
      paramVarArgs.gB(6, this.tVu);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.eAK) + 0 + d.a.a.a.gy(2, this.tVt);
      paramInt = i;
      if (this.category != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.category);
      }
      i = paramInt;
      if (this.sRj != null) {
        i = paramInt + d.a.a.a.a(4, this.sRj);
      }
      return i + d.a.a.a.gy(5, this.tGT) + d.a.a.a.gy(6, this.tVu);
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
      cgl localcgl = (cgl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcgl.eAK = locala.xpH.oD();
        return 0;
      case 2: 
        localcgl.tVt = locala.xpH.oD();
        return 0;
      case 3: 
        localcgl.category = locala.xpH.readString();
        return 0;
      case 4: 
        localcgl.sRj = locala.cUs();
        return 0;
      case 5: 
        localcgl.tGT = locala.xpH.oD();
        return 0;
      }
      localcgl.tVu = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cgl
 * JD-Core Version:    0.7.0.1
 */