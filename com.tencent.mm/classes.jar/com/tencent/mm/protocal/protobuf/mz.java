package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class mz
  extends esc
{
  public String Username;
  public int YCa;
  public fck YJt;
  public String YJu;
  public int YJy;
  public sc YOA;
  public dts YOB;
  public String YOC;
  public int YOD;
  public eto YOE;
  public String YOF;
  public String YOG;
  public String YOH;
  public String YOI;
  public int YOJ;
  public int YOm;
  public String YOn;
  public dtr YOr;
  public String YOu;
  public String YOw;
  public int YOx;
  public String YOy;
  public dal YOz;
  public String hFb;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258780);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseResponse", this.BaseResponse, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ticket", this.hFb, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SmsNo", this.YOw, false);
      com.tencent.mm.bk.a.a(localJSONObject, "NeedSetPwd", Integer.valueOf(this.YOx), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Pwd", this.YOy, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Username", this.Username, false);
      com.tencent.mm.bk.a.a(localJSONObject, "NewHostList", this.YOz, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BuiltinIPList", this.YOA, false);
      com.tencent.mm.bk.a.a(localJSONObject, "NetworkControl", this.YOB, false);
      com.tencent.mm.bk.a.a(localJSONObject, "AuthTicket", this.YJu, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SafeDevice", Integer.valueOf(this.YCa), false);
      com.tencent.mm.bk.a.a(localJSONObject, "CC", this.YOC, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ObsoleteItem1", Integer.valueOf(this.YOD), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SafeDeviceList", this.YOE, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PureMobile", this.YOF, false);
      com.tencent.mm.bk.a.a(localJSONObject, "FormatedMobile", this.YOG, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ShowStyle", this.YJt, false);
      com.tencent.mm.bk.a.a(localJSONObject, "MmtlsControlBitFlag", Integer.valueOf(this.YJy), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SmsUpCode", this.YOH, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SmsUpMobile", this.YOI, false);
      com.tencent.mm.bk.a.a(localJSONObject, "MobileCheckType", Integer.valueOf(this.YOm), false);
      com.tencent.mm.bk.a.a(localJSONObject, "RegSessionId", this.YOn, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Restart", Integer.valueOf(this.YOJ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "networkCheckExtInfo", this.YOr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "VerifyTicket", this.YOu, false);
      label306:
      AppMethodBeat.o(258780);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label306;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134244);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(134244);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.hFb != null) {
        paramVarArgs.g(2, this.hFb);
      }
      if (this.YOw != null) {
        paramVarArgs.g(3, this.YOw);
      }
      paramVarArgs.bS(4, this.YOx);
      if (this.YOy != null) {
        paramVarArgs.g(5, this.YOy);
      }
      if (this.Username != null) {
        paramVarArgs.g(6, this.Username);
      }
      if (this.YOz != null)
      {
        paramVarArgs.qD(7, this.YOz.computeSize());
        this.YOz.writeFields(paramVarArgs);
      }
      if (this.YOA != null)
      {
        paramVarArgs.qD(8, this.YOA.computeSize());
        this.YOA.writeFields(paramVarArgs);
      }
      if (this.YOB != null)
      {
        paramVarArgs.qD(9, this.YOB.computeSize());
        this.YOB.writeFields(paramVarArgs);
      }
      if (this.YJu != null) {
        paramVarArgs.g(10, this.YJu);
      }
      paramVarArgs.bS(11, this.YCa);
      if (this.YOC != null) {
        paramVarArgs.g(12, this.YOC);
      }
      paramVarArgs.bS(13, this.YOD);
      if (this.YOE != null)
      {
        paramVarArgs.qD(14, this.YOE.computeSize());
        this.YOE.writeFields(paramVarArgs);
      }
      if (this.YOF != null) {
        paramVarArgs.g(15, this.YOF);
      }
      if (this.YOG != null) {
        paramVarArgs.g(16, this.YOG);
      }
      if (this.YJt != null)
      {
        paramVarArgs.qD(17, this.YJt.computeSize());
        this.YJt.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(18, this.YJy);
      if (this.YOH != null) {
        paramVarArgs.g(19, this.YOH);
      }
      if (this.YOI != null) {
        paramVarArgs.g(20, this.YOI);
      }
      paramVarArgs.bS(21, this.YOm);
      if (this.YOn != null) {
        paramVarArgs.g(22, this.YOn);
      }
      paramVarArgs.bS(23, this.YOJ);
      if (this.YOr != null)
      {
        paramVarArgs.qD(24, this.YOr.computeSize());
        this.YOr.writeFields(paramVarArgs);
      }
      if (this.YOu != null) {
        paramVarArgs.g(26, this.YOu);
      }
      AppMethodBeat.o(134244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2152;
      }
    }
    label2152:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hFb != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hFb);
      }
      i = paramInt;
      if (this.YOw != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YOw);
      }
      i += i.a.a.b.b.a.cJ(4, this.YOx);
      paramInt = i;
      if (this.YOy != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YOy);
      }
      i = paramInt;
      if (this.Username != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.Username);
      }
      paramInt = i;
      if (this.YOz != null) {
        paramInt = i + i.a.a.a.qC(7, this.YOz.computeSize());
      }
      i = paramInt;
      if (this.YOA != null) {
        i = paramInt + i.a.a.a.qC(8, this.YOA.computeSize());
      }
      paramInt = i;
      if (this.YOB != null) {
        paramInt = i + i.a.a.a.qC(9, this.YOB.computeSize());
      }
      i = paramInt;
      if (this.YJu != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.YJu);
      }
      i += i.a.a.b.b.a.cJ(11, this.YCa);
      paramInt = i;
      if (this.YOC != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.YOC);
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.YOD);
      paramInt = i;
      if (this.YOE != null) {
        paramInt = i + i.a.a.a.qC(14, this.YOE.computeSize());
      }
      i = paramInt;
      if (this.YOF != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.YOF);
      }
      paramInt = i;
      if (this.YOG != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.YOG);
      }
      i = paramInt;
      if (this.YJt != null) {
        i = paramInt + i.a.a.a.qC(17, this.YJt.computeSize());
      }
      i += i.a.a.b.b.a.cJ(18, this.YJy);
      paramInt = i;
      if (this.YOH != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.YOH);
      }
      i = paramInt;
      if (this.YOI != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.YOI);
      }
      i += i.a.a.b.b.a.cJ(21, this.YOm);
      paramInt = i;
      if (this.YOn != null) {
        paramInt = i + i.a.a.b.b.a.h(22, this.YOn);
      }
      i = paramInt + i.a.a.b.b.a.cJ(23, this.YOJ);
      paramInt = i;
      if (this.YOr != null) {
        paramInt = i + i.a.a.a.qC(24, this.YOr.computeSize());
      }
      i = paramInt;
      if (this.YOu != null) {
        i = paramInt + i.a.a.b.b.a.h(26, this.YOu);
      }
      AppMethodBeat.o(134244);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(134244);
          throw paramVarArgs;
        }
        AppMethodBeat.o(134244);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        mz localmz = (mz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 25: 
        default: 
          AppMethodBeat.o(134244);
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
            localmz.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 2: 
          localmz.hFb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 3: 
          localmz.YOw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 4: 
          localmz.YOx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134244);
          return 0;
        case 5: 
          localmz.YOy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 6: 
          localmz.Username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dal();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dal)localObject2).parseFrom((byte[])localObject1);
            }
            localmz.YOz = ((dal)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new sc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((sc)localObject2).parseFrom((byte[])localObject1);
            }
            localmz.YOA = ((sc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dts();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dts)localObject2).parseFrom((byte[])localObject1);
            }
            localmz.YOB = ((dts)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 10: 
          localmz.YJu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 11: 
          localmz.YCa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134244);
          return 0;
        case 12: 
          localmz.YOC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 13: 
          localmz.YOD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134244);
          return 0;
        case 14: 
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
            localmz.YOE = ((eto)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 15: 
          localmz.YOF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 16: 
          localmz.YOG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 17: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fck();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fck)localObject2).parseFrom((byte[])localObject1);
            }
            localmz.YJt = ((fck)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 18: 
          localmz.YJy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134244);
          return 0;
        case 19: 
          localmz.YOH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 20: 
          localmz.YOI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 21: 
          localmz.YOm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134244);
          return 0;
        case 22: 
          localmz.YOn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 23: 
          localmz.YOJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(134244);
          return 0;
        case 24: 
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
            localmz.YOr = ((dtr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        }
        localmz.YOu = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(134244);
        return 0;
      }
      AppMethodBeat.o(134244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mz
 * JD-Core Version:    0.7.0.1
 */