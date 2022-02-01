package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aes
  extends com.tencent.mm.bw.a
{
  public boolean ApK;
  public ffn LpZ;
  public LinkedList<ecf> Lqa;
  public int Lqb;
  public LinkedList<ffm> likeList;
  public int qwL;
  
  public aes()
  {
    AppMethodBeat.i(232371);
    this.Lqa = new LinkedList();
    this.likeList = new LinkedList();
    AppMethodBeat.o(232371);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(232372);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.qwL);
      if (this.LpZ != null)
      {
        paramVarArgs.ni(2, this.LpZ.computeSize());
        this.LpZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.Lqa);
      paramVarArgs.aM(4, this.Lqb);
      paramVarArgs.e(5, 8, this.likeList);
      paramVarArgs.cc(6, this.ApK);
      AppMethodBeat.o(232372);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.qwL) + 0;
      paramInt = i;
      if (this.LpZ != null) {
        paramInt = i + g.a.a.a.nh(2, this.LpZ.computeSize());
      }
      i = g.a.a.a.c(3, 8, this.Lqa);
      int j = g.a.a.b.b.a.bu(4, this.Lqb);
      int k = g.a.a.a.c(5, 8, this.likeList);
      int m = g.a.a.b.b.a.fS(6);
      AppMethodBeat.o(232372);
      return paramInt + i + j + k + (m + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lqa.clear();
      this.likeList.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(232372);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      aes localaes = (aes)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(232372);
        return -1;
      case 1: 
        localaes.qwL = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(232372);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ffn();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ffn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaes.LpZ = ((ffn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(232372);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ecf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ecf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaes.Lqa.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(232372);
        return 0;
      case 4: 
        localaes.Lqb = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(232372);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ffm();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ffm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaes.likeList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(232372);
        return 0;
      }
      localaes.ApK = ((g.a.a.a.a)localObject1).UbS.yZ();
      AppMethodBeat.o(232372);
      return 0;
    }
    AppMethodBeat.o(232372);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aes
 * JD-Core Version:    0.7.0.1
 */