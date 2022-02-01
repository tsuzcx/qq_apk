package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bhd
  extends cwj
{
  public dbt GVk;
  public eil GVl;
  public ejd GVm;
  public alg GVn;
  public ein GVo;
  public ejm GVp;
  public ejo GVq;
  public String GVr;
  public String GVs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153276);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153276);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GVk != null)
      {
        paramVarArgs.lJ(2, this.GVk.computeSize());
        this.GVk.writeFields(paramVarArgs);
      }
      if (this.GVl != null)
      {
        paramVarArgs.lJ(3, this.GVl.computeSize());
        this.GVl.writeFields(paramVarArgs);
      }
      if (this.GVm != null)
      {
        paramVarArgs.lJ(4, this.GVm.computeSize());
        this.GVm.writeFields(paramVarArgs);
      }
      if (this.GVn != null)
      {
        paramVarArgs.lJ(5, this.GVn.computeSize());
        this.GVn.writeFields(paramVarArgs);
      }
      if (this.GVo != null)
      {
        paramVarArgs.lJ(6, this.GVo.computeSize());
        this.GVo.writeFields(paramVarArgs);
      }
      if (this.GVp != null)
      {
        paramVarArgs.lJ(7, this.GVp.computeSize());
        this.GVp.writeFields(paramVarArgs);
      }
      if (this.GVq != null)
      {
        paramVarArgs.lJ(8, this.GVq.computeSize());
        this.GVq.writeFields(paramVarArgs);
      }
      if (this.GVr != null) {
        paramVarArgs.d(10, this.GVr);
      }
      if (this.GVs != null) {
        paramVarArgs.d(11, this.GVs);
      }
      AppMethodBeat.o(153276);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1570;
      }
    }
    label1570:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GVk != null) {
        paramInt = i + f.a.a.a.lI(2, this.GVk.computeSize());
      }
      i = paramInt;
      if (this.GVl != null) {
        i = paramInt + f.a.a.a.lI(3, this.GVl.computeSize());
      }
      paramInt = i;
      if (this.GVm != null) {
        paramInt = i + f.a.a.a.lI(4, this.GVm.computeSize());
      }
      i = paramInt;
      if (this.GVn != null) {
        i = paramInt + f.a.a.a.lI(5, this.GVn.computeSize());
      }
      paramInt = i;
      if (this.GVo != null) {
        paramInt = i + f.a.a.a.lI(6, this.GVo.computeSize());
      }
      i = paramInt;
      if (this.GVp != null) {
        i = paramInt + f.a.a.a.lI(7, this.GVp.computeSize());
      }
      paramInt = i;
      if (this.GVq != null) {
        paramInt = i + f.a.a.a.lI(8, this.GVq.computeSize());
      }
      i = paramInt;
      if (this.GVr != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GVr);
      }
      paramInt = i;
      if (this.GVs != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GVs);
      }
      AppMethodBeat.o(153276);
      return paramInt;
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
          AppMethodBeat.o(153276);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153276);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bhd localbhd = (bhd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        default: 
          AppMethodBeat.o(153276);
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
            localbhd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhd.GVk = ((dbt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eil();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eil)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhd.GVl = ((eil)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ejd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ejd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhd.GVm = ((ejd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhd.GVn = ((alg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ein();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ein)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhd.GVo = ((ein)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ejm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ejm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhd.GVp = ((ejm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ejo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ejo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhd.GVq = ((ejo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 10: 
          localbhd.GVr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153276);
          return 0;
        }
        localbhd.GVs = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(153276);
        return 0;
      }
      AppMethodBeat.o(153276);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhd
 * JD-Core Version:    0.7.0.1
 */