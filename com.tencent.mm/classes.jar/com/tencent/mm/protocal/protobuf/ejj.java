package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ejj
  extends com.tencent.mm.bw.a
{
  public String Imr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200346);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Imr != null) {
        paramVarArgs.d(1, this.Imr);
      }
      AppMethodBeat.o(200346);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Imr == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.Imr) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(200346);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(200346);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ejj localejj = (ejj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(200346);
          return -1;
        }
        localejj.Imr = locala.OmT.readString();
        AppMethodBeat.o(200346);
        return 0;
      }
      AppMethodBeat.o(200346);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejj
 * JD-Core Version:    0.7.0.1
 */