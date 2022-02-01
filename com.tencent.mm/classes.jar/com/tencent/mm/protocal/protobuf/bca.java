package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bca
  extends esc
{
  public b Ayh;
  public String Edn;
  public bgw ZGD;
  public long ZGF;
  public LinkedList<String> ZGL;
  public bfw ZGP;
  public bfk ZGx;
  public int ZGz;
  public LinkedList<bnp> ZJW;
  public bgh ZKB;
  public bgz ZKb;
  public LinkedList<Integer> ZKe;
  public LinkedList<Integer> ZKg;
  public boolean ZKi;
  public bfg ZKj;
  public bjm ZMN;
  public bnw ZMO;
  public bmv ZMP;
  public bcc ZMQ;
  public int ZMR;
  public bzd ZMS;
  public String ZMT;
  public bcy ZMU;
  public eho ZMV;
  public bha ZMW;
  public aui ZMX;
  public bgq ZMY;
  public bfz ZMZ;
  public LinkedList<bcz> ZMv;
  public int ZMw;
  public long ZMx;
  public cbs ZNa;
  public int ZNb;
  public long ZNc;
  public cbw ZNd;
  public String ZNe;
  public boolean ZNf;
  public bla ZNg;
  public int ZNh;
  public long ZNi;
  public bip liveInfo;
  public boi location;
  public dix mZr;
  public String verify_info_buf;
  
  public bca()
  {
    AppMethodBeat.i(259451);
    this.ZJW = new LinkedList();
    this.ZMv = new LinkedList();
    this.ZGL = new LinkedList();
    this.ZKg = new LinkedList();
    this.ZKe = new LinkedList();
    AppMethodBeat.o(259451);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259465);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Ayh != null) {
        paramVarArgs.d(2, this.Ayh);
      }
      if (this.mZr != null)
      {
        paramVarArgs.qD(3, this.mZr.computeSize());
        this.mZr.writeFields(paramVarArgs);
      }
      if (this.liveInfo != null)
      {
        paramVarArgs.qD(4, this.liveInfo.computeSize());
        this.liveInfo.writeFields(paramVarArgs);
      }
      if (this.ZMN != null)
      {
        paramVarArgs.qD(5, this.ZMN.computeSize());
        this.ZMN.writeFields(paramVarArgs);
      }
      if (this.ZMO != null)
      {
        paramVarArgs.qD(6, this.ZMO.computeSize());
        this.ZMO.writeFields(paramVarArgs);
      }
      if (this.ZMP != null)
      {
        paramVarArgs.qD(7, this.ZMP.computeSize());
        this.ZMP.writeFields(paramVarArgs);
      }
      if (this.ZKB != null)
      {
        paramVarArgs.qD(8, this.ZKB.computeSize());
        this.ZKB.writeFields(paramVarArgs);
      }
      if (this.ZMQ != null)
      {
        paramVarArgs.qD(9, this.ZMQ.computeSize());
        this.ZMQ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.ZJW);
      paramVarArgs.e(11, 8, this.ZMv);
      paramVarArgs.bS(12, this.ZMw);
      paramVarArgs.bS(13, this.ZMR);
      paramVarArgs.bv(14, this.ZMx);
      if (this.verify_info_buf != null) {
        paramVarArgs.g(15, this.verify_info_buf);
      }
      if (this.location != null)
      {
        paramVarArgs.qD(16, this.location.computeSize());
        this.location.writeFields(paramVarArgs);
      }
      if (this.ZMS != null)
      {
        paramVarArgs.qD(17, this.ZMS.computeSize());
        this.ZMS.writeFields(paramVarArgs);
      }
      if (this.ZMT != null) {
        paramVarArgs.g(18, this.ZMT);
      }
      paramVarArgs.e(19, 1, this.ZGL);
      if (this.ZMU != null)
      {
        paramVarArgs.qD(20, this.ZMU.computeSize());
        this.ZMU.writeFields(paramVarArgs);
      }
      if (this.ZMV != null)
      {
        paramVarArgs.qD(21, this.ZMV.computeSize());
        this.ZMV.writeFields(paramVarArgs);
      }
      if (this.ZGx != null)
      {
        paramVarArgs.qD(22, this.ZGx.computeSize());
        this.ZGx.writeFields(paramVarArgs);
      }
      if (this.ZMW != null)
      {
        paramVarArgs.qD(23, this.ZMW.computeSize());
        this.ZMW.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(24, this.ZGz);
      if (this.ZMX != null)
      {
        paramVarArgs.qD(25, this.ZMX.computeSize());
        this.ZMX.writeFields(paramVarArgs);
      }
      if (this.ZMY != null)
      {
        paramVarArgs.qD(26, this.ZMY.computeSize());
        this.ZMY.writeFields(paramVarArgs);
      }
      if (this.ZGP != null)
      {
        paramVarArgs.qD(27, this.ZGP.computeSize());
        this.ZGP.writeFields(paramVarArgs);
      }
      if (this.ZKb != null)
      {
        paramVarArgs.qD(28, this.ZKb.computeSize());
        this.ZKb.writeFields(paramVarArgs);
      }
      if (this.Edn != null) {
        paramVarArgs.g(29, this.Edn);
      }
      if (this.ZMZ != null)
      {
        paramVarArgs.qD(30, this.ZMZ.computeSize());
        this.ZMZ.writeFields(paramVarArgs);
      }
      if (this.ZNa != null)
      {
        paramVarArgs.qD(31, this.ZNa.computeSize());
        this.ZNa.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(32, this.ZNb);
      paramVarArgs.bv(33, this.ZNc);
      if (this.ZNd != null)
      {
        paramVarArgs.qD(34, this.ZNd.computeSize());
        this.ZNd.writeFields(paramVarArgs);
      }
      paramVarArgs.e(35, 2, this.ZKg);
      paramVarArgs.e(36, 2, this.ZKe);
      if (this.ZGD != null)
      {
        paramVarArgs.qD(37, this.ZGD.computeSize());
        this.ZGD.writeFields(paramVarArgs);
      }
      paramVarArgs.di(38, this.ZKi);
      if (this.ZNe != null) {
        paramVarArgs.g(39, this.ZNe);
      }
      paramVarArgs.di(40, this.ZNf);
      if (this.ZNg != null)
      {
        paramVarArgs.qD(41, this.ZNg.computeSize());
        this.ZNg.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(42, this.ZNh);
      paramVarArgs.bv(44, this.ZGF);
      paramVarArgs.bv(45, this.ZNi);
      if (this.ZKj != null)
      {
        paramVarArgs.qD(47, this.ZKj.computeSize());
        this.ZKj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259465);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label4588;
      }
    }
    label4588:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ayh != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.Ayh);
      }
      i = paramInt;
      if (this.mZr != null) {
        i = paramInt + i.a.a.a.qC(3, this.mZr.computeSize());
      }
      paramInt = i;
      if (this.liveInfo != null) {
        paramInt = i + i.a.a.a.qC(4, this.liveInfo.computeSize());
      }
      i = paramInt;
      if (this.ZMN != null) {
        i = paramInt + i.a.a.a.qC(5, this.ZMN.computeSize());
      }
      paramInt = i;
      if (this.ZMO != null) {
        paramInt = i + i.a.a.a.qC(6, this.ZMO.computeSize());
      }
      i = paramInt;
      if (this.ZMP != null) {
        i = paramInt + i.a.a.a.qC(7, this.ZMP.computeSize());
      }
      paramInt = i;
      if (this.ZKB != null) {
        paramInt = i + i.a.a.a.qC(8, this.ZKB.computeSize());
      }
      i = paramInt;
      if (this.ZMQ != null) {
        i = paramInt + i.a.a.a.qC(9, this.ZMQ.computeSize());
      }
      i = i + i.a.a.a.c(10, 8, this.ZJW) + i.a.a.a.c(11, 8, this.ZMv) + i.a.a.b.b.a.cJ(12, this.ZMw) + i.a.a.b.b.a.cJ(13, this.ZMR) + i.a.a.b.b.a.q(14, this.ZMx);
      paramInt = i;
      if (this.verify_info_buf != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.verify_info_buf);
      }
      i = paramInt;
      if (this.location != null) {
        i = paramInt + i.a.a.a.qC(16, this.location.computeSize());
      }
      paramInt = i;
      if (this.ZMS != null) {
        paramInt = i + i.a.a.a.qC(17, this.ZMS.computeSize());
      }
      i = paramInt;
      if (this.ZMT != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.ZMT);
      }
      i += i.a.a.a.c(19, 1, this.ZGL);
      paramInt = i;
      if (this.ZMU != null) {
        paramInt = i + i.a.a.a.qC(20, this.ZMU.computeSize());
      }
      i = paramInt;
      if (this.ZMV != null) {
        i = paramInt + i.a.a.a.qC(21, this.ZMV.computeSize());
      }
      paramInt = i;
      if (this.ZGx != null) {
        paramInt = i + i.a.a.a.qC(22, this.ZGx.computeSize());
      }
      i = paramInt;
      if (this.ZMW != null) {
        i = paramInt + i.a.a.a.qC(23, this.ZMW.computeSize());
      }
      i += i.a.a.b.b.a.cJ(24, this.ZGz);
      paramInt = i;
      if (this.ZMX != null) {
        paramInt = i + i.a.a.a.qC(25, this.ZMX.computeSize());
      }
      i = paramInt;
      if (this.ZMY != null) {
        i = paramInt + i.a.a.a.qC(26, this.ZMY.computeSize());
      }
      paramInt = i;
      if (this.ZGP != null) {
        paramInt = i + i.a.a.a.qC(27, this.ZGP.computeSize());
      }
      i = paramInt;
      if (this.ZKb != null) {
        i = paramInt + i.a.a.a.qC(28, this.ZKb.computeSize());
      }
      paramInt = i;
      if (this.Edn != null) {
        paramInt = i + i.a.a.b.b.a.h(29, this.Edn);
      }
      i = paramInt;
      if (this.ZMZ != null) {
        i = paramInt + i.a.a.a.qC(30, this.ZMZ.computeSize());
      }
      paramInt = i;
      if (this.ZNa != null) {
        paramInt = i + i.a.a.a.qC(31, this.ZNa.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(32, this.ZNb) + i.a.a.b.b.a.q(33, this.ZNc);
      paramInt = i;
      if (this.ZNd != null) {
        paramInt = i + i.a.a.a.qC(34, this.ZNd.computeSize());
      }
      i = paramInt + i.a.a.a.c(35, 2, this.ZKg) + i.a.a.a.c(36, 2, this.ZKe);
      paramInt = i;
      if (this.ZGD != null) {
        paramInt = i + i.a.a.a.qC(37, this.ZGD.computeSize());
      }
      i = paramInt + (i.a.a.b.b.a.ko(38) + 1);
      paramInt = i;
      if (this.ZNe != null) {
        paramInt = i + i.a.a.b.b.a.h(39, this.ZNe);
      }
      i = paramInt + (i.a.a.b.b.a.ko(40) + 1);
      paramInt = i;
      if (this.ZNg != null) {
        paramInt = i + i.a.a.a.qC(41, this.ZNg.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(42, this.ZNh) + i.a.a.b.b.a.q(44, this.ZGF) + i.a.a.b.b.a.q(45, this.ZNi);
      paramInt = i;
      if (this.ZKj != null) {
        paramInt = i + i.a.a.a.qC(47, this.ZKj.computeSize());
      }
      AppMethodBeat.o(259465);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZJW.clear();
        this.ZMv.clear();
        this.ZGL.clear();
        this.ZKg.clear();
        this.ZKe.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259465);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bca localbca = (bca)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 43: 
        case 46: 
        default: 
          AppMethodBeat.o(259465);
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
            localbca.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 2: 
          localbca.Ayh = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259465);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dix();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dix)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.mZr = ((dix)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bip();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bip)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.liveInfo = ((bip)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjm)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.ZMN = ((bjm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bnw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bnw)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.ZMO = ((bnw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bmv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bmv)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.ZMP = ((bmv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgh)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.ZKB = ((bgh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bcc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bcc)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.ZMQ = ((bcc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bnp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bnp)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.ZJW.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 11: 
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
            localbca.ZMv.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 12: 
          localbca.ZMw = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259465);
          return 0;
        case 13: 
          localbca.ZMR = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259465);
          return 0;
        case 14: 
          localbca.ZMx = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259465);
          return 0;
        case 15: 
          localbca.verify_info_buf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259465);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new boi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((boi)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.location = ((boi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
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
            localbca.ZMS = ((bzd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 18: 
          localbca.ZMT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259465);
          return 0;
        case 19: 
          localbca.ZGL.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(259465);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bcy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bcy)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.ZMU = ((bcy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eho();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eho)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.ZMV = ((eho)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 22: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfk)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.ZGx = ((bfk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 23: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bha();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bha)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.ZMW = ((bha)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 24: 
          localbca.ZGz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259465);
          return 0;
        case 25: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aui();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aui)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.ZMX = ((aui)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 26: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgq)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.ZMY = ((bgq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 27: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfw)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.ZGP = ((bfw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 28: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgz)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.ZKb = ((bgz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 29: 
          localbca.Edn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259465);
          return 0;
        case 30: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfz)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.ZMZ = ((bfz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 31: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cbs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cbs)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.ZNa = ((cbs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 32: 
          localbca.ZNb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259465);
          return 0;
        case 33: 
          localbca.ZNc = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259465);
          return 0;
        case 34: 
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
            localbca.ZNd = ((cbw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 35: 
          localbca.ZKg.add(Integer.valueOf(((i.a.a.a.a)localObject1).ajGk.aar()));
          AppMethodBeat.o(259465);
          return 0;
        case 36: 
          localbca.ZKe.add(Integer.valueOf(((i.a.a.a.a)localObject1).ajGk.aar()));
          AppMethodBeat.o(259465);
          return 0;
        case 37: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgw)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.ZGD = ((bgw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 38: 
          localbca.ZKi = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(259465);
          return 0;
        case 39: 
          localbca.ZNe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259465);
          return 0;
        case 40: 
          localbca.ZNf = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(259465);
          return 0;
        case 41: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bla();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bla)localObject2).parseFrom((byte[])localObject1);
            }
            localbca.ZNg = ((bla)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259465);
          return 0;
        case 42: 
          localbca.ZNh = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259465);
          return 0;
        case 44: 
          localbca.ZGF = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259465);
          return 0;
        case 45: 
          localbca.ZNi = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259465);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bfg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bfg)localObject2).parseFrom((byte[])localObject1);
          }
          localbca.ZKj = ((bfg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259465);
        return 0;
      }
      AppMethodBeat.o(259465);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bca
 * JD-Core Version:    0.7.0.1
 */