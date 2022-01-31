package com.tencent.mm.protocal.c;

public final class avi
  extends com.tencent.mm.bv.a
{
  public int hQR;
  public String sEb;
  public String sFF;
  public int scene;
  public long tqP;
  public long tqQ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.scene);
      if (this.sEb != null) {
        paramVarArgs.d(2, this.sEb);
      }
      paramVarArgs.Y(3, this.tqP);
      paramVarArgs.Y(4, this.tqQ);
      if (this.sFF != null) {
        paramVarArgs.d(5, this.sFF);
      }
      paramVarArgs.gB(6, this.hQR);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.scene) + 0;
      paramInt = i;
      if (this.sEb != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sEb);
      }
      i = paramInt + d.a.a.a.X(3, this.tqP) + d.a.a.a.X(4, this.tqQ);
      paramInt = i;
      if (this.sFF != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sFF);
      }
      return paramInt + d.a.a.a.gy(6, this.hQR);
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
      avi localavi = (avi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localavi.scene = locala.xpH.oD();
        return 0;
      case 2: 
        localavi.sEb = locala.xpH.readString();
        return 0;
      case 3: 
        localavi.tqP = locala.xpH.oE();
        return 0;
      case 4: 
        localavi.tqQ = locala.xpH.oE();
        return 0;
      case 5: 
        localavi.sFF = locala.xpH.readString();
        return 0;
      }
      localavi.hQR = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.avi
 * JD-Core Version:    0.7.0.1
 */