package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amd
  extends com.tencent.mm.bw.a
{
  public FinderObject EDN;
  public ame EFC;
  public int dataType;
  public aml rDK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195097);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.dataType);
      if (this.EFC != null)
      {
        paramVarArgs.ln(2, this.EFC.computeSize());
        this.EFC.writeFields(paramVarArgs);
      }
      if (this.rDK != null)
      {
        paramVarArgs.ln(3, this.rDK.computeSize());
        this.rDK.writeFields(paramVarArgs);
      }
      if (this.EDN != null)
      {
        paramVarArgs.ln(4, this.EDN.computeSize());
        this.EDN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195097);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.dataType) + 0;
      paramInt = i;
      if (this.EFC != null) {
        paramInt = i + f.a.a.a.lm(2, this.EFC.computeSize());
      }
      i = paramInt;
      if (this.rDK != null) {
        i = paramInt + f.a.a.a.lm(3, this.rDK.computeSize());
      }
      paramInt = i;
      if (this.EDN != null) {
        paramInt = i + f.a.a.a.lm(4, this.EDN.computeSize());
      }
      AppMethodBeat.o(195097);
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
      AppMethodBeat.o(195097);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      amd localamd = (amd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(195097);
        return -1;
      case 1: 
        localamd.dataType = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(195097);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ame();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ame)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localamd.EFC = ((ame)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(195097);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aml();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aml)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localamd.rDK = ((aml)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(195097);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new FinderObject();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localamd.EDN = ((FinderObject)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(195097);
      return 0;
    }
    AppMethodBeat.o(195097);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amd
 * JD-Core Version:    0.7.0.1
 */