package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aeh
  extends com.tencent.mm.cd.a
{
  public String OMa;
  public String OMe;
  public String OTk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91429);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.OMa != null) {
        paramVarArgs.f(1, this.OMa);
      }
      if (this.OTk != null) {
        paramVarArgs.f(2, this.OTk);
      }
      if (this.OMe != null) {
        paramVarArgs.f(3, this.OMe);
      }
      AppMethodBeat.o(91429);
      return 0;
    }
    if (paramInt == 1) {
      if (this.OMa == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.OMa) + 0;; i = 0)
    {
      paramInt = i;
      if (this.OTk != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.OTk);
      }
      i = paramInt;
      if (this.OMe != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.OMe);
      }
      AppMethodBeat.o(91429);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91429);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aeh localaeh = (aeh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91429);
          return -1;
        case 1: 
          localaeh.OMa = locala.abFh.readString();
          AppMethodBeat.o(91429);
          return 0;
        case 2: 
          localaeh.OTk = locala.abFh.readString();
          AppMethodBeat.o(91429);
          return 0;
        }
        localaeh.OMe = locala.abFh.readString();
        AppMethodBeat.o(91429);
        return 0;
      }
      AppMethodBeat.o(91429);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aeh
 * JD-Core Version:    0.7.0.1
 */