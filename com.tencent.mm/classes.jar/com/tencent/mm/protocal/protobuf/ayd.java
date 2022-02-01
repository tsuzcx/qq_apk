package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ayd
  extends com.tencent.mm.cd.a
{
  public String SKy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230693);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SKy != null) {
        paramVarArgs.f(1, this.SKy);
      }
      AppMethodBeat.o(230693);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SKy == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.g(1, this.SKy) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(230693);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230693);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ayd localayd = (ayd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(230693);
          return -1;
        }
        localayd.SKy = locala.abFh.readString();
        AppMethodBeat.o(230693);
        return 0;
      }
      AppMethodBeat.o(230693);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayd
 * JD-Core Version:    0.7.0.1
 */