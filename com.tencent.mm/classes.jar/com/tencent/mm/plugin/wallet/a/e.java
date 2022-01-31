package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends com.tencent.mm.bv.a
{
  public String fjP;
  public String name;
  public String tTY;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56646);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.e(1, this.url);
      }
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      if (this.tTY != null) {
        paramVarArgs.e(3, this.tTY);
      }
      if (this.fjP != null) {
        paramVarArgs.e(4, this.fjP);
      }
      AppMethodBeat.o(56646);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label394;
      }
    }
    label394:
    for (int i = e.a.a.b.b.a.f(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.name);
      }
      i = paramInt;
      if (this.tTY != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.tTY);
      }
      paramInt = i;
      if (this.fjP != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.fjP);
      }
      AppMethodBeat.o(56646);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56646);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56646);
          return -1;
        case 1: 
          locale.url = locala.CLY.readString();
          AppMethodBeat.o(56646);
          return 0;
        case 2: 
          locale.name = locala.CLY.readString();
          AppMethodBeat.o(56646);
          return 0;
        case 3: 
          locale.tTY = locala.CLY.readString();
          AppMethodBeat.o(56646);
          return 0;
        }
        locale.fjP = locala.CLY.readString();
        AppMethodBeat.o(56646);
        return 0;
      }
      AppMethodBeat.o(56646);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.e
 * JD-Core Version:    0.7.0.1
 */