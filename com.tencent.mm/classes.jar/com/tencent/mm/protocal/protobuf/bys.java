package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bys
  extends esc
{
  public int EsV;
  public int FPD;
  public int FSv;
  public String Vpy;
  public FinderContact ZEd;
  public LinkedList<bcz> ZMv;
  public int ZMw;
  public long ZMx;
  public int aahA;
  public efp aahB;
  public int aahC;
  public String aahD;
  public String aahE;
  public ax aahF;
  public int aahG;
  public String aahH;
  public fat aahI;
  public byq aahJ;
  public ei aahK;
  public int aahL;
  public efq aahM;
  public boh aahN;
  public cbw aahO;
  public btf aahP;
  public String aahr;
  public String aahs;
  public String aaht;
  public int aahu;
  public int aahv;
  public aho aahw;
  public int aahx;
  public int aahy;
  public bzd aahz;
  public int actionType;
  public int foreign_user_flag;
  public bkl live_notice_list_info;
  public int logout_lock;
  public String logout_url;
  public bqt verifyInfo;
  public bzd wxaShopInfo;
  
  public bys()
  {
    AppMethodBeat.i(257940);
    this.ZMv = new LinkedList();
    AppMethodBeat.o(257940);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169074);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.actionType);
      if (this.verifyInfo != null)
      {
        paramVarArgs.qD(3, this.verifyInfo.computeSize());
        this.verifyInfo.writeFields(paramVarArgs);
      }
      if (this.ZEd != null)
      {
        paramVarArgs.qD(4, this.ZEd.computeSize());
        this.ZEd.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.EsV);
      if (this.aahr != null) {
        paramVarArgs.g(6, this.aahr);
      }
      if (this.aahs != null) {
        paramVarArgs.g(7, this.aahs);
      }
      if (this.aaht != null) {
        paramVarArgs.g(8, this.aaht);
      }
      paramVarArgs.bS(9, this.aahu);
      paramVarArgs.bS(10, this.FSv);
      paramVarArgs.bS(11, this.aahv);
      paramVarArgs.bS(12, this.FPD);
      if (this.aahw != null)
      {
        paramVarArgs.qD(13, this.aahw.computeSize());
        this.aahw.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(14, this.aahx);
      paramVarArgs.bS(15, this.aahy);
      if (this.Vpy != null) {
        paramVarArgs.g(16, this.Vpy);
      }
      if (this.aahz != null)
      {
        paramVarArgs.qD(17, this.aahz.computeSize());
        this.aahz.writeFields(paramVarArgs);
      }
      if (this.wxaShopInfo != null)
      {
        paramVarArgs.qD(18, this.wxaShopInfo.computeSize());
        this.wxaShopInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(19, this.aahA);
      if (this.aahB != null)
      {
        paramVarArgs.qD(21, this.aahB.computeSize());
        this.aahB.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(22, this.aahC);
      if (this.aahD != null) {
        paramVarArgs.g(23, this.aahD);
      }
      paramVarArgs.bS(24, this.foreign_user_flag);
      if (this.aahE != null) {
        paramVarArgs.g(25, this.aahE);
      }
      if (this.aahF != null)
      {
        paramVarArgs.qD(26, this.aahF.computeSize());
        this.aahF.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(27, this.logout_lock);
      if (this.logout_url != null) {
        paramVarArgs.g(28, this.logout_url);
      }
      paramVarArgs.e(29, 8, this.ZMv);
      paramVarArgs.bS(30, this.ZMw);
      paramVarArgs.bv(31, this.ZMx);
      paramVarArgs.bS(32, this.aahG);
      if (this.aahH != null) {
        paramVarArgs.g(33, this.aahH);
      }
      if (this.aahI != null)
      {
        paramVarArgs.qD(35, this.aahI.computeSize());
        this.aahI.writeFields(paramVarArgs);
      }
      if (this.aahJ != null)
      {
        paramVarArgs.qD(36, this.aahJ.computeSize());
        this.aahJ.writeFields(paramVarArgs);
      }
      if (this.aahK != null)
      {
        paramVarArgs.qD(37, this.aahK.computeSize());
        this.aahK.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(38, this.aahL);
      if (this.aahM != null)
      {
        paramVarArgs.qD(39, this.aahM.computeSize());
        this.aahM.writeFields(paramVarArgs);
      }
      if (this.aahN != null)
      {
        paramVarArgs.qD(40, this.aahN.computeSize());
        this.aahN.writeFields(paramVarArgs);
      }
      if (this.aahO != null)
      {
        paramVarArgs.qD(41, this.aahO.computeSize());
        this.aahO.writeFields(paramVarArgs);
      }
      if (this.aahP != null)
      {
        paramVarArgs.qD(42, this.aahP.computeSize());
        this.aahP.writeFields(paramVarArgs);
      }
      if (this.live_notice_list_info != null)
      {
        paramVarArgs.qD(43, this.live_notice_list_info.computeSize());
        this.live_notice_list_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169074);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label3636;
      }
    }
    label3636:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.actionType);
      paramInt = i;
      if (this.verifyInfo != null) {
        paramInt = i + i.a.a.a.qC(3, this.verifyInfo.computeSize());
      }
      i = paramInt;
      if (this.ZEd != null) {
        i = paramInt + i.a.a.a.qC(4, this.ZEd.computeSize());
      }
      i += i.a.a.b.b.a.cJ(5, this.EsV);
      paramInt = i;
      if (this.aahr != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aahr);
      }
      i = paramInt;
      if (this.aahs != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aahs);
      }
      paramInt = i;
      if (this.aaht != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aaht);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.aahu) + i.a.a.b.b.a.cJ(10, this.FSv) + i.a.a.b.b.a.cJ(11, this.aahv) + i.a.a.b.b.a.cJ(12, this.FPD);
      paramInt = i;
      if (this.aahw != null) {
        paramInt = i + i.a.a.a.qC(13, this.aahw.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(14, this.aahx) + i.a.a.b.b.a.cJ(15, this.aahy);
      paramInt = i;
      if (this.Vpy != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.Vpy);
      }
      i = paramInt;
      if (this.aahz != null) {
        i = paramInt + i.a.a.a.qC(17, this.aahz.computeSize());
      }
      paramInt = i;
      if (this.wxaShopInfo != null) {
        paramInt = i + i.a.a.a.qC(18, this.wxaShopInfo.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(19, this.aahA);
      paramInt = i;
      if (this.aahB != null) {
        paramInt = i + i.a.a.a.qC(21, this.aahB.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(22, this.aahC);
      paramInt = i;
      if (this.aahD != null) {
        paramInt = i + i.a.a.b.b.a.h(23, this.aahD);
      }
      i = paramInt + i.a.a.b.b.a.cJ(24, this.foreign_user_flag);
      paramInt = i;
      if (this.aahE != null) {
        paramInt = i + i.a.a.b.b.a.h(25, this.aahE);
      }
      i = paramInt;
      if (this.aahF != null) {
        i = paramInt + i.a.a.a.qC(26, this.aahF.computeSize());
      }
      i += i.a.a.b.b.a.cJ(27, this.logout_lock);
      paramInt = i;
      if (this.logout_url != null) {
        paramInt = i + i.a.a.b.b.a.h(28, this.logout_url);
      }
      i = paramInt + i.a.a.a.c(29, 8, this.ZMv) + i.a.a.b.b.a.cJ(30, this.ZMw) + i.a.a.b.b.a.q(31, this.ZMx) + i.a.a.b.b.a.cJ(32, this.aahG);
      paramInt = i;
      if (this.aahH != null) {
        paramInt = i + i.a.a.b.b.a.h(33, this.aahH);
      }
      i = paramInt;
      if (this.aahI != null) {
        i = paramInt + i.a.a.a.qC(35, this.aahI.computeSize());
      }
      paramInt = i;
      if (this.aahJ != null) {
        paramInt = i + i.a.a.a.qC(36, this.aahJ.computeSize());
      }
      i = paramInt;
      if (this.aahK != null) {
        i = paramInt + i.a.a.a.qC(37, this.aahK.computeSize());
      }
      i += i.a.a.b.b.a.cJ(38, this.aahL);
      paramInt = i;
      if (this.aahM != null) {
        paramInt = i + i.a.a.a.qC(39, this.aahM.computeSize());
      }
      i = paramInt;
      if (this.aahN != null) {
        i = paramInt + i.a.a.a.qC(40, this.aahN.computeSize());
      }
      paramInt = i;
      if (this.aahO != null) {
        paramInt = i + i.a.a.a.qC(41, this.aahO.computeSize());
      }
      i = paramInt;
      if (this.aahP != null) {
        i = paramInt + i.a.a.a.qC(42, this.aahP.computeSize());
      }
      paramInt = i;
      if (this.live_notice_list_info != null) {
        paramInt = i + i.a.a.a.qC(43, this.live_notice_list_info.computeSize());
      }
      AppMethodBeat.o(169074);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZMv.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169074);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bys localbys = (bys)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 20: 
        case 34: 
        default: 
          AppMethodBeat.o(169074);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localbys.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 2: 
          localbys.actionType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169074);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bqt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bqt)localObject2).parseFrom((byte[])localObject1);
            }
            localbys.verifyInfo = ((bqt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 4: 
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
            localbys.ZEd = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 5: 
          localbys.EsV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169074);
          return 0;
        case 6: 
          localbys.aahr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 7: 
          localbys.aahs = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 8: 
          localbys.aaht = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 9: 
          localbys.aahu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169074);
          return 0;
        case 10: 
          localbys.FSv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169074);
          return 0;
        case 11: 
          localbys.aahv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169074);
          return 0;
        case 12: 
          localbys.FPD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169074);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aho();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aho)localObject2).parseFrom((byte[])localObject1);
            }
            localbys.aahw = ((aho)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 14: 
          localbys.aahx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169074);
          return 0;
        case 15: 
          localbys.aahy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169074);
          return 0;
        case 16: 
          localbys.Vpy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 17: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bzd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bzd)localObject2).parseFrom((byte[])localObject1);
            }
            localbys.aahz = ((bzd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bzd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bzd)localObject2).parseFrom((byte[])localObject1);
            }
            localbys.wxaShopInfo = ((bzd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 19: 
          localbys.aahA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169074);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new efp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((efp)localObject2).parseFrom((byte[])localObject1);
            }
            localbys.aahB = ((efp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 22: 
          localbys.aahC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169074);
          return 0;
        case 23: 
          localbys.aahD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 24: 
          localbys.foreign_user_flag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169074);
          return 0;
        case 25: 
          localbys.aahE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 26: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ax();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ax)localObject2).parseFrom((byte[])localObject1);
            }
            localbys.aahF = ((ax)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 27: 
          localbys.logout_lock = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169074);
          return 0;
        case 28: 
          localbys.logout_url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 29: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bcz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bcz)localObject2).parseFrom((byte[])localObject1);
            }
            localbys.ZMv.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 30: 
          localbys.ZMw = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169074);
          return 0;
        case 31: 
          localbys.ZMx = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169074);
          return 0;
        case 32: 
          localbys.aahG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169074);
          return 0;
        case 33: 
          localbys.aahH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 35: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fat();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fat)localObject2).parseFrom((byte[])localObject1);
            }
            localbys.aahI = ((fat)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 36: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new byq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((byq)localObject2).parseFrom((byte[])localObject1);
            }
            localbys.aahJ = ((byq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 37: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ei();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ei)localObject2).parseFrom((byte[])localObject1);
            }
            localbys.aahK = ((ei)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 38: 
          localbys.aahL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169074);
          return 0;
        case 39: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new efq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((efq)localObject2).parseFrom((byte[])localObject1);
            }
            localbys.aahM = ((efq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 40: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new boh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((boh)localObject2).parseFrom((byte[])localObject1);
            }
            localbys.aahN = ((boh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 41: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cbw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cbw)localObject2).parseFrom((byte[])localObject1);
            }
            localbys.aahO = ((cbw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 42: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new btf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((btf)localObject2).parseFrom((byte[])localObject1);
            }
            localbys.aahP = ((btf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bkl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bkl)localObject2).parseFrom((byte[])localObject1);
          }
          localbys.live_notice_list_info = ((bkl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169074);
        return 0;
      }
      AppMethodBeat.o(169074);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bys
 * JD-Core Version:    0.7.0.1
 */