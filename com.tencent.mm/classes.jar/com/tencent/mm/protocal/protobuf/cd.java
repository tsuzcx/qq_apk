package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cd
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
  public String KFL;
  public long KFM;
  public int KFO;
  public String KFQ;
  public int KFR;
  public b KFS;
  public b KFT;
  public int KFW;
  public int KFX;
  public int KGj;
  public cc KGk;
  public cf KGl;
  public int KGm;
  public long KGn;
  public long KGo;
  public float KGp;
  public float KGq;
  public float KGr;
  public int KGs;
  public long KGt;
  public long KGu;
  public int KGv;
  public String bssid;
  public String imei;
  public int scene;
  public int source;
  public String ssid;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125699);
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
      paramVarArgs.aM(3, this.scene);
      paramVarArgs.aM(4, this.type);
      paramVarArgs.aM(5, this.KGj);
      if (this.ssid != null) {
        paramVarArgs.e(6, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.e(7, this.bssid);
      }
      paramVarArgs.bb(8, this.KFM);
      if (this.KGk != null)
      {
        paramVarArgs.ni(9, this.KGk.computeSize());
        this.KGk.writeFields(paramVarArgs);
      }
      if (this.KGl != null)
      {
        paramVarArgs.ni(10, this.KGl.computeSize());
        this.KGl.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(11, this.KFO);
      if (this.KFL != null) {
        paramVarArgs.e(12, this.KFL);
      }
      paramVarArgs.aM(13, this.source);
      if (this.KFQ != null) {
        paramVarArgs.e(14, this.KFQ);
      }
      paramVarArgs.aM(15, this.KGm);
      paramVarArgs.bb(16, this.KGn);
      paramVarArgs.bb(17, this.KGo);
      paramVarArgs.aM(18, this.KFR);
      if (this.KFS != null) {
        paramVarArgs.c(19, this.KFS);
      }
      if (this.KFT != null) {
        paramVarArgs.c(20, this.KFT);
      }
      if (this.Dsg != null) {
        paramVarArgs.e(21, this.Dsg);
      }
      if (this.KFH != null) {
        paramVarArgs.e(22, this.KFH);
      }
      if (this.KFI != null) {
        paramVarArgs.e(23, this.KFI);
      }
      paramVarArgs.E(24, this.KGp);
      paramVarArgs.E(25, this.KGq);
      paramVarArgs.E(26, this.KGr);
      paramVarArgs.aM(27, this.KGs);
      paramVarArgs.bb(28, this.KGt);
      paramVarArgs.bb(29, this.KGu);
      paramVarArgs.aM(30, this.KFW);
      paramVarArgs.aM(31, this.KFX);
      paramVarArgs.aM(32, this.KGv);
      if (this.imei != null) {
        paramVarArgs.e(33, this.imei);
      }
      if (this.KFD != null) {
        paramVarArgs.e(34, this.KFD);
      }
      if (this.KFE != null) {
        paramVarArgs.e(35, this.KFE);
      }
      if (this.KFF != null) {
        paramVarArgs.e(36, this.KFF);
      }
      if (this.KFG != null) {
        paramVarArgs.e(37, this.KFG);
      }
      AppMethodBeat.o(125699);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2395;
      }
    }
    label2395:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DvI != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.DvI);
      }
      i = i + g.a.a.b.b.a.bu(3, this.scene) + g.a.a.b.b.a.bu(4, this.type) + g.a.a.b.b.a.bu(5, this.KGj);
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
      if (this.KGk != null) {
        paramInt = i + g.a.a.a.nh(9, this.KGk.computeSize());
      }
      i = paramInt;
      if (this.KGl != null) {
        i = paramInt + g.a.a.a.nh(10, this.KGl.computeSize());
      }
      i += g.a.a.b.b.a.bu(11, this.KFO);
      paramInt = i;
      if (this.KFL != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.KFL);
      }
      i = paramInt + g.a.a.b.b.a.bu(13, this.source);
      paramInt = i;
      if (this.KFQ != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.KFQ);
      }
      i = paramInt + g.a.a.b.b.a.bu(15, this.KGm) + g.a.a.b.b.a.r(16, this.KGn) + g.a.a.b.b.a.r(17, this.KGo) + g.a.a.b.b.a.bu(18, this.KFR);
      paramInt = i;
      if (this.KFS != null) {
        paramInt = i + g.a.a.b.b.a.b(19, this.KFS);
      }
      i = paramInt;
      if (this.KFT != null) {
        i = paramInt + g.a.a.b.b.a.b(20, this.KFT);
      }
      paramInt = i;
      if (this.Dsg != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.Dsg);
      }
      i = paramInt;
      if (this.KFH != null) {
        i = paramInt + g.a.a.b.b.a.f(22, this.KFH);
      }
      paramInt = i;
      if (this.KFI != null) {
        paramInt = i + g.a.a.b.b.a.f(23, this.KFI);
      }
      i = paramInt + (g.a.a.b.b.a.fS(24) + 4) + (g.a.a.b.b.a.fS(25) + 4) + (g.a.a.b.b.a.fS(26) + 4) + g.a.a.b.b.a.bu(27, this.KGs) + g.a.a.b.b.a.r(28, this.KGt) + g.a.a.b.b.a.r(29, this.KGu) + g.a.a.b.b.a.bu(30, this.KFW) + g.a.a.b.b.a.bu(31, this.KFX) + g.a.a.b.b.a.bu(32, this.KGv);
      paramInt = i;
      if (this.imei != null) {
        paramInt = i + g.a.a.b.b.a.f(33, this.imei);
      }
      i = paramInt;
      if (this.KFD != null) {
        i = paramInt + g.a.a.b.b.a.f(34, this.KFD);
      }
      paramInt = i;
      if (this.KFE != null) {
        paramInt = i + g.a.a.b.b.a.f(35, this.KFE);
      }
      i = paramInt;
      if (this.KFF != null) {
        i = paramInt + g.a.a.b.b.a.f(36, this.KFF);
      }
      paramInt = i;
      if (this.KFG != null) {
        paramInt = i + g.a.a.b.b.a.f(37, this.KFG);
      }
      AppMethodBeat.o(125699);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125699);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cd localcd = (cd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125699);
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
            localcd.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 2: 
          localcd.DvI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 3: 
          localcd.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125699);
          return 0;
        case 4: 
          localcd.type = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125699);
          return 0;
        case 5: 
          localcd.KGj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125699);
          return 0;
        case 6: 
          localcd.ssid = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 7: 
          localcd.bssid = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 8: 
          localcd.KFM = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125699);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcd.KGk = ((cc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcd.KGl = ((cf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 11: 
          localcd.KFO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125699);
          return 0;
        case 12: 
          localcd.KFL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 13: 
          localcd.source = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125699);
          return 0;
        case 14: 
          localcd.KFQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 15: 
          localcd.KGm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125699);
          return 0;
        case 16: 
          localcd.KGn = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125699);
          return 0;
        case 17: 
          localcd.KGo = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125699);
          return 0;
        case 18: 
          localcd.KFR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125699);
          return 0;
        case 19: 
          localcd.KFS = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(125699);
          return 0;
        case 20: 
          localcd.KFT = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(125699);
          return 0;
        case 21: 
          localcd.Dsg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 22: 
          localcd.KFH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 23: 
          localcd.KFI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 24: 
          localcd.KGp = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(125699);
          return 0;
        case 25: 
          localcd.KGq = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(125699);
          return 0;
        case 26: 
          localcd.KGr = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(125699);
          return 0;
        case 27: 
          localcd.KGs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125699);
          return 0;
        case 28: 
          localcd.KGt = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125699);
          return 0;
        case 29: 
          localcd.KGu = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125699);
          return 0;
        case 30: 
          localcd.KFW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125699);
          return 0;
        case 31: 
          localcd.KFX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125699);
          return 0;
        case 32: 
          localcd.KGv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125699);
          return 0;
        case 33: 
          localcd.imei = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 34: 
          localcd.KFD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 35: 
          localcd.KFE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 36: 
          localcd.KFF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125699);
          return 0;
        }
        localcd.KFG = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125699);
        return 0;
      }
      AppMethodBeat.o(125699);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cd
 * JD-Core Version:    0.7.0.1
 */