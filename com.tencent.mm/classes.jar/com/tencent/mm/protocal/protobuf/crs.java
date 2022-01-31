package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crs
  extends buy
{
  public long wQQ;
  public int wsD;
  public long xCj;
  public int xCk;
  public long xSP;
  public String yaH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(135443);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xCk);
      paramVarArgs.am(3, this.xSP);
      paramVarArgs.am(4, this.wQQ);
      if (this.yaH != null) {
        paramVarArgs.e(5, this.yaH);
      }
      paramVarArgs.am(6, this.xCj);
      paramVarArgs.aO(7, this.wsD);
      AppMethodBeat.o(135443);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label594;
      }
    }
    label594:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xCk) + e.a.a.b.b.a.p(3, this.xSP) + e.a.a.b.b.a.p(4, this.wQQ);
      paramInt = i;
      if (this.yaH != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.yaH);
      }
      i = e.a.a.b.b.a.p(6, this.xCj);
      int j = e.a.a.b.b.a.bl(7, this.wsD);
      AppMethodBeat.o(135443);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(135443);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        crs localcrs = (crs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(135443);
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
            localcrs.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(135443);
          return 0;
        case 2: 
          localcrs.xCk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135443);
          return 0;
        case 3: 
          localcrs.xSP = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(135443);
          return 0;
        case 4: 
          localcrs.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(135443);
          return 0;
        case 5: 
          localcrs.yaH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(135443);
          return 0;
        case 6: 
          localcrs.xCj = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(135443);
          return 0;
        }
        localcrs.wsD = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(135443);
        return 0;
      }
      AppMethodBeat.o(135443);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crs
 * JD-Core Version:    0.7.0.1
 */