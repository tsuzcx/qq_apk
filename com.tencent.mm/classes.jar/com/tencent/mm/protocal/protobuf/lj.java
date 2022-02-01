package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class lj
  extends cqk
{
  public int DNg;
  public int DNj;
  public SKBuiltinBuffer_t DPX;
  public SKBuiltinBuffer_t DTC;
  public SKBuiltinBuffer_t DTI;
  public crp DYL;
  public String DYT;
  public crm DYW;
  public SKBuiltinBuffer_t DYX;
  public int DYZ;
  public String DZa;
  public String DZb;
  public int ndj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155397);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155397);
        throw paramVarArgs;
      }
      if (this.DPX == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(155397);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DYT != null) {
        paramVarArgs.d(2, this.DYT);
      }
      if (this.DPX != null)
      {
        paramVarArgs.ln(3, this.DPX.computeSize());
        this.DPX.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.DNj);
      paramVarArgs.aR(5, this.DYZ);
      if (this.DZa != null) {
        paramVarArgs.d(6, this.DZa);
      }
      paramVarArgs.aR(7, this.ndj);
      if (this.DZb != null) {
        paramVarArgs.d(8, this.DZb);
      }
      if (this.DYW != null)
      {
        paramVarArgs.ln(9, this.DYW.computeSize());
        this.DYW.writeFields(paramVarArgs);
      }
      if (this.DTI != null)
      {
        paramVarArgs.ln(10, this.DTI.computeSize());
        this.DTI.writeFields(paramVarArgs);
      }
      if (this.DYX != null)
      {
        paramVarArgs.ln(11, this.DYX.computeSize());
        this.DYX.writeFields(paramVarArgs);
      }
      if (this.DYL != null)
      {
        paramVarArgs.ln(12, this.DYL.computeSize());
        this.DYL.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(13, this.DNg);
      if (this.DTC != null)
      {
        paramVarArgs.ln(14, this.DTC.computeSize());
        this.DTC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155397);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1702;
      }
    }
    label1702:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DYT != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DYT);
      }
      i = paramInt;
      if (this.DPX != null) {
        i = paramInt + f.a.a.a.lm(3, this.DPX.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(4, this.DNj) + f.a.a.b.b.a.bx(5, this.DYZ);
      paramInt = i;
      if (this.DZa != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DZa);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.ndj);
      paramInt = i;
      if (this.DZb != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DZb);
      }
      i = paramInt;
      if (this.DYW != null) {
        i = paramInt + f.a.a.a.lm(9, this.DYW.computeSize());
      }
      paramInt = i;
      if (this.DTI != null) {
        paramInt = i + f.a.a.a.lm(10, this.DTI.computeSize());
      }
      i = paramInt;
      if (this.DYX != null) {
        i = paramInt + f.a.a.a.lm(11, this.DYX.computeSize());
      }
      paramInt = i;
      if (this.DYL != null) {
        paramInt = i + f.a.a.a.lm(12, this.DYL.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(13, this.DNg);
      paramInt = i;
      if (this.DTC != null) {
        paramInt = i + f.a.a.a.lm(14, this.DTC.computeSize());
      }
      AppMethodBeat.o(155397);
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
          AppMethodBeat.o(155397);
          throw paramVarArgs;
        }
        if (this.DPX == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(155397);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155397);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        lj locallj = (lj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155397);
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
            locallj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 2: 
          locallj.DYT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155397);
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
            locallj.DPX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 4: 
          locallj.DNj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155397);
          return 0;
        case 5: 
          locallj.DYZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155397);
          return 0;
        case 6: 
          locallj.DZa = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155397);
          return 0;
        case 7: 
          locallj.ndj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155397);
          return 0;
        case 8: 
          locallj.DZb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155397);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallj.DYW = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallj.DTI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallj.DYX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallj.DYL = ((crp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 13: 
          locallj.DNg = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155397);
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
          locallj.DTC = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155397);
        return 0;
      }
      AppMethodBeat.o(155397);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lj
 * JD-Core Version:    0.7.0.1
 */