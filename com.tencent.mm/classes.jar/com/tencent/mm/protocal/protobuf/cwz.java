package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cwz
  extends com.tencent.mm.bv.a
{
  public String Username;
  public String lGH;
  public boolean yeI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28733);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(28733);
        throw paramVarArgs;
      }
      if (this.lGH == null)
      {
        paramVarArgs = new b("Not all required fields were included: Language");
        AppMethodBeat.o(28733);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.e(1, this.Username);
      }
      if (this.lGH != null) {
        paramVarArgs.e(2, this.lGH);
      }
      paramVarArgs.aS(3, this.yeI);
      AppMethodBeat.o(28733);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = e.a.a.b.b.a.f(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lGH != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.lGH);
      }
      paramInt = e.a.a.b.b.a.eW(3);
      AppMethodBeat.o(28733);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.Username == null)
        {
          paramVarArgs = new b("Not all required fields were included: Username");
          AppMethodBeat.o(28733);
          throw paramVarArgs;
        }
        if (this.lGH == null)
        {
          paramVarArgs = new b("Not all required fields were included: Language");
          AppMethodBeat.o(28733);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28733);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cwz localcwz = (cwz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28733);
          return -1;
        case 1: 
          localcwz.Username = locala.CLY.readString();
          AppMethodBeat.o(28733);
          return 0;
        case 2: 
          localcwz.lGH = locala.CLY.readString();
          AppMethodBeat.o(28733);
          return 0;
        }
        localcwz.yeI = locala.CLY.emu();
        AppMethodBeat.o(28733);
        return 0;
      }
      AppMethodBeat.o(28733);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwz
 * JD-Core Version:    0.7.0.1
 */