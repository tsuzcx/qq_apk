package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class adv
  extends com.tencent.mm.bw.a
{
  public int EwD;
  public String EwE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104760);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EwE == null)
      {
        paramVarArgs = new b("Not all required fields were included: TagDesc");
        AppMethodBeat.o(104760);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.EwD);
      if (this.EwE != null) {
        paramVarArgs.d(2, this.EwE);
      }
      AppMethodBeat.o(104760);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.EwD) + 0;
      paramInt = i;
      if (this.EwE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EwE);
      }
      AppMethodBeat.o(104760);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.EwE == null)
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
      adv localadv = (adv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104760);
        return -1;
      case 1: 
        localadv.EwD = locala.LVo.xF();
        AppMethodBeat.o(104760);
        return 0;
      }
      localadv.EwE = locala.LVo.readString();
      AppMethodBeat.o(104760);
      return 0;
    }
    AppMethodBeat.o(104760);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adv
 * JD-Core Version:    0.7.0.1
 */