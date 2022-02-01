package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aph
  extends com.tencent.mm.cd.a
{
  public String desc;
  public String llI;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91465);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.llI != null) {
        paramVarArgs.f(1, this.llI);
      }
      if (this.title != null) {
        paramVarArgs.f(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.f(3, this.desc);
      }
      AppMethodBeat.o(91465);
      return 0;
    }
    if (paramInt == 1) {
      if (this.llI == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.llI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.desc);
      }
      AppMethodBeat.o(91465);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91465);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aph localaph = (aph)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91465);
          return -1;
        case 1: 
          localaph.llI = locala.abFh.readString();
          AppMethodBeat.o(91465);
          return 0;
        case 2: 
          localaph.title = locala.abFh.readString();
          AppMethodBeat.o(91465);
          return 0;
        }
        localaph.desc = locala.abFh.readString();
        AppMethodBeat.o(91465);
        return 0;
      }
      AppMethodBeat.o(91465);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aph
 * JD-Core Version:    0.7.0.1
 */