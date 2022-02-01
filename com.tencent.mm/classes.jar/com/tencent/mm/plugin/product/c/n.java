package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.cd.a
{
  public String GUf;
  public String appid;
  public int cUP;
  public String name;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91282);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      if (this.name != null) {
        paramVarArgs.f(2, this.name);
      }
      if (this.GUf != null) {
        paramVarArgs.f(3, this.GUf);
      }
      if (this.username != null) {
        paramVarArgs.f(4, this.username);
      }
      paramVarArgs.aY(5, this.cUP);
      AppMethodBeat.o(91282);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label438;
      }
    }
    label438:
    for (int i = g.a.a.b.b.a.g(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.name);
      }
      i = paramInt;
      if (this.GUf != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.GUf);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.username);
      }
      i = g.a.a.b.b.a.bM(5, this.cUP);
      AppMethodBeat.o(91282);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
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
          localn.appid = locala.abFh.readString();
          AppMethodBeat.o(91282);
          return 0;
        case 2: 
          localn.name = locala.abFh.readString();
          AppMethodBeat.o(91282);
          return 0;
        case 3: 
          localn.GUf = locala.abFh.readString();
          AppMethodBeat.o(91282);
          return 0;
        case 4: 
          localn.username = locala.abFh.readString();
          AppMethodBeat.o(91282);
          return 0;
        }
        localn.cUP = locala.abFh.AK();
        AppMethodBeat.o(91282);
        return 0;
      }
      AppMethodBeat.o(91282);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.n
 * JD-Core Version:    0.7.0.1
 */