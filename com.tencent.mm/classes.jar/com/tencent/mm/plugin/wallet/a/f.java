package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.bv.a
{
  public String tTZ;
  public String tUa;
  public String tUb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56647);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.tTZ != null) {
        paramVarArgs.e(1, this.tTZ);
      }
      if (this.tUa != null) {
        paramVarArgs.e(2, this.tUa);
      }
      if (this.tUb != null) {
        paramVarArgs.e(3, this.tUb);
      }
      AppMethodBeat.o(56647);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tTZ == null) {
        break label334;
      }
    }
    label334:
    for (int i = e.a.a.b.b.a.f(1, this.tTZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tUa != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.tUa);
      }
      i = paramInt;
      if (this.tUb != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.tUb);
      }
      AppMethodBeat.o(56647);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56647);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56647);
          return -1;
        case 1: 
          localf.tTZ = locala.CLY.readString();
          AppMethodBeat.o(56647);
          return 0;
        case 2: 
          localf.tUa = locala.CLY.readString();
          AppMethodBeat.o(56647);
          return 0;
        }
        localf.tUb = locala.CLY.readString();
        AppMethodBeat.o(56647);
        return 0;
      }
      AppMethodBeat.o(56647);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.f
 * JD-Core Version:    0.7.0.1
 */