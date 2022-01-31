package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ti
  extends bvk
{
  public int jJS;
  public cri wLI;
  public cox wLJ;
  public bqi wLK;
  public int wLL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28363);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28363);
        throw paramVarArgs;
      }
      if (this.wLI == null)
      {
        paramVarArgs = new b("Not all required fields were included: TransRes");
        AppMethodBeat.o(28363);
        throw paramVarArgs;
      }
      if (this.wLJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: UploadCtx");
        AppMethodBeat.o(28363);
        throw paramVarArgs;
      }
      if (this.wLK == null)
      {
        paramVarArgs = new b("Not all required fields were included: QueryCtx");
        AppMethodBeat.o(28363);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.jJS);
      if (this.wLI != null)
      {
        paramVarArgs.iQ(3, this.wLI.computeSize());
        this.wLI.writeFields(paramVarArgs);
      }
      if (this.wLJ != null)
      {
        paramVarArgs.iQ(4, this.wLJ.computeSize());
        this.wLJ.writeFields(paramVarArgs);
      }
      if (this.wLK != null)
      {
        paramVarArgs.iQ(5, this.wLK.computeSize());
        this.wLK.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.wLL);
      AppMethodBeat.o(28363);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1074;
      }
    }
    label1074:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jJS);
      paramInt = i;
      if (this.wLI != null) {
        paramInt = i + e.a.a.a.iP(3, this.wLI.computeSize());
      }
      i = paramInt;
      if (this.wLJ != null) {
        i = paramInt + e.a.a.a.iP(4, this.wLJ.computeSize());
      }
      paramInt = i;
      if (this.wLK != null) {
        paramInt = i + e.a.a.a.iP(5, this.wLK.computeSize());
      }
      i = e.a.a.b.b.a.bl(6, this.wLL);
      AppMethodBeat.o(28363);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28363);
          throw paramVarArgs;
        }
        if (this.wLI == null)
        {
          paramVarArgs = new b("Not all required fields were included: TransRes");
          AppMethodBeat.o(28363);
          throw paramVarArgs;
        }
        if (this.wLJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: UploadCtx");
          AppMethodBeat.o(28363);
          throw paramVarArgs;
        }
        if (this.wLK == null)
        {
          paramVarArgs = new b("Not all required fields were included: QueryCtx");
          AppMethodBeat.o(28363);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28363);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ti localti = (ti)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28363);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localti.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28363);
          return 0;
        case 2: 
          localti.jJS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28363);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cri();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cri)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localti.wLI = ((cri)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28363);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cox();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cox)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localti.wLJ = ((cox)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28363);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqi();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqi)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localti.wLK = ((bqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28363);
          return 0;
        }
        localti.wLL = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28363);
        return 0;
      }
      AppMethodBeat.o(28363);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ti
 * JD-Core Version:    0.7.0.1
 */