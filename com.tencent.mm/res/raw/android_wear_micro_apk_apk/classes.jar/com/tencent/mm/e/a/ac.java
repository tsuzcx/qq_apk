package com.tencent.mm.e.a;

public final class ac
  extends com.tencent.mm.d.a
{
  public long VO;
  public com.tencent.mm.d.b Wo;
  public int Wp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.Wo == null) {
        throw new a.a.a.b("Not all required fields were included: VoiceData");
      }
      paramVarArgs.g(1, this.VO);
      if (this.Wo != null) {
        paramVarArgs.c(2, this.Wo);
      }
      paramVarArgs.aq(3, this.Wp);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.e(1, this.VO) + 0;
      paramInt = i;
      if (this.Wo != null) {
        paramInt = i + a.a.a.a.a(2, this.Wo);
      }
      return paramInt + a.a.a.a.ak(3, this.Wp);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Vj);
      for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.oz();
        }
      }
      if (this.Wo == null) {
        throw new a.a.a.b("Not all required fields were included: VoiceData");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      ac localac = (ac)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localac.VO = locala.ow();
        return 0;
      case 2: 
        localac.Wo = locala.ox();
        return 0;
      }
      localac.Wp = locala.ot();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.ac
 * JD-Core Version:    0.7.0.1
 */