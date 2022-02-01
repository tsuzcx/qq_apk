package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class brc
  extends com.tencent.mm.bx.a
{
  public int fVE;
  public String vJI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43109);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.fVE);
      if (this.vJI != null) {
        paramVarArgs.d(2, this.vJI);
      }
      AppMethodBeat.o(43109);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.fVE) + 0;
      paramInt = i;
      if (this.vJI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vJI);
      }
      AppMethodBeat.o(43109);
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
      AppMethodBeat.o(43109);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      brc localbrc = (brc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43109);
        return -1;
      case 1: 
        localbrc.fVE = locala.KhF.xS();
        AppMethodBeat.o(43109);
        return 0;
      }
      localbrc.vJI = locala.KhF.readString();
      AppMethodBeat.o(43109);
      return 0;
    }
    AppMethodBeat.o(43109);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brc
 * JD-Core Version:    0.7.0.1
 */