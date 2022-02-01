package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdo
  extends com.tencent.mm.bx.a
{
  public String CVv;
  public String CVw;
  public cwh DJb;
  public zh DJc;
  public int DZO;
  public String DZP;
  public int DZQ;
  public String DZR;
  public String Dqd;
  public int ijM;
  public String ijN;
  public String ijO;
  public String ijP;
  public int ijQ;
  public String ijR;
  public int ijS;
  public int ijT;
  public String ijU;
  public String ijV;
  public String ijW;
  public String mAQ;
  public String mBV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155448);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DZO);
      if (this.mAQ != null) {
        paramVarArgs.d(2, this.mAQ);
      }
      if (this.mBV != null) {
        paramVarArgs.d(3, this.mBV);
      }
      if (this.DZP != null) {
        paramVarArgs.d(4, this.DZP);
      }
      paramVarArgs.aR(5, this.DZQ);
      if (this.DZR != null) {
        paramVarArgs.d(6, this.DZR);
      }
      paramVarArgs.aR(7, this.ijM);
      if (this.ijN != null) {
        paramVarArgs.d(8, this.ijN);
      }
      if (this.ijO != null) {
        paramVarArgs.d(9, this.ijO);
      }
      if (this.ijP != null) {
        paramVarArgs.d(10, this.ijP);
      }
      paramVarArgs.aR(11, this.ijQ);
      if (this.ijR != null) {
        paramVarArgs.d(12, this.ijR);
      }
      paramVarArgs.aR(13, this.ijS);
      paramVarArgs.aR(14, this.ijT);
      if (this.ijU != null) {
        paramVarArgs.d(15, this.ijU);
      }
      if (this.DJb != null)
      {
        paramVarArgs.kX(16, this.DJb.computeSize());
        this.DJb.writeFields(paramVarArgs);
      }
      if (this.ijV != null) {
        paramVarArgs.d(17, this.ijV);
      }
      if (this.ijW != null) {
        paramVarArgs.d(18, this.ijW);
      }
      if (this.DJc != null)
      {
        paramVarArgs.kX(19, this.DJc.computeSize());
        this.DJc.writeFields(paramVarArgs);
      }
      if (this.CVv != null) {
        paramVarArgs.d(20, this.CVv);
      }
      if (this.CVw != null) {
        paramVarArgs.d(21, this.CVw);
      }
      if (this.Dqd != null) {
        paramVarArgs.d(22, this.Dqd);
      }
      AppMethodBeat.o(155448);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.DZO) + 0;
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mAQ);
      }
      i = paramInt;
      if (this.mBV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.mBV);
      }
      paramInt = i;
      if (this.DZP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DZP);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.DZQ);
      paramInt = i;
      if (this.DZR != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DZR);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.ijM);
      paramInt = i;
      if (this.ijN != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ijN);
      }
      i = paramInt;
      if (this.ijO != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.ijO);
      }
      paramInt = i;
      if (this.ijP != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.ijP);
      }
      i = paramInt + f.a.a.b.b.a.bA(11, this.ijQ);
      paramInt = i;
      if (this.ijR != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.ijR);
      }
      i = paramInt + f.a.a.b.b.a.bA(13, this.ijS) + f.a.a.b.b.a.bA(14, this.ijT);
      paramInt = i;
      if (this.ijU != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.ijU);
      }
      i = paramInt;
      if (this.DJb != null) {
        i = paramInt + f.a.a.a.kW(16, this.DJb.computeSize());
      }
      paramInt = i;
      if (this.ijV != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.ijV);
      }
      i = paramInt;
      if (this.ijW != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.ijW);
      }
      paramInt = i;
      if (this.DJc != null) {
        paramInt = i + f.a.a.a.kW(19, this.DJc.computeSize());
      }
      i = paramInt;
      if (this.CVv != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.CVv);
      }
      paramInt = i;
      if (this.CVw != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.CVw);
      }
      i = paramInt;
      if (this.Dqd != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.Dqd);
      }
      AppMethodBeat.o(155448);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(155448);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cdo localcdo = (cdo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155448);
        return -1;
      case 1: 
        localcdo.DZO = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(155448);
        return 0;
      case 2: 
        localcdo.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 3: 
        localcdo.mBV = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 4: 
        localcdo.DZP = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 5: 
        localcdo.DZQ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(155448);
        return 0;
      case 6: 
        localcdo.DZR = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 7: 
        localcdo.ijM = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(155448);
        return 0;
      case 8: 
        localcdo.ijN = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 9: 
        localcdo.ijO = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 10: 
        localcdo.ijP = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 11: 
        localcdo.ijQ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(155448);
        return 0;
      case 12: 
        localcdo.ijR = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 13: 
        localcdo.ijS = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(155448);
        return 0;
      case 14: 
        localcdo.ijT = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(155448);
        return 0;
      case 15: 
        localcdo.ijU = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcdo.DJb = ((cwh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155448);
        return 0;
      case 17: 
        localcdo.ijV = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 18: 
        localcdo.ijW = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 19: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcdo.DJc = ((zh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155448);
        return 0;
      case 20: 
        localcdo.CVv = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 21: 
        localcdo.CVw = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(155448);
        return 0;
      }
      localcdo.Dqd = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(155448);
      return 0;
    }
    AppMethodBeat.o(155448);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdo
 * JD-Core Version:    0.7.0.1
 */