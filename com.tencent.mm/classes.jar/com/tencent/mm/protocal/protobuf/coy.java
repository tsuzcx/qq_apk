package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class coy
  extends com.tencent.mm.cd.a
{
  public String Izj;
  public String TwI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32334);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Izj != null) {
        paramVarArgs.f(1, this.Izj);
      }
      if (this.TwI != null) {
        paramVarArgs.f(2, this.TwI);
      }
      AppMethodBeat.o(32334);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Izj == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = g.a.a.b.b.a.g(1, this.Izj) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TwI != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TwI);
      }
      AppMethodBeat.o(32334);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32334);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        coy localcoy = (coy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32334);
          return -1;
        case 1: 
          localcoy.Izj = locala.abFh.readString();
          AppMethodBeat.o(32334);
          return 0;
        }
        localcoy.TwI = locala.abFh.readString();
        AppMethodBeat.o(32334);
        return 0;
      }
      AppMethodBeat.o(32334);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coy
 * JD-Core Version:    0.7.0.1
 */