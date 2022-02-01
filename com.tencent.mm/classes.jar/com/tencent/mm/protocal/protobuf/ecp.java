package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ecp
  extends com.tencent.mm.bw.a
{
  public String FXI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188964);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FXI != null) {
        paramVarArgs.d(1, this.FXI);
      }
      AppMethodBeat.o(188964);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FXI == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.FXI) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(188964);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(188964);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ecp localecp = (ecp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(188964);
          return -1;
        }
        localecp.FXI = locala.OmT.readString();
        AppMethodBeat.o(188964);
        return 0;
      }
      AppMethodBeat.o(188964);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecp
 * JD-Core Version:    0.7.0.1
 */