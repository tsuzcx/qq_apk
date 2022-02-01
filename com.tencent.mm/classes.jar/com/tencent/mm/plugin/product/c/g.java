package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bw.a
{
  public String country;
  public String exV;
  public String exW;
  public String hEt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91273);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.country != null) {
        paramVarArgs.d(1, this.country);
      }
      if (this.exV != null) {
        paramVarArgs.d(2, this.exV);
      }
      if (this.exW != null) {
        paramVarArgs.d(3, this.exW);
      }
      if (this.hEt != null) {
        paramVarArgs.d(4, this.hEt);
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
      if (this.exV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.exV);
      }
      i = paramInt;
      if (this.exW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.exW);
      }
      paramInt = i;
      if (this.hEt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hEt);
      }
      AppMethodBeat.o(91273);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          localg.country = locala.LVo.readString();
          AppMethodBeat.o(91273);
          return 0;
        case 2: 
          localg.exV = locala.LVo.readString();
          AppMethodBeat.o(91273);
          return 0;
        case 3: 
          localg.exW = locala.LVo.readString();
          AppMethodBeat.o(91273);
          return 0;
        }
        localg.hEt = locala.LVo.readString();
        AppMethodBeat.o(91273);
        return 0;
      }
      AppMethodBeat.o(91273);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.g
 * JD-Core Version:    0.7.0.1
 */