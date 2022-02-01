package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ffp
  extends com.tencent.mm.bw.a
{
  public int NAI;
  public String ixr;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32574);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ixr == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankid");
        AppMethodBeat.o(32574);
        throw paramVarArgs;
      }
      if (this.title == null)
      {
        paramVarArgs = new b("Not all required fields were included: title");
        AppMethodBeat.o(32574);
        throw paramVarArgs;
      }
      if (this.ixr != null) {
        paramVarArgs.e(1, this.ixr);
      }
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      paramVarArgs.aM(3, this.NAI);
      AppMethodBeat.o(32574);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ixr == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = g.a.a.b.b.a.f(1, this.ixr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.title);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.NAI);
      AppMethodBeat.o(32574);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.ixr == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankid");
          AppMethodBeat.o(32574);
          throw paramVarArgs;
        }
        if (this.title == null)
        {
          paramVarArgs = new b("Not all required fields were included: title");
          AppMethodBeat.o(32574);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32574);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ffp localffp = (ffp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32574);
          return -1;
        case 1: 
          localffp.ixr = locala.UbS.readString();
          AppMethodBeat.o(32574);
          return 0;
        case 2: 
          localffp.title = locala.UbS.readString();
          AppMethodBeat.o(32574);
          return 0;
        }
        localffp.NAI = locala.UbS.zi();
        AppMethodBeat.o(32574);
        return 0;
      }
      AppMethodBeat.o(32574);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffp
 * JD-Core Version:    0.7.0.1
 */