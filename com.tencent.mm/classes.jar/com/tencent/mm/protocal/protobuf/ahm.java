package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ahm
  extends buy
{
  public String data;
  public int vA;
  public String wOf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11767);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOf == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(11767);
        throw paramVarArgs;
      }
      if (this.data == null)
      {
        paramVarArgs = new b("Not all required fields were included: data");
        AppMethodBeat.o(11767);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wOf != null) {
        paramVarArgs.e(2, this.wOf);
      }
      paramVarArgs.aO(3, this.vA);
      if (this.data != null) {
        paramVarArgs.e(4, this.data);
      }
      AppMethodBeat.o(11767);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label588;
      }
    }
    label588:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wOf != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wOf);
      }
      i += e.a.a.b.b.a.bl(3, this.vA);
      paramInt = i;
      if (this.data != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.data);
      }
      AppMethodBeat.o(11767);
      return paramInt;
      Object localObject1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        localObject1 = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber((e.a.a.a.a)localObject1); paramInt > 0; paramInt = buy.getNextFieldNumber((e.a.a.a.a)localObject1)) {
          if (!super.populateBuilderWithField((e.a.a.a.a)localObject1, this, paramInt)) {
            ((e.a.a.a.a)localObject1).eqQ();
          }
        }
        if (this.wOf == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(11767);
          throw paramVarArgs;
        }
        if (paramVarArgs == null)
        {
          paramVarArgs = new b("Not all required fields were included: data");
          AppMethodBeat.o(11767);
          throw paramVarArgs;
        }
        AppMethodBeat.o(11767);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject2 = (e.a.a.a.a)paramVarArgs[0];
        localObject1 = (ahm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11767);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject2).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject3 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new hq();
            localObject3 = new e.a.a.a.a((byte[])localObject3, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject2).populateBuilderWithField((e.a.a.a.a)localObject3, (com.tencent.mm.bv.a)localObject2, buy.getNextFieldNumber((e.a.a.a.a)localObject3))) {}
            ((ahm)localObject1).BaseRequest = ((hq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(11767);
          return 0;
        case 2: 
          ((ahm)localObject1).wOf = ((e.a.a.a.a)localObject2).CLY.readString();
          AppMethodBeat.o(11767);
          return 0;
        case 3: 
          ((ahm)localObject1).vA = ((e.a.a.a.a)localObject2).CLY.sl();
          AppMethodBeat.o(11767);
          return 0;
        }
        ((ahm)localObject1).data = ((e.a.a.a.a)localObject2).CLY.readString();
        AppMethodBeat.o(11767);
        return 0;
      }
      AppMethodBeat.o(11767);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahm
 * JD-Core Version:    0.7.0.1
 */