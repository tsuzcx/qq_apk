package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cat
  extends com.tencent.mm.bv.a
{
  public String jnN;
  public int ndf;
  public int ndg;
  public String sRE;
  public com.tencent.mm.bv.b tPS;
  public boolean tPT;
  public LinkedList<String> tPU = new LinkedList();
  public String tPV;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tPS == null) {
        throw new d.a.a.b("Not all required fields were included: EmojiBuffer");
      }
      if (this.sRE != null) {
        paramVarArgs.d(1, this.sRE);
      }
      paramVarArgs.gB(2, this.ndg);
      paramVarArgs.gB(3, this.ndf);
      if (this.tPS != null) {
        paramVarArgs.b(4, this.tPS);
      }
      paramVarArgs.aA(5, this.tPT);
      paramVarArgs.d(6, 1, this.tPU);
      if (this.jnN != null) {
        paramVarArgs.d(7, this.jnN);
      }
      if (this.tPV != null) {
        paramVarArgs.d(8, this.tPV);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sRE == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = d.a.a.b.b.a.e(1, this.sRE) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ndg) + d.a.a.a.gy(3, this.ndf);
      paramInt = i;
      if (this.tPS != null) {
        paramInt = i + d.a.a.a.a(4, this.tPS);
      }
      i = paramInt + (d.a.a.b.b.a.dQ(5) + 1) + d.a.a.a.c(6, 1, this.tPU);
      paramInt = i;
      if (this.jnN != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.jnN);
      }
      i = paramInt;
      if (this.tPV != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.tPV);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tPU.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tPS != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: EmojiBuffer");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cat localcat = (cat)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcat.sRE = locala.xpH.readString();
          return 0;
        case 2: 
          localcat.ndg = locala.xpH.oD();
          return 0;
        case 3: 
          localcat.ndf = locala.xpH.oD();
          return 0;
        case 4: 
          localcat.tPS = locala.cUs();
          return 0;
        case 5: 
          localcat.tPT = locala.cUr();
          return 0;
        case 6: 
          localcat.tPU.add(locala.xpH.readString());
          return 0;
        case 7: 
          localcat.jnN = locala.xpH.readString();
          return 0;
        }
        localcat.tPV = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cat
 * JD-Core Version:    0.7.0.1
 */