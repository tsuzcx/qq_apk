package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class td
  extends com.tencent.mm.bw.a
{
  public int Lbw;
  public LinkedList<Integer> Lbx;
  
  public td()
  {
    AppMethodBeat.i(133164);
    this.Lbx = new LinkedList();
    AppMethodBeat.o(133164);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133165);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Lbw);
      paramVarArgs.f(2, 2, this.Lbx);
      AppMethodBeat.o(133165);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Lbw);
      int i = g.a.a.a.d(2, 2, this.Lbx);
      AppMethodBeat.o(133165);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lbx.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(133165);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      td localtd = (td)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133165);
        return -1;
      case 1: 
        localtd.Lbw = locala.UbS.zi();
        AppMethodBeat.o(133165);
        return 0;
      }
      localtd.Lbx = new g.a.a.a.a(locala.UbS.hPo().zy, unknownTagHandler).UbS.hPm();
      AppMethodBeat.o(133165);
      return 0;
    }
    AppMethodBeat.o(133165);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.td
 * JD-Core Version:    0.7.0.1
 */