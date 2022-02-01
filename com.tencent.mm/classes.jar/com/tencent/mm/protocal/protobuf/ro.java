package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ro
  extends com.tencent.mm.bx.a
{
  public String CRC;
  public int CRD;
  public String CRE;
  public LinkedList<xo> CRF;
  public LinkedList<xo> CRG;
  public String CRH;
  public String CRI;
  public int CRJ;
  public String CRK;
  public int CRL;
  public String CRM;
  public String CRN;
  public long CRO;
  public String CRP;
  public String CRQ;
  public String CRR;
  public rd CRS;
  public String CRT;
  public String CRU;
  public int CRV;
  public abm CRW;
  public dij CRX;
  public amg CRY;
  public ba CRZ;
  public int CSa;
  public int CSb;
  public String CSc;
  public int CSd;
  public String CSe;
  public int CSf;
  public xo CSg;
  public String CSh;
  public xo CSi;
  public aco CSj;
  public boolean CSk;
  public int CSl;
  public boolean CSm;
  public boolean CSn;
  public oc CSo;
  public String CSp;
  public String CSq;
  public String dlB;
  public String gGR;
  public String gHT;
  public String iau;
  public String jEK;
  public int lpz;
  public String nrr;
  public String nrs;
  public String nsJ;
  public String nsK;
  public String source;
  public String title;
  
  public ro()
  {
    AppMethodBeat.i(113975);
    this.CRF = new LinkedList();
    this.CRG = new LinkedList();
    AppMethodBeat.o(113975);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113976);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nrr != null) {
        paramVarArgs.d(1, this.nrr);
      }
      if (this.gGR != null) {
        paramVarArgs.d(2, this.gGR);
      }
      if (this.dlB != null) {
        paramVarArgs.d(3, this.dlB);
      }
      if (this.CRC != null) {
        paramVarArgs.d(4, this.CRC);
      }
      paramVarArgs.aR(5, this.CRD);
      paramVarArgs.aR(6, this.lpz);
      if (this.nsK != null) {
        paramVarArgs.d(7, this.nsK);
      }
      if (this.title != null) {
        paramVarArgs.d(8, this.title);
      }
      if (this.nrs != null) {
        paramVarArgs.d(9, this.nrs);
      }
      if (this.gHT != null) {
        paramVarArgs.d(10, this.gHT);
      }
      if (this.iau != null) {
        paramVarArgs.d(11, this.iau);
      }
      if (this.CRE != null) {
        paramVarArgs.d(12, this.CRE);
      }
      paramVarArgs.e(13, 8, this.CRF);
      paramVarArgs.e(14, 8, this.CRG);
      if (this.CRH != null) {
        paramVarArgs.d(15, this.CRH);
      }
      if (this.CRI != null) {
        paramVarArgs.d(16, this.CRI);
      }
      if (this.source != null) {
        paramVarArgs.d(17, this.source);
      }
      paramVarArgs.aR(18, this.CRJ);
      if (this.nsJ != null) {
        paramVarArgs.d(19, this.nsJ);
      }
      if (this.jEK != null) {
        paramVarArgs.d(20, this.jEK);
      }
      if (this.CRK != null) {
        paramVarArgs.d(21, this.CRK);
      }
      paramVarArgs.aR(22, this.CRL);
      if (this.CRM != null) {
        paramVarArgs.d(23, this.CRM);
      }
      if (this.CRN != null) {
        paramVarArgs.d(24, this.CRN);
      }
      paramVarArgs.aG(25, this.CRO);
      if (this.CRP != null) {
        paramVarArgs.d(26, this.CRP);
      }
      if (this.CRQ != null) {
        paramVarArgs.d(27, this.CRQ);
      }
      if (this.CRR != null) {
        paramVarArgs.d(28, this.CRR);
      }
      if (this.CRS != null)
      {
        paramVarArgs.kX(29, this.CRS.computeSize());
        this.CRS.writeFields(paramVarArgs);
      }
      if (this.CRT != null) {
        paramVarArgs.d(30, this.CRT);
      }
      if (this.CRU != null) {
        paramVarArgs.d(31, this.CRU);
      }
      paramVarArgs.aR(32, this.CRV);
      if (this.CRW != null)
      {
        paramVarArgs.kX(33, this.CRW.computeSize());
        this.CRW.writeFields(paramVarArgs);
      }
      if (this.CRX != null)
      {
        paramVarArgs.kX(34, this.CRX.computeSize());
        this.CRX.writeFields(paramVarArgs);
      }
      if (this.CRY != null)
      {
        paramVarArgs.kX(35, this.CRY.computeSize());
        this.CRY.writeFields(paramVarArgs);
      }
      if (this.CRZ != null)
      {
        paramVarArgs.kX(36, this.CRZ.computeSize());
        this.CRZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(37, this.CSa);
      paramVarArgs.aR(38, this.CSb);
      if (this.CSc != null) {
        paramVarArgs.d(39, this.CSc);
      }
      paramVarArgs.aR(40, this.CSd);
      if (this.CSe != null) {
        paramVarArgs.d(41, this.CSe);
      }
      paramVarArgs.aR(42, this.CSf);
      if (this.CSg != null)
      {
        paramVarArgs.kX(43, this.CSg.computeSize());
        this.CSg.writeFields(paramVarArgs);
      }
      if (this.CSh != null) {
        paramVarArgs.d(44, this.CSh);
      }
      if (this.CSi != null)
      {
        paramVarArgs.kX(45, this.CSi.computeSize());
        this.CSi.writeFields(paramVarArgs);
      }
      if (this.CSj != null)
      {
        paramVarArgs.kX(46, this.CSj.computeSize());
        this.CSj.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(47, this.CSk);
      paramVarArgs.aR(48, this.CSl);
      paramVarArgs.bg(49, this.CSm);
      paramVarArgs.bg(50, this.CSn);
      if (this.CSo != null)
      {
        paramVarArgs.kX(51, this.CSo.computeSize());
        this.CSo.writeFields(paramVarArgs);
      }
      if (this.CSp != null) {
        paramVarArgs.d(52, this.CSp);
      }
      if (this.CSq != null) {
        paramVarArgs.d(53, this.CSq);
      }
      AppMethodBeat.o(113976);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nrr == null) {
        break label4198;
      }
    }
    label4198:
    for (int i = f.a.a.b.b.a.e(1, this.nrr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gGR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.gGR);
      }
      i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dlB);
      }
      paramInt = i;
      if (this.CRC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CRC);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.CRD) + f.a.a.b.b.a.bA(6, this.lpz);
      paramInt = i;
      if (this.nsK != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.nsK);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.title);
      }
      paramInt = i;
      if (this.nrs != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.nrs);
      }
      i = paramInt;
      if (this.gHT != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.gHT);
      }
      paramInt = i;
      if (this.iau != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.iau);
      }
      i = paramInt;
      if (this.CRE != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.CRE);
      }
      i = i + f.a.a.a.c(13, 8, this.CRF) + f.a.a.a.c(14, 8, this.CRG);
      paramInt = i;
      if (this.CRH != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.CRH);
      }
      i = paramInt;
      if (this.CRI != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.CRI);
      }
      paramInt = i;
      if (this.source != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.source);
      }
      i = paramInt + f.a.a.b.b.a.bA(18, this.CRJ);
      paramInt = i;
      if (this.nsJ != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.nsJ);
      }
      i = paramInt;
      if (this.jEK != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.jEK);
      }
      paramInt = i;
      if (this.CRK != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.CRK);
      }
      i = paramInt + f.a.a.b.b.a.bA(22, this.CRL);
      paramInt = i;
      if (this.CRM != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.CRM);
      }
      i = paramInt;
      if (this.CRN != null) {
        i = paramInt + f.a.a.b.b.a.e(24, this.CRN);
      }
      i += f.a.a.b.b.a.q(25, this.CRO);
      paramInt = i;
      if (this.CRP != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.CRP);
      }
      i = paramInt;
      if (this.CRQ != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.CRQ);
      }
      paramInt = i;
      if (this.CRR != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.CRR);
      }
      i = paramInt;
      if (this.CRS != null) {
        i = paramInt + f.a.a.a.kW(29, this.CRS.computeSize());
      }
      paramInt = i;
      if (this.CRT != null) {
        paramInt = i + f.a.a.b.b.a.e(30, this.CRT);
      }
      i = paramInt;
      if (this.CRU != null) {
        i = paramInt + f.a.a.b.b.a.e(31, this.CRU);
      }
      i += f.a.a.b.b.a.bA(32, this.CRV);
      paramInt = i;
      if (this.CRW != null) {
        paramInt = i + f.a.a.a.kW(33, this.CRW.computeSize());
      }
      i = paramInt;
      if (this.CRX != null) {
        i = paramInt + f.a.a.a.kW(34, this.CRX.computeSize());
      }
      paramInt = i;
      if (this.CRY != null) {
        paramInt = i + f.a.a.a.kW(35, this.CRY.computeSize());
      }
      i = paramInt;
      if (this.CRZ != null) {
        i = paramInt + f.a.a.a.kW(36, this.CRZ.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(37, this.CSa) + f.a.a.b.b.a.bA(38, this.CSb);
      paramInt = i;
      if (this.CSc != null) {
        paramInt = i + f.a.a.b.b.a.e(39, this.CSc);
      }
      i = paramInt + f.a.a.b.b.a.bA(40, this.CSd);
      paramInt = i;
      if (this.CSe != null) {
        paramInt = i + f.a.a.b.b.a.e(41, this.CSe);
      }
      i = paramInt + f.a.a.b.b.a.bA(42, this.CSf);
      paramInt = i;
      if (this.CSg != null) {
        paramInt = i + f.a.a.a.kW(43, this.CSg.computeSize());
      }
      i = paramInt;
      if (this.CSh != null) {
        i = paramInt + f.a.a.b.b.a.e(44, this.CSh);
      }
      paramInt = i;
      if (this.CSi != null) {
        paramInt = i + f.a.a.a.kW(45, this.CSi.computeSize());
      }
      i = paramInt;
      if (this.CSj != null) {
        i = paramInt + f.a.a.a.kW(46, this.CSj.computeSize());
      }
      i = i + (f.a.a.b.b.a.fY(47) + 1) + f.a.a.b.b.a.bA(48, this.CSl) + (f.a.a.b.b.a.fY(49) + 1) + (f.a.a.b.b.a.fY(50) + 1);
      paramInt = i;
      if (this.CSo != null) {
        paramInt = i + f.a.a.a.kW(51, this.CSo.computeSize());
      }
      i = paramInt;
      if (this.CSp != null) {
        i = paramInt + f.a.a.b.b.a.e(52, this.CSp);
      }
      paramInt = i;
      if (this.CSq != null) {
        paramInt = i + f.a.a.b.b.a.e(53, this.CSq);
      }
      AppMethodBeat.o(113976);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CRF.clear();
        this.CRG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113976);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ro localro = (ro)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113976);
          return -1;
        case 1: 
          localro.nrr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 2: 
          localro.gGR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 3: 
          localro.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 4: 
          localro.CRC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 5: 
          localro.CRD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113976);
          return 0;
        case 6: 
          localro.lpz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113976);
          return 0;
        case 7: 
          localro.nsK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 8: 
          localro.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 9: 
          localro.nrs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 10: 
          localro.gHT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 11: 
          localro.iau = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 12: 
          localro.CRE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localro.CRF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localro.CRG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 15: 
          localro.CRH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 16: 
          localro.CRI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 17: 
          localro.source = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 18: 
          localro.CRJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113976);
          return 0;
        case 19: 
          localro.nsJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 20: 
          localro.jEK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 21: 
          localro.CRK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 22: 
          localro.CRL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113976);
          return 0;
        case 23: 
          localro.CRM = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 24: 
          localro.CRN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 25: 
          localro.CRO = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(113976);
          return 0;
        case 26: 
          localro.CRP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 27: 
          localro.CRQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 28: 
          localro.CRR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 29: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localro.CRS = ((rd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 30: 
          localro.CRT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 31: 
          localro.CRU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 32: 
          localro.CRV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113976);
          return 0;
        case 33: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localro.CRW = ((abm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 34: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dij();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dij)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localro.CRX = ((dij)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 35: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localro.CRY = ((amg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 36: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ba();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ba)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localro.CRZ = ((ba)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 37: 
          localro.CSa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113976);
          return 0;
        case 38: 
          localro.CSb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113976);
          return 0;
        case 39: 
          localro.CSc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 40: 
          localro.CSd = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113976);
          return 0;
        case 41: 
          localro.CSe = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 42: 
          localro.CSf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113976);
          return 0;
        case 43: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localro.CSg = ((xo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 44: 
          localro.CSh = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 45: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localro.CSi = ((xo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 46: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aco();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aco)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localro.CSj = ((aco)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 47: 
          localro.CSk = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(113976);
          return 0;
        case 48: 
          localro.CSl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113976);
          return 0;
        case 49: 
          localro.CSm = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(113976);
          return 0;
        case 50: 
          localro.CSn = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(113976);
          return 0;
        case 51: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new oc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((oc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localro.CSo = ((oc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 52: 
          localro.CSp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113976);
          return 0;
        }
        localro.CSq = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(113976);
        return 0;
      }
      AppMethodBeat.o(113976);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ro
 * JD-Core Version:    0.7.0.1
 */