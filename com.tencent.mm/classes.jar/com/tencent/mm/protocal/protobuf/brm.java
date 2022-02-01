package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class brm
  extends cwj
{
  public LinkedList<dvl> HeH;
  public LinkedList<String> HeI;
  public String HeJ;
  public LinkedList<brr> HeK;
  public brf Heq;
  
  public brm()
  {
    AppMethodBeat.i(82440);
    this.HeH = new LinkedList();
    this.HeI = new LinkedList();
    this.HeK = new LinkedList();
    AppMethodBeat.o(82440);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82441);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82441);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Heq != null)
      {
        paramVarArgs.lJ(2, this.Heq.computeSize());
        this.Heq.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.HeH);
      paramVarArgs.e(4, 1, this.HeI);
      if (this.HeJ != null) {
        paramVarArgs.d(5, this.HeJ);
      }
      paramVarArgs.e(6, 8, this.HeK);
      AppMethodBeat.o(82441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label910;
      }
    }
    label910:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Heq != null) {
        i = paramInt + f.a.a.a.lI(2, this.Heq.computeSize());
      }
      i = i + f.a.a.a.c(3, 8, this.HeH) + f.a.a.a.c(4, 1, this.HeI);
      paramInt = i;
      if (this.HeJ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HeJ);
      }
      i = f.a.a.a.c(6, 8, this.HeK);
      AppMethodBeat.o(82441);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HeH.clear();
        this.HeI.clear();
        this.HeK.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brm localbrm = (brm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82441);
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
            localbrm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82441);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new brf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((brf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrm.Heq = ((brf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82441);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrm.HeH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82441);
          return 0;
        case 4: 
          localbrm.HeI.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(82441);
          return 0;
        case 5: 
          localbrm.HeJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82441);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new brr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((brr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbrm.HeK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(82441);
        return 0;
      }
      AppMethodBeat.o(82441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brm
 * JD-Core Version:    0.7.0.1
 */