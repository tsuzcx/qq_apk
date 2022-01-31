package com.tencent.mm.protocal.c;

public final class bbn
  extends com.tencent.mm.bv.a
{
  public String ePQ;
  public int txo;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ePQ != null) {
        paramVarArgs.d(1, this.ePQ);
      }
      paramVarArgs.gB(2, this.txo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ePQ == null) {
        break label212;
      }
    }
    label212:
    for (paramInt = d.a.a.b.b.a.e(1, this.ePQ) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.txo);
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
        bbn localbbn = (bbn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbbn.ePQ = locala.xpH.readString();
          return 0;
        }
        localbbn.txo = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bbn
 * JD-Core Version:    0.7.0.1
 */