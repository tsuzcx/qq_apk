package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzr
  extends com.tencent.mm.bw.a
{
  public String Mfl;
  public int Mfm;
  public int Mfn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43097);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mfl != null) {
        paramVarArgs.e(1, this.Mfl);
      }
      paramVarArgs.aM(2, this.Mfm);
      paramVarArgs.aM(3, this.Mfn);
      AppMethodBeat.o(43097);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mfl == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.f(1, this.Mfl) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.Mfm);
      int j = g.a.a.b.b.a.bu(3, this.Mfn);
      AppMethodBeat.o(43097);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(43097);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bzr localbzr = (bzr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43097);
          return -1;
        case 1: 
          localbzr.Mfl = locala.UbS.readString();
          AppMethodBeat.o(43097);
          return 0;
        case 2: 
          localbzr.Mfm = locala.UbS.zi();
          AppMethodBeat.o(43097);
          return 0;
        }
        localbzr.Mfn = locala.UbS.zi();
        AppMethodBeat.o(43097);
        return 0;
      }
      AppMethodBeat.o(43097);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzr
 * JD-Core Version:    0.7.0.1
 */