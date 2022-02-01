package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c;
import f.a.a.b;
import java.util.LinkedList;

public final class uk
  extends cvp
{
  public c CZq;
  public long CZs;
  public int dlw;
  public String paA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91404);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91404);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dlw);
      if (this.paA != null) {
        paramVarArgs.d(3, this.paA);
      }
      paramVarArgs.aY(4, this.CZs);
      if (this.CZq != null)
      {
        paramVarArgs.lC(5, this.CZq.computeSize());
        this.CZq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91404);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt + f.a.a.b.b.a.p(4, this.CZs);
      paramInt = i;
      if (this.CZq != null) {
        paramInt = i + f.a.a.a.lB(5, this.CZq.computeSize());
      }
      AppMethodBeat.o(91404);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91404);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91404);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        uk localuk = (uk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91404);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91404);
          return 0;
        case 2: 
          localuk.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91404);
          return 0;
        case 3: 
          localuk.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91404);
          return 0;
        case 4: 
          localuk.CZs = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91404);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new c();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localuk.CZq = ((c)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91404);
        return 0;
      }
      AppMethodBeat.o(91404);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uk
 * JD-Core Version:    0.7.0.1
 */