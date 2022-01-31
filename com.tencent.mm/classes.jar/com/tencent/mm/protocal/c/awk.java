package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class awk
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String mQp;
  public int sYX;
  public String sYY;
  public int tsZ;
  public int tta;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.mQp == null) {
        throw new b("Not all required fields were included: ThumbUrl");
      }
      paramVarArgs.gB(1, this.tsZ);
      if (this.bGw != null) {
        paramVarArgs.d(2, this.bGw);
      }
      if (this.mQp != null) {
        paramVarArgs.d(3, this.mQp);
      }
      paramVarArgs.gB(4, this.sYX);
      if (this.sYY != null) {
        paramVarArgs.d(5, this.sYY);
      }
      paramVarArgs.gB(6, this.tta);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.tsZ) + 0;
      paramInt = i;
      if (this.bGw != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bGw);
      }
      i = paramInt;
      if (this.mQp != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.mQp);
      }
      i += d.a.a.a.gy(4, this.sYX);
      paramInt = i;
      if (this.sYY != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sYY);
      }
      return paramInt + d.a.a.a.gy(6, this.tta);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.bGw == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.mQp == null) {
        throw new b("Not all required fields were included: ThumbUrl");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      awk localawk = (awk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localawk.tsZ = locala.xpH.oD();
        return 0;
      case 2: 
        localawk.bGw = locala.xpH.readString();
        return 0;
      case 3: 
        localawk.mQp = locala.xpH.readString();
        return 0;
      case 4: 
        localawk.sYX = locala.xpH.oD();
        return 0;
      case 5: 
        localawk.sYY = locala.xpH.readString();
        return 0;
      }
      localawk.tta = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.awk
 * JD-Core Version:    0.7.0.1
 */