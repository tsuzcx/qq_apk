package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdq
  extends buy
{
  public String xOk;
  public long xOl;
  public String xOm;
  public int xOn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94567);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xOk != null) {
        paramVarArgs.e(2, this.xOk);
      }
      paramVarArgs.am(3, this.xOl);
      if (this.xOm != null) {
        paramVarArgs.e(4, this.xOm);
      }
      paramVarArgs.aO(5, this.xOn);
      AppMethodBeat.o(94567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xOk != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xOk);
      }
      i += e.a.a.b.b.a.p(3, this.xOl);
      paramInt = i;
      if (this.xOm != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xOm);
      }
      i = e.a.a.b.b.a.bl(5, this.xOn);
      AppMethodBeat.o(94567);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94567);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cdq localcdq = (cdq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94567);
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
            localcdq.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94567);
          return 0;
        case 2: 
          localcdq.xOk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94567);
          return 0;
        case 3: 
          localcdq.xOl = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(94567);
          return 0;
        case 4: 
          localcdq.xOm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94567);
          return 0;
        }
        localcdq.xOn = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94567);
        return 0;
      }
      AppMethodBeat.o(94567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdq
 * JD-Core Version:    0.7.0.1
 */