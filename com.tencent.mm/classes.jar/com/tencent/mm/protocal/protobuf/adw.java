package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class adw
  extends com.tencent.mm.bw.a
{
  public String Ebg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104761);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ebg == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(104761);
        throw paramVarArgs;
      }
      if (this.Ebg != null) {
        paramVarArgs.d(1, this.Ebg);
      }
      AppMethodBeat.o(104761);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ebg == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = f.a.a.b.b.a.e(1, this.Ebg) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(104761);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Ebg == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(104761);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104761);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        adw localadw = (adw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104761);
          return -1;
        }
        localadw.Ebg = locala.LVo.readString();
        AppMethodBeat.o(104761);
        return 0;
      }
      AppMethodBeat.o(104761);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adw
 * JD-Core Version:    0.7.0.1
 */