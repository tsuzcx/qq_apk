package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cd
  extends erp
{
  public String PNk;
  public int PUQ;
  public String PWh;
  public String YDW;
  public String YDX;
  public String YDY;
  public String YDZ;
  public String YEa;
  public String YEb;
  public int YEd;
  public String YEe;
  public long YEf;
  public ct YEg;
  public int YEh;
  public int YEi;
  public String YEj;
  public int YEk;
  public b YEl;
  public b YEm;
  public long YEn;
  public int YEo;
  public int YEp;
  public int YEq;
  public int YEr;
  public int YEs;
  public int YEt;
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
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.PWh != null) {
        paramVarArgs.g(2, this.PWh);
      }
      paramVarArgs.bS(3, this.YEd);
      if (this.YEe != null) {
        paramVarArgs.g(4, this.YEe);
      }
      paramVarArgs.bS(5, this.scene);
      if (this.ssid != null) {
        paramVarArgs.g(6, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.g(7, this.bssid);
      }
      paramVarArgs.bv(8, this.YEf);
      if (this.YEg != null)
      {
        paramVarArgs.qD(9, this.YEg.computeSize());
        this.YEg.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(10, this.YEh);
      paramVarArgs.bS(11, this.YEi);
      paramVarArgs.bS(12, this.source);
      if (this.YEj != null) {
        paramVarArgs.g(13, this.YEj);
      }
      paramVarArgs.bS(14, this.YEk);
      if (this.YEl != null) {
        paramVarArgs.d(15, this.YEl);
      }
      if (this.YEm != null) {
        paramVarArgs.d(16, this.YEm);
      }
      paramVarArgs.bv(17, this.YEn);
      if (this.PNk != null) {
        paramVarArgs.g(18, this.PNk);
      }
      if (this.YEa != null) {
        paramVarArgs.g(19, this.YEa);
      }
      if (this.YEb != null) {
        paramVarArgs.g(20, this.YEb);
      }
      paramVarArgs.bS(21, this.YEo);
      paramVarArgs.bS(22, this.YEp);
      paramVarArgs.bS(23, this.YEq);
      if (this.imei != null) {
        paramVarArgs.g(24, this.imei);
      }
      if (this.YDW != null) {
        paramVarArgs.g(25, this.YDW);
      }
      if (this.YDX != null) {
        paramVarArgs.g(26, this.YDX);
      }
      if (this.YDY != null) {
        paramVarArgs.g(27, this.YDY);
      }
      if (this.YDZ != null) {
        paramVarArgs.g(28, this.YDZ);
      }
      paramVarArgs.bS(29, this.YEr);
      paramVarArgs.bS(30, this.YEs);
      paramVarArgs.bS(31, this.YEt);
      paramVarArgs.bS(32, this.PUQ);
      AppMethodBeat.o(125693);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2030;
      }
    }
    label2030:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.PWh != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.PWh);
      }
      i += i.a.a.b.b.a.cJ(3, this.YEd);
      paramInt = i;
      if (this.YEe != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YEe);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.scene);
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
      if (this.YEg != null) {
        paramInt = i + i.a.a.a.qC(9, this.YEg.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.YEh) + i.a.a.b.b.a.cJ(11, this.YEi) + i.a.a.b.b.a.cJ(12, this.source);
      paramInt = i;
      if (this.YEj != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.YEj);
      }
      i = paramInt + i.a.a.b.b.a.cJ(14, this.YEk);
      paramInt = i;
      if (this.YEl != null) {
        paramInt = i + i.a.a.b.b.a.c(15, this.YEl);
      }
      i = paramInt;
      if (this.YEm != null) {
        i = paramInt + i.a.a.b.b.a.c(16, this.YEm);
      }
      i += i.a.a.b.b.a.q(17, this.YEn);
      paramInt = i;
      if (this.PNk != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.PNk);
      }
      i = paramInt;
      if (this.YEa != null) {
        i = paramInt + i.a.a.b.b.a.h(19, this.YEa);
      }
      paramInt = i;
      if (this.YEb != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.YEb);
      }
      i = paramInt + i.a.a.b.b.a.cJ(21, this.YEo) + i.a.a.b.b.a.cJ(22, this.YEp) + i.a.a.b.b.a.cJ(23, this.YEq);
      paramInt = i;
      if (this.imei != null) {
        paramInt = i + i.a.a.b.b.a.h(24, this.imei);
      }
      i = paramInt;
      if (this.YDW != null) {
        i = paramInt + i.a.a.b.b.a.h(25, this.YDW);
      }
      paramInt = i;
      if (this.YDX != null) {
        paramInt = i + i.a.a.b.b.a.h(26, this.YDX);
      }
      i = paramInt;
      if (this.YDY != null) {
        i = paramInt + i.a.a.b.b.a.h(27, this.YDY);
      }
      paramInt = i;
      if (this.YDZ != null) {
        paramInt = i + i.a.a.b.b.a.h(28, this.YDZ);
      }
      i = i.a.a.b.b.a.cJ(29, this.YEr);
      int j = i.a.a.b.b.a.cJ(30, this.YEs);
      int k = i.a.a.b.b.a.cJ(31, this.YEt);
      int m = i.a.a.b.b.a.cJ(32, this.PUQ);
      AppMethodBeat.o(125693);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125693);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cd localcd = (cd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125693);
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
            localcd.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125693);
          return 0;
        case 2: 
          localcd.PWh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 3: 
          localcd.YEd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125693);
          return 0;
        case 4: 
          localcd.YEe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 5: 
          localcd.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125693);
          return 0;
        case 6: 
          localcd.ssid = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 7: 
          localcd.bssid = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 8: 
          localcd.YEf = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125693);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ct();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ct)localObject2).parseFrom((byte[])localObject1);
            }
            localcd.YEg = ((ct)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125693);
          return 0;
        case 10: 
          localcd.YEh = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125693);
          return 0;
        case 11: 
          localcd.YEi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125693);
          return 0;
        case 12: 
          localcd.source = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125693);
          return 0;
        case 13: 
          localcd.YEj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 14: 
          localcd.YEk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125693);
          return 0;
        case 15: 
          localcd.YEl = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(125693);
          return 0;
        case 16: 
          localcd.YEm = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(125693);
          return 0;
        case 17: 
          localcd.YEn = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125693);
          return 0;
        case 18: 
          localcd.PNk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 19: 
          localcd.YEa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 20: 
          localcd.YEb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 21: 
          localcd.YEo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125693);
          return 0;
        case 22: 
          localcd.YEp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125693);
          return 0;
        case 23: 
          localcd.YEq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125693);
          return 0;
        case 24: 
          localcd.imei = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 25: 
          localcd.YDW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 26: 
          localcd.YDX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 27: 
          localcd.YDY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 28: 
          localcd.YDZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 29: 
          localcd.YEr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125693);
          return 0;
        case 30: 
          localcd.YEs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125693);
          return 0;
        case 31: 
          localcd.YEt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125693);
          return 0;
        }
        localcd.PUQ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125693);
        return 0;
      }
      AppMethodBeat.o(125693);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cd
 * JD-Core Version:    0.7.0.1
 */