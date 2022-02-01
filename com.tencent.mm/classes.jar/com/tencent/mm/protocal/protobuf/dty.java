package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dty
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> HZD;
  public int OpCode;
  
  public dty()
  {
    AppMethodBeat.i(104845);
    this.HZD = new LinkedList();
    AppMethodBeat.o(104845);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104846);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.OpCode);
      paramVarArgs.e(2, 1, this.HZD);
      AppMethodBeat.o(104846);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.OpCode);
      int i = f.a.a.a.c(2, 1, this.HZD);
      AppMethodBeat.o(104846);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HZD.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(104846);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dty localdty = (dty)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104846);
        return -1;
      case 1: 
        localdty.OpCode = locala.OmT.zc();
        AppMethodBeat.o(104846);
        return 0;
      }
      localdty.HZD.add(locala.OmT.readString());
      AppMethodBeat.o(104846);
      return 0;
    }
    AppMethodBeat.o(104846);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dty
 * JD-Core Version:    0.7.0.1
 */