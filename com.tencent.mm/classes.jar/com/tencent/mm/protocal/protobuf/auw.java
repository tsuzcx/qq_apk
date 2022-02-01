package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class auw
  extends cqk
{
  public String EMV;
  public sb EMW;
  public int EMX;
  public ctu EMY;
  public String nWw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114023);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114023);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.nWw != null) {
        paramVarArgs.d(2, this.nWw);
      }
      if (this.EMV != null) {
        paramVarArgs.d(3, this.EMV);
      }
      if (this.EMW != null)
      {
        paramVarArgs.ln(4, this.EMW.computeSize());
        this.EMW.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.EMX);
      if (this.EMY != null)
      {
        paramVarArgs.ln(6, this.EMY.computeSize());
        this.EMY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114023);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label834;
      }
    }
    label834:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nWw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nWw);
      }
      i = paramInt;
      if (this.EMV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EMV);
      }
      paramInt = i;
      if (this.EMW != null) {
        paramInt = i + f.a.a.a.lm(4, this.EMW.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.EMX);
      paramInt = i;
      if (this.EMY != null) {
        paramInt = i + f.a.a.a.lm(6, this.EMY.computeSize());
      }
      AppMethodBeat.o(114023);
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
          AppMethodBeat.o(114023);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114023);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        auw localauw = (auw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114023);
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
            localauw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114023);
          return 0;
        case 2: 
          localauw.nWw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114023);
          return 0;
        case 3: 
          localauw.EMV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114023);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauw.EMW = ((sb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114023);
          return 0;
        case 5: 
          localauw.EMX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114023);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ctu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ctu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localauw.EMY = ((ctu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114023);
        return 0;
      }
      AppMethodBeat.o(114023);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auw
 * JD-Core Version:    0.7.0.1
 */