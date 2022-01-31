package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cfo
  extends buy
{
  public String kbP;
  public int scene;
  public String son;
  public int xPV;
  public int xPW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56977);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.scene);
      if (this.son != null) {
        paramVarArgs.e(3, this.son);
      }
      if (this.kbP != null) {
        paramVarArgs.e(4, this.kbP);
      }
      paramVarArgs.aO(5, this.xPV);
      paramVarArgs.aO(6, this.xPW);
      AppMethodBeat.o(56977);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.scene);
      paramInt = i;
      if (this.son != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.son);
      }
      i = paramInt;
      if (this.kbP != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.kbP);
      }
      paramInt = e.a.a.b.b.a.bl(5, this.xPV);
      int j = e.a.a.b.b.a.bl(6, this.xPW);
      AppMethodBeat.o(56977);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56977);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cfo localcfo = (cfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56977);
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
            localcfo.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56977);
          return 0;
        case 2: 
          localcfo.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56977);
          return 0;
        case 3: 
          localcfo.son = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56977);
          return 0;
        case 4: 
          localcfo.kbP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56977);
          return 0;
        case 5: 
          localcfo.xPV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56977);
          return 0;
        }
        localcfo.xPW = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56977);
        return 0;
      }
      AppMethodBeat.o(56977);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfo
 * JD-Core Version:    0.7.0.1
 */