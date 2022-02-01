package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvq
  extends cvw
{
  public SKBuiltinBuffer_t FUo;
  public String FWJ;
  public cxn FWN;
  public SKBuiltinBuffer_t FWO;
  public cxn GYt;
  public int HLl;
  public String IaX;
  public cxn IaY;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43133);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.OpCode);
      if (this.IaX != null) {
        paramVarArgs.d(3, this.IaX);
      }
      if (this.FWJ != null) {
        paramVarArgs.d(4, this.FWJ);
      }
      if (this.GYt != null)
      {
        paramVarArgs.lJ(5, this.GYt.computeSize());
        this.GYt.writeFields(paramVarArgs);
      }
      if (this.IaY != null)
      {
        paramVarArgs.lJ(6, this.IaY.computeSize());
        this.IaY.writeFields(paramVarArgs);
      }
      if (this.FWN != null)
      {
        paramVarArgs.lJ(7, this.FWN.computeSize());
        this.FWN.writeFields(paramVarArgs);
      }
      if (this.FWO != null)
      {
        paramVarArgs.lJ(8, this.FWO.computeSize());
        this.FWO.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.HLl);
      if (this.FUo != null)
      {
        paramVarArgs.lJ(10, this.FUo.computeSize());
        this.FUo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43133);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1298;
      }
    }
    label1298:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.OpCode);
      paramInt = i;
      if (this.IaX != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.IaX);
      }
      i = paramInt;
      if (this.FWJ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FWJ);
      }
      paramInt = i;
      if (this.GYt != null) {
        paramInt = i + f.a.a.a.lI(5, this.GYt.computeSize());
      }
      i = paramInt;
      if (this.IaY != null) {
        i = paramInt + f.a.a.a.lI(6, this.IaY.computeSize());
      }
      paramInt = i;
      if (this.FWN != null) {
        paramInt = i + f.a.a.a.lI(7, this.FWN.computeSize());
      }
      i = paramInt;
      if (this.FWO != null) {
        i = paramInt + f.a.a.a.lI(8, this.FWO.computeSize());
      }
      i += f.a.a.b.b.a.bz(9, this.HLl);
      paramInt = i;
      if (this.FUo != null) {
        paramInt = i + f.a.a.a.lI(10, this.FUo.computeSize());
      }
      AppMethodBeat.o(43133);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(43133);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dvq localdvq = (dvq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43133);
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
            localdvq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 2: 
          localdvq.OpCode = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43133);
          return 0;
        case 3: 
          localdvq.IaX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43133);
          return 0;
        case 4: 
          localdvq.FWJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43133);
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
            localdvq.GYt = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
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
            localdvq.IaY = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
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
            localdvq.FWN = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvq.FWO = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 9: 
          localdvq.HLl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43133);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdvq.FUo = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43133);
        return 0;
      }
      AppMethodBeat.o(43133);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvq
 * JD-Core Version:    0.7.0.1
 */