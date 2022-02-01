package com.tencent.mm.plugin.wallet.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends com.tencent.mm.bx.a
{
  public String MDt;
  public String VlT;
  public int selected;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91298);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.VlT != null) {
        paramVarArgs.g(1, this.VlT);
      }
      paramVarArgs.bS(2, this.selected);
      if (this.MDt != null) {
        paramVarArgs.g(3, this.MDt);
      }
      AppMethodBeat.o(91298);
      return 0;
    }
    if (paramInt == 1) {
      if (this.VlT == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.VlT) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.selected);
      paramInt = i;
      if (this.MDt != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.MDt);
      }
      AppMethodBeat.o(91298);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91298);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91298);
          return -1;
        case 1: 
          localk.VlT = locala.ajGk.readString();
          AppMethodBeat.o(91298);
          return 0;
        case 2: 
          localk.selected = locala.ajGk.aar();
          AppMethodBeat.o(91298);
          return 0;
        }
        localk.MDt = locala.ajGk.readString();
        AppMethodBeat.o(91298);
        return 0;
      }
      AppMethodBeat.o(91298);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.model.k
 * JD-Core Version:    0.7.0.1
 */