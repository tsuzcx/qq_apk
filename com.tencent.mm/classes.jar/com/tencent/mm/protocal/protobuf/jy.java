package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class jy
  extends com.tencent.mm.bv.a
{
  public b www;
  public b wwx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(836);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.www != null) {
        paramVarArgs.c(1, this.www);
      }
      if (this.wwx != null) {
        paramVarArgs.c(2, this.wwx);
      }
      AppMethodBeat.o(836);
      return 0;
    }
    if (paramInt == 1) {
      if (this.www == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = e.a.a.b.b.a.b(1, this.www) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wwx != null) {
        i = paramInt + e.a.a.b.b.a.b(2, this.wwx);
      }
      AppMethodBeat.o(836);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(836);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        jy localjy = (jy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(836);
          return -1;
        case 1: 
          localjy.www = locala.CLY.eqS();
          AppMethodBeat.o(836);
          return 0;
        }
        localjy.wwx = locala.CLY.eqS();
        AppMethodBeat.o(836);
        return 0;
      }
      AppMethodBeat.o(836);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jy
 * JD-Core Version:    0.7.0.1
 */