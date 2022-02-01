package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aun
  extends com.tencent.mm.bx.a
{
  public String GsM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42647);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GsM != null) {
        paramVarArgs.d(1, this.GsM);
      }
      AppMethodBeat.o(42647);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GsM == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.GsM) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(42647);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(42647);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aun localaun = (aun)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(42647);
          return -1;
        }
        localaun.GsM = locala.NPN.readString();
        AppMethodBeat.o(42647);
        return 0;
      }
      AppMethodBeat.o(42647);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aun
 * JD-Core Version:    0.7.0.1
 */