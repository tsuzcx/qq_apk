package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dif
  extends com.tencent.mm.bx.a
{
  public String ubt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125842);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ubt != null) {
        paramVarArgs.d(1, this.ubt);
      }
      AppMethodBeat.o(125842);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ubt == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.ubt) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(125842);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125842);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dif localdif = (dif)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125842);
          return -1;
        }
        localdif.ubt = locala.NPN.readString();
        AppMethodBeat.o(125842);
        return 0;
      }
      AppMethodBeat.o(125842);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dif
 * JD-Core Version:    0.7.0.1
 */