package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bny
  extends com.tencent.mm.bx.a
{
  public String mVR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169922);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mVR != null) {
        paramVarArgs.d(1, this.mVR);
      }
      AppMethodBeat.o(169922);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mVR == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.mVR) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(169922);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169922);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bny localbny = (bny)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169922);
          return -1;
        }
        localbny.mVR = locala.KhF.readString();
        AppMethodBeat.o(169922);
        return 0;
      }
      AppMethodBeat.o(169922);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bny
 * JD-Core Version:    0.7.0.1
 */