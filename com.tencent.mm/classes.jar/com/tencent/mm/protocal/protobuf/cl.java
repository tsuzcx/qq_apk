package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cl
  extends erp
{
  public String PNk;
  public int PUQ;
  public String PWh;
  public String YDW;
  public String YDX;
  public String YDY;
  public String YDZ;
  public int YEF;
  public ck YEG;
  public cn YEH;
  public int YEI;
  public long YEJ;
  public long YEK;
  public float YEL;
  public float YEM;
  public float YEN;
  public int YEO;
  public long YEP;
  public long YEQ;
  public int YER;
  public String YEa;
  public String YEb;
  public String YEe;
  public long YEf;
  public int YEh;
  public String YEj;
  public int YEk;
  public b YEl;
  public b YEm;
  public int YEp;
  public int YEq;
  public int YEs;
  public int YEt;
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
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.PWh != null) {
        paramVarArgs.g(2, this.PWh);
      }
      paramVarArgs.bS(3, this.scene);
      paramVarArgs.bS(4, this.type);
      paramVarArgs.bS(5, this.YEF);
      if (this.ssid != null) {
        paramVarArgs.g(6, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.g(7, this.bssid);
      }
      paramVarArgs.bv(8, this.YEf);
      if (this.YEG != null)
      {
        paramVarArgs.qD(9, this.YEG.computeSize());
        this.YEG.writeFields(paramVarArgs);
      }
      if (this.YEH != null)
      {
        paramVarArgs.qD(10, this.YEH.computeSize());
        this.YEH.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(11, this.YEh);
      if (this.YEe != null) {
        paramVarArgs.g(12, this.YEe);
      }
      paramVarArgs.bS(13, this.source);
      if (this.YEj != null) {
        paramVarArgs.g(14, this.YEj);
      }
      paramVarArgs.bS(15, this.YEI);
      paramVarArgs.bv(16, this.YEJ);
      paramVarArgs.bv(17, this.YEK);
      paramVarArgs.bS(18, this.YEk);
      if (this.YEl != null) {
        paramVarArgs.d(19, this.YEl);
      }
      if (this.YEm != null) {
        paramVarArgs.d(20, this.YEm);
      }
      if (this.PNk != null) {
        paramVarArgs.g(21, this.PNk);
      }
      if (this.YEa != null) {
        paramVarArgs.g(22, this.YEa);
      }
      if (this.YEb != null) {
        paramVarArgs.g(23, this.YEb);
      }
      paramVarArgs.l(24, this.YEL);
      paramVarArgs.l(25, this.YEM);
      paramVarArgs.l(26, this.YEN);
      paramVarArgs.bS(27, this.YEO);
      paramVarArgs.bv(28, this.YEP);
      paramVarArgs.bv(29, this.YEQ);
      paramVarArgs.bS(30, this.YEp);
      paramVarArgs.bS(31, this.YEq);
      paramVarArgs.bS(32, this.YER);
      if (this.imei != null) {
        paramVarArgs.g(33, this.imei);
      }
      if (this.YDW != null) {
        paramVarArgs.g(34, this.YDW);
      }
      if (this.YDX != null) {
        paramVarArgs.g(35, this.YDX);
      }
      if (this.YDY != null) {
        paramVarArgs.g(36, this.YDY);
      }
      if (this.YDZ != null) {
        paramVarArgs.g(37, this.YDZ);
      }
      paramVarArgs.bS(38, this.YEs);
      paramVarArgs.bS(39, this.YEt);
      paramVarArgs.bS(40, this.PUQ);
      AppMethodBeat.o(125699);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2469;
      }
    }
    label2469:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.PWh != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.PWh);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.scene) + i.a.a.b.b.a.cJ(4, this.type) + i.a.a.b.b.a.cJ(5, this.YEF);
      paramInt = i;
      if (this.ssid != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ssid);
      }
      i = paramInt;
      if (this.bssid != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.bssid);
      }
      i += i.a.a.b.b.a.q(8, this.YEf);
      paramInt = i;
      if (this.YEG != null) {
        paramInt = i + i.a.a.a.qC(9, this.YEG.computeSize());
      }
      i = paramInt;
      if (this.YEH != null) {
        i = paramInt + i.a.a.a.qC(10, this.YEH.computeSize());
      }
      i += i.a.a.b.b.a.cJ(11, this.YEh);
      paramInt = i;
      if (this.YEe != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.YEe);
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.source);
      paramInt = i;
      if (this.YEj != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.YEj);
      }
      i = paramInt + i.a.a.b.b.a.cJ(15, this.YEI) + i.a.a.b.b.a.q(16, this.YEJ) + i.a.a.b.b.a.q(17, this.YEK) + i.a.a.b.b.a.cJ(18, this.YEk);
      paramInt = i;
      if (this.YEl != null) {
        paramInt = i + i.a.a.b.b.a.c(19, this.YEl);
      }
      i = paramInt;
      if (this.YEm != null) {
        i = paramInt + i.a.a.b.b.a.c(20, this.YEm);
      }
      paramInt = i;
      if (this.PNk != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.PNk);
      }
      i = paramInt;
      if (this.YEa != null) {
        i = paramInt + i.a.a.b.b.a.h(22, this.YEa);
      }
      paramInt = i;
      if (this.YEb != null) {
        paramInt = i + i.a.a.b.b.a.h(23, this.YEb);
      }
      i = paramInt + (i.a.a.b.b.a.ko(24) + 4) + (i.a.a.b.b.a.ko(25) + 4) + (i.a.a.b.b.a.ko(26) + 4) + i.a.a.b.b.a.cJ(27, this.YEO) + i.a.a.b.b.a.q(28, this.YEP) + i.a.a.b.b.a.q(29, this.YEQ) + i.a.a.b.b.a.cJ(30, this.YEp) + i.a.a.b.b.a.cJ(31, this.YEq) + i.a.a.b.b.a.cJ(32, this.YER);
      paramInt = i;
      if (this.imei != null) {
        paramInt = i + i.a.a.b.b.a.h(33, this.imei);
      }
      i = paramInt;
      if (this.YDW != null) {
        i = paramInt + i.a.a.b.b.a.h(34, this.YDW);
      }
      paramInt = i;
      if (this.YDX != null) {
        paramInt = i + i.a.a.b.b.a.h(35, this.YDX);
      }
      i = paramInt;
      if (this.YDY != null) {
        i = paramInt + i.a.a.b.b.a.h(36, this.YDY);
      }
      paramInt = i;
      if (this.YDZ != null) {
        paramInt = i + i.a.a.b.b.a.h(37, this.YDZ);
      }
      i = i.a.a.b.b.a.cJ(38, this.YEs);
      int j = i.a.a.b.b.a.cJ(39, this.YEt);
      int k = i.a.a.b.b.a.cJ(40, this.PUQ);
      AppMethodBeat.o(125699);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125699);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cl localcl = (cl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125699);
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
            localcl.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 2: 
          localcl.PWh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 3: 
          localcl.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125699);
          return 0;
        case 4: 
          localcl.type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125699);
          return 0;
        case 5: 
          localcl.YEF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125699);
          return 0;
        case 6: 
          localcl.ssid = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 7: 
          localcl.bssid = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 8: 
          localcl.YEf = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125699);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ck();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ck)localObject2).parseFrom((byte[])localObject1);
            }
            localcl.YEG = ((ck)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cn)localObject2).parseFrom((byte[])localObject1);
            }
            localcl.YEH = ((cn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 11: 
          localcl.YEh = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125699);
          return 0;
        case 12: 
          localcl.YEe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 13: 
          localcl.source = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125699);
          return 0;
        case 14: 
          localcl.YEj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 15: 
          localcl.YEI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125699);
          return 0;
        case 16: 
          localcl.YEJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125699);
          return 0;
        case 17: 
          localcl.YEK = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125699);
          return 0;
        case 18: 
          localcl.YEk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125699);
          return 0;
        case 19: 
          localcl.YEl = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(125699);
          return 0;
        case 20: 
          localcl.YEm = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(125699);
          return 0;
        case 21: 
          localcl.PNk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 22: 
          localcl.YEa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 23: 
          localcl.YEb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 24: 
          localcl.YEL = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(125699);
          return 0;
        case 25: 
          localcl.YEM = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(125699);
          return 0;
        case 26: 
          localcl.YEN = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(125699);
          return 0;
        case 27: 
          localcl.YEO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125699);
          return 0;
        case 28: 
          localcl.YEP = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125699);
          return 0;
        case 29: 
          localcl.YEQ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125699);
          return 0;
        case 30: 
          localcl.YEp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125699);
          return 0;
        case 31: 
          localcl.YEq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125699);
          return 0;
        case 32: 
          localcl.YER = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125699);
          return 0;
        case 33: 
          localcl.imei = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 34: 
          localcl.YDW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 35: 
          localcl.YDX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 36: 
          localcl.YDY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 37: 
          localcl.YDZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 38: 
          localcl.YEs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125699);
          return 0;
        case 39: 
          localcl.YEt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125699);
          return 0;
        }
        localcl.PUQ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125699);
        return 0;
      }
      AppMethodBeat.o(125699);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cl
 * JD-Core Version:    0.7.0.1
 */