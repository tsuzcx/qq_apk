package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahj
  extends com.tencent.mm.bw.a
{
  public String EBE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125724);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EBE != null) {
        paramVarArgs.d(1, this.EBE);
      }
      AppMethodBeat.o(125724);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EBE == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.EBE) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(125724);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125724);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ahj localahj = (ahj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125724);
          return -1;
        }
        localahj.EBE = locala.LVo.readString();
        AppMethodBeat.o(125724);
        return 0;
      }
      AppMethodBeat.o(125724);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahj
 * JD-Core Version:    0.7.0.1
 */