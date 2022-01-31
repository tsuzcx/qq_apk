package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class us
  extends com.tencent.mm.bv.a
{
  public String content;
  public int wMR;
  public int wMS;
  public String wMT;
  public int wMU;
  public int wMV;
  public String wys;
  public int wyt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14724);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.e(1, this.content);
      }
      if (this.wys != null) {
        paramVarArgs.e(3, this.wys);
      }
      paramVarArgs.aO(4, this.wyt);
      paramVarArgs.aO(5, this.wMR);
      paramVarArgs.aO(6, this.wMS);
      if (this.wMT != null) {
        paramVarArgs.e(7, this.wMT);
      }
      paramVarArgs.aO(8, this.wMU);
      paramVarArgs.aO(9, this.wMV);
      AppMethodBeat.o(14724);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label580;
      }
    }
    label580:
    for (paramInt = e.a.a.b.b.a.f(1, this.content) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wys != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wys);
      }
      i = i + e.a.a.b.b.a.bl(4, this.wyt) + e.a.a.b.b.a.bl(5, this.wMR) + e.a.a.b.b.a.bl(6, this.wMS);
      paramInt = i;
      if (this.wMT != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wMT);
      }
      i = e.a.a.b.b.a.bl(8, this.wMU);
      int j = e.a.a.b.b.a.bl(9, this.wMV);
      AppMethodBeat.o(14724);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(14724);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        us localus = (us)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 2: 
        default: 
          AppMethodBeat.o(14724);
          return -1;
        case 1: 
          localus.content = locala.CLY.readString();
          AppMethodBeat.o(14724);
          return 0;
        case 3: 
          localus.wys = locala.CLY.readString();
          AppMethodBeat.o(14724);
          return 0;
        case 4: 
          localus.wyt = locala.CLY.sl();
          AppMethodBeat.o(14724);
          return 0;
        case 5: 
          localus.wMR = locala.CLY.sl();
          AppMethodBeat.o(14724);
          return 0;
        case 6: 
          localus.wMS = locala.CLY.sl();
          AppMethodBeat.o(14724);
          return 0;
        case 7: 
          localus.wMT = locala.CLY.readString();
          AppMethodBeat.o(14724);
          return 0;
        case 8: 
          localus.wMU = locala.CLY.sl();
          AppMethodBeat.o(14724);
          return 0;
        }
        localus.wMV = locala.CLY.sl();
        AppMethodBeat.o(14724);
        return 0;
      }
      AppMethodBeat.o(14724);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.us
 * JD-Core Version:    0.7.0.1
 */