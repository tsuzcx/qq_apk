package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwv
  extends com.tencent.mm.bw.a
{
  public bqg GfD;
  public rg GfG;
  public dnl Gtc;
  public bf HIb;
  public cww HMv;
  public cmx Htg;
  public dmg IbX;
  public dfk IbY;
  public cck IbZ;
  public ccy Ica;
  public tl Icb;
  public abt Icc;
  public iw Icd;
  public bvg Ice;
  public bnn Icf;
  public chj Icg;
  public bra Ich;
  public brb Ici;
  public dmr Icj;
  public abi Ick;
  public rh Icl;
  public dxa Icm;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91724);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.Gtc != null)
      {
        paramVarArgs.lJ(2, this.Gtc.computeSize());
        this.Gtc.writeFields(paramVarArgs);
      }
      if (this.HMv != null)
      {
        paramVarArgs.lJ(3, this.HMv.computeSize());
        this.HMv.writeFields(paramVarArgs);
      }
      if (this.IbX != null)
      {
        paramVarArgs.lJ(4, this.IbX.computeSize());
        this.IbX.writeFields(paramVarArgs);
      }
      if (this.IbY != null)
      {
        paramVarArgs.lJ(5, this.IbY.computeSize());
        this.IbY.writeFields(paramVarArgs);
      }
      if (this.IbZ != null)
      {
        paramVarArgs.lJ(6, this.IbZ.computeSize());
        this.IbZ.writeFields(paramVarArgs);
      }
      if (this.Ica != null)
      {
        paramVarArgs.lJ(7, this.Ica.computeSize());
        this.Ica.writeFields(paramVarArgs);
      }
      if (this.Icb != null)
      {
        paramVarArgs.lJ(8, this.Icb.computeSize());
        this.Icb.writeFields(paramVarArgs);
      }
      if (this.Icc != null)
      {
        paramVarArgs.lJ(9, this.Icc.computeSize());
        this.Icc.writeFields(paramVarArgs);
      }
      if (this.Icd != null)
      {
        paramVarArgs.lJ(10, this.Icd.computeSize());
        this.Icd.writeFields(paramVarArgs);
      }
      if (this.GfG != null)
      {
        paramVarArgs.lJ(11, this.GfG.computeSize());
        this.GfG.writeFields(paramVarArgs);
      }
      if (this.GfD != null)
      {
        paramVarArgs.lJ(12, this.GfD.computeSize());
        this.GfD.writeFields(paramVarArgs);
      }
      if (this.Ice != null)
      {
        paramVarArgs.lJ(13, this.Ice.computeSize());
        this.Ice.writeFields(paramVarArgs);
      }
      if (this.Icf != null)
      {
        paramVarArgs.lJ(14, this.Icf.computeSize());
        this.Icf.writeFields(paramVarArgs);
      }
      if (this.Htg != null)
      {
        paramVarArgs.lJ(15, this.Htg.computeSize());
        this.Htg.writeFields(paramVarArgs);
      }
      if (this.Icg != null)
      {
        paramVarArgs.lJ(16, this.Icg.computeSize());
        this.Icg.writeFields(paramVarArgs);
      }
      if (this.Ich != null)
      {
        paramVarArgs.lJ(17, this.Ich.computeSize());
        this.Ich.writeFields(paramVarArgs);
      }
      if (this.Ici != null)
      {
        paramVarArgs.lJ(18, this.Ici.computeSize());
        this.Ici.writeFields(paramVarArgs);
      }
      if (this.Icj != null)
      {
        paramVarArgs.lJ(19, this.Icj.computeSize());
        this.Icj.writeFields(paramVarArgs);
      }
      if (this.Ick != null)
      {
        paramVarArgs.lJ(20, this.Ick.computeSize());
        this.Ick.writeFields(paramVarArgs);
      }
      if (this.Icl != null)
      {
        paramVarArgs.lJ(21, this.Icl.computeSize());
        this.Icl.writeFields(paramVarArgs);
      }
      if (this.HIb != null)
      {
        paramVarArgs.lJ(22, this.HIb.computeSize());
        this.HIb.writeFields(paramVarArgs);
      }
      if (this.Icm != null)
      {
        paramVarArgs.lJ(23, this.Icm.computeSize());
        this.Icm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91724);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.Gtc != null) {
        paramInt = i + f.a.a.a.lI(2, this.Gtc.computeSize());
      }
      i = paramInt;
      if (this.HMv != null) {
        i = paramInt + f.a.a.a.lI(3, this.HMv.computeSize());
      }
      paramInt = i;
      if (this.IbX != null) {
        paramInt = i + f.a.a.a.lI(4, this.IbX.computeSize());
      }
      i = paramInt;
      if (this.IbY != null) {
        i = paramInt + f.a.a.a.lI(5, this.IbY.computeSize());
      }
      paramInt = i;
      if (this.IbZ != null) {
        paramInt = i + f.a.a.a.lI(6, this.IbZ.computeSize());
      }
      i = paramInt;
      if (this.Ica != null) {
        i = paramInt + f.a.a.a.lI(7, this.Ica.computeSize());
      }
      paramInt = i;
      if (this.Icb != null) {
        paramInt = i + f.a.a.a.lI(8, this.Icb.computeSize());
      }
      i = paramInt;
      if (this.Icc != null) {
        i = paramInt + f.a.a.a.lI(9, this.Icc.computeSize());
      }
      paramInt = i;
      if (this.Icd != null) {
        paramInt = i + f.a.a.a.lI(10, this.Icd.computeSize());
      }
      i = paramInt;
      if (this.GfG != null) {
        i = paramInt + f.a.a.a.lI(11, this.GfG.computeSize());
      }
      paramInt = i;
      if (this.GfD != null) {
        paramInt = i + f.a.a.a.lI(12, this.GfD.computeSize());
      }
      i = paramInt;
      if (this.Ice != null) {
        i = paramInt + f.a.a.a.lI(13, this.Ice.computeSize());
      }
      paramInt = i;
      if (this.Icf != null) {
        paramInt = i + f.a.a.a.lI(14, this.Icf.computeSize());
      }
      i = paramInt;
      if (this.Htg != null) {
        i = paramInt + f.a.a.a.lI(15, this.Htg.computeSize());
      }
      paramInt = i;
      if (this.Icg != null) {
        paramInt = i + f.a.a.a.lI(16, this.Icg.computeSize());
      }
      i = paramInt;
      if (this.Ich != null) {
        i = paramInt + f.a.a.a.lI(17, this.Ich.computeSize());
      }
      paramInt = i;
      if (this.Ici != null) {
        paramInt = i + f.a.a.a.lI(18, this.Ici.computeSize());
      }
      i = paramInt;
      if (this.Icj != null) {
        i = paramInt + f.a.a.a.lI(19, this.Icj.computeSize());
      }
      paramInt = i;
      if (this.Ick != null) {
        paramInt = i + f.a.a.a.lI(20, this.Ick.computeSize());
      }
      i = paramInt;
      if (this.Icl != null) {
        i = paramInt + f.a.a.a.lI(21, this.Icl.computeSize());
      }
      paramInt = i;
      if (this.HIb != null) {
        paramInt = i + f.a.a.a.lI(22, this.HIb.computeSize());
      }
      i = paramInt;
      if (this.Icm != null) {
        i = paramInt + f.a.a.a.lI(23, this.Icm.computeSize());
      }
      AppMethodBeat.o(91724);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91724);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dwv localdwv = (dwv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91724);
        return -1;
      case 1: 
        localdwv.type = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91724);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dnl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.Gtc = ((dnl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cww();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cww)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.HMv = ((cww)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dmg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dmg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.IbX = ((dmg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dfk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.IbY = ((dfk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cck();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cck)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.IbZ = ((cck)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.Ica = ((ccy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new tl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((tl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.Icb = ((tl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.Icc = ((abt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new iw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((iw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.Icd = ((iw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.GfG = ((rg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bqg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bqg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.GfD = ((bqg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.Ice = ((bvg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 14: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bnn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bnn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.Icf = ((bnn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.Htg = ((cmx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((chj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.Icg = ((chj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 17: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bra();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bra)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.Ich = ((bra)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 18: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new brb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((brb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.Ici = ((brb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 19: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dmr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dmr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.Icj = ((dmr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 20: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.Ick = ((abi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 21: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.Icl = ((rh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 22: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwv.HIb = ((bf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dxa();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dxa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdwv.Icm = ((dxa)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91724);
      return 0;
    }
    AppMethodBeat.o(91724);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwv
 * JD-Core Version:    0.7.0.1
 */