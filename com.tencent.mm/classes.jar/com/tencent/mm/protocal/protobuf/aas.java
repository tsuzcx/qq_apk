package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aas
  extends com.tencent.mm.bw.a
{
  public String Lma;
  public String sGE;
  public String sGQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196086);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.sGQ != null) {
        paramVarArgs.e(1, this.sGQ);
      }
      if (this.sGE != null) {
        paramVarArgs.e(2, this.sGE);
      }
      if (this.Lma != null) {
        paramVarArgs.e(3, this.Lma);
      }
      AppMethodBeat.o(196086);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sGQ == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.sGQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sGE != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.sGE);
      }
      i = paramInt;
      if (this.Lma != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Lma);
      }
      AppMethodBeat.o(196086);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(196086);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aas localaas = (aas)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(196086);
          return -1;
        case 1: 
          localaas.sGQ = locala.UbS.readString();
          AppMethodBeat.o(196086);
          return 0;
        case 2: 
          localaas.sGE = locala.UbS.readString();
          AppMethodBeat.o(196086);
          return 0;
        }
        localaas.Lma = locala.UbS.readString();
        AppMethodBeat.o(196086);
        return 0;
      }
      AppMethodBeat.o(196086);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aas
 * JD-Core Version:    0.7.0.1
 */