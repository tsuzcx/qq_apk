package com.tencent.mm.protocal.c;

public final class cka
  extends com.tencent.mm.bv.a
{
  public int tMt;
  public String tWr;
  public com.tencent.mm.bv.b tXF;
  public com.tencent.mm.bv.b tXG;
  public String tXH;
  public String tXI;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tWr == null) {
        throw new d.a.a.b("Not all required fields were included: Msg");
      }
      paramVarArgs.gB(1, this.tMt);
      if (this.tWr != null) {
        paramVarArgs.d(2, this.tWr);
      }
      if (this.tXF != null) {
        paramVarArgs.b(3, this.tXF);
      }
      if (this.tXG != null) {
        paramVarArgs.b(4, this.tXG);
      }
      if (this.tXH != null) {
        paramVarArgs.d(5, this.tXH);
      }
      if (this.tXI != null) {
        paramVarArgs.d(6, this.tXI);
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
      i = d.a.a.a.gy(1, this.tMt) + 0;
      paramInt = i;
      if (this.tWr != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tWr);
      }
      i = paramInt;
      if (this.tXF != null) {
        i = paramInt + d.a.a.a.a(3, this.tXF);
      }
      paramInt = i;
      if (this.tXG != null) {
        paramInt = i + d.a.a.a.a(4, this.tXG);
      }
      i = paramInt;
      if (this.tXH != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tXH);
      }
      paramInt = i;
    } while (this.tXI == null);
    return i + d.a.a.b.b.a.e(6, this.tXI);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.tWr == null) {
        throw new d.a.a.b("Not all required fields were included: Msg");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      cka localcka = (cka)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcka.tMt = locala.xpH.oD();
        return 0;
      case 2: 
        localcka.tWr = locala.xpH.readString();
        return 0;
      case 3: 
        localcka.tXF = locala.cUs();
        return 0;
      case 4: 
        localcka.tXG = locala.cUs();
        return 0;
      case 5: 
        localcka.tXH = locala.xpH.readString();
        return 0;
      }
      localcka.tXI = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cka
 * JD-Core Version:    0.7.0.1
 */