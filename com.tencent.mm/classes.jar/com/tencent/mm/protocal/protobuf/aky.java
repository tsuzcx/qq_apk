package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aky
  extends buy
{
  public String jJA;
  public int pIx;
  public int pIy;
  public int xbU;
  public int xbV;
  public String xbW;
  public int xbX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80073);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jJA != null) {
        paramVarArgs.e(2, this.jJA);
      }
      paramVarArgs.aO(3, this.xbU);
      paramVarArgs.aO(4, this.xbV);
      if (this.xbW != null) {
        paramVarArgs.e(5, this.xbW);
      }
      paramVarArgs.aO(6, this.pIx);
      paramVarArgs.aO(7, this.pIy);
      paramVarArgs.aO(8, this.xbX);
      AppMethodBeat.o(80073);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jJA != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.jJA);
      }
      i = i + e.a.a.b.b.a.bl(3, this.xbU) + e.a.a.b.b.a.bl(4, this.xbV);
      paramInt = i;
      if (this.xbW != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xbW);
      }
      i = e.a.a.b.b.a.bl(6, this.pIx);
      int j = e.a.a.b.b.a.bl(7, this.pIy);
      int k = e.a.a.b.b.a.bl(8, this.xbX);
      AppMethodBeat.o(80073);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80073);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aky localaky = (aky)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80073);
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
            localaky.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80073);
          return 0;
        case 2: 
          localaky.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80073);
          return 0;
        case 3: 
          localaky.xbU = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80073);
          return 0;
        case 4: 
          localaky.xbV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80073);
          return 0;
        case 5: 
          localaky.xbW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80073);
          return 0;
        case 6: 
          localaky.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80073);
          return 0;
        case 7: 
          localaky.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80073);
          return 0;
        }
        localaky.xbX = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80073);
        return 0;
      }
      AppMethodBeat.o(80073);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aky
 * JD-Core Version:    0.7.0.1
 */