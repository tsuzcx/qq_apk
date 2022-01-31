package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class bmh
  extends com.tencent.mm.bv.a
{
  public String xAL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60061);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xAL == null)
      {
        paramVarArgs = new b("Not all required fields were included: PhoneNum");
        AppMethodBeat.o(60061);
        throw paramVarArgs;
      }
      if (this.xAL != null) {
        paramVarArgs.e(1, this.xAL);
      }
      AppMethodBeat.o(60061);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xAL == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = e.a.a.b.b.a.f(1, this.xAL) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(60061);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xAL == null)
        {
          paramVarArgs = new b("Not all required fields were included: PhoneNum");
          AppMethodBeat.o(60061);
          throw paramVarArgs;
        }
        AppMethodBeat.o(60061);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bmh localbmh = (bmh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(60061);
          return -1;
        }
        localbmh.xAL = locala.CLY.readString();
        AppMethodBeat.o(60061);
        return 0;
      }
      AppMethodBeat.o(60061);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmh
 * JD-Core Version:    0.7.0.1
 */