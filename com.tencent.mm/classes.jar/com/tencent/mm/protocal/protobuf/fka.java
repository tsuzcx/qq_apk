package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fka
  extends com.tencent.mm.cd.a
{
  public com.tencent.mm.cd.b RLr;
  public long RNj;
  public int UIX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32552);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RLr == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32552);
        throw paramVarArgs;
      }
      paramVarArgs.bm(1, this.RNj);
      if (this.RLr != null) {
        paramVarArgs.c(2, this.RLr);
      }
      paramVarArgs.aY(3, this.UIX);
      AppMethodBeat.o(32552);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.RNj) + 0;
      paramInt = i;
      if (this.RLr != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.RLr);
      }
      i = g.a.a.b.b.a.bM(3, this.UIX);
      AppMethodBeat.o(32552);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.RLr == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32552);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32552);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fka localfka = (fka)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32552);
        return -1;
      case 1: 
        localfka.RNj = locala.abFh.AN();
        AppMethodBeat.o(32552);
        return 0;
      case 2: 
        localfka.RLr = locala.abFh.iUw();
        AppMethodBeat.o(32552);
        return 0;
      }
      localfka.UIX = locala.abFh.AK();
      AppMethodBeat.o(32552);
      return 0;
    }
    AppMethodBeat.o(32552);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fka
 * JD-Core Version:    0.7.0.1
 */