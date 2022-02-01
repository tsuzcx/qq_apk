package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhf
  extends com.tencent.mm.bx.a
{
  public int Edd;
  public String Ede;
  public String ZOJ;
  public int ZOK;
  public String ZQD;
  public String ZQE;
  public String ZQF;
  public cbo ZQG;
  public int ZQH;
  public gfi ZQI;
  public String ZQJ;
  public String ZQK;
  public String ZQL;
  public String ZQM;
  public fhh ZQN;
  public String ZQO;
  public gfi ZQP;
  public String ZQQ;
  public String ZQR;
  public int status;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257767);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.status);
      if (this.title != null) {
        paramVarArgs.g(2, this.title);
      }
      if (this.ZOJ != null) {
        paramVarArgs.g(3, this.ZOJ);
      }
      if (this.ZQD != null) {
        paramVarArgs.g(4, this.ZQD);
      }
      if (this.ZQE != null) {
        paramVarArgs.g(5, this.ZQE);
      }
      paramVarArgs.bS(6, this.ZOK);
      if (this.ZQF != null) {
        paramVarArgs.g(7, this.ZQF);
      }
      if (this.ZQG != null)
      {
        paramVarArgs.qD(8, this.ZQG.computeSize());
        this.ZQG.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(9, this.Edd);
      if (this.Ede != null) {
        paramVarArgs.g(10, this.Ede);
      }
      paramVarArgs.bS(11, this.ZQH);
      if (this.ZQI != null)
      {
        paramVarArgs.qD(12, this.ZQI.computeSize());
        this.ZQI.writeFields(paramVarArgs);
      }
      if (this.ZQJ != null) {
        paramVarArgs.g(13, this.ZQJ);
      }
      if (this.ZQK != null) {
        paramVarArgs.g(14, this.ZQK);
      }
      if (this.ZQL != null) {
        paramVarArgs.g(15, this.ZQL);
      }
      if (this.ZQM != null) {
        paramVarArgs.g(16, this.ZQM);
      }
      if (this.ZQN != null)
      {
        paramVarArgs.qD(17, this.ZQN.computeSize());
        this.ZQN.writeFields(paramVarArgs);
      }
      if (this.ZQO != null) {
        paramVarArgs.g(18, this.ZQO);
      }
      if (this.ZQP != null)
      {
        paramVarArgs.qD(19, this.ZQP.computeSize());
        this.ZQP.writeFields(paramVarArgs);
      }
      if (this.ZQQ != null) {
        paramVarArgs.g(20, this.ZQQ);
      }
      if (this.ZQR != null) {
        paramVarArgs.g(21, this.ZQR);
      }
      AppMethodBeat.o(257767);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.status) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.title);
      }
      i = paramInt;
      if (this.ZOJ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZOJ);
      }
      paramInt = i;
      if (this.ZQD != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZQD);
      }
      i = paramInt;
      if (this.ZQE != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZQE);
      }
      i += i.a.a.b.b.a.cJ(6, this.ZOK);
      paramInt = i;
      if (this.ZQF != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ZQF);
      }
      i = paramInt;
      if (this.ZQG != null) {
        i = paramInt + i.a.a.a.qC(8, this.ZQG.computeSize());
      }
      i += i.a.a.b.b.a.cJ(9, this.Edd);
      paramInt = i;
      if (this.Ede != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.Ede);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.ZQH);
      paramInt = i;
      if (this.ZQI != null) {
        paramInt = i + i.a.a.a.qC(12, this.ZQI.computeSize());
      }
      i = paramInt;
      if (this.ZQJ != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.ZQJ);
      }
      paramInt = i;
      if (this.ZQK != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.ZQK);
      }
      i = paramInt;
      if (this.ZQL != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.ZQL);
      }
      paramInt = i;
      if (this.ZQM != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.ZQM);
      }
      i = paramInt;
      if (this.ZQN != null) {
        i = paramInt + i.a.a.a.qC(17, this.ZQN.computeSize());
      }
      paramInt = i;
      if (this.ZQO != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.ZQO);
      }
      i = paramInt;
      if (this.ZQP != null) {
        i = paramInt + i.a.a.a.qC(19, this.ZQP.computeSize());
      }
      paramInt = i;
      if (this.ZQQ != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.ZQQ);
      }
      i = paramInt;
      if (this.ZQR != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.ZQR);
      }
      AppMethodBeat.o(257767);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257767);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      bhf localbhf = (bhf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257767);
        return -1;
      case 1: 
        localbhf.status = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257767);
        return 0;
      case 2: 
        localbhf.title = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257767);
        return 0;
      case 3: 
        localbhf.ZOJ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257767);
        return 0;
      case 4: 
        localbhf.ZQD = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257767);
        return 0;
      case 5: 
        localbhf.ZQE = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257767);
        return 0;
      case 6: 
        localbhf.ZOK = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257767);
        return 0;
      case 7: 
        localbhf.ZQF = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257767);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cbo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cbo)localObject2).parseFrom((byte[])localObject1);
          }
          localbhf.ZQG = ((cbo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257767);
        return 0;
      case 9: 
        localbhf.Edd = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257767);
        return 0;
      case 10: 
        localbhf.Ede = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257767);
        return 0;
      case 11: 
        localbhf.ZQH = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257767);
        return 0;
      case 12: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gfi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gfi)localObject2).parseFrom((byte[])localObject1);
          }
          localbhf.ZQI = ((gfi)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257767);
        return 0;
      case 13: 
        localbhf.ZQJ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257767);
        return 0;
      case 14: 
        localbhf.ZQK = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257767);
        return 0;
      case 15: 
        localbhf.ZQL = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257767);
        return 0;
      case 16: 
        localbhf.ZQM = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257767);
        return 0;
      case 17: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fhh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fhh)localObject2).parseFrom((byte[])localObject1);
          }
          localbhf.ZQN = ((fhh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257767);
        return 0;
      case 18: 
        localbhf.ZQO = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257767);
        return 0;
      case 19: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gfi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gfi)localObject2).parseFrom((byte[])localObject1);
          }
          localbhf.ZQP = ((gfi)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257767);
        return 0;
      case 20: 
        localbhf.ZQQ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257767);
        return 0;
      }
      localbhf.ZQR = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(257767);
      return 0;
    }
    AppMethodBeat.o(257767);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhf
 * JD-Core Version:    0.7.0.1
 */