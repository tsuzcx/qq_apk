package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvq
  extends buy
{
  public int CreateTime;
  public String nul;
  public String num;
  public String wpS;
  public int xJj;
  public int xJk;
  public int xJl;
  public long xJm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28618);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wpS != null) {
        paramVarArgs.e(2, this.wpS);
      }
      paramVarArgs.aO(3, this.xJj);
      paramVarArgs.aO(4, this.CreateTime);
      paramVarArgs.aO(5, this.xJk);
      if (this.num != null) {
        paramVarArgs.e(6, this.num);
      }
      if (this.nul != null) {
        paramVarArgs.e(7, this.nul);
      }
      paramVarArgs.aO(8, this.xJl);
      paramVarArgs.am(9, this.xJm);
      AppMethodBeat.o(28618);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label733;
      }
    }
    label733:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wpS != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wpS);
      }
      i = i + e.a.a.b.b.a.bl(3, this.xJj) + e.a.a.b.b.a.bl(4, this.CreateTime) + e.a.a.b.b.a.bl(5, this.xJk);
      paramInt = i;
      if (this.num != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.num);
      }
      i = paramInt;
      if (this.nul != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.nul);
      }
      paramInt = e.a.a.b.b.a.bl(8, this.xJl);
      int j = e.a.a.b.b.a.p(9, this.xJm);
      AppMethodBeat.o(28618);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28618);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bvq localbvq = (bvq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28618);
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
            localbvq.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28618);
          return 0;
        case 2: 
          localbvq.wpS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28618);
          return 0;
        case 3: 
          localbvq.xJj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28618);
          return 0;
        case 4: 
          localbvq.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28618);
          return 0;
        case 5: 
          localbvq.xJk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28618);
          return 0;
        case 6: 
          localbvq.num = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28618);
          return 0;
        case 7: 
          localbvq.nul = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28618);
          return 0;
        case 8: 
          localbvq.xJl = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28618);
          return 0;
        }
        localbvq.xJm = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(28618);
        return 0;
      }
      AppMethodBeat.o(28618);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvq
 * JD-Core Version:    0.7.0.1
 */