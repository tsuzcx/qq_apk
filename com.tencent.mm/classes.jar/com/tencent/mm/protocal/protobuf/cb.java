package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class cb
  extends dyl
{
  public String JFg;
  public String JyL;
  public String RGU;
  public String RGV;
  public String RGW;
  public String RGX;
  public String RGY;
  public String RGZ;
  public int RHC;
  public ca RHD;
  public cd RHE;
  public int RHF;
  public long RHG;
  public long RHH;
  public float RHI;
  public float RHJ;
  public float RHK;
  public int RHL;
  public long RHM;
  public long RHN;
  public int RHO;
  public String RHd;
  public long RHe;
  public int RHg;
  public String RHi;
  public int RHj;
  public b RHk;
  public b RHl;
  public int RHo;
  public int RHp;
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
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.JFg != null) {
        paramVarArgs.f(2, this.JFg);
      }
      paramVarArgs.aY(3, this.scene);
      paramVarArgs.aY(4, this.type);
      paramVarArgs.aY(5, this.RHC);
      if (this.ssid != null) {
        paramVarArgs.f(6, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.f(7, this.bssid);
      }
      paramVarArgs.bm(8, this.RHe);
      if (this.RHD != null)
      {
        paramVarArgs.oE(9, this.RHD.computeSize());
        this.RHD.writeFields(paramVarArgs);
      }
      if (this.RHE != null)
      {
        paramVarArgs.oE(10, this.RHE.computeSize());
        this.RHE.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(11, this.RHg);
      if (this.RHd != null) {
        paramVarArgs.f(12, this.RHd);
      }
      paramVarArgs.aY(13, this.source);
      if (this.RHi != null) {
        paramVarArgs.f(14, this.RHi);
      }
      paramVarArgs.aY(15, this.RHF);
      paramVarArgs.bm(16, this.RHG);
      paramVarArgs.bm(17, this.RHH);
      paramVarArgs.aY(18, this.RHj);
      if (this.RHk != null) {
        paramVarArgs.c(19, this.RHk);
      }
      if (this.RHl != null) {
        paramVarArgs.c(20, this.RHl);
      }
      if (this.JyL != null) {
        paramVarArgs.f(21, this.JyL);
      }
      if (this.RGY != null) {
        paramVarArgs.f(22, this.RGY);
      }
      if (this.RGZ != null) {
        paramVarArgs.f(23, this.RGZ);
      }
      paramVarArgs.i(24, this.RHI);
      paramVarArgs.i(25, this.RHJ);
      paramVarArgs.i(26, this.RHK);
      paramVarArgs.aY(27, this.RHL);
      paramVarArgs.bm(28, this.RHM);
      paramVarArgs.bm(29, this.RHN);
      paramVarArgs.aY(30, this.RHo);
      paramVarArgs.aY(31, this.RHp);
      paramVarArgs.aY(32, this.RHO);
      if (this.imei != null) {
        paramVarArgs.f(33, this.imei);
      }
      if (this.RGU != null) {
        paramVarArgs.f(34, this.RGU);
      }
      if (this.RGV != null) {
        paramVarArgs.f(35, this.RGV);
      }
      if (this.RGW != null) {
        paramVarArgs.f(36, this.RGW);
      }
      if (this.RGX != null) {
        paramVarArgs.f(37, this.RGX);
      }
      AppMethodBeat.o(125699);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2329;
      }
    }
    label2329:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.JFg != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.JFg);
      }
      i = i + g.a.a.b.b.a.bM(3, this.scene) + g.a.a.b.b.a.bM(4, this.type) + g.a.a.b.b.a.bM(5, this.RHC);
      paramInt = i;
      if (this.ssid != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.ssid);
      }
      i = paramInt;
      if (this.bssid != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.bssid);
      }
      i += g.a.a.b.b.a.p(8, this.RHe);
      paramInt = i;
      if (this.RHD != null) {
        paramInt = i + g.a.a.a.oD(9, this.RHD.computeSize());
      }
      i = paramInt;
      if (this.RHE != null) {
        i = paramInt + g.a.a.a.oD(10, this.RHE.computeSize());
      }
      i += g.a.a.b.b.a.bM(11, this.RHg);
      paramInt = i;
      if (this.RHd != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.RHd);
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.source);
      paramInt = i;
      if (this.RHi != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.RHi);
      }
      i = paramInt + g.a.a.b.b.a.bM(15, this.RHF) + g.a.a.b.b.a.p(16, this.RHG) + g.a.a.b.b.a.p(17, this.RHH) + g.a.a.b.b.a.bM(18, this.RHj);
      paramInt = i;
      if (this.RHk != null) {
        paramInt = i + g.a.a.b.b.a.b(19, this.RHk);
      }
      i = paramInt;
      if (this.RHl != null) {
        i = paramInt + g.a.a.b.b.a.b(20, this.RHl);
      }
      paramInt = i;
      if (this.JyL != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.JyL);
      }
      i = paramInt;
      if (this.RGY != null) {
        i = paramInt + g.a.a.b.b.a.g(22, this.RGY);
      }
      paramInt = i;
      if (this.RGZ != null) {
        paramInt = i + g.a.a.b.b.a.g(23, this.RGZ);
      }
      i = paramInt + (g.a.a.b.b.a.gL(24) + 4) + (g.a.a.b.b.a.gL(25) + 4) + (g.a.a.b.b.a.gL(26) + 4) + g.a.a.b.b.a.bM(27, this.RHL) + g.a.a.b.b.a.p(28, this.RHM) + g.a.a.b.b.a.p(29, this.RHN) + g.a.a.b.b.a.bM(30, this.RHo) + g.a.a.b.b.a.bM(31, this.RHp) + g.a.a.b.b.a.bM(32, this.RHO);
      paramInt = i;
      if (this.imei != null) {
        paramInt = i + g.a.a.b.b.a.g(33, this.imei);
      }
      i = paramInt;
      if (this.RGU != null) {
        i = paramInt + g.a.a.b.b.a.g(34, this.RGU);
      }
      paramInt = i;
      if (this.RGV != null) {
        paramInt = i + g.a.a.b.b.a.g(35, this.RGV);
      }
      i = paramInt;
      if (this.RGW != null) {
        i = paramInt + g.a.a.b.b.a.g(36, this.RGW);
      }
      paramInt = i;
      if (this.RGX != null) {
        paramInt = i + g.a.a.b.b.a.g(37, this.RGX);
      }
      AppMethodBeat.o(125699);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125699);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cb localcb = (cb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125699);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localcb.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 2: 
          localcb.JFg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 3: 
          localcb.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125699);
          return 0;
        case 4: 
          localcb.type = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125699);
          return 0;
        case 5: 
          localcb.RHC = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125699);
          return 0;
        case 6: 
          localcb.ssid = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 7: 
          localcb.bssid = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 8: 
          localcb.RHe = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125699);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ca();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ca)localObject2).parseFrom((byte[])localObject1);
            }
            localcb.RHD = ((ca)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cd)localObject2).parseFrom((byte[])localObject1);
            }
            localcb.RHE = ((cd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 11: 
          localcb.RHg = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125699);
          return 0;
        case 12: 
          localcb.RHd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 13: 
          localcb.source = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125699);
          return 0;
        case 14: 
          localcb.RHi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 15: 
          localcb.RHF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125699);
          return 0;
        case 16: 
          localcb.RHG = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125699);
          return 0;
        case 17: 
          localcb.RHH = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125699);
          return 0;
        case 18: 
          localcb.RHj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125699);
          return 0;
        case 19: 
          localcb.RHk = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(125699);
          return 0;
        case 20: 
          localcb.RHl = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(125699);
          return 0;
        case 21: 
          localcb.JyL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 22: 
          localcb.RGY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 23: 
          localcb.RGZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 24: 
          localcb.RHI = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(125699);
          return 0;
        case 25: 
          localcb.RHJ = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(125699);
          return 0;
        case 26: 
          localcb.RHK = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(125699);
          return 0;
        case 27: 
          localcb.RHL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125699);
          return 0;
        case 28: 
          localcb.RHM = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125699);
          return 0;
        case 29: 
          localcb.RHN = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125699);
          return 0;
        case 30: 
          localcb.RHo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125699);
          return 0;
        case 31: 
          localcb.RHp = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125699);
          return 0;
        case 32: 
          localcb.RHO = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125699);
          return 0;
        case 33: 
          localcb.imei = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 34: 
          localcb.RGU = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 35: 
          localcb.RGV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 36: 
          localcb.RGW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125699);
          return 0;
        }
        localcb.RGX = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125699);
        return 0;
      }
      AppMethodBeat.o(125699);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cb
 * JD-Core Version:    0.7.0.1
 */