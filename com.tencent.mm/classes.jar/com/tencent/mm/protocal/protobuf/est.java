package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class est
  extends com.tencent.mm.bx.a
{
  public String IKJ;
  public String YDL;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258170);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.oOI != null) {
        paramVarArgs.g(1, this.oOI);
      }
      if (this.IKJ != null) {
        paramVarArgs.g(2, this.IKJ);
      }
      if (this.YDL != null) {
        paramVarArgs.g(3, this.YDL);
      }
      AppMethodBeat.o(258170);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oOI == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.oOI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IKJ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IKJ);
      }
      i = paramInt;
      if (this.YDL != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YDL);
      }
      AppMethodBeat.o(258170);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258170);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        est localest = (est)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258170);
          return -1;
        case 1: 
          localest.oOI = locala.ajGk.readString();
          AppMethodBeat.o(258170);
          return 0;
        case 2: 
          localest.IKJ = locala.ajGk.readString();
          AppMethodBeat.o(258170);
          return 0;
        }
        localest.YDL = locala.ajGk.readString();
        AppMethodBeat.o(258170);
        return 0;
      }
      AppMethodBeat.o(258170);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.est
 * JD-Core Version:    0.7.0.1
 */