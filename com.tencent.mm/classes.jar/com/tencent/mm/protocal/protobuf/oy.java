package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class oy
  extends ckq
{
  public dcl CMJ;
  public String CMK;
  public dh CMn;
  public int CNh;
  public String token;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91381);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CMJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: tock_mess");
        AppMethodBeat.o(91381);
        throw paramVarArgs;
      }
      if (this.CMn == null)
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
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CMJ != null)
      {
        paramVarArgs.kX(2, this.CMJ.computeSize());
        this.CMJ.writeFields(paramVarArgs);
      }
      if (this.CMn != null)
      {
        paramVarArgs.kX(3, this.CMn.computeSize());
        this.CMn.writeFields(paramVarArgs);
      }
      if (this.CMK != null) {
        paramVarArgs.d(4, this.CMK);
      }
      paramVarArgs.aR(5, this.CNh);
      if (this.token != null) {
        paramVarArgs.d(6, this.token);
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
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CMJ != null) {
        paramInt = i + f.a.a.a.kW(2, this.CMJ.computeSize());
      }
      i = paramInt;
      if (this.CMn != null) {
        i = paramInt + f.a.a.a.kW(3, this.CMn.computeSize());
      }
      paramInt = i;
      if (this.CMK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CMK);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.CNh);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.token);
      }
      AppMethodBeat.o(91381);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CMJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: tock_mess");
          AppMethodBeat.o(91381);
          throw paramVarArgs;
        }
        if (this.CMn == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        oy localoy = (oy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91381);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localoy.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localoy.CMJ = ((dcl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localoy.CMn = ((dh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 4: 
          localoy.CMK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91381);
          return 0;
        case 5: 
          localoy.CNh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91381);
          return 0;
        }
        localoy.token = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91381);
        return 0;
      }
      AppMethodBeat.o(91381);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oy
 * JD-Core Version:    0.7.0.1
 */