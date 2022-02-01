package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bag
  extends cqk
{
  public crm DPT;
  public crm DPU;
  public int vTH;
  public int vTI;
  public int vTJ;
  public SKBuiltinBuffer_t vTK;
  public int vTO;
  public long vTQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152573);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152573);
        throw paramVarArgs;
      }
      if (this.DPT == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152573);
        throw paramVarArgs;
      }
      if (this.DPU == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152573);
        throw paramVarArgs;
      }
      if (this.vTK == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(152573);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.vTO);
      if (this.DPT != null)
      {
        paramVarArgs.ln(3, this.DPT.computeSize());
        this.DPT.writeFields(paramVarArgs);
      }
      if (this.DPU != null)
      {
        paramVarArgs.ln(4, this.DPU.computeSize());
        this.DPU.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.vTH);
      paramVarArgs.aR(6, this.vTI);
      paramVarArgs.aR(7, this.vTJ);
      if (this.vTK != null)
      {
        paramVarArgs.ln(8, this.vTK.computeSize());
        this.vTK.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(9, this.vTQ);
      AppMethodBeat.o(152573);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1190;
      }
    }
    label1190:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.vTO);
      paramInt = i;
      if (this.DPT != null) {
        paramInt = i + f.a.a.a.lm(3, this.DPT.computeSize());
      }
      i = paramInt;
      if (this.DPU != null) {
        i = paramInt + f.a.a.a.lm(4, this.DPU.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(5, this.vTH) + f.a.a.b.b.a.bx(6, this.vTI) + f.a.a.b.b.a.bx(7, this.vTJ);
      paramInt = i;
      if (this.vTK != null) {
        paramInt = i + f.a.a.a.lm(8, this.vTK.computeSize());
      }
      i = f.a.a.b.b.a.p(9, this.vTQ);
      AppMethodBeat.o(152573);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152573);
          throw paramVarArgs;
        }
        if (this.DPT == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152573);
          throw paramVarArgs;
        }
        if (this.DPU == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152573);
          throw paramVarArgs;
        }
        if (this.vTK == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(152573);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152573);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bag localbag = (bag)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152573);
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
            localbag.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152573);
          return 0;
        case 2: 
          localbag.vTO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152573);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbag.DPT = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152573);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbag.DPU = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152573);
          return 0;
        case 5: 
          localbag.vTH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152573);
          return 0;
        case 6: 
          localbag.vTI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152573);
          return 0;
        case 7: 
          localbag.vTJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152573);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbag.vTK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152573);
          return 0;
        }
        localbag.vTQ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(152573);
        return 0;
      }
      AppMethodBeat.o(152573);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bag
 * JD-Core Version:    0.7.0.1
 */