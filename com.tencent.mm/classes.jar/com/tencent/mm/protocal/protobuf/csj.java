package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csj
  extends com.tencent.mm.bw.a
{
  public cic HDv;
  public ei HDw;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50100);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.HDv != null)
      {
        paramVarArgs.lJ(2, this.HDv.computeSize());
        this.HDv.writeFields(paramVarArgs);
      }
      if (this.HDw != null)
      {
        paramVarArgs.lJ(3, this.HDw.computeSize());
        this.HDw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(50100);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.HDv != null) {
        paramInt = i + f.a.a.a.lI(2, this.HDv.computeSize());
      }
      i = paramInt;
      if (this.HDw != null) {
        i = paramInt + f.a.a.a.lI(3, this.HDw.computeSize());
      }
      AppMethodBeat.o(50100);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(50100);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      csj localcsj = (csj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(50100);
        return -1;
      case 1: 
        localcsj.type = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(50100);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cic();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cic)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcsj.HDv = ((cic)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(50100);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ei();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ei)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcsj.HDw = ((ei)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(50100);
      return 0;
    }
    AppMethodBeat.o(50100);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csj
 * JD-Core Version:    0.7.0.1
 */