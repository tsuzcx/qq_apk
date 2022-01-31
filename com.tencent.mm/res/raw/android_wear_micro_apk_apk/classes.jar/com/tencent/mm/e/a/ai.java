package com.tencent.mm.e.a;

public final class ai
  extends com.tencent.mm.d.a
{
  public String VN;
  public com.tencent.mm.d.b Wo;
  public int Ws;
  public long Wu;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.VN == null) {
        throw new a.a.a.b("Not all required fields were included: Talker");
      }
      if (this.Wo == null) {
        throw new a.a.a.b("Not all required fields were included: VoiceData");
      }
      if (this.VN != null) {
        paramVarArgs.d(1, this.VN);
      }
      paramVarArgs.g(2, this.Wu);
      if (this.Wo != null) {
        paramVarArgs.c(3, this.Wo);
      }
      paramVarArgs.aq(4, this.Ws);
      return 0;
    }
    if (paramInt == 1) {
      if (this.VN == null) {
        break label360;
      }
    }
    label360:
    for (paramInt = a.a.a.b.b.a.e(1, this.VN) + 0;; paramInt = 0)
    {
      int i = paramInt + a.a.a.a.e(2, this.Wu);
      paramInt = i;
      if (this.Wo != null) {
        paramInt = i + a.a.a.a.a(3, this.Wo);
      }
      return paramInt + a.a.a.a.ak(4, this.Ws);
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Vj);
        for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.oz();
          }
        }
        if (this.VN == null) {
          throw new a.a.a.b("Not all required fields were included: Talker");
        }
        if (this.Wo != null) {
          break;
        }
        throw new a.a.a.b("Not all required fields were included: VoiceData");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        ai localai = (ai)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localai.VN = locala.ou();
          return 0;
        case 2: 
          localai.Wu = locala.ow();
          return 0;
        case 3: 
          localai.Wo = locala.ox();
          return 0;
        }
        localai.Ws = locala.ot();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.ai
 * JD-Core Version:    0.7.0.1
 */