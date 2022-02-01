package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class baw
  extends ckq
{
  public String CBQ;
  public SKBuiltinBuffer_t CFU;
  public String DyA;
  public String DyB;
  public String DyC;
  public String DyD;
  public String DyE;
  public int DyF;
  public String mBV;
  public String oXs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155417);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CFU == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(155417);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CFU != null)
      {
        paramVarArgs.kX(2, this.CFU.computeSize());
        this.CFU.writeFields(paramVarArgs);
      }
      if (this.DyA != null) {
        paramVarArgs.d(3, this.DyA);
      }
      if (this.DyB != null) {
        paramVarArgs.d(4, this.DyB);
      }
      if (this.mBV != null) {
        paramVarArgs.d(5, this.mBV);
      }
      if (this.DyC != null) {
        paramVarArgs.d(6, this.DyC);
      }
      if (this.DyD != null) {
        paramVarArgs.d(7, this.DyD);
      }
      if (this.DyE != null) {
        paramVarArgs.d(8, this.DyE);
      }
      paramVarArgs.aR(9, this.DyF);
      if (this.oXs != null) {
        paramVarArgs.d(10, this.oXs);
      }
      if (this.CBQ != null) {
        paramVarArgs.d(11, this.CBQ);
      }
      AppMethodBeat.o(155417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1050;
      }
    }
    label1050:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CFU != null) {
        paramInt = i + f.a.a.a.kW(2, this.CFU.computeSize());
      }
      i = paramInt;
      if (this.DyA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DyA);
      }
      paramInt = i;
      if (this.DyB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DyB);
      }
      i = paramInt;
      if (this.mBV != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.mBV);
      }
      paramInt = i;
      if (this.DyC != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DyC);
      }
      i = paramInt;
      if (this.DyD != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DyD);
      }
      paramInt = i;
      if (this.DyE != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DyE);
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.DyF);
      paramInt = i;
      if (this.oXs != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.oXs);
      }
      i = paramInt;
      if (this.CBQ != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.CBQ);
      }
      AppMethodBeat.o(155417);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CFU == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(155417);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155417);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        baw localbaw = (baw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155417);
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
            localbaw.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155417);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbaw.CFU = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155417);
          return 0;
        case 3: 
          localbaw.DyA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 4: 
          localbaw.DyB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 5: 
          localbaw.mBV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 6: 
          localbaw.DyC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 7: 
          localbaw.DyD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 8: 
          localbaw.DyE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 9: 
          localbaw.DyF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(155417);
          return 0;
        case 10: 
          localbaw.oXs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155417);
          return 0;
        }
        localbaw.CBQ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(155417);
        return 0;
      }
      AppMethodBeat.o(155417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baw
 * JD-Core Version:    0.7.0.1
 */