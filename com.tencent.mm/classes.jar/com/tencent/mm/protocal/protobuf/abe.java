package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class abe
  extends com.tencent.mm.bx.a
{
  public String orq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117863);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.orq != null) {
        paramVarArgs.d(4, this.orq);
      }
      AppMethodBeat.o(117863);
      return 0;
    }
    if (paramInt == 1) {
      if (this.orq == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(4, this.orq) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(117863);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117863);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        abe localabe = (abe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117863);
          return -1;
        }
        localabe.orq = locala.NPN.readString();
        AppMethodBeat.o(117863);
        return 0;
      }
      AppMethodBeat.o(117863);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abe
 * JD-Core Version:    0.7.0.1
 */