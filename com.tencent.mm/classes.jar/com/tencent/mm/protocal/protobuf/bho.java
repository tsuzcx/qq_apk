package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bho
  extends cqk
{
  public int EWF;
  public LinkedList<eay> EWS;
  public eay EWT;
  public String EWU;
  public int EWV;
  public String EWW;
  public String EWX;
  public String EWY;
  public String EWZ;
  public dzq EoS;
  
  public bho()
  {
    AppMethodBeat.i(123594);
    this.EWS = new LinkedList();
    AppMethodBeat.o(123594);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123595);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123595);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.EoS != null)
      {
        paramVarArgs.ln(2, this.EoS.computeSize());
        this.EoS.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.EWS);
      if (this.EWT != null)
      {
        paramVarArgs.ln(4, this.EWT.computeSize());
        this.EWT.writeFields(paramVarArgs);
      }
      if (this.EWU != null) {
        paramVarArgs.d(5, this.EWU);
      }
      paramVarArgs.aR(6, this.EWV);
      if (this.EWW != null) {
        paramVarArgs.d(7, this.EWW);
      }
      if (this.EWX != null) {
        paramVarArgs.d(8, this.EWX);
      }
      if (this.EWY != null) {
        paramVarArgs.d(9, this.EWY);
      }
      if (this.EWZ != null) {
        paramVarArgs.d(10, this.EWZ);
      }
      paramVarArgs.aR(11, this.EWF);
      AppMethodBeat.o(123595);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1206;
      }
    }
    label1206:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EoS != null) {
        i = paramInt + f.a.a.a.lm(2, this.EoS.computeSize());
      }
      i += f.a.a.a.c(3, 8, this.EWS);
      paramInt = i;
      if (this.EWT != null) {
        paramInt = i + f.a.a.a.lm(4, this.EWT.computeSize());
      }
      i = paramInt;
      if (this.EWU != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EWU);
      }
      i += f.a.a.b.b.a.bx(6, this.EWV);
      paramInt = i;
      if (this.EWW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EWW);
      }
      i = paramInt;
      if (this.EWX != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EWX);
      }
      paramInt = i;
      if (this.EWY != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EWY);
      }
      i = paramInt;
      if (this.EWZ != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.EWZ);
      }
      paramInt = f.a.a.b.b.a.bx(11, this.EWF);
      AppMethodBeat.o(123595);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EWS.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123595);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123595);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bho localbho = (bho)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123595);
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
            localbho.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbho.EoS = ((dzq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eay();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eay)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbho.EWS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eay();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eay)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbho.EWT = ((eay)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 5: 
          localbho.EWU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 6: 
          localbho.EWV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123595);
          return 0;
        case 7: 
          localbho.EWW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 8: 
          localbho.EWX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 9: 
          localbho.EWY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 10: 
          localbho.EWZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123595);
          return 0;
        }
        localbho.EWF = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(123595);
        return 0;
      }
      AppMethodBeat.o(123595);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bho
 * JD-Core Version:    0.7.0.1
 */