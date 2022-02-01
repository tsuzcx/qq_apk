package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dtc
  extends com.tencent.mm.bx.a
{
  public int DLL;
  public String EHR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145672);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DLL);
      if (this.EHR != null) {
        paramVarArgs.d(2, this.EHR);
      }
      AppMethodBeat.o(145672);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.DLL) + 0;
      paramInt = i;
      if (this.EHR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EHR);
      }
      AppMethodBeat.o(145672);
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
      AppMethodBeat.o(145672);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dtc localdtc = (dtc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(145672);
        return -1;
      case 1: 
        localdtc.DLL = locala.KhF.xS();
        AppMethodBeat.o(145672);
        return 0;
      }
      localdtc.EHR = locala.KhF.readString();
      AppMethodBeat.o(145672);
      return 0;
    }
    AppMethodBeat.o(145672);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtc
 * JD-Core Version:    0.7.0.1
 */