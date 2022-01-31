package com.tencent.mm.protocal.c;

public final class brk
  extends com.tencent.mm.bv.a
{
  public String bZc;
  public int ioG;
  public int sKM;
  public long tIh;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bZc != null) {
        paramVarArgs.d(1, this.bZc);
      }
      paramVarArgs.gB(2, this.ioG);
      paramVarArgs.gB(3, this.sKM);
      paramVarArgs.Y(4, this.tIh);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bZc == null) {
        break label284;
      }
    }
    label284:
    for (paramInt = d.a.a.b.b.a.e(1, this.bZc) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.ioG) + d.a.a.a.gy(3, this.sKM) + d.a.a.a.X(4, this.tIh);
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
        brk localbrk = (brk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbrk.bZc = locala.xpH.readString();
          return 0;
        case 2: 
          localbrk.ioG = locala.xpH.oD();
          return 0;
        case 3: 
          localbrk.sKM = locala.xpH.oD();
          return 0;
        }
        localbrk.tIh = locala.xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.brk
 * JD-Core Version:    0.7.0.1
 */