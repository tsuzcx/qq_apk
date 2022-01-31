package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ve
  extends buy
{
  public String fKw;
  public String wNG;
  public String wNH;
  public String wsq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28368);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wNG == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceId");
        AppMethodBeat.o(28368);
        throw paramVarArgs;
      }
      if (this.wsq == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceType");
        AppMethodBeat.o(28368);
        throw paramVarArgs;
      }
      if (this.wNH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientInfo");
        AppMethodBeat.o(28368);
        throw paramVarArgs;
      }
      if (this.fKw == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(28368);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wNG != null) {
        paramVarArgs.e(2, this.wNG);
      }
      if (this.wsq != null) {
        paramVarArgs.e(3, this.wsq);
      }
      if (this.wNH != null) {
        paramVarArgs.e(4, this.wNH);
      }
      if (this.fKw != null) {
        paramVarArgs.e(5, this.fKw);
      }
      AppMethodBeat.o(28368);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label761;
      }
    }
    label761:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wNG != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wNG);
      }
      i = paramInt;
      if (this.wsq != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wsq);
      }
      paramInt = i;
      if (this.wNH != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wNH);
      }
      i = paramInt;
      if (this.fKw != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.fKw);
      }
      AppMethodBeat.o(28368);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wNG == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceId");
          AppMethodBeat.o(28368);
          throw paramVarArgs;
        }
        if (this.wsq == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceType");
          AppMethodBeat.o(28368);
          throw paramVarArgs;
        }
        if (this.wNH == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientInfo");
          AppMethodBeat.o(28368);
          throw paramVarArgs;
        }
        if (this.fKw == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(28368);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28368);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ve localve = (ve)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28368);
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
            localve.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28368);
          return 0;
        case 2: 
          localve.wNG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28368);
          return 0;
        case 3: 
          localve.wsq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28368);
          return 0;
        case 4: 
          localve.wNH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28368);
          return 0;
        }
        localve.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28368);
        return 0;
      }
      AppMethodBeat.o(28368);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ve
 * JD-Core Version:    0.7.0.1
 */