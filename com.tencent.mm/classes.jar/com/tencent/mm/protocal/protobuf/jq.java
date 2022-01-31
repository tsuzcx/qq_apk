package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class jq
  extends buy
{
  public int wsW;
  public String wvA;
  public String wvB;
  public String wvC;
  public String wvD;
  public String wvE;
  public String wvF;
  public int wvy;
  public String wvz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73693);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wsW);
      paramVarArgs.aO(3, this.wvy);
      if (this.wvz != null) {
        paramVarArgs.e(4, this.wvz);
      }
      if (this.wvA != null) {
        paramVarArgs.e(5, this.wvA);
      }
      if (this.wvB != null) {
        paramVarArgs.e(6, this.wvB);
      }
      if (this.wvC != null) {
        paramVarArgs.e(7, this.wvC);
      }
      if (this.wvD != null) {
        paramVarArgs.e(8, this.wvD);
      }
      if (this.wvE != null) {
        paramVarArgs.e(9, this.wvE);
      }
      if (this.wvF != null) {
        paramVarArgs.e(10, this.wvF);
      }
      AppMethodBeat.o(73693);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label826;
      }
    }
    label826:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wsW) + e.a.a.b.b.a.bl(3, this.wvy);
      paramInt = i;
      if (this.wvz != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wvz);
      }
      i = paramInt;
      if (this.wvA != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wvA);
      }
      paramInt = i;
      if (this.wvB != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wvB);
      }
      i = paramInt;
      if (this.wvC != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wvC);
      }
      paramInt = i;
      if (this.wvD != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wvD);
      }
      i = paramInt;
      if (this.wvE != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wvE);
      }
      paramInt = i;
      if (this.wvF != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wvF);
      }
      AppMethodBeat.o(73693);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(73693);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        jq localjq = (jq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(73693);
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
            localjq.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73693);
          return 0;
        case 2: 
          localjq.wsW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73693);
          return 0;
        case 3: 
          localjq.wvy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73693);
          return 0;
        case 4: 
          localjq.wvz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73693);
          return 0;
        case 5: 
          localjq.wvA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73693);
          return 0;
        case 6: 
          localjq.wvB = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73693);
          return 0;
        case 7: 
          localjq.wvC = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73693);
          return 0;
        case 8: 
          localjq.wvD = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73693);
          return 0;
        case 9: 
          localjq.wvE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73693);
          return 0;
        }
        localjq.wvF = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(73693);
        return 0;
      }
      AppMethodBeat.o(73693);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jq
 * JD-Core Version:    0.7.0.1
 */