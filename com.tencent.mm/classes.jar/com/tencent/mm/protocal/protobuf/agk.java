package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agk
  extends com.tencent.mm.bx.a
{
  public String Diy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125724);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Diy != null) {
        paramVarArgs.d(1, this.Diy);
      }
      AppMethodBeat.o(125724);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Diy == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.Diy) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(125724);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125724);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        agk localagk = (agk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125724);
          return -1;
        }
        localagk.Diy = locala.KhF.readString();
        AppMethodBeat.o(125724);
        return 0;
      }
      AppMethodBeat.o(125724);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agk
 * JD-Core Version:    0.7.0.1
 */