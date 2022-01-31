package com.tencent.mm.protocal.c;

public final class bio
  extends com.tencent.mm.bv.a
{
  public String hPY;
  public String hRf;
  public String sRZ;
  public String sUr;
  public String tac;
  public int tzC;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPY != null) {
        paramVarArgs.d(1, this.hPY);
      }
      paramVarArgs.gB(2, this.tzC);
      if (this.hRf != null) {
        paramVarArgs.d(3, this.hRf);
      }
      if (this.sRZ != null) {
        paramVarArgs.d(4, this.sRZ);
      }
      if (this.sUr != null) {
        paramVarArgs.d(5, this.sUr);
      }
      if (this.tac != null) {
        paramVarArgs.d(6, this.tac);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.hPY == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = d.a.a.b.b.a.e(1, this.hPY) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tzC);
      paramInt = i;
      if (this.hRf != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.hRf);
      }
      i = paramInt;
      if (this.sRZ != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.sRZ);
      }
      paramInt = i;
      if (this.sUr != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sUr);
      }
      i = paramInt;
      if (this.tac != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.tac);
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
        bio localbio = (bio)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbio.hPY = locala.xpH.readString();
          return 0;
        case 2: 
          localbio.tzC = locala.xpH.oD();
          return 0;
        case 3: 
          localbio.hRf = locala.xpH.readString();
          return 0;
        case 4: 
          localbio.sRZ = locala.xpH.readString();
          return 0;
        case 5: 
          localbio.sUr = locala.xpH.readString();
          return 0;
        }
        localbio.tac = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bio
 * JD-Core Version:    0.7.0.1
 */