package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class IMBehaviorMsgOP
  extends com.tencent.mm.cd.a
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
      paramVarArgs.aY(1, this.msgType);
      paramVarArgs.aY(2, this.msgOpType);
      paramVarArgs.aY(3, this.appMsgInnerType);
      paramVarArgs.aY(4, this.count);
      AppMethodBeat.o(151537);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.msgType);
      int i = g.a.a.b.b.a.bM(2, this.msgOpType);
      int j = g.a.a.b.b.a.bM(3, this.appMsgInnerType);
      int k = g.a.a.b.b.a.bM(4, this.count);
      AppMethodBeat.o(151537);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
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
        localIMBehaviorMsgOP.msgType = locala.abFh.AK();
        AppMethodBeat.o(151537);
        return 0;
      case 2: 
        localIMBehaviorMsgOP.msgOpType = locala.abFh.AK();
        AppMethodBeat.o(151537);
        return 0;
      case 3: 
        localIMBehaviorMsgOP.appMsgInnerType = locala.abFh.AK();
        AppMethodBeat.o(151537);
        return 0;
      }
      localIMBehaviorMsgOP.count = locala.abFh.AK();
      AppMethodBeat.o(151537);
      return 0;
    }
    AppMethodBeat.o(151537);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP
 * JD-Core Version:    0.7.0.1
 */