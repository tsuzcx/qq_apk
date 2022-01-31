package com.tencent.mm.protocal.c;

public final class cji
  extends com.tencent.mm.bv.a
{
  public String hPY;
  public String hRf;
  public String kVs;
  public int kWl;
  public com.tencent.mm.bv.b tXh;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPY == null) {
        throw new d.a.a.b("Not all required fields were included: UserName");
      }
      if (this.hRf == null) {
        throw new d.a.a.b("Not all required fields were included: NickName");
      }
      if (this.kVs == null) {
        throw new d.a.a.b("Not all required fields were included: Content");
      }
      paramVarArgs.gB(1, this.kWl);
      if (this.hPY != null) {
        paramVarArgs.d(2, this.hPY);
      }
      if (this.hRf != null) {
        paramVarArgs.d(3, this.hRf);
      }
      if (this.kVs != null) {
        paramVarArgs.d(4, this.kVs);
      }
      if (this.tXh != null) {
        paramVarArgs.b(5, this.tXh);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.kWl) + 0;
      paramInt = i;
      if (this.hPY != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hPY);
      }
      i = paramInt;
      if (this.hRf != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.hRf);
      }
      paramInt = i;
      if (this.kVs != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kVs);
      }
      i = paramInt;
    } while (this.tXh == null);
    return paramInt + d.a.a.a.a(5, this.tXh);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.hPY == null) {
        throw new d.a.a.b("Not all required fields were included: UserName");
      }
      if (this.hRf == null) {
        throw new d.a.a.b("Not all required fields were included: NickName");
      }
      if (this.kVs == null) {
        throw new d.a.a.b("Not all required fields were included: Content");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      cji localcji = (cji)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcji.kWl = locala.xpH.oD();
        return 0;
      case 2: 
        localcji.hPY = locala.xpH.readString();
        return 0;
      case 3: 
        localcji.hRf = locala.xpH.readString();
        return 0;
      case 4: 
        localcji.kVs = locala.xpH.readString();
        return 0;
      }
      localcji.tXh = locala.cUs();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cji
 * JD-Core Version:    0.7.0.1
 */