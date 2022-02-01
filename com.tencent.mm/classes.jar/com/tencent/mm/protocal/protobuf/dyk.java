package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyk
  extends cqk
{
  public int EfV;
  public String FhN;
  public int GeA;
  public cmk GeB;
  public cmi GeC;
  public int GeD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117949);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.GeA);
      paramVarArgs.aR(3, this.EfV);
      if (this.FhN != null) {
        paramVarArgs.d(4, this.FhN);
      }
      if (this.GeB != null)
      {
        paramVarArgs.ln(5, this.GeB.computeSize());
        this.GeB.writeFields(paramVarArgs);
      }
      if (this.GeC != null)
      {
        paramVarArgs.ln(6, this.GeC.computeSize());
        this.GeC.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.GeD);
      AppMethodBeat.o(117949);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label814;
      }
    }
    label814:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.GeA) + f.a.a.b.b.a.bx(3, this.EfV);
      paramInt = i;
      if (this.FhN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FhN);
      }
      i = paramInt;
      if (this.GeB != null) {
        i = paramInt + f.a.a.a.lm(5, this.GeB.computeSize());
      }
      paramInt = i;
      if (this.GeC != null) {
        paramInt = i + f.a.a.a.lm(6, this.GeC.computeSize());
      }
      i = f.a.a.b.b.a.bx(7, this.GeD);
      AppMethodBeat.o(117949);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117949);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyk localdyk = (dyk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117949);
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
            localdyk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        case 2: 
          localdyk.GeA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117949);
          return 0;
        case 3: 
          localdyk.EfV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117949);
          return 0;
        case 4: 
          localdyk.FhN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117949);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyk.GeB = ((cmk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyk.GeC = ((cmi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        }
        localdyk.GeD = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117949);
        return 0;
      }
      AppMethodBeat.o(117949);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyk
 * JD-Core Version:    0.7.0.1
 */