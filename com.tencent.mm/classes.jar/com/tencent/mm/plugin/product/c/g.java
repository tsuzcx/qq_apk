package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bx.a
{
  public String country;
  public String ePu;
  public String ePv;
  public String hWY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91273);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.country != null) {
        paramVarArgs.d(1, this.country);
      }
      if (this.ePu != null) {
        paramVarArgs.d(2, this.ePu);
      }
      if (this.ePv != null) {
        paramVarArgs.d(3, this.ePv);
      }
      if (this.hWY != null) {
        paramVarArgs.d(4, this.hWY);
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
    for (int i = f.a.a.b.b.a.e(1, this.country) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ePu != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ePu);
      }
      i = paramInt;
      if (this.ePv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ePv);
      }
      paramInt = i;
      if (this.hWY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hWY);
      }
      AppMethodBeat.o(91273);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91273);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91273);
          return -1;
        case 1: 
          localg.country = locala.NPN.readString();
          AppMethodBeat.o(91273);
          return 0;
        case 2: 
          localg.ePu = locala.NPN.readString();
          AppMethodBeat.o(91273);
          return 0;
        case 3: 
          localg.ePv = locala.NPN.readString();
          AppMethodBeat.o(91273);
          return 0;
        }
        localg.hWY = locala.NPN.readString();
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