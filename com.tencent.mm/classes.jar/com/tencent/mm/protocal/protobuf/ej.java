package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ej
  extends com.tencent.mm.bw.a
{
  public String KIa;
  public String KIb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32115);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KIa != null) {
        paramVarArgs.e(1, this.KIa);
      }
      if (this.KIb != null) {
        paramVarArgs.e(2, this.KIb);
      }
      AppMethodBeat.o(32115);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KIa == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = g.a.a.b.b.a.f(1, this.KIa) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KIb != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KIb);
      }
      AppMethodBeat.o(32115);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32115);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ej localej = (ej)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32115);
          return -1;
        case 1: 
          localej.KIa = locala.UbS.readString();
          AppMethodBeat.o(32115);
          return 0;
        }
        localej.KIb = locala.UbS.readString();
        AppMethodBeat.o(32115);
        return 0;
      }
      AppMethodBeat.o(32115);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ej
 * JD-Core Version:    0.7.0.1
 */