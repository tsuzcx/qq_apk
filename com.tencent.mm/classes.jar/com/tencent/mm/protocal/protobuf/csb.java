package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csb
  extends com.tencent.mm.bw.a
{
  public ehd HDf;
  public ehc HDg;
  public ehc HDh;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208304);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.version);
      if (this.HDf != null)
      {
        paramVarArgs.lJ(2, this.HDf.computeSize());
        this.HDf.writeFields(paramVarArgs);
      }
      if (this.HDg != null)
      {
        paramVarArgs.lJ(3, this.HDg.computeSize());
        this.HDg.writeFields(paramVarArgs);
      }
      if (this.HDh != null)
      {
        paramVarArgs.lJ(4, this.HDh.computeSize());
        this.HDh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(208304);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.version) + 0;
      paramInt = i;
      if (this.HDf != null) {
        paramInt = i + f.a.a.a.lI(2, this.HDf.computeSize());
      }
      i = paramInt;
      if (this.HDg != null) {
        i = paramInt + f.a.a.a.lI(3, this.HDg.computeSize());
      }
      paramInt = i;
      if (this.HDh != null) {
        paramInt = i + f.a.a.a.lI(4, this.HDh.computeSize());
      }
      AppMethodBeat.o(208304);
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
      AppMethodBeat.o(208304);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      csb localcsb = (csb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(208304);
        return -1;
      case 1: 
        localcsb.version = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(208304);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ehd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ehd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcsb.HDf = ((ehd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(208304);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ehc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ehc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcsb.HDg = ((ehc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(208304);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ehc();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ehc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcsb.HDh = ((ehc)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(208304);
      return 0;
    }
    AppMethodBeat.o(208304);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csb
 * JD-Core Version:    0.7.0.1
 */