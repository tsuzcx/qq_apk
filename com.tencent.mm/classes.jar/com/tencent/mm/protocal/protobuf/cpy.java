package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cpy
  extends com.tencent.mm.bv.a
{
  public String gfL;
  public String gfU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80205);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.gfL == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(80205);
        throw paramVarArgs;
      }
      if (this.gfU == null)
      {
        paramVarArgs = new b("Not all required fields were included: verify_ticket");
        AppMethodBeat.o(80205);
        throw paramVarArgs;
      }
      if (this.gfL != null) {
        paramVarArgs.e(1, this.gfL);
      }
      if (this.gfU != null) {
        paramVarArgs.e(2, this.gfU);
      }
      AppMethodBeat.o(80205);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gfL == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = e.a.a.b.b.a.f(1, this.gfL) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gfU != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.gfU);
      }
      AppMethodBeat.o(80205);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.gfL == null)
        {
          paramVarArgs = new b("Not all required fields were included: tp_username");
          AppMethodBeat.o(80205);
          throw paramVarArgs;
        }
        if (this.gfU == null)
        {
          paramVarArgs = new b("Not all required fields were included: verify_ticket");
          AppMethodBeat.o(80205);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80205);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cpy localcpy = (cpy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(80205);
          return -1;
        case 1: 
          localcpy.gfL = locala.CLY.readString();
          AppMethodBeat.o(80205);
          return 0;
        }
        localcpy.gfU = locala.CLY.readString();
        AppMethodBeat.o(80205);
        return 0;
      }
      AppMethodBeat.o(80205);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpy
 * JD-Core Version:    0.7.0.1
 */