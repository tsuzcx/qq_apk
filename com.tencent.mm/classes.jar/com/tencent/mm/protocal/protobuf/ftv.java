package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ftv
  extends erp
{
  public int IIs;
  public String Md5;
  public int NkN;
  public int NkO;
  public int NkP;
  public gol NkQ;
  public String YCm;
  public String YCn;
  public String YCo;
  public etl YFE;
  public etl YFF;
  public String YFJ;
  public String ZaN;
  public int ZaO;
  public int ZaP;
  public int ZaQ;
  public String ZaR;
  public int ZkT;
  public int ZtS;
  public String aaGp;
  public int aaWH;
  public int aava;
  public int abFB;
  public etl abRT;
  public String abRU;
  public String abRV;
  public int abRW;
  public int abRX;
  public String abRY;
  public String abge;
  public int abzD;
  public int abzE;
  public int abzF;
  public int abzb;
  public String oOI;
  public String oOL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152719);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abRT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientImgId");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.YFE == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.YFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.NkQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abRT != null)
      {
        paramVarArgs.qD(2, this.abRT.computeSize());
        this.abRT.writeFields(paramVarArgs);
      }
      if (this.YFE != null)
      {
        paramVarArgs.qD(3, this.YFE.computeSize());
        this.YFE.writeFields(paramVarArgs);
      }
      if (this.YFF != null)
      {
        paramVarArgs.qD(4, this.YFF.computeSize());
        this.YFF.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.NkN);
      paramVarArgs.bS(6, this.NkO);
      paramVarArgs.bS(7, this.NkP);
      if (this.NkQ != null)
      {
        paramVarArgs.qD(8, this.NkQ.computeSize());
        this.NkQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(9, this.IIs);
      if (this.YFJ != null) {
        paramVarArgs.g(10, this.YFJ);
      }
      paramVarArgs.bS(11, this.aava);
      paramVarArgs.bS(12, this.ZkT);
      paramVarArgs.bS(13, this.abFB);
      if (this.oOL != null) {
        paramVarArgs.g(14, this.oOL);
      }
      if (this.abRU != null) {
        paramVarArgs.g(15, this.abRU);
      }
      if (this.abRV != null) {
        paramVarArgs.g(16, this.abRV);
      }
      if (this.ZaN != null) {
        paramVarArgs.g(17, this.ZaN);
      }
      paramVarArgs.bS(18, this.ZaO);
      paramVarArgs.bS(19, this.abRW);
      paramVarArgs.bS(20, this.abRX);
      if (this.abRY != null) {
        paramVarArgs.g(21, this.abRY);
      }
      paramVarArgs.bS(22, this.abzD);
      paramVarArgs.bS(23, this.abzE);
      paramVarArgs.bS(24, this.abzF);
      if (this.aaGp != null) {
        paramVarArgs.g(25, this.aaGp);
      }
      paramVarArgs.bS(26, this.ZtS);
      if (this.Md5 != null) {
        paramVarArgs.g(27, this.Md5);
      }
      paramVarArgs.bS(28, this.ZaP);
      paramVarArgs.bS(29, this.ZaQ);
      paramVarArgs.bS(30, this.abzb);
      if (this.oOI != null) {
        paramVarArgs.g(31, this.oOI);
      }
      if (this.YCo != null) {
        paramVarArgs.g(32, this.YCo);
      }
      if (this.YCn != null) {
        paramVarArgs.g(33, this.YCn);
      }
      if (this.YCm != null) {
        paramVarArgs.g(34, this.YCm);
      }
      if (this.ZaR != null) {
        paramVarArgs.g(35, this.ZaR);
      }
      paramVarArgs.bS(36, this.aaWH);
      if (this.abge != null) {
        paramVarArgs.g(37, this.abge);
      }
      AppMethodBeat.o(152719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2680;
      }
    }
    label2680:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abRT != null) {
        paramInt = i + i.a.a.a.qC(2, this.abRT.computeSize());
      }
      i = paramInt;
      if (this.YFE != null) {
        i = paramInt + i.a.a.a.qC(3, this.YFE.computeSize());
      }
      paramInt = i;
      if (this.YFF != null) {
        paramInt = i + i.a.a.a.qC(4, this.YFF.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.NkN) + i.a.a.b.b.a.cJ(6, this.NkO) + i.a.a.b.b.a.cJ(7, this.NkP);
      paramInt = i;
      if (this.NkQ != null) {
        paramInt = i + i.a.a.a.qC(8, this.NkQ.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.IIs);
      paramInt = i;
      if (this.YFJ != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.YFJ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.aava) + i.a.a.b.b.a.cJ(12, this.ZkT) + i.a.a.b.b.a.cJ(13, this.abFB);
      paramInt = i;
      if (this.oOL != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.oOL);
      }
      i = paramInt;
      if (this.abRU != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.abRU);
      }
      paramInt = i;
      if (this.abRV != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.abRV);
      }
      i = paramInt;
      if (this.ZaN != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.ZaN);
      }
      i = i + i.a.a.b.b.a.cJ(18, this.ZaO) + i.a.a.b.b.a.cJ(19, this.abRW) + i.a.a.b.b.a.cJ(20, this.abRX);
      paramInt = i;
      if (this.abRY != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.abRY);
      }
      i = paramInt + i.a.a.b.b.a.cJ(22, this.abzD) + i.a.a.b.b.a.cJ(23, this.abzE) + i.a.a.b.b.a.cJ(24, this.abzF);
      paramInt = i;
      if (this.aaGp != null) {
        paramInt = i + i.a.a.b.b.a.h(25, this.aaGp);
      }
      i = paramInt + i.a.a.b.b.a.cJ(26, this.ZtS);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + i.a.a.b.b.a.h(27, this.Md5);
      }
      i = paramInt + i.a.a.b.b.a.cJ(28, this.ZaP) + i.a.a.b.b.a.cJ(29, this.ZaQ) + i.a.a.b.b.a.cJ(30, this.abzb);
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(31, this.oOI);
      }
      i = paramInt;
      if (this.YCo != null) {
        i = paramInt + i.a.a.b.b.a.h(32, this.YCo);
      }
      paramInt = i;
      if (this.YCn != null) {
        paramInt = i + i.a.a.b.b.a.h(33, this.YCn);
      }
      i = paramInt;
      if (this.YCm != null) {
        i = paramInt + i.a.a.b.b.a.h(34, this.YCm);
      }
      paramInt = i;
      if (this.ZaR != null) {
        paramInt = i + i.a.a.b.b.a.h(35, this.ZaR);
      }
      i = paramInt + i.a.a.b.b.a.cJ(36, this.aaWH);
      paramInt = i;
      if (this.abge != null) {
        paramInt = i + i.a.a.b.b.a.h(37, this.abge);
      }
      AppMethodBeat.o(152719);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abRT == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientImgId");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.YFE == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.YFF == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.NkQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152719);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ftv localftv = (ftv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152719);
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
            localftv.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localftv.abRT = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localftv.YFE = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localftv.YFF = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 5: 
          localftv.NkN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152719);
          return 0;
        case 6: 
          localftv.NkO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152719);
          return 0;
        case 7: 
          localftv.NkP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152719);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localftv.NkQ = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 9: 
          localftv.IIs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152719);
          return 0;
        case 10: 
          localftv.YFJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 11: 
          localftv.aava = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152719);
          return 0;
        case 12: 
          localftv.ZkT = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152719);
          return 0;
        case 13: 
          localftv.abFB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152719);
          return 0;
        case 14: 
          localftv.oOL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 15: 
          localftv.abRU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 16: 
          localftv.abRV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 17: 
          localftv.ZaN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 18: 
          localftv.ZaO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152719);
          return 0;
        case 19: 
          localftv.abRW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152719);
          return 0;
        case 20: 
          localftv.abRX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152719);
          return 0;
        case 21: 
          localftv.abRY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 22: 
          localftv.abzD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152719);
          return 0;
        case 23: 
          localftv.abzE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152719);
          return 0;
        case 24: 
          localftv.abzF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152719);
          return 0;
        case 25: 
          localftv.aaGp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 26: 
          localftv.ZtS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152719);
          return 0;
        case 27: 
          localftv.Md5 = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 28: 
          localftv.ZaP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152719);
          return 0;
        case 29: 
          localftv.ZaQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152719);
          return 0;
        case 30: 
          localftv.abzb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152719);
          return 0;
        case 31: 
          localftv.oOI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 32: 
          localftv.YCo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 33: 
          localftv.YCn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 34: 
          localftv.YCm = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 35: 
          localftv.ZaR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 36: 
          localftv.aaWH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152719);
          return 0;
        }
        localftv.abge = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(152719);
        return 0;
      }
      AppMethodBeat.o(152719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ftv
 * JD-Core Version:    0.7.0.1
 */