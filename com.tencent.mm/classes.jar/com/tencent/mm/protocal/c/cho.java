package com.tencent.mm.protocal.c;

public final class cho
  extends com.tencent.mm.bv.a
{
  public String ffq;
  public String tWr;
  public int tWs;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tWr != null) {
        paramVarArgs.d(1, this.tWr);
      }
      if (this.ffq != null) {
        paramVarArgs.d(2, this.ffq);
      }
      paramVarArgs.gB(3, this.tWs);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tWr == null) {
        break label269;
      }
    }
    label269:
    for (paramInt = d.a.a.b.b.a.e(1, this.tWr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ffq != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.ffq);
      }
      return i + d.a.a.a.gy(3, this.tWs);
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
        cho localcho = (cho)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcho.tWr = locala.xpH.readString();
          return 0;
        case 2: 
          localcho.ffq = locala.xpH.readString();
          return 0;
        }
        localcho.tWs = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cho
 * JD-Core Version:    0.7.0.1
 */