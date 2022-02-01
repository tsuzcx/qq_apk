package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class abk
  extends com.tencent.mm.bw.a
{
  public String iod;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152535);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iod == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152535);
        throw paramVarArgs;
      }
      if (this.iod != null) {
        paramVarArgs.d(1, this.iod);
      }
      AppMethodBeat.o(152535);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iod == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = f.a.a.b.b.a.e(1, this.iod) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(152535);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.iod == null)
        {
          paramVarArgs = new b("Not all required fields were included: tp_username");
          AppMethodBeat.o(152535);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152535);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        abk localabk = (abk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152535);
          return -1;
        }
        localabk.iod = locala.LVo.readString();
        AppMethodBeat.o(152535);
        return 0;
      }
      AppMethodBeat.o(152535);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abk
 * JD-Core Version:    0.7.0.1
 */