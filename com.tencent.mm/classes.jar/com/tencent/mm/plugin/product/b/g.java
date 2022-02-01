package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bx.a
{
  public String city;
  public String country;
  public String oDI;
  public String province;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91273);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.country != null) {
        paramVarArgs.g(1, this.country);
      }
      if (this.province != null) {
        paramVarArgs.g(2, this.province);
      }
      if (this.city != null) {
        paramVarArgs.g(3, this.city);
      }
      if (this.oDI != null) {
        paramVarArgs.g(4, this.oDI);
      }
      AppMethodBeat.o(91273);
      return 0;
    }
    if (paramInt == 1) {
      if (this.country == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.country) + 0;; i = 0)
    {
      paramInt = i;
      if (this.province != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.province);
      }
      i = paramInt;
      if (this.city != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.city);
      }
      paramInt = i;
      if (this.oDI != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.oDI);
      }
      AppMethodBeat.o(91273);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91273);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91273);
          return -1;
        case 1: 
          localg.country = locala.ajGk.readString();
          AppMethodBeat.o(91273);
          return 0;
        case 2: 
          localg.province = locala.ajGk.readString();
          AppMethodBeat.o(91273);
          return 0;
        case 3: 
          localg.city = locala.ajGk.readString();
          AppMethodBeat.o(91273);
          return 0;
        }
        localg.oDI = locala.ajGk.readString();
        AppMethodBeat.o(91273);
        return 0;
      }
      AppMethodBeat.o(91273);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.g
 * JD-Core Version:    0.7.0.1
 */