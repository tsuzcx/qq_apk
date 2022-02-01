package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avy
  extends cvw
{
  public int FNv;
  public int FQm;
  public SKBuiltinBuffer_t FRA;
  public int FSu;
  public int GMY;
  public String GMZ;
  public SKBuiltinBuffer_t GNA;
  public cxn GNp;
  public cxn GNq;
  public cxn GNr;
  public cxn GNs;
  public String GNt;
  public int GNu;
  public String GNv;
  public SKBuiltinBuffer_t GNw;
  public int GNx;
  public String GNy;
  public int GNz;
  public int Goq;
  public int Gor;
  public int OpCode;
  public int Scene;
  public String nIJ;
  public String oxI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152552);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.OpCode);
      if (this.FRA != null)
      {
        paramVarArgs.lJ(3, this.FRA.computeSize());
        this.FRA.writeFields(paramVarArgs);
      }
      if (this.GNp != null)
      {
        paramVarArgs.lJ(4, this.GNp.computeSize());
        this.GNp.writeFields(paramVarArgs);
      }
      if (this.GNq != null)
      {
        paramVarArgs.lJ(5, this.GNq.computeSize());
        this.GNq.writeFields(paramVarArgs);
      }
      if (this.GNr != null)
      {
        paramVarArgs.lJ(6, this.GNr.computeSize());
        this.GNr.writeFields(paramVarArgs);
      }
      if (this.GNs != null)
      {
        paramVarArgs.lJ(7, this.GNs.computeSize());
        this.GNs.writeFields(paramVarArgs);
      }
      if (this.GNt != null) {
        paramVarArgs.d(8, this.GNt);
      }
      paramVarArgs.aS(9, this.GNu);
      paramVarArgs.aS(10, this.Scene);
      if (this.nIJ != null) {
        paramVarArgs.d(11, this.nIJ);
      }
      if (this.GNv != null) {
        paramVarArgs.d(12, this.GNv);
      }
      if (this.GNw != null)
      {
        paramVarArgs.lJ(13, this.GNw.computeSize());
        this.GNw.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(14, this.FSu);
      paramVarArgs.aS(15, this.GMY);
      paramVarArgs.aS(16, this.FNv);
      if (this.oxI != null) {
        paramVarArgs.d(17, this.oxI);
      }
      paramVarArgs.aS(18, this.Goq);
      paramVarArgs.aS(19, this.Gor);
      paramVarArgs.aS(20, this.GNx);
      if (this.GNy != null) {
        paramVarArgs.d(21, this.GNy);
      }
      paramVarArgs.aS(22, this.GNz);
      if (this.GNA != null)
      {
        paramVarArgs.lJ(23, this.GNA.computeSize());
        this.GNA.writeFields(paramVarArgs);
      }
      if (this.GMZ != null) {
        paramVarArgs.d(24, this.GMZ);
      }
      paramVarArgs.aS(25, this.FQm);
      AppMethodBeat.o(152552);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2262;
      }
    }
    label2262:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.OpCode);
      paramInt = i;
      if (this.FRA != null) {
        paramInt = i + f.a.a.a.lI(3, this.FRA.computeSize());
      }
      i = paramInt;
      if (this.GNp != null) {
        i = paramInt + f.a.a.a.lI(4, this.GNp.computeSize());
      }
      paramInt = i;
      if (this.GNq != null) {
        paramInt = i + f.a.a.a.lI(5, this.GNq.computeSize());
      }
      i = paramInt;
      if (this.GNr != null) {
        i = paramInt + f.a.a.a.lI(6, this.GNr.computeSize());
      }
      paramInt = i;
      if (this.GNs != null) {
        paramInt = i + f.a.a.a.lI(7, this.GNs.computeSize());
      }
      i = paramInt;
      if (this.GNt != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GNt);
      }
      i = i + f.a.a.b.b.a.bz(9, this.GNu) + f.a.a.b.b.a.bz(10, this.Scene);
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.nIJ);
      }
      i = paramInt;
      if (this.GNv != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GNv);
      }
      paramInt = i;
      if (this.GNw != null) {
        paramInt = i + f.a.a.a.lI(13, this.GNw.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(14, this.FSu) + f.a.a.b.b.a.bz(15, this.GMY) + f.a.a.b.b.a.bz(16, this.FNv);
      paramInt = i;
      if (this.oxI != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.oxI);
      }
      i = paramInt + f.a.a.b.b.a.bz(18, this.Goq) + f.a.a.b.b.a.bz(19, this.Gor) + f.a.a.b.b.a.bz(20, this.GNx);
      paramInt = i;
      if (this.GNy != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.GNy);
      }
      i = paramInt + f.a.a.b.b.a.bz(22, this.GNz);
      paramInt = i;
      if (this.GNA != null) {
        paramInt = i + f.a.a.a.lI(23, this.GNA.computeSize());
      }
      i = paramInt;
      if (this.GMZ != null) {
        i = paramInt + f.a.a.b.b.a.e(24, this.GMZ);
      }
      paramInt = f.a.a.b.b.a.bz(25, this.FQm);
      AppMethodBeat.o(152552);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152552);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avy localavy = (avy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152552);
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
            localavy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 2: 
          localavy.OpCode = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152552);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavy.FRA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavy.GNp = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavy.GNq = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavy.GNr = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavy.GNs = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 8: 
          localavy.GNt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 9: 
          localavy.GNu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152552);
          return 0;
        case 10: 
          localavy.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152552);
          return 0;
        case 11: 
          localavy.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 12: 
          localavy.GNv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavy.GNw = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 14: 
          localavy.FSu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152552);
          return 0;
        case 15: 
          localavy.GMY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152552);
          return 0;
        case 16: 
          localavy.FNv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152552);
          return 0;
        case 17: 
          localavy.oxI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 18: 
          localavy.Goq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152552);
          return 0;
        case 19: 
          localavy.Gor = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152552);
          return 0;
        case 20: 
          localavy.GNx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152552);
          return 0;
        case 21: 
          localavy.GNy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 22: 
          localavy.GNz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152552);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavy.GNA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 24: 
          localavy.GMZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152552);
          return 0;
        }
        localavy.FQm = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152552);
        return 0;
      }
      AppMethodBeat.o(152552);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avy
 * JD-Core Version:    0.7.0.1
 */