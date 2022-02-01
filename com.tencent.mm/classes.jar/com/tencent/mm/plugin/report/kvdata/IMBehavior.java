package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class IMBehavior
  extends com.tencent.mm.bw.a
{
  public IMBehaviorChattingOP chattingOp;
  public IMBehaviorMsgOP msgOp;
  public int opType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151535);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.opType);
      if (this.chattingOp != null)
      {
        paramVarArgs.ln(2, this.chattingOp.computeSize());
        this.chattingOp.writeFields(paramVarArgs);
      }
      if (this.msgOp != null)
      {
        paramVarArgs.ln(3, this.msgOp.computeSize());
        this.msgOp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(151535);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.opType) + 0;
      paramInt = i;
      if (this.chattingOp != null) {
        paramInt = i + f.a.a.a.lm(2, this.chattingOp.computeSize());
      }
      i = paramInt;
      if (this.msgOp != null) {
        i = paramInt + f.a.a.a.lm(3, this.msgOp.computeSize());
      }
      AppMethodBeat.o(151535);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(151535);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      IMBehavior localIMBehavior = (IMBehavior)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(151535);
        return -1;
      case 1: 
        localIMBehavior.opType = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(151535);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new IMBehaviorChattingOP();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((IMBehaviorChattingOP)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localIMBehavior.chattingOp = ((IMBehaviorChattingOP)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(151535);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new IMBehaviorMsgOP();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((IMBehaviorMsgOP)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localIMBehavior.msgOp = ((IMBehaviorMsgOP)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(151535);
      return 0;
    }
    AppMethodBeat.o(151535);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.IMBehavior
 * JD-Core Version:    0.7.0.1
 */