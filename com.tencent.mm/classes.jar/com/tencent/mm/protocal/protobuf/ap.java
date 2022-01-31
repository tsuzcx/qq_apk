package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ap
  extends com.tencent.mm.bv.a
{
  public String knk;
  public String knl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89001);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.knk != null) {
        paramVarArgs.e(1, this.knk);
      }
      if (this.knl != null) {
        paramVarArgs.e(2, this.knl);
      }
      AppMethodBeat.o(89001);
      return 0;
    }
    if (paramInt == 1) {
      if (this.knk == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.knk) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.knl != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.knl);
      }
      AppMethodBeat.o(89001);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89001);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ap localap = (ap)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(89001);
          return -1;
        case 1: 
          localap.knk = locala.CLY.readString();
          AppMethodBeat.o(89001);
          return 0;
        }
        localap.knl = locala.CLY.readString();
        AppMethodBeat.o(89001);
        return 0;
      }
      AppMethodBeat.o(89001);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ap
 * JD-Core Version:    0.7.0.1
 */