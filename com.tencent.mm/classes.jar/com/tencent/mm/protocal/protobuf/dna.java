package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class dna
  extends com.tencent.mm.bx.a
{
  public LinkedList<etl> GroupUser;
  public String Njp;
  public int Privated;
  public int aaTG;
  public int aaTH;
  public LinkedList<djp> aaTI;
  public LinkedList<ffw> aaTJ;
  public int aaTK;
  public long aaTL;
  public int aaTM;
  public LinkedList<Long> aaTN;
  public int aaTO;
  public int aaTP;
  public String aaTQ;
  public int aaTR;
  public feu aaTS;
  public LinkedList<ffa> aaTT;
  public String aaTU;
  public long aaTV;
  public String aaTW;
  public boolean aaTX;
  public fdr aaTY;
  public dyq aaTZ;
  public LinkedList<etl> aaUa;
  public String iag;
  public int ihz;
  public String nUv;
  public int nrQ;
  public String sessionId;
  public String token;
  
  public dna()
  {
    AppMethodBeat.i(125744);
    this.aaTI = new LinkedList();
    this.aaTJ = new LinkedList();
    this.aaTN = new LinkedList();
    this.GroupUser = new LinkedList();
    this.aaTT = new LinkedList();
    this.aaUa = new LinkedList();
    AppMethodBeat.o(125744);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125745);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaTG);
      paramVarArgs.bS(2, this.aaTH);
      paramVarArgs.bS(3, this.Privated);
      if (this.nUv != null) {
        paramVarArgs.g(4, this.nUv);
      }
      paramVarArgs.e(5, 8, this.aaTI);
      paramVarArgs.e(6, 8, this.aaTJ);
      paramVarArgs.bS(7, this.aaTK);
      paramVarArgs.bS(8, this.nrQ);
      paramVarArgs.bv(9, this.aaTL);
      paramVarArgs.bS(10, this.aaTM);
      paramVarArgs.e(11, 3, this.aaTN);
      paramVarArgs.bS(12, this.aaTO);
      paramVarArgs.bS(13, this.aaTP);
      if (this.token != null) {
        paramVarArgs.g(14, this.token);
      }
      if (this.aaTQ != null) {
        paramVarArgs.g(15, this.aaTQ);
      }
      paramVarArgs.bS(16, this.aaTR);
      paramVarArgs.e(17, 8, this.GroupUser);
      if (this.aaTS != null)
      {
        paramVarArgs.qD(18, this.aaTS.computeSize());
        this.aaTS.writeFields(paramVarArgs);
      }
      if (this.iag != null) {
        paramVarArgs.g(19, this.iag);
      }
      paramVarArgs.e(20, 8, this.aaTT);
      if (this.sessionId != null) {
        paramVarArgs.g(21, this.sessionId);
      }
      if (this.aaTU != null) {
        paramVarArgs.g(22, this.aaTU);
      }
      if (this.Njp != null) {
        paramVarArgs.g(23, this.Njp);
      }
      paramVarArgs.bS(24, this.ihz);
      paramVarArgs.bv(25, this.aaTV);
      if (this.aaTW != null) {
        paramVarArgs.g(26, this.aaTW);
      }
      paramVarArgs.di(27, this.aaTX);
      if (this.aaTY != null)
      {
        paramVarArgs.qD(28, this.aaTY.computeSize());
        this.aaTY.writeFields(paramVarArgs);
      }
      if (this.aaTZ != null)
      {
        paramVarArgs.qD(29, this.aaTZ.computeSize());
        this.aaTZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(30, 8, this.aaUa);
      AppMethodBeat.o(125745);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.aaTG) + 0 + i.a.a.b.b.a.cJ(2, this.aaTH) + i.a.a.b.b.a.cJ(3, this.Privated);
      paramInt = i;
      if (this.nUv != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.nUv);
      }
      i = paramInt + i.a.a.a.c(5, 8, this.aaTI) + i.a.a.a.c(6, 8, this.aaTJ) + i.a.a.b.b.a.cJ(7, this.aaTK) + i.a.a.b.b.a.cJ(8, this.nrQ) + i.a.a.b.b.a.q(9, this.aaTL) + i.a.a.b.b.a.cJ(10, this.aaTM) + i.a.a.a.c(11, 3, this.aaTN) + i.a.a.b.b.a.cJ(12, this.aaTO) + i.a.a.b.b.a.cJ(13, this.aaTP);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.token);
      }
      i = paramInt;
      if (this.aaTQ != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.aaTQ);
      }
      i = i + i.a.a.b.b.a.cJ(16, this.aaTR) + i.a.a.a.c(17, 8, this.GroupUser);
      paramInt = i;
      if (this.aaTS != null) {
        paramInt = i + i.a.a.a.qC(18, this.aaTS.computeSize());
      }
      i = paramInt;
      if (this.iag != null) {
        i = paramInt + i.a.a.b.b.a.h(19, this.iag);
      }
      i += i.a.a.a.c(20, 8, this.aaTT);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.sessionId);
      }
      i = paramInt;
      if (this.aaTU != null) {
        i = paramInt + i.a.a.b.b.a.h(22, this.aaTU);
      }
      paramInt = i;
      if (this.Njp != null) {
        paramInt = i + i.a.a.b.b.a.h(23, this.Njp);
      }
      i = paramInt + i.a.a.b.b.a.cJ(24, this.ihz) + i.a.a.b.b.a.q(25, this.aaTV);
      paramInt = i;
      if (this.aaTW != null) {
        paramInt = i + i.a.a.b.b.a.h(26, this.aaTW);
      }
      i = paramInt + (i.a.a.b.b.a.ko(27) + 1);
      paramInt = i;
      if (this.aaTY != null) {
        paramInt = i + i.a.a.a.qC(28, this.aaTY.computeSize());
      }
      i = paramInt;
      if (this.aaTZ != null) {
        i = paramInt + i.a.a.a.qC(29, this.aaTZ.computeSize());
      }
      paramInt = i.a.a.a.c(30, 8, this.aaUa);
      AppMethodBeat.o(125745);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaTI.clear();
      this.aaTJ.clear();
      this.aaTN.clear();
      this.GroupUser.clear();
      this.aaTT.clear();
      this.aaUa.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(125745);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      dna localdna = (dna)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125745);
        return -1;
      case 1: 
        localdna.aaTG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125745);
        return 0;
      case 2: 
        localdna.aaTH = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125745);
        return 0;
      case 3: 
        localdna.Privated = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125745);
        return 0;
      case 4: 
        localdna.nUv = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new djp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((djp)localObject2).parseFrom((byte[])localObject1);
          }
          localdna.aaTI.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ffw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ffw)localObject2).parseFrom((byte[])localObject1);
          }
          localdna.aaTJ.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 7: 
        localdna.aaTK = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125745);
        return 0;
      case 8: 
        localdna.nrQ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125745);
        return 0;
      case 9: 
        localdna.aaTL = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(125745);
        return 0;
      case 10: 
        localdna.aaTM = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125745);
        return 0;
      case 11: 
        localdna.aaTN.add(Long.valueOf(((i.a.a.a.a)localObject1).ajGk.aaw()));
        AppMethodBeat.o(125745);
        return 0;
      case 12: 
        localdna.aaTO = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125745);
        return 0;
      case 13: 
        localdna.aaTP = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125745);
        return 0;
      case 14: 
        localdna.token = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 15: 
        localdna.aaTQ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 16: 
        localdna.aaTR = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125745);
        return 0;
      case 17: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etl)localObject2).dh((byte[])localObject1);
          }
          localdna.GroupUser.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 18: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new feu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((feu)localObject2).parseFrom((byte[])localObject1);
          }
          localdna.aaTS = ((feu)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 19: 
        localdna.iag = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 20: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ffa();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ffa)localObject2).parseFrom((byte[])localObject1);
          }
          localdna.aaTT.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 21: 
        localdna.sessionId = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 22: 
        localdna.aaTU = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 23: 
        localdna.Njp = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 24: 
        localdna.ihz = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125745);
        return 0;
      case 25: 
        localdna.aaTV = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(125745);
        return 0;
      case 26: 
        localdna.aaTW = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 27: 
        localdna.aaTX = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(125745);
        return 0;
      case 28: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fdr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fdr)localObject2).parseFrom((byte[])localObject1);
          }
          localdna.aaTY = ((fdr)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 29: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dyq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dyq)localObject2).parseFrom((byte[])localObject1);
          }
          localdna.aaTZ = ((dyq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new etl();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((etl)localObject2).dh((byte[])localObject1);
        }
        localdna.aaUa.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(125745);
      return 0;
    }
    AppMethodBeat.o(125745);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dna
 * JD-Core Version:    0.7.0.1
 */