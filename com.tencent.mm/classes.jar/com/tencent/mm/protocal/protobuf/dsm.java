package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dsm
  extends com.tencent.mm.bw.a
{
  public dss FYh;
  public dss FYi;
  public cnz FZV;
  public acu FZW;
  public SKBuiltinBuffer_t GaA;
  public int GaB;
  public String GaC;
  public int GaD;
  public LinkedList<dsn> GaE;
  public bai GaF;
  public int Gac;
  public dqz Gad;
  public dqz Gae;
  public int Gaf;
  public int Gag;
  public int Gah;
  public int Gai;
  public SKBuiltinBuffer_t Gaj;
  public int Gak;
  public dqz Gal;
  public int Gam;
  public int Gan;
  public int Gao;
  public int Gap;
  public int Gaq;
  public int Gar;
  public SKBuiltinBuffer_t Gas;
  public SKBuiltinBuffer_t Gat;
  public int Gau;
  public SKBuiltinBuffer_t Gav;
  public int Gaw;
  public int Gax;
  public int Gay;
  public bnb Gaz;
  public int tJb;
  
  public dsm()
  {
    AppMethodBeat.i(115899);
    this.GaE = new LinkedList();
    AppMethodBeat.o(115899);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115900);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FYh == null)
      {
        paramVarArgs = new b("Not all required fields were included: PeerId");
        AppMethodBeat.o(115900);
        throw paramVarArgs;
      }
      if (this.FYi == null)
      {
        paramVarArgs = new b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(115900);
        throw paramVarArgs;
      }
      if (this.FYh != null)
      {
        paramVarArgs.ln(1, this.FYh.computeSize());
        this.FYh.writeFields(paramVarArgs);
      }
      if (this.FYi != null)
      {
        paramVarArgs.ln(2, this.FYi.computeSize());
        this.FYi.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.Gac);
      if (this.Gad != null)
      {
        paramVarArgs.ln(4, this.Gad.computeSize());
        this.Gad.writeFields(paramVarArgs);
      }
      if (this.Gae != null)
      {
        paramVarArgs.ln(5, this.Gae.computeSize());
        this.Gae.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.Gaf);
      paramVarArgs.aR(7, this.Gag);
      paramVarArgs.aR(8, this.Gah);
      paramVarArgs.aR(9, this.Gai);
      if (this.Gaj != null)
      {
        paramVarArgs.ln(10, this.Gaj.computeSize());
        this.Gaj.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.Gak);
      if (this.Gal != null)
      {
        paramVarArgs.ln(12, this.Gal.computeSize());
        this.Gal.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(13, this.Gam);
      paramVarArgs.aR(14, this.Gan);
      paramVarArgs.aR(15, this.Gao);
      paramVarArgs.aR(16, this.Gap);
      paramVarArgs.aR(17, this.Gaq);
      paramVarArgs.aR(18, this.tJb);
      paramVarArgs.aR(19, this.Gar);
      if (this.Gas != null)
      {
        paramVarArgs.ln(20, this.Gas.computeSize());
        this.Gas.writeFields(paramVarArgs);
      }
      if (this.Gat != null)
      {
        paramVarArgs.ln(21, this.Gat.computeSize());
        this.Gat.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(22, this.Gau);
      if (this.Gav != null)
      {
        paramVarArgs.ln(23, this.Gav.computeSize());
        this.Gav.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(24, this.Gaw);
      paramVarArgs.aR(25, this.Gax);
      paramVarArgs.aR(26, this.Gay);
      if (this.Gaz != null)
      {
        paramVarArgs.ln(27, this.Gaz.computeSize());
        this.Gaz.writeFields(paramVarArgs);
      }
      if (this.GaA != null)
      {
        paramVarArgs.ln(28, this.GaA.computeSize());
        this.GaA.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(29, this.GaB);
      if (this.GaC != null) {
        paramVarArgs.d(30, this.GaC);
      }
      paramVarArgs.aR(31, this.GaD);
      paramVarArgs.e(32, 8, this.GaE);
      if (this.FZV != null)
      {
        paramVarArgs.ln(33, this.FZV.computeSize());
        this.FZV.writeFields(paramVarArgs);
      }
      if (this.FZW != null)
      {
        paramVarArgs.ln(34, this.FZW.computeSize());
        this.FZW.writeFields(paramVarArgs);
      }
      if (this.GaF != null)
      {
        paramVarArgs.ln(35, this.GaF.computeSize());
        this.GaF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115900);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FYh == null) {
        break label3482;
      }
    }
    label3482:
    for (paramInt = f.a.a.a.lm(1, this.FYh.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FYi != null) {
        i = paramInt + f.a.a.a.lm(2, this.FYi.computeSize());
      }
      i += f.a.a.b.b.a.bx(3, this.Gac);
      paramInt = i;
      if (this.Gad != null) {
        paramInt = i + f.a.a.a.lm(4, this.Gad.computeSize());
      }
      i = paramInt;
      if (this.Gae != null) {
        i = paramInt + f.a.a.a.lm(5, this.Gae.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(6, this.Gaf) + f.a.a.b.b.a.bx(7, this.Gag) + f.a.a.b.b.a.bx(8, this.Gah) + f.a.a.b.b.a.bx(9, this.Gai);
      paramInt = i;
      if (this.Gaj != null) {
        paramInt = i + f.a.a.a.lm(10, this.Gaj.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(11, this.Gak);
      paramInt = i;
      if (this.Gal != null) {
        paramInt = i + f.a.a.a.lm(12, this.Gal.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(13, this.Gam) + f.a.a.b.b.a.bx(14, this.Gan) + f.a.a.b.b.a.bx(15, this.Gao) + f.a.a.b.b.a.bx(16, this.Gap) + f.a.a.b.b.a.bx(17, this.Gaq) + f.a.a.b.b.a.bx(18, this.tJb) + f.a.a.b.b.a.bx(19, this.Gar);
      paramInt = i;
      if (this.Gas != null) {
        paramInt = i + f.a.a.a.lm(20, this.Gas.computeSize());
      }
      i = paramInt;
      if (this.Gat != null) {
        i = paramInt + f.a.a.a.lm(21, this.Gat.computeSize());
      }
      i += f.a.a.b.b.a.bx(22, this.Gau);
      paramInt = i;
      if (this.Gav != null) {
        paramInt = i + f.a.a.a.lm(23, this.Gav.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(24, this.Gaw) + f.a.a.b.b.a.bx(25, this.Gax) + f.a.a.b.b.a.bx(26, this.Gay);
      paramInt = i;
      if (this.Gaz != null) {
        paramInt = i + f.a.a.a.lm(27, this.Gaz.computeSize());
      }
      i = paramInt;
      if (this.GaA != null) {
        i = paramInt + f.a.a.a.lm(28, this.GaA.computeSize());
      }
      i += f.a.a.b.b.a.bx(29, this.GaB);
      paramInt = i;
      if (this.GaC != null) {
        paramInt = i + f.a.a.b.b.a.e(30, this.GaC);
      }
      i = paramInt + f.a.a.b.b.a.bx(31, this.GaD) + f.a.a.a.c(32, 8, this.GaE);
      paramInt = i;
      if (this.FZV != null) {
        paramInt = i + f.a.a.a.lm(33, this.FZV.computeSize());
      }
      i = paramInt;
      if (this.FZW != null) {
        i = paramInt + f.a.a.a.lm(34, this.FZW.computeSize());
      }
      paramInt = i;
      if (this.GaF != null) {
        paramInt = i + f.a.a.a.lm(35, this.GaF.computeSize());
      }
      AppMethodBeat.o(115900);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GaE.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FYh == null)
        {
          paramVarArgs = new b("Not all required fields were included: PeerId");
          AppMethodBeat.o(115900);
          throw paramVarArgs;
        }
        if (this.FYi == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsm localdsm = (dsm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115900);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dss();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dss)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsm.FYh = ((dss)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dss();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dss)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsm.FYi = ((dss)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 3: 
          localdsm.Gac = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115900);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsm.Gad = ((dqz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsm.Gae = ((dqz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 6: 
          localdsm.Gaf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115900);
          return 0;
        case 7: 
          localdsm.Gag = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115900);
          return 0;
        case 8: 
          localdsm.Gah = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115900);
          return 0;
        case 9: 
          localdsm.Gai = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115900);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsm.Gaj = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 11: 
          localdsm.Gak = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115900);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsm.Gal = ((dqz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 13: 
          localdsm.Gam = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115900);
          return 0;
        case 14: 
          localdsm.Gan = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115900);
          return 0;
        case 15: 
          localdsm.Gao = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115900);
          return 0;
        case 16: 
          localdsm.Gap = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115900);
          return 0;
        case 17: 
          localdsm.Gaq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115900);
          return 0;
        case 18: 
          localdsm.tJb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115900);
          return 0;
        case 19: 
          localdsm.Gar = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115900);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsm.Gas = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsm.Gat = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 22: 
          localdsm.Gau = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115900);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsm.Gav = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 24: 
          localdsm.Gaw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115900);
          return 0;
        case 25: 
          localdsm.Gax = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115900);
          return 0;
        case 26: 
          localdsm.Gay = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115900);
          return 0;
        case 27: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsm.Gaz = ((bnb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 28: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsm.GaA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 29: 
          localdsm.GaB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115900);
          return 0;
        case 30: 
          localdsm.GaC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(115900);
          return 0;
        case 31: 
          localdsm.GaD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115900);
          return 0;
        case 32: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dsn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dsn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsm.GaE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 33: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsm.FZV = ((cnz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 34: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsm.FZW = ((acu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bai();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bai)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdsm.GaF = ((bai)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsm
 * JD-Core Version:    0.7.0.1
 */