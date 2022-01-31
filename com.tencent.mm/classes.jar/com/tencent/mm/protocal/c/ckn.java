package com.tencent.mm.protocal.c;

public final class ckn
  extends com.tencent.mm.bv.a
{
  public int sRd;
  public com.tencent.mm.bv.b sxO;
  public boolean tXR;
  public boolean tXS;
  public String tXp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tXp == null) {
        throw new d.a.a.b("Not all required fields were included: Talker");
      }
      if (this.tXp != null) {
        paramVarArgs.d(1, this.tXp);
      }
      paramVarArgs.gB(2, this.sRd);
      if (this.sxO != null) {
        paramVarArgs.b(3, this.sxO);
      }
      paramVarArgs.aA(4, this.tXR);
      paramVarArgs.aA(5, this.tXS);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tXp == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = d.a.a.b.b.a.e(1, this.tXp) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sRd);
      paramInt = i;
      if (this.sxO != null) {
        paramInt = i + d.a.a.a.a(3, this.sxO);
      }
      return paramInt + (d.a.a.b.b.a.dQ(4) + 1) + (d.a.a.b.b.a.dQ(5) + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tXp != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: Talker");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        ckn localckn = (ckn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localckn.tXp = locala.xpH.readString();
          return 0;
        case 2: 
          localckn.sRd = locala.xpH.oD();
          return 0;
        case 3: 
          localckn.sxO = locala.cUs();
          return 0;
        case 4: 
          localckn.tXR = locala.cUr();
          return 0;
        }
        localckn.tXS = locala.cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ckn
 * JD-Core Version:    0.7.0.1
 */