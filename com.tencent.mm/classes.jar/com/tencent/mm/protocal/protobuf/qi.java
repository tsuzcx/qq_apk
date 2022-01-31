package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class qi
  extends buy
{
  public int okH;
  public String wIJ;
  public String wIK;
  public String wpp;
  public String wpq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56758);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wpp == null)
      {
        paramVarArgs = new b("Not all required fields were included: f2f_id");
        AppMethodBeat.o(56758);
        throw paramVarArgs;
      }
      if (this.wpq == null)
      {
        paramVarArgs = new b("Not all required fields were included: trans_id");
        AppMethodBeat.o(56758);
        throw paramVarArgs;
      }
      if (this.wIK == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_open_id");
        AppMethodBeat.o(56758);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wpp != null) {
        paramVarArgs.e(2, this.wpp);
      }
      if (this.wpq != null) {
        paramVarArgs.e(3, this.wpq);
      }
      if (this.wIJ != null) {
        paramVarArgs.e(4, this.wIJ);
      }
      if (this.wIK != null) {
        paramVarArgs.e(5, this.wIK);
      }
      paramVarArgs.aO(6, this.okH);
      AppMethodBeat.o(56758);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label742;
      }
    }
    label742:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wpp != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wpp);
      }
      i = paramInt;
      if (this.wpq != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wpq);
      }
      paramInt = i;
      if (this.wIJ != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wIJ);
      }
      i = paramInt;
      if (this.wIK != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wIK);
      }
      paramInt = e.a.a.b.b.a.bl(6, this.okH);
      AppMethodBeat.o(56758);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wpp == null)
        {
          paramVarArgs = new b("Not all required fields were included: f2f_id");
          AppMethodBeat.o(56758);
          throw paramVarArgs;
        }
        if (this.wpq == null)
        {
          paramVarArgs = new b("Not all required fields were included: trans_id");
          AppMethodBeat.o(56758);
          throw paramVarArgs;
        }
        if (this.wIK == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_open_id");
          AppMethodBeat.o(56758);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56758);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        qi localqi = (qi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56758);
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
            localqi.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56758);
          return 0;
        case 2: 
          localqi.wpp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56758);
          return 0;
        case 3: 
          localqi.wpq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56758);
          return 0;
        case 4: 
          localqi.wIJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56758);
          return 0;
        case 5: 
          localqi.wIK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56758);
          return 0;
        }
        localqi.okH = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56758);
        return 0;
      }
      AppMethodBeat.o(56758);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qi
 * JD-Core Version:    0.7.0.1
 */