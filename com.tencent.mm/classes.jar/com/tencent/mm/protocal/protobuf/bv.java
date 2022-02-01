package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bv
  extends dop
{
  public String Dsg;
  public String DvI;
  public String KFD;
  public String KFE;
  public String KFF;
  public String KFG;
  public String KFH;
  public String KFI;
  public int KFK;
  public String KFL;
  public long KFM;
  public ck KFN;
  public int KFO;
  public int KFP;
  public String KFQ;
  public int KFR;
  public b KFS;
  public b KFT;
  public long KFU;
  public int KFV;
  public int KFW;
  public int KFX;
  public String bssid;
  public String imei;
  public int scene;
  public int source;
  public String ssid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125693);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DvI != null) {
        paramVarArgs.e(2, this.DvI);
      }
      paramVarArgs.aM(3, this.KFK);
      if (this.KFL != null) {
        paramVarArgs.e(4, this.KFL);
      }
      paramVarArgs.aM(5, this.scene);
      if (this.ssid != null) {
        paramVarArgs.e(6, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.e(7, this.bssid);
      }
      paramVarArgs.bb(8, this.KFM);
      if (this.KFN != null)
      {
        paramVarArgs.ni(9, this.KFN.computeSize());
        this.KFN.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(10, this.KFO);
      paramVarArgs.aM(11, this.KFP);
      paramVarArgs.aM(12, this.source);
      if (this.KFQ != null) {
        paramVarArgs.e(13, this.KFQ);
      }
      paramVarArgs.aM(14, this.KFR);
      if (this.KFS != null) {
        paramVarArgs.c(15, this.KFS);
      }
      if (this.KFT != null) {
        paramVarArgs.c(16, this.KFT);
      }
      paramVarArgs.bb(17, this.KFU);
      if (this.Dsg != null) {
        paramVarArgs.e(18, this.Dsg);
      }
      if (this.KFH != null) {
        paramVarArgs.e(19, this.KFH);
      }
      if (this.KFI != null) {
        paramVarArgs.e(20, this.KFI);
      }
      paramVarArgs.aM(21, this.KFV);
      paramVarArgs.aM(22, this.KFW);
      paramVarArgs.aM(23, this.KFX);
      if (this.imei != null) {
        paramVarArgs.e(24, this.imei);
      }
      if (this.KFD != null) {
        paramVarArgs.e(25, this.KFD);
      }
      if (this.KFE != null) {
        paramVarArgs.e(26, this.KFE);
      }
      if (this.KFF != null) {
        paramVarArgs.e(27, this.KFF);
      }
      if (this.KFG != null) {
        paramVarArgs.e(28, this.KFG);
      }
      AppMethodBeat.o(125693);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1886;
      }
    }
    label1886:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DvI != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.DvI);
      }
      i += g.a.a.b.b.a.bu(3, this.KFK);
      paramInt = i;
      if (this.KFL != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KFL);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.scene);
      paramInt = i;
      if (this.ssid != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.ssid);
      }
      i = paramInt;
      if (this.bssid != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.bssid);
      }
      i += g.a.a.b.b.a.r(8, this.KFM);
      paramInt = i;
      if (this.KFN != null) {
        paramInt = i + g.a.a.a.nh(9, this.KFN.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.KFO) + g.a.a.b.b.a.bu(11, this.KFP) + g.a.a.b.b.a.bu(12, this.source);
      paramInt = i;
      if (this.KFQ != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.KFQ);
      }
      i = paramInt + g.a.a.b.b.a.bu(14, this.KFR);
      paramInt = i;
      if (this.KFS != null) {
        paramInt = i + g.a.a.b.b.a.b(15, this.KFS);
      }
      i = paramInt;
      if (this.KFT != null) {
        i = paramInt + g.a.a.b.b.a.b(16, this.KFT);
      }
      i += g.a.a.b.b.a.r(17, this.KFU);
      paramInt = i;
      if (this.Dsg != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.Dsg);
      }
      i = paramInt;
      if (this.KFH != null) {
        i = paramInt + g.a.a.b.b.a.f(19, this.KFH);
      }
      paramInt = i;
      if (this.KFI != null) {
        paramInt = i + g.a.a.b.b.a.f(20, this.KFI);
      }
      i = paramInt + g.a.a.b.b.a.bu(21, this.KFV) + g.a.a.b.b.a.bu(22, this.KFW) + g.a.a.b.b.a.bu(23, this.KFX);
      paramInt = i;
      if (this.imei != null) {
        paramInt = i + g.a.a.b.b.a.f(24, this.imei);
      }
      i = paramInt;
      if (this.KFD != null) {
        i = paramInt + g.a.a.b.b.a.f(25, this.KFD);
      }
      paramInt = i;
      if (this.KFE != null) {
        paramInt = i + g.a.a.b.b.a.f(26, this.KFE);
      }
      i = paramInt;
      if (this.KFF != null) {
        i = paramInt + g.a.a.b.b.a.f(27, this.KFF);
      }
      paramInt = i;
      if (this.KFG != null) {
        paramInt = i + g.a.a.b.b.a.f(28, this.KFG);
      }
      AppMethodBeat.o(125693);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125693);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bv localbv = (bv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125693);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbv.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125693);
          return 0;
        case 2: 
          localbv.DvI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 3: 
          localbv.KFK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125693);
          return 0;
        case 4: 
          localbv.KFL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 5: 
          localbv.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125693);
          return 0;
        case 6: 
          localbv.ssid = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 7: 
          localbv.bssid = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 8: 
          localbv.KFM = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125693);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ck();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ck)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbv.KFN = ((ck)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125693);
          return 0;
        case 10: 
          localbv.KFO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125693);
          return 0;
        case 11: 
          localbv.KFP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125693);
          return 0;
        case 12: 
          localbv.source = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125693);
          return 0;
        case 13: 
          localbv.KFQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 14: 
          localbv.KFR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125693);
          return 0;
        case 15: 
          localbv.KFS = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(125693);
          return 0;
        case 16: 
          localbv.KFT = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(125693);
          return 0;
        case 17: 
          localbv.KFU = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125693);
          return 0;
        case 18: 
          localbv.Dsg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 19: 
          localbv.KFH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 20: 
          localbv.KFI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 21: 
          localbv.KFV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125693);
          return 0;
        case 22: 
          localbv.KFW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125693);
          return 0;
        case 23: 
          localbv.KFX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125693);
          return 0;
        case 24: 
          localbv.imei = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 25: 
          localbv.KFD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 26: 
          localbv.KFE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 27: 
          localbv.KFF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125693);
          return 0;
        }
        localbv.KFG = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125693);
        return 0;
      }
      AppMethodBeat.o(125693);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bv
 * JD-Core Version:    0.7.0.1
 */