package com.tencent.mm.protocal.c;

public final class vi
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kRN;
  public String sRZ;
  public String sSa;
  public String sSb;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      if (this.sRZ != null) {
        paramVarArgs.d(2, this.sRZ);
      }
      if (this.sSa != null) {
        paramVarArgs.d(3, this.sSa);
      }
      if (this.kRN != null) {
        paramVarArgs.d(4, this.kRN);
      }
      if (this.sSb != null) {
        paramVarArgs.d(5, this.sSb);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bGw == null) {
        break label399;
      }
    }
    label399:
    for (int i = d.a.a.b.b.a.e(1, this.bGw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sRZ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sRZ);
      }
      i = paramInt;
      if (this.sSa != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sSa);
      }
      paramInt = i;
      if (this.kRN != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kRN);
      }
      i = paramInt;
      if (this.sSb != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sSb);
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
        vi localvi = (vi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localvi.bGw = locala.xpH.readString();
          return 0;
        case 2: 
          localvi.sRZ = locala.xpH.readString();
          return 0;
        case 3: 
          localvi.sSa = locala.xpH.readString();
          return 0;
        case 4: 
          localvi.kRN = locala.xpH.readString();
          return 0;
        }
        localvi.sSb = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.vi
 * JD-Core Version:    0.7.0.1
 */