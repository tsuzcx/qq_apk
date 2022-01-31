package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axq
  extends buy
{
  public String fKw;
  public LinkedList<String> xmO;
  public int xmP;
  public int xmQ;
  public dam xmR;
  
  public axq()
  {
    AppMethodBeat.i(96252);
    this.xmO = new LinkedList();
    AppMethodBeat.o(96252);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96253);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fKw != null) {
        paramVarArgs.e(2, this.fKw);
      }
      paramVarArgs.e(3, 1, this.xmO);
      paramVarArgs.aO(4, this.xmP);
      paramVarArgs.aO(5, this.xmQ);
      if (this.xmR != null)
      {
        paramVarArgs.iQ(6, this.xmR.computeSize());
        this.xmR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(96253);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fKw != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.fKw);
      }
      i = i + e.a.a.a.c(3, 1, this.xmO) + e.a.a.b.b.a.bl(4, this.xmP) + e.a.a.b.b.a.bl(5, this.xmQ);
      paramInt = i;
      if (this.xmR != null) {
        paramInt = i + e.a.a.a.iP(6, this.xmR.computeSize());
      }
      AppMethodBeat.o(96253);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xmO.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96253);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        axq localaxq = (axq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96253);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaxq.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96253);
          return 0;
        case 2: 
          localaxq.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96253);
          return 0;
        case 3: 
          localaxq.xmO.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(96253);
          return 0;
        case 4: 
          localaxq.xmP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96253);
          return 0;
        case 5: 
          localaxq.xmQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96253);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dam();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dam)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaxq.xmR = ((dam)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(96253);
        return 0;
      }
      AppMethodBeat.o(96253);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axq
 * JD-Core Version:    0.7.0.1
 */