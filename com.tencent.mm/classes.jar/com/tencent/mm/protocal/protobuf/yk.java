package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class yk
  extends cvp
{
  public dwo FXT;
  public dtj FXU;
  public cpk FXV;
  public int FXW;
  public int nDG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32167);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32167);
        throw paramVarArgs;
      }
      if (this.FXT == null)
      {
        paramVarArgs = new b("Not all required fields were included: TransRes");
        AppMethodBeat.o(32167);
        throw paramVarArgs;
      }
      if (this.FXU == null)
      {
        paramVarArgs = new b("Not all required fields were included: UploadCtx");
        AppMethodBeat.o(32167);
        throw paramVarArgs;
      }
      if (this.FXV == null)
      {
        paramVarArgs = new b("Not all required fields were included: QueryCtx");
        AppMethodBeat.o(32167);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nDG);
      if (this.FXT != null)
      {
        paramVarArgs.lC(3, this.FXT.computeSize());
        this.FXT.writeFields(paramVarArgs);
      }
      if (this.FXU != null)
      {
        paramVarArgs.lC(4, this.FXU.computeSize());
        this.FXU.writeFields(paramVarArgs);
      }
      if (this.FXV != null)
      {
        paramVarArgs.lC(5, this.FXV.computeSize());
        this.FXV.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.FXW);
      AppMethodBeat.o(32167);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1074;
      }
    }
    label1074:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nDG);
      paramInt = i;
      if (this.FXT != null) {
        paramInt = i + f.a.a.a.lB(3, this.FXT.computeSize());
      }
      i = paramInt;
      if (this.FXU != null) {
        i = paramInt + f.a.a.a.lB(4, this.FXU.computeSize());
      }
      paramInt = i;
      if (this.FXV != null) {
        paramInt = i + f.a.a.a.lB(5, this.FXV.computeSize());
      }
      i = f.a.a.b.b.a.bz(6, this.FXW);
      AppMethodBeat.o(32167);
      return paramInt + i;
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
          AppMethodBeat.o(32167);
          throw paramVarArgs;
        }
        if (this.FXT == null)
        {
          paramVarArgs = new b("Not all required fields were included: TransRes");
          AppMethodBeat.o(32167);
          throw paramVarArgs;
        }
        if (this.FXU == null)
        {
          paramVarArgs = new b("Not all required fields were included: UploadCtx");
          AppMethodBeat.o(32167);
          throw paramVarArgs;
        }
        if (this.FXV == null)
        {
          paramVarArgs = new b("Not all required fields were included: QueryCtx");
          AppMethodBeat.o(32167);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32167);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yk localyk = (yk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32167);
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
            localyk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32167);
          return 0;
        case 2: 
          localyk.nDG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32167);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyk.FXT = ((dwo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32167);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dtj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dtj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyk.FXU = ((dtj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32167);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cpk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cpk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyk.FXV = ((cpk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32167);
          return 0;
        }
        localyk.FXW = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32167);
        return 0;
      }
      AppMethodBeat.o(32167);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yk
 * JD-Core Version:    0.7.0.1
 */