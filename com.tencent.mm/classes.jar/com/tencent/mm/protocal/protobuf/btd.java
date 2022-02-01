package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class btd
  extends com.tencent.mm.bw.a
{
  public String uuW;
  public String yxn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91529);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uuW != null) {
        paramVarArgs.d(1, this.uuW);
      }
      if (this.yxn != null) {
        paramVarArgs.d(2, this.yxn);
      }
      AppMethodBeat.o(91529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuW == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.uuW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.yxn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.yxn);
      }
      AppMethodBeat.o(91529);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91529);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        btd localbtd = (btd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91529);
          return -1;
        case 1: 
          localbtd.uuW = locala.OmT.readString();
          AppMethodBeat.o(91529);
          return 0;
        }
        localbtd.yxn = locala.OmT.readString();
        AppMethodBeat.o(91529);
        return 0;
      }
      AppMethodBeat.o(91529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btd
 * JD-Core Version:    0.7.0.1
 */