package com.tencent.mm.protocal.c;

public final class vd
  extends com.tencent.mm.bv.a
{
  public int Height;
  public int Width;
  public String lsF;
  public String sRS;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.lsF != null) {
        paramVarArgs.d(1, this.lsF);
      }
      paramVarArgs.gB(2, this.Width);
      paramVarArgs.gB(3, this.Height);
      if (this.sRS != null) {
        paramVarArgs.d(4, this.sRS);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.lsF == null) {
        break label308;
      }
    }
    label308:
    for (paramInt = d.a.a.b.b.a.e(1, this.lsF) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.Width) + d.a.a.a.gy(3, this.Height);
      paramInt = i;
      if (this.sRS != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sRS);
      }
      return paramInt;
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
        vd localvd = (vd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localvd.lsF = locala.xpH.readString();
          return 0;
        case 2: 
          localvd.Width = locala.xpH.oD();
          return 0;
        case 3: 
          localvd.Height = locala.xpH.oD();
          return 0;
        }
        localvd.sRS = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.vd
 * JD-Core Version:    0.7.0.1
 */