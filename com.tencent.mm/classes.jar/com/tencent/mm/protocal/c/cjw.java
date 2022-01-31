package com.tencent.mm.protocal.c;

public final class cjw
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kVs;
  public int kWl;
  public int tXB;
  public boolean tXC;
  public boolean tXD;
  public boolean tXE;
  public com.tencent.mm.bv.b tXh;
  public String tXp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tXp == null) {
        throw new d.a.a.b("Not all required fields were included: Talker");
      }
      if (this.bGw == null) {
        throw new d.a.a.b("Not all required fields were included: Title");
      }
      if (this.kVs == null) {
        throw new d.a.a.b("Not all required fields were included: Content");
      }
      paramVarArgs.gB(1, this.kWl);
      if (this.tXp != null) {
        paramVarArgs.d(2, this.tXp);
      }
      if (this.bGw != null) {
        paramVarArgs.d(3, this.bGw);
      }
      if (this.kVs != null) {
        paramVarArgs.d(4, this.kVs);
      }
      paramVarArgs.gB(5, this.tXB);
      if (this.tXh != null) {
        paramVarArgs.b(6, this.tXh);
      }
      paramVarArgs.aA(7, this.tXC);
      paramVarArgs.aA(8, this.tXD);
      paramVarArgs.aA(9, this.tXE);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.kWl) + 0;
      paramInt = i;
      if (this.tXp != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tXp);
      }
      i = paramInt;
      if (this.bGw != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bGw);
      }
      paramInt = i;
      if (this.kVs != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kVs);
      }
      i = paramInt + d.a.a.a.gy(5, this.tXB);
      paramInt = i;
      if (this.tXh != null) {
        paramInt = i + d.a.a.a.a(6, this.tXh);
      }
      return paramInt + (d.a.a.b.b.a.dQ(7) + 1) + (d.a.a.b.b.a.dQ(8) + 1) + (d.a.a.b.b.a.dQ(9) + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.tXp == null) {
        throw new d.a.a.b("Not all required fields were included: Talker");
      }
      if (this.bGw == null) {
        throw new d.a.a.b("Not all required fields were included: Title");
      }
      if (this.kVs == null) {
        throw new d.a.a.b("Not all required fields were included: Content");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      cjw localcjw = (cjw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcjw.kWl = locala.xpH.oD();
        return 0;
      case 2: 
        localcjw.tXp = locala.xpH.readString();
        return 0;
      case 3: 
        localcjw.bGw = locala.xpH.readString();
        return 0;
      case 4: 
        localcjw.kVs = locala.xpH.readString();
        return 0;
      case 5: 
        localcjw.tXB = locala.xpH.oD();
        return 0;
      case 6: 
        localcjw.tXh = locala.cUs();
        return 0;
      case 7: 
        localcjw.tXC = locala.cUr();
        return 0;
      case 8: 
        localcjw.tXD = locala.cUr();
        return 0;
      }
      localcjw.tXE = locala.cUr();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cjw
 * JD-Core Version:    0.7.0.1
 */