package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class enw
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> NlK;
  public int OpCode;
  
  public enw()
  {
    AppMethodBeat.i(104845);
    this.NlK = new LinkedList();
    AppMethodBeat.o(104845);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104846);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.OpCode);
      paramVarArgs.e(2, 1, this.NlK);
      AppMethodBeat.o(104846);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.OpCode);
      int i = g.a.a.a.c(2, 1, this.NlK);
      AppMethodBeat.o(104846);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.NlK.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(104846);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      enw localenw = (enw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104846);
        return -1;
      case 1: 
        localenw.OpCode = locala.UbS.zi();
        AppMethodBeat.o(104846);
        return 0;
      }
      localenw.NlK.add(locala.UbS.readString());
      AppMethodBeat.o(104846);
      return 0;
    }
    AppMethodBeat.o(104846);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enw
 * JD-Core Version:    0.7.0.1
 */