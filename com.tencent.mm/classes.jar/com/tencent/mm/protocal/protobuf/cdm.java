package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cdm
  extends com.tencent.mm.bw.a
{
  public int Mjk;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32333);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      paramVarArgs.aM(2, this.Mjk);
      AppMethodBeat.o(32333);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = g.a.a.b.b.a.f(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.Mjk);
      AppMethodBeat.o(32333);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32333);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cdm localcdm = (cdm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32333);
          return -1;
        case 1: 
          localcdm.UserName = locala.UbS.readString();
          AppMethodBeat.o(32333);
          return 0;
        }
        localcdm.Mjk = locala.UbS.zi();
        AppMethodBeat.o(32333);
        return 0;
      }
      AppMethodBeat.o(32333);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdm
 * JD-Core Version:    0.7.0.1
 */