package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bv.a
{
  public int bsY;
  public String cwc;
  public String name;
  public String pvi;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56639);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cwc != null) {
        paramVarArgs.e(1, this.cwc);
      }
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      if (this.pvi != null) {
        paramVarArgs.e(3, this.pvi);
      }
      if (this.username != null) {
        paramVarArgs.e(4, this.username);
      }
      paramVarArgs.aO(5, this.bsY);
      AppMethodBeat.o(56639);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cwc == null) {
        break label438;
      }
    }
    label438:
    for (int i = e.a.a.b.b.a.f(1, this.cwc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.name);
      }
      i = paramInt;
      if (this.pvi != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.pvi);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.username);
      }
      i = e.a.a.b.b.a.bl(5, this.bsY);
      AppMethodBeat.o(56639);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56639);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56639);
          return -1;
        case 1: 
          localn.cwc = locala.CLY.readString();
          AppMethodBeat.o(56639);
          return 0;
        case 2: 
          localn.name = locala.CLY.readString();
          AppMethodBeat.o(56639);
          return 0;
        case 3: 
          localn.pvi = locala.CLY.readString();
          AppMethodBeat.o(56639);
          return 0;
        case 4: 
          localn.username = locala.CLY.readString();
          AppMethodBeat.o(56639);
          return 0;
        }
        localn.bsY = locala.CLY.sl();
        AppMethodBeat.o(56639);
        return 0;
      }
      AppMethodBeat.o(56639);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.n
 * JD-Core Version:    0.7.0.1
 */