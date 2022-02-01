package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class esc
  extends com.tencent.mm.cd.a
{
  public String CRg;
  public String Izj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6437);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CRg != null) {
        paramVarArgs.f(1, this.CRg);
      }
      if (this.Izj != null) {
        paramVarArgs.f(2, this.Izj);
      }
      AppMethodBeat.o(6437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CRg == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = g.a.a.b.b.a.g(1, this.CRg) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Izj != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Izj);
      }
      AppMethodBeat.o(6437);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(6437);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        esc localesc = (esc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6437);
          return -1;
        case 1: 
          localesc.CRg = locala.abFh.readString();
          AppMethodBeat.o(6437);
          return 0;
        }
        localesc.Izj = locala.abFh.readString();
        AppMethodBeat.o(6437);
        return 0;
      }
      AppMethodBeat.o(6437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esc
 * JD-Core Version:    0.7.0.1
 */