package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class we
  extends com.tencent.mm.bw.a
{
  public wd Lht;
  public wd Lhu;
  public wd Lhv;
  public wd Lhw;
  public wd Lhx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113984);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lht != null)
      {
        paramVarArgs.ni(1, this.Lht.computeSize());
        this.Lht.writeFields(paramVarArgs);
      }
      if (this.Lhu != null)
      {
        paramVarArgs.ni(2, this.Lhu.computeSize());
        this.Lhu.writeFields(paramVarArgs);
      }
      if (this.Lhv != null)
      {
        paramVarArgs.ni(3, this.Lhv.computeSize());
        this.Lhv.writeFields(paramVarArgs);
      }
      if (this.Lhw != null)
      {
        paramVarArgs.ni(4, this.Lhw.computeSize());
        this.Lhw.writeFields(paramVarArgs);
      }
      if (this.Lhx != null)
      {
        paramVarArgs.ni(5, this.Lhx.computeSize());
        this.Lhx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113984);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lht == null) {
        break label926;
      }
    }
    label926:
    for (int i = g.a.a.a.nh(1, this.Lht.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Lhu != null) {
        paramInt = i + g.a.a.a.nh(2, this.Lhu.computeSize());
      }
      i = paramInt;
      if (this.Lhv != null) {
        i = paramInt + g.a.a.a.nh(3, this.Lhv.computeSize());
      }
      paramInt = i;
      if (this.Lhw != null) {
        paramInt = i + g.a.a.a.nh(4, this.Lhw.computeSize());
      }
      i = paramInt;
      if (this.Lhx != null) {
        i = paramInt + g.a.a.a.nh(5, this.Lhx.computeSize());
      }
      AppMethodBeat.o(113984);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(113984);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        we localwe = (we)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113984);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localwe.Lht = ((wd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localwe.Lhu = ((wd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localwe.Lhv = ((wd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localwe.Lhw = ((wd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new wd();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((wd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localwe.Lhx = ((wd)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.we
 * JD-Core Version:    0.7.0.1
 */