package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class csb
  extends com.tencent.mm.bx.a
{
  public String CVv;
  public String CVw;
  public int CxA;
  public String DIU;
  public int DIV;
  public String DIW;
  public String DIX;
  public String DIY;
  public int DIZ;
  public int DJa;
  public cwh DJb;
  public zh DJc;
  public String Dqd;
  public String DyE;
  public int EjY;
  public SKBuiltinBuffer_t EjZ;
  public int Eka;
  public int ijM;
  public String ijN;
  public String ijO;
  public String ijP;
  public String ijV;
  public String ijW;
  public String mAQ;
  public String mBV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32440);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EjZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuffer");
        AppMethodBeat.o(32440);
        throw paramVarArgs;
      }
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      if (this.mBV != null) {
        paramVarArgs.d(2, this.mBV);
      }
      if (this.ijN != null) {
        paramVarArgs.d(3, this.ijN);
      }
      if (this.ijO != null) {
        paramVarArgs.d(4, this.ijO);
      }
      if (this.ijP != null) {
        paramVarArgs.d(5, this.ijP);
      }
      if (this.DIU != null) {
        paramVarArgs.d(6, this.DIU);
      }
      paramVarArgs.aR(7, this.ijM);
      paramVarArgs.aR(8, this.CxA);
      paramVarArgs.aR(9, this.EjY);
      if (this.EjZ != null)
      {
        paramVarArgs.kX(10, this.EjZ.computeSize());
        this.EjZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.Eka);
      if (this.DIX != null) {
        paramVarArgs.d(12, this.DIX);
      }
      if (this.DIY != null) {
        paramVarArgs.d(13, this.DIY);
      }
      paramVarArgs.aR(14, this.DIZ);
      paramVarArgs.aR(15, this.DIV);
      if (this.DIW != null) {
        paramVarArgs.d(16, this.DIW);
      }
      if (this.DyE != null) {
        paramVarArgs.d(17, this.DyE);
      }
      paramVarArgs.aR(21, this.DJa);
      if (this.DJb != null)
      {
        paramVarArgs.kX(22, this.DJb.computeSize());
        this.DJb.writeFields(paramVarArgs);
      }
      if (this.ijV != null) {
        paramVarArgs.d(23, this.ijV);
      }
      if (this.CVv != null) {
        paramVarArgs.d(24, this.CVv);
      }
      if (this.CVw != null) {
        paramVarArgs.d(25, this.CVw);
      }
      if (this.ijW != null) {
        paramVarArgs.d(26, this.ijW);
      }
      if (this.DJc != null)
      {
        paramVarArgs.kX(27, this.DJc.computeSize());
        this.DJc.writeFields(paramVarArgs);
      }
      if (this.Dqd != null) {
        paramVarArgs.d(28, this.Dqd);
      }
      AppMethodBeat.o(32440);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label1953;
      }
    }
    label1953:
    for (int i = f.a.a.b.b.a.e(1, this.mAQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mBV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mBV);
      }
      i = paramInt;
      if (this.ijN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ijN);
      }
      paramInt = i;
      if (this.ijO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ijO);
      }
      i = paramInt;
      if (this.ijP != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ijP);
      }
      paramInt = i;
      if (this.DIU != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DIU);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.ijM) + f.a.a.b.b.a.bA(8, this.CxA) + f.a.a.b.b.a.bA(9, this.EjY);
      paramInt = i;
      if (this.EjZ != null) {
        paramInt = i + f.a.a.a.kW(10, this.EjZ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(11, this.Eka);
      paramInt = i;
      if (this.DIX != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DIX);
      }
      i = paramInt;
      if (this.DIY != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.DIY);
      }
      i = i + f.a.a.b.b.a.bA(14, this.DIZ) + f.a.a.b.b.a.bA(15, this.DIV);
      paramInt = i;
      if (this.DIW != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.DIW);
      }
      i = paramInt;
      if (this.DyE != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.DyE);
      }
      i += f.a.a.b.b.a.bA(21, this.DJa);
      paramInt = i;
      if (this.DJb != null) {
        paramInt = i + f.a.a.a.kW(22, this.DJb.computeSize());
      }
      i = paramInt;
      if (this.ijV != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.ijV);
      }
      paramInt = i;
      if (this.CVv != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.CVv);
      }
      i = paramInt;
      if (this.CVw != null) {
        i = paramInt + f.a.a.b.b.a.e(25, this.CVw);
      }
      paramInt = i;
      if (this.ijW != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.ijW);
      }
      i = paramInt;
      if (this.DJc != null) {
        i = paramInt + f.a.a.a.kW(27, this.DJc.computeSize());
      }
      paramInt = i;
      if (this.Dqd != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.Dqd);
      }
      AppMethodBeat.o(32440);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.EjZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuffer");
          AppMethodBeat.o(32440);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32440);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csb localcsb = (csb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        case 19: 
        case 20: 
        default: 
          AppMethodBeat.o(32440);
          return -1;
        case 1: 
          localcsb.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 2: 
          localcsb.mBV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 3: 
          localcsb.ijN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 4: 
          localcsb.ijO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 5: 
          localcsb.ijP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 6: 
          localcsb.DIU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 7: 
          localcsb.ijM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32440);
          return 0;
        case 8: 
          localcsb.CxA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32440);
          return 0;
        case 9: 
          localcsb.EjY = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32440);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsb.EjZ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        case 11: 
          localcsb.Eka = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32440);
          return 0;
        case 12: 
          localcsb.DIX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 13: 
          localcsb.DIY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 14: 
          localcsb.DIZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32440);
          return 0;
        case 15: 
          localcsb.DIV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32440);
          return 0;
        case 16: 
          localcsb.DIW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 17: 
          localcsb.DyE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 21: 
          localcsb.DJa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32440);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsb.DJb = ((cwh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        case 23: 
          localcsb.ijV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 24: 
          localcsb.CVv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 25: 
          localcsb.CVw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 26: 
          localcsb.ijW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 27: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsb.DJc = ((zh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        }
        localcsb.Dqd = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32440);
        return 0;
      }
      AppMethodBeat.o(32440);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csb
 * JD-Core Version:    0.7.0.1
 */