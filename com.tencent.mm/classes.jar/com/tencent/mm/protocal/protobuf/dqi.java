package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqi
  extends com.tencent.mm.bw.a
{
  public bld EgF;
  public pz EgI;
  public dhb Ete;
  public bf FEk;
  public cqx FIk;
  public rp FXA;
  public zk FXB;
  public ip FXC;
  public bpz FXD;
  public bin FXE;
  public cby FXF;
  public blw FXG;
  public blx FXH;
  public dgh FXI;
  public yz FXJ;
  public qa FXK;
  public dql FXL;
  public dfw FXw;
  public czd FXx;
  public bxa FXy;
  public bxn FXz;
  public che FpV;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91724);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.Ete != null)
      {
        paramVarArgs.ln(2, this.Ete.computeSize());
        this.Ete.writeFields(paramVarArgs);
      }
      if (this.FIk != null)
      {
        paramVarArgs.ln(3, this.FIk.computeSize());
        this.FIk.writeFields(paramVarArgs);
      }
      if (this.FXw != null)
      {
        paramVarArgs.ln(4, this.FXw.computeSize());
        this.FXw.writeFields(paramVarArgs);
      }
      if (this.FXx != null)
      {
        paramVarArgs.ln(5, this.FXx.computeSize());
        this.FXx.writeFields(paramVarArgs);
      }
      if (this.FXy != null)
      {
        paramVarArgs.ln(6, this.FXy.computeSize());
        this.FXy.writeFields(paramVarArgs);
      }
      if (this.FXz != null)
      {
        paramVarArgs.ln(7, this.FXz.computeSize());
        this.FXz.writeFields(paramVarArgs);
      }
      if (this.FXA != null)
      {
        paramVarArgs.ln(8, this.FXA.computeSize());
        this.FXA.writeFields(paramVarArgs);
      }
      if (this.FXB != null)
      {
        paramVarArgs.ln(9, this.FXB.computeSize());
        this.FXB.writeFields(paramVarArgs);
      }
      if (this.FXC != null)
      {
        paramVarArgs.ln(10, this.FXC.computeSize());
        this.FXC.writeFields(paramVarArgs);
      }
      if (this.EgI != null)
      {
        paramVarArgs.ln(11, this.EgI.computeSize());
        this.EgI.writeFields(paramVarArgs);
      }
      if (this.EgF != null)
      {
        paramVarArgs.ln(12, this.EgF.computeSize());
        this.EgF.writeFields(paramVarArgs);
      }
      if (this.FXD != null)
      {
        paramVarArgs.ln(13, this.FXD.computeSize());
        this.FXD.writeFields(paramVarArgs);
      }
      if (this.FXE != null)
      {
        paramVarArgs.ln(14, this.FXE.computeSize());
        this.FXE.writeFields(paramVarArgs);
      }
      if (this.FpV != null)
      {
        paramVarArgs.ln(15, this.FpV.computeSize());
        this.FpV.writeFields(paramVarArgs);
      }
      if (this.FXF != null)
      {
        paramVarArgs.ln(16, this.FXF.computeSize());
        this.FXF.writeFields(paramVarArgs);
      }
      if (this.FXG != null)
      {
        paramVarArgs.ln(17, this.FXG.computeSize());
        this.FXG.writeFields(paramVarArgs);
      }
      if (this.FXH != null)
      {
        paramVarArgs.ln(18, this.FXH.computeSize());
        this.FXH.writeFields(paramVarArgs);
      }
      if (this.FXI != null)
      {
        paramVarArgs.ln(19, this.FXI.computeSize());
        this.FXI.writeFields(paramVarArgs);
      }
      if (this.FXJ != null)
      {
        paramVarArgs.ln(20, this.FXJ.computeSize());
        this.FXJ.writeFields(paramVarArgs);
      }
      if (this.FXK != null)
      {
        paramVarArgs.ln(21, this.FXK.computeSize());
        this.FXK.writeFields(paramVarArgs);
      }
      if (this.FEk != null)
      {
        paramVarArgs.ln(22, this.FEk.computeSize());
        this.FEk.writeFields(paramVarArgs);
      }
      if (this.FXL != null)
      {
        paramVarArgs.ln(23, this.FXL.computeSize());
        this.FXL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91724);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.type) + 0;
      paramInt = i;
      if (this.Ete != null) {
        paramInt = i + f.a.a.a.lm(2, this.Ete.computeSize());
      }
      i = paramInt;
      if (this.FIk != null) {
        i = paramInt + f.a.a.a.lm(3, this.FIk.computeSize());
      }
      paramInt = i;
      if (this.FXw != null) {
        paramInt = i + f.a.a.a.lm(4, this.FXw.computeSize());
      }
      i = paramInt;
      if (this.FXx != null) {
        i = paramInt + f.a.a.a.lm(5, this.FXx.computeSize());
      }
      paramInt = i;
      if (this.FXy != null) {
        paramInt = i + f.a.a.a.lm(6, this.FXy.computeSize());
      }
      i = paramInt;
      if (this.FXz != null) {
        i = paramInt + f.a.a.a.lm(7, this.FXz.computeSize());
      }
      paramInt = i;
      if (this.FXA != null) {
        paramInt = i + f.a.a.a.lm(8, this.FXA.computeSize());
      }
      i = paramInt;
      if (this.FXB != null) {
        i = paramInt + f.a.a.a.lm(9, this.FXB.computeSize());
      }
      paramInt = i;
      if (this.FXC != null) {
        paramInt = i + f.a.a.a.lm(10, this.FXC.computeSize());
      }
      i = paramInt;
      if (this.EgI != null) {
        i = paramInt + f.a.a.a.lm(11, this.EgI.computeSize());
      }
      paramInt = i;
      if (this.EgF != null) {
        paramInt = i + f.a.a.a.lm(12, this.EgF.computeSize());
      }
      i = paramInt;
      if (this.FXD != null) {
        i = paramInt + f.a.a.a.lm(13, this.FXD.computeSize());
      }
      paramInt = i;
      if (this.FXE != null) {
        paramInt = i + f.a.a.a.lm(14, this.FXE.computeSize());
      }
      i = paramInt;
      if (this.FpV != null) {
        i = paramInt + f.a.a.a.lm(15, this.FpV.computeSize());
      }
      paramInt = i;
      if (this.FXF != null) {
        paramInt = i + f.a.a.a.lm(16, this.FXF.computeSize());
      }
      i = paramInt;
      if (this.FXG != null) {
        i = paramInt + f.a.a.a.lm(17, this.FXG.computeSize());
      }
      paramInt = i;
      if (this.FXH != null) {
        paramInt = i + f.a.a.a.lm(18, this.FXH.computeSize());
      }
      i = paramInt;
      if (this.FXI != null) {
        i = paramInt + f.a.a.a.lm(19, this.FXI.computeSize());
      }
      paramInt = i;
      if (this.FXJ != null) {
        paramInt = i + f.a.a.a.lm(20, this.FXJ.computeSize());
      }
      i = paramInt;
      if (this.FXK != null) {
        i = paramInt + f.a.a.a.lm(21, this.FXK.computeSize());
      }
      paramInt = i;
      if (this.FEk != null) {
        paramInt = i + f.a.a.a.lm(22, this.FEk.computeSize());
      }
      i = paramInt;
      if (this.FXL != null) {
        i = paramInt + f.a.a.a.lm(23, this.FXL.computeSize());
      }
      AppMethodBeat.o(91724);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91724);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dqi localdqi = (dqi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91724);
        return -1;
      case 1: 
        localdqi.type = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91724);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dhb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.Ete = ((dhb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cqx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cqx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.FIk = ((cqx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dfw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.FXw = ((dfw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new czd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((czd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.FXx = ((czd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxa();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.FXy = ((bxa)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.FXz = ((bxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.FXA = ((rp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.FXB = ((zk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ip();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.FXC = ((ip)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.EgI = ((pz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bld();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bld)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.EgF = ((bld)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.FXD = ((bpz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 14: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bin();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bin)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.FXE = ((bin)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new che();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((che)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.FpV = ((che)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cby();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cby)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.FXF = ((cby)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 17: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new blw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((blw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.FXG = ((blw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 18: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new blx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((blx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.FXH = ((blx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 19: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dgh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dgh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.FXI = ((dgh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 20: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.FXJ = ((yz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 21: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qa();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.FXK = ((qa)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 22: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqi.FEk = ((bf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dql();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dql)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdqi.FXL = ((dql)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91724);
      return 0;
    }
    AppMethodBeat.o(91724);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqi
 * JD-Core Version:    0.7.0.1
 */