package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bdn
  extends com.tencent.mm.bv.a
{
  public int qsl;
  public String wot;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118280);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wot != null) {
        paramVarArgs.e(1, this.wot);
      }
      paramVarArgs.aO(2, this.qsl);
      AppMethodBeat.o(118280);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wot == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = e.a.a.b.b.a.f(1, this.wot) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.qsl);
      AppMethodBeat.o(118280);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(118280);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bdn localbdn = (bdn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118280);
          return -1;
        case 1: 
          localbdn.wot = locala.CLY.readString();
          AppMethodBeat.o(118280);
          return 0;
        }
        localbdn.qsl = locala.CLY.sl();
        AppMethodBeat.o(118280);
        return 0;
      }
      AppMethodBeat.o(118280);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdn
 * JD-Core Version:    0.7.0.1
 */