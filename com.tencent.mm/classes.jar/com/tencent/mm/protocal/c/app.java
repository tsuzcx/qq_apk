package com.tencent.mm.protocal.c;

public final class app
  extends com.tencent.mm.bv.a
{
  public int hQL;
  public String jnU;
  public String kRZ;
  public String kSC;
  public String sGQ;
  public String sGU;
  public String sSA;
  public String tlG;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sSA != null) {
        paramVarArgs.d(1, this.sSA);
      }
      if (this.kRZ != null) {
        paramVarArgs.d(2, this.kRZ);
      }
      paramVarArgs.gB(3, this.hQL);
      if (this.jnU != null) {
        paramVarArgs.d(4, this.jnU);
      }
      if (this.sGU != null) {
        paramVarArgs.d(5, this.sGU);
      }
      if (this.sGQ != null) {
        paramVarArgs.d(6, this.sGQ);
      }
      if (this.kSC != null) {
        paramVarArgs.d(7, this.kSC);
      }
      if (this.tlG != null) {
        paramVarArgs.d(8, this.tlG);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sSA == null) {
        break label552;
      }
    }
    label552:
    for (paramInt = d.a.a.b.b.a.e(1, this.sSA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kRZ != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kRZ);
      }
      i += d.a.a.a.gy(3, this.hQL);
      paramInt = i;
      if (this.jnU != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.jnU);
      }
      i = paramInt;
      if (this.sGU != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sGU);
      }
      paramInt = i;
      if (this.sGQ != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sGQ);
      }
      i = paramInt;
      if (this.kSC != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.kSC);
      }
      paramInt = i;
      if (this.tlG != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tlG);
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
        app localapp = (app)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localapp.sSA = locala.xpH.readString();
          return 0;
        case 2: 
          localapp.kRZ = locala.xpH.readString();
          return 0;
        case 3: 
          localapp.hQL = locala.xpH.oD();
          return 0;
        case 4: 
          localapp.jnU = locala.xpH.readString();
          return 0;
        case 5: 
          localapp.sGU = locala.xpH.readString();
          return 0;
        case 6: 
          localapp.sGQ = locala.xpH.readString();
          return 0;
        case 7: 
          localapp.kSC = locala.xpH.readString();
          return 0;
        }
        localapp.tlG = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.app
 * JD-Core Version:    0.7.0.1
 */