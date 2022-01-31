package com.tencent.mm.protocal.c;

public final class cki
  extends com.tencent.mm.bv.a
{
  public int pyo;
  public com.tencent.mm.bv.b sxO;
  public long tXK;
  public String tXp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tXp == null) {
        throw new d.a.a.b("Not all required fields were included: Talker");
      }
      if (this.sxO == null) {
        throw new d.a.a.b("Not all required fields were included: VoiceData");
      }
      if (this.tXp != null) {
        paramVarArgs.d(1, this.tXp);
      }
      paramVarArgs.Y(2, this.tXK);
      if (this.sxO != null) {
        paramVarArgs.b(3, this.sxO);
      }
      paramVarArgs.gB(4, this.pyo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tXp == null) {
        break label373;
      }
    }
    label373:
    for (paramInt = d.a.a.b.b.a.e(1, this.tXp) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.X(2, this.tXK);
      paramInt = i;
      if (this.sxO != null) {
        paramInt = i + d.a.a.a.a(3, this.sxO);
      }
      return paramInt + d.a.a.a.gy(4, this.pyo);
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
        if (this.sxO != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: VoiceData");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cki localcki = (cki)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcki.tXp = locala.xpH.readString();
          return 0;
        case 2: 
          localcki.tXK = locala.xpH.oE();
          return 0;
        case 3: 
          localcki.sxO = locala.cUs();
          return 0;
        }
        localcki.pyo = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cki
 * JD-Core Version:    0.7.0.1
 */