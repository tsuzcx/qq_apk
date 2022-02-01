package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bip
  extends com.tencent.mm.bx.a
{
  public int DSe;
  public int EOg;
  public int GWs;
  public String Idh;
  public long ZFH;
  public int ZFJ;
  public bjm ZGl;
  public long ZKQ;
  public long ZKR;
  public long ZKy;
  public dix ZOg;
  public bgs ZRO;
  public bjj ZRP;
  public bmi ZRQ;
  public int ZRR;
  public bnn ZRS;
  public int ZRT;
  public int ZRU;
  public String ZRV;
  public long ZRW;
  public int ZRX;
  public int ZRY;
  public bix ZRZ;
  public String ZRm;
  public int ZSa;
  public bnv ZSb;
  public blf ZSc;
  public LinkedList<Integer> ZSd;
  public int ZSe;
  public int ZSf;
  public int ZSg;
  public int ZSh;
  public int ZSi;
  public aui ZSj;
  public LinkedList<String> ZSk;
  public int ZSl;
  public blz ZSm;
  public bgr ZSn;
  public String ZSo;
  public int endTime;
  public long liveId;
  public int liveStatus;
  public int live_flag;
  public String mIE;
  public int replay_status;
  public int startTime;
  
  public bip()
  {
    AppMethodBeat.i(257344);
    this.ZSd = new LinkedList();
    this.ZSk = new LinkedList();
    AppMethodBeat.o(257344);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257353);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.liveId);
      paramVarArgs.bS(2, this.DSe);
      paramVarArgs.bS(3, this.liveStatus);
      if (this.mIE != null) {
        paramVarArgs.g(4, this.mIE);
      }
      paramVarArgs.bS(5, this.startTime);
      paramVarArgs.bS(6, this.GWs);
      paramVarArgs.bS(7, this.endTime);
      if (this.ZRO != null)
      {
        paramVarArgs.qD(8, this.ZRO.computeSize());
        this.ZRO.writeFields(paramVarArgs);
      }
      if (this.ZRP != null)
      {
        paramVarArgs.qD(9, this.ZRP.computeSize());
        this.ZRP.writeFields(paramVarArgs);
      }
      if (this.ZRQ != null)
      {
        paramVarArgs.qD(10, this.ZRQ.computeSize());
        this.ZRQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(11, this.EOg);
      paramVarArgs.bv(12, this.ZKQ);
      paramVarArgs.bS(13, this.ZFJ);
      paramVarArgs.bS(14, this.ZRR);
      paramVarArgs.bv(15, this.ZKy);
      if (this.ZRS != null)
      {
        paramVarArgs.qD(16, this.ZRS.computeSize());
        this.ZRS.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(17, this.ZRT);
      paramVarArgs.bS(18, this.ZRU);
      if (this.ZRV != null) {
        paramVarArgs.g(19, this.ZRV);
      }
      paramVarArgs.bv(20, this.ZRW);
      paramVarArgs.bv(21, this.ZKR);
      paramVarArgs.bS(22, this.ZRX);
      if (this.Idh != null) {
        paramVarArgs.g(23, this.Idh);
      }
      if (this.ZOg != null)
      {
        paramVarArgs.qD(24, this.ZOg.computeSize());
        this.ZOg.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(25, this.ZRY);
      if (this.ZRZ != null)
      {
        paramVarArgs.qD(26, this.ZRZ.computeSize());
        this.ZRZ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(27, this.ZSa);
      if (this.ZSb != null)
      {
        paramVarArgs.qD(28, this.ZSb.computeSize());
        this.ZSb.writeFields(paramVarArgs);
      }
      if (this.ZSc != null)
      {
        paramVarArgs.qD(29, this.ZSc.computeSize());
        this.ZSc.writeFields(paramVarArgs);
      }
      if (this.ZRm != null) {
        paramVarArgs.g(30, this.ZRm);
      }
      if (this.ZGl != null)
      {
        paramVarArgs.qD(31, this.ZGl.computeSize());
        this.ZGl.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(32, this.replay_status);
      paramVarArgs.bv(33, this.ZFH);
      paramVarArgs.e(34, 2, this.ZSd);
      paramVarArgs.bS(35, this.ZSe);
      paramVarArgs.bS(36, this.ZSf);
      paramVarArgs.bS(37, this.ZSg);
      paramVarArgs.bS(38, this.live_flag);
      paramVarArgs.bS(39, this.ZSh);
      paramVarArgs.bS(40, this.ZSi);
      if (this.ZSj != null)
      {
        paramVarArgs.qD(41, this.ZSj.computeSize());
        this.ZSj.writeFields(paramVarArgs);
      }
      paramVarArgs.e(42, 1, this.ZSk);
      paramVarArgs.bS(43, this.ZSl);
      if (this.ZSm != null)
      {
        paramVarArgs.qD(47, this.ZSm.computeSize());
        this.ZSm.writeFields(paramVarArgs);
      }
      if (this.ZSn != null)
      {
        paramVarArgs.qD(48, this.ZSn.computeSize());
        this.ZSn.writeFields(paramVarArgs);
      }
      if (this.ZSo != null) {
        paramVarArgs.g(49, this.ZSo);
      }
      AppMethodBeat.o(257353);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.liveId) + 0 + i.a.a.b.b.a.cJ(2, this.DSe) + i.a.a.b.b.a.cJ(3, this.liveStatus);
      paramInt = i;
      if (this.mIE != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.mIE);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.startTime) + i.a.a.b.b.a.cJ(6, this.GWs) + i.a.a.b.b.a.cJ(7, this.endTime);
      paramInt = i;
      if (this.ZRO != null) {
        paramInt = i + i.a.a.a.qC(8, this.ZRO.computeSize());
      }
      i = paramInt;
      if (this.ZRP != null) {
        i = paramInt + i.a.a.a.qC(9, this.ZRP.computeSize());
      }
      paramInt = i;
      if (this.ZRQ != null) {
        paramInt = i + i.a.a.a.qC(10, this.ZRQ.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.EOg) + i.a.a.b.b.a.q(12, this.ZKQ) + i.a.a.b.b.a.cJ(13, this.ZFJ) + i.a.a.b.b.a.cJ(14, this.ZRR) + i.a.a.b.b.a.q(15, this.ZKy);
      paramInt = i;
      if (this.ZRS != null) {
        paramInt = i + i.a.a.a.qC(16, this.ZRS.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(17, this.ZRT) + i.a.a.b.b.a.cJ(18, this.ZRU);
      paramInt = i;
      if (this.ZRV != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.ZRV);
      }
      i = paramInt + i.a.a.b.b.a.q(20, this.ZRW) + i.a.a.b.b.a.q(21, this.ZKR) + i.a.a.b.b.a.cJ(22, this.ZRX);
      paramInt = i;
      if (this.Idh != null) {
        paramInt = i + i.a.a.b.b.a.h(23, this.Idh);
      }
      i = paramInt;
      if (this.ZOg != null) {
        i = paramInt + i.a.a.a.qC(24, this.ZOg.computeSize());
      }
      i += i.a.a.b.b.a.cJ(25, this.ZRY);
      paramInt = i;
      if (this.ZRZ != null) {
        paramInt = i + i.a.a.a.qC(26, this.ZRZ.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(27, this.ZSa);
      paramInt = i;
      if (this.ZSb != null) {
        paramInt = i + i.a.a.a.qC(28, this.ZSb.computeSize());
      }
      i = paramInt;
      if (this.ZSc != null) {
        i = paramInt + i.a.a.a.qC(29, this.ZSc.computeSize());
      }
      paramInt = i;
      if (this.ZRm != null) {
        paramInt = i + i.a.a.b.b.a.h(30, this.ZRm);
      }
      i = paramInt;
      if (this.ZGl != null) {
        i = paramInt + i.a.a.a.qC(31, this.ZGl.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(32, this.replay_status) + i.a.a.b.b.a.q(33, this.ZFH) + i.a.a.a.c(34, 2, this.ZSd) + i.a.a.b.b.a.cJ(35, this.ZSe) + i.a.a.b.b.a.cJ(36, this.ZSf) + i.a.a.b.b.a.cJ(37, this.ZSg) + i.a.a.b.b.a.cJ(38, this.live_flag) + i.a.a.b.b.a.cJ(39, this.ZSh) + i.a.a.b.b.a.cJ(40, this.ZSi);
      paramInt = i;
      if (this.ZSj != null) {
        paramInt = i + i.a.a.a.qC(41, this.ZSj.computeSize());
      }
      i = paramInt + i.a.a.a.c(42, 1, this.ZSk) + i.a.a.b.b.a.cJ(43, this.ZSl);
      paramInt = i;
      if (this.ZSm != null) {
        paramInt = i + i.a.a.a.qC(47, this.ZSm.computeSize());
      }
      i = paramInt;
      if (this.ZSn != null) {
        i = paramInt + i.a.a.a.qC(48, this.ZSn.computeSize());
      }
      paramInt = i;
      if (this.ZSo != null) {
        paramInt = i + i.a.a.b.b.a.h(49, this.ZSo);
      }
      AppMethodBeat.o(257353);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZSd.clear();
      this.ZSk.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257353);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      bip localbip = (bip)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      case 44: 
      case 45: 
      case 46: 
      default: 
        AppMethodBeat.o(257353);
        return -1;
      case 1: 
        localbip.liveId = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(257353);
        return 0;
      case 2: 
        localbip.DSe = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 3: 
        localbip.liveStatus = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 4: 
        localbip.mIE = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257353);
        return 0;
      case 5: 
        localbip.startTime = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 6: 
        localbip.GWs = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 7: 
        localbip.endTime = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bgs();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bgs)localObject2).parseFrom((byte[])localObject1);
          }
          localbip.ZRO = ((bgs)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257353);
        return 0;
      case 9: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bjj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bjj)localObject2).parseFrom((byte[])localObject1);
          }
          localbip.ZRP = ((bjj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257353);
        return 0;
      case 10: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bmi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bmi)localObject2).parseFrom((byte[])localObject1);
          }
          localbip.ZRQ = ((bmi)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257353);
        return 0;
      case 11: 
        localbip.EOg = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 12: 
        localbip.ZKQ = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(257353);
        return 0;
      case 13: 
        localbip.ZFJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 14: 
        localbip.ZRR = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 15: 
        localbip.ZKy = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(257353);
        return 0;
      case 16: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bnn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bnn)localObject2).parseFrom((byte[])localObject1);
          }
          localbip.ZRS = ((bnn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257353);
        return 0;
      case 17: 
        localbip.ZRT = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 18: 
        localbip.ZRU = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 19: 
        localbip.ZRV = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257353);
        return 0;
      case 20: 
        localbip.ZRW = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(257353);
        return 0;
      case 21: 
        localbip.ZKR = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(257353);
        return 0;
      case 22: 
        localbip.ZRX = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 23: 
        localbip.Idh = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257353);
        return 0;
      case 24: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dix();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dix)localObject2).parseFrom((byte[])localObject1);
          }
          localbip.ZOg = ((dix)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257353);
        return 0;
      case 25: 
        localbip.ZRY = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 26: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bix();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bix)localObject2).parseFrom((byte[])localObject1);
          }
          localbip.ZRZ = ((bix)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257353);
        return 0;
      case 27: 
        localbip.ZSa = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 28: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bnv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bnv)localObject2).parseFrom((byte[])localObject1);
          }
          localbip.ZSb = ((bnv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257353);
        return 0;
      case 29: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new blf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((blf)localObject2).parseFrom((byte[])localObject1);
          }
          localbip.ZSc = ((blf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257353);
        return 0;
      case 30: 
        localbip.ZRm = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257353);
        return 0;
      case 31: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bjm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bjm)localObject2).parseFrom((byte[])localObject1);
          }
          localbip.ZGl = ((bjm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257353);
        return 0;
      case 32: 
        localbip.replay_status = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 33: 
        localbip.ZFH = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(257353);
        return 0;
      case 34: 
        localbip.ZSd.add(Integer.valueOf(((i.a.a.a.a)localObject1).ajGk.aar()));
        AppMethodBeat.o(257353);
        return 0;
      case 35: 
        localbip.ZSe = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 36: 
        localbip.ZSf = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 37: 
        localbip.ZSg = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 38: 
        localbip.live_flag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 39: 
        localbip.ZSh = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 40: 
        localbip.ZSi = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 41: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aui();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aui)localObject2).parseFrom((byte[])localObject1);
          }
          localbip.ZSj = ((aui)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257353);
        return 0;
      case 42: 
        localbip.ZSk.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(257353);
        return 0;
      case 43: 
        localbip.ZSl = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257353);
        return 0;
      case 47: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new blz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((blz)localObject2).parseFrom((byte[])localObject1);
          }
          localbip.ZSm = ((blz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257353);
        return 0;
      case 48: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bgr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bgr)localObject2).parseFrom((byte[])localObject1);
          }
          localbip.ZSn = ((bgr)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257353);
        return 0;
      }
      localbip.ZSo = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(257353);
      return 0;
    }
    AppMethodBeat.o(257353);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bip
 * JD-Core Version:    0.7.0.1
 */