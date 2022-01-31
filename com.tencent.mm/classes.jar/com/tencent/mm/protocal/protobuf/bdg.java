package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bdg
  extends com.tencent.mm.bv.a
{
  public String cwc;
  public String qkL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(126192);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cwc != null) {
        paramVarArgs.e(1, this.cwc);
      }
      if (this.qkL != null) {
        paramVarArgs.e(2, this.qkL);
      }
      AppMethodBeat.o(126192);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cwc == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.cwc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.qkL != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.qkL);
      }
      AppMethodBeat.o(126192);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(126192);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bdg localbdg = (bdg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(126192);
          return -1;
        case 1: 
          localbdg.cwc = locala.CLY.readString();
          AppMethodBeat.o(126192);
          return 0;
        }
        localbdg.qkL = locala.CLY.readString();
        AppMethodBeat.o(126192);
        return 0;
      }
      AppMethodBeat.o(126192);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdg
 * JD-Core Version:    0.7.0.1
 */