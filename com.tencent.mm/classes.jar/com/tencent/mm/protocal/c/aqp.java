package com.tencent.mm.protocal.c;

public final class aqp
  extends com.tencent.mm.bv.a
{
  public String hPY;
  public int tmx;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPY != null) {
        paramVarArgs.d(1, this.hPY);
      }
      paramVarArgs.gB(2, this.tmx);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hPY == null) {
        break label212;
      }
    }
    label212:
    for (paramInt = d.a.a.b.b.a.e(1, this.hPY) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.tmx);
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
        aqp localaqp = (aqp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaqp.hPY = locala.xpH.readString();
          return 0;
        }
        localaqp.tmx = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aqp
 * JD-Core Version:    0.7.0.1
 */