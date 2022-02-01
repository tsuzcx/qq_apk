package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hd
  extends cpx
{
  public int DLC;
  public SKBuiltinBuffer_t DTA;
  public iq DUl;
  public String DUm;
  public int DUn;
  public String DUo;
  public String DUp;
  public SKBuiltinBuffer_t DUq;
  public SKBuiltinBuffer_t DUr;
  public String iJW;
  public String ncV;
  public String pAC;
  public String pAD;
  public String tCb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133146);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DTA == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133146);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DUl != null)
      {
        paramVarArgs.ln(2, this.DUl.computeSize());
        this.DUl.writeFields(paramVarArgs);
      }
      if (this.DTA != null)
      {
        paramVarArgs.ln(3, this.DTA.computeSize());
        this.DTA.writeFields(paramVarArgs);
      }
      if (this.tCb != null) {
        paramVarArgs.d(4, this.tCb);
      }
      if (this.DUm != null) {
        paramVarArgs.d(5, this.DUm);
      }
      paramVarArgs.aR(6, this.DUn);
      if (this.DUo != null) {
        paramVarArgs.d(7, this.DUo);
      }
      if (this.iJW != null) {
        paramVarArgs.d(8, this.iJW);
      }
      if (this.ncV != null) {
        paramVarArgs.d(9, this.ncV);
      }
      if (this.DUp != null) {
        paramVarArgs.d(10, this.DUp);
      }
      if (this.pAD != null) {
        paramVarArgs.d(11, this.pAD);
      }
      if (this.pAC != null) {
        paramVarArgs.d(12, this.pAC);
      }
      paramVarArgs.aR(13, this.DLC);
      if (this.DUq != null)
      {
        paramVarArgs.ln(14, this.DUq.computeSize());
        this.DUq.writeFields(paramVarArgs);
      }
      if (this.DUr != null)
      {
        paramVarArgs.ln(15, this.DUr.computeSize());
        this.DUr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133146);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1562;
      }
    }
    label1562:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DUl != null) {
        paramInt = i + f.a.a.a.lm(2, this.DUl.computeSize());
      }
      i = paramInt;
      if (this.DTA != null) {
        i = paramInt + f.a.a.a.lm(3, this.DTA.computeSize());
      }
      paramInt = i;
      if (this.tCb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tCb);
      }
      i = paramInt;
      if (this.DUm != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DUm);
      }
      i += f.a.a.b.b.a.bx(6, this.DUn);
      paramInt = i;
      if (this.DUo != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DUo);
      }
      i = paramInt;
      if (this.iJW != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.iJW);
      }
      paramInt = i;
      if (this.ncV != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.ncV);
      }
      i = paramInt;
      if (this.DUp != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.DUp);
      }
      paramInt = i;
      if (this.pAD != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.pAD);
      }
      i = paramInt;
      if (this.pAC != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.pAC);
      }
      i += f.a.a.b.b.a.bx(13, this.DLC);
      paramInt = i;
      if (this.DUq != null) {
        paramInt = i + f.a.a.a.lm(14, this.DUq.computeSize());
      }
      i = paramInt;
      if (this.DUr != null) {
        i = paramInt + f.a.a.a.lm(15, this.DUr.computeSize());
      }
      AppMethodBeat.o(133146);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DTA == null)
        {
          paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
          AppMethodBeat.o(133146);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133146);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        hd localhd = (hd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133146);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhd.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhd.DUl = ((iq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhd.DTA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 4: 
          localhd.tCb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 5: 
          localhd.DUm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 6: 
          localhd.DUn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133146);
          return 0;
        case 7: 
          localhd.DUo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 8: 
          localhd.iJW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 9: 
          localhd.ncV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 10: 
          localhd.DUp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 11: 
          localhd.pAD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 12: 
          localhd.pAC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 13: 
          localhd.DLC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133146);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhd.DUq = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
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
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhd.DUr = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133146);
        return 0;
      }
      AppMethodBeat.o(133146);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hd
 * JD-Core Version:    0.7.0.1
 */