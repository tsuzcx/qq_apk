package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ax
  extends com.tencent.mm.bx.a
{
  public long Nlt;
  public String Nlu;
  public String Nlv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267047);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.Nlt);
      if (this.Nlu != null) {
        paramVarArgs.g(2, this.Nlu);
      }
      if (this.Nlv != null) {
        paramVarArgs.g(3, this.Nlv);
      }
      AppMethodBeat.o(267047);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.Nlt) + 0;
      paramInt = i;
      if (this.Nlu != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Nlu);
      }
      i = paramInt;
      if (this.Nlv != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Nlv);
      }
      AppMethodBeat.o(267047);
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
      AppMethodBeat.o(267047);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ax localax = (ax)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(267047);
        return -1;
      case 1: 
        localax.Nlt = locala.ajGk.aaw();
        AppMethodBeat.o(267047);
        return 0;
      case 2: 
        localax.Nlu = locala.ajGk.readString();
        AppMethodBeat.o(267047);
        return 0;
      }
      localax.Nlv = locala.ajGk.readString();
      AppMethodBeat.o(267047);
      return 0;
    }
    AppMethodBeat.o(267047);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.ax
 * JD-Core Version:    0.7.0.1
 */