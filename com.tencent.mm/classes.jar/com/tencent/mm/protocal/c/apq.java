package com.tencent.mm.protocal.c;

public final class apq
  extends com.tencent.mm.bv.a
{
  public String kVZ;
  public float sDX;
  public float sDY;
  public float tlH;
  public String tlI;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.m(1, this.sDX);
      paramVarArgs.m(2, this.sDY);
      paramVarArgs.m(3, this.tlH);
      if (this.kVZ != null) {
        paramVarArgs.d(4, this.kVZ);
      }
      if (this.tlI != null) {
        paramVarArgs.d(5, this.tlI);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.b.b.a.dQ(1) + 4 + 0 + (d.a.a.b.b.a.dQ(2) + 4) + (d.a.a.b.b.a.dQ(3) + 4);
      paramInt = i;
      if (this.kVZ != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kVZ);
      }
      i = paramInt;
    } while (this.tlI == null);
    return paramInt + d.a.a.b.b.a.e(5, this.tlI);
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
      apq localapq = (apq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localapq.sDX = locala.xpH.readFloat();
        return 0;
      case 2: 
        localapq.sDY = locala.xpH.readFloat();
        return 0;
      case 3: 
        localapq.tlH = locala.xpH.readFloat();
        return 0;
      case 4: 
        localapq.kVZ = locala.xpH.readString();
        return 0;
      }
      localapq.tlI = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.apq
 * JD-Core Version:    0.7.0.1
 */