package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gq
  extends com.tencent.mm.bx.a
{
  public String CBB;
  public String CBC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123543);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CBB != null) {
        paramVarArgs.d(1, this.CBB);
      }
      if (this.CBC != null) {
        paramVarArgs.d(2, this.CBC);
      }
      AppMethodBeat.o(123543);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CBB == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.CBB) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CBC != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CBC);
      }
      AppMethodBeat.o(123543);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123543);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        gq localgq = (gq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123543);
          return -1;
        case 1: 
          localgq.CBB = locala.KhF.readString();
          AppMethodBeat.o(123543);
          return 0;
        }
        localgq.CBC = locala.KhF.readString();
        AppMethodBeat.o(123543);
        return 0;
      }
      AppMethodBeat.o(123543);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gq
 * JD-Core Version:    0.7.0.1
 */