package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class fvb
  extends com.tencent.mm.bx.a
{
  public int YCa;
  public dhy YGk;
  public String YNO;
  public eto YOE;
  public String ZhO;
  public String ZhP;
  public String ZhS;
  public int ZhZ;
  public String Zia;
  public String Zib;
  public String Zic;
  public ffs aaMs;
  public String aaVS;
  public String aaVT;
  public String aaWy;
  public int aang;
  public String abSR;
  public String abSS;
  public int abST;
  public int abSU;
  public int abSV;
  public String abSW;
  public int abSX;
  public etl abSY;
  public int abSZ;
  public long abTA;
  public String abTa;
  public String abTb;
  public String abTc;
  public String abTd;
  public String abTe;
  public ebj abTf;
  public String abTg;
  public int abTh;
  public long abTi;
  public String abTj;
  public fjk abTk;
  public long abTl;
  public int abTm;
  public String abTn;
  public int abTo;
  public int abTp;
  public int abTq;
  public gnp abTr;
  public String abTs;
  public long abTt;
  public int abTu;
  public ess abTv;
  public int abTw;
  public duh abTx;
  public int abTy;
  public long abTz;
  public int abnq;
  public int abzt;
  public String kaq;
  public String pSp;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258833);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "SnsUserInfo", this.aaMs, false);
      com.tencent.mm.bk.a.a(localJSONObject, "MyBrandList", this.pSp, false);
      com.tencent.mm.bk.a.a(localJSONObject, "MsgPushSound", this.abSR, false);
      com.tencent.mm.bk.a.a(localJSONObject, "VoipPushSound", this.abSS, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BigChatRoomSize", Integer.valueOf(this.abST), false);
      com.tencent.mm.bk.a.a(localJSONObject, "BigChatRoomQuota", Integer.valueOf(this.abSU), false);
      com.tencent.mm.bk.a.a(localJSONObject, "BigChatRoomInvite", Integer.valueOf(this.abSV), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SafeMobile", this.abSW, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BigHeadImgUrl", this.ZhO, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SmallHeadImgUrl", this.ZhP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "MainAcctType", Integer.valueOf(this.abSX), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ExtXml", this.abSY, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SafeDeviceList", this.YOE, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SafeDevice", Integer.valueOf(this.YCa), false);
      com.tencent.mm.bk.a.a(localJSONObject, "GrayscaleFlag", Integer.valueOf(this.abSZ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "GoogleContactName", this.YNO, false);
      com.tencent.mm.bk.a.a(localJSONObject, "IDCardNum", this.aaVS, false);
      com.tencent.mm.bk.a.a(localJSONObject, "RealName", this.aaVT, false);
      com.tencent.mm.bk.a.a(localJSONObject, "RegCountry", this.abTa, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BBPPID", this.abTb, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BBPIN", this.abTc, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BBMNickName", this.abTd, false);
      com.tencent.mm.bk.a.a(localJSONObject, "LinkedinContactItem", this.YGk, false);
      com.tencent.mm.bk.a.a(localJSONObject, "KFInfo", this.abTe, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PatternLockInfo", this.abTf, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SecurityDeviceId", this.abTg, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PayWalletType", Integer.valueOf(this.abTh), false);
      com.tencent.mm.bk.a.a(localJSONObject, "WeiDianInfo", this.kaq, false);
      com.tencent.mm.bk.a.a(localJSONObject, "WalletRegion", Integer.valueOf(this.aang), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ExtStatus", Long.valueOf(this.abTi), false);
      com.tencent.mm.bk.a.a(localJSONObject, "F2FPushSound", this.abTj, false);
      com.tencent.mm.bk.a.a(localJSONObject, "UserStatus", Integer.valueOf(this.abnq), false);
      com.tencent.mm.bk.a.a(localJSONObject, "StoryUserInfo", this.abTk, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PaySetting", Long.valueOf(this.abTl), false);
      com.tencent.mm.bk.a.a(localJSONObject, "PayBindMobileTransfer", Integer.valueOf(this.abTm), false);
      com.tencent.mm.bk.a.a(localJSONObject, "TextStatus", this.ZhS, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BindXMail", this.abTn, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PatSuffix", this.aaWy, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PatSuffixVersion", Integer.valueOf(this.abzt), false);
      com.tencent.mm.bk.a.a(localJSONObject, "TeenagerModeFinderSetting", Integer.valueOf(this.abTo), false);
      com.tencent.mm.bk.a.a(localJSONObject, "TeenagerModeBizAcctSetting", Integer.valueOf(this.abTp), false);
      com.tencent.mm.bk.a.a(localJSONObject, "TeenagerModeMiniProgramSetting", Integer.valueOf(this.abTq), false);
      com.tencent.mm.bk.a.a(localJSONObject, "XAgreementInfo", this.abTr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "TextStatusExpireTime", Integer.valueOf(this.ZhZ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "TextStatusID", this.Zia, false);
      com.tencent.mm.bk.a.a(localJSONObject, "TextStatusExtInfo", this.Zic, false);
      com.tencent.mm.bk.a.a(localJSONObject, "TextStatusTopicID", this.Zib, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Salt", this.abTs, false);
      com.tencent.mm.bk.a.a(localJSONObject, "FinderSetting", Long.valueOf(this.abTt), false);
      com.tencent.mm.bk.a.a(localJSONObject, "IMESetting", Integer.valueOf(this.abTu), false);
      com.tencent.mm.bk.a.a(localJSONObject, "RingBackSetting", this.abTv, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SMCryptoFlag", Integer.valueOf(this.abTw), false);
      com.tencent.mm.bk.a.a(localJSONObject, "GlobalRingBackSetting", this.abTx, false);
      com.tencent.mm.bk.a.a(localJSONObject, "NewcomeMsgDefaultVoiceNumber", Integer.valueOf(this.abTy), false);
      com.tencent.mm.bk.a.a(localJSONObject, "DiscoveryPageCtrlFlag", Long.valueOf(this.abTz), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ExtStatus2", Long.valueOf(this.abTA), false);
      label717:
      AppMethodBeat.o(258833);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label717;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134260);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaMs == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsUserInfo");
        AppMethodBeat.o(134260);
        throw paramVarArgs;
      }
      if (this.aaMs != null)
      {
        paramVarArgs.qD(1, this.aaMs.computeSize());
        this.aaMs.writeFields(paramVarArgs);
      }
      if (this.pSp != null) {
        paramVarArgs.g(2, this.pSp);
      }
      if (this.abSR != null) {
        paramVarArgs.g(3, this.abSR);
      }
      if (this.abSS != null) {
        paramVarArgs.g(4, this.abSS);
      }
      paramVarArgs.bS(5, this.abST);
      paramVarArgs.bS(6, this.abSU);
      paramVarArgs.bS(7, this.abSV);
      if (this.abSW != null) {
        paramVarArgs.g(8, this.abSW);
      }
      if (this.ZhO != null) {
        paramVarArgs.g(9, this.ZhO);
      }
      if (this.ZhP != null) {
        paramVarArgs.g(10, this.ZhP);
      }
      paramVarArgs.bS(11, this.abSX);
      if (this.abSY != null)
      {
        paramVarArgs.qD(12, this.abSY.computeSize());
        this.abSY.writeFields(paramVarArgs);
      }
      if (this.YOE != null)
      {
        paramVarArgs.qD(13, this.YOE.computeSize());
        this.YOE.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(14, this.YCa);
      paramVarArgs.bS(15, this.abSZ);
      if (this.YNO != null) {
        paramVarArgs.g(16, this.YNO);
      }
      if (this.aaVS != null) {
        paramVarArgs.g(17, this.aaVS);
      }
      if (this.aaVT != null) {
        paramVarArgs.g(18, this.aaVT);
      }
      if (this.abTa != null) {
        paramVarArgs.g(19, this.abTa);
      }
      if (this.abTb != null) {
        paramVarArgs.g(20, this.abTb);
      }
      if (this.abTc != null) {
        paramVarArgs.g(21, this.abTc);
      }
      if (this.abTd != null) {
        paramVarArgs.g(22, this.abTd);
      }
      if (this.YGk != null)
      {
        paramVarArgs.qD(23, this.YGk.computeSize());
        this.YGk.writeFields(paramVarArgs);
      }
      if (this.abTe != null) {
        paramVarArgs.g(24, this.abTe);
      }
      if (this.abTf != null)
      {
        paramVarArgs.qD(25, this.abTf.computeSize());
        this.abTf.writeFields(paramVarArgs);
      }
      if (this.abTg != null) {
        paramVarArgs.g(26, this.abTg);
      }
      paramVarArgs.bS(27, this.abTh);
      if (this.kaq != null) {
        paramVarArgs.g(28, this.kaq);
      }
      paramVarArgs.bS(29, this.aang);
      paramVarArgs.bv(30, this.abTi);
      if (this.abTj != null) {
        paramVarArgs.g(31, this.abTj);
      }
      paramVarArgs.bS(32, this.abnq);
      if (this.abTk != null)
      {
        paramVarArgs.qD(33, this.abTk.computeSize());
        this.abTk.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(34, this.abTl);
      paramVarArgs.bS(35, this.abTm);
      if (this.ZhS != null) {
        paramVarArgs.g(36, this.ZhS);
      }
      if (this.abTn != null) {
        paramVarArgs.g(37, this.abTn);
      }
      if (this.aaWy != null) {
        paramVarArgs.g(38, this.aaWy);
      }
      paramVarArgs.bS(39, this.abzt);
      paramVarArgs.bS(44, this.abTo);
      paramVarArgs.bS(45, this.abTp);
      paramVarArgs.bS(46, this.abTq);
      if (this.abTr != null)
      {
        paramVarArgs.qD(47, this.abTr.computeSize());
        this.abTr.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(48, this.ZhZ);
      if (this.Zia != null) {
        paramVarArgs.g(49, this.Zia);
      }
      if (this.Zic != null) {
        paramVarArgs.g(51, this.Zic);
      }
      if (this.Zib != null) {
        paramVarArgs.g(50, this.Zib);
      }
      if (this.abTs != null) {
        paramVarArgs.g(52, this.abTs);
      }
      paramVarArgs.bv(53, this.abTt);
      paramVarArgs.bS(54, this.abTu);
      if (this.abTv != null)
      {
        paramVarArgs.qD(55, this.abTv.computeSize());
        this.abTv.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(56, this.abTw);
      if (this.abTx != null)
      {
        paramVarArgs.qD(57, this.abTx.computeSize());
        this.abTx.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(58, this.abTy);
      paramVarArgs.bv(59, this.abTz);
      paramVarArgs.bv(60, this.abTA);
      AppMethodBeat.o(134260);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaMs == null) {
        break label4010;
      }
    }
    label4010:
    for (int i = i.a.a.a.qC(1, this.aaMs.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pSp != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.pSp);
      }
      i = paramInt;
      if (this.abSR != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abSR);
      }
      paramInt = i;
      if (this.abSS != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abSS);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.abST) + i.a.a.b.b.a.cJ(6, this.abSU) + i.a.a.b.b.a.cJ(7, this.abSV);
      paramInt = i;
      if (this.abSW != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abSW);
      }
      i = paramInt;
      if (this.ZhO != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ZhO);
      }
      paramInt = i;
      if (this.ZhP != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.ZhP);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.abSX);
      paramInt = i;
      if (this.abSY != null) {
        paramInt = i + i.a.a.a.qC(12, this.abSY.computeSize());
      }
      i = paramInt;
      if (this.YOE != null) {
        i = paramInt + i.a.a.a.qC(13, this.YOE.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(14, this.YCa) + i.a.a.b.b.a.cJ(15, this.abSZ);
      paramInt = i;
      if (this.YNO != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.YNO);
      }
      i = paramInt;
      if (this.aaVS != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.aaVS);
      }
      paramInt = i;
      if (this.aaVT != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.aaVT);
      }
      i = paramInt;
      if (this.abTa != null) {
        i = paramInt + i.a.a.b.b.a.h(19, this.abTa);
      }
      paramInt = i;
      if (this.abTb != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.abTb);
      }
      i = paramInt;
      if (this.abTc != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.abTc);
      }
      paramInt = i;
      if (this.abTd != null) {
        paramInt = i + i.a.a.b.b.a.h(22, this.abTd);
      }
      i = paramInt;
      if (this.YGk != null) {
        i = paramInt + i.a.a.a.qC(23, this.YGk.computeSize());
      }
      paramInt = i;
      if (this.abTe != null) {
        paramInt = i + i.a.a.b.b.a.h(24, this.abTe);
      }
      i = paramInt;
      if (this.abTf != null) {
        i = paramInt + i.a.a.a.qC(25, this.abTf.computeSize());
      }
      paramInt = i;
      if (this.abTg != null) {
        paramInt = i + i.a.a.b.b.a.h(26, this.abTg);
      }
      i = paramInt + i.a.a.b.b.a.cJ(27, this.abTh);
      paramInt = i;
      if (this.kaq != null) {
        paramInt = i + i.a.a.b.b.a.h(28, this.kaq);
      }
      i = paramInt + i.a.a.b.b.a.cJ(29, this.aang) + i.a.a.b.b.a.q(30, this.abTi);
      paramInt = i;
      if (this.abTj != null) {
        paramInt = i + i.a.a.b.b.a.h(31, this.abTj);
      }
      i = paramInt + i.a.a.b.b.a.cJ(32, this.abnq);
      paramInt = i;
      if (this.abTk != null) {
        paramInt = i + i.a.a.a.qC(33, this.abTk.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.q(34, this.abTl) + i.a.a.b.b.a.cJ(35, this.abTm);
      paramInt = i;
      if (this.ZhS != null) {
        paramInt = i + i.a.a.b.b.a.h(36, this.ZhS);
      }
      i = paramInt;
      if (this.abTn != null) {
        i = paramInt + i.a.a.b.b.a.h(37, this.abTn);
      }
      paramInt = i;
      if (this.aaWy != null) {
        paramInt = i + i.a.a.b.b.a.h(38, this.aaWy);
      }
      i = paramInt + i.a.a.b.b.a.cJ(39, this.abzt) + i.a.a.b.b.a.cJ(44, this.abTo) + i.a.a.b.b.a.cJ(45, this.abTp) + i.a.a.b.b.a.cJ(46, this.abTq);
      paramInt = i;
      if (this.abTr != null) {
        paramInt = i + i.a.a.a.qC(47, this.abTr.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(48, this.ZhZ);
      paramInt = i;
      if (this.Zia != null) {
        paramInt = i + i.a.a.b.b.a.h(49, this.Zia);
      }
      i = paramInt;
      if (this.Zic != null) {
        i = paramInt + i.a.a.b.b.a.h(51, this.Zic);
      }
      paramInt = i;
      if (this.Zib != null) {
        paramInt = i + i.a.a.b.b.a.h(50, this.Zib);
      }
      i = paramInt;
      if (this.abTs != null) {
        i = paramInt + i.a.a.b.b.a.h(52, this.abTs);
      }
      i = i + i.a.a.b.b.a.q(53, this.abTt) + i.a.a.b.b.a.cJ(54, this.abTu);
      paramInt = i;
      if (this.abTv != null) {
        paramInt = i + i.a.a.a.qC(55, this.abTv.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(56, this.abTw);
      paramInt = i;
      if (this.abTx != null) {
        paramInt = i + i.a.a.a.qC(57, this.abTx.computeSize());
      }
      i = i.a.a.b.b.a.cJ(58, this.abTy);
      int j = i.a.a.b.b.a.q(59, this.abTz);
      int k = i.a.a.b.b.a.q(60, this.abTA);
      AppMethodBeat.o(134260);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aaMs == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsUserInfo");
          AppMethodBeat.o(134260);
          throw paramVarArgs;
        }
        AppMethodBeat.o(134260);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fvb localfvb = (fvb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 40: 
        case 41: 
        case 42: 
        case 43: 
        default: 
          AppMethodBeat.o(134260);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ffs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ffs)localObject2).parseFrom((byte[])localObject1);
            }
            localfvb.aaMs = ((ffs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 2: 
          localfvb.pSp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 3: 
          localfvb.abSR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 4: 
          localfvb.abSS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 5: 
          localfvb.abST = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134260);
          return 0;
        case 6: 
          localfvb.abSU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134260);
          return 0;
        case 7: 
          localfvb.abSV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134260);
          return 0;
        case 8: 
          localfvb.abSW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 9: 
          localfvb.ZhO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 10: 
          localfvb.ZhP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 11: 
          localfvb.abSX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134260);
          return 0;
        case 12: 
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
            localfvb.abSY = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eto();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eto)localObject2).parseFrom((byte[])localObject1);
            }
            localfvb.YOE = ((eto)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 14: 
          localfvb.YCa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134260);
          return 0;
        case 15: 
          localfvb.abSZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134260);
          return 0;
        case 16: 
          localfvb.YNO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 17: 
          localfvb.aaVS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 18: 
          localfvb.aaVT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 19: 
          localfvb.abTa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 20: 
          localfvb.abTb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 21: 
          localfvb.abTc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 22: 
          localfvb.abTd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 23: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhy)localObject2).parseFrom((byte[])localObject1);
            }
            localfvb.YGk = ((dhy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 24: 
          localfvb.abTe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 25: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ebj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ebj)localObject2).parseFrom((byte[])localObject1);
            }
            localfvb.abTf = ((ebj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 26: 
          localfvb.abTg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 27: 
          localfvb.abTh = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134260);
          return 0;
        case 28: 
          localfvb.kaq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 29: 
          localfvb.aang = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134260);
          return 0;
        case 30: 
          localfvb.abTi = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(134260);
          return 0;
        case 31: 
          localfvb.abTj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 32: 
          localfvb.abnq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134260);
          return 0;
        case 33: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fjk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fjk)localObject2).parseFrom((byte[])localObject1);
            }
            localfvb.abTk = ((fjk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 34: 
          localfvb.abTl = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(134260);
          return 0;
        case 35: 
          localfvb.abTm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134260);
          return 0;
        case 36: 
          localfvb.ZhS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 37: 
          localfvb.abTn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 38: 
          localfvb.aaWy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 39: 
          localfvb.abzt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134260);
          return 0;
        case 44: 
          localfvb.abTo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134260);
          return 0;
        case 45: 
          localfvb.abTp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134260);
          return 0;
        case 46: 
          localfvb.abTq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134260);
          return 0;
        case 47: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gnp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gnp)localObject2).parseFrom((byte[])localObject1);
            }
            localfvb.abTr = ((gnp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 48: 
          localfvb.ZhZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134260);
          return 0;
        case 49: 
          localfvb.Zia = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 51: 
          localfvb.Zic = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 50: 
          localfvb.Zib = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 52: 
          localfvb.abTs = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 53: 
          localfvb.abTt = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(134260);
          return 0;
        case 54: 
          localfvb.abTu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134260);
          return 0;
        case 55: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ess();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ess)localObject2).parseFrom((byte[])localObject1);
            }
            localfvb.abTv = ((ess)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 56: 
          localfvb.abTw = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134260);
          return 0;
        case 57: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new duh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((duh)localObject2).parseFrom((byte[])localObject1);
            }
            localfvb.abTx = ((duh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 58: 
          localfvb.abTy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134260);
          return 0;
        case 59: 
          localfvb.abTz = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(134260);
          return 0;
        }
        localfvb.abTA = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(134260);
        return 0;
      }
      AppMethodBeat.o(134260);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fvb
 * JD-Core Version:    0.7.0.1
 */