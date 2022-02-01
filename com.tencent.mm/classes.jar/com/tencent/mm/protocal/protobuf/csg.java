package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csg
  extends ckq
{
  public SKBuiltinBuffer_t CBT;
  public SKBuiltinBuffer_t CBU;
  public float COI;
  public float COJ;
  public int DfE;
  public String DfF;
  public String DfG;
  public int DfH;
  public int Ekp;
  public int Ekq;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32446);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.OpCode);
      paramVarArgs.x(3, this.COI);
      paramVarArgs.x(4, this.COJ);
      paramVarArgs.aR(5, this.DfE);
      if (this.DfF != null) {
        paramVarArgs.d(6, this.DfF);
      }
      if (this.DfG != null) {
        paramVarArgs.d(7, this.DfG);
      }
      paramVarArgs.aR(8, this.Ekp);
      paramVarArgs.aR(9, this.Ekq);
      paramVarArgs.aR(10, this.DfH);
      if (this.CBT != null)
      {
        paramVarArgs.kX(11, this.CBT.computeSize());
        this.CBT.writeFields(paramVarArgs);
      }
      if (this.CBU != null)
      {
        paramVarArgs.kX(12, this.CBU.computeSize());
        this.CBU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32446);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1070;
      }
    }
    label1070:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.OpCode) + (f.a.a.b.b.a.fY(3) + 4) + (f.a.a.b.b.a.fY(4) + 4) + f.a.a.b.b.a.bA(5, this.DfE);
      paramInt = i;
      if (this.DfF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DfF);
      }
      i = paramInt;
      if (this.DfG != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DfG);
      }
      i = i + f.a.a.b.b.a.bA(8, this.Ekp) + f.a.a.b.b.a.bA(9, this.Ekq) + f.a.a.b.b.a.bA(10, this.DfH);
      paramInt = i;
      if (this.CBT != null) {
        paramInt = i + f.a.a.a.kW(11, this.CBT.computeSize());
      }
      i = paramInt;
      if (this.CBU != null) {
        i = paramInt + f.a.a.a.kW(12, this.CBU.computeSize());
      }
      AppMethodBeat.o(32446);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32446);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csg localcsg = (csg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32446);
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
            localcsg.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32446);
          return 0;
        case 2: 
          localcsg.OpCode = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32446);
          return 0;
        case 3: 
          localcsg.COI = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(32446);
          return 0;
        case 4: 
          localcsg.COJ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(32446);
          return 0;
        case 5: 
          localcsg.DfE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32446);
          return 0;
        case 6: 
          localcsg.DfF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32446);
          return 0;
        case 7: 
          localcsg.DfG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32446);
          return 0;
        case 8: 
          localcsg.Ekp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32446);
          return 0;
        case 9: 
          localcsg.Ekq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32446);
          return 0;
        case 10: 
          localcsg.DfH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32446);
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
            localcsg.CBT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32446);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcsg.CBU = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32446);
        return 0;
      }
      AppMethodBeat.o(32446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csg
 * JD-Core Version:    0.7.0.1
 */