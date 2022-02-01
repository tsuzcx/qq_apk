package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cxx
  extends cvp
{
  public String FCR;
  public bzp FCS;
  public bnj FDx;
  public bnk FDy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32420);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32420);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FDx != null)
      {
        paramVarArgs.lC(2, this.FDx.computeSize());
        this.FDx.writeFields(paramVarArgs);
      }
      if (this.FDy != null)
      {
        paramVarArgs.lC(3, this.FDy.computeSize());
        this.FDy.writeFields(paramVarArgs);
      }
      if (this.FCR != null) {
        paramVarArgs.d(4, this.FCR);
      }
      if (this.FCS != null)
      {
        paramVarArgs.lC(5, this.FCS.computeSize());
        this.FCS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32420);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label893;
      }
    }
    label893:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FDx != null) {
        paramInt = i + f.a.a.a.lB(2, this.FDx.computeSize());
      }
      i = paramInt;
      if (this.FDy != null) {
        i = paramInt + f.a.a.a.lB(3, this.FDy.computeSize());
      }
      paramInt = i;
      if (this.FCR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FCR);
      }
      i = paramInt;
      if (this.FCS != null) {
        i = paramInt + f.a.a.a.lB(5, this.FCS.computeSize());
      }
      AppMethodBeat.o(32420);
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
          AppMethodBeat.o(32420);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32420);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cxx localcxx = (cxx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32420);
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
            localcxx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32420);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxx.FDx = ((bnj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32420);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxx.FDy = ((bnk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32420);
          return 0;
        case 4: 
          localcxx.FCR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32420);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bzp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bzp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcxx.FCS = ((bzp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32420);
        return 0;
      }
      AppMethodBeat.o(32420);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxx
 * JD-Core Version:    0.7.0.1
 */