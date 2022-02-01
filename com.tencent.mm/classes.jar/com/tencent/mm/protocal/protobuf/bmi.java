package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bmi
  extends cqk
{
  public LinkedList<dox> FbH;
  public LinkedList<String> FbI;
  public String FbJ;
  public LinkedList<bmn> FbK;
  public bmb Fbq;
  
  public bmi()
  {
    AppMethodBeat.i(82440);
    this.FbH = new LinkedList();
    this.FbI = new LinkedList();
    this.FbK = new LinkedList();
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
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Fbq != null)
      {
        paramVarArgs.ln(2, this.Fbq.computeSize());
        this.Fbq.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.FbH);
      paramVarArgs.e(4, 1, this.FbI);
      if (this.FbJ != null) {
        paramVarArgs.d(5, this.FbJ);
      }
      paramVarArgs.e(6, 8, this.FbK);
      AppMethodBeat.o(82441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label910;
      }
    }
    label910:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fbq != null) {
        i = paramInt + f.a.a.a.lm(2, this.Fbq.computeSize());
      }
      i = i + f.a.a.a.c(3, 8, this.FbH) + f.a.a.a.c(4, 1, this.FbI);
      paramInt = i;
      if (this.FbJ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FbJ);
      }
      i = f.a.a.a.c(6, 8, this.FbK);
      AppMethodBeat.o(82441);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FbH.clear();
        this.FbI.clear();
        this.FbK.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
        bmi localbmi = (bmi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82441);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82441);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmi.Fbq = ((bmb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82441);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dox();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dox)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmi.FbH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82441);
          return 0;
        case 4: 
          localbmi.FbI.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(82441);
          return 0;
        case 5: 
          localbmi.FbJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82441);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbmi.FbK.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmi
 * JD-Core Version:    0.7.0.1
 */