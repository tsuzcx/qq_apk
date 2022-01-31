package com.tencent.mm.protocal.c;

public final class bcg
  extends com.tencent.mm.bv.a
{
  public String bZc;
  public String inb;
  public int txJ;
  public int txK;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bZc != null) {
        paramVarArgs.d(1, this.bZc);
      }
      if (this.inb != null) {
        paramVarArgs.d(2, this.inb);
      }
      paramVarArgs.gB(3, this.txJ);
      paramVarArgs.gB(4, this.txK);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bZc == null) {
        break label308;
      }
    }
    label308:
    for (paramInt = d.a.a.b.b.a.e(1, this.bZc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.inb != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.inb);
      }
      return i + d.a.a.a.gy(3, this.txJ) + d.a.a.a.gy(4, this.txK);
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
        bcg localbcg = (bcg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbcg.bZc = locala.xpH.readString();
          return 0;
        case 2: 
          localbcg.inb = locala.xpH.readString();
          return 0;
        case 3: 
          localbcg.txJ = locala.xpH.oD();
          return 0;
        }
        localbcg.txK = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bcg
 * JD-Core Version:    0.7.0.1
 */