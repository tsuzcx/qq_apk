package com.tencent.mm.protocal.c;

public final class ato
  extends com.tencent.mm.bv.a
{
  public float sGJ;
  public float sGK;
  public int sUn;
  public String sUo;
  public String sUp;
  public int sUq;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.m(1, this.sGJ);
      paramVarArgs.m(2, this.sGK);
      paramVarArgs.gB(3, this.sUn);
      if (this.sUo != null) {
        paramVarArgs.d(4, this.sUo);
      }
      if (this.sUp != null) {
        paramVarArgs.d(5, this.sUp);
      }
      paramVarArgs.gB(6, this.sUq);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.b.b.a.dQ(1) + 4 + 0 + (d.a.a.b.b.a.dQ(2) + 4) + d.a.a.a.gy(3, this.sUn);
      paramInt = i;
      if (this.sUo != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sUo);
      }
      i = paramInt;
      if (this.sUp != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sUp);
      }
      return i + d.a.a.a.gy(6, this.sUq);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      ato localato = (ato)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localato.sGJ = locala.xpH.readFloat();
        return 0;
      case 2: 
        localato.sGK = locala.xpH.readFloat();
        return 0;
      case 3: 
        localato.sUn = locala.xpH.oD();
        return 0;
      case 4: 
        localato.sUo = locala.xpH.readString();
        return 0;
      case 5: 
        localato.sUp = locala.xpH.readString();
        return 0;
      }
      localato.sUq = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ato
 * JD-Core Version:    0.7.0.1
 */