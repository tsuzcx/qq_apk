package com.tencent.mm.protocal.c;

public final class aqa
  extends com.tencent.mm.bv.a
{
  public String kSz;
  public String mSC;
  public int sML;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sML);
      if (this.mSC != null) {
        paramVarArgs.d(2, this.mSC);
      }
      if (this.kSz != null) {
        paramVarArgs.d(3, this.kSz);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.sML) + 0;
      paramInt = i;
      if (this.mSC != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.mSC);
      }
      i = paramInt;
    } while (this.kSz == null);
    return paramInt + d.a.a.b.b.a.e(3, this.kSz);
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
      aqa localaqa = (aqa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localaqa.sML = locala.xpH.oD();
        return 0;
      case 2: 
        localaqa.mSC = locala.xpH.readString();
        return 0;
      }
      localaqa.kSz = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aqa
 * JD-Core Version:    0.7.0.1
 */