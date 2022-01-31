package com.tencent.mm.protocal.c;

public final class apk
  extends com.tencent.mm.bv.a
{
  public String tlw;
  public String tlx;
  public int tly;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tlw != null) {
        paramVarArgs.d(1, this.tlw);
      }
      if (this.tlx != null) {
        paramVarArgs.d(2, this.tlx);
      }
      paramVarArgs.gB(3, this.tly);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tlw == null) {
        break label269;
      }
    }
    label269:
    for (paramInt = d.a.a.b.b.a.e(1, this.tlw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tlx != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tlx);
      }
      return i + d.a.a.a.gy(3, this.tly);
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
        apk localapk = (apk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localapk.tlw = locala.xpH.readString();
          return 0;
        case 2: 
          localapk.tlx = locala.xpH.readString();
          return 0;
        }
        localapk.tly = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.apk
 * JD-Core Version:    0.7.0.1
 */