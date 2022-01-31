package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wp
  extends buy
{
  public int Scene;
  public int eeF;
  public String wot;
  public LinkedList<wz> wov;
  
  public wp()
  {
    AppMethodBeat.i(5572);
    this.wov = new LinkedList();
    AppMethodBeat.o(5572);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5573);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.eeF);
      paramVarArgs.e(3, 8, this.wov);
      if (this.wot != null) {
        paramVarArgs.e(4, this.wot);
      }
      paramVarArgs.aO(5, this.Scene);
      AppMethodBeat.o(5573);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label609;
      }
    }
    label609:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.eeF) + e.a.a.a.c(3, 8, this.wov);
      paramInt = i;
      if (this.wot != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wot);
      }
      i = e.a.a.b.b.a.bl(5, this.Scene);
      AppMethodBeat.o(5573);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wov.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(5573);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        wp localwp = (wp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5573);
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
            localwp.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5573);
          return 0;
        case 2: 
          localwp.eeF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5573);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localwp.wov.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5573);
          return 0;
        case 4: 
          localwp.wot = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5573);
          return 0;
        }
        localwp.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5573);
        return 0;
      }
      AppMethodBeat.o(5573);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wp
 * JD-Core Version:    0.7.0.1
 */