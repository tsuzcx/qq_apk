package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class qk
  extends cvc
{
  public dnn FLK;
  public String FLL;
  public dk FLo;
  public int FMi;
  public String token;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91381);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FLK == null)
      {
        paramVarArgs = new b("Not all required fields were included: tock_mess");
        AppMethodBeat.o(91381);
        throw paramVarArgs;
      }
      if (this.FLo == null)
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
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FLK != null)
      {
        paramVarArgs.lC(2, this.FLK.computeSize());
        this.FLK.writeFields(paramVarArgs);
      }
      if (this.FLo != null)
      {
        paramVarArgs.lC(3, this.FLo.computeSize());
        this.FLo.writeFields(paramVarArgs);
      }
      if (this.FLL != null) {
        paramVarArgs.d(4, this.FLL);
      }
      paramVarArgs.aS(5, this.FMi);
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
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FLK != null) {
        paramInt = i + f.a.a.a.lB(2, this.FLK.computeSize());
      }
      i = paramInt;
      if (this.FLo != null) {
        i = paramInt + f.a.a.a.lB(3, this.FLo.computeSize());
      }
      paramInt = i;
      if (this.FLL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FLL);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FMi);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.token);
      }
      AppMethodBeat.o(91381);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FLK == null)
        {
          paramVarArgs = new b("Not all required fields were included: tock_mess");
          AppMethodBeat.o(91381);
          throw paramVarArgs;
        }
        if (this.FLo == null)
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
        qk localqk = (qk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91381);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqk.FLK = ((dnn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqk.FLo = ((dk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 4: 
          localqk.FLL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91381);
          return 0;
        case 5: 
          localqk.FMi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91381);
          return 0;
        }
        localqk.token = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91381);
        return 0;
      }
      AppMethodBeat.o(91381);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qk
 * JD-Core Version:    0.7.0.1
 */