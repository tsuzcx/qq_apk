package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ae
  extends com.tencent.mm.bv.a
{
  public String wlu;
  public int wlv;
  public int wlw;
  public int wlx;
  public int wly;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72837);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wlu != null) {
        paramVarArgs.e(1, this.wlu);
      }
      paramVarArgs.aO(2, this.wlv);
      paramVarArgs.aO(3, this.wlw);
      paramVarArgs.aO(4, this.wlx);
      paramVarArgs.aO(5, this.wly);
      AppMethodBeat.o(72837);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wlu == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = e.a.a.b.b.a.f(1, this.wlu) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.wlv);
      int j = e.a.a.b.b.a.bl(3, this.wlw);
      int k = e.a.a.b.b.a.bl(4, this.wlx);
      int m = e.a.a.b.b.a.bl(5, this.wly);
      AppMethodBeat.o(72837);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(72837);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ae localae = (ae)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72837);
          return -1;
        case 1: 
          localae.wlu = locala.CLY.readString();
          AppMethodBeat.o(72837);
          return 0;
        case 2: 
          localae.wlv = locala.CLY.sl();
          AppMethodBeat.o(72837);
          return 0;
        case 3: 
          localae.wlw = locala.CLY.sl();
          AppMethodBeat.o(72837);
          return 0;
        case 4: 
          localae.wlx = locala.CLY.sl();
          AppMethodBeat.o(72837);
          return 0;
        }
        localae.wly = locala.CLY.sl();
        AppMethodBeat.o(72837);
        return 0;
      }
      AppMethodBeat.o(72837);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ae
 * JD-Core Version:    0.7.0.1
 */