package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class sa
  extends com.tencent.mm.bw.a
{
  public LinkedList<eye> KZA;
  public LinkedList<ahp> KZB;
  public LinkedList<fbp> KZC;
  public dnn KZD;
  public b KZE;
  public LinkedList<czb> KZF;
  public LinkedList<ps> KZz;
  public int oUv;
  
  public sa()
  {
    AppMethodBeat.i(117848);
    this.KZz = new LinkedList();
    this.KZA = new LinkedList();
    this.KZB = new LinkedList();
    this.KZC = new LinkedList();
    this.KZF = new LinkedList();
    AppMethodBeat.o(117848);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117849);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.oUv);
      paramVarArgs.e(2, 8, this.KZz);
      paramVarArgs.e(3, 8, this.KZA);
      paramVarArgs.e(4, 8, this.KZB);
      paramVarArgs.e(5, 8, this.KZC);
      if (this.KZD != null)
      {
        paramVarArgs.ni(6, this.KZD.computeSize());
        this.KZD.writeFields(paramVarArgs);
      }
      if (this.KZE != null) {
        paramVarArgs.c(7, this.KZE);
      }
      paramVarArgs.e(8, 8, this.KZF);
      AppMethodBeat.o(117849);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.oUv) + 0 + g.a.a.a.c(2, 8, this.KZz) + g.a.a.a.c(3, 8, this.KZA) + g.a.a.a.c(4, 8, this.KZB) + g.a.a.a.c(5, 8, this.KZC);
      paramInt = i;
      if (this.KZD != null) {
        paramInt = i + g.a.a.a.nh(6, this.KZD.computeSize());
      }
      i = paramInt;
      if (this.KZE != null) {
        i = paramInt + g.a.a.b.b.a.b(7, this.KZE);
      }
      paramInt = g.a.a.a.c(8, 8, this.KZF);
      AppMethodBeat.o(117849);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KZz.clear();
      this.KZA.clear();
      this.KZB.clear();
      this.KZC.clear();
      this.KZF.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(117849);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      sa localsa = (sa)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117849);
        return -1;
      case 1: 
        localsa.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117849);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ps();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ps)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localsa.KZz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eye();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eye)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localsa.KZA.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahp();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ahp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localsa.KZB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fbp();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fbp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localsa.KZC.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dnn();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dnn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localsa.KZD = ((dnn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 7: 
        localsa.KZE = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(117849);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new czb();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((czb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localsa.KZF.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117849);
      return 0;
    }
    AppMethodBeat.o(117849);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sa
 * JD-Core Version:    0.7.0.1
 */