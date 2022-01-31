package com.tencent.mm.protocal.c;

public final class bro
  extends com.tencent.mm.bv.a
{
  public String URL;
  public String bGw;
  public String kVH;
  public String sRE;
  public String sxZ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.URL != null) {
        paramVarArgs.d(1, this.URL);
      }
      if (this.bGw != null) {
        paramVarArgs.d(2, this.bGw);
      }
      if (this.sxZ != null) {
        paramVarArgs.d(3, this.sxZ);
      }
      if (this.kVH != null) {
        paramVarArgs.d(4, this.kVH);
      }
      if (this.sRE != null) {
        paramVarArgs.d(5, this.sRE);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.URL == null) {
        break label399;
      }
    }
    label399:
    for (int i = d.a.a.b.b.a.e(1, this.URL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bGw != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bGw);
      }
      i = paramInt;
      if (this.sxZ != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sxZ);
      }
      paramInt = i;
      if (this.kVH != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kVH);
      }
      i = paramInt;
      if (this.sRE != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sRE);
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
        bro localbro = (bro)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbro.URL = locala.xpH.readString();
          return 0;
        case 2: 
          localbro.bGw = locala.xpH.readString();
          return 0;
        case 3: 
          localbro.sxZ = locala.xpH.readString();
          return 0;
        case 4: 
          localbro.kVH = locala.xpH.readString();
          return 0;
        }
        localbro.sRE = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bro
 * JD-Core Version:    0.7.0.1
 */