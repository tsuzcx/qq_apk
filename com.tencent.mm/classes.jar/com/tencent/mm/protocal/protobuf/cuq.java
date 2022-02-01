package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cuq
  extends dop
{
  public int KRg;
  public int MzW;
  public LinkedList<cus> MzX;
  public LinkedList<cup> MzY;
  public int source;
  
  public cuq()
  {
    AppMethodBeat.i(6413);
    this.MzX = new LinkedList();
    this.MzY = new LinkedList();
    AppMethodBeat.o(6413);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6414);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.MzW);
      paramVarArgs.aM(3, this.KRg);
      paramVarArgs.e(4, 8, this.MzX);
      paramVarArgs.e(5, 8, this.MzY);
      paramVarArgs.aM(6, this.source);
      AppMethodBeat.o(6414);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.MzW);
      int j = g.a.a.b.b.a.bu(3, this.KRg);
      int k = g.a.a.a.c(4, 8, this.MzX);
      int m = g.a.a.a.c(5, 8, this.MzY);
      int n = g.a.a.b.b.a.bu(6, this.source);
      AppMethodBeat.o(6414);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MzX.clear();
        this.MzY.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(6414);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cuq localcuq = (cuq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6414);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcuq.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6414);
          return 0;
        case 2: 
          localcuq.MzW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(6414);
          return 0;
        case 3: 
          localcuq.KRg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(6414);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cus();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cus)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcuq.MzX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6414);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cup();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cup)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcuq.MzY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6414);
          return 0;
        }
        localcuq.source = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(6414);
        return 0;
      }
      AppMethodBeat.o(6414);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuq
 * JD-Core Version:    0.7.0.1
 */