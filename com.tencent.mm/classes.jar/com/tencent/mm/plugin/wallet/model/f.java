package com.tencent.mm.plugin.wallet.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.bx.a
{
  public String Vlr;
  public String Vls;
  public String Vlt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91290);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Vlr != null) {
        paramVarArgs.g(1, this.Vlr);
      }
      if (this.Vls != null) {
        paramVarArgs.g(2, this.Vls);
      }
      if (this.Vlt != null) {
        paramVarArgs.g(3, this.Vlt);
      }
      AppMethodBeat.o(91290);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Vlr == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.Vlr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Vls != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Vls);
      }
      i = paramInt;
      if (this.Vlt != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Vlt);
      }
      AppMethodBeat.o(91290);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91290);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91290);
          return -1;
        case 1: 
          localf.Vlr = locala.ajGk.readString();
          AppMethodBeat.o(91290);
          return 0;
        case 2: 
          localf.Vls = locala.ajGk.readString();
          AppMethodBeat.o(91290);
          return 0;
        }
        localf.Vlt = locala.ajGk.readString();
        AppMethodBeat.o(91290);
        return 0;
      }
      AppMethodBeat.o(91290);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.model.f
 * JD-Core Version:    0.7.0.1
 */