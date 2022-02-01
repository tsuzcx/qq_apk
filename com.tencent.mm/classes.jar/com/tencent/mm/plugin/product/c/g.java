package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.cd.a
{
  public String city;
  public String country;
  public String lLg;
  public String province;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91273);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.country != null) {
        paramVarArgs.f(1, this.country);
      }
      if (this.province != null) {
        paramVarArgs.f(2, this.province);
      }
      if (this.city != null) {
        paramVarArgs.f(3, this.city);
      }
      if (this.lLg != null) {
        paramVarArgs.f(4, this.lLg);
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
    for (int i = g.a.a.b.b.a.g(1, this.country) + 0;; i = 0)
    {
      paramInt = i;
      if (this.province != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.province);
      }
      i = paramInt;
      if (this.city != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.city);
      }
      paramInt = i;
      if (this.lLg != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.lLg);
      }
      AppMethodBeat.o(91273);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
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
          localg.country = locala.abFh.readString();
          AppMethodBeat.o(91273);
          return 0;
        case 2: 
          localg.province = locala.abFh.readString();
          AppMethodBeat.o(91273);
          return 0;
        case 3: 
          localg.city = locala.abFh.readString();
          AppMethodBeat.o(91273);
          return 0;
        }
        localg.lLg = locala.abFh.readString();
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