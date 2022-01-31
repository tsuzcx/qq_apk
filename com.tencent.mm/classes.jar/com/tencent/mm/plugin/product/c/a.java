package com.tencent.mm.plugin.product.c;

public final class a
  extends com.tencent.mm.bv.a
{
  public int hQR;
  public String kRZ;
  public String kSy;
  public String kVs;
  public String mSC;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRZ != null) {
        paramVarArgs.d(1, this.kRZ);
      }
      if (this.mSC != null) {
        paramVarArgs.d(2, this.mSC);
      }
      paramVarArgs.gB(3, this.hQR);
      if (this.kVs != null) {
        paramVarArgs.d(4, this.kVs);
      }
      if (this.kSy != null) {
        paramVarArgs.d(5, this.kSy);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kRZ == null) {
        break label383;
      }
    }
    label383:
    for (paramInt = d.a.a.b.b.a.e(1, this.kRZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mSC != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.mSC);
      }
      i += d.a.a.a.gy(3, this.hQR);
      paramInt = i;
      if (this.kVs != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kVs);
      }
      i = paramInt;
      if (this.kSy != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.kSy);
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
        a locala1 = (a)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          locala1.kRZ = locala.xpH.readString();
          return 0;
        case 2: 
          locala1.mSC = locala.xpH.readString();
          return 0;
        case 3: 
          locala1.hQR = locala.xpH.oD();
          return 0;
        case 4: 
          locala1.kVs = locala.xpH.readString();
          return 0;
        }
        locala1.kSy = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.a
 * JD-Core Version:    0.7.0.1
 */