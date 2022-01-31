package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class cbw
  extends com.tencent.mm.bv.a
{
  public int Height;
  public int Width;
  public b tQW;
  public int tQX;
  public long tQY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tQW != null) {
        paramVarArgs.b(1, this.tQW);
      }
      paramVarArgs.gB(2, this.tQX);
      paramVarArgs.Y(3, this.tQY);
      paramVarArgs.gB(4, this.Width);
      paramVarArgs.gB(5, this.Height);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tQW == null) {
        break label315;
      }
    }
    label315:
    for (paramInt = d.a.a.a.a(1, this.tQW) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.tQX) + d.a.a.a.X(3, this.tQY) + d.a.a.a.gy(4, this.Width) + d.a.a.a.gy(5, this.Height);
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
        cbw localcbw = (cbw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcbw.tQW = locala.cUs();
          return 0;
        case 2: 
          localcbw.tQX = locala.xpH.oD();
          return 0;
        case 3: 
          localcbw.tQY = locala.xpH.oE();
          return 0;
        case 4: 
          localcbw.Width = locala.xpH.oD();
          return 0;
        }
        localcbw.Height = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cbw
 * JD-Core Version:    0.7.0.1
 */