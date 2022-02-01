package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class air
  extends com.tencent.mm.bw.a
{
  public FinderCommentInfo EDq;
  public bqv EDr;
  public bqw EDs;
  public FinderCommentInfo EDt;
  public int actionType;
  public anm contextObj;
  public long qXu;
  public int rfR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168935);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.actionType);
      if (this.EDq != null)
      {
        paramVarArgs.ln(2, this.EDq.computeSize());
        this.EDq.writeFields(paramVarArgs);
      }
      if (this.EDr != null)
      {
        paramVarArgs.ln(3, this.EDr.computeSize());
        this.EDr.writeFields(paramVarArgs);
      }
      if (this.EDs != null)
      {
        paramVarArgs.ln(4, this.EDs.computeSize());
        this.EDs.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.qXu);
      if (this.EDt != null)
      {
        paramVarArgs.ln(6, this.EDt.computeSize());
        this.EDt.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.rfR);
      if (this.contextObj != null)
      {
        paramVarArgs.ln(8, this.contextObj.computeSize());
        this.contextObj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168935);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.actionType) + 0;
      paramInt = i;
      if (this.EDq != null) {
        paramInt = i + f.a.a.a.lm(2, this.EDq.computeSize());
      }
      i = paramInt;
      if (this.EDr != null) {
        i = paramInt + f.a.a.a.lm(3, this.EDr.computeSize());
      }
      paramInt = i;
      if (this.EDs != null) {
        paramInt = i + f.a.a.a.lm(4, this.EDs.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.qXu);
      paramInt = i;
      if (this.EDt != null) {
        paramInt = i + f.a.a.a.lm(6, this.EDt.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.rfR);
      paramInt = i;
      if (this.contextObj != null) {
        paramInt = i + f.a.a.a.lm(8, this.contextObj.computeSize());
      }
      AppMethodBeat.o(168935);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(168935);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      air localair = (air)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168935);
        return -1;
      case 1: 
        localair.actionType = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(168935);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderCommentInfo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localair.EDq = ((FinderCommentInfo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bqv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bqv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localair.EDr = ((bqv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bqw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bqw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localair.EDs = ((bqw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 5: 
        localair.qXu = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(168935);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderCommentInfo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localair.EDt = ((FinderCommentInfo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168935);
        return 0;
      case 7: 
        localair.rfR = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(168935);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new anm();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((anm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localair.contextObj = ((anm)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(168935);
      return 0;
    }
    AppMethodBeat.o(168935);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.air
 * JD-Core Version:    0.7.0.1
 */