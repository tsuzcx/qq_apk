package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckf
  extends com.tencent.mm.bx.a
{
  public String HdP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(192510);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HdP != null) {
        paramVarArgs.d(1, this.HdP);
      }
      AppMethodBeat.o(192510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HdP == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.HdP) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(192510);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(192510);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ckf localckf = (ckf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(192510);
          return -1;
        }
        localckf.HdP = locala.NPN.readString();
        AppMethodBeat.o(192510);
        return 0;
      }
      AppMethodBeat.o(192510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckf
 * JD-Core Version:    0.7.0.1
 */