package com.tencent.mm.protocal.c;

public final class ccq
  extends com.tencent.mm.bv.a
{
  public int state;
  public int tRH;
  public String tmz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tmz != null) {
        paramVarArgs.d(1, this.tmz);
      }
      paramVarArgs.gB(2, this.state);
      paramVarArgs.gB(3, this.tRH);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tmz == null) {
        break label246;
      }
    }
    label246:
    for (paramInt = d.a.a.b.b.a.e(1, this.tmz) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.state) + d.a.a.a.gy(3, this.tRH);
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
        ccq localccq = (ccq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localccq.tmz = locala.xpH.readString();
          return 0;
        case 2: 
          localccq.state = locala.xpH.oD();
          return 0;
        }
        localccq.tRH = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ccq
 * JD-Core Version:    0.7.0.1
 */