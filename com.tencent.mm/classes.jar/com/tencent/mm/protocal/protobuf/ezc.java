package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ezc
  extends com.tencent.mm.bw.a
{
  public LinkedList<Integer> NvD;
  public boolean NvE;
  
  public ezc()
  {
    AppMethodBeat.i(32543);
    this.NvD = new LinkedList();
    AppMethodBeat.o(32543);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32544);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 2, this.NvD);
      paramVarArgs.cc(2, this.NvE);
      AppMethodBeat.o(32544);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 2, this.NvD);
      int i = g.a.a.b.b.a.fS(2);
      AppMethodBeat.o(32544);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.NvD.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32544);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ezc localezc = (ezc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32544);
        return -1;
      case 1: 
        localezc.NvD.add(Integer.valueOf(locala.UbS.zi()));
        AppMethodBeat.o(32544);
        return 0;
      }
      localezc.NvE = locala.UbS.yZ();
      AppMethodBeat.o(32544);
      return 0;
    }
    AppMethodBeat.o(32544);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezc
 * JD-Core Version:    0.7.0.1
 */