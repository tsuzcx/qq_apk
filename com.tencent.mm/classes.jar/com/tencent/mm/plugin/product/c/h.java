package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends com.tencent.mm.bv.a
{
  public String id;
  public String name;
  public boolean pva;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56631);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.e(1, this.id);
      }
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      paramVarArgs.aS(3, this.pva);
      AppMethodBeat.o(56631);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.name != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.name);
      }
      paramInt = e.a.a.b.b.a.eW(3);
      AppMethodBeat.o(56631);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56631);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56631);
          return -1;
        case 1: 
          localh.id = locala.CLY.readString();
          AppMethodBeat.o(56631);
          return 0;
        case 2: 
          localh.name = locala.CLY.readString();
          AppMethodBeat.o(56631);
          return 0;
        }
        localh.pva = locala.CLY.emu();
        AppMethodBeat.o(56631);
        return 0;
      }
      AppMethodBeat.o(56631);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.h
 * JD-Core Version:    0.7.0.1
 */