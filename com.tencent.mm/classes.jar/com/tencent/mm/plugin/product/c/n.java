package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bw.a
{
  public String Bah;
  public int cSx;
  public String dNI;
  public String name;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91282);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI != null) {
        paramVarArgs.e(1, this.dNI);
      }
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      if (this.Bah != null) {
        paramVarArgs.e(3, this.Bah);
      }
      if (this.username != null) {
        paramVarArgs.e(4, this.username);
      }
      paramVarArgs.aM(5, this.cSx);
      AppMethodBeat.o(91282);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dNI == null) {
        break label438;
      }
    }
    label438:
    for (int i = g.a.a.b.b.a.f(1, this.dNI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.name);
      }
      i = paramInt;
      if (this.Bah != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Bah);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.username);
      }
      i = g.a.a.b.b.a.bu(5, this.cSx);
      AppMethodBeat.o(91282);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91282);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91282);
          return -1;
        case 1: 
          localn.dNI = locala.UbS.readString();
          AppMethodBeat.o(91282);
          return 0;
        case 2: 
          localn.name = locala.UbS.readString();
          AppMethodBeat.o(91282);
          return 0;
        case 3: 
          localn.Bah = locala.UbS.readString();
          AppMethodBeat.o(91282);
          return 0;
        case 4: 
          localn.username = locala.UbS.readString();
          AppMethodBeat.o(91282);
          return 0;
        }
        localn.cSx = locala.UbS.zi();
        AppMethodBeat.o(91282);
        return 0;
      }
      AppMethodBeat.o(91282);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.n
 * JD-Core Version:    0.7.0.1
 */