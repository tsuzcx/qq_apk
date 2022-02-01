package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lq
  extends cvw
{
  public String FRD;
  public int FSQ;
  public String FSg;
  public SKBuiltinBuffer_t FSj;
  public String FWe;
  public String FWf;
  public int FWg;
  public String FWh;
  public int FWi;
  public String FWj;
  public String FWk;
  public SKBuiltinBuffer_t FWl;
  public int FWm;
  public int FWn;
  public int FWo;
  public String FWp;
  public SKBuiltinBuffer_t FWq;
  public String FWr;
  public dfq FWs;
  public ccv FWt;
  public String nIJ;
  public String qkN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134243);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(2, this.nIJ);
      }
      if (this.FWe != null) {
        paramVarArgs.d(3, this.FWe);
      }
      paramVarArgs.aS(4, this.FSQ);
      if (this.FWf != null) {
        paramVarArgs.d(5, this.FWf);
      }
      paramVarArgs.aS(6, this.FWg);
      if (this.FWh != null) {
        paramVarArgs.d(7, this.FWh);
      }
      if (this.FRD != null) {
        paramVarArgs.d(8, this.FRD);
      }
      paramVarArgs.aS(9, this.FWi);
      if (this.FWj != null) {
        paramVarArgs.d(10, this.FWj);
      }
      if (this.FWk != null) {
        paramVarArgs.d(11, this.FWk);
      }
      if (this.FWl != null)
      {
        paramVarArgs.lJ(12, this.FWl.computeSize());
        this.FWl.writeFields(paramVarArgs);
      }
      if (this.qkN != null) {
        paramVarArgs.d(13, this.qkN);
      }
      paramVarArgs.aS(14, this.FWm);
      paramVarArgs.aS(15, this.FWn);
      if (this.FSg != null) {
        paramVarArgs.d(16, this.FSg);
      }
      paramVarArgs.aS(17, this.FWo);
      if (this.FWp != null) {
        paramVarArgs.d(18, this.FWp);
      }
      if (this.FWq != null)
      {
        paramVarArgs.lJ(19, this.FWq.computeSize());
        this.FWq.writeFields(paramVarArgs);
      }
      if (this.FSj != null)
      {
        paramVarArgs.lJ(20, this.FSj.computeSize());
        this.FSj.writeFields(paramVarArgs);
      }
      if (this.FWr != null) {
        paramVarArgs.d(21, this.FWr);
      }
      if (this.FWs != null)
      {
        paramVarArgs.lJ(22, this.FWs.computeSize());
        this.FWs.writeFields(paramVarArgs);
      }
      if (this.FWt != null)
      {
        paramVarArgs.lJ(23, this.FWt.computeSize());
        this.FWt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(134243);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2038;
      }
    }
    label2038:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nIJ);
      }
      i = paramInt;
      if (this.FWe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FWe);
      }
      i += f.a.a.b.b.a.bz(4, this.FSQ);
      paramInt = i;
      if (this.FWf != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FWf);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.FWg);
      paramInt = i;
      if (this.FWh != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FWh);
      }
      i = paramInt;
      if (this.FRD != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FRD);
      }
      i += f.a.a.b.b.a.bz(9, this.FWi);
      paramInt = i;
      if (this.FWj != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FWj);
      }
      i = paramInt;
      if (this.FWk != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.FWk);
      }
      paramInt = i;
      if (this.FWl != null) {
        paramInt = i + f.a.a.a.lI(12, this.FWl.computeSize());
      }
      i = paramInt;
      if (this.qkN != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.qkN);
      }
      i = i + f.a.a.b.b.a.bz(14, this.FWm) + f.a.a.b.b.a.bz(15, this.FWn);
      paramInt = i;
      if (this.FSg != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.FSg);
      }
      i = paramInt + f.a.a.b.b.a.bz(17, this.FWo);
      paramInt = i;
      if (this.FWp != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.FWp);
      }
      i = paramInt;
      if (this.FWq != null) {
        i = paramInt + f.a.a.a.lI(19, this.FWq.computeSize());
      }
      paramInt = i;
      if (this.FSj != null) {
        paramInt = i + f.a.a.a.lI(20, this.FSj.computeSize());
      }
      i = paramInt;
      if (this.FWr != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.FWr);
      }
      paramInt = i;
      if (this.FWs != null) {
        paramInt = i + f.a.a.a.lI(22, this.FWs.computeSize());
      }
      i = paramInt;
      if (this.FWt != null) {
        i = paramInt + f.a.a.a.lI(23, this.FWt.computeSize());
      }
      AppMethodBeat.o(134243);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(134243);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        lq locallq = (lq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134243);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 2: 
          locallq.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 3: 
          locallq.FWe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 4: 
          locallq.FSQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134243);
          return 0;
        case 5: 
          locallq.FWf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 6: 
          locallq.FWg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134243);
          return 0;
        case 7: 
          locallq.FWh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 8: 
          locallq.FRD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 9: 
          locallq.FWi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134243);
          return 0;
        case 10: 
          locallq.FWj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 11: 
          locallq.FWk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallq.FWl = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 13: 
          locallq.qkN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 14: 
          locallq.FWm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134243);
          return 0;
        case 15: 
          locallq.FWn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134243);
          return 0;
        case 16: 
          locallq.FSg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 17: 
          locallq.FWo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134243);
          return 0;
        case 18: 
          locallq.FWp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 19: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallq.FWq = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallq.FSj = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 21: 
          locallq.FWr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallq.FWs = ((dfq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locallq.FWt = ((ccv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(134243);
        return 0;
      }
      AppMethodBeat.o(134243);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lq
 * JD-Core Version:    0.7.0.1
 */