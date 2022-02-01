package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mt
  extends com.tencent.mm.bx.a
{
  public String CHL;
  public int CJH;
  public int CJI;
  public long CJJ;
  public String CJK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124433);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CJH);
      paramVarArgs.aR(2, this.CJI);
      paramVarArgs.aG(3, this.CJJ);
      if (this.CJK != null) {
        paramVarArgs.d(4, this.CJK);
      }
      if (this.CHL != null) {
        paramVarArgs.d(5, this.CHL);
      }
      AppMethodBeat.o(124433);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.CJH) + 0 + f.a.a.b.b.a.bA(2, this.CJI) + f.a.a.b.b.a.q(3, this.CJJ);
      paramInt = i;
      if (this.CJK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CJK);
      }
      i = paramInt;
      if (this.CHL != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CHL);
      }
      AppMethodBeat.o(124433);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(124433);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      mt localmt = (mt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124433);
        return -1;
      case 1: 
        localmt.CJH = locala.KhF.xS();
        AppMethodBeat.o(124433);
        return 0;
      case 2: 
        localmt.CJI = locala.KhF.xS();
        AppMethodBeat.o(124433);
        return 0;
      case 3: 
        localmt.CJJ = locala.KhF.xT();
        AppMethodBeat.o(124433);
        return 0;
      case 4: 
        localmt.CJK = locala.KhF.readString();
        AppMethodBeat.o(124433);
        return 0;
      }
      localmt.CHL = locala.KhF.readString();
      AppMethodBeat.o(124433);
      return 0;
    }
    AppMethodBeat.o(124433);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mt
 * JD-Core Version:    0.7.0.1
 */