package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class IMBehaviorMsgOP
  extends com.tencent.mm.bv.a
{
  public int appMsgInnerType;
  public int count;
  public int msgOpType;
  public int msgType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(79151);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.msgType);
      paramVarArgs.aO(2, this.msgOpType);
      paramVarArgs.aO(3, this.appMsgInnerType);
      paramVarArgs.aO(4, this.count);
      AppMethodBeat.o(79151);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.msgType);
      int i = e.a.a.b.b.a.bl(2, this.msgOpType);
      int j = e.a.a.b.b.a.bl(3, this.appMsgInnerType);
      int k = e.a.a.b.b.a.bl(4, this.count);
      AppMethodBeat.o(79151);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(79151);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      IMBehaviorMsgOP localIMBehaviorMsgOP = (IMBehaviorMsgOP)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(79151);
        return -1;
      case 1: 
        localIMBehaviorMsgOP.msgType = locala.CLY.sl();
        AppMethodBeat.o(79151);
        return 0;
      case 2: 
        localIMBehaviorMsgOP.msgOpType = locala.CLY.sl();
        AppMethodBeat.o(79151);
        return 0;
      case 3: 
        localIMBehaviorMsgOP.appMsgInnerType = locala.CLY.sl();
        AppMethodBeat.o(79151);
        return 0;
      }
      localIMBehaviorMsgOP.count = locala.CLY.sl();
      AppMethodBeat.o(79151);
      return 0;
    }
    AppMethodBeat.o(79151);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP
 * JD-Core Version:    0.7.0.1
 */