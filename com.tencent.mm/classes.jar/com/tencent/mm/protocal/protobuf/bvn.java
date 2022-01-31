package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvn
  extends com.tencent.mm.bv.a
{
  public int eAS;
  public String xJe;
  public int xJf;
  public int xJg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(141134);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xJe != null) {
        paramVarArgs.e(1, this.xJe);
      }
      paramVarArgs.aO(2, this.eAS);
      paramVarArgs.aO(3, this.xJf);
      paramVarArgs.aO(4, this.xJg);
      AppMethodBeat.o(141134);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xJe == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = e.a.a.b.b.a.f(1, this.xJe) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.eAS);
      int j = e.a.a.b.b.a.bl(3, this.xJf);
      int k = e.a.a.b.b.a.bl(4, this.xJg);
      AppMethodBeat.o(141134);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(141134);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bvn localbvn = (bvn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(141134);
          return -1;
        case 1: 
          localbvn.xJe = locala.CLY.readString();
          AppMethodBeat.o(141134);
          return 0;
        case 2: 
          localbvn.eAS = locala.CLY.sl();
          AppMethodBeat.o(141134);
          return 0;
        case 3: 
          localbvn.xJf = locala.CLY.sl();
          AppMethodBeat.o(141134);
          return 0;
        }
        localbvn.xJg = locala.CLY.sl();
        AppMethodBeat.o(141134);
        return 0;
      }
      AppMethodBeat.o(141134);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvn
 * JD-Core Version:    0.7.0.1
 */