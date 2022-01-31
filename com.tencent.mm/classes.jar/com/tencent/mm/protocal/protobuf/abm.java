package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abm
  extends buy
{
  public int nrS;
  public String wRO;
  public String wRP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73704);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.nrS);
      if (this.wRO != null) {
        paramVarArgs.e(3, this.wRO);
      }
      if (this.wRP != null) {
        paramVarArgs.e(4, this.wRP);
      }
      AppMethodBeat.o(73704);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.nrS);
      paramInt = i;
      if (this.wRO != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wRO);
      }
      i = paramInt;
      if (this.wRP != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wRP);
      }
      AppMethodBeat.o(73704);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(73704);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        abm localabm = (abm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(73704);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localabm.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73704);
          return 0;
        case 2: 
          localabm.nrS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73704);
          return 0;
        case 3: 
          localabm.wRO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73704);
          return 0;
        }
        localabm.wRP = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(73704);
        return 0;
      }
      AppMethodBeat.o(73704);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abm
 * JD-Core Version:    0.7.0.1
 */