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
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.msgType);
      paramVarArgs.aS(2, this.msgOpType);
      paramVarArgs.aS(3, this.appMsgInnerType);
      paramVarArgs.aS(4, this.count);
      AppMethodBeat.o(151537);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.msgType);
      int i = f.a.a.b.b.a.bz(2, this.msgOpType);
      int j = f.a.a.b.b.a.bz(3, this.appMsgInnerType);
      int k = f.a.a.b.b.a.bz(4, this.count);
      AppMethodBeat.o(151537);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(151537);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      IMBehaviorMsgOP localIMBehaviorMsgOP = (IMBehaviorMsgOP)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151537);
        return -1;
      case 1: 
        localIMBehaviorMsgOP.msgType = locala.NPN.zc();
        AppMethodBeat.o(151537);
        return 0;
      case 2: 
        localIMBehaviorMsgOP.msgOpType = locala.NPN.zc();
        AppMethodBeat.o(151537);
        return 0;
      case 3: 
        localIMBehaviorMsgOP.appMsgInnerType = locala.NPN.zc();
        AppMethodBeat.o(151537);
        return 0;
      }
      localIMBehaviorMsgOP.count = locala.NPN.zc();
      AppMethodBeat.o(151537);
      return 0;
    }
    AppMethodBeat.o(151537);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP
 * JD-Core Version:    0.7.0.1
 */