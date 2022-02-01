package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class aso
  extends com.tencent.mm.bx.a
{
  public String ZCN;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153271);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title == null)
      {
        paramVarArgs = new b("Not all required fields were included: title");
        AppMethodBeat.o(153271);
        throw paramVarArgs;
      }
      if (this.ZCN == null)
      {
        paramVarArgs = new b("Not all required fields were included: jumpurl_prefix");
        AppMethodBeat.o(153271);
        throw paramVarArgs;
      }
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.ZCN != null) {
        paramVarArgs.g(2, this.ZCN);
      }
      AppMethodBeat.o(153271);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZCN != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZCN);
      }
      AppMethodBeat.o(153271);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.title == null)
        {
          paramVarArgs = new b("Not all required fields were included: title");
          AppMethodBeat.o(153271);
          throw paramVarArgs;
        }
        if (this.ZCN == null)
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
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aso localaso = (aso)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153271);
          return -1;
        case 1: 
          localaso.title = locala.ajGk.readString();
          AppMethodBeat.o(153271);
          return 0;
        }
        localaso.ZCN = locala.ajGk.readString();
        AppMethodBeat.o(153271);
        return 0;
      }
      AppMethodBeat.o(153271);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aso
 * JD-Core Version:    0.7.0.1
 */