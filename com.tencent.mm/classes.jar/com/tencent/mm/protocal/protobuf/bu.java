package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bu
  extends cvw
{
  public int FME;
  public bt FMF;
  public bw FMG;
  public int FMH;
  public long FMI;
  public long FMJ;
  public float FMK;
  public float FML;
  public float FMM;
  public int FMN;
  public long FMO;
  public long FMP;
  public int FMQ;
  public String FMb;
  public String FMc;
  public String FMd;
  public String FMe;
  public String FMf;
  public String FMg;
  public String FMj;
  public long FMk;
  public int FMm;
  public String FMo;
  public int FMp;
  public b FMq;
  public b FMr;
  public int FMu;
  public int FMv;
  public String bssid;
  public int doj;
  public String imei;
  public int scene;
  public String ssid;
  public int type;
  public String zmV;
  public String zpz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125699);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.zpz != null) {
        paramVarArgs.d(2, this.zpz);
      }
      paramVarArgs.aS(3, this.scene);
      paramVarArgs.aS(4, this.type);
      paramVarArgs.aS(5, this.FME);
      if (this.ssid != null) {
        paramVarArgs.d(6, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.d(7, this.bssid);
      }
      paramVarArgs.aZ(8, this.FMk);
      if (this.FMF != null)
      {
        paramVarArgs.lJ(9, this.FMF.computeSize());
        this.FMF.writeFields(paramVarArgs);
      }
      if (this.FMG != null)
      {
        paramVarArgs.lJ(10, this.FMG.computeSize());
        this.FMG.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.FMm);
      if (this.FMj != null) {
        paramVarArgs.d(12, this.FMj);
      }
      paramVarArgs.aS(13, this.doj);
      if (this.FMo != null) {
        paramVarArgs.d(14, this.FMo);
      }
      paramVarArgs.aS(15, this.FMH);
      paramVarArgs.aZ(16, this.FMI);
      paramVarArgs.aZ(17, this.FMJ);
      paramVarArgs.aS(18, this.FMp);
      if (this.FMq != null) {
        paramVarArgs.c(19, this.FMq);
      }
      if (this.FMr != null) {
        paramVarArgs.c(20, this.FMr);
      }
      if (this.zmV != null) {
        paramVarArgs.d(21, this.zmV);
      }
      if (this.FMf != null) {
        paramVarArgs.d(22, this.FMf);
      }
      if (this.FMg != null) {
        paramVarArgs.d(23, this.FMg);
      }
      paramVarArgs.y(24, this.FMK);
      paramVarArgs.y(25, this.FML);
      paramVarArgs.y(26, this.FMM);
      paramVarArgs.aS(27, this.FMN);
      paramVarArgs.aZ(28, this.FMO);
      paramVarArgs.aZ(29, this.FMP);
      paramVarArgs.aS(30, this.FMu);
      paramVarArgs.aS(31, this.FMv);
      paramVarArgs.aS(32, this.FMQ);
      if (this.imei != null) {
        paramVarArgs.d(33, this.imei);
      }
      if (this.FMb != null) {
        paramVarArgs.d(34, this.FMb);
      }
      if (this.FMc != null) {
        paramVarArgs.d(35, this.FMc);
      }
      if (this.FMd != null) {
        paramVarArgs.d(36, this.FMd);
      }
      if (this.FMe != null) {
        paramVarArgs.d(37, this.FMe);
      }
      AppMethodBeat.o(125699);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2391;
      }
    }
    label2391:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.zpz != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.zpz);
      }
      i = i + f.a.a.b.b.a.bz(3, this.scene) + f.a.a.b.b.a.bz(4, this.type) + f.a.a.b.b.a.bz(5, this.FME);
      paramInt = i;
      if (this.ssid != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ssid);
      }
      i = paramInt;
      if (this.bssid != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.bssid);
      }
      i += f.a.a.b.b.a.p(8, this.FMk);
      paramInt = i;
      if (this.FMF != null) {
        paramInt = i + f.a.a.a.lI(9, this.FMF.computeSize());
      }
      i = paramInt;
      if (this.FMG != null) {
        i = paramInt + f.a.a.a.lI(10, this.FMG.computeSize());
      }
      i += f.a.a.b.b.a.bz(11, this.FMm);
      paramInt = i;
      if (this.FMj != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FMj);
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.doj);
      paramInt = i;
      if (this.FMo != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.FMo);
      }
      i = paramInt + f.a.a.b.b.a.bz(15, this.FMH) + f.a.a.b.b.a.p(16, this.FMI) + f.a.a.b.b.a.p(17, this.FMJ) + f.a.a.b.b.a.bz(18, this.FMp);
      paramInt = i;
      if (this.FMq != null) {
        paramInt = i + f.a.a.b.b.a.b(19, this.FMq);
      }
      i = paramInt;
      if (this.FMr != null) {
        i = paramInt + f.a.a.b.b.a.b(20, this.FMr);
      }
      paramInt = i;
      if (this.zmV != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.zmV);
      }
      i = paramInt;
      if (this.FMf != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.FMf);
      }
      paramInt = i;
      if (this.FMg != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.FMg);
      }
      i = paramInt + f.a.a.b.b.a.amE(24) + f.a.a.b.b.a.amE(25) + f.a.a.b.b.a.amE(26) + f.a.a.b.b.a.bz(27, this.FMN) + f.a.a.b.b.a.p(28, this.FMO) + f.a.a.b.b.a.p(29, this.FMP) + f.a.a.b.b.a.bz(30, this.FMu) + f.a.a.b.b.a.bz(31, this.FMv) + f.a.a.b.b.a.bz(32, this.FMQ);
      paramInt = i;
      if (this.imei != null) {
        paramInt = i + f.a.a.b.b.a.e(33, this.imei);
      }
      i = paramInt;
      if (this.FMb != null) {
        i = paramInt + f.a.a.b.b.a.e(34, this.FMb);
      }
      paramInt = i;
      if (this.FMc != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.FMc);
      }
      i = paramInt;
      if (this.FMd != null) {
        i = paramInt + f.a.a.b.b.a.e(36, this.FMd);
      }
      paramInt = i;
      if (this.FMe != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.FMe);
      }
      AppMethodBeat.o(125699);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125699);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bu localbu = (bu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125699);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 2: 
          localbu.zpz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 3: 
          localbu.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 4: 
          localbu.type = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 5: 
          localbu.FME = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 6: 
          localbu.ssid = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 7: 
          localbu.bssid = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 8: 
          localbu.FMk = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125699);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbu.FMF = ((bt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbu.FMG = ((bw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 11: 
          localbu.FMm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 12: 
          localbu.FMj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 13: 
          localbu.doj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 14: 
          localbu.FMo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 15: 
          localbu.FMH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 16: 
          localbu.FMI = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125699);
          return 0;
        case 17: 
          localbu.FMJ = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125699);
          return 0;
        case 18: 
          localbu.FMp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 19: 
          localbu.FMq = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(125699);
          return 0;
        case 20: 
          localbu.FMr = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(125699);
          return 0;
        case 21: 
          localbu.zmV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 22: 
          localbu.FMf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 23: 
          localbu.FMg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 24: 
          localbu.FMK = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(125699);
          return 0;
        case 25: 
          localbu.FML = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(125699);
          return 0;
        case 26: 
          localbu.FMM = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(125699);
          return 0;
        case 27: 
          localbu.FMN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 28: 
          localbu.FMO = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125699);
          return 0;
        case 29: 
          localbu.FMP = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125699);
          return 0;
        case 30: 
          localbu.FMu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 31: 
          localbu.FMv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 32: 
          localbu.FMQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 33: 
          localbu.imei = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 34: 
          localbu.FMb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 35: 
          localbu.FMc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 36: 
          localbu.FMd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125699);
          return 0;
        }
        localbu.FMe = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125699);
        return 0;
      }
      AppMethodBeat.o(125699);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bu
 * JD-Core Version:    0.7.0.1
 */