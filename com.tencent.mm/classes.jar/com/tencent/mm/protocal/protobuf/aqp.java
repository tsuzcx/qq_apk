package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqp
  extends buy
{
  public String cwc;
  public int wDT;
  public String xfV;
  public String xfW;
  public int xfX;
  public int xfY = 4;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96228);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.cwc != null) {
        paramVarArgs.e(2, this.cwc);
      }
      if (this.xfV != null) {
        paramVarArgs.e(3, this.xfV);
      }
      if (this.xfW != null) {
        paramVarArgs.e(4, this.xfW);
      }
      paramVarArgs.aO(5, this.wDT);
      paramVarArgs.aO(6, this.xfX);
      paramVarArgs.aO(7, this.xfY);
      AppMethodBeat.o(96228);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cwc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.cwc);
      }
      i = paramInt;
      if (this.xfV != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xfV);
      }
      paramInt = i;
      if (this.xfW != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xfW);
      }
      i = e.a.a.b.b.a.bl(5, this.wDT);
      int j = e.a.a.b.b.a.bl(6, this.xfX);
      int k = e.a.a.b.b.a.bl(7, this.xfY);
      AppMethodBeat.o(96228);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96228);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aqp localaqp = (aqp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96228);
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
            localaqp.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96228);
          return 0;
        case 2: 
          localaqp.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96228);
          return 0;
        case 3: 
          localaqp.xfV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96228);
          return 0;
        case 4: 
          localaqp.xfW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96228);
          return 0;
        case 5: 
          localaqp.wDT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96228);
          return 0;
        case 6: 
          localaqp.xfX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96228);
          return 0;
        }
        localaqp.xfY = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(96228);
        return 0;
      }
      AppMethodBeat.o(96228);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqp
 * JD-Core Version:    0.7.0.1
 */