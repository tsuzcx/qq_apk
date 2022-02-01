package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class IMBehaviorMsgOP
  extends com.tencent.mm.bw.a
{
  public int appMsgInnerType;
  public int count;
  public int msgOpType;
  public int msgType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151537);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.msgType);
      paramVarArgs.aM(2, this.msgOpType);
      paramVarArgs.aM(3, this.appMsgInnerType);
      paramVarArgs.aM(4, this.count);
      AppMethodBeat.o(151537);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.msgType);
      int i = g.a.a.b.b.a.bu(2, this.msgOpType);
      int j = g.a.a.b.b.a.bu(3, this.appMsgInnerType);
      int k = g.a.a.b.b.a.bu(4, this.count);
      AppMethodBeat.o(151537);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(151537);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      IMBehaviorMsgOP localIMBehaviorMsgOP = (IMBehaviorMsgOP)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151537);
        return -1;
      case 1: 
        localIMBehaviorMsgOP.msgType = locala.UbS.zi();
        AppMethodBeat.o(151537);
        return 0;
      case 2: 
        localIMBehaviorMsgOP.msgOpType = locala.UbS.zi();
        AppMethodBeat.o(151537);
        return 0;
      case 3: 
        localIMBehaviorMsgOP.appMsgInnerType = locala.UbS.zi();
        AppMethodBeat.o(151537);
        return 0;
      }
      localIMBehaviorMsgOP.count = locala.UbS.zi();
      AppMethodBeat.o(151537);
      return 0;
    }
    AppMethodBeat.o(151537);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP
 * JD-Core Version:    0.7.0.1
 */