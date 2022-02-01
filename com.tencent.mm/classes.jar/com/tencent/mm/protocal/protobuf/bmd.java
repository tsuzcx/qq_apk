package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bmd
  extends cqk
{
  public int FbA;
  public bmb Fbq;
  public int dfm;
  public int tfk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123603);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123603);
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
      paramVarArgs.aR(3, this.dfm);
      paramVarArgs.aR(4, this.tfk);
      paramVarArgs.aR(5, this.FbA);
      AppMethodBeat.o(123603);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fbq != null) {
        i = paramInt + f.a.a.a.lm(2, this.Fbq.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(3, this.dfm);
      int j = f.a.a.b.b.a.bx(4, this.tfk);
      int k = f.a.a.b.b.a.bx(5, this.FbA);
      AppMethodBeat.o(123603);
      return i + paramInt + j + k;
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
          AppMethodBeat.o(123603);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123603);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bmd localbmd = (bmd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123603);
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
            localbmd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123603);
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
            localbmd.Fbq = ((bmb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123603);
          return 0;
        case 3: 
          localbmd.dfm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123603);
          return 0;
        case 4: 
          localbmd.tfk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123603);
          return 0;
        }
        localbmd.FbA = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(123603);
        return 0;
      }
      AppMethodBeat.o(123603);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmd
 * JD-Core Version:    0.7.0.1
 */