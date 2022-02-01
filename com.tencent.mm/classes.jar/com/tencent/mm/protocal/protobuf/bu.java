package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bu
  extends cvc
{
  public String FtD;
  public String FtE;
  public String FtF;
  public String FtG;
  public String FtH;
  public String FtI;
  public String FtL;
  public long FtM;
  public int FtO;
  public String FtQ;
  public int FtR;
  public b FtS;
  public b FtT;
  public int FtW;
  public int FtX;
  public int Fug;
  public bt Fuh;
  public bw Fui;
  public int Fuj;
  public long Fuk;
  public long Ful;
  public float Fum;
  public float Fun;
  public float Fuo;
  public int Fup;
  public long Fuq;
  public long Fur;
  public int Fus;
  public String bssid;
  public int dnh;
  public String imei;
  public int scene;
  public String ssid;
  public int type;
  public String yWM;
  public String yYY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125699);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.yYY != null) {
        paramVarArgs.d(2, this.yYY);
      }
      paramVarArgs.aS(3, this.scene);
      paramVarArgs.aS(4, this.type);
      paramVarArgs.aS(5, this.Fug);
      if (this.ssid != null) {
        paramVarArgs.d(6, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.d(7, this.bssid);
      }
      paramVarArgs.aY(8, this.FtM);
      if (this.Fuh != null)
      {
        paramVarArgs.lC(9, this.Fuh.computeSize());
        this.Fuh.writeFields(paramVarArgs);
      }
      if (this.Fui != null)
      {
        paramVarArgs.lC(10, this.Fui.computeSize());
        this.Fui.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.FtO);
      if (this.FtL != null) {
        paramVarArgs.d(12, this.FtL);
      }
      paramVarArgs.aS(13, this.dnh);
      if (this.FtQ != null) {
        paramVarArgs.d(14, this.FtQ);
      }
      paramVarArgs.aS(15, this.Fuj);
      paramVarArgs.aY(16, this.Fuk);
      paramVarArgs.aY(17, this.Ful);
      paramVarArgs.aS(18, this.FtR);
      if (this.FtS != null) {
        paramVarArgs.c(19, this.FtS);
      }
      if (this.FtT != null) {
        paramVarArgs.c(20, this.FtT);
      }
      if (this.yWM != null) {
        paramVarArgs.d(21, this.yWM);
      }
      if (this.FtH != null) {
        paramVarArgs.d(22, this.FtH);
      }
      if (this.FtI != null) {
        paramVarArgs.d(23, this.FtI);
      }
      paramVarArgs.z(24, this.Fum);
      paramVarArgs.z(25, this.Fun);
      paramVarArgs.z(26, this.Fuo);
      paramVarArgs.aS(27, this.Fup);
      paramVarArgs.aY(28, this.Fuq);
      paramVarArgs.aY(29, this.Fur);
      paramVarArgs.aS(30, this.FtW);
      paramVarArgs.aS(31, this.FtX);
      paramVarArgs.aS(32, this.Fus);
      if (this.imei != null) {
        paramVarArgs.d(33, this.imei);
      }
      if (this.FtD != null) {
        paramVarArgs.d(34, this.FtD);
      }
      if (this.FtE != null) {
        paramVarArgs.d(35, this.FtE);
      }
      if (this.FtF != null) {
        paramVarArgs.d(36, this.FtF);
      }
      if (this.FtG != null) {
        paramVarArgs.d(37, this.FtG);
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
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.yYY != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.yYY);
      }
      i = i + f.a.a.b.b.a.bz(3, this.scene) + f.a.a.b.b.a.bz(4, this.type) + f.a.a.b.b.a.bz(5, this.Fug);
      paramInt = i;
      if (this.ssid != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ssid);
      }
      i = paramInt;
      if (this.bssid != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.bssid);
      }
      i += f.a.a.b.b.a.p(8, this.FtM);
      paramInt = i;
      if (this.Fuh != null) {
        paramInt = i + f.a.a.a.lB(9, this.Fuh.computeSize());
      }
      i = paramInt;
      if (this.Fui != null) {
        i = paramInt + f.a.a.a.lB(10, this.Fui.computeSize());
      }
      i += f.a.a.b.b.a.bz(11, this.FtO);
      paramInt = i;
      if (this.FtL != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FtL);
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.dnh);
      paramInt = i;
      if (this.FtQ != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.FtQ);
      }
      i = paramInt + f.a.a.b.b.a.bz(15, this.Fuj) + f.a.a.b.b.a.p(16, this.Fuk) + f.a.a.b.b.a.p(17, this.Ful) + f.a.a.b.b.a.bz(18, this.FtR);
      paramInt = i;
      if (this.FtS != null) {
        paramInt = i + f.a.a.b.b.a.b(19, this.FtS);
      }
      i = paramInt;
      if (this.FtT != null) {
        i = paramInt + f.a.a.b.b.a.b(20, this.FtT);
      }
      paramInt = i;
      if (this.yWM != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.yWM);
      }
      i = paramInt;
      if (this.FtH != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.FtH);
      }
      paramInt = i;
      if (this.FtI != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.FtI);
      }
      i = paramInt + f.a.a.b.b.a.alU(24) + f.a.a.b.b.a.alU(25) + f.a.a.b.b.a.alU(26) + f.a.a.b.b.a.bz(27, this.Fup) + f.a.a.b.b.a.p(28, this.Fuq) + f.a.a.b.b.a.p(29, this.Fur) + f.a.a.b.b.a.bz(30, this.FtW) + f.a.a.b.b.a.bz(31, this.FtX) + f.a.a.b.b.a.bz(32, this.Fus);
      paramInt = i;
      if (this.imei != null) {
        paramInt = i + f.a.a.b.b.a.e(33, this.imei);
      }
      i = paramInt;
      if (this.FtD != null) {
        i = paramInt + f.a.a.b.b.a.e(34, this.FtD);
      }
      paramInt = i;
      if (this.FtE != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.FtE);
      }
      i = paramInt;
      if (this.FtF != null) {
        i = paramInt + f.a.a.b.b.a.e(36, this.FtF);
      }
      paramInt = i;
      if (this.FtG != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.FtG);
      }
      AppMethodBeat.o(125699);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 2: 
          localbu.yYY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 3: 
          localbu.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 4: 
          localbu.type = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 5: 
          localbu.Fug = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 6: 
          localbu.ssid = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 7: 
          localbu.bssid = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 8: 
          localbu.FtM = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125699);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbu.Fuh = ((bt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbu.Fui = ((bw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 11: 
          localbu.FtO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 12: 
          localbu.FtL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 13: 
          localbu.dnh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 14: 
          localbu.FtQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 15: 
          localbu.Fuj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 16: 
          localbu.Fuk = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125699);
          return 0;
        case 17: 
          localbu.Ful = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125699);
          return 0;
        case 18: 
          localbu.FtR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 19: 
          localbu.FtS = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(125699);
          return 0;
        case 20: 
          localbu.FtT = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(125699);
          return 0;
        case 21: 
          localbu.yWM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 22: 
          localbu.FtH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 23: 
          localbu.FtI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 24: 
          localbu.Fum = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(125699);
          return 0;
        case 25: 
          localbu.Fun = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(125699);
          return 0;
        case 26: 
          localbu.Fuo = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(125699);
          return 0;
        case 27: 
          localbu.Fup = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 28: 
          localbu.Fuq = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125699);
          return 0;
        case 29: 
          localbu.Fur = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125699);
          return 0;
        case 30: 
          localbu.FtW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 31: 
          localbu.FtX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 32: 
          localbu.Fus = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125699);
          return 0;
        case 33: 
          localbu.imei = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 34: 
          localbu.FtD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 35: 
          localbu.FtE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 36: 
          localbu.FtF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125699);
          return 0;
        }
        localbu.FtG = ((f.a.a.a.a)localObject1).NPN.readString();
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