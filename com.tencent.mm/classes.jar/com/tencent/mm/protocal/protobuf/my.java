package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class my
  extends erp
{
  public String UserName;
  public String YJX;
  public String YJu;
  public int YKH;
  public gol YKb;
  public String YOc;
  public String YOd;
  public int YOe;
  public String YOf;
  public int YOg;
  public String YOh;
  public String YOi;
  public gol YOj;
  public int YOk;
  public int YOl;
  public int YOm;
  public String YOn;
  public gol YOo;
  public String YOp;
  public fde YOq;
  public dtr YOr;
  public String YOs;
  public String YOt;
  public String YOu;
  public int YOv;
  public String yts;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258791);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseRequest", this.BaseRequest, false);
      com.tencent.mm.bk.a.a(localJSONObject, "UserName", this.UserName, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Mobile", this.YOc, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Opcode", Integer.valueOf(this.YKH), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Verifycode", this.YOd, false);
      com.tencent.mm.bk.a.a(localJSONObject, "DialFlag", Integer.valueOf(this.YOe), false);
      com.tencent.mm.bk.a.a(localJSONObject, "DialLang", this.YOf, false);
      com.tencent.mm.bk.a.a(localJSONObject, "AuthTicket", this.YJu, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ForceReg", Integer.valueOf(this.YOg), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SafeDeviceName", this.YOh, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SafeDeviceType", this.YOi, false);
      com.tencent.mm.bk.a.a(localJSONObject, "RandomEncryKey", this.YOj, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Language", this.yts, false);
      com.tencent.mm.bk.a.a(localJSONObject, "InputMobileRetrys", Integer.valueOf(this.YOk), false);
      com.tencent.mm.bk.a.a(localJSONObject, "AdjustRet", Integer.valueOf(this.YOl), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ClientSeqID", this.YJX, false);
      com.tencent.mm.bk.a.a(localJSONObject, "MobileCheckType", Integer.valueOf(this.YOm), false);
      com.tencent.mm.bk.a.a(localJSONObject, "RegSessionId", this.YOn, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SpamBuffer", this.YOo, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ExtSpamInfo", this.YKb, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ThirdAppAuthTicket", this.YOp, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SmsUpCheckExtInfo", this.YOq, false);
      com.tencent.mm.bk.a.a(localJSONObject, "networkCheckExtInfo", this.YOr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ExtRegUrl", this.YOs, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PolicyAgreementTicket", this.YOt, false);
      com.tencent.mm.bk.a.a(localJSONObject, "VerifyTicket", this.YOu, false);
      com.tencent.mm.bk.a.a(localJSONObject, "IsAffiliated", Integer.valueOf(this.YOv), false);
      label331:
      AppMethodBeat.o(258791);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label331;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134243);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.g(2, this.UserName);
      }
      if (this.YOc != null) {
        paramVarArgs.g(3, this.YOc);
      }
      paramVarArgs.bS(4, this.YKH);
      if (this.YOd != null) {
        paramVarArgs.g(5, this.YOd);
      }
      paramVarArgs.bS(6, this.YOe);
      if (this.YOf != null) {
        paramVarArgs.g(7, this.YOf);
      }
      if (this.YJu != null) {
        paramVarArgs.g(8, this.YJu);
      }
      paramVarArgs.bS(9, this.YOg);
      if (this.YOh != null) {
        paramVarArgs.g(10, this.YOh);
      }
      if (this.YOi != null) {
        paramVarArgs.g(11, this.YOi);
      }
      if (this.YOj != null)
      {
        paramVarArgs.qD(12, this.YOj.computeSize());
        this.YOj.writeFields(paramVarArgs);
      }
      if (this.yts != null) {
        paramVarArgs.g(13, this.yts);
      }
      paramVarArgs.bS(14, this.YOk);
      paramVarArgs.bS(15, this.YOl);
      if (this.YJX != null) {
        paramVarArgs.g(16, this.YJX);
      }
      paramVarArgs.bS(17, this.YOm);
      if (this.YOn != null) {
        paramVarArgs.g(18, this.YOn);
      }
      if (this.YOo != null)
      {
        paramVarArgs.qD(19, this.YOo.computeSize());
        this.YOo.writeFields(paramVarArgs);
      }
      if (this.YKb != null)
      {
        paramVarArgs.qD(20, this.YKb.computeSize());
        this.YKb.writeFields(paramVarArgs);
      }
      if (this.YOp != null) {
        paramVarArgs.g(21, this.YOp);
      }
      if (this.YOq != null)
      {
        paramVarArgs.qD(22, this.YOq.computeSize());
        this.YOq.writeFields(paramVarArgs);
      }
      if (this.YOr != null)
      {
        paramVarArgs.qD(23, this.YOr.computeSize());
        this.YOr.writeFields(paramVarArgs);
      }
      if (this.YOs != null) {
        paramVarArgs.g(24, this.YOs);
      }
      if (this.YOt != null) {
        paramVarArgs.g(25, this.YOt);
      }
      if (this.YOu != null) {
        paramVarArgs.g(26, this.YOu);
      }
      paramVarArgs.bS(27, this.YOv);
      AppMethodBeat.o(134243);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2134;
      }
    }
    label2134:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.UserName);
      }
      i = paramInt;
      if (this.YOc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YOc);
      }
      i += i.a.a.b.b.a.cJ(4, this.YKH);
      paramInt = i;
      if (this.YOd != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YOd);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.YOe);
      paramInt = i;
      if (this.YOf != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YOf);
      }
      i = paramInt;
      if (this.YJu != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.YJu);
      }
      i += i.a.a.b.b.a.cJ(9, this.YOg);
      paramInt = i;
      if (this.YOh != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.YOh);
      }
      i = paramInt;
      if (this.YOi != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.YOi);
      }
      paramInt = i;
      if (this.YOj != null) {
        paramInt = i + i.a.a.a.qC(12, this.YOj.computeSize());
      }
      i = paramInt;
      if (this.yts != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.yts);
      }
      i = i + i.a.a.b.b.a.cJ(14, this.YOk) + i.a.a.b.b.a.cJ(15, this.YOl);
      paramInt = i;
      if (this.YJX != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.YJX);
      }
      i = paramInt + i.a.a.b.b.a.cJ(17, this.YOm);
      paramInt = i;
      if (this.YOn != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.YOn);
      }
      i = paramInt;
      if (this.YOo != null) {
        i = paramInt + i.a.a.a.qC(19, this.YOo.computeSize());
      }
      paramInt = i;
      if (this.YKb != null) {
        paramInt = i + i.a.a.a.qC(20, this.YKb.computeSize());
      }
      i = paramInt;
      if (this.YOp != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.YOp);
      }
      paramInt = i;
      if (this.YOq != null) {
        paramInt = i + i.a.a.a.qC(22, this.YOq.computeSize());
      }
      i = paramInt;
      if (this.YOr != null) {
        i = paramInt + i.a.a.a.qC(23, this.YOr.computeSize());
      }
      paramInt = i;
      if (this.YOs != null) {
        paramInt = i + i.a.a.b.b.a.h(24, this.YOs);
      }
      i = paramInt;
      if (this.YOt != null) {
        i = paramInt + i.a.a.b.b.a.h(25, this.YOt);
      }
      paramInt = i;
      if (this.YOu != null) {
        paramInt = i + i.a.a.b.b.a.h(26, this.YOu);
      }
      i = i.a.a.b.b.a.cJ(27, this.YOv);
      AppMethodBeat.o(134243);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(134243);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        my localmy = (my)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134243);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localmy.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 2: 
          localmy.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 3: 
          localmy.YOc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 4: 
          localmy.YKH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134243);
          return 0;
        case 5: 
          localmy.YOd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 6: 
          localmy.YOe = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134243);
          return 0;
        case 7: 
          localmy.YOf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 8: 
          localmy.YJu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 9: 
          localmy.YOg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134243);
          return 0;
        case 10: 
          localmy.YOh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 11: 
          localmy.YOi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localmy.YOj = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 13: 
          localmy.yts = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 14: 
          localmy.YOk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134243);
          return 0;
        case 15: 
          localmy.YOl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134243);
          return 0;
        case 16: 
          localmy.YJX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 17: 
          localmy.YOm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134243);
          return 0;
        case 18: 
          localmy.YOn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 19: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localmy.YOo = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localmy.YKb = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 21: 
          localmy.YOp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 22: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fde();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fde)localObject2).parseFrom((byte[])localObject1);
            }
            localmy.YOq = ((fde)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 23: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtr)localObject2).parseFrom((byte[])localObject1);
            }
            localmy.YOr = ((dtr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 24: 
          localmy.YOs = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 25: 
          localmy.YOt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 26: 
          localmy.YOu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134243);
          return 0;
        }
        localmy.YOv = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(134243);
        return 0;
      }
      AppMethodBeat.o(134243);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.my
 * JD-Core Version:    0.7.0.1
 */