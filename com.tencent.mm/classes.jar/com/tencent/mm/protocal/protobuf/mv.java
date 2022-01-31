package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class mv
  extends buy
{
  public String token;
  public cz wAZ;
  public int wBO;
  public ckm wBt;
  public String wBu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56731);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wBt == null)
      {
        paramVarArgs = new b("Not all required fields were included: tock_mess");
        AppMethodBeat.o(56731);
        throw paramVarArgs;
      }
      if (this.wAZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: after_placeorder_comm_req");
        AppMethodBeat.o(56731);
        throw paramVarArgs;
      }
      if (this.token == null)
      {
        paramVarArgs = new b("Not all required fields were included: token");
        AppMethodBeat.o(56731);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wBt != null)
      {
        paramVarArgs.iQ(2, this.wBt.computeSize());
        this.wBt.writeFields(paramVarArgs);
      }
      if (this.wAZ != null)
      {
        paramVarArgs.iQ(3, this.wAZ.computeSize());
        this.wAZ.writeFields(paramVarArgs);
      }
      if (this.wBu != null) {
        paramVarArgs.e(4, this.wBu);
      }
      paramVarArgs.aO(5, this.wBO);
      if (this.token != null) {
        paramVarArgs.e(6, this.token);
      }
      AppMethodBeat.o(56731);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label930;
      }
    }
    label930:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wBt != null) {
        paramInt = i + e.a.a.a.iP(2, this.wBt.computeSize());
      }
      i = paramInt;
      if (this.wAZ != null) {
        i = paramInt + e.a.a.a.iP(3, this.wAZ.computeSize());
      }
      paramInt = i;
      if (this.wBu != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wBu);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.wBO);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.token);
      }
      AppMethodBeat.o(56731);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wBt == null)
        {
          paramVarArgs = new b("Not all required fields were included: tock_mess");
          AppMethodBeat.o(56731);
          throw paramVarArgs;
        }
        if (this.wAZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: after_placeorder_comm_req");
          AppMethodBeat.o(56731);
          throw paramVarArgs;
        }
        if (this.token == null)
        {
          paramVarArgs = new b("Not all required fields were included: token");
          AppMethodBeat.o(56731);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56731);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        mv localmv = (mv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56731);
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
            localmv.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56731);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localmv.wBt = ((ckm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56731);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localmv.wAZ = ((cz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56731);
          return 0;
        case 4: 
          localmv.wBu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56731);
          return 0;
        case 5: 
          localmv.wBO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56731);
          return 0;
        }
        localmv.token = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56731);
        return 0;
      }
      AppMethodBeat.o(56731);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mv
 * JD-Core Version:    0.7.0.1
 */