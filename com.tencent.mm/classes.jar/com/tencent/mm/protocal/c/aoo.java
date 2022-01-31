package com.tencent.mm.protocal.c;

public final class aoo
  extends com.tencent.mm.bv.a
{
  public long tkl;
  public int tkm;
  public long tkn;
  public int tko;
  public long tkp;
  public int tkq;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.Y(1, this.tkl);
      paramVarArgs.gB(2, this.tkm);
      paramVarArgs.Y(3, this.tkn);
      paramVarArgs.gB(4, this.tko);
      paramVarArgs.Y(5, this.tkp);
      paramVarArgs.gB(6, this.tkq);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.X(1, this.tkl) + 0 + d.a.a.a.gy(2, this.tkm) + d.a.a.a.X(3, this.tkn) + d.a.a.a.gy(4, this.tko) + d.a.a.a.X(5, this.tkp) + d.a.a.a.gy(6, this.tkq);
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
      aoo localaoo = (aoo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localaoo.tkl = locala.xpH.oE();
        return 0;
      case 2: 
        localaoo.tkm = locala.xpH.oD();
        return 0;
      case 3: 
        localaoo.tkn = locala.xpH.oE();
        return 0;
      case 4: 
        localaoo.tko = locala.xpH.oD();
        return 0;
      case 5: 
        localaoo.tkp = locala.xpH.oE();
        return 0;
      }
      localaoo.tkq = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aoo
 * JD-Core Version:    0.7.0.1
 */