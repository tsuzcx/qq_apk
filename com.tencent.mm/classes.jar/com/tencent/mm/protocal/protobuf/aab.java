package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aab
  extends dpc
{
  public esm Llk;
  public eoe Lll;
  public did Llm;
  public int Lln;
  public int oTW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32167);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32167);
        throw paramVarArgs;
      }
      if (this.Llk == null)
      {
        paramVarArgs = new b("Not all required fields were included: TransRes");
        AppMethodBeat.o(32167);
        throw paramVarArgs;
      }
      if (this.Lll == null)
      {
        paramVarArgs = new b("Not all required fields were included: UploadCtx");
        AppMethodBeat.o(32167);
        throw paramVarArgs;
      }
      if (this.Llm == null)
      {
        paramVarArgs = new b("Not all required fields were included: QueryCtx");
        AppMethodBeat.o(32167);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.oTW);
      if (this.Llk != null)
      {
        paramVarArgs.ni(3, this.Llk.computeSize());
        this.Llk.writeFields(paramVarArgs);
      }
      if (this.Lll != null)
      {
        paramVarArgs.ni(4, this.Lll.computeSize());
        this.Lll.writeFields(paramVarArgs);
      }
      if (this.Llm != null)
      {
        paramVarArgs.ni(5, this.Llm.computeSize());
        this.Llm.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.Lln);
      AppMethodBeat.o(32167);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1074;
      }
    }
    label1074:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oTW);
      paramInt = i;
      if (this.Llk != null) {
        paramInt = i + g.a.a.a.nh(3, this.Llk.computeSize());
      }
      i = paramInt;
      if (this.Lll != null) {
        i = paramInt + g.a.a.a.nh(4, this.Lll.computeSize());
      }
      paramInt = i;
      if (this.Llm != null) {
        paramInt = i + g.a.a.a.nh(5, this.Llm.computeSize());
      }
      i = g.a.a.b.b.a.bu(6, this.Lln);
      AppMethodBeat.o(32167);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32167);
          throw paramVarArgs;
        }
        if (this.Llk == null)
        {
          paramVarArgs = new b("Not all required fields were included: TransRes");
          AppMethodBeat.o(32167);
          throw paramVarArgs;
        }
        if (this.Lll == null)
        {
          paramVarArgs = new b("Not all required fields were included: UploadCtx");
          AppMethodBeat.o(32167);
          throw paramVarArgs;
        }
        if (this.Llm == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aab localaab = (aab)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32167);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaab.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32167);
          return 0;
        case 2: 
          localaab.oTW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32167);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new esm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((esm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaab.Llk = ((esm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32167);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eoe();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eoe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaab.Lll = ((eoe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32167);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new did();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((did)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaab.Llm = ((did)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32167);
          return 0;
        }
        localaab.Lln = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32167);
        return 0;
      }
      AppMethodBeat.o(32167);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aab
 * JD-Core Version:    0.7.0.1
 */