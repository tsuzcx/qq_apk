package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uv
  extends com.tencent.mm.bx.a
{
  public uu FUq;
  public uu FUr;
  public uu FUs;
  public uu FUt;
  public uu FUu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113984);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FUq != null)
      {
        paramVarArgs.lC(1, this.FUq.computeSize());
        this.FUq.writeFields(paramVarArgs);
      }
      if (this.FUr != null)
      {
        paramVarArgs.lC(2, this.FUr.computeSize());
        this.FUr.writeFields(paramVarArgs);
      }
      if (this.FUs != null)
      {
        paramVarArgs.lC(3, this.FUs.computeSize());
        this.FUs.writeFields(paramVarArgs);
      }
      if (this.FUt != null)
      {
        paramVarArgs.lC(4, this.FUt.computeSize());
        this.FUt.writeFields(paramVarArgs);
      }
      if (this.FUu != null)
      {
        paramVarArgs.lC(5, this.FUu.computeSize());
        this.FUu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113984);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FUq == null) {
        break label926;
      }
    }
    label926:
    for (int i = f.a.a.a.lB(1, this.FUq.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FUr != null) {
        paramInt = i + f.a.a.a.lB(2, this.FUr.computeSize());
      }
      i = paramInt;
      if (this.FUs != null) {
        i = paramInt + f.a.a.a.lB(3, this.FUs.computeSize());
      }
      paramInt = i;
      if (this.FUt != null) {
        paramInt = i + f.a.a.a.lB(4, this.FUt.computeSize());
      }
      i = paramInt;
      if (this.FUu != null) {
        i = paramInt + f.a.a.a.lB(5, this.FUu.computeSize());
      }
      AppMethodBeat.o(113984);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(113984);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        uv localuv = (uv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113984);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuv.FUq = ((uu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuv.FUr = ((uu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuv.FUs = ((uu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuv.FUt = ((uu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new uu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((uu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localuv.FUu = ((uu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113984);
        return 0;
      }
      AppMethodBeat.o(113984);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uv
 * JD-Core Version:    0.7.0.1
 */