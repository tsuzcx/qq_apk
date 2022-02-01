package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class anu
  extends com.tencent.mm.bw.a
{
  public String Lzu;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153271);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title == null)
      {
        paramVarArgs = new b("Not all required fields were included: title");
        AppMethodBeat.o(153271);
        throw paramVarArgs;
      }
      if (this.Lzu == null)
      {
        paramVarArgs = new b("Not all required fields were included: jumpurl_prefix");
        AppMethodBeat.o(153271);
        throw paramVarArgs;
      }
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.Lzu != null) {
        paramVarArgs.e(2, this.Lzu);
      }
      AppMethodBeat.o(153271);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.b.b.a.f(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Lzu != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Lzu);
      }
      AppMethodBeat.o(153271);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.title == null)
        {
          paramVarArgs = new b("Not all required fields were included: title");
          AppMethodBeat.o(153271);
          throw paramVarArgs;
        }
        if (this.Lzu == null)
        {
          paramVarArgs = new b("Not all required fields were included: jumpurl_prefix");
          AppMethodBeat.o(153271);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153271);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        anu localanu = (anu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153271);
          return -1;
        case 1: 
          localanu.title = locala.UbS.readString();
          AppMethodBeat.o(153271);
          return 0;
        }
        localanu.Lzu = locala.UbS.readString();
        AppMethodBeat.o(153271);
        return 0;
      }
      AppMethodBeat.o(153271);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anu
 * JD-Core Version:    0.7.0.1
 */