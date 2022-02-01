package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ExchangeEmotionPackRequest
  extends dop
{
  public int IsAutomatic;
  public String ProductID;
  public int Scene;
  public String SeriesID;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104782);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.e(2, this.ProductID);
      }
      if (this.SeriesID != null) {
        paramVarArgs.e(3, this.SeriesID);
      }
      paramVarArgs.aM(4, this.IsAutomatic);
      paramVarArgs.aM(5, this.Scene);
      AppMethodBeat.o(104782);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.ProductID);
      }
      i = paramInt;
      if (this.SeriesID != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.SeriesID);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.IsAutomatic);
      int j = g.a.a.b.b.a.bu(5, this.Scene);
      AppMethodBeat.o(104782);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(104782);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ExchangeEmotionPackRequest localExchangeEmotionPackRequest = (ExchangeEmotionPackRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104782);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localExchangeEmotionPackRequest.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104782);
          return 0;
        case 2: 
          localExchangeEmotionPackRequest.ProductID = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104782);
          return 0;
        case 3: 
          localExchangeEmotionPackRequest.SeriesID = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104782);
          return 0;
        case 4: 
          localExchangeEmotionPackRequest.IsAutomatic = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104782);
          return 0;
        }
        localExchangeEmotionPackRequest.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(104782);
        return 0;
      }
      AppMethodBeat.o(104782);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ExchangeEmotionPackRequest
 * JD-Core Version:    0.7.0.1
 */