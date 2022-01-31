package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cby
  extends com.tencent.mm.bv.a
{
  public int FileSize;
  public String wQr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28652);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wQr != null) {
        paramVarArgs.e(1, this.wQr);
      }
      paramVarArgs.aO(2, this.FileSize);
      AppMethodBeat.o(28652);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wQr == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = e.a.a.b.b.a.f(1, this.wQr) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.FileSize);
      AppMethodBeat.o(28652);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28652);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cby localcby = (cby)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28652);
          return -1;
        case 1: 
          localcby.wQr = locala.CLY.readString();
          AppMethodBeat.o(28652);
          return 0;
        }
        localcby.FileSize = locala.CLY.sl();
        AppMethodBeat.o(28652);
        return 0;
      }
      AppMethodBeat.o(28652);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cby
 * JD-Core Version:    0.7.0.1
 */