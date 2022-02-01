package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebd
  extends com.tencent.mm.bw.a
{
  public int IgQ;
  public String script;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147794);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.script != null) {
        paramVarArgs.d(1, this.script);
      }
      paramVarArgs.aS(2, this.IgQ);
      AppMethodBeat.o(147794);
      return 0;
    }
    if (paramInt == 1) {
      if (this.script == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.script) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.IgQ);
      AppMethodBeat.o(147794);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(147794);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ebd localebd = (ebd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147794);
          return -1;
        case 1: 
          localebd.script = locala.OmT.readString();
          AppMethodBeat.o(147794);
          return 0;
        }
        localebd.IgQ = locala.OmT.zc();
        AppMethodBeat.o(147794);
        return 0;
      }
      AppMethodBeat.o(147794);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebd
 * JD-Core Version:    0.7.0.1
 */