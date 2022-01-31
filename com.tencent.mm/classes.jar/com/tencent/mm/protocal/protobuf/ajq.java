package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class ajq
  extends com.tencent.mm.bv.a
{
  public String wQg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62551);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wQg == null)
      {
        paramVarArgs = new b("Not all required fields were included: DesignerID");
        AppMethodBeat.o(62551);
        throw paramVarArgs;
      }
      if (this.wQg != null) {
        paramVarArgs.e(1, this.wQg);
      }
      AppMethodBeat.o(62551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wQg == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = e.a.a.b.b.a.f(1, this.wQg) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(62551);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wQg == null)
        {
          paramVarArgs = new b("Not all required fields were included: DesignerID");
          AppMethodBeat.o(62551);
          throw paramVarArgs;
        }
        AppMethodBeat.o(62551);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ajq localajq = (ajq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(62551);
          return -1;
        }
        localajq.wQg = locala.CLY.readString();
        AppMethodBeat.o(62551);
        return 0;
      }
      AppMethodBeat.o(62551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajq
 * JD-Core Version:    0.7.0.1
 */