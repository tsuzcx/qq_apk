package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class evf
  extends com.tencent.mm.bw.a
{
  public int EX;
  public b LrK;
  public String uuid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147789);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.EX);
      if (this.uuid != null) {
        paramVarArgs.e(2, this.uuid);
      }
      if (this.LrK != null) {
        paramVarArgs.c(3, this.LrK);
      }
      AppMethodBeat.o(147789);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.EX) + 0;
      paramInt = i;
      if (this.uuid != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.uuid);
      }
      i = paramInt;
      if (this.LrK != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.LrK);
      }
      AppMethodBeat.o(147789);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(147789);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      evf localevf = (evf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147789);
        return -1;
      case 1: 
        localevf.EX = locala.UbS.zi();
        AppMethodBeat.o(147789);
        return 0;
      case 2: 
        localevf.uuid = locala.UbS.readString();
        AppMethodBeat.o(147789);
        return 0;
      }
      localevf.LrK = locala.UbS.hPo();
      AppMethodBeat.o(147789);
      return 0;
    }
    AppMethodBeat.o(147789);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evf
 * JD-Core Version:    0.7.0.1
 */