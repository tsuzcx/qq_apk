package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhy
  extends com.tencent.mm.bx.a
{
  public String YNT;
  public String YNU;
  public String YNV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43103);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YNU != null) {
        paramVarArgs.g(1, this.YNU);
      }
      if (this.YNT != null) {
        paramVarArgs.g(2, this.YNT);
      }
      if (this.YNV != null) {
        paramVarArgs.g(3, this.YNV);
      }
      AppMethodBeat.o(43103);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YNU == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.YNU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YNT != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YNT);
      }
      i = paramInt;
      if (this.YNV != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YNV);
      }
      AppMethodBeat.o(43103);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(43103);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dhy localdhy = (dhy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43103);
          return -1;
        case 1: 
          localdhy.YNU = locala.ajGk.readString();
          AppMethodBeat.o(43103);
          return 0;
        case 2: 
          localdhy.YNT = locala.ajGk.readString();
          AppMethodBeat.o(43103);
          return 0;
        }
        localdhy.YNV = locala.ajGk.readString();
        AppMethodBeat.o(43103);
        return 0;
      }
      AppMethodBeat.o(43103);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhy
 * JD-Core Version:    0.7.0.1
 */