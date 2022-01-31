package com.tencent.mm.protocal.c;

public final class aon
  extends com.tencent.mm.bv.a
{
  public int tkh;
  public com.tencent.mm.bv.b tki;
  public com.tencent.mm.bv.b tkj;
  public com.tencent.mm.bv.b tkk;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tki == null) {
        throw new d.a.a.b("Not all required fields were included: SPSBuf");
      }
      if (this.tkj == null) {
        throw new d.a.a.b("Not all required fields were included: PPSBuf");
      }
      paramVarArgs.gB(1, this.tkh);
      if (this.tki != null) {
        paramVarArgs.b(2, this.tki);
      }
      if (this.tkj != null) {
        paramVarArgs.b(3, this.tkj);
      }
      if (this.tkk != null) {
        paramVarArgs.b(4, this.tkk);
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
      i = d.a.a.a.gy(1, this.tkh) + 0;
      paramInt = i;
      if (this.tki != null) {
        paramInt = i + d.a.a.a.a(2, this.tki);
      }
      i = paramInt;
      if (this.tkj != null) {
        i = paramInt + d.a.a.a.a(3, this.tkj);
      }
      paramInt = i;
    } while (this.tkk == null);
    return i + d.a.a.a.a(4, this.tkk);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.tki == null) {
        throw new d.a.a.b("Not all required fields were included: SPSBuf");
      }
      if (this.tkj == null) {
        throw new d.a.a.b("Not all required fields were included: PPSBuf");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      aon localaon = (aon)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localaon.tkh = locala.xpH.oD();
        return 0;
      case 2: 
        localaon.tki = locala.cUs();
        return 0;
      case 3: 
        localaon.tkj = locala.cUs();
        return 0;
      }
      localaon.tkk = locala.cUs();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aon
 * JD-Core Version:    0.7.0.1
 */