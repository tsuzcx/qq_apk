package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bva
  extends com.tencent.mm.bw.a
{
  public String FVV;
  public String FVW;
  public String FVX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43103);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FVW != null) {
        paramVarArgs.d(1, this.FVW);
      }
      if (this.FVV != null) {
        paramVarArgs.d(2, this.FVV);
      }
      if (this.FVX != null) {
        paramVarArgs.d(3, this.FVX);
      }
      AppMethodBeat.o(43103);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FVW == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.FVW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FVV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FVV);
      }
      i = paramInt;
      if (this.FVX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FVX);
      }
      AppMethodBeat.o(43103);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(43103);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bva localbva = (bva)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43103);
          return -1;
        case 1: 
          localbva.FVW = locala.OmT.readString();
          AppMethodBeat.o(43103);
          return 0;
        case 2: 
          localbva.FVV = locala.OmT.readString();
          AppMethodBeat.o(43103);
          return 0;
        }
        localbva.FVX = locala.OmT.readString();
        AppMethodBeat.o(43103);
        return 0;
      }
      AppMethodBeat.o(43103);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bva
 * JD-Core Version:    0.7.0.1
 */