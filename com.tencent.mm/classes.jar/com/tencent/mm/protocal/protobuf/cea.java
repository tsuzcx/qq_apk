package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cea
  extends com.tencent.mm.bx.a
{
  public String GOM;
  public boolean GYa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211976);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GOM != null) {
        paramVarArgs.d(1, this.GOM);
      }
      paramVarArgs.bt(2, this.GYa);
      AppMethodBeat.o(211976);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GOM == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = f.a.a.b.b.a.e(1, this.GOM) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.alV(2);
      AppMethodBeat.o(211976);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(211976);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cea localcea = (cea)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(211976);
          return -1;
        case 1: 
          localcea.GOM = locala.NPN.readString();
          AppMethodBeat.o(211976);
          return 0;
        }
        localcea.GYa = locala.NPN.grw();
        AppMethodBeat.o(211976);
        return 0;
      }
      AppMethodBeat.o(211976);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cea
 * JD-Core Version:    0.7.0.1
 */