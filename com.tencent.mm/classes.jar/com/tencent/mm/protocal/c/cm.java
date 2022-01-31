package com.tencent.mm.protocal.c;

public final class cm
  extends com.tencent.mm.bv.a
{
  public String ffi;
  public String ffj;
  public String ffq;
  public String hPY;
  public String kSY;
  public String svW;
  public String svX;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ffq != null) {
        paramVarArgs.d(1, this.ffq);
      }
      if (this.ffi != null) {
        paramVarArgs.d(2, this.ffi);
      }
      if (this.ffj != null) {
        paramVarArgs.d(3, this.ffj);
      }
      if (this.kSY != null) {
        paramVarArgs.d(4, this.kSY);
      }
      if (this.hPY != null) {
        paramVarArgs.d(5, this.hPY);
      }
      if (this.svW != null) {
        paramVarArgs.d(6, this.svW);
      }
      if (this.svX != null) {
        paramVarArgs.d(7, this.svX);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.ffq == null) {
        break label513;
      }
    }
    label513:
    for (int i = d.a.a.b.b.a.e(1, this.ffq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ffi != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.ffi);
      }
      i = paramInt;
      if (this.ffj != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.ffj);
      }
      paramInt = i;
      if (this.kSY != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kSY);
      }
      i = paramInt;
      if (this.hPY != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.hPY);
      }
      paramInt = i;
      if (this.svW != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.svW);
      }
      i = paramInt;
      if (this.svX != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.svX);
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
        cm localcm = (cm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcm.ffq = locala.xpH.readString();
          return 0;
        case 2: 
          localcm.ffi = locala.xpH.readString();
          return 0;
        case 3: 
          localcm.ffj = locala.xpH.readString();
          return 0;
        case 4: 
          localcm.kSY = locala.xpH.readString();
          return 0;
        case 5: 
          localcm.hPY = locala.xpH.readString();
          return 0;
        case 6: 
          localcm.svW = locala.xpH.readString();
          return 0;
        }
        localcm.svX = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cm
 * JD-Core Version:    0.7.0.1
 */