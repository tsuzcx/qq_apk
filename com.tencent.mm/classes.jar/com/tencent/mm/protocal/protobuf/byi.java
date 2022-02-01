package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byi
  extends com.tencent.mm.bw.a
{
  public String dyI;
  public String kCZ;
  public String kDa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72513);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyI != null) {
        paramVarArgs.d(1, this.dyI);
      }
      if (this.kCZ != null) {
        paramVarArgs.d(2, this.kCZ);
      }
      if (this.kDa != null) {
        paramVarArgs.d(4, this.kDa);
      }
      AppMethodBeat.o(72513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dyI == null) {
        break label338;
      }
    }
    label338:
    for (int i = f.a.a.b.b.a.e(1, this.dyI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kCZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.kCZ);
      }
      i = paramInt;
      if (this.kDa != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.kDa);
      }
      AppMethodBeat.o(72513);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72513);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        byi localbyi = (byi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 3: 
        default: 
          AppMethodBeat.o(72513);
          return -1;
        case 1: 
          localbyi.dyI = locala.OmT.readString();
          AppMethodBeat.o(72513);
          return 0;
        case 2: 
          localbyi.kCZ = locala.OmT.readString();
          AppMethodBeat.o(72513);
          return 0;
        }
        localbyi.kDa = locala.OmT.readString();
        AppMethodBeat.o(72513);
        return 0;
      }
      AppMethodBeat.o(72513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byi
 * JD-Core Version:    0.7.0.1
 */