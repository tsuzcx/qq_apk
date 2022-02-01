package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eiw
  extends com.tencent.mm.bw.a
{
  public String BmI;
  public int Eso;
  public LinkedList<aca> IDO;
  public String IED;
  public String IEE;
  public String IEF;
  public String IEG;
  public String IEH;
  public String MwR;
  public int NiA;
  public int NiB;
  public boolean NiC;
  public String NiD;
  public eiu NiE;
  public int NiF;
  public eiw NiG;
  public int NiH;
  public eip NiI;
  public int NiJ;
  public String Nio;
  public long Nip;
  public String Niq;
  public String Nir;
  public int Nis;
  public String Nit;
  public long Niu;
  public long Niv;
  public LinkedList<eiy> Niw;
  public int Nix;
  public long Niy;
  public eir Niz;
  public long dDw;
  public boolean dEF;
  public String eby;
  public String msN;
  public String psI;
  public String rCq;
  public String source;
  public int thumbHeight;
  public int thumbWidth;
  public long timestamp;
  public String title;
  public String videoUrl;
  public String wWb;
  public String xDQ;
  public LinkedList<dyi> xuO;
  
  public eiw()
  {
    AppMethodBeat.i(153012);
    this.xuO = new LinkedList();
    this.Niw = new LinkedList();
    this.IDO = new LinkedList();
    AppMethodBeat.o(153012);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153013);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.videoUrl != null) {
        paramVarArgs.e(2, this.videoUrl);
      }
      if (this.Nio != null) {
        paramVarArgs.e(3, this.Nio);
      }
      paramVarArgs.aM(4, this.Eso);
      if (this.psI != null) {
        paramVarArgs.e(5, this.psI);
      }
      paramVarArgs.aM(6, this.thumbWidth);
      paramVarArgs.aM(7, this.thumbHeight);
      if (this.rCq != null) {
        paramVarArgs.e(8, this.rCq);
      }
      if (this.msN != null) {
        paramVarArgs.e(9, this.msN);
      }
      if (this.xDQ != null) {
        paramVarArgs.e(10, this.xDQ);
      }
      if (this.IED != null) {
        paramVarArgs.e(11, this.IED);
      }
      if (this.IEE != null) {
        paramVarArgs.e(12, this.IEE);
      }
      if (this.IEF != null) {
        paramVarArgs.e(13, this.IEF);
      }
      if (this.source != null) {
        paramVarArgs.e(14, this.source);
      }
      if (this.eby != null) {
        paramVarArgs.e(15, this.eby);
      }
      paramVarArgs.bb(16, this.Nip);
      if (this.Niq != null) {
        paramVarArgs.e(17, this.Niq);
      }
      if (this.Nir != null) {
        paramVarArgs.e(18, this.Nir);
      }
      if (this.IEG != null) {
        paramVarArgs.e(19, this.IEG);
      }
      if (this.IEH != null) {
        paramVarArgs.e(20, this.IEH);
      }
      paramVarArgs.aM(21, this.Nis);
      if (this.Nit != null) {
        paramVarArgs.e(22, this.Nit);
      }
      if (this.MwR != null) {
        paramVarArgs.e(23, this.MwR);
      }
      paramVarArgs.e(24, 8, this.xuO);
      paramVarArgs.bb(25, this.timestamp);
      paramVarArgs.cc(26, this.dEF);
      if (this.wWb != null) {
        paramVarArgs.e(27, this.wWb);
      }
      paramVarArgs.bb(28, this.Niu);
      paramVarArgs.bb(29, this.dDw);
      paramVarArgs.bb(30, this.Niv);
      paramVarArgs.e(31, 8, this.Niw);
      paramVarArgs.aM(32, this.Nix);
      paramVarArgs.bb(33, this.Niy);
      if (this.Niz != null)
      {
        paramVarArgs.ni(34, this.Niz.computeSize());
        this.Niz.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(35, this.NiA);
      paramVarArgs.aM(36, this.NiB);
      paramVarArgs.cc(37, this.NiC);
      if (this.NiD != null) {
        paramVarArgs.e(38, this.NiD);
      }
      if (this.NiE != null)
      {
        paramVarArgs.ni(39, this.NiE.computeSize());
        this.NiE.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(40, this.NiF);
      if (this.NiG != null)
      {
        paramVarArgs.ni(41, this.NiG.computeSize());
        this.NiG.writeFields(paramVarArgs);
      }
      paramVarArgs.e(42, 8, this.IDO);
      paramVarArgs.aM(43, this.NiH);
      if (this.NiI != null)
      {
        paramVarArgs.ni(44, this.NiI.computeSize());
        this.NiI.writeFields(paramVarArgs);
      }
      if (this.BmI != null) {
        paramVarArgs.e(45, this.BmI);
      }
      paramVarArgs.aM(46, this.NiJ);
      AppMethodBeat.o(153013);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label3298;
      }
    }
    label3298:
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.videoUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.videoUrl);
      }
      i = paramInt;
      if (this.Nio != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Nio);
      }
      i += g.a.a.b.b.a.bu(4, this.Eso);
      paramInt = i;
      if (this.psI != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.psI);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.thumbWidth) + g.a.a.b.b.a.bu(7, this.thumbHeight);
      paramInt = i;
      if (this.rCq != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.rCq);
      }
      i = paramInt;
      if (this.msN != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.msN);
      }
      paramInt = i;
      if (this.xDQ != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.xDQ);
      }
      i = paramInt;
      if (this.IED != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.IED);
      }
      paramInt = i;
      if (this.IEE != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.IEE);
      }
      i = paramInt;
      if (this.IEF != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.IEF);
      }
      paramInt = i;
      if (this.source != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.source);
      }
      i = paramInt;
      if (this.eby != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.eby);
      }
      i += g.a.a.b.b.a.r(16, this.Nip);
      paramInt = i;
      if (this.Niq != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.Niq);
      }
      i = paramInt;
      if (this.Nir != null) {
        i = paramInt + g.a.a.b.b.a.f(18, this.Nir);
      }
      paramInt = i;
      if (this.IEG != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.IEG);
      }
      i = paramInt;
      if (this.IEH != null) {
        i = paramInt + g.a.a.b.b.a.f(20, this.IEH);
      }
      i += g.a.a.b.b.a.bu(21, this.Nis);
      paramInt = i;
      if (this.Nit != null) {
        paramInt = i + g.a.a.b.b.a.f(22, this.Nit);
      }
      i = paramInt;
      if (this.MwR != null) {
        i = paramInt + g.a.a.b.b.a.f(23, this.MwR);
      }
      i = i + g.a.a.a.c(24, 8, this.xuO) + g.a.a.b.b.a.r(25, this.timestamp) + (g.a.a.b.b.a.fS(26) + 1);
      paramInt = i;
      if (this.wWb != null) {
        paramInt = i + g.a.a.b.b.a.f(27, this.wWb);
      }
      i = paramInt + g.a.a.b.b.a.r(28, this.Niu) + g.a.a.b.b.a.r(29, this.dDw) + g.a.a.b.b.a.r(30, this.Niv) + g.a.a.a.c(31, 8, this.Niw) + g.a.a.b.b.a.bu(32, this.Nix) + g.a.a.b.b.a.r(33, this.Niy);
      paramInt = i;
      if (this.Niz != null) {
        paramInt = i + g.a.a.a.nh(34, this.Niz.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(35, this.NiA) + g.a.a.b.b.a.bu(36, this.NiB) + (g.a.a.b.b.a.fS(37) + 1);
      paramInt = i;
      if (this.NiD != null) {
        paramInt = i + g.a.a.b.b.a.f(38, this.NiD);
      }
      i = paramInt;
      if (this.NiE != null) {
        i = paramInt + g.a.a.a.nh(39, this.NiE.computeSize());
      }
      i += g.a.a.b.b.a.bu(40, this.NiF);
      paramInt = i;
      if (this.NiG != null) {
        paramInt = i + g.a.a.a.nh(41, this.NiG.computeSize());
      }
      i = paramInt + g.a.a.a.c(42, 8, this.IDO) + g.a.a.b.b.a.bu(43, this.NiH);
      paramInt = i;
      if (this.NiI != null) {
        paramInt = i + g.a.a.a.nh(44, this.NiI.computeSize());
      }
      i = paramInt;
      if (this.BmI != null) {
        i = paramInt + g.a.a.b.b.a.f(45, this.BmI);
      }
      paramInt = g.a.a.b.b.a.bu(46, this.NiJ);
      AppMethodBeat.o(153013);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xuO.clear();
        this.Niw.clear();
        this.IDO.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153013);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eiw localeiw = (eiw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153013);
          return -1;
        case 1: 
          localeiw.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 2: 
          localeiw.videoUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 3: 
          localeiw.Nio = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 4: 
          localeiw.Eso = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153013);
          return 0;
        case 5: 
          localeiw.psI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 6: 
          localeiw.thumbWidth = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153013);
          return 0;
        case 7: 
          localeiw.thumbHeight = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153013);
          return 0;
        case 8: 
          localeiw.rCq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 9: 
          localeiw.msN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 10: 
          localeiw.xDQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 11: 
          localeiw.IED = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 12: 
          localeiw.IEE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 13: 
          localeiw.IEF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 14: 
          localeiw.source = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 15: 
          localeiw.eby = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 16: 
          localeiw.Nip = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(153013);
          return 0;
        case 17: 
          localeiw.Niq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 18: 
          localeiw.Nir = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 19: 
          localeiw.IEG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 20: 
          localeiw.IEH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 21: 
          localeiw.Nis = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153013);
          return 0;
        case 22: 
          localeiw.Nit = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 23: 
          localeiw.MwR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 24: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeiw.xuO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 25: 
          localeiw.timestamp = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(153013);
          return 0;
        case 26: 
          localeiw.dEF = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(153013);
          return 0;
        case 27: 
          localeiw.wWb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 28: 
          localeiw.Niu = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(153013);
          return 0;
        case 29: 
          localeiw.dDw = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(153013);
          return 0;
        case 30: 
          localeiw.Niv = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(153013);
          return 0;
        case 31: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eiy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eiy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeiw.Niw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 32: 
          localeiw.Nix = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153013);
          return 0;
        case 33: 
          localeiw.Niy = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(153013);
          return 0;
        case 34: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eir();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eir)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeiw.Niz = ((eir)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 35: 
          localeiw.NiA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153013);
          return 0;
        case 36: 
          localeiw.NiB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153013);
          return 0;
        case 37: 
          localeiw.NiC = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(153013);
          return 0;
        case 38: 
          localeiw.NiD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 39: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eiu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eiu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeiw.NiE = ((eiu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 40: 
          localeiw.NiF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153013);
          return 0;
        case 41: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eiw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eiw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeiw.NiG = ((eiw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 42: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aca();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aca)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeiw.IDO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 43: 
          localeiw.NiH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153013);
          return 0;
        case 44: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eip();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eip)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeiw.NiI = ((eip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 45: 
          localeiw.BmI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153013);
          return 0;
        }
        localeiw.NiJ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(153013);
        return 0;
      }
      AppMethodBeat.o(153013);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eiw
 * JD-Core Version:    0.7.0.1
 */