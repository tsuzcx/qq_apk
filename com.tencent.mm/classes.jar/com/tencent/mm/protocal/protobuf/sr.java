package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class sr
  extends erp
{
  public fnr YXI;
  public String YXJ;
  public eh YXl;
  public int YYg;
  public String token;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91381);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YXI == null)
      {
        paramVarArgs = new b("Not all required fields were included: tock_mess");
        AppMethodBeat.o(91381);
        throw paramVarArgs;
      }
      if (this.YXl == null)
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
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YXI != null)
      {
        paramVarArgs.qD(2, this.YXI.computeSize());
        this.YXI.writeFields(paramVarArgs);
      }
      if (this.YXl != null)
      {
        paramVarArgs.qD(3, this.YXl.computeSize());
        this.YXl.writeFields(paramVarArgs);
      }
      if (this.YXJ != null) {
        paramVarArgs.g(4, this.YXJ);
      }
      paramVarArgs.bS(5, this.YYg);
      if (this.token != null) {
        paramVarArgs.g(6, this.token);
      }
      AppMethodBeat.o(91381);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label860;
      }
    }
    label860:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YXI != null) {
        paramInt = i + i.a.a.a.qC(2, this.YXI.computeSize());
      }
      i = paramInt;
      if (this.YXl != null) {
        i = paramInt + i.a.a.a.qC(3, this.YXl.computeSize());
      }
      paramInt = i;
      if (this.YXJ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YXJ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.YYg);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.token);
      }
      AppMethodBeat.o(91381);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YXI == null)
        {
          paramVarArgs = new b("Not all required fields were included: tock_mess");
          AppMethodBeat.o(91381);
          throw paramVarArgs;
        }
        if (this.YXl == null)
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
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        sr localsr = (sr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91381);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localsr.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fnr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fnr)localObject2).parseFrom((byte[])localObject1);
            }
            localsr.YXI = ((fnr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eh)localObject2).parseFrom((byte[])localObject1);
            }
            localsr.YXl = ((eh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 4: 
          localsr.YXJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91381);
          return 0;
        case 5: 
          localsr.YYg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91381);
          return 0;
        }
        localsr.token = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91381);
        return 0;
      }
      AppMethodBeat.o(91381);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sr
 * JD-Core Version:    0.7.0.1
 */