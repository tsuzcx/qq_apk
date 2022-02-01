package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rk
  extends com.tencent.mm.bx.a
{
  public int CRs;
  public int CRt;
  public String CRu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113972);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CRs);
      paramVarArgs.aR(2, this.CRt);
      if (this.CRu != null) {
        paramVarArgs.d(3, this.CRu);
      }
      AppMethodBeat.o(113972);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.CRs) + 0 + f.a.a.b.b.a.bA(2, this.CRt);
      paramInt = i;
      if (this.CRu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CRu);
      }
      AppMethodBeat.o(113972);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(113972);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      rk localrk = (rk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113972);
        return -1;
      case 1: 
        localrk.CRs = locala.KhF.xS();
        AppMethodBeat.o(113972);
        return 0;
      case 2: 
        localrk.CRt = locala.KhF.xS();
        AppMethodBeat.o(113972);
        return 0;
      }
      localrk.CRu = locala.KhF.readString();
      AppMethodBeat.o(113972);
      return 0;
    }
    AppMethodBeat.o(113972);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rk
 * JD-Core Version:    0.7.0.1
 */