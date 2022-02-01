package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class baw
  extends com.tencent.mm.bw.a
{
  public LinkedList<bax> LKA;
  public LinkedList<cnt> LKB;
  public bav LKz;
  public long uUw;
  
  public baw()
  {
    AppMethodBeat.i(184206);
    this.LKA = new LinkedList();
    this.LKB = new LinkedList();
    AppMethodBeat.o(184206);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184207);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.uUw);
      if (this.LKz != null)
      {
        paramVarArgs.ni(2, this.LKz.computeSize());
        this.LKz.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.LKA);
      paramVarArgs.e(4, 8, this.LKB);
      AppMethodBeat.o(184207);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.uUw) + 0;
      paramInt = i;
      if (this.LKz != null) {
        paramInt = i + g.a.a.a.nh(2, this.LKz.computeSize());
      }
      i = g.a.a.a.c(3, 8, this.LKA);
      int j = g.a.a.a.c(4, 8, this.LKB);
      AppMethodBeat.o(184207);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LKA.clear();
      this.LKB.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(184207);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      baw localbaw = (baw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184207);
        return -1;
      case 1: 
        localbaw.uUw = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(184207);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bav();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bav)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbaw.LKz = ((bav)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(184207);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bax();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bax)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbaw.LKA.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(184207);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cnt();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cnt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localbaw.LKB.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(184207);
      return 0;
    }
    AppMethodBeat.o(184207);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baw
 * JD-Core Version:    0.7.0.1
 */