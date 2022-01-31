package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ahk
  extends buy
{
  public String kwJ;
  public String signature;
  public String uho;
  public String wAE;
  public String wOf;
  public String wZM;
  public String wZN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11765);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOf == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(11765);
        throw paramVarArgs;
      }
      if (this.wZM == null)
      {
        paramVarArgs = new b("Not all required fields were included: group_id");
        AppMethodBeat.o(11765);
        throw paramVarArgs;
      }
      if (this.uho == null)
      {
        paramVarArgs = new b("Not all required fields were included: time_stamp");
        AppMethodBeat.o(11765);
        throw paramVarArgs;
      }
      if (this.kwJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: nonce_str");
        AppMethodBeat.o(11765);
        throw paramVarArgs;
      }
      if (this.signature == null)
      {
        paramVarArgs = new b("Not all required fields were included: signature");
        AppMethodBeat.o(11765);
        throw paramVarArgs;
      }
      if (this.wAE == null)
      {
        paramVarArgs = new b("Not all required fields were included: from_url");
        AppMethodBeat.o(11765);
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
      if (this.wZM != null) {
        paramVarArgs.e(3, this.wZM);
      }
      if (this.uho != null) {
        paramVarArgs.e(4, this.uho);
      }
      if (this.kwJ != null) {
        paramVarArgs.e(5, this.kwJ);
      }
      if (this.signature != null) {
        paramVarArgs.e(6, this.signature);
      }
      if (this.wAE != null) {
        paramVarArgs.e(7, this.wAE);
      }
      if (this.wZN != null) {
        paramVarArgs.e(8, this.wZN);
      }
      AppMethodBeat.o(11765);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1052;
      }
    }
    label1052:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wOf != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wOf);
      }
      i = paramInt;
      if (this.wZM != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wZM);
      }
      paramInt = i;
      if (this.uho != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.uho);
      }
      i = paramInt;
      if (this.kwJ != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.kwJ);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.signature);
      }
      i = paramInt;
      if (this.wAE != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wAE);
      }
      paramInt = i;
      if (this.wZN != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wZN);
      }
      AppMethodBeat.o(11765);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wOf == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(11765);
          throw paramVarArgs;
        }
        if (this.wZM == null)
        {
          paramVarArgs = new b("Not all required fields were included: group_id");
          AppMethodBeat.o(11765);
          throw paramVarArgs;
        }
        if (this.uho == null)
        {
          paramVarArgs = new b("Not all required fields were included: time_stamp");
          AppMethodBeat.o(11765);
          throw paramVarArgs;
        }
        if (this.kwJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: nonce_str");
          AppMethodBeat.o(11765);
          throw paramVarArgs;
        }
        if (this.signature == null)
        {
          paramVarArgs = new b("Not all required fields were included: signature");
          AppMethodBeat.o(11765);
          throw paramVarArgs;
        }
        if (this.wAE == null)
        {
          paramVarArgs = new b("Not all required fields were included: from_url");
          AppMethodBeat.o(11765);
          throw paramVarArgs;
        }
        AppMethodBeat.o(11765);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ahk localahk = (ahk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11765);
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
            localahk.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11765);
          return 0;
        case 2: 
          localahk.wOf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11765);
          return 0;
        case 3: 
          localahk.wZM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11765);
          return 0;
        case 4: 
          localahk.uho = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11765);
          return 0;
        case 5: 
          localahk.kwJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11765);
          return 0;
        case 6: 
          localahk.signature = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11765);
          return 0;
        case 7: 
          localahk.wAE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11765);
          return 0;
        }
        localahk.wZN = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(11765);
        return 0;
      }
      AppMethodBeat.o(11765);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahk
 * JD-Core Version:    0.7.0.1
 */