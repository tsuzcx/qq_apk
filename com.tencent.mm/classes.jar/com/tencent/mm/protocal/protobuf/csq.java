package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csq
  extends buy
{
  public int Timestamp;
  public int wQP;
  public long wQQ;
  public long yab;
  public int ybh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5247);
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
      paramVarArgs.aO(4, this.Timestamp);
      paramVarArgs.am(5, this.yab);
      paramVarArgs.aO(6, this.ybh);
      AppMethodBeat.o(5247);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.wQP);
      int j = e.a.a.b.b.a.p(3, this.wQQ);
      int k = e.a.a.b.b.a.bl(4, this.Timestamp);
      int m = e.a.a.b.b.a.p(5, this.yab);
      int n = e.a.a.b.b.a.bl(6, this.ybh);
      AppMethodBeat.o(5247);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(5247);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        csq localcsq = (csq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5247);
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
            localcsq.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5247);
          return 0;
        case 2: 
          localcsq.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5247);
          return 0;
        case 3: 
          localcsq.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5247);
          return 0;
        case 4: 
          localcsq.Timestamp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5247);
          return 0;
        case 5: 
          localcsq.yab = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5247);
          return 0;
        }
        localcsq.ybh = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5247);
        return 0;
      }
      AppMethodBeat.o(5247);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csq
 * JD-Core Version:    0.7.0.1
 */