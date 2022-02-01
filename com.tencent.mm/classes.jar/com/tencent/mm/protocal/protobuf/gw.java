package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gw
  extends com.tencent.mm.bx.a
{
  public String CBK;
  public String CBL;
  public String dca;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123549);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CBK != null) {
        paramVarArgs.d(1, this.CBK);
      }
      if (this.CBL != null) {
        paramVarArgs.d(2, this.CBL);
      }
      if (this.dca != null) {
        paramVarArgs.d(3, this.dca);
      }
      AppMethodBeat.o(123549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CBK == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.CBK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CBL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CBL);
      }
      i = paramInt;
      if (this.dca != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dca);
      }
      AppMethodBeat.o(123549);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123549);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        gw localgw = (gw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123549);
          return -1;
        case 1: 
          localgw.CBK = locala.KhF.readString();
          AppMethodBeat.o(123549);
          return 0;
        case 2: 
          localgw.CBL = locala.KhF.readString();
          AppMethodBeat.o(123549);
          return 0;
        }
        localgw.dca = locala.KhF.readString();
        AppMethodBeat.o(123549);
        return 0;
      }
      AppMethodBeat.o(123549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gw
 * JD-Core Version:    0.7.0.1
 */