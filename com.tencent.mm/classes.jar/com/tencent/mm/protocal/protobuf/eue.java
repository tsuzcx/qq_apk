package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eue
  extends com.tencent.mm.bw.a
{
  public euk NpJ;
  public euk NpK;
  public int NrE;
  public esr NrF;
  public esr NrG;
  public int NrH;
  public int NrI;
  public int NrJ;
  public int NrK;
  public SKBuiltinBuffer_t NrL;
  public int NrM;
  public esr NrN;
  public int NrO;
  public int NrP;
  public int NrQ;
  public int NrR;
  public int NrS;
  public int NrT;
  public SKBuiltinBuffer_t NrU;
  public SKBuiltinBuffer_t NrV;
  public int NrW;
  public SKBuiltinBuffer_t NrX;
  public int NrY;
  public int NrZ;
  public dmm Nrx;
  public ahk Nry;
  public int Nsa;
  public cez Nsb;
  public SKBuiltinBuffer_t Nsc;
  public int Nsd;
  public String Nse;
  public int Nsf;
  public LinkedList<euf> Nsg;
  public bqy Nsh;
  public int yqc;
  
  public eue()
  {
    AppMethodBeat.i(115899);
    this.Nsg = new LinkedList();
    AppMethodBeat.o(115899);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115900);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NpJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: PeerId");
        AppMethodBeat.o(115900);
        throw paramVarArgs;
      }
      if (this.NpK == null)
      {
        paramVarArgs = new b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(115900);
        throw paramVarArgs;
      }
      if (this.NpJ != null)
      {
        paramVarArgs.ni(1, this.NpJ.computeSize());
        this.NpJ.writeFields(paramVarArgs);
      }
      if (this.NpK != null)
      {
        paramVarArgs.ni(2, this.NpK.computeSize());
        this.NpK.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.NrE);
      if (this.NrF != null)
      {
        paramVarArgs.ni(4, this.NrF.computeSize());
        this.NrF.writeFields(paramVarArgs);
      }
      if (this.NrG != null)
      {
        paramVarArgs.ni(5, this.NrG.computeSize());
        this.NrG.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.NrH);
      paramVarArgs.aM(7, this.NrI);
      paramVarArgs.aM(8, this.NrJ);
      paramVarArgs.aM(9, this.NrK);
      if (this.NrL != null)
      {
        paramVarArgs.ni(10, this.NrL.computeSize());
        this.NrL.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(11, this.NrM);
      if (this.NrN != null)
      {
        paramVarArgs.ni(12, this.NrN.computeSize());
        this.NrN.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(13, this.NrO);
      paramVarArgs.aM(14, this.NrP);
      paramVarArgs.aM(15, this.NrQ);
      paramVarArgs.aM(16, this.NrR);
      paramVarArgs.aM(17, this.NrS);
      paramVarArgs.aM(18, this.yqc);
      paramVarArgs.aM(19, this.NrT);
      if (this.NrU != null)
      {
        paramVarArgs.ni(20, this.NrU.computeSize());
        this.NrU.writeFields(paramVarArgs);
      }
      if (this.NrV != null)
      {
        paramVarArgs.ni(21, this.NrV.computeSize());
        this.NrV.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(22, this.NrW);
      if (this.NrX != null)
      {
        paramVarArgs.ni(23, this.NrX.computeSize());
        this.NrX.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(24, this.NrY);
      paramVarArgs.aM(25, this.NrZ);
      paramVarArgs.aM(26, this.Nsa);
      if (this.Nsb != null)
      {
        paramVarArgs.ni(27, this.Nsb.computeSize());
        this.Nsb.writeFields(paramVarArgs);
      }
      if (this.Nsc != null)
      {
        paramVarArgs.ni(28, this.Nsc.computeSize());
        this.Nsc.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(29, this.Nsd);
      if (this.Nse != null) {
        paramVarArgs.e(30, this.Nse);
      }
      paramVarArgs.aM(31, this.Nsf);
      paramVarArgs.e(32, 8, this.Nsg);
      if (this.Nrx != null)
      {
        paramVarArgs.ni(33, this.Nrx.computeSize());
        this.Nrx.writeFields(paramVarArgs);
      }
      if (this.Nry != null)
      {
        paramVarArgs.ni(34, this.Nry.computeSize());
        this.Nry.writeFields(paramVarArgs);
      }
      if (this.Nsh != null)
      {
        paramVarArgs.ni(35, this.Nsh.computeSize());
        this.Nsh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115900);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NpJ == null) {
        break label3482;
      }
    }
    label3482:
    for (paramInt = g.a.a.a.nh(1, this.NpJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.NpK != null) {
        i = paramInt + g.a.a.a.nh(2, this.NpK.computeSize());
      }
      i += g.a.a.b.b.a.bu(3, this.NrE);
      paramInt = i;
      if (this.NrF != null) {
        paramInt = i + g.a.a.a.nh(4, this.NrF.computeSize());
      }
      i = paramInt;
      if (this.NrG != null) {
        i = paramInt + g.a.a.a.nh(5, this.NrG.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(6, this.NrH) + g.a.a.b.b.a.bu(7, this.NrI) + g.a.a.b.b.a.bu(8, this.NrJ) + g.a.a.b.b.a.bu(9, this.NrK);
      paramInt = i;
      if (this.NrL != null) {
        paramInt = i + g.a.a.a.nh(10, this.NrL.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.NrM);
      paramInt = i;
      if (this.NrN != null) {
        paramInt = i + g.a.a.a.nh(12, this.NrN.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(13, this.NrO) + g.a.a.b.b.a.bu(14, this.NrP) + g.a.a.b.b.a.bu(15, this.NrQ) + g.a.a.b.b.a.bu(16, this.NrR) + g.a.a.b.b.a.bu(17, this.NrS) + g.a.a.b.b.a.bu(18, this.yqc) + g.a.a.b.b.a.bu(19, this.NrT);
      paramInt = i;
      if (this.NrU != null) {
        paramInt = i + g.a.a.a.nh(20, this.NrU.computeSize());
      }
      i = paramInt;
      if (this.NrV != null) {
        i = paramInt + g.a.a.a.nh(21, this.NrV.computeSize());
      }
      i += g.a.a.b.b.a.bu(22, this.NrW);
      paramInt = i;
      if (this.NrX != null) {
        paramInt = i + g.a.a.a.nh(23, this.NrX.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(24, this.NrY) + g.a.a.b.b.a.bu(25, this.NrZ) + g.a.a.b.b.a.bu(26, this.Nsa);
      paramInt = i;
      if (this.Nsb != null) {
        paramInt = i + g.a.a.a.nh(27, this.Nsb.computeSize());
      }
      i = paramInt;
      if (this.Nsc != null) {
        i = paramInt + g.a.a.a.nh(28, this.Nsc.computeSize());
      }
      i += g.a.a.b.b.a.bu(29, this.Nsd);
      paramInt = i;
      if (this.Nse != null) {
        paramInt = i + g.a.a.b.b.a.f(30, this.Nse);
      }
      i = paramInt + g.a.a.b.b.a.bu(31, this.Nsf) + g.a.a.a.c(32, 8, this.Nsg);
      paramInt = i;
      if (this.Nrx != null) {
        paramInt = i + g.a.a.a.nh(33, this.Nrx.computeSize());
      }
      i = paramInt;
      if (this.Nry != null) {
        i = paramInt + g.a.a.a.nh(34, this.Nry.computeSize());
      }
      paramInt = i;
      if (this.Nsh != null) {
        paramInt = i + g.a.a.a.nh(35, this.Nsh.computeSize());
      }
      AppMethodBeat.o(115900);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Nsg.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.NpJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: PeerId");
          AppMethodBeat.o(115900);
          throw paramVarArgs;
        }
        if (this.NpK == null)
        {
          paramVarArgs = new b("Not all required fields were included: CapInfo");
          AppMethodBeat.o(115900);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115900);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eue localeue = (eue)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115900);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new euk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((euk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeue.NpJ = ((euk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new euk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((euk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeue.NpK = ((euk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 3: 
          localeue.NrE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115900);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new esr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((esr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeue.NrF = ((esr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new esr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((esr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeue.NrG = ((esr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 6: 
          localeue.NrH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115900);
          return 0;
        case 7: 
          localeue.NrI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115900);
          return 0;
        case 8: 
          localeue.NrJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115900);
          return 0;
        case 9: 
          localeue.NrK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115900);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeue.NrL = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 11: 
          localeue.NrM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115900);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new esr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((esr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeue.NrN = ((esr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 13: 
          localeue.NrO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115900);
          return 0;
        case 14: 
          localeue.NrP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115900);
          return 0;
        case 15: 
          localeue.NrQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115900);
          return 0;
        case 16: 
          localeue.NrR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115900);
          return 0;
        case 17: 
          localeue.NrS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115900);
          return 0;
        case 18: 
          localeue.yqc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115900);
          return 0;
        case 19: 
          localeue.NrT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115900);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeue.NrU = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeue.NrV = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 22: 
          localeue.NrW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115900);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeue.NrX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 24: 
          localeue.NrY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115900);
          return 0;
        case 25: 
          localeue.NrZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115900);
          return 0;
        case 26: 
          localeue.Nsa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115900);
          return 0;
        case 27: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cez();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cez)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeue.Nsb = ((cez)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 28: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeue.Nsc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 29: 
          localeue.Nsd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115900);
          return 0;
        case 30: 
          localeue.Nse = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(115900);
          return 0;
        case 31: 
          localeue.Nsf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115900);
          return 0;
        case 32: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new euf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((euf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeue.Nsg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 33: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeue.Nrx = ((dmm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 34: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeue.Nry = ((ahk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bqy();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bqy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeue.Nsh = ((bqy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115900);
        return 0;
      }
      AppMethodBeat.o(115900);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eue
 * JD-Core Version:    0.7.0.1
 */