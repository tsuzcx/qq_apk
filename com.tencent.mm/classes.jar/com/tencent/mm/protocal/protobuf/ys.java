package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ys
  extends buy
{
  public String fKw;
  public String fKz;
  public String jJA;
  public int jKs;
  public long pIG;
  public int pIx;
  public int pIy;
  public int pIz;
  public String wPO;
  public int wPP;
  public int wPQ;
  public int wpR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(135756);
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
      paramVarArgs.aO(3, this.wpR);
      if (this.fKz != null) {
        paramVarArgs.e(4, this.fKz);
      }
      if (this.jJA != null) {
        paramVarArgs.e(5, this.jJA);
      }
      paramVarArgs.aO(6, this.pIx);
      paramVarArgs.aO(7, this.pIy);
      paramVarArgs.aO(8, this.pIz);
      if (this.wPO != null) {
        paramVarArgs.e(9, this.wPO);
      }
      paramVarArgs.aO(10, this.wPP);
      paramVarArgs.aO(11, this.jKs);
      paramVarArgs.aO(12, this.wPQ);
      paramVarArgs.am(13, this.pIG);
      AppMethodBeat.o(135756);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label922;
      }
    }
    label922:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fKw != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.fKw);
      }
      i += e.a.a.b.b.a.bl(3, this.wpR);
      paramInt = i;
      if (this.fKz != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.fKz);
      }
      i = paramInt;
      if (this.jJA != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.jJA);
      }
      i = i + e.a.a.b.b.a.bl(6, this.pIx) + e.a.a.b.b.a.bl(7, this.pIy) + e.a.a.b.b.a.bl(8, this.pIz);
      paramInt = i;
      if (this.wPO != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.wPO);
      }
      i = e.a.a.b.b.a.bl(10, this.wPP);
      int j = e.a.a.b.b.a.bl(11, this.jKs);
      int k = e.a.a.b.b.a.bl(12, this.wPQ);
      int m = e.a.a.b.b.a.p(13, this.pIG);
      AppMethodBeat.o(135756);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(135756);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ys localys = (ys)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(135756);
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
            localys.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(135756);
          return 0;
        case 2: 
          localys.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(135756);
          return 0;
        case 3: 
          localys.wpR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135756);
          return 0;
        case 4: 
          localys.fKz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(135756);
          return 0;
        case 5: 
          localys.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(135756);
          return 0;
        case 6: 
          localys.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135756);
          return 0;
        case 7: 
          localys.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135756);
          return 0;
        case 8: 
          localys.pIz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135756);
          return 0;
        case 9: 
          localys.wPO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(135756);
          return 0;
        case 10: 
          localys.wPP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135756);
          return 0;
        case 11: 
          localys.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135756);
          return 0;
        case 12: 
          localys.wPQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135756);
          return 0;
        }
        localys.pIG = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(135756);
        return 0;
      }
      AppMethodBeat.o(135756);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ys
 * JD-Core Version:    0.7.0.1
 */