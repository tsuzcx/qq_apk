package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bko
  extends cvp
{
  public dwo FXT;
  public cpk FXV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32292);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32292);
        throw paramVarArgs;
      }
      if (this.FXT == null)
      {
        paramVarArgs = new b("Not all required fields were included: TransRes");
        AppMethodBeat.o(32292);
        throw paramVarArgs;
      }
      if (this.FXV == null)
      {
        paramVarArgs = new b("Not all required fields were included: QueryCtx");
        AppMethodBeat.o(32292);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FXT != null)
      {
        paramVarArgs.lC(2, this.FXT.computeSize());
        this.FXT.writeFields(paramVarArgs);
      }
      if (this.FXV != null)
      {
        paramVarArgs.lC(3, this.FXV.computeSize());
        this.FXV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32292);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label779;
      }
    }
    label779:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FXT != null) {
        paramInt = i + f.a.a.a.lB(2, this.FXT.computeSize());
      }
      i = paramInt;
      if (this.FXV != null) {
        i = paramInt + f.a.a.a.lB(3, this.FXV.computeSize());
      }
      AppMethodBeat.o(32292);
      return i;
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
          AppMethodBeat.o(32292);
          throw paramVarArgs;
        }
        if (this.FXT == null)
        {
          paramVarArgs = new b("Not all required fields were included: TransRes");
          AppMethodBeat.o(32292);
          throw paramVarArgs;
        }
        if (this.FXV == null)
        {
          paramVarArgs = new b("Not all required fields were included: QueryCtx");
          AppMethodBeat.o(32292);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32292);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bko localbko = (bko)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32292);
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
            localbko.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32292);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbko.FXT = ((dwo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32292);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cpk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cpk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbko.FXV = ((cpk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32292);
        return 0;
      }
      AppMethodBeat.o(32292);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bko
 * JD-Core Version:    0.7.0.1
 */