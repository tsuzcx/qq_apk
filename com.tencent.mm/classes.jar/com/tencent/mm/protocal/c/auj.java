package com.tencent.mm.protocal.c;

public final class auj
  extends com.tencent.mm.bv.a
{
  public String jwY;
  public double sDm;
  public double sDn;
  public String tpW;
  public String tpX;
  public String tpY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.b(1, this.sDn);
      paramVarArgs.b(2, this.sDm);
      if (this.jwY != null) {
        paramVarArgs.d(3, this.jwY);
      }
      if (this.tpW != null) {
        paramVarArgs.d(4, this.tpW);
      }
      if (this.tpX != null) {
        paramVarArgs.d(5, this.tpX);
      }
      if (this.tpY != null) {
        paramVarArgs.d(6, this.tpY);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.b.b.a.dQ(1) + 8 + 0 + (d.a.a.b.b.a.dQ(2) + 8);
      paramInt = i;
      if (this.jwY != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.jwY);
      }
      i = paramInt;
      if (this.tpW != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.tpW);
      }
      paramInt = i;
      if (this.tpX != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tpX);
      }
      i = paramInt;
    } while (this.tpY == null);
    return paramInt + d.a.a.b.b.a.e(6, this.tpY);
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
      auj localauj = (auj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localauj.sDn = locala.xpH.readDouble();
        return 0;
      case 2: 
        localauj.sDm = locala.xpH.readDouble();
        return 0;
      case 3: 
        localauj.jwY = locala.xpH.readString();
        return 0;
      case 4: 
        localauj.tpW = locala.xpH.readString();
        return 0;
      case 5: 
        localauj.tpX = locala.xpH.readString();
        return 0;
      }
      localauj.tpY = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.auj
 * JD-Core Version:    0.7.0.1
 */