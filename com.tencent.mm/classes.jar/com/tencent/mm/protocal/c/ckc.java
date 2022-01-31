package com.tencent.mm.protocal.c;

public final class ckc
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b sxO;
  public int tXJ;
  public long tXq;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sxO == null) {
        throw new d.a.a.b("Not all required fields were included: VoiceData");
      }
      paramVarArgs.Y(1, this.tXq);
      if (this.sxO != null) {
        paramVarArgs.b(2, this.sxO);
      }
      paramVarArgs.gB(3, this.tXJ);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.X(1, this.tXq) + 0;
      paramInt = i;
      if (this.sxO != null) {
        paramInt = i + d.a.a.a.a(2, this.sxO);
      }
      return paramInt + d.a.a.a.gy(3, this.tXJ);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.sxO == null) {
        throw new d.a.a.b("Not all required fields were included: VoiceData");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      ckc localckc = (ckc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localckc.tXq = locala.xpH.oE();
        return 0;
      case 2: 
        localckc.sxO = locala.cUs();
        return 0;
      }
      localckc.tXJ = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ckc
 * JD-Core Version:    0.7.0.1
 */