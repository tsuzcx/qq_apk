package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class djw
  extends ckq
{
  public SKBuiltinBuffer_t CBT;
  public SKBuiltinBuffer_t CBU;
  public int CCB;
  public String DyE;
  public int EzI;
  public LinkedList<djt> EzJ;
  public int EzK;
  public LinkedList<Integer> EzL;
  public int EzM;
  public LinkedList<djv> EzN;
  public int EzO;
  
  public djw()
  {
    AppMethodBeat.i(152726);
    this.EzJ = new LinkedList();
    this.EzL = new LinkedList();
    this.EzN = new LinkedList();
    AppMethodBeat.o(152726);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152727);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CCB);
      paramVarArgs.aR(3, this.EzI);
      paramVarArgs.e(4, 8, this.EzJ);
      if (this.DyE != null) {
        paramVarArgs.d(5, this.DyE);
      }
      paramVarArgs.aR(6, this.EzK);
      paramVarArgs.f(7, 2, this.EzL);
      paramVarArgs.aR(8, this.EzM);
      paramVarArgs.e(9, 8, this.EzN);
      if (this.CBT != null)
      {
        paramVarArgs.kX(10, this.CBT.computeSize());
        this.CBT.writeFields(paramVarArgs);
      }
      if (this.CBU != null)
      {
        paramVarArgs.kX(11, this.CBU.computeSize());
        this.CBU.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(12, this.EzO);
      AppMethodBeat.o(152727);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1253;
      }
    }
    label1253:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CCB) + f.a.a.b.b.a.bA(3, this.EzI) + f.a.a.a.c(4, 8, this.EzJ);
      paramInt = i;
      if (this.DyE != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DyE);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.EzK) + f.a.a.a.d(7, 2, this.EzL) + f.a.a.b.b.a.bA(8, this.EzM) + f.a.a.a.c(9, 8, this.EzN);
      paramInt = i;
      if (this.CBT != null) {
        paramInt = i + f.a.a.a.kW(10, this.CBT.computeSize());
      }
      i = paramInt;
      if (this.CBU != null) {
        i = paramInt + f.a.a.a.kW(11, this.CBU.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(12, this.EzO);
      AppMethodBeat.o(152727);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EzJ.clear();
        this.EzL.clear();
        this.EzN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152727);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        djw localdjw = (djw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152727);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjw.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 2: 
          localdjw.CCB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152727);
          return 0;
        case 3: 
          localdjw.EzI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152727);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new djt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((djt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjw.EzJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 5: 
          localdjw.DyE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152727);
          return 0;
        case 6: 
          localdjw.EzK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152727);
          return 0;
        case 7: 
          localdjw.EzL = new f.a.a.a.a(((f.a.a.a.a)localObject1).KhF.fMu().wA, unknownTagHandler).KhF.fMs();
          AppMethodBeat.o(152727);
          return 0;
        case 8: 
          localdjw.EzM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152727);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new djv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((djv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjw.EzN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjw.CBT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjw.CBU = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        }
        localdjw.EzO = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152727);
        return 0;
      }
      AppMethodBeat.o(152727);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djw
 * JD-Core Version:    0.7.0.1
 */