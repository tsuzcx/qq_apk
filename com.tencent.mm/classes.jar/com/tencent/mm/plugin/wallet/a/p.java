package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  extends com.tencent.mm.bv.a
{
  public String fjP;
  public int id;
  public String name;
  public String tTY;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56659);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.id);
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      if (this.tTY != null) {
        paramVarArgs.e(4, this.tTY);
      }
      if (this.fjP != null) {
        paramVarArgs.e(5, this.fjP);
      }
      AppMethodBeat.o(56659);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.id) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.name);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.url);
      }
      paramInt = i;
      if (this.tTY != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.tTY);
      }
      i = paramInt;
      if (this.fjP != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.fjP);
      }
      AppMethodBeat.o(56659);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56659);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      p localp = (p)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56659);
        return -1;
      case 1: 
        localp.id = locala.CLY.sl();
        AppMethodBeat.o(56659);
        return 0;
      case 2: 
        localp.name = locala.CLY.readString();
        AppMethodBeat.o(56659);
        return 0;
      case 3: 
        localp.url = locala.CLY.readString();
        AppMethodBeat.o(56659);
        return 0;
      case 4: 
        localp.tTY = locala.CLY.readString();
        AppMethodBeat.o(56659);
        return 0;
      }
      localp.fjP = locala.CLY.readString();
      AppMethodBeat.o(56659);
      return 0;
    }
    AppMethodBeat.o(56659);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.p
 * JD-Core Version:    0.7.0.1
 */