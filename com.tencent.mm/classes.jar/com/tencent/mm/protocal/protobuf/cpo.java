package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cpo
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String MvG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32349);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MvG != null) {
        paramVarArgs.e(1, this.MvG);
      }
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      AppMethodBeat.o(32349);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MvG == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = g.a.a.b.b.a.f(1, this.MvG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Desc != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Desc);
      }
      AppMethodBeat.o(32349);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32349);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cpo localcpo = (cpo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32349);
          return -1;
        case 1: 
          localcpo.MvG = locala.UbS.readString();
          AppMethodBeat.o(32349);
          return 0;
        }
        localcpo.Desc = locala.UbS.readString();
        AppMethodBeat.o(32349);
        return 0;
      }
      AppMethodBeat.o(32349);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpo
 * JD-Core Version:    0.7.0.1
 */