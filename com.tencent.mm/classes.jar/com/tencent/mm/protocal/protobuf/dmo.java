package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmo
  extends com.tencent.mm.cd.a
{
  public String REl;
  public int TTS;
  public String TTT;
  public String URL;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208834);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.URL != null) {
        paramVarArgs.f(2, this.URL);
      }
      paramVarArgs.aY(3, this.TTS);
      if (this.TTT != null) {
        paramVarArgs.f(4, this.TTT);
      }
      if (this.REl != null) {
        paramVarArgs.f(5, this.REl);
      }
      AppMethodBeat.o(208834);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = g.a.a.b.b.a.g(1, this.fwr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.URL != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.URL);
      }
      i += g.a.a.b.b.a.bM(3, this.TTS);
      paramInt = i;
      if (this.TTT != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TTT);
      }
      i = paramInt;
      if (this.REl != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.REl);
      }
      AppMethodBeat.o(208834);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(208834);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dmo localdmo = (dmo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(208834);
          return -1;
        case 1: 
          localdmo.fwr = locala.abFh.readString();
          AppMethodBeat.o(208834);
          return 0;
        case 2: 
          localdmo.URL = locala.abFh.readString();
          AppMethodBeat.o(208834);
          return 0;
        case 3: 
          localdmo.TTS = locala.abFh.AK();
          AppMethodBeat.o(208834);
          return 0;
        case 4: 
          localdmo.TTT = locala.abFh.readString();
          AppMethodBeat.o(208834);
          return 0;
        }
        localdmo.REl = locala.abFh.readString();
        AppMethodBeat.o(208834);
        return 0;
      }
      AppMethodBeat.o(208834);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmo
 * JD-Core Version:    0.7.0.1
 */