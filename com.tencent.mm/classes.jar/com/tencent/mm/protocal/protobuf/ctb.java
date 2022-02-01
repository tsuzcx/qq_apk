package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ctb
  extends com.tencent.mm.bw.a
{
  public String Eel;
  public long FvQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117911);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eel == null)
      {
        paramVarArgs = new b("Not all required fields were included: Query");
        AppMethodBeat.o(117911);
        throw paramVarArgs;
      }
      if (this.Eel != null) {
        paramVarArgs.d(1, this.Eel);
      }
      paramVarArgs.aO(2, this.FvQ);
      AppMethodBeat.o(117911);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Eel == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.Eel) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.FvQ);
      AppMethodBeat.o(117911);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Eel == null)
        {
          paramVarArgs = new b("Not all required fields were included: Query");
          AppMethodBeat.o(117911);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117911);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ctb localctb = (ctb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117911);
          return -1;
        case 1: 
          localctb.Eel = locala.LVo.readString();
          AppMethodBeat.o(117911);
          return 0;
        }
        localctb.FvQ = locala.LVo.xG();
        AppMethodBeat.o(117911);
        return 0;
      }
      AppMethodBeat.o(117911);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctb
 * JD-Core Version:    0.7.0.1
 */