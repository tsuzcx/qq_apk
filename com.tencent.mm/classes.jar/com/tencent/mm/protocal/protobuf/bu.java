package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bu
  extends cpx
{
  public String DOA;
  public long DOB;
  public int DOD;
  public String DOF;
  public int DOG;
  public b DOH;
  public b DOI;
  public String DOK;
  public int DOM;
  public int DON;
  public int DOW;
  public bt DOX;
  public bw DOY;
  public int DOZ;
  public String DOw;
  public String DOx;
  public long DPa;
  public long DPb;
  public float DPc;
  public float DPd;
  public float DPe;
  public int DPf;
  public long DPg;
  public long DPh;
  public int DPi;
  public String bssid;
  public int dbL;
  public String imei;
  public int scene;
  public String ssid;
  public int type;
  public String xJJ;
  public String zmu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125699);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xJJ != null) {
        paramVarArgs.d(2, this.xJJ);
      }
      paramVarArgs.aR(3, this.scene);
      paramVarArgs.aR(4, this.type);
      paramVarArgs.aR(5, this.DOW);
      if (this.ssid != null) {
        paramVarArgs.d(6, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.d(7, this.bssid);
      }
      paramVarArgs.aO(8, this.DOB);
      if (this.DOX != null)
      {
        paramVarArgs.ln(9, this.DOX.computeSize());
        this.DOX.writeFields(paramVarArgs);
      }
      if (this.DOY != null)
      {
        paramVarArgs.ln(10, this.DOY.computeSize());
        this.DOY.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.DOD);
      if (this.DOA != null) {
        paramVarArgs.d(12, this.DOA);
      }
      paramVarArgs.aR(13, this.dbL);
      if (this.DOF != null) {
        paramVarArgs.d(14, this.DOF);
      }
      paramVarArgs.aR(15, this.DOZ);
      paramVarArgs.aO(16, this.DPa);
      paramVarArgs.aO(17, this.DPb);
      paramVarArgs.aR(18, this.DOG);
      if (this.DOH != null) {
        paramVarArgs.c(19, this.DOH);
      }
      if (this.DOI != null) {
        paramVarArgs.c(20, this.DOI);
      }
      if (this.DOw != null) {
        paramVarArgs.d(21, this.DOw);
      }
      if (this.zmu != null) {
        paramVarArgs.d(22, this.zmu);
      }
      if (this.DOK != null) {
        paramVarArgs.d(23, this.DOK);
      }
      paramVarArgs.x(24, this.DPc);
      paramVarArgs.x(25, this.DPd);
      paramVarArgs.x(26, this.DPe);
      paramVarArgs.aR(27, this.DPf);
      paramVarArgs.aO(28, this.DPg);
      paramVarArgs.aO(29, this.DPh);
      paramVarArgs.aR(30, this.DOM);
      paramVarArgs.aR(31, this.DON);
      paramVarArgs.aR(32, this.DPi);
      if (this.imei != null) {
        paramVarArgs.d(33, this.imei);
      }
      if (this.DOx != null) {
        paramVarArgs.d(34, this.DOx);
      }
      AppMethodBeat.o(125699);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2211;
      }
    }
    label2211:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xJJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.xJJ);
      }
      i = i + f.a.a.b.b.a.bx(3, this.scene) + f.a.a.b.b.a.bx(4, this.type) + f.a.a.b.b.a.bx(5, this.DOW);
      paramInt = i;
      if (this.ssid != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ssid);
      }
      i = paramInt;
      if (this.bssid != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.bssid);
      }
      i += f.a.a.b.b.a.p(8, this.DOB);
      paramInt = i;
      if (this.DOX != null) {
        paramInt = i + f.a.a.a.lm(9, this.DOX.computeSize());
      }
      i = paramInt;
      if (this.DOY != null) {
        i = paramInt + f.a.a.a.lm(10, this.DOY.computeSize());
      }
      i += f.a.a.b.b.a.bx(11, this.DOD);
      paramInt = i;
      if (this.DOA != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DOA);
      }
      i = paramInt + f.a.a.b.b.a.bx(13, this.dbL);
      paramInt = i;
      if (this.DOF != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.DOF);
      }
      i = paramInt + f.a.a.b.b.a.bx(15, this.DOZ) + f.a.a.b.b.a.p(16, this.DPa) + f.a.a.b.b.a.p(17, this.DPb) + f.a.a.b.b.a.bx(18, this.DOG);
      paramInt = i;
      if (this.DOH != null) {
        paramInt = i + f.a.a.b.b.a.b(19, this.DOH);
      }
      i = paramInt;
      if (this.DOI != null) {
        i = paramInt + f.a.a.b.b.a.b(20, this.DOI);
      }
      paramInt = i;
      if (this.DOw != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.DOw);
      }
      i = paramInt;
      if (this.zmu != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.zmu);
      }
      paramInt = i;
      if (this.DOK != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.DOK);
      }
      i = paramInt + (f.a.a.b.b.a.fK(24) + 4) + (f.a.a.b.b.a.fK(25) + 4) + (f.a.a.b.b.a.fK(26) + 4) + f.a.a.b.b.a.bx(27, this.DPf) + f.a.a.b.b.a.p(28, this.DPg) + f.a.a.b.b.a.p(29, this.DPh) + f.a.a.b.b.a.bx(30, this.DOM) + f.a.a.b.b.a.bx(31, this.DON) + f.a.a.b.b.a.bx(32, this.DPi);
      paramInt = i;
      if (this.imei != null) {
        paramInt = i + f.a.a.b.b.a.e(33, this.imei);
      }
      i = paramInt;
      if (this.DOx != null) {
        i = paramInt + f.a.a.b.b.a.e(34, this.DOx);
      }
      AppMethodBeat.o(125699);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbu.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 2: 
          localbu.xJJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 3: 
          localbu.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125699);
          return 0;
        case 4: 
          localbu.type = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125699);
          return 0;
        case 5: 
          localbu.DOW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125699);
          return 0;
        case 6: 
          localbu.ssid = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 7: 
          localbu.bssid = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 8: 
          localbu.DOB = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125699);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbu.DOX = ((bt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbu.DOY = ((bw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 11: 
          localbu.DOD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125699);
          return 0;
        case 12: 
          localbu.DOA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 13: 
          localbu.dbL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125699);
          return 0;
        case 14: 
          localbu.DOF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 15: 
          localbu.DOZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125699);
          return 0;
        case 16: 
          localbu.DPa = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125699);
          return 0;
        case 17: 
          localbu.DPb = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125699);
          return 0;
        case 18: 
          localbu.DOG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125699);
          return 0;
        case 19: 
          localbu.DOH = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(125699);
          return 0;
        case 20: 
          localbu.DOI = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(125699);
          return 0;
        case 21: 
          localbu.DOw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 22: 
          localbu.zmu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 23: 
          localbu.DOK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 24: 
          localbu.DPc = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(125699);
          return 0;
        case 25: 
          localbu.DPd = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(125699);
          return 0;
        case 26: 
          localbu.DPe = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(125699);
          return 0;
        case 27: 
          localbu.DPf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125699);
          return 0;
        case 28: 
          localbu.DPg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125699);
          return 0;
        case 29: 
          localbu.DPh = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125699);
          return 0;
        case 30: 
          localbu.DOM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125699);
          return 0;
        case 31: 
          localbu.DON = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125699);
          return 0;
        case 32: 
          localbu.DPi = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125699);
          return 0;
        case 33: 
          localbu.imei = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125699);
          return 0;
        }
        localbu.DOx = ((f.a.a.a.a)localObject1).LVo.readString();
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