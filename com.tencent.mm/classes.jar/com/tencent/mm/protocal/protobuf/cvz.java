package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvz
  extends com.tencent.mm.bw.a
{
  public String jHa;
  public String pWh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152641);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jHa != null) {
        paramVarArgs.e(1, this.jHa);
      }
      if (this.pWh != null) {
        paramVarArgs.e(2, this.pWh);
      }
      AppMethodBeat.o(152641);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jHa == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.jHa) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pWh != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.pWh);
      }
      AppMethodBeat.o(152641);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152641);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cvz localcvz = (cvz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152641);
          return -1;
        case 1: 
          localcvz.jHa = locala.UbS.readString();
          AppMethodBeat.o(152641);
          return 0;
        }
        localcvz.pWh = locala.UbS.readString();
        AppMethodBeat.o(152641);
        return 0;
      }
      AppMethodBeat.o(152641);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvz
 * JD-Core Version:    0.7.0.1
 */