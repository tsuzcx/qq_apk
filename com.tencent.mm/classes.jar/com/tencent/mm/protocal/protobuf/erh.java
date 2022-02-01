package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class erh
  extends com.tencent.mm.bw.a
{
  public LinkedList<cmu> GzC;
  public long KPe;
  public LinkedList<aiv> MoI;
  public csq NoU;
  public LinkedList<ehe> NoV;
  
  public erh()
  {
    AppMethodBeat.i(110917);
    this.NoV = new LinkedList();
    this.MoI = new LinkedList();
    this.GzC = new LinkedList();
    AppMethodBeat.o(110917);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110918);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.KPe);
      if (this.NoU != null)
      {
        paramVarArgs.ni(2, this.NoU.computeSize());
        this.NoU.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.NoV);
      paramVarArgs.e(4, 8, this.MoI);
      paramVarArgs.e(5, 8, this.GzC);
      AppMethodBeat.o(110918);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.KPe) + 0;
      paramInt = i;
      if (this.NoU != null) {
        paramInt = i + g.a.a.a.nh(2, this.NoU.computeSize());
      }
      i = g.a.a.a.c(3, 8, this.NoV);
      int j = g.a.a.a.c(4, 8, this.MoI);
      int k = g.a.a.a.c(5, 8, this.GzC);
      AppMethodBeat.o(110918);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.NoV.clear();
      this.MoI.clear();
      this.GzC.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(110918);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      erh localerh = (erh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110918);
        return -1;
      case 1: 
        localerh.KPe = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110918);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new csq();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((csq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localerh.NoU = ((csq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ehe();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ehe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localerh.NoV.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aiv();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aiv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localerh.MoI.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cmu();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cmu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localerh.GzC.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(110918);
      return 0;
    }
    AppMethodBeat.o(110918);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erh
 * JD-Core Version:    0.7.0.1
 */