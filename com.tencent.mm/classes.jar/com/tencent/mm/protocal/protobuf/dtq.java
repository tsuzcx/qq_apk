package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dtq
  extends com.tencent.mm.bx.a
{
  public int CHC;
  public String EIm;
  public String EIn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123682);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CHC);
      if (this.EIm != null) {
        paramVarArgs.d(2, this.EIm);
      }
      if (this.EIn != null) {
        paramVarArgs.d(3, this.EIn);
      }
      AppMethodBeat.o(123682);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.CHC) + 0;
      paramInt = i;
      if (this.EIm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EIm);
      }
      i = paramInt;
      if (this.EIn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EIn);
      }
      AppMethodBeat.o(123682);
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
      AppMethodBeat.o(123682);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dtq localdtq = (dtq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123682);
        return -1;
      case 1: 
        localdtq.CHC = locala.KhF.xS();
        AppMethodBeat.o(123682);
        return 0;
      case 2: 
        localdtq.EIm = locala.KhF.readString();
        AppMethodBeat.o(123682);
        return 0;
      }
      localdtq.EIn = locala.KhF.readString();
      AppMethodBeat.o(123682);
      return 0;
    }
    AppMethodBeat.o(123682);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtq
 * JD-Core Version:    0.7.0.1
 */