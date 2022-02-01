package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awt
  extends com.tencent.mm.bx.a
{
  public int BbV;
  public int EOg;
  public long FOi;
  public String WDP;
  public long ZHH;
  public String ZHI;
  public String ZHJ;
  public int ZHK;
  public int ZHL;
  public bxu ZHM;
  public awx ZHN;
  public FinderJumpInfo ZHO;
  public aws ZHP;
  public int ZHQ;
  public LinkedList<FinderJumpInfo> ZHR;
  public String ZHS;
  public fmi ZHT;
  public awu ZHU;
  public fxs ZHV;
  public FinderContact contact;
  public String coverImgUrl;
  public String description;
  public long endTime;
  public String eventName;
  public int feedCount;
  public FinderJumpInfo hVf;
  public long ocD;
  
  public awt()
  {
    AppMethodBeat.i(260149);
    this.ZHR = new LinkedList();
    AppMethodBeat.o(260149);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260161);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ocD);
      if (this.contact != null)
      {
        paramVarArgs.qD(2, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.eventName != null) {
        paramVarArgs.g(3, this.eventName);
      }
      if (this.description != null) {
        paramVarArgs.g(4, this.description);
      }
      paramVarArgs.bS(5, this.EOg);
      if (this.coverImgUrl != null) {
        paramVarArgs.g(6, this.coverImgUrl);
      }
      paramVarArgs.bv(7, this.ZHH);
      paramVarArgs.bS(8, this.feedCount);
      paramVarArgs.bS(9, this.BbV);
      if (this.WDP != null) {
        paramVarArgs.g(10, this.WDP);
      }
      if (this.ZHI != null) {
        paramVarArgs.g(11, this.ZHI);
      }
      if (this.ZHJ != null) {
        paramVarArgs.g(12, this.ZHJ);
      }
      paramVarArgs.bS(13, this.ZHK);
      paramVarArgs.bv(14, this.endTime);
      paramVarArgs.bS(15, this.ZHL);
      if (this.hVf != null)
      {
        paramVarArgs.qD(16, this.hVf.computeSize());
        this.hVf.writeFields(paramVarArgs);
      }
      if (this.ZHM != null)
      {
        paramVarArgs.qD(17, this.ZHM.computeSize());
        this.ZHM.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(18, this.FOi);
      if (this.ZHN != null)
      {
        paramVarArgs.qD(19, this.ZHN.computeSize());
        this.ZHN.writeFields(paramVarArgs);
      }
      if (this.ZHO != null)
      {
        paramVarArgs.qD(20, this.ZHO.computeSize());
        this.ZHO.writeFields(paramVarArgs);
      }
      if (this.ZHP != null)
      {
        paramVarArgs.qD(21, this.ZHP.computeSize());
        this.ZHP.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(22, this.ZHQ);
      paramVarArgs.e(23, 8, this.ZHR);
      if (this.ZHS != null) {
        paramVarArgs.g(24, this.ZHS);
      }
      if (this.ZHT != null)
      {
        paramVarArgs.qD(25, this.ZHT.computeSize());
        this.ZHT.writeFields(paramVarArgs);
      }
      if (this.ZHU != null)
      {
        paramVarArgs.qD(26, this.ZHU.computeSize());
        this.ZHU.writeFields(paramVarArgs);
      }
      if (this.ZHV != null)
      {
        paramVarArgs.qD(27, this.ZHV.computeSize());
        this.ZHV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(260161);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.ocD) + 0;
      paramInt = i;
      if (this.contact != null) {
        paramInt = i + i.a.a.a.qC(2, this.contact.computeSize());
      }
      i = paramInt;
      if (this.eventName != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.eventName);
      }
      paramInt = i;
      if (this.description != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.description);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.EOg);
      paramInt = i;
      if (this.coverImgUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.coverImgUrl);
      }
      i = paramInt + i.a.a.b.b.a.q(7, this.ZHH) + i.a.a.b.b.a.cJ(8, this.feedCount) + i.a.a.b.b.a.cJ(9, this.BbV);
      paramInt = i;
      if (this.WDP != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.WDP);
      }
      i = paramInt;
      if (this.ZHI != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.ZHI);
      }
      paramInt = i;
      if (this.ZHJ != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.ZHJ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.ZHK) + i.a.a.b.b.a.q(14, this.endTime) + i.a.a.b.b.a.cJ(15, this.ZHL);
      paramInt = i;
      if (this.hVf != null) {
        paramInt = i + i.a.a.a.qC(16, this.hVf.computeSize());
      }
      i = paramInt;
      if (this.ZHM != null) {
        i = paramInt + i.a.a.a.qC(17, this.ZHM.computeSize());
      }
      i += i.a.a.b.b.a.q(18, this.FOi);
      paramInt = i;
      if (this.ZHN != null) {
        paramInt = i + i.a.a.a.qC(19, this.ZHN.computeSize());
      }
      i = paramInt;
      if (this.ZHO != null) {
        i = paramInt + i.a.a.a.qC(20, this.ZHO.computeSize());
      }
      paramInt = i;
      if (this.ZHP != null) {
        paramInt = i + i.a.a.a.qC(21, this.ZHP.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(22, this.ZHQ) + i.a.a.a.c(23, 8, this.ZHR);
      paramInt = i;
      if (this.ZHS != null) {
        paramInt = i + i.a.a.b.b.a.h(24, this.ZHS);
      }
      i = paramInt;
      if (this.ZHT != null) {
        i = paramInt + i.a.a.a.qC(25, this.ZHT.computeSize());
      }
      paramInt = i;
      if (this.ZHU != null) {
        paramInt = i + i.a.a.a.qC(26, this.ZHU.computeSize());
      }
      i = paramInt;
      if (this.ZHV != null) {
        i = paramInt + i.a.a.a.qC(27, this.ZHV.computeSize());
      }
      AppMethodBeat.o(260161);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZHR.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260161);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      awt localawt = (awt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(260161);
        return -1;
      case 1: 
        localawt.ocD = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(260161);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderContact();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderContact)localObject2).parseFrom((byte[])localObject1);
          }
          localawt.contact = ((FinderContact)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260161);
        return 0;
      case 3: 
        localawt.eventName = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(260161);
        return 0;
      case 4: 
        localawt.description = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(260161);
        return 0;
      case 5: 
        localawt.EOg = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(260161);
        return 0;
      case 6: 
        localawt.coverImgUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(260161);
        return 0;
      case 7: 
        localawt.ZHH = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(260161);
        return 0;
      case 8: 
        localawt.feedCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(260161);
        return 0;
      case 9: 
        localawt.BbV = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(260161);
        return 0;
      case 10: 
        localawt.WDP = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(260161);
        return 0;
      case 11: 
        localawt.ZHI = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(260161);
        return 0;
      case 12: 
        localawt.ZHJ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(260161);
        return 0;
      case 13: 
        localawt.ZHK = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(260161);
        return 0;
      case 14: 
        localawt.endTime = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(260161);
        return 0;
      case 15: 
        localawt.ZHL = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(260161);
        return 0;
      case 16: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderJumpInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderJumpInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localawt.hVf = ((FinderJumpInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260161);
        return 0;
      case 17: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bxu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bxu)localObject2).parseFrom((byte[])localObject1);
          }
          localawt.ZHM = ((bxu)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260161);
        return 0;
      case 18: 
        localawt.FOi = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(260161);
        return 0;
      case 19: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new awx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((awx)localObject2).parseFrom((byte[])localObject1);
          }
          localawt.ZHN = ((awx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260161);
        return 0;
      case 20: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderJumpInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderJumpInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localawt.ZHO = ((FinderJumpInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260161);
        return 0;
      case 21: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aws();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aws)localObject2).parseFrom((byte[])localObject1);
          }
          localawt.ZHP = ((aws)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260161);
        return 0;
      case 22: 
        localawt.ZHQ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(260161);
        return 0;
      case 23: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderJumpInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderJumpInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localawt.ZHR.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260161);
        return 0;
      case 24: 
        localawt.ZHS = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(260161);
        return 0;
      case 25: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fmi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fmi)localObject2).parseFrom((byte[])localObject1);
          }
          localawt.ZHT = ((fmi)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260161);
        return 0;
      case 26: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new awu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((awu)localObject2).parseFrom((byte[])localObject1);
          }
          localawt.ZHU = ((awu)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260161);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new fxs();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((fxs)localObject2).parseFrom((byte[])localObject1);
        }
        localawt.ZHV = ((fxs)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(260161);
      return 0;
    }
    AppMethodBeat.o(260161);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awt
 * JD-Core Version:    0.7.0.1
 */