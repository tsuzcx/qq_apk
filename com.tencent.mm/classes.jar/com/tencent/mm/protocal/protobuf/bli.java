package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bli
  extends cwj
{
  public bpj FWx;
  public px FWy;
  public ccw FWz;
  public String GYz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32294);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32294);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GYz != null) {
        paramVarArgs.d(2, this.GYz);
      }
      if (this.FWy != null)
      {
        paramVarArgs.lJ(3, this.FWy.computeSize());
        this.FWy.writeFields(paramVarArgs);
      }
      if (this.FWx != null)
      {
        paramVarArgs.lJ(4, this.FWx.computeSize());
        this.FWx.writeFields(paramVarArgs);
      }
      if (this.FWz != null)
      {
        paramVarArgs.lJ(5, this.FWz.computeSize());
        this.FWz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32294);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label893;
      }
    }
    label893:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GYz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GYz);
      }
      i = paramInt;
      if (this.FWy != null) {
        i = paramInt + f.a.a.a.lI(3, this.FWy.computeSize());
      }
      paramInt = i;
      if (this.FWx != null) {
        paramInt = i + f.a.a.a.lI(4, this.FWx.computeSize());
      }
      i = paramInt;
      if (this.FWz != null) {
        i = paramInt + f.a.a.a.lI(5, this.FWz.computeSize());
      }
      AppMethodBeat.o(32294);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32294);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32294);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bli localbli = (bli)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32294);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbli.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32294);
          return 0;
        case 2: 
          localbli.GYz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32294);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new px();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((px)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbli.FWy = ((px)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32294);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbli.FWx = ((bpj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32294);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbli.FWz = ((ccw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32294);
        return 0;
      }
      AppMethodBeat.o(32294);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bli
 * JD-Core Version:    0.7.0.1
 */