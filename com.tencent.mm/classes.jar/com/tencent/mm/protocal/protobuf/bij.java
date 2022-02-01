package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bij
  extends com.tencent.mm.bw.a
{
  public String dHx;
  public String dOe;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181501);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dOe != null) {
        paramVarArgs.e(1, this.dOe);
      }
      if (this.dHx != null) {
        paramVarArgs.e(2, this.dHx);
      }
      paramVarArgs.aM(3, this.scene);
      AppMethodBeat.o(181501);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dOe == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.dOe) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dHx != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.dHx);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.scene);
      AppMethodBeat.o(181501);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(181501);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bij localbij = (bij)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(181501);
          return -1;
        case 1: 
          localbij.dOe = locala.UbS.readString();
          AppMethodBeat.o(181501);
          return 0;
        case 2: 
          localbij.dHx = locala.UbS.readString();
          AppMethodBeat.o(181501);
          return 0;
        }
        localbij.scene = locala.UbS.zi();
        AppMethodBeat.o(181501);
        return 0;
      }
      AppMethodBeat.o(181501);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bij
 * JD-Core Version:    0.7.0.1
 */