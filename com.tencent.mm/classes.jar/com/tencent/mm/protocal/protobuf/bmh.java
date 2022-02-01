package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class bmh
  extends com.tencent.mm.bw.a
{
  public String Lsl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104787);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lsl == null)
      {
        paramVarArgs = new b("Not all required fields were included: DesignerID");
        AppMethodBeat.o(104787);
        throw paramVarArgs;
      }
      if (this.Lsl != null) {
        paramVarArgs.e(1, this.Lsl);
      }
      AppMethodBeat.o(104787);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lsl == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = g.a.a.b.b.a.f(1, this.Lsl) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(104787);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Lsl == null)
        {
          paramVarArgs = new b("Not all required fields were included: DesignerID");
          AppMethodBeat.o(104787);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104787);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bmh localbmh = (bmh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104787);
          return -1;
        }
        localbmh.Lsl = locala.UbS.readString();
        AppMethodBeat.o(104787);
        return 0;
      }
      AppMethodBeat.o(104787);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmh
 * JD-Core Version:    0.7.0.1
 */