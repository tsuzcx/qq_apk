package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class IMBehavior
  extends com.tencent.mm.bx.a
{
  public IMBehaviorChattingOP chattingOp;
  public IMBehaviorMsgOP msgOp;
  public int opType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151535);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.opType);
      if (this.chattingOp != null)
      {
        paramVarArgs.qD(2, this.chattingOp.computeSize());
        this.chattingOp.writeFields(paramVarArgs);
      }
      if (this.msgOp != null)
      {
        paramVarArgs.qD(3, this.msgOp.computeSize());
        this.msgOp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(151535);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.opType) + 0;
      paramInt = i;
      if (this.chattingOp != null) {
        paramInt = i + i.a.a.a.qC(2, this.chattingOp.computeSize());
      }
      i = paramInt;
      if (this.msgOp != null) {
        i = paramInt + i.a.a.a.qC(3, this.msgOp.computeSize());
      }
      AppMethodBeat.o(151535);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(151535);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      IMBehavior localIMBehavior = (IMBehavior)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(151535);
        return -1;
      case 1: 
        localIMBehavior.opType = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(151535);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new IMBehaviorChattingOP();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((IMBehaviorChattingOP)localObject2).parseFrom((byte[])localObject1);
          }
          localIMBehavior.chattingOp = ((IMBehaviorChattingOP)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(151535);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new IMBehaviorMsgOP();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((IMBehaviorMsgOP)localObject2).parseFrom((byte[])localObject1);
        }
        localIMBehavior.msgOp = ((IMBehaviorMsgOP)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(151535);
      return 0;
    }
    AppMethodBeat.o(151535);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.IMBehavior
 * JD-Core Version:    0.7.0.1
 */