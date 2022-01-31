package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bja
  extends buy
{
  public String tNy;
  public String wvn;
  public String xxz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56871);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wvn != null) {
        paramVarArgs.e(2, this.wvn);
      }
      if (this.xxz != null) {
        paramVarArgs.e(3, this.xxz);
      }
      if (this.tNy != null) {
        paramVarArgs.e(100, this.tNy);
      }
      AppMethodBeat.o(56871);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label506;
      }
    }
    label506:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wvn != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wvn);
      }
      i = paramInt;
      if (this.xxz != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xxz);
      }
      paramInt = i;
      if (this.tNy != null) {
        paramInt = i + e.a.a.b.b.a.f(100, this.tNy);
      }
      AppMethodBeat.o(56871);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56871);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bja localbja = (bja)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56871);
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
            localbja.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56871);
          return 0;
        case 2: 
          localbja.wvn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56871);
          return 0;
        case 3: 
          localbja.xxz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56871);
          return 0;
        }
        localbja.tNy = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56871);
        return 0;
      }
      AppMethodBeat.o(56871);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bja
 * JD-Core Version:    0.7.0.1
 */