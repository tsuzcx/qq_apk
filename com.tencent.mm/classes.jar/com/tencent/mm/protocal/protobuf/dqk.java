package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqk
  extends com.tencent.mm.bx.a
{
  public int YBU;
  public int YBX;
  public etl ZqL;
  public long ZxM;
  public String ZxN;
  public etl aaIz;
  public int aaMm;
  public String aaMn;
  public String aaMo;
  public String aaMp;
  public int aaMq;
  public int aaVN;
  public int aaWB;
  public int aaWI;
  public com.tencent.mm.bx.b aaWJ;
  public int aaWL;
  public etl aaWM;
  public etl aaWN;
  public int aaWO;
  public int aaWP;
  public int aaWQ;
  public int aaWR;
  public int aaWS;
  public cxo aaWT;
  public int aaWU;
  public String aaWV;
  public akq aaWm;
  public int pSf;
  public String pSg;
  public String pSh;
  public String pSi;
  public int pSj;
  public String pSk;
  public int pSl;
  public int pSm;
  public String pSn;
  public String pSo;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43112);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZqL == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.aaIz == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.aaWM == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BindEmail");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.aaWN == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BindMobile");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.aaWL);
      if (this.ZqL != null)
      {
        paramVarArgs.qD(2, this.ZqL.computeSize());
        this.ZqL.writeFields(paramVarArgs);
      }
      if (this.aaIz != null)
      {
        paramVarArgs.qD(3, this.aaIz.computeSize());
        this.aaIz.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.YBU);
      if (this.aaWM != null)
      {
        paramVarArgs.qD(5, this.aaWM.computeSize());
        this.aaWM.writeFields(paramVarArgs);
      }
      if (this.aaWN != null)
      {
        paramVarArgs.qD(6, this.aaWN.computeSize());
        this.aaWN.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.vhk);
      paramVarArgs.bS(8, this.aaWI);
      if (this.aaWJ != null) {
        paramVarArgs.d(9, this.aaWJ);
      }
      paramVarArgs.bS(10, this.pSf);
      if (this.pSg != null) {
        paramVarArgs.g(11, this.pSg);
      }
      if (this.pSh != null) {
        paramVarArgs.g(12, this.pSh);
      }
      if (this.pSi != null) {
        paramVarArgs.g(13, this.pSi);
      }
      paramVarArgs.bS(14, this.pSj);
      if (this.aaWm != null)
      {
        paramVarArgs.qD(15, this.aaWm.computeSize());
        this.aaWm.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(16, this.YBX);
      paramVarArgs.bS(17, this.aaMm);
      if (this.aaMn != null) {
        paramVarArgs.g(18, this.aaMn);
      }
      paramVarArgs.bS(19, this.aaWO);
      paramVarArgs.bS(20, this.aaWP);
      paramVarArgs.bS(21, this.aaVN);
      paramVarArgs.bS(22, this.aaWQ);
      paramVarArgs.bS(23, this.aaWR);
      if (this.aaMo != null) {
        paramVarArgs.g(24, this.aaMo);
      }
      paramVarArgs.bS(25, this.aaWS);
      if (this.aaWT != null)
      {
        paramVarArgs.qD(26, this.aaWT.computeSize());
        this.aaWT.writeFields(paramVarArgs);
      }
      if (this.pSk != null) {
        paramVarArgs.g(27, this.pSk);
      }
      if (this.aaMp != null) {
        paramVarArgs.g(28, this.aaMp);
      }
      paramVarArgs.bS(29, this.aaMq);
      paramVarArgs.bS(30, this.aaWU);
      paramVarArgs.bv(31, this.ZxM);
      if (this.ZxN != null) {
        paramVarArgs.g(32, this.ZxN);
      }
      paramVarArgs.bS(33, this.pSm);
      paramVarArgs.bS(34, this.pSl);
      if (this.pSn != null) {
        paramVarArgs.g(35, this.pSn);
      }
      paramVarArgs.bS(36, this.aaWB);
      if (this.aaWV != null) {
        paramVarArgs.g(37, this.aaWV);
      }
      if (this.pSo != null) {
        paramVarArgs.g(38, this.pSo);
      }
      AppMethodBeat.o(43112);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.aaWL) + 0;
      paramInt = i;
      if (this.ZqL != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZqL.computeSize());
      }
      i = paramInt;
      if (this.aaIz != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaIz.computeSize());
      }
      i += i.a.a.b.b.a.cJ(4, this.YBU);
      paramInt = i;
      if (this.aaWM != null) {
        paramInt = i + i.a.a.a.qC(5, this.aaWM.computeSize());
      }
      i = paramInt;
      if (this.aaWN != null) {
        i = paramInt + i.a.a.a.qC(6, this.aaWN.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(7, this.vhk) + i.a.a.b.b.a.cJ(8, this.aaWI);
      paramInt = i;
      if (this.aaWJ != null) {
        paramInt = i + i.a.a.b.b.a.c(9, this.aaWJ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.pSf);
      paramInt = i;
      if (this.pSg != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.pSg);
      }
      i = paramInt;
      if (this.pSh != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.pSh);
      }
      paramInt = i;
      if (this.pSi != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.pSi);
      }
      i = paramInt + i.a.a.b.b.a.cJ(14, this.pSj);
      paramInt = i;
      if (this.aaWm != null) {
        paramInt = i + i.a.a.a.qC(15, this.aaWm.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(16, this.YBX) + i.a.a.b.b.a.cJ(17, this.aaMm);
      paramInt = i;
      if (this.aaMn != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.aaMn);
      }
      i = paramInt + i.a.a.b.b.a.cJ(19, this.aaWO) + i.a.a.b.b.a.cJ(20, this.aaWP) + i.a.a.b.b.a.cJ(21, this.aaVN) + i.a.a.b.b.a.cJ(22, this.aaWQ) + i.a.a.b.b.a.cJ(23, this.aaWR);
      paramInt = i;
      if (this.aaMo != null) {
        paramInt = i + i.a.a.b.b.a.h(24, this.aaMo);
      }
      i = paramInt + i.a.a.b.b.a.cJ(25, this.aaWS);
      paramInt = i;
      if (this.aaWT != null) {
        paramInt = i + i.a.a.a.qC(26, this.aaWT.computeSize());
      }
      i = paramInt;
      if (this.pSk != null) {
        i = paramInt + i.a.a.b.b.a.h(27, this.pSk);
      }
      paramInt = i;
      if (this.aaMp != null) {
        paramInt = i + i.a.a.b.b.a.h(28, this.aaMp);
      }
      i = paramInt + i.a.a.b.b.a.cJ(29, this.aaMq) + i.a.a.b.b.a.cJ(30, this.aaWU) + i.a.a.b.b.a.q(31, this.ZxM);
      paramInt = i;
      if (this.ZxN != null) {
        paramInt = i + i.a.a.b.b.a.h(32, this.ZxN);
      }
      i = paramInt + i.a.a.b.b.a.cJ(33, this.pSm) + i.a.a.b.b.a.cJ(34, this.pSl);
      paramInt = i;
      if (this.pSn != null) {
        paramInt = i + i.a.a.b.b.a.h(35, this.pSn);
      }
      i = paramInt + i.a.a.b.b.a.cJ(36, this.aaWB);
      paramInt = i;
      if (this.aaWV != null) {
        paramInt = i + i.a.a.b.b.a.h(37, this.aaWV);
      }
      i = paramInt;
      if (this.pSo != null) {
        i = paramInt + i.a.a.b.b.a.h(38, this.pSo);
      }
      AppMethodBeat.o(43112);
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
      if (this.ZqL == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.aaIz == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.aaWM == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BindEmail");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.aaWN == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BindMobile");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43112);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      dqk localdqk = (dqk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43112);
        return -1;
      case 1: 
        localdqk.aaWL = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43112);
        return 0;
      case 2: 
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
          localdqk.ZqL = ((etl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 3: 
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
          localdqk.aaIz = ((etl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 4: 
        localdqk.YBU = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43112);
        return 0;
      case 5: 
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
          localdqk.aaWM = ((etl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 6: 
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
          localdqk.aaWN = ((etl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 7: 
        localdqk.vhk = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43112);
        return 0;
      case 8: 
        localdqk.aaWI = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43112);
        return 0;
      case 9: 
        localdqk.aaWJ = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(43112);
        return 0;
      case 10: 
        localdqk.pSf = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43112);
        return 0;
      case 11: 
        localdqk.pSg = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 12: 
        localdqk.pSh = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 13: 
        localdqk.pSi = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 14: 
        localdqk.pSj = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43112);
        return 0;
      case 15: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new akq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((akq)localObject2).parseFrom((byte[])localObject1);
          }
          localdqk.aaWm = ((akq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 16: 
        localdqk.YBX = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43112);
        return 0;
      case 17: 
        localdqk.aaMm = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43112);
        return 0;
      case 18: 
        localdqk.aaMn = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 19: 
        localdqk.aaWO = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43112);
        return 0;
      case 20: 
        localdqk.aaWP = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43112);
        return 0;
      case 21: 
        localdqk.aaVN = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43112);
        return 0;
      case 22: 
        localdqk.aaWQ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43112);
        return 0;
      case 23: 
        localdqk.aaWR = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43112);
        return 0;
      case 24: 
        localdqk.aaMo = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 25: 
        localdqk.aaWS = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43112);
        return 0;
      case 26: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cxo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cxo)localObject2).parseFrom((byte[])localObject1);
          }
          localdqk.aaWT = ((cxo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 27: 
        localdqk.pSk = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 28: 
        localdqk.aaMp = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 29: 
        localdqk.aaMq = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43112);
        return 0;
      case 30: 
        localdqk.aaWU = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43112);
        return 0;
      case 31: 
        localdqk.ZxM = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(43112);
        return 0;
      case 32: 
        localdqk.ZxN = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 33: 
        localdqk.pSm = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43112);
        return 0;
      case 34: 
        localdqk.pSl = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43112);
        return 0;
      case 35: 
        localdqk.pSn = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 36: 
        localdqk.aaWB = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43112);
        return 0;
      case 37: 
        localdqk.aaWV = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(43112);
        return 0;
      }
      localdqk.pSo = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(43112);
      return 0;
    }
    AppMethodBeat.o(43112);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqk
 * JD-Core Version:    0.7.0.1
 */