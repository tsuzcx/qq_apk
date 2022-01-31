package com.tencent.mm.e.a;

public final class al
  extends com.tencent.mm.d.a
{
  public String VN;
  public int WA;
  public boolean WB;
  public boolean WC;
  public com.tencent.mm.d.b Wo;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.VN == null) {
        throw new a.a.a.b("Not all required fields were included: Talker");
      }
      if (this.VN != null) {
        paramVarArgs.d(1, this.VN);
      }
      paramVarArgs.aq(2, this.WA);
      if (this.Wo != null) {
        paramVarArgs.c(3, this.Wo);
      }
      paramVarArgs.g(4, this.WB);
      paramVarArgs.g(5, this.WC);
      return 0;
    }
    if (paramInt == 1) {
      if (this.VN == null) {
        break label356;
      }
    }
    label356:
    for (paramInt = a.a.a.b.b.a.e(1, this.VN) + 0;; paramInt = 0)
    {
      int i = paramInt + a.a.a.a.ak(2, this.WA);
      paramInt = i;
      if (this.Wo != null) {
        paramInt = i + a.a.a.a.a(3, this.Wo);
      }
      return paramInt + (a.a.a.b.b.a.cp(4) + 1) + (a.a.a.b.b.a.cp(5) + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Vj);
        for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.oz();
          }
        }
        if (this.VN != null) {
          break;
        }
        throw new a.a.a.b("Not all required fields were included: Talker");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        al localal = (al)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localal.VN = locala.ou();
          return 0;
        case 2: 
          localal.WA = locala.ot();
          return 0;
        case 3: 
          localal.Wo = locala.ox();
          return 0;
        case 4: 
          localal.WB = locala.ov();
          return 0;
        }
        localal.WC = locala.ov();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.al
 * JD-Core Version:    0.7.0.1
 */