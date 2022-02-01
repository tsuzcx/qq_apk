package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class rn
  extends dop
{
  public eig KYA;
  public String KYB;
  public int KYY;
  public du KYe;
  public String token;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91381);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KYA == null)
      {
        paramVarArgs = new b("Not all required fields were included: tock_mess");
        AppMethodBeat.o(91381);
        throw paramVarArgs;
      }
      if (this.KYe == null)
      {
        paramVarArgs = new b("Not all required fields were included: after_placeorder_comm_req");
        AppMethodBeat.o(91381);
        throw paramVarArgs;
      }
      if (this.token == null)
      {
        paramVarArgs = new b("Not all required fields were included: token");
        AppMethodBeat.o(91381);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KYA != null)
      {
        paramVarArgs.ni(2, this.KYA.computeSize());
        this.KYA.writeFields(paramVarArgs);
      }
      if (this.KYe != null)
      {
        paramVarArgs.ni(3, this.KYe.computeSize());
        this.KYe.writeFields(paramVarArgs);
      }
      if (this.KYB != null) {
        paramVarArgs.e(4, this.KYB);
      }
      paramVarArgs.aM(5, this.KYY);
      if (this.token != null) {
        paramVarArgs.e(6, this.token);
      }
      AppMethodBeat.o(91381);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label930;
      }
    }
    label930:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KYA != null) {
        paramInt = i + g.a.a.a.nh(2, this.KYA.computeSize());
      }
      i = paramInt;
      if (this.KYe != null) {
        i = paramInt + g.a.a.a.nh(3, this.KYe.computeSize());
      }
      paramInt = i;
      if (this.KYB != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KYB);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.KYY);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.token);
      }
      AppMethodBeat.o(91381);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KYA == null)
        {
          paramVarArgs = new b("Not all required fields were included: tock_mess");
          AppMethodBeat.o(91381);
          throw paramVarArgs;
        }
        if (this.KYe == null)
        {
          paramVarArgs = new b("Not all required fields were included: after_placeorder_comm_req");
          AppMethodBeat.o(91381);
          throw paramVarArgs;
        }
        if (this.token == null)
        {
          paramVarArgs = new b("Not all required fields were included: token");
          AppMethodBeat.o(91381);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91381);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        rn localrn = (rn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91381);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localrn.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eig();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eig)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localrn.KYA = ((eig)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new du();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((du)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localrn.KYe = ((du)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 4: 
          localrn.KYB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91381);
          return 0;
        case 5: 
          localrn.KYY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91381);
          return 0;
        }
        localrn.token = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91381);
        return 0;
      }
      AppMethodBeat.o(91381);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rn
 * JD-Core Version:    0.7.0.1
 */