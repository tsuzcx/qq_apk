package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ExchangeEmotionPackRequest
  extends buy
{
  public int IsAutomatic;
  public String ProductID;
  public int Scene;
  public String SeriesID;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62546);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.e(2, this.ProductID);
      }
      if (this.SeriesID != null) {
        paramVarArgs.e(3, this.SeriesID);
      }
      paramVarArgs.aO(4, this.IsAutomatic);
      paramVarArgs.aO(5, this.Scene);
      AppMethodBeat.o(62546);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.ProductID);
      }
      i = paramInt;
      if (this.SeriesID != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.SeriesID);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.IsAutomatic);
      int j = e.a.a.b.b.a.bl(5, this.Scene);
      AppMethodBeat.o(62546);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(62546);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ExchangeEmotionPackRequest localExchangeEmotionPackRequest = (ExchangeEmotionPackRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(62546);
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
            localExchangeEmotionPackRequest.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62546);
          return 0;
        case 2: 
          localExchangeEmotionPackRequest.ProductID = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(62546);
          return 0;
        case 3: 
          localExchangeEmotionPackRequest.SeriesID = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(62546);
          return 0;
        case 4: 
          localExchangeEmotionPackRequest.IsAutomatic = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(62546);
          return 0;
        }
        localExchangeEmotionPackRequest.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(62546);
        return 0;
      }
      AppMethodBeat.o(62546);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ExchangeEmotionPackRequest
 * JD-Core Version:    0.7.0.1
 */