package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bw.a
{
  public String country;
  public String fuJ;
  public String fuK;
  public String iUO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91273);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.country != null) {
        paramVarArgs.e(1, this.country);
      }
      if (this.fuJ != null) {
        paramVarArgs.e(2, this.fuJ);
      }
      if (this.fuK != null) {
        paramVarArgs.e(3, this.fuK);
      }
      if (this.iUO != null) {
        paramVarArgs.e(4, this.iUO);
      }
      AppMethodBeat.o(91273);
      return 0;
    }
    if (paramInt == 1) {
      if (this.country == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.f(1, this.country) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fuJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.fuJ);
      }
      i = paramInt;
      if (this.fuK != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.fuK);
      }
      paramInt = i;
      if (this.iUO != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.iUO);
      }
      AppMethodBeat.o(91273);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91273);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91273);
          return -1;
        case 1: 
          localg.country = locala.UbS.readString();
          AppMethodBeat.o(91273);
          return 0;
        case 2: 
          localg.fuJ = locala.UbS.readString();
          AppMethodBeat.o(91273);
          return 0;
        case 3: 
          localg.fuK = locala.UbS.readString();
          AppMethodBeat.o(91273);
          return 0;
        }
        localg.iUO = locala.UbS.readString();
        AppMethodBeat.o(91273);
        return 0;
      }
      AppMethodBeat.o(91273);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.g
 * JD-Core Version:    0.7.0.1
 */