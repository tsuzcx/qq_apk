package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cay
  extends cqk
{
  public SKBuiltinBuffer_t Fpq;
  public xw Fpr;
  public int qXl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152656);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152656);
        throw paramVarArgs;
      }
      if (this.Fpr == null)
      {
        paramVarArgs = new b("Not all required fields were included: cmd_list");
        AppMethodBeat.o(152656);
        throw paramVarArgs;
      }
      if (this.Fpq == null)
      {
        paramVarArgs = new b("Not all required fields were included: key_buf");
        AppMethodBeat.o(152656);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Fpr != null)
      {
        paramVarArgs.ln(2, this.Fpr.computeSize());
        this.Fpr.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.qXl);
      if (this.Fpq != null)
      {
        paramVarArgs.ln(4, this.Fpq.computeSize());
        this.Fpq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152656);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label806;
      }
    }
    label806:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fpr != null) {
        i = paramInt + f.a.a.a.lm(2, this.Fpr.computeSize());
      }
      i += f.a.a.b.b.a.bx(3, this.qXl);
      paramInt = i;
      if (this.Fpq != null) {
        paramInt = i + f.a.a.a.lm(4, this.Fpq.computeSize());
      }
      AppMethodBeat.o(152656);
      return paramInt;
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
          AppMethodBeat.o(152656);
          throw paramVarArgs;
        }
        if (this.Fpr == null)
        {
          paramVarArgs = new b("Not all required fields were included: cmd_list");
          AppMethodBeat.o(152656);
          throw paramVarArgs;
        }
        if (this.Fpq == null)
        {
          paramVarArgs = new b("Not all required fields were included: key_buf");
          AppMethodBeat.o(152656);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152656);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cay localcay = (cay)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152656);
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
            localcay.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152656);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcay.Fpr = ((xw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152656);
          return 0;
        case 3: 
          localcay.qXl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152656);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcay.Fpq = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152656);
        return 0;
      }
      AppMethodBeat.o(152656);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cay
 * JD-Core Version:    0.7.0.1
 */