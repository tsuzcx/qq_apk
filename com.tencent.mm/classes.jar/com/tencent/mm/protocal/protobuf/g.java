package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class g
  extends cqk
{
  public String DKA;
  public String DKC;
  public z DKL;
  public a DKM;
  public int dae = 268513600;
  public String oxf = "请求不成功，请稍候再试";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91317);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91317);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dae);
      if (this.oxf != null) {
        paramVarArgs.d(3, this.oxf);
      }
      if (this.DKA != null) {
        paramVarArgs.d(4, this.DKA);
      }
      if (this.DKC != null) {
        paramVarArgs.d(5, this.DKC);
      }
      if (this.DKL != null)
      {
        paramVarArgs.ln(6, this.DKL.computeSize());
        this.DKL.writeFields(paramVarArgs);
      }
      if (this.DKM != null)
      {
        paramVarArgs.ln(7, this.DKM.computeSize());
        this.DKM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91317);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt;
      if (this.DKA != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DKA);
      }
      paramInt = i;
      if (this.DKC != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DKC);
      }
      i = paramInt;
      if (this.DKL != null) {
        i = paramInt + f.a.a.a.lm(6, this.DKL.computeSize());
      }
      paramInt = i;
      if (this.DKM != null) {
        paramInt = i + f.a.a.a.lm(7, this.DKM.computeSize());
      }
      AppMethodBeat.o(91317);
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
          AppMethodBeat.o(91317);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91317);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91317);
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
            localg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91317);
          return 0;
        case 2: 
          localg.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91317);
          return 0;
        case 3: 
          localg.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91317);
          return 0;
        case 4: 
          localg.DKA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91317);
          return 0;
        case 5: 
          localg.DKC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91317);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new z();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((z)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localg.DKL = ((z)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91317);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localg.DKM = ((a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91317);
        return 0;
      }
      AppMethodBeat.o(91317);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.g
 * JD-Core Version:    0.7.0.1
 */