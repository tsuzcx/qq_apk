package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class agn
  extends com.tencent.mm.bw.a
{
  public int GwN;
  public String GwO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104760);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GwO == null)
      {
        paramVarArgs = new b("Not all required fields were included: TagDesc");
        AppMethodBeat.o(104760);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.GwN);
      if (this.GwO != null) {
        paramVarArgs.d(2, this.GwO);
      }
      AppMethodBeat.o(104760);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GwN) + 0;
      paramInt = i;
      if (this.GwO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GwO);
      }
      AppMethodBeat.o(104760);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.GwO == null)
      {
        paramVarArgs = new b("Not all required fields were included: TagDesc");
        AppMethodBeat.o(104760);
        throw paramVarArgs;
      }
      AppMethodBeat.o(104760);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      agn localagn = (agn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104760);
        return -1;
      case 1: 
        localagn.GwN = locala.OmT.zc();
        AppMethodBeat.o(104760);
        return 0;
      }
      localagn.GwO = locala.OmT.readString();
      AppMethodBeat.o(104760);
      return 0;
    }
    AppMethodBeat.o(104760);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agn
 * JD-Core Version:    0.7.0.1
 */