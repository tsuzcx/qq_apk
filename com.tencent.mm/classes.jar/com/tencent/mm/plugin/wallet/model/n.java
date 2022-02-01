package com.tencent.mm.plugin.wallet.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bx.a
{
  public String Vlq;
  public int id;
  public String nUS;
  public String name;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91302);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.id);
      if (this.name != null) {
        paramVarArgs.g(2, this.name);
      }
      if (this.url != null) {
        paramVarArgs.g(3, this.url);
      }
      if (this.Vlq != null) {
        paramVarArgs.g(4, this.Vlq);
      }
      if (this.nUS != null) {
        paramVarArgs.g(5, this.nUS);
      }
      AppMethodBeat.o(91302);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.id) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.name);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.url);
      }
      paramInt = i;
      if (this.Vlq != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Vlq);
      }
      i = paramInt;
      if (this.nUS != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.nUS);
      }
      AppMethodBeat.o(91302);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91302);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91302);
        return -1;
      case 1: 
        localn.id = locala.ajGk.aar();
        AppMethodBeat.o(91302);
        return 0;
      case 2: 
        localn.name = locala.ajGk.readString();
        AppMethodBeat.o(91302);
        return 0;
      case 3: 
        localn.url = locala.ajGk.readString();
        AppMethodBeat.o(91302);
        return 0;
      case 4: 
        localn.Vlq = locala.ajGk.readString();
        AppMethodBeat.o(91302);
        return 0;
      }
      localn.nUS = locala.ajGk.readString();
      AppMethodBeat.o(91302);
      return 0;
    }
    AppMethodBeat.o(91302);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.model.n
 * JD-Core Version:    0.7.0.1
 */