package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qv
  extends com.tencent.mm.bw.a
{
  public String EhU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125714);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EhU != null) {
        paramVarArgs.d(1, this.EhU);
      }
      AppMethodBeat.o(125714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EhU == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.EhU) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(125714);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125714);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        qv localqv = (qv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125714);
          return -1;
        }
        localqv.EhU = locala.LVo.readString();
        AppMethodBeat.o(125714);
        return 0;
      }
      AppMethodBeat.o(125714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qv
 * JD-Core Version:    0.7.0.1
 */