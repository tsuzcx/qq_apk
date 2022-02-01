package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class on
  extends com.tencent.mm.cd.a
{
  public int RKb;
  public int RUK;
  public String RVH;
  public LinkedList<Integer> RVK;
  public int RVL;
  public int RVM;
  public int RVN;
  public int RVO;
  public int RVP;
  public int RVQ;
  public int RVR;
  public int RVS;
  public int RVT;
  public int RVU;
  public int RVV;
  public int RVW;
  public String RVX;
  public long RVY;
  public int RVZ;
  public int RWa;
  public int RWb;
  public int RWc;
  public int RWd;
  public int RWe;
  public int RWf;
  public long RWg;
  public String RWh;
  public int RWi;
  public String RWj;
  public String RWk;
  public int RWl;
  public String RWm;
  public int RWn;
  public String RWo;
  public String RWp;
  public int RWq;
  public int RWr;
  public String RWs;
  public long RWt;
  public int RWu;
  public String RWv;
  public String aid;
  public int cancel;
  public String event;
  public String fUL;
  public long fxU;
  public int msg_type;
  public int pos;
  public int qJt;
  public int style;
  public String tpe;
  public String traceid;
  public int weight;
  public String zaX;
  
  public on()
  {
    AppMethodBeat.i(6398);
    this.RVK = new LinkedList();
    this.qJt = 0;
    AppMethodBeat.o(6398);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6399);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RVH != null) {
        paramVarArgs.f(1, this.RVH);
      }
      paramVarArgs.bm(2, this.fxU);
      paramVarArgs.aY(3, this.pos);
      paramVarArgs.e(4, 2, this.RVK);
      paramVarArgs.aY(5, this.RVL);
      paramVarArgs.aY(6, this.RVM);
      paramVarArgs.aY(7, this.RVN);
      paramVarArgs.aY(8, this.RVO);
      paramVarArgs.aY(9, this.RVP);
      paramVarArgs.aY(10, this.RVQ);
      paramVarArgs.aY(11, this.RUK);
      paramVarArgs.aY(12, this.RVR);
      paramVarArgs.aY(13, this.RVS);
      paramVarArgs.aY(14, this.cancel);
      paramVarArgs.aY(15, this.RVT);
      paramVarArgs.aY(16, this.RVU);
      paramVarArgs.aY(17, this.RVV);
      paramVarArgs.aY(18, this.RVW);
      paramVarArgs.aY(19, this.msg_type);
      if (this.RVX != null) {
        paramVarArgs.f(20, this.RVX);
      }
      paramVarArgs.bm(21, this.RVY);
      paramVarArgs.aY(22, this.RVZ);
      paramVarArgs.aY(23, this.RWa);
      paramVarArgs.aY(24, this.RWb);
      paramVarArgs.aY(25, this.RWc);
      paramVarArgs.aY(26, this.RWd);
      paramVarArgs.aY(27, this.RWe);
      paramVarArgs.aY(28, this.RWf);
      paramVarArgs.aY(29, this.qJt);
      paramVarArgs.bm(30, this.RWg);
      if (this.RWh != null) {
        paramVarArgs.f(31, this.RWh);
      }
      paramVarArgs.aY(32, this.RWi);
      paramVarArgs.aY(33, this.weight);
      if (this.RWj != null) {
        paramVarArgs.f(34, this.RWj);
      }
      paramVarArgs.aY(35, this.style);
      if (this.RWk != null) {
        paramVarArgs.f(36, this.RWk);
      }
      if (this.event != null) {
        paramVarArgs.f(37, this.event);
      }
      if (this.fUL != null) {
        paramVarArgs.f(38, this.fUL);
      }
      paramVarArgs.aY(39, this.RWl);
      if (this.RWm != null) {
        paramVarArgs.f(40, this.RWm);
      }
      if (this.aid != null) {
        paramVarArgs.f(41, this.aid);
      }
      if (this.traceid != null) {
        paramVarArgs.f(42, this.traceid);
      }
      paramVarArgs.aY(43, this.RWn);
      if (this.zaX != null) {
        paramVarArgs.f(44, this.zaX);
      }
      if (this.RWo != null) {
        paramVarArgs.f(45, this.RWo);
      }
      if (this.RWp != null) {
        paramVarArgs.f(46, this.RWp);
      }
      paramVarArgs.aY(47, this.RWq);
      paramVarArgs.aY(48, this.RWr);
      if (this.tpe != null) {
        paramVarArgs.f(49, this.tpe);
      }
      if (this.RWs != null) {
        paramVarArgs.f(50, this.RWs);
      }
      paramVarArgs.bm(51, this.RWt);
      paramVarArgs.aY(52, this.RWu);
      paramVarArgs.aY(53, this.RKb);
      if (this.RWv != null) {
        paramVarArgs.f(54, this.RWv);
      }
      AppMethodBeat.o(6399);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RVH == null) {
        break label2901;
      }
    }
    label2901:
    for (paramInt = g.a.a.b.b.a.g(1, this.RVH) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.fxU) + g.a.a.b.b.a.bM(3, this.pos) + g.a.a.a.c(4, 2, this.RVK) + g.a.a.b.b.a.bM(5, this.RVL) + g.a.a.b.b.a.bM(6, this.RVM) + g.a.a.b.b.a.bM(7, this.RVN) + g.a.a.b.b.a.bM(8, this.RVO) + g.a.a.b.b.a.bM(9, this.RVP) + g.a.a.b.b.a.bM(10, this.RVQ) + g.a.a.b.b.a.bM(11, this.RUK) + g.a.a.b.b.a.bM(12, this.RVR) + g.a.a.b.b.a.bM(13, this.RVS) + g.a.a.b.b.a.bM(14, this.cancel) + g.a.a.b.b.a.bM(15, this.RVT) + g.a.a.b.b.a.bM(16, this.RVU) + g.a.a.b.b.a.bM(17, this.RVV) + g.a.a.b.b.a.bM(18, this.RVW) + g.a.a.b.b.a.bM(19, this.msg_type);
      paramInt = i;
      if (this.RVX != null) {
        paramInt = i + g.a.a.b.b.a.g(20, this.RVX);
      }
      i = paramInt + g.a.a.b.b.a.p(21, this.RVY) + g.a.a.b.b.a.bM(22, this.RVZ) + g.a.a.b.b.a.bM(23, this.RWa) + g.a.a.b.b.a.bM(24, this.RWb) + g.a.a.b.b.a.bM(25, this.RWc) + g.a.a.b.b.a.bM(26, this.RWd) + g.a.a.b.b.a.bM(27, this.RWe) + g.a.a.b.b.a.bM(28, this.RWf) + g.a.a.b.b.a.bM(29, this.qJt) + g.a.a.b.b.a.p(30, this.RWg);
      paramInt = i;
      if (this.RWh != null) {
        paramInt = i + g.a.a.b.b.a.g(31, this.RWh);
      }
      i = paramInt + g.a.a.b.b.a.bM(32, this.RWi) + g.a.a.b.b.a.bM(33, this.weight);
      paramInt = i;
      if (this.RWj != null) {
        paramInt = i + g.a.a.b.b.a.g(34, this.RWj);
      }
      i = paramInt + g.a.a.b.b.a.bM(35, this.style);
      paramInt = i;
      if (this.RWk != null) {
        paramInt = i + g.a.a.b.b.a.g(36, this.RWk);
      }
      i = paramInt;
      if (this.event != null) {
        i = paramInt + g.a.a.b.b.a.g(37, this.event);
      }
      paramInt = i;
      if (this.fUL != null) {
        paramInt = i + g.a.a.b.b.a.g(38, this.fUL);
      }
      i = paramInt + g.a.a.b.b.a.bM(39, this.RWl);
      paramInt = i;
      if (this.RWm != null) {
        paramInt = i + g.a.a.b.b.a.g(40, this.RWm);
      }
      i = paramInt;
      if (this.aid != null) {
        i = paramInt + g.a.a.b.b.a.g(41, this.aid);
      }
      paramInt = i;
      if (this.traceid != null) {
        paramInt = i + g.a.a.b.b.a.g(42, this.traceid);
      }
      i = paramInt + g.a.a.b.b.a.bM(43, this.RWn);
      paramInt = i;
      if (this.zaX != null) {
        paramInt = i + g.a.a.b.b.a.g(44, this.zaX);
      }
      i = paramInt;
      if (this.RWo != null) {
        i = paramInt + g.a.a.b.b.a.g(45, this.RWo);
      }
      paramInt = i;
      if (this.RWp != null) {
        paramInt = i + g.a.a.b.b.a.g(46, this.RWp);
      }
      i = paramInt + g.a.a.b.b.a.bM(47, this.RWq) + g.a.a.b.b.a.bM(48, this.RWr);
      paramInt = i;
      if (this.tpe != null) {
        paramInt = i + g.a.a.b.b.a.g(49, this.tpe);
      }
      i = paramInt;
      if (this.RWs != null) {
        i = paramInt + g.a.a.b.b.a.g(50, this.RWs);
      }
      i = i + g.a.a.b.b.a.p(51, this.RWt) + g.a.a.b.b.a.bM(52, this.RWu) + g.a.a.b.b.a.bM(53, this.RKb);
      paramInt = i;
      if (this.RWv != null) {
        paramInt = i + g.a.a.b.b.a.g(54, this.RWv);
      }
      AppMethodBeat.o(6399);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RVK.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(6399);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        on localon = (on)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6399);
          return -1;
        case 1: 
          localon.RVH = locala.abFh.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 2: 
          localon.fxU = locala.abFh.AN();
          AppMethodBeat.o(6399);
          return 0;
        case 3: 
          localon.pos = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 4: 
          localon.RVK.add(Integer.valueOf(locala.abFh.AK()));
          AppMethodBeat.o(6399);
          return 0;
        case 5: 
          localon.RVL = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 6: 
          localon.RVM = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 7: 
          localon.RVN = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 8: 
          localon.RVO = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 9: 
          localon.RVP = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 10: 
          localon.RVQ = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 11: 
          localon.RUK = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 12: 
          localon.RVR = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 13: 
          localon.RVS = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 14: 
          localon.cancel = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 15: 
          localon.RVT = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 16: 
          localon.RVU = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 17: 
          localon.RVV = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 18: 
          localon.RVW = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 19: 
          localon.msg_type = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 20: 
          localon.RVX = locala.abFh.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 21: 
          localon.RVY = locala.abFh.AN();
          AppMethodBeat.o(6399);
          return 0;
        case 22: 
          localon.RVZ = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 23: 
          localon.RWa = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 24: 
          localon.RWb = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 25: 
          localon.RWc = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 26: 
          localon.RWd = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 27: 
          localon.RWe = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 28: 
          localon.RWf = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 29: 
          localon.qJt = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 30: 
          localon.RWg = locala.abFh.AN();
          AppMethodBeat.o(6399);
          return 0;
        case 31: 
          localon.RWh = locala.abFh.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 32: 
          localon.RWi = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 33: 
          localon.weight = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 34: 
          localon.RWj = locala.abFh.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 35: 
          localon.style = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 36: 
          localon.RWk = locala.abFh.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 37: 
          localon.event = locala.abFh.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 38: 
          localon.fUL = locala.abFh.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 39: 
          localon.RWl = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 40: 
          localon.RWm = locala.abFh.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 41: 
          localon.aid = locala.abFh.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 42: 
          localon.traceid = locala.abFh.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 43: 
          localon.RWn = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 44: 
          localon.zaX = locala.abFh.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 45: 
          localon.RWo = locala.abFh.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 46: 
          localon.RWp = locala.abFh.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 47: 
          localon.RWq = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 48: 
          localon.RWr = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 49: 
          localon.tpe = locala.abFh.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 50: 
          localon.RWs = locala.abFh.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 51: 
          localon.RWt = locala.abFh.AN();
          AppMethodBeat.o(6399);
          return 0;
        case 52: 
          localon.RWu = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        case 53: 
          localon.RKb = locala.abFh.AK();
          AppMethodBeat.o(6399);
          return 0;
        }
        localon.RWv = locala.abFh.readString();
        AppMethodBeat.o(6399);
        return 0;
      }
      AppMethodBeat.o(6399);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.on
 * JD-Core Version:    0.7.0.1
 */