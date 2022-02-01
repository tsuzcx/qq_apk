package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bt
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
  public int RHc;
  public String RHd;
  public long RHe;
  public cj RHf;
  public int RHg;
  public int RHh;
  public String RHi;
  public int RHj;
  public b RHk;
  public b RHl;
  public long RHm;
  public int RHn;
  public int RHo;
  public int RHp;
  public int RHq;
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
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.JFg != null) {
        paramVarArgs.f(2, this.JFg);
      }
      paramVarArgs.aY(3, this.RHc);
      if (this.RHd != null) {
        paramVarArgs.f(4, this.RHd);
      }
      paramVarArgs.aY(5, this.scene);
      if (this.ssid != null) {
        paramVarArgs.f(6, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.f(7, this.bssid);
      }
      paramVarArgs.bm(8, this.RHe);
      if (this.RHf != null)
      {
        paramVarArgs.oE(9, this.RHf.computeSize());
        this.RHf.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(10, this.RHg);
      paramVarArgs.aY(11, this.RHh);
      paramVarArgs.aY(12, this.source);
      if (this.RHi != null) {
        paramVarArgs.f(13, this.RHi);
      }
      paramVarArgs.aY(14, this.RHj);
      if (this.RHk != null) {
        paramVarArgs.c(15, this.RHk);
      }
      if (this.RHl != null) {
        paramVarArgs.c(16, this.RHl);
      }
      paramVarArgs.bm(17, this.RHm);
      if (this.JyL != null) {
        paramVarArgs.f(18, this.JyL);
      }
      if (this.RGY != null) {
        paramVarArgs.f(19, this.RGY);
      }
      if (this.RGZ != null) {
        paramVarArgs.f(20, this.RGZ);
      }
      paramVarArgs.aY(21, this.RHn);
      paramVarArgs.aY(22, this.RHo);
      paramVarArgs.aY(23, this.RHp);
      if (this.imei != null) {
        paramVarArgs.f(24, this.imei);
      }
      if (this.RGU != null) {
        paramVarArgs.f(25, this.RGU);
      }
      if (this.RGV != null) {
        paramVarArgs.f(26, this.RGV);
      }
      if (this.RGW != null) {
        paramVarArgs.f(27, this.RGW);
      }
      if (this.RGX != null) {
        paramVarArgs.f(28, this.RGX);
      }
      paramVarArgs.aY(29, this.RHq);
      AppMethodBeat.o(125693);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1890;
      }
    }
    label1890:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.JFg != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.JFg);
      }
      i += g.a.a.b.b.a.bM(3, this.RHc);
      paramInt = i;
      if (this.RHd != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RHd);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.scene);
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
      if (this.RHf != null) {
        paramInt = i + g.a.a.a.oD(9, this.RHf.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.RHg) + g.a.a.b.b.a.bM(11, this.RHh) + g.a.a.b.b.a.bM(12, this.source);
      paramInt = i;
      if (this.RHi != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.RHi);
      }
      i = paramInt + g.a.a.b.b.a.bM(14, this.RHj);
      paramInt = i;
      if (this.RHk != null) {
        paramInt = i + g.a.a.b.b.a.b(15, this.RHk);
      }
      i = paramInt;
      if (this.RHl != null) {
        i = paramInt + g.a.a.b.b.a.b(16, this.RHl);
      }
      i += g.a.a.b.b.a.p(17, this.RHm);
      paramInt = i;
      if (this.JyL != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.JyL);
      }
      i = paramInt;
      if (this.RGY != null) {
        i = paramInt + g.a.a.b.b.a.g(19, this.RGY);
      }
      paramInt = i;
      if (this.RGZ != null) {
        paramInt = i + g.a.a.b.b.a.g(20, this.RGZ);
      }
      i = paramInt + g.a.a.b.b.a.bM(21, this.RHn) + g.a.a.b.b.a.bM(22, this.RHo) + g.a.a.b.b.a.bM(23, this.RHp);
      paramInt = i;
      if (this.imei != null) {
        paramInt = i + g.a.a.b.b.a.g(24, this.imei);
      }
      i = paramInt;
      if (this.RGU != null) {
        i = paramInt + g.a.a.b.b.a.g(25, this.RGU);
      }
      paramInt = i;
      if (this.RGV != null) {
        paramInt = i + g.a.a.b.b.a.g(26, this.RGV);
      }
      i = paramInt;
      if (this.RGW != null) {
        i = paramInt + g.a.a.b.b.a.g(27, this.RGW);
      }
      paramInt = i;
      if (this.RGX != null) {
        paramInt = i + g.a.a.b.b.a.g(28, this.RGX);
      }
      i = g.a.a.b.b.a.bM(29, this.RHq);
      AppMethodBeat.o(125693);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125693);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bt localbt = (bt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125693);
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
            localbt.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125693);
          return 0;
        case 2: 
          localbt.JFg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 3: 
          localbt.RHc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125693);
          return 0;
        case 4: 
          localbt.RHd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 5: 
          localbt.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125693);
          return 0;
        case 6: 
          localbt.ssid = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 7: 
          localbt.bssid = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 8: 
          localbt.RHe = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125693);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cj)localObject2).parseFrom((byte[])localObject1);
            }
            localbt.RHf = ((cj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125693);
          return 0;
        case 10: 
          localbt.RHg = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125693);
          return 0;
        case 11: 
          localbt.RHh = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125693);
          return 0;
        case 12: 
          localbt.source = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125693);
          return 0;
        case 13: 
          localbt.RHi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 14: 
          localbt.RHj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125693);
          return 0;
        case 15: 
          localbt.RHk = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(125693);
          return 0;
        case 16: 
          localbt.RHl = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(125693);
          return 0;
        case 17: 
          localbt.RHm = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125693);
          return 0;
        case 18: 
          localbt.JyL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 19: 
          localbt.RGY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 20: 
          localbt.RGZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 21: 
          localbt.RHn = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125693);
          return 0;
        case 22: 
          localbt.RHo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125693);
          return 0;
        case 23: 
          localbt.RHp = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125693);
          return 0;
        case 24: 
          localbt.imei = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 25: 
          localbt.RGU = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 26: 
          localbt.RGV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 27: 
          localbt.RGW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 28: 
          localbt.RGX = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125693);
          return 0;
        }
        localbt.RHq = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125693);
        return 0;
      }
      AppMethodBeat.o(125693);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bt
 * JD-Core Version:    0.7.0.1
 */