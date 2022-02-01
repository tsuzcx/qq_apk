package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbx
  extends com.tencent.mm.bw.a
{
  public String xMX;
  public int xNF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133188);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xMX != null) {
        paramVarArgs.e(1, this.xMX);
      }
      paramVarArgs.aM(2, this.xNF);
      AppMethodBeat.o(133188);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xMX == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = g.a.a.b.b.a.f(1, this.xMX) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.xNF);
      AppMethodBeat.o(133188);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(133188);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dbx localdbx = (dbx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133188);
          return -1;
        case 1: 
          localdbx.xMX = locala.UbS.readString();
          AppMethodBeat.o(133188);
          return 0;
        }
        localdbx.xNF = locala.UbS.zi();
        AppMethodBeat.o(133188);
        return 0;
      }
      AppMethodBeat.o(133188);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbx
 * JD-Core Version:    0.7.0.1
 */