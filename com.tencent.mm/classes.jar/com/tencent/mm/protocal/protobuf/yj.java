package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class yj
  extends cwj
{
  public String FEz;
  public ckd GpL;
  public dpe Gqp;
  public int qkQ;
  public String qkR;
  public String token;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91419);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91419);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.qkQ);
      if (this.qkR != null) {
        paramVarArgs.d(3, this.qkR);
      }
      if (this.token != null) {
        paramVarArgs.d(4, this.token);
      }
      if (this.GpL != null)
      {
        paramVarArgs.lJ(5, this.GpL.computeSize());
        this.GpL.writeFields(paramVarArgs);
      }
      if (this.FEz != null) {
        paramVarArgs.d(6, this.FEz);
      }
      if (this.Gqp != null)
      {
        paramVarArgs.lJ(7, this.Gqp.computeSize());
        this.Gqp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91419);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.qkQ);
      paramInt = i;
      if (this.qkR != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.qkR);
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.token);
      }
      paramInt = i;
      if (this.GpL != null) {
        paramInt = i + f.a.a.a.lI(5, this.GpL.computeSize());
      }
      i = paramInt;
      if (this.FEz != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FEz);
      }
      paramInt = i;
      if (this.Gqp != null) {
        paramInt = i + f.a.a.a.lI(7, this.Gqp.computeSize());
      }
      AppMethodBeat.o(91419);
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
          AppMethodBeat.o(91419);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91419);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yj localyj = (yj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91419);
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
            localyj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91419);
          return 0;
        case 2: 
          localyj.qkQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91419);
          return 0;
        case 3: 
          localyj.qkR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91419);
          return 0;
        case 4: 
          localyj.token = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91419);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyj.GpL = ((ckd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91419);
          return 0;
        case 6: 
          localyj.FEz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91419);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dpe();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dpe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyj.Gqp = ((dpe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91419);
        return 0;
      }
      AppMethodBeat.o(91419);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yj
 * JD-Core Version:    0.7.0.1
 */