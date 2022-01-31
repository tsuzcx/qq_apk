package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class cjl
  extends com.tencent.mm.bv.a
{
  public String cNb;
  public String hQd;
  public String sPn;
  public int swP;
  public String tXi;
  public String tXj;
  public String tXk;
  public String tXl;
  public String tXm;
  public String tXn;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tXi == null) {
        throw new b("Not all required fields were included: LocalNodeId");
      }
      if (this.tXi != null) {
        paramVarArgs.d(1, this.tXi);
      }
      if (this.hQd != null) {
        paramVarArgs.d(2, this.hQd);
      }
      if (this.tXj != null) {
        paramVarArgs.d(3, this.tXj);
      }
      if (this.cNb != null) {
        paramVarArgs.d(4, this.cNb);
      }
      if (this.tXk != null) {
        paramVarArgs.d(5, this.tXk);
      }
      if (this.sPn != null) {
        paramVarArgs.d(6, this.sPn);
      }
      if (this.tXl != null) {
        paramVarArgs.d(7, this.tXl);
      }
      if (this.tXm != null) {
        paramVarArgs.d(8, this.tXm);
      }
      if (this.tXn != null) {
        paramVarArgs.d(9, this.tXn);
      }
      paramVarArgs.gB(10, this.swP);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tXi == null) {
        break label698;
      }
    }
    label698:
    for (int i = d.a.a.b.b.a.e(1, this.tXi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hQd != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hQd);
      }
      i = paramInt;
      if (this.tXj != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tXj);
      }
      paramInt = i;
      if (this.cNb != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.cNb);
      }
      i = paramInt;
      if (this.tXk != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tXk);
      }
      paramInt = i;
      if (this.sPn != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sPn);
      }
      i = paramInt;
      if (this.tXl != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.tXl);
      }
      paramInt = i;
      if (this.tXm != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tXm);
      }
      i = paramInt;
      if (this.tXn != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.tXn);
      }
      return i + d.a.a.a.gy(10, this.swP);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tXi != null) {
          break;
        }
        throw new b("Not all required fields were included: LocalNodeId");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cjl localcjl = (cjl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcjl.tXi = locala.xpH.readString();
          return 0;
        case 2: 
          localcjl.hQd = locala.xpH.readString();
          return 0;
        case 3: 
          localcjl.tXj = locala.xpH.readString();
          return 0;
        case 4: 
          localcjl.cNb = locala.xpH.readString();
          return 0;
        case 5: 
          localcjl.tXk = locala.xpH.readString();
          return 0;
        case 6: 
          localcjl.sPn = locala.xpH.readString();
          return 0;
        case 7: 
          localcjl.tXl = locala.xpH.readString();
          return 0;
        case 8: 
          localcjl.tXm = locala.xpH.readString();
          return 0;
        case 9: 
          localcjl.tXn = locala.xpH.readString();
          return 0;
        }
        localcjl.swP = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cjl
 * JD-Core Version:    0.7.0.1
 */