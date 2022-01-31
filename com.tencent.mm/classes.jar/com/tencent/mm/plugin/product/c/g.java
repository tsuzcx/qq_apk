package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bv.a
{
  public String city;
  public String country;
  public String fBq;
  public String province;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56630);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.country != null) {
        paramVarArgs.e(1, this.country);
      }
      if (this.province != null) {
        paramVarArgs.e(2, this.province);
      }
      if (this.city != null) {
        paramVarArgs.e(3, this.city);
      }
      if (this.fBq != null) {
        paramVarArgs.e(4, this.fBq);
      }
      AppMethodBeat.o(56630);
      return 0;
    }
    if (paramInt == 1) {
      if (this.country == null) {
        break label394;
      }
    }
    label394:
    for (int i = e.a.a.b.b.a.f(1, this.country) + 0;; i = 0)
    {
      paramInt = i;
      if (this.province != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.province);
      }
      i = paramInt;
      if (this.city != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.city);
      }
      paramInt = i;
      if (this.fBq != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.fBq);
      }
      AppMethodBeat.o(56630);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56630);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56630);
          return -1;
        case 1: 
          localg.country = locala.CLY.readString();
          AppMethodBeat.o(56630);
          return 0;
        case 2: 
          localg.province = locala.CLY.readString();
          AppMethodBeat.o(56630);
          return 0;
        case 3: 
          localg.city = locala.CLY.readString();
          AppMethodBeat.o(56630);
          return 0;
        }
        localg.fBq = locala.CLY.readString();
        AppMethodBeat.o(56630);
        return 0;
      }
      AppMethodBeat.o(56630);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.g
 * JD-Core Version:    0.7.0.1
 */