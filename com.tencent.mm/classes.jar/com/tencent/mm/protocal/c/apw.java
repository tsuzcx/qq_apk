package com.tencent.mm.protocal.c;

public final class apw
  extends com.tencent.mm.bv.a
{
  public String dCX;
  public double eyp;
  public int major;
  public int minor;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.dCX != null) {
        paramVarArgs.d(1, this.dCX);
      }
      paramVarArgs.gB(2, this.major);
      paramVarArgs.gB(3, this.minor);
      paramVarArgs.b(4, this.eyp);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dCX == null) {
        break label284;
      }
    }
    label284:
    for (paramInt = d.a.a.b.b.a.e(1, this.dCX) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.major) + d.a.a.a.gy(3, this.minor) + (d.a.a.b.b.a.dQ(4) + 8);
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
        apw localapw = (apw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localapw.dCX = locala.xpH.readString();
          return 0;
        case 2: 
          localapw.major = locala.xpH.oD();
          return 0;
        case 3: 
          localapw.minor = locala.xpH.oD();
          return 0;
        }
        localapw.eyp = locala.xpH.readDouble();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.apw
 * JD-Core Version:    0.7.0.1
 */