package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpa
  extends com.tencent.mm.bw.a
{
  public int AjG;
  public String DTI;
  public String DTJ;
  public String DTK;
  public String DTL;
  public String DTM;
  public LinkedList<aaj> DTg;
  public int HWA;
  public dot HWB;
  public String HWg;
  public long HWh;
  public String HWi;
  public String HWj;
  public int HWk;
  public String HWl;
  public String HWm;
  public long HWn;
  public long HWo;
  public LinkedList<dpc> HWp;
  public int HWq;
  public long HWr;
  public dov HWs;
  public int HWt;
  public int HWu;
  public boolean HWv;
  public String HWw;
  public doy HWx;
  public int HWy;
  public dpa HWz;
  public String dJL;
  public long dmg;
  public boolean dnq;
  public String qlv;
  public String qlw;
  public String source;
  public String tFc;
  public int thumbHeight;
  public int thumbWidth;
  public long timestamp;
  public String title;
  public LinkedList<dfc> uda;
  public String udb;
  public String uly;
  public String videoUrl;
  
  public dpa()
  {
    AppMethodBeat.i(153012);
    this.uda = new LinkedList();
    this.HWp = new LinkedList();
    this.DTg = new LinkedList();
    AppMethodBeat.o(153012);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153013);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.videoUrl != null) {
        paramVarArgs.d(2, this.videoUrl);
      }
      if (this.HWg != null) {
        paramVarArgs.d(3, this.HWg);
      }
      paramVarArgs.aS(4, this.AjG);
      if (this.udb != null) {
        paramVarArgs.d(5, this.udb);
      }
      paramVarArgs.aS(6, this.thumbWidth);
      paramVarArgs.aS(7, this.thumbHeight);
      if (this.qlv != null) {
        paramVarArgs.d(8, this.qlv);
      }
      if (this.qlw != null) {
        paramVarArgs.d(9, this.qlw);
      }
      if (this.uly != null) {
        paramVarArgs.d(10, this.uly);
      }
      if (this.DTI != null) {
        paramVarArgs.d(11, this.DTI);
      }
      if (this.DTJ != null) {
        paramVarArgs.d(12, this.DTJ);
      }
      if (this.DTK != null) {
        paramVarArgs.d(13, this.DTK);
      }
      if (this.source != null) {
        paramVarArgs.d(14, this.source);
      }
      if (this.dJL != null) {
        paramVarArgs.d(15, this.dJL);
      }
      paramVarArgs.aZ(16, this.HWh);
      if (this.HWi != null) {
        paramVarArgs.d(17, this.HWi);
      }
      if (this.HWj != null) {
        paramVarArgs.d(18, this.HWj);
      }
      if (this.DTL != null) {
        paramVarArgs.d(19, this.DTL);
      }
      if (this.DTM != null) {
        paramVarArgs.d(20, this.DTM);
      }
      paramVarArgs.aS(21, this.HWk);
      if (this.HWl != null) {
        paramVarArgs.d(22, this.HWl);
      }
      if (this.HWm != null) {
        paramVarArgs.d(23, this.HWm);
      }
      paramVarArgs.e(24, 8, this.uda);
      paramVarArgs.aZ(25, this.timestamp);
      paramVarArgs.bC(26, this.dnq);
      if (this.tFc != null) {
        paramVarArgs.d(27, this.tFc);
      }
      paramVarArgs.aZ(28, this.HWn);
      paramVarArgs.aZ(29, this.dmg);
      paramVarArgs.aZ(30, this.HWo);
      paramVarArgs.e(31, 8, this.HWp);
      paramVarArgs.aS(32, this.HWq);
      paramVarArgs.aZ(33, this.HWr);
      if (this.HWs != null)
      {
        paramVarArgs.lJ(34, this.HWs.computeSize());
        this.HWs.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(35, this.HWt);
      paramVarArgs.aS(36, this.HWu);
      paramVarArgs.bC(37, this.HWv);
      if (this.HWw != null) {
        paramVarArgs.d(38, this.HWw);
      }
      if (this.HWx != null)
      {
        paramVarArgs.lJ(39, this.HWx.computeSize());
        this.HWx.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(40, this.HWy);
      if (this.HWz != null)
      {
        paramVarArgs.lJ(41, this.HWz.computeSize());
        this.HWz.writeFields(paramVarArgs);
      }
      paramVarArgs.e(42, 8, this.DTg);
      paramVarArgs.aS(43, this.HWA);
      if (this.HWB != null)
      {
        paramVarArgs.lJ(44, this.HWB.computeSize());
        this.HWB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153013);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label3186;
      }
    }
    label3186:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.videoUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.videoUrl);
      }
      i = paramInt;
      if (this.HWg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HWg);
      }
      i += f.a.a.b.b.a.bz(4, this.AjG);
      paramInt = i;
      if (this.udb != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.udb);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.thumbWidth) + f.a.a.b.b.a.bz(7, this.thumbHeight);
      paramInt = i;
      if (this.qlv != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.qlv);
      }
      i = paramInt;
      if (this.qlw != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.qlw);
      }
      paramInt = i;
      if (this.uly != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.uly);
      }
      i = paramInt;
      if (this.DTI != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.DTI);
      }
      paramInt = i;
      if (this.DTJ != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DTJ);
      }
      i = paramInt;
      if (this.DTK != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.DTK);
      }
      paramInt = i;
      if (this.source != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.source);
      }
      i = paramInt;
      if (this.dJL != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.dJL);
      }
      i += f.a.a.b.b.a.p(16, this.HWh);
      paramInt = i;
      if (this.HWi != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.HWi);
      }
      i = paramInt;
      if (this.HWj != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.HWj);
      }
      paramInt = i;
      if (this.DTL != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.DTL);
      }
      i = paramInt;
      if (this.DTM != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.DTM);
      }
      i += f.a.a.b.b.a.bz(21, this.HWk);
      paramInt = i;
      if (this.HWl != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.HWl);
      }
      i = paramInt;
      if (this.HWm != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.HWm);
      }
      i = i + f.a.a.a.c(24, 8, this.uda) + f.a.a.b.b.a.p(25, this.timestamp) + f.a.a.b.b.a.amF(26);
      paramInt = i;
      if (this.tFc != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.tFc);
      }
      i = paramInt + f.a.a.b.b.a.p(28, this.HWn) + f.a.a.b.b.a.p(29, this.dmg) + f.a.a.b.b.a.p(30, this.HWo) + f.a.a.a.c(31, 8, this.HWp) + f.a.a.b.b.a.bz(32, this.HWq) + f.a.a.b.b.a.p(33, this.HWr);
      paramInt = i;
      if (this.HWs != null) {
        paramInt = i + f.a.a.a.lI(34, this.HWs.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(35, this.HWt) + f.a.a.b.b.a.bz(36, this.HWu) + f.a.a.b.b.a.amF(37);
      paramInt = i;
      if (this.HWw != null) {
        paramInt = i + f.a.a.b.b.a.e(38, this.HWw);
      }
      i = paramInt;
      if (this.HWx != null) {
        i = paramInt + f.a.a.a.lI(39, this.HWx.computeSize());
      }
      i += f.a.a.b.b.a.bz(40, this.HWy);
      paramInt = i;
      if (this.HWz != null) {
        paramInt = i + f.a.a.a.lI(41, this.HWz.computeSize());
      }
      i = paramInt + f.a.a.a.c(42, 8, this.DTg) + f.a.a.b.b.a.bz(43, this.HWA);
      paramInt = i;
      if (this.HWB != null) {
        paramInt = i + f.a.a.a.lI(44, this.HWB.computeSize());
      }
      AppMethodBeat.o(153013);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uda.clear();
        this.HWp.clear();
        this.DTg.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153013);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpa localdpa = (dpa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153013);
          return -1;
        case 1: 
          localdpa.title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 2: 
          localdpa.videoUrl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 3: 
          localdpa.HWg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 4: 
          localdpa.AjG = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153013);
          return 0;
        case 5: 
          localdpa.udb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 6: 
          localdpa.thumbWidth = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153013);
          return 0;
        case 7: 
          localdpa.thumbHeight = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153013);
          return 0;
        case 8: 
          localdpa.qlv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 9: 
          localdpa.qlw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 10: 
          localdpa.uly = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 11: 
          localdpa.DTI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 12: 
          localdpa.DTJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 13: 
          localdpa.DTK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 14: 
          localdpa.source = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 15: 
          localdpa.dJL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 16: 
          localdpa.HWh = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(153013);
          return 0;
        case 17: 
          localdpa.HWi = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 18: 
          localdpa.HWj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 19: 
          localdpa.DTL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 20: 
          localdpa.DTM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 21: 
          localdpa.HWk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153013);
          return 0;
        case 22: 
          localdpa.HWl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 23: 
          localdpa.HWm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 24: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpa.uda.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 25: 
          localdpa.timestamp = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(153013);
          return 0;
        case 26: 
          localdpa.dnq = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(153013);
          return 0;
        case 27: 
          localdpa.tFc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 28: 
          localdpa.HWn = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(153013);
          return 0;
        case 29: 
          localdpa.dmg = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(153013);
          return 0;
        case 30: 
          localdpa.HWo = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(153013);
          return 0;
        case 31: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpa.HWp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 32: 
          localdpa.HWq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153013);
          return 0;
        case 33: 
          localdpa.HWr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(153013);
          return 0;
        case 34: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dov();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dov)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpa.HWs = ((dov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 35: 
          localdpa.HWt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153013);
          return 0;
        case 36: 
          localdpa.HWu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153013);
          return 0;
        case 37: 
          localdpa.HWv = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(153013);
          return 0;
        case 38: 
          localdpa.HWw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 39: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new doy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((doy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpa.HWx = ((doy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 40: 
          localdpa.HWy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153013);
          return 0;
        case 41: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpa.HWz = ((dpa)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 42: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aaj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aaj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpa.DTg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 43: 
          localdpa.HWA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153013);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dot();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dot)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdpa.HWB = ((dot)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153013);
        return 0;
      }
      AppMethodBeat.o(153013);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpa
 * JD-Core Version:    0.7.0.1
 */