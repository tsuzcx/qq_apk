package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cky
  extends com.tencent.mm.bv.a
{
  public String cBO;
  public long xVi;
  public long xVt;
  public long xVu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(55712);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cBO != null) {
        paramVarArgs.e(1, this.cBO);
      }
      paramVarArgs.am(2, this.xVt);
      paramVarArgs.am(3, this.xVu);
      paramVarArgs.am(4, this.xVi);
      AppMethodBeat.o(55712);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cBO == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = e.a.a.b.b.a.f(1, this.cBO) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.p(2, this.xVt);
      int j = e.a.a.b.b.a.p(3, this.xVu);
      int k = e.a.a.b.b.a.p(4, this.xVi);
      AppMethodBeat.o(55712);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(55712);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cky localcky = (cky)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(55712);
          return -1;
        case 1: 
          localcky.cBO = locala.CLY.readString();
          AppMethodBeat.o(55712);
          return 0;
        case 2: 
          localcky.xVt = locala.CLY.sm();
          AppMethodBeat.o(55712);
          return 0;
        case 3: 
          localcky.xVu = locala.CLY.sm();
          AppMethodBeat.o(55712);
          return 0;
        }
        localcky.xVi = locala.CLY.sm();
        AppMethodBeat.o(55712);
        return 0;
      }
      AppMethodBeat.o(55712);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cky
 * JD-Core Version:    0.7.0.1
 */