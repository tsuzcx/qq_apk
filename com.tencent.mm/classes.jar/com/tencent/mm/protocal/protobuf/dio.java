package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dio
  extends com.tencent.mm.bw.a
{
  public String BYP;
  public String BYQ;
  public String BYR;
  public String BYS;
  public String BYT;
  public LinkedList<yh> BYq;
  public String FRN;
  public long FRO;
  public String FRP;
  public String FRQ;
  public int FRR;
  public String FRS;
  public String FRT;
  public long FRU;
  public long FRV;
  public LinkedList<diq> FRW;
  public int FRX;
  public long FRY;
  public dij FRZ;
  public int FSa;
  public int FSb;
  public boolean FSc;
  public String FSd;
  public dim FSe;
  public int FSf;
  public dio FSg;
  public int FSh;
  public dih FSi;
  public long cZM;
  public boolean daU;
  public String kRU;
  public String pBl;
  public String pBm;
  public LinkedList<cyv> sVE;
  public String sVF;
  public String source;
  public String sxK;
  public String tcG;
  public int thumbHeight;
  public int thumbWidth;
  public long timestamp;
  public String title;
  public String videoUrl;
  public int yBk;
  
  public dio()
  {
    AppMethodBeat.i(153012);
    this.sVE = new LinkedList();
    this.FRW = new LinkedList();
    this.BYq = new LinkedList();
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
      if (this.FRN != null) {
        paramVarArgs.d(3, this.FRN);
      }
      paramVarArgs.aR(4, this.yBk);
      if (this.sVF != null) {
        paramVarArgs.d(5, this.sVF);
      }
      paramVarArgs.aR(6, this.thumbWidth);
      paramVarArgs.aR(7, this.thumbHeight);
      if (this.pBl != null) {
        paramVarArgs.d(8, this.pBl);
      }
      if (this.pBm != null) {
        paramVarArgs.d(9, this.pBm);
      }
      if (this.tcG != null) {
        paramVarArgs.d(10, this.tcG);
      }
      if (this.BYP != null) {
        paramVarArgs.d(11, this.BYP);
      }
      if (this.BYQ != null) {
        paramVarArgs.d(12, this.BYQ);
      }
      if (this.BYR != null) {
        paramVarArgs.d(13, this.BYR);
      }
      if (this.source != null) {
        paramVarArgs.d(14, this.source);
      }
      if (this.kRU != null) {
        paramVarArgs.d(15, this.kRU);
      }
      paramVarArgs.aO(16, this.FRO);
      if (this.FRP != null) {
        paramVarArgs.d(17, this.FRP);
      }
      if (this.FRQ != null) {
        paramVarArgs.d(18, this.FRQ);
      }
      if (this.BYS != null) {
        paramVarArgs.d(19, this.BYS);
      }
      if (this.BYT != null) {
        paramVarArgs.d(20, this.BYT);
      }
      paramVarArgs.aR(21, this.FRR);
      if (this.FRS != null) {
        paramVarArgs.d(22, this.FRS);
      }
      if (this.FRT != null) {
        paramVarArgs.d(23, this.FRT);
      }
      paramVarArgs.e(24, 8, this.sVE);
      paramVarArgs.aO(25, this.timestamp);
      paramVarArgs.bl(26, this.daU);
      if (this.sxK != null) {
        paramVarArgs.d(27, this.sxK);
      }
      paramVarArgs.aO(28, this.FRU);
      paramVarArgs.aO(29, this.cZM);
      paramVarArgs.aO(30, this.FRV);
      paramVarArgs.e(31, 8, this.FRW);
      paramVarArgs.aR(32, this.FRX);
      paramVarArgs.aO(33, this.FRY);
      if (this.FRZ != null)
      {
        paramVarArgs.ln(34, this.FRZ.computeSize());
        this.FRZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(35, this.FSa);
      paramVarArgs.aR(36, this.FSb);
      paramVarArgs.bl(37, this.FSc);
      if (this.FSd != null) {
        paramVarArgs.d(38, this.FSd);
      }
      if (this.FSe != null)
      {
        paramVarArgs.ln(39, this.FSe.computeSize());
        this.FSe.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(40, this.FSf);
      if (this.FSg != null)
      {
        paramVarArgs.ln(41, this.FSg.computeSize());
        this.FSg.writeFields(paramVarArgs);
      }
      paramVarArgs.e(42, 8, this.BYq);
      paramVarArgs.aR(43, this.FSh);
      if (this.FSi != null)
      {
        paramVarArgs.ln(44, this.FSi.computeSize());
        this.FSi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153013);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label3190;
      }
    }
    label3190:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.videoUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.videoUrl);
      }
      i = paramInt;
      if (this.FRN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FRN);
      }
      i += f.a.a.b.b.a.bx(4, this.yBk);
      paramInt = i;
      if (this.sVF != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.sVF);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.thumbWidth) + f.a.a.b.b.a.bx(7, this.thumbHeight);
      paramInt = i;
      if (this.pBl != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.pBl);
      }
      i = paramInt;
      if (this.pBm != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.pBm);
      }
      paramInt = i;
      if (this.tcG != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.tcG);
      }
      i = paramInt;
      if (this.BYP != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.BYP);
      }
      paramInt = i;
      if (this.BYQ != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.BYQ);
      }
      i = paramInt;
      if (this.BYR != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.BYR);
      }
      paramInt = i;
      if (this.source != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.source);
      }
      i = paramInt;
      if (this.kRU != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.kRU);
      }
      i += f.a.a.b.b.a.p(16, this.FRO);
      paramInt = i;
      if (this.FRP != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.FRP);
      }
      i = paramInt;
      if (this.FRQ != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.FRQ);
      }
      paramInt = i;
      if (this.BYS != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.BYS);
      }
      i = paramInt;
      if (this.BYT != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.BYT);
      }
      i += f.a.a.b.b.a.bx(21, this.FRR);
      paramInt = i;
      if (this.FRS != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.FRS);
      }
      i = paramInt;
      if (this.FRT != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.FRT);
      }
      i = i + f.a.a.a.c(24, 8, this.sVE) + f.a.a.b.b.a.p(25, this.timestamp) + (f.a.a.b.b.a.fK(26) + 1);
      paramInt = i;
      if (this.sxK != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.sxK);
      }
      i = paramInt + f.a.a.b.b.a.p(28, this.FRU) + f.a.a.b.b.a.p(29, this.cZM) + f.a.a.b.b.a.p(30, this.FRV) + f.a.a.a.c(31, 8, this.FRW) + f.a.a.b.b.a.bx(32, this.FRX) + f.a.a.b.b.a.p(33, this.FRY);
      paramInt = i;
      if (this.FRZ != null) {
        paramInt = i + f.a.a.a.lm(34, this.FRZ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(35, this.FSa) + f.a.a.b.b.a.bx(36, this.FSb) + (f.a.a.b.b.a.fK(37) + 1);
      paramInt = i;
      if (this.FSd != null) {
        paramInt = i + f.a.a.b.b.a.e(38, this.FSd);
      }
      i = paramInt;
      if (this.FSe != null) {
        i = paramInt + f.a.a.a.lm(39, this.FSe.computeSize());
      }
      i += f.a.a.b.b.a.bx(40, this.FSf);
      paramInt = i;
      if (this.FSg != null) {
        paramInt = i + f.a.a.a.lm(41, this.FSg.computeSize());
      }
      i = paramInt + f.a.a.a.c(42, 8, this.BYq) + f.a.a.b.b.a.bx(43, this.FSh);
      paramInt = i;
      if (this.FSi != null) {
        paramInt = i + f.a.a.a.lm(44, this.FSi.computeSize());
      }
      AppMethodBeat.o(153013);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sVE.clear();
        this.FRW.clear();
        this.BYq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153013);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dio localdio = (dio)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153013);
          return -1;
        case 1: 
          localdio.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 2: 
          localdio.videoUrl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 3: 
          localdio.FRN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 4: 
          localdio.yBk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153013);
          return 0;
        case 5: 
          localdio.sVF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 6: 
          localdio.thumbWidth = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153013);
          return 0;
        case 7: 
          localdio.thumbHeight = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153013);
          return 0;
        case 8: 
          localdio.pBl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 9: 
          localdio.pBm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 10: 
          localdio.tcG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 11: 
          localdio.BYP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 12: 
          localdio.BYQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 13: 
          localdio.BYR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 14: 
          localdio.source = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 15: 
          localdio.kRU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 16: 
          localdio.FRO = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(153013);
          return 0;
        case 17: 
          localdio.FRP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 18: 
          localdio.FRQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 19: 
          localdio.BYS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 20: 
          localdio.BYT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 21: 
          localdio.FRR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153013);
          return 0;
        case 22: 
          localdio.FRS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 23: 
          localdio.FRT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 24: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdio.sVE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 25: 
          localdio.timestamp = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(153013);
          return 0;
        case 26: 
          localdio.daU = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(153013);
          return 0;
        case 27: 
          localdio.sxK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 28: 
          localdio.FRU = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(153013);
          return 0;
        case 29: 
          localdio.cZM = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(153013);
          return 0;
        case 30: 
          localdio.FRV = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(153013);
          return 0;
        case 31: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new diq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((diq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdio.FRW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 32: 
          localdio.FRX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153013);
          return 0;
        case 33: 
          localdio.FRY = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(153013);
          return 0;
        case 34: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dij();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dij)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdio.FRZ = ((dij)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 35: 
          localdio.FSa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153013);
          return 0;
        case 36: 
          localdio.FSb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153013);
          return 0;
        case 37: 
          localdio.FSc = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(153013);
          return 0;
        case 38: 
          localdio.FSd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 39: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dim();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dim)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdio.FSe = ((dim)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 40: 
          localdio.FSf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153013);
          return 0;
        case 41: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dio();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dio)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdio.FSg = ((dio)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 42: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdio.BYq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 43: 
          localdio.FSh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153013);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dih();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dih)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdio.FSi = ((dih)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dio
 * JD-Core Version:    0.7.0.1
 */