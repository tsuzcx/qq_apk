package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bd
  extends com.tencent.mm.bx.a
{
  public String YCm;
  public String YCn;
  public String YCo;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125688);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.oOI != null) {
        paramVarArgs.g(1, this.oOI);
      }
      if (this.YCm != null) {
        paramVarArgs.g(2, this.YCm);
      }
      if (this.YCn != null) {
        paramVarArgs.g(3, this.YCn);
      }
      if (this.YCo != null) {
        paramVarArgs.g(4, this.YCo);
      }
      AppMethodBeat.o(125688);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oOI == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.oOI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YCm != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YCm);
      }
      i = paramInt;
      if (this.YCn != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YCn);
      }
      paramInt = i;
      if (this.YCo != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YCo);
      }
      AppMethodBeat.o(125688);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125688);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bd localbd = (bd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125688);
          return -1;
        case 1: 
          localbd.oOI = locala.ajGk.readString();
          AppMethodBeat.o(125688);
          return 0;
        case 2: 
          localbd.YCm = locala.ajGk.readString();
          AppMethodBeat.o(125688);
          return 0;
        case 3: 
          localbd.YCn = locala.ajGk.readString();
          AppMethodBeat.o(125688);
          return 0;
        }
        localbd.YCo = locala.ajGk.readString();
        AppMethodBeat.o(125688);
        return 0;
      }
      AppMethodBeat.o(125688);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bd
 * JD-Core Version:    0.7.0.1
 */