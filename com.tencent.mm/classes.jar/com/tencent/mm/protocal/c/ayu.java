package com.tencent.mm.protocal.c;

public final class ayu
  extends com.tencent.mm.bv.a
{
  public int kSW;
  public String kWm;
  public String kWn;
  public int ndm;
  public long ndp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kWn != null) {
        paramVarArgs.d(1, this.kWn);
      }
      if (this.kWm != null) {
        paramVarArgs.d(2, this.kWm);
      }
      paramVarArgs.gB(3, this.ndm);
      paramVarArgs.gB(4, this.kSW);
      paramVarArgs.Y(5, this.ndp);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kWn == null) {
        break label343;
      }
    }
    label343:
    for (paramInt = d.a.a.b.b.a.e(1, this.kWn) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kWm != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kWm);
      }
      return i + d.a.a.a.gy(3, this.ndm) + d.a.a.a.gy(4, this.kSW) + d.a.a.a.X(5, this.ndp);
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
        ayu localayu = (ayu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localayu.kWn = locala.xpH.readString();
          return 0;
        case 2: 
          localayu.kWm = locala.xpH.readString();
          return 0;
        case 3: 
          localayu.ndm = locala.xpH.oD();
          return 0;
        case 4: 
          localayu.kSW = locala.xpH.oD();
          return 0;
        }
        localayu.ndp = locala.xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ayu
 * JD-Core Version:    0.7.0.1
 */