package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class IMBehaviorMsgOP
  extends com.tencent.mm.bx.a
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
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.msgType);
      paramVarArgs.bS(2, this.msgOpType);
      paramVarArgs.bS(3, this.appMsgInnerType);
      paramVarArgs.bS(4, this.count);
      AppMethodBeat.o(151537);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.msgType);
      int i = i.a.a.b.b.a.cJ(2, this.msgOpType);
      int j = i.a.a.b.b.a.cJ(3, this.appMsgInnerType);
      int k = i.a.a.b.b.a.cJ(4, this.count);
      AppMethodBeat.o(151537);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(151537);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      IMBehaviorMsgOP localIMBehaviorMsgOP = (IMBehaviorMsgOP)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151537);
        return -1;
      case 1: 
        localIMBehaviorMsgOP.msgType = locala.ajGk.aar();
        AppMethodBeat.o(151537);
        return 0;
      case 2: 
        localIMBehaviorMsgOP.msgOpType = locala.ajGk.aar();
        AppMethodBeat.o(151537);
        return 0;
      case 3: 
        localIMBehaviorMsgOP.appMsgInnerType = locala.ajGk.aar();
        AppMethodBeat.o(151537);
        return 0;
      }
      localIMBehaviorMsgOP.count = locala.ajGk.aar();
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