package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abp
  extends com.tencent.mm.bw.a
{
  public cxk FLp;
  public zw GfE;
  public cwn GtE;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91426);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.GtE != null)
      {
        paramVarArgs.lJ(2, this.GtE.computeSize());
        this.GtE.writeFields(paramVarArgs);
      }
      if (this.FLp != null)
      {
        paramVarArgs.lJ(3, this.FLp.computeSize());
        this.FLp.writeFields(paramVarArgs);
      }
      if (this.GfE != null)
      {
        paramVarArgs.lJ(4, this.GfE.computeSize());
        this.GfE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91426);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.GtE != null) {
        paramInt = i + f.a.a.a.lI(2, this.GtE.computeSize());
      }
      i = paramInt;
      if (this.FLp != null) {
        i = paramInt + f.a.a.a.lI(3, this.FLp.computeSize());
      }
      paramInt = i;
      if (this.GfE != null) {
        paramInt = i + f.a.a.a.lI(4, this.GfE.computeSize());
      }
      AppMethodBeat.o(91426);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91426);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      abp localabp = (abp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91426);
        return -1;
      case 1: 
        localabp.type = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91426);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabp.GtE = ((cwn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91426);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabp.FLp = ((cxk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91426);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new zw();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((zw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localabp.GfE = ((zw)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91426);
      return 0;
    }
    AppMethodBeat.o(91426);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abp
 * JD-Core Version:    0.7.0.1
 */