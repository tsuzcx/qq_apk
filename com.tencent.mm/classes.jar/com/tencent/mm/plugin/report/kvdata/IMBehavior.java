package com.tencent.mm.plugin.report.kvdata;

import java.util.LinkedList;

public class IMBehavior
  extends com.tencent.mm.bv.a
{
  public IMBehaviorChattingOP chattingOp;
  public IMBehaviorMsgOP msgOp;
  public int opType;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.opType);
      if (this.chattingOp != null)
      {
        paramVarArgs.gD(2, this.chattingOp.btq());
        this.chattingOp.a(paramVarArgs);
      }
      if (this.msgOp != null)
      {
        paramVarArgs.gD(3, this.msgOp.btq());
        this.msgOp.a(paramVarArgs);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.opType) + 0;
      paramInt = i;
      if (this.chattingOp != null) {
        paramInt = i + d.a.a.a.gA(2, this.chattingOp.btq());
      }
      i = paramInt;
    } while (this.msgOp == null);
    return paramInt + d.a.a.a.gA(3, this.msgOp.btq());
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      IMBehavior localIMBehavior = (IMBehavior)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localIMBehavior.opType = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new IMBehaviorChattingOP();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((IMBehaviorChattingOP)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localIMBehavior.chattingOp = ((IMBehaviorChattingOP)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new IMBehaviorMsgOP();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((IMBehaviorMsgOP)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localIMBehavior.msgOp = ((IMBehaviorMsgOP)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.IMBehavior
 * JD-Core Version:    0.7.0.1
 */