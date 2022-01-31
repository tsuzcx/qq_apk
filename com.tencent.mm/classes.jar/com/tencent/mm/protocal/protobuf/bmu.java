package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmu
  extends com.tencent.mm.bv.a
{
  public String tVo;
  public String wPJ;
  public String xBf;
  public String xBg;
  public int xij;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48925);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xBf != null) {
        paramVarArgs.e(1, this.xBf);
      }
      if (this.xBg != null) {
        paramVarArgs.e(2, this.xBg);
      }
      if (this.tVo != null) {
        paramVarArgs.e(3, this.tVo);
      }
      if (this.wPJ != null) {
        paramVarArgs.e(4, this.wPJ);
      }
      paramVarArgs.aO(5, this.xij);
      AppMethodBeat.o(48925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xBf == null) {
        break label438;
      }
    }
    label438:
    for (int i = e.a.a.b.b.a.f(1, this.xBf) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xBg != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xBg);
      }
      i = paramInt;
      if (this.tVo != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.tVo);
      }
      paramInt = i;
      if (this.wPJ != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wPJ);
      }
      i = e.a.a.b.b.a.bl(5, this.xij);
      AppMethodBeat.o(48925);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48925);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bmu localbmu = (bmu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(48925);
          return -1;
        case 1: 
          localbmu.xBf = locala.CLY.readString();
          AppMethodBeat.o(48925);
          return 0;
        case 2: 
          localbmu.xBg = locala.CLY.readString();
          AppMethodBeat.o(48925);
          return 0;
        case 3: 
          localbmu.tVo = locala.CLY.readString();
          AppMethodBeat.o(48925);
          return 0;
        case 4: 
          localbmu.wPJ = locala.CLY.readString();
          AppMethodBeat.o(48925);
          return 0;
        }
        localbmu.xij = locala.CLY.sl();
        AppMethodBeat.o(48925);
        return 0;
      }
      AppMethodBeat.o(48925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmu
 * JD-Core Version:    0.7.0.1
 */