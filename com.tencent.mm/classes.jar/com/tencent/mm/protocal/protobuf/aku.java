package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aku
  extends buy
{
  public String fKw;
  public String xbR;
  public String xbS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94528);
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
      if (this.xbR != null) {
        paramVarArgs.e(3, this.xbR);
      }
      if (this.xbS != null) {
        paramVarArgs.e(4, this.xbS);
      }
      AppMethodBeat.o(94528);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fKw != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.fKw);
      }
      i = paramInt;
      if (this.xbR != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xbR);
      }
      paramInt = i;
      if (this.xbS != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xbS);
      }
      AppMethodBeat.o(94528);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94528);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aku localaku = (aku)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94528);
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
            localaku.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94528);
          return 0;
        case 2: 
          localaku.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94528);
          return 0;
        case 3: 
          localaku.xbR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94528);
          return 0;
        }
        localaku.xbS = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94528);
        return 0;
      }
      AppMethodBeat.o(94528);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aku
 * JD-Core Version:    0.7.0.1
 */