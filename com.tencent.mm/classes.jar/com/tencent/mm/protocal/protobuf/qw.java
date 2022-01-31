package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class qw
  extends buy
{
  public String cwk;
  public String qkn;
  public String qkt;
  public long qmt;
  public String wIJ;
  public String wJc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48812);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cwk == null)
      {
        paramVarArgs = new b("Not all required fields were included: req_key");
        AppMethodBeat.o(48812);
        throw paramVarArgs;
      }
      if (this.wJc == null)
      {
        paramVarArgs = new b("Not all required fields were included: transfer_id");
        AppMethodBeat.o(48812);
        throw paramVarArgs;
      }
      if (this.qkt == null)
      {
        paramVarArgs = new b("Not all required fields were included: transaction_id");
        AppMethodBeat.o(48812);
        throw paramVarArgs;
      }
      if (this.qkn == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_openid");
        AppMethodBeat.o(48812);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.cwk != null) {
        paramVarArgs.e(2, this.cwk);
      }
      if (this.wJc != null) {
        paramVarArgs.e(3, this.wJc);
      }
      if (this.qkt != null) {
        paramVarArgs.e(4, this.qkt);
      }
      if (this.qkn != null) {
        paramVarArgs.e(5, this.qkn);
      }
      paramVarArgs.am(6, this.qmt);
      if (this.wIJ != null) {
        paramVarArgs.e(7, this.wIJ);
      }
      AppMethodBeat.o(48812);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label850;
      }
    }
    label850:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cwk != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.cwk);
      }
      i = paramInt;
      if (this.wJc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wJc);
      }
      paramInt = i;
      if (this.qkt != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.qkt);
      }
      i = paramInt;
      if (this.qkn != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.qkn);
      }
      i += e.a.a.b.b.a.p(6, this.qmt);
      paramInt = i;
      if (this.wIJ != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wIJ);
      }
      AppMethodBeat.o(48812);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.cwk == null)
        {
          paramVarArgs = new b("Not all required fields were included: req_key");
          AppMethodBeat.o(48812);
          throw paramVarArgs;
        }
        if (this.wJc == null)
        {
          paramVarArgs = new b("Not all required fields were included: transfer_id");
          AppMethodBeat.o(48812);
          throw paramVarArgs;
        }
        if (this.qkt == null)
        {
          paramVarArgs = new b("Not all required fields were included: transaction_id");
          AppMethodBeat.o(48812);
          throw paramVarArgs;
        }
        if (this.qkn == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_openid");
          AppMethodBeat.o(48812);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48812);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        qw localqw = (qw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48812);
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
            localqw.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48812);
          return 0;
        case 2: 
          localqw.cwk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48812);
          return 0;
        case 3: 
          localqw.wJc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48812);
          return 0;
        case 4: 
          localqw.qkt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48812);
          return 0;
        case 5: 
          localqw.qkn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48812);
          return 0;
        case 6: 
          localqw.qmt = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(48812);
          return 0;
        }
        localqw.wIJ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48812);
        return 0;
      }
      AppMethodBeat.o(48812);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qw
 * JD-Core Version:    0.7.0.1
 */