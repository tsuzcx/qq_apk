package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class blb
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
  public int ijM;
  public String ijN;
  public String ijO;
  public String ijP;
  public String ijR;
  public String ijV;
  public String ijW;
  public String mAQ;
  public String mBV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
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
      paramVarArgs.aR(9, this.DIV);
      if (this.DIW != null) {
        paramVarArgs.d(10, this.DIW);
      }
      if (this.DyE != null) {
        paramVarArgs.d(11, this.DyE);
      }
      if (this.ijR != null) {
        paramVarArgs.d(12, this.ijR);
      }
      if (this.DIX != null) {
        paramVarArgs.d(13, this.DIX);
      }
      if (this.DIY != null) {
        paramVarArgs.d(14, this.DIY);
      }
      paramVarArgs.aR(15, this.DIZ);
      paramVarArgs.aR(19, this.DJa);
      if (this.DJb != null)
      {
        paramVarArgs.kX(20, this.DJb.computeSize());
        this.DJb.writeFields(paramVarArgs);
      }
      if (this.ijV != null) {
        paramVarArgs.d(21, this.ijV);
      }
      if (this.CVv != null) {
        paramVarArgs.d(22, this.CVv);
      }
      if (this.CVw != null) {
        paramVarArgs.d(23, this.CVw);
      }
      if (this.ijW != null) {
        paramVarArgs.d(24, this.ijW);
      }
      if (this.DJc != null)
      {
        paramVarArgs.kX(25, this.DJc.computeSize());
        this.DJc.writeFields(paramVarArgs);
      }
      if (this.Dqd != null) {
        paramVarArgs.d(26, this.Dqd);
      }
      AppMethodBeat.o(89925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label1686;
      }
    }
    label1686:
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
      i = paramInt + f.a.a.b.b.a.bA(7, this.ijM) + f.a.a.b.b.a.bA(8, this.CxA) + f.a.a.b.b.a.bA(9, this.DIV);
      paramInt = i;
      if (this.DIW != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DIW);
      }
      i = paramInt;
      if (this.DyE != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.DyE);
      }
      paramInt = i;
      if (this.ijR != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.ijR);
      }
      i = paramInt;
      if (this.DIX != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.DIX);
      }
      paramInt = i;
      if (this.DIY != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.DIY);
      }
      i = paramInt + f.a.a.b.b.a.bA(15, this.DIZ) + f.a.a.b.b.a.bA(19, this.DJa);
      paramInt = i;
      if (this.DJb != null) {
        paramInt = i + f.a.a.a.kW(20, this.DJb.computeSize());
      }
      i = paramInt;
      if (this.ijV != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.ijV);
      }
      paramInt = i;
      if (this.CVv != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.CVv);
      }
      i = paramInt;
      if (this.CVw != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.CVw);
      }
      paramInt = i;
      if (this.ijW != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.ijW);
      }
      i = paramInt;
      if (this.DJc != null) {
        i = paramInt + f.a.a.a.kW(25, this.DJc.computeSize());
      }
      paramInt = i;
      if (this.Dqd != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.Dqd);
      }
      AppMethodBeat.o(89925);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(89925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        blb localblb = (blb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 16: 
        case 17: 
        case 18: 
        default: 
          AppMethodBeat.o(89925);
          return -1;
        case 1: 
          localblb.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 2: 
          localblb.mBV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 3: 
          localblb.ijN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 4: 
          localblb.ijO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 5: 
          localblb.ijP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 6: 
          localblb.DIU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 7: 
          localblb.ijM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(89925);
          return 0;
        case 8: 
          localblb.CxA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(89925);
          return 0;
        case 9: 
          localblb.DIV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(89925);
          return 0;
        case 10: 
          localblb.DIW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 11: 
          localblb.DyE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 12: 
          localblb.ijR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 13: 
          localblb.DIX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 14: 
          localblb.DIY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 15: 
          localblb.DIZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(89925);
          return 0;
        case 19: 
          localblb.DJa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(89925);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblb.DJb = ((cwh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89925);
          return 0;
        case 21: 
          localblb.ijV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 22: 
          localblb.CVv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 23: 
          localblb.CVw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 24: 
          localblb.ijW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblb.DJc = ((zh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89925);
          return 0;
        }
        localblb.Dqd = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(89925);
        return 0;
      }
      AppMethodBeat.o(89925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blb
 * JD-Core Version:    0.7.0.1
 */