package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yj
  extends com.tencent.mm.bx.a
{
  public String nlK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117863);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nlK != null) {
        paramVarArgs.d(4, this.nlK);
      }
      AppMethodBeat.o(117863);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nlK == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(4, this.nlK) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(117863);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117863);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        yj localyj = (yj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117863);
          return -1;
        }
        localyj.nlK = locala.KhF.readString();
        AppMethodBeat.o(117863);
        return 0;
      }
      AppMethodBeat.o(117863);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yj
 * JD-Core Version:    0.7.0.1
 */