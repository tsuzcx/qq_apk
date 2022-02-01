package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class diz
  extends com.tencent.mm.bw.a
{
  public String MNe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127292);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MNe != null) {
        paramVarArgs.e(1, this.MNe);
      }
      AppMethodBeat.o(127292);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MNe == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.f(1, this.MNe) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(127292);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(127292);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        diz localdiz = (diz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127292);
          return -1;
        }
        localdiz.MNe = locala.UbS.readString();
        AppMethodBeat.o(127292);
        return 0;
      }
      AppMethodBeat.o(127292);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.diz
 * JD-Core Version:    0.7.0.1
 */