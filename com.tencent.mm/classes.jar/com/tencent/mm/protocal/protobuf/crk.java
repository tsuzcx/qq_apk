package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crk
  extends buy
{
  public int wLO;
  public int wQP;
  public long wQQ;
  public String xCG;
  public int xZW;
  public cta xZX;
  public cta xZY;
  public String xZZ;
  public int yaa;
  public long yab;
  public int yac;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5225);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wQP);
      paramVarArgs.am(3, this.wQQ);
      if (this.xCG != null) {
        paramVarArgs.e(4, this.xCG);
      }
      paramVarArgs.aO(5, this.xZW);
      if (this.xZX != null)
      {
        paramVarArgs.iQ(6, this.xZX.computeSize());
        this.xZX.writeFields(paramVarArgs);
      }
      if (this.xZY != null)
      {
        paramVarArgs.iQ(7, this.xZY.computeSize());
        this.xZY.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(8, this.wLO);
      if (this.xZZ != null) {
        paramVarArgs.e(9, this.xZZ);
      }
      paramVarArgs.aO(10, this.yaa);
      paramVarArgs.am(11, this.yab);
      paramVarArgs.aO(12, this.yac);
      AppMethodBeat.o(5225);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1080;
      }
    }
    label1080:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wQP) + e.a.a.b.b.a.p(3, this.wQQ);
      paramInt = i;
      if (this.xCG != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xCG);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.xZW);
      paramInt = i;
      if (this.xZX != null) {
        paramInt = i + e.a.a.a.iP(6, this.xZX.computeSize());
      }
      i = paramInt;
      if (this.xZY != null) {
        i = paramInt + e.a.a.a.iP(7, this.xZY.computeSize());
      }
      i += e.a.a.b.b.a.bl(8, this.wLO);
      paramInt = i;
      if (this.xZZ != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xZZ);
      }
      i = e.a.a.b.b.a.bl(10, this.yaa);
      int j = e.a.a.b.b.a.p(11, this.yab);
      int k = e.a.a.b.b.a.bl(12, this.yac);
      AppMethodBeat.o(5225);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(5225);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        crk localcrk = (crk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5225);
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
            localcrk.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5225);
          return 0;
        case 2: 
          localcrk.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5225);
          return 0;
        case 3: 
          localcrk.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5225);
          return 0;
        case 4: 
          localcrk.xCG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5225);
          return 0;
        case 5: 
          localcrk.xZW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5225);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cta();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cta)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcrk.xZX = ((cta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5225);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cta();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cta)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcrk.xZY = ((cta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5225);
          return 0;
        case 8: 
          localcrk.wLO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5225);
          return 0;
        case 9: 
          localcrk.xZZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5225);
          return 0;
        case 10: 
          localcrk.yaa = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5225);
          return 0;
        case 11: 
          localcrk.yab = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5225);
          return 0;
        }
        localcrk.yac = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5225);
        return 0;
      }
      AppMethodBeat.o(5225);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crk
 * JD-Core Version:    0.7.0.1
 */