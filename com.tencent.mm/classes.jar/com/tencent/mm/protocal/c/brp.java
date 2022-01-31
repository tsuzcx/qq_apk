package com.tencent.mm.protocal.c;

public final class brp
  extends com.tencent.mm.bv.a
{
  public int Height;
  public int Width;
  public String sRE;
  public String tFz;
  public String tIk;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sRE != null) {
        paramVarArgs.d(1, this.sRE);
      }
      paramVarArgs.gB(2, this.Width);
      paramVarArgs.gB(3, this.Height);
      if (this.tFz != null) {
        paramVarArgs.d(4, this.tFz);
      }
      if (this.tIk != null) {
        paramVarArgs.d(5, this.tIk);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sRE == null) {
        break label363;
      }
    }
    label363:
    for (paramInt = d.a.a.b.b.a.e(1, this.sRE) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.Width) + d.a.a.a.gy(3, this.Height);
      paramInt = i;
      if (this.tFz != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tFz);
      }
      i = paramInt;
      if (this.tIk != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tIk);
      }
      return i;
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
        brp localbrp = (brp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbrp.sRE = locala.xpH.readString();
          return 0;
        case 2: 
          localbrp.Width = locala.xpH.oD();
          return 0;
        case 3: 
          localbrp.Height = locala.xpH.oD();
          return 0;
        case 4: 
          localbrp.tFz = locala.xpH.readString();
          return 0;
        }
        localbrp.tIk = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.brp
 * JD-Core Version:    0.7.0.1
 */