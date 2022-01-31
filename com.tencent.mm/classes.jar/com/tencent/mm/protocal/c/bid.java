package com.tencent.mm.protocal.c;

public final class bid
  extends com.tencent.mm.bv.a
{
  public String info;
  public int sQC;
  public int sQD;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sQC);
      paramVarArgs.gB(2, this.sQD);
      if (this.info != null) {
        paramVarArgs.d(3, this.info);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.sQC) + 0 + d.a.a.a.gy(2, this.sQD);
      paramInt = i;
    } while (this.info == null);
    return i + d.a.a.b.b.a.e(3, this.info);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      bid localbid = (bid)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbid.sQC = locala.xpH.oD();
        return 0;
      case 2: 
        localbid.sQD = locala.xpH.oD();
        return 0;
      }
      localbid.info = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bid
 * JD-Core Version:    0.7.0.1
 */