package com.tencent.mm.protocal.c;

public final class ays
  extends com.tencent.mm.bv.a
{
  public String tuA;
  public int tuB;
  public int tuC;
  public int tuD;
  public int tuE;
  public String tuz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tuz != null) {
        paramVarArgs.d(1, this.tuz);
      }
      if (this.tuA != null) {
        paramVarArgs.d(2, this.tuA);
      }
      paramVarArgs.gB(3, this.tuB);
      paramVarArgs.gB(4, this.tuC);
      paramVarArgs.gB(5, this.tuD);
      paramVarArgs.gB(7, this.tuE);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tuz == null) {
        break label386;
      }
    }
    label386:
    for (paramInt = d.a.a.b.b.a.e(1, this.tuz) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tuA != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tuA);
      }
      return i + d.a.a.a.gy(3, this.tuB) + d.a.a.a.gy(4, this.tuC) + d.a.a.a.gy(5, this.tuD) + d.a.a.a.gy(7, this.tuE);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        ays localays = (ays)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 6: 
        default: 
          return -1;
        case 1: 
          localays.tuz = locala.xpH.readString();
          return 0;
        case 2: 
          localays.tuA = locala.xpH.readString();
          return 0;
        case 3: 
          localays.tuB = locala.xpH.oD();
          return 0;
        case 4: 
          localays.tuC = locala.xpH.oD();
          return 0;
        case 5: 
          localays.tuD = locala.xpH.oD();
          return 0;
        }
        localays.tuE = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ays
 * JD-Core Version:    0.7.0.1
 */