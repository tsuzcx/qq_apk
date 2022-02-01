package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bna
  extends com.tencent.mm.bx.a
{
  public String CVv;
  public String CVw;
  public cwh DJb;
  public zh DJc;
  public aet DKt;
  public String Dqd;
  public String Nickname;
  public String Username;
  public String ijL;
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
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155440);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.d(2, this.Nickname);
      }
      if (this.ijL != null) {
        paramVarArgs.d(3, this.ijL);
      }
      paramVarArgs.aR(4, this.ijM);
      if (this.ijN != null) {
        paramVarArgs.d(5, this.ijN);
      }
      if (this.ijO != null) {
        paramVarArgs.d(6, this.ijO);
      }
      if (this.ijP != null) {
        paramVarArgs.d(7, this.ijP);
      }
      paramVarArgs.aR(8, this.ijQ);
      if (this.ijR != null) {
        paramVarArgs.d(9, this.ijR);
      }
      if (this.DKt != null)
      {
        paramVarArgs.kX(10, this.DKt.computeSize());
        this.DKt.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.ijS);
      paramVarArgs.aR(12, this.ijT);
      if (this.ijU != null) {
        paramVarArgs.d(13, this.ijU);
      }
      if (this.DJb != null)
      {
        paramVarArgs.kX(14, this.DJb.computeSize());
        this.DJb.writeFields(paramVarArgs);
      }
      if (this.ijV != null) {
        paramVarArgs.d(15, this.ijV);
      }
      if (this.ijW != null) {
        paramVarArgs.d(16, this.ijW);
      }
      if (this.DJc != null)
      {
        paramVarArgs.kX(17, this.DJc.computeSize());
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
      AppMethodBeat.o(155440);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label1610;
      }
    }
    label1610:
    for (int i = f.a.a.b.b.a.e(1, this.Username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Nickname);
      }
      i = paramInt;
      if (this.ijL != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ijL);
      }
      i += f.a.a.b.b.a.bA(4, this.ijM);
      paramInt = i;
      if (this.ijN != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ijN);
      }
      i = paramInt;
      if (this.ijO != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.ijO);
      }
      paramInt = i;
      if (this.ijP != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ijP);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.ijQ);
      paramInt = i;
      if (this.ijR != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.ijR);
      }
      i = paramInt;
      if (this.DKt != null) {
        i = paramInt + f.a.a.a.kW(10, this.DKt.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(11, this.ijS) + f.a.a.b.b.a.bA(12, this.ijT);
      paramInt = i;
      if (this.ijU != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.ijU);
      }
      i = paramInt;
      if (this.DJb != null) {
        i = paramInt + f.a.a.a.kW(14, this.DJb.computeSize());
      }
      paramInt = i;
      if (this.ijV != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.ijV);
      }
      i = paramInt;
      if (this.ijW != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.ijW);
      }
      paramInt = i;
      if (this.DJc != null) {
        paramInt = i + f.a.a.a.kW(17, this.DJc.computeSize());
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
      AppMethodBeat.o(155440);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(155440);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bna localbna = (bna)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        case 19: 
        default: 
          AppMethodBeat.o(155440);
          return -1;
        case 1: 
          localbna.Username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 2: 
          localbna.Nickname = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 3: 
          localbna.ijL = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 4: 
          localbna.ijM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(155440);
          return 0;
        case 5: 
          localbna.ijN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 6: 
          localbna.ijO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 7: 
          localbna.ijP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 8: 
          localbna.ijQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(155440);
          return 0;
        case 9: 
          localbna.ijR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aet();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aet)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbna.DKt = ((aet)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 11: 
          localbna.ijS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(155440);
          return 0;
        case 12: 
          localbna.ijT = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(155440);
          return 0;
        case 13: 
          localbna.ijU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbna.DJb = ((cwh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 15: 
          localbna.ijV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 16: 
          localbna.ijW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbna.DJc = ((zh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 20: 
          localbna.CVv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 21: 
          localbna.CVw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155440);
          return 0;
        }
        localbna.Dqd = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(155440);
        return 0;
      }
      AppMethodBeat.o(155440);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bna
 * JD-Core Version:    0.7.0.1
 */