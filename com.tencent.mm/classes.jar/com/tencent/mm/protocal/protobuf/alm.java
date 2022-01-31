package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alm
  extends buy
{
  public String mKo;
  public String mKp;
  public String mKq;
  public String wkY;
  public yi wlp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28439);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.mKo != null) {
        paramVarArgs.e(2, this.mKo);
      }
      if (this.mKp != null) {
        paramVarArgs.e(3, this.mKp);
      }
      if (this.mKq != null) {
        paramVarArgs.e(4, this.mKq);
      }
      if (this.wkY != null) {
        paramVarArgs.e(5, this.wkY);
      }
      if (this.wlp != null)
      {
        paramVarArgs.iQ(6, this.wlp.computeSize());
        this.wlp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(28439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label718;
      }
    }
    label718:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mKo != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.mKo);
      }
      i = paramInt;
      if (this.mKp != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.mKp);
      }
      paramInt = i;
      if (this.mKq != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.mKq);
      }
      i = paramInt;
      if (this.wkY != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wkY);
      }
      paramInt = i;
      if (this.wlp != null) {
        paramInt = i + e.a.a.a.iP(6, this.wlp.computeSize());
      }
      AppMethodBeat.o(28439);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        alm localalm = (alm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28439);
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
            localalm.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28439);
          return 0;
        case 2: 
          localalm.mKo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28439);
          return 0;
        case 3: 
          localalm.mKp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28439);
          return 0;
        case 4: 
          localalm.mKq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28439);
          return 0;
        case 5: 
          localalm.wkY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28439);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yi();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yi)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localalm.wlp = ((yi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28439);
        return 0;
      }
      AppMethodBeat.o(28439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alm
 * JD-Core Version:    0.7.0.1
 */