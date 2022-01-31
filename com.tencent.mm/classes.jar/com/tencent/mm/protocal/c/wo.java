package com.tencent.mm.protocal.c;

public final class wo
  extends com.tencent.mm.bv.a
{
  public int sTo;
  public String sTp;
  public String sTq;
  public String sTr;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sTo);
      if (this.sTp != null) {
        paramVarArgs.d(2, this.sTp);
      }
      if (this.sTq != null) {
        paramVarArgs.d(3, this.sTq);
      }
      if (this.sTr != null) {
        paramVarArgs.d(4, this.sTr);
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
      i = d.a.a.a.gy(1, this.sTo) + 0;
      paramInt = i;
      if (this.sTp != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sTp);
      }
      i = paramInt;
      if (this.sTq != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sTq);
      }
      paramInt = i;
    } while (this.sTr == null);
    return i + d.a.a.b.b.a.e(4, this.sTr);
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
      wo localwo = (wo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localwo.sTo = locala.xpH.oD();
        return 0;
      case 2: 
        localwo.sTp = locala.xpH.readString();
        return 0;
      case 3: 
        localwo.sTq = locala.xpH.readString();
        return 0;
      }
      localwo.sTr = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.wo
 * JD-Core Version:    0.7.0.1
 */