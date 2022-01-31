package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class IMBehavior
  extends com.tencent.mm.bv.a
{
  public IMBehaviorChattingOP chattingOp;
  public IMBehaviorMsgOP msgOp;
  public int opType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(79149);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.opType);
      if (this.chattingOp != null)
      {
        paramVarArgs.iQ(2, this.chattingOp.computeSize());
        this.chattingOp.writeFields(paramVarArgs);
      }
      if (this.msgOp != null)
      {
        paramVarArgs.iQ(3, this.msgOp.computeSize());
        this.msgOp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(79149);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.opType) + 0;
      paramInt = i;
      if (this.chattingOp != null) {
        paramInt = i + e.a.a.a.iP(2, this.chattingOp.computeSize());
      }
      i = paramInt;
      if (this.msgOp != null) {
        i = paramInt + e.a.a.a.iP(3, this.msgOp.computeSize());
      }
      AppMethodBeat.o(79149);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(79149);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      IMBehavior localIMBehavior = (IMBehavior)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(79149);
        return -1;
      case 1: 
        localIMBehavior.opType = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(79149);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new IMBehaviorChattingOP();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((IMBehaviorChattingOP)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localIMBehavior.chattingOp = ((IMBehaviorChattingOP)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(79149);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new IMBehaviorMsgOP();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((IMBehaviorMsgOP)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localIMBehavior.msgOp = ((IMBehaviorMsgOP)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(79149);
      return 0;
    }
    AppMethodBeat.o(79149);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.IMBehavior
 * JD-Core Version:    0.7.0.1
 */