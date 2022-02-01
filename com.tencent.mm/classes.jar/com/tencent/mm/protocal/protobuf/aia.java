package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aia
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> EBW;
  public LinkedList<String> EBX;
  
  public aia()
  {
    AppMethodBeat.i(127490);
    this.EBW = new LinkedList();
    this.EBX = new LinkedList();
    AppMethodBeat.o(127490);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127491);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.EBW);
      paramVarArgs.e(2, 1, this.EBX);
      AppMethodBeat.o(127491);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 1, this.EBW);
      int i = f.a.a.a.c(2, 1, this.EBX);
      AppMethodBeat.o(127491);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EBW.clear();
      this.EBX.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(127491);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aia localaia = (aia)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127491);
        return -1;
      case 1: 
        localaia.EBW.add(locala.LVo.readString());
        AppMethodBeat.o(127491);
        return 0;
      }
      localaia.EBX.add(locala.LVo.readString());
      AppMethodBeat.o(127491);
      return 0;
    }
    AppMethodBeat.o(127491);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aia
 * JD-Core Version:    0.7.0.1
 */