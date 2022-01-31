package com.tencent.mm.protocal.c;

public final class de
  extends com.tencent.mm.bv.a
{
  public String euK;
  public int hQR;
  public int swt;
  public String swu;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.euK != null) {
        paramVarArgs.d(1, this.euK);
      }
      paramVarArgs.gB(2, this.hQR);
      paramVarArgs.gB(3, this.swt);
      if (this.swu != null) {
        paramVarArgs.d(4, this.swu);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.euK == null) {
        break label308;
      }
    }
    label308:
    for (paramInt = d.a.a.b.b.a.e(1, this.euK) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.hQR) + d.a.a.a.gy(3, this.swt);
      paramInt = i;
      if (this.swu != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.swu);
      }
      return paramInt;
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
        de localde = (de)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localde.euK = locala.xpH.readString();
          return 0;
        case 2: 
          localde.hQR = locala.xpH.oD();
          return 0;
        case 3: 
          localde.swt = locala.xpH.oD();
          return 0;
        }
        localde.swu = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.de
 * JD-Core Version:    0.7.0.1
 */