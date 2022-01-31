package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnz
  extends buy
{
  public String nul;
  public int wQP;
  public long wQQ;
  public long xCj;
  public int xCk;
  public String xCl;
  public long xCm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28575);
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
      if (this.nul != null) {
        paramVarArgs.e(4, this.nul);
      }
      paramVarArgs.am(5, this.xCj);
      paramVarArgs.aO(6, this.xCk);
      if (this.xCl != null) {
        paramVarArgs.e(7, this.xCl);
      }
      paramVarArgs.am(8, this.xCm);
      AppMethodBeat.o(28575);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label668;
      }
    }
    label668:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wQP) + e.a.a.b.b.a.p(3, this.wQQ);
      paramInt = i;
      if (this.nul != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nul);
      }
      i = paramInt + e.a.a.b.b.a.p(5, this.xCj) + e.a.a.b.b.a.bl(6, this.xCk);
      paramInt = i;
      if (this.xCl != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xCl);
      }
      i = e.a.a.b.b.a.p(8, this.xCm);
      AppMethodBeat.o(28575);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28575);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bnz localbnz = (bnz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28575);
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
            localbnz.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28575);
          return 0;
        case 2: 
          localbnz.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28575);
          return 0;
        case 3: 
          localbnz.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(28575);
          return 0;
        case 4: 
          localbnz.nul = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28575);
          return 0;
        case 5: 
          localbnz.xCj = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(28575);
          return 0;
        case 6: 
          localbnz.xCk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28575);
          return 0;
        case 7: 
          localbnz.xCl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28575);
          return 0;
        }
        localbnz.xCm = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(28575);
        return 0;
      }
      AppMethodBeat.o(28575);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnz
 * JD-Core Version:    0.7.0.1
 */