package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bp
  extends cvc
{
  public String FtD;
  public String FtE;
  public String FtF;
  public String FtG;
  public String FtH;
  public String FtI;
  public int FtK;
  public String FtL;
  public long FtM;
  public cb FtN;
  public int FtO;
  public int FtP;
  public String FtQ;
  public int FtR;
  public b FtS;
  public b FtT;
  public long FtU;
  public int FtV;
  public int FtW;
  public int FtX;
  public String bssid;
  public int dnh;
  public String imei;
  public int scene;
  public String ssid;
  public String yWM;
  public String yYY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125693);
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
      paramVarArgs.aS(3, this.FtK);
      if (this.FtL != null) {
        paramVarArgs.d(4, this.FtL);
      }
      paramVarArgs.aS(5, this.scene);
      if (this.ssid != null) {
        paramVarArgs.d(6, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.d(7, this.bssid);
      }
      paramVarArgs.aY(8, this.FtM);
      if (this.FtN != null)
      {
        paramVarArgs.lC(9, this.FtN.computeSize());
        this.FtN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(10, this.FtO);
      paramVarArgs.aS(11, this.FtP);
      paramVarArgs.aS(12, this.dnh);
      if (this.FtQ != null) {
        paramVarArgs.d(13, this.FtQ);
      }
      paramVarArgs.aS(14, this.FtR);
      if (this.FtS != null) {
        paramVarArgs.c(15, this.FtS);
      }
      if (this.FtT != null) {
        paramVarArgs.c(16, this.FtT);
      }
      paramVarArgs.aY(17, this.FtU);
      if (this.yWM != null) {
        paramVarArgs.d(18, this.yWM);
      }
      if (this.FtH != null) {
        paramVarArgs.d(19, this.FtH);
      }
      if (this.FtI != null) {
        paramVarArgs.d(20, this.FtI);
      }
      paramVarArgs.aS(21, this.FtV);
      paramVarArgs.aS(22, this.FtW);
      paramVarArgs.aS(23, this.FtX);
      if (this.imei != null) {
        paramVarArgs.d(24, this.imei);
      }
      if (this.FtD != null) {
        paramVarArgs.d(25, this.FtD);
      }
      if (this.FtE != null) {
        paramVarArgs.d(26, this.FtE);
      }
      if (this.FtF != null) {
        paramVarArgs.d(27, this.FtF);
      }
      if (this.FtG != null) {
        paramVarArgs.d(28, this.FtG);
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
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.yYY != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.yYY);
      }
      i += f.a.a.b.b.a.bz(3, this.FtK);
      paramInt = i;
      if (this.FtL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FtL);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.scene);
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
      if (this.FtN != null) {
        paramInt = i + f.a.a.a.lB(9, this.FtN.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.FtO) + f.a.a.b.b.a.bz(11, this.FtP) + f.a.a.b.b.a.bz(12, this.dnh);
      paramInt = i;
      if (this.FtQ != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FtQ);
      }
      i = paramInt + f.a.a.b.b.a.bz(14, this.FtR);
      paramInt = i;
      if (this.FtS != null) {
        paramInt = i + f.a.a.b.b.a.b(15, this.FtS);
      }
      i = paramInt;
      if (this.FtT != null) {
        i = paramInt + f.a.a.b.b.a.b(16, this.FtT);
      }
      i += f.a.a.b.b.a.p(17, this.FtU);
      paramInt = i;
      if (this.yWM != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.yWM);
      }
      i = paramInt;
      if (this.FtH != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.FtH);
      }
      paramInt = i;
      if (this.FtI != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.FtI);
      }
      i = paramInt + f.a.a.b.b.a.bz(21, this.FtV) + f.a.a.b.b.a.bz(22, this.FtW) + f.a.a.b.b.a.bz(23, this.FtX);
      paramInt = i;
      if (this.imei != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.imei);
      }
      i = paramInt;
      if (this.FtD != null) {
        i = paramInt + f.a.a.b.b.a.e(25, this.FtD);
      }
      paramInt = i;
      if (this.FtE != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.FtE);
      }
      i = paramInt;
      if (this.FtF != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.FtF);
      }
      paramInt = i;
      if (this.FtG != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.FtG);
      }
      AppMethodBeat.o(125693);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125693);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bp localbp = (bp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125693);
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
            localbp.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125693);
          return 0;
        case 2: 
          localbp.yYY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 3: 
          localbp.FtK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125693);
          return 0;
        case 4: 
          localbp.FtL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 5: 
          localbp.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125693);
          return 0;
        case 6: 
          localbp.ssid = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 7: 
          localbp.bssid = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 8: 
          localbp.FtM = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125693);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbp.FtN = ((cb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125693);
          return 0;
        case 10: 
          localbp.FtO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125693);
          return 0;
        case 11: 
          localbp.FtP = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125693);
          return 0;
        case 12: 
          localbp.dnh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125693);
          return 0;
        case 13: 
          localbp.FtQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 14: 
          localbp.FtR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125693);
          return 0;
        case 15: 
          localbp.FtS = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(125693);
          return 0;
        case 16: 
          localbp.FtT = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(125693);
          return 0;
        case 17: 
          localbp.FtU = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125693);
          return 0;
        case 18: 
          localbp.yWM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 19: 
          localbp.FtH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 20: 
          localbp.FtI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 21: 
          localbp.FtV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125693);
          return 0;
        case 22: 
          localbp.FtW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125693);
          return 0;
        case 23: 
          localbp.FtX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125693);
          return 0;
        case 24: 
          localbp.imei = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 25: 
          localbp.FtD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 26: 
          localbp.FtE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 27: 
          localbp.FtF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125693);
          return 0;
        }
        localbp.FtG = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125693);
        return 0;
      }
      AppMethodBeat.o(125693);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bp
 * JD-Core Version:    0.7.0.1
 */