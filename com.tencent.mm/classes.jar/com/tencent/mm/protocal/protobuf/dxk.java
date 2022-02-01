package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxk
  extends com.tencent.mm.bw.a
{
  public int FileSize;
  public String MD5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32450);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MD5 != null) {
        paramVarArgs.e(1, this.MD5);
      }
      paramVarArgs.aM(2, this.FileSize);
      AppMethodBeat.o(32450);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = g.a.a.b.b.a.f(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.FileSize);
      AppMethodBeat.o(32450);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32450);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dxk localdxk = (dxk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32450);
          return -1;
        case 1: 
          localdxk.MD5 = locala.UbS.readString();
          AppMethodBeat.o(32450);
          return 0;
        }
        localdxk.FileSize = locala.UbS.zi();
        AppMethodBeat.o(32450);
        return 0;
      }
      AppMethodBeat.o(32450);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxk
 * JD-Core Version:    0.7.0.1
 */