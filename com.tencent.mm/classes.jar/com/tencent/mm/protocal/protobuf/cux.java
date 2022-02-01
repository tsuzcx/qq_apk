package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cux
  extends com.tencent.mm.cd.a
{
  public String oDJ;
  public String oDK;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72513);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.f(1, this.wording);
      }
      if (this.oDJ != null) {
        paramVarArgs.f(2, this.oDJ);
      }
      if (this.oDK != null) {
        paramVarArgs.f(4, this.oDK);
      }
      AppMethodBeat.o(72513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label338;
      }
    }
    label338:
    for (int i = g.a.a.b.b.a.g(1, this.wording) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oDJ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.oDJ);
      }
      i = paramInt;
      if (this.oDK != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.oDK);
      }
      AppMethodBeat.o(72513);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72513);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cux localcux = (cux)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 3: 
        default: 
          AppMethodBeat.o(72513);
          return -1;
        case 1: 
          localcux.wording = locala.abFh.readString();
          AppMethodBeat.o(72513);
          return 0;
        case 2: 
          localcux.oDJ = locala.abFh.readString();
          AppMethodBeat.o(72513);
          return 0;
        }
        localcux.oDK = locala.abFh.readString();
        AppMethodBeat.o(72513);
        return 0;
      }
      AppMethodBeat.o(72513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cux
 * JD-Core Version:    0.7.0.1
 */