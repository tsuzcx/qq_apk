package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class nr
  extends com.tencent.mm.cd.a
{
  public String key;
  public String lvH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206447);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(206447);
        throw paramVarArgs;
      }
      if (this.lvH == null)
      {
        paramVarArgs = new b("Not all required fields were included: val");
        AppMethodBeat.o(206447);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.f(1, this.key);
      }
      if (this.lvH != null) {
        paramVarArgs.f(2, this.lvH);
      }
      AppMethodBeat.o(206447);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.b.b.a.g(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lvH != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.lvH);
      }
      AppMethodBeat.o(206447);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(206447);
          throw paramVarArgs;
        }
        if (this.lvH == null)
        {
          paramVarArgs = new b("Not all required fields were included: val");
          AppMethodBeat.o(206447);
          throw paramVarArgs;
        }
        AppMethodBeat.o(206447);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        nr localnr = (nr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(206447);
          return -1;
        case 1: 
          localnr.key = locala.abFh.readString();
          AppMethodBeat.o(206447);
          return 0;
        }
        localnr.lvH = locala.abFh.readString();
        AppMethodBeat.o(206447);
        return 0;
      }
      AppMethodBeat.o(206447);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nr
 * JD-Core Version:    0.7.0.1
 */