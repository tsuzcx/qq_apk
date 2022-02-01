package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dpd
  extends cqk
{
  public SKBuiltinBuffer_t DPX;
  public SKBuiltinBuffer_t DTC;
  public String DTH;
  public SKBuiltinBuffer_t DTI;
  public crm DYW;
  public SKBuiltinBuffer_t DYX;
  public crm EVt;
  public String Ewu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43134);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(43134);
        throw paramVarArgs;
      }
      if (this.EVt == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgSid");
        AppMethodBeat.o(43134);
        throw paramVarArgs;
      }
      if (this.DPX == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(43134);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.EVt != null)
      {
        paramVarArgs.ln(2, this.EVt.computeSize());
        this.EVt.writeFields(paramVarArgs);
      }
      if (this.DPX != null)
      {
        paramVarArgs.ln(3, this.DPX.computeSize());
        this.DPX.writeFields(paramVarArgs);
      }
      if (this.Ewu != null) {
        paramVarArgs.d(4, this.Ewu);
      }
      if (this.DYW != null)
      {
        paramVarArgs.ln(5, this.DYW.computeSize());
        this.DYW.writeFields(paramVarArgs);
      }
      if (this.DTI != null)
      {
        paramVarArgs.ln(6, this.DTI.computeSize());
        this.DTI.writeFields(paramVarArgs);
      }
      if (this.DYX != null)
      {
        paramVarArgs.ln(7, this.DYX.computeSize());
        this.DYX.writeFields(paramVarArgs);
      }
      if (this.DTH != null) {
        paramVarArgs.d(8, this.DTH);
      }
      if (this.DTC != null)
      {
        paramVarArgs.ln(9, this.DTC.computeSize());
        this.DTC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43134);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1506;
      }
    }
    label1506:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EVt != null) {
        paramInt = i + f.a.a.a.lm(2, this.EVt.computeSize());
      }
      i = paramInt;
      if (this.DPX != null) {
        i = paramInt + f.a.a.a.lm(3, this.DPX.computeSize());
      }
      paramInt = i;
      if (this.Ewu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ewu);
      }
      i = paramInt;
      if (this.DYW != null) {
        i = paramInt + f.a.a.a.lm(5, this.DYW.computeSize());
      }
      paramInt = i;
      if (this.DTI != null) {
        paramInt = i + f.a.a.a.lm(6, this.DTI.computeSize());
      }
      i = paramInt;
      if (this.DYX != null) {
        i = paramInt + f.a.a.a.lm(7, this.DYX.computeSize());
      }
      paramInt = i;
      if (this.DTH != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DTH);
      }
      i = paramInt;
      if (this.DTC != null) {
        i = paramInt + f.a.a.a.lm(9, this.DTC.computeSize());
      }
      AppMethodBeat.o(43134);
      return i;
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
          AppMethodBeat.o(43134);
          throw paramVarArgs;
        }
        if (this.EVt == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgSid");
          AppMethodBeat.o(43134);
          throw paramVarArgs;
        }
        if (this.DPX == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(43134);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43134);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpd localdpd = (dpd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43134);
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
            localdpd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpd.EVt = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpd.DPX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 4: 
          localdpd.Ewu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43134);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpd.DYW = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpd.DTI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpd.DYX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 8: 
          localdpd.DTH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43134);
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
          localdpd.DTC = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43134);
        return 0;
      }
      AppMethodBeat.o(43134);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpd
 * JD-Core Version:    0.7.0.1
 */