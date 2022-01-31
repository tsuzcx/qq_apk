package com.tencent.mm.protocal.c;

public final class cjs
  extends com.tencent.mm.bv.a
{
  public int kSW;
  public String kVs;
  public String tXp;
  public long tXq;
  public long tXv;
  public boolean tXw;
  public com.tencent.mm.bv.b tXx;
  public String tqh;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tqh == null) {
        throw new d.a.a.b("Not all required fields were included: Nickname");
      }
      if (this.kVs == null) {
        throw new d.a.a.b("Not all required fields were included: Content");
      }
      if (this.tXp == null) {
        throw new d.a.a.b("Not all required fields were included: Talker");
      }
      paramVarArgs.Y(1, this.tXq);
      if (this.tqh != null) {
        paramVarArgs.d(2, this.tqh);
      }
      if (this.kVs != null) {
        paramVarArgs.d(3, this.kVs);
      }
      paramVarArgs.gB(4, this.kSW);
      if (this.tXp != null) {
        paramVarArgs.d(5, this.tXp);
      }
      paramVarArgs.Y(6, this.tXv);
      paramVarArgs.aA(7, this.tXw);
      if (this.tXx != null) {
        paramVarArgs.b(8, this.tXx);
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
      i = d.a.a.a.X(1, this.tXq) + 0;
      paramInt = i;
      if (this.tqh != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tqh);
      }
      i = paramInt;
      if (this.kVs != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kVs);
      }
      i += d.a.a.a.gy(4, this.kSW);
      paramInt = i;
      if (this.tXp != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tXp);
      }
      i = paramInt + d.a.a.a.X(6, this.tXv) + (d.a.a.b.b.a.dQ(7) + 1);
      paramInt = i;
    } while (this.tXx == null);
    return i + d.a.a.a.a(8, this.tXx);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.tqh == null) {
        throw new d.a.a.b("Not all required fields were included: Nickname");
      }
      if (this.kVs == null) {
        throw new d.a.a.b("Not all required fields were included: Content");
      }
      if (this.tXp == null) {
        throw new d.a.a.b("Not all required fields were included: Talker");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      cjs localcjs = (cjs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcjs.tXq = locala.xpH.oE();
        return 0;
      case 2: 
        localcjs.tqh = locala.xpH.readString();
        return 0;
      case 3: 
        localcjs.kVs = locala.xpH.readString();
        return 0;
      case 4: 
        localcjs.kSW = locala.xpH.oD();
        return 0;
      case 5: 
        localcjs.tXp = locala.xpH.readString();
        return 0;
      case 6: 
        localcjs.tXv = locala.xpH.oE();
        return 0;
      case 7: 
        localcjs.tXw = locala.cUr();
        return 0;
      }
      localcjs.tXx = locala.cUs();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cjs
 * JD-Core Version:    0.7.0.1
 */