package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fau
  extends com.tencent.mm.bw.a
{
  public egk IDN;
  public long KZg;
  public String KZj;
  public int KZk;
  public String LPT;
  public int MEt;
  public int MRb;
  public int MRf;
  public LinkedList<eou> MUs;
  public chl MlQ;
  public aah MlR;
  public LinkedList<aca> Nva;
  public int NwG;
  public String NwH;
  public int NwV;
  public String NwW;
  public String NwX;
  public int NwY;
  public LinkedList<String> NwZ;
  public LinkedList<ctz> Nxa;
  public com.tencent.mm.bw.b Nxb;
  public com.tencent.mm.bw.b Nxc;
  public dzr Nxd;
  public aev Nxe;
  public dci Nxf;
  public egh Nxg;
  public int Scene;
  public String rBI;
  
  public fau()
  {
    AppMethodBeat.i(117954);
    this.MUs = new LinkedList();
    this.NwZ = new LinkedList();
    this.NwG = 2;
    this.Nva = new LinkedList();
    this.Nxa = new LinkedList();
    AppMethodBeat.o(117954);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117955);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LPT == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Keyword");
        AppMethodBeat.o(117955);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.MRb);
      if (this.LPT != null) {
        paramVarArgs.e(2, this.LPT);
      }
      paramVarArgs.aM(3, this.KZk);
      paramVarArgs.bb(4, this.KZg);
      paramVarArgs.aM(5, this.NwV);
      if (this.MlQ != null)
      {
        paramVarArgs.ni(6, this.MlQ.computeSize());
        this.MlQ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.MUs);
      paramVarArgs.aM(8, this.Scene);
      if (this.KZj != null) {
        paramVarArgs.e(9, this.KZj);
      }
      paramVarArgs.aM(10, this.MRf);
      if (this.NwW != null) {
        paramVarArgs.e(11, this.NwW);
      }
      if (this.NwX != null) {
        paramVarArgs.e(12, this.NwX);
      }
      paramVarArgs.aM(13, this.NwY);
      paramVarArgs.e(14, 1, this.NwZ);
      paramVarArgs.aM(15, this.NwG);
      if (this.IDN != null)
      {
        paramVarArgs.ni(16, this.IDN.computeSize());
        this.IDN.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.Nva);
      paramVarArgs.e(18, 8, this.Nxa);
      if (this.rBI != null) {
        paramVarArgs.e(19, this.rBI);
      }
      if (this.Nxb != null) {
        paramVarArgs.c(20, this.Nxb);
      }
      if (this.NwH != null) {
        paramVarArgs.e(21, this.NwH);
      }
      if (this.Nxc != null) {
        paramVarArgs.c(22, this.Nxc);
      }
      if (this.Nxd != null)
      {
        paramVarArgs.ni(23, this.Nxd.computeSize());
        this.Nxd.writeFields(paramVarArgs);
      }
      if (this.Nxe != null)
      {
        paramVarArgs.ni(24, this.Nxe.computeSize());
        this.Nxe.writeFields(paramVarArgs);
      }
      if (this.Nxf != null)
      {
        paramVarArgs.ni(25, this.Nxf.computeSize());
        this.Nxf.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(26, this.MEt);
      if (this.MlR != null)
      {
        paramVarArgs.ni(27, this.MlR.computeSize());
        this.MlR.writeFields(paramVarArgs);
      }
      if (this.Nxg != null)
      {
        paramVarArgs.ni(28, this.Nxg.computeSize());
        this.Nxg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117955);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.MRb) + 0;
      paramInt = i;
      if (this.LPT != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LPT);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.KZk) + g.a.a.b.b.a.r(4, this.KZg) + g.a.a.b.b.a.bu(5, this.NwV);
      paramInt = i;
      if (this.MlQ != null) {
        paramInt = i + g.a.a.a.nh(6, this.MlQ.computeSize());
      }
      i = paramInt + g.a.a.a.c(7, 8, this.MUs) + g.a.a.b.b.a.bu(8, this.Scene);
      paramInt = i;
      if (this.KZj != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.KZj);
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.MRf);
      paramInt = i;
      if (this.NwW != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.NwW);
      }
      i = paramInt;
      if (this.NwX != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.NwX);
      }
      i = i + g.a.a.b.b.a.bu(13, this.NwY) + g.a.a.a.c(14, 1, this.NwZ) + g.a.a.b.b.a.bu(15, this.NwG);
      paramInt = i;
      if (this.IDN != null) {
        paramInt = i + g.a.a.a.nh(16, this.IDN.computeSize());
      }
      i = paramInt + g.a.a.a.c(17, 8, this.Nva) + g.a.a.a.c(18, 8, this.Nxa);
      paramInt = i;
      if (this.rBI != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.rBI);
      }
      i = paramInt;
      if (this.Nxb != null) {
        i = paramInt + g.a.a.b.b.a.b(20, this.Nxb);
      }
      paramInt = i;
      if (this.NwH != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.NwH);
      }
      i = paramInt;
      if (this.Nxc != null) {
        i = paramInt + g.a.a.b.b.a.b(22, this.Nxc);
      }
      paramInt = i;
      if (this.Nxd != null) {
        paramInt = i + g.a.a.a.nh(23, this.Nxd.computeSize());
      }
      i = paramInt;
      if (this.Nxe != null) {
        i = paramInt + g.a.a.a.nh(24, this.Nxe.computeSize());
      }
      paramInt = i;
      if (this.Nxf != null) {
        paramInt = i + g.a.a.a.nh(25, this.Nxf.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(26, this.MEt);
      paramInt = i;
      if (this.MlR != null) {
        paramInt = i + g.a.a.a.nh(27, this.MlR.computeSize());
      }
      i = paramInt;
      if (this.Nxg != null) {
        i = paramInt + g.a.a.a.nh(28, this.Nxg.computeSize());
      }
      AppMethodBeat.o(117955);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MUs.clear();
      this.NwZ.clear();
      this.Nva.clear();
      this.Nxa.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.LPT == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Keyword");
        AppMethodBeat.o(117955);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117955);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      fau localfau = (fau)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117955);
        return -1;
      case 1: 
        localfau.MRb = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117955);
        return 0;
      case 2: 
        localfau.LPT = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 3: 
        localfau.KZk = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117955);
        return 0;
      case 4: 
        localfau.KZg = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(117955);
        return 0;
      case 5: 
        localfau.NwV = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117955);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((chl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfau.MlQ = ((chl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eou();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eou)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfau.MUs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 8: 
        localfau.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117955);
        return 0;
      case 9: 
        localfau.KZj = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 10: 
        localfau.MRf = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117955);
        return 0;
      case 11: 
        localfau.NwW = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 12: 
        localfau.NwX = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 13: 
        localfau.NwY = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117955);
        return 0;
      case 14: 
        localfau.NwZ.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(117955);
        return 0;
      case 15: 
        localfau.NwG = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117955);
        return 0;
      case 16: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new egk();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((egk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfau.IDN = ((egk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 17: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aca();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aca)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfau.Nva.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 18: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ctz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ctz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfau.Nxa.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 19: 
        localfau.rBI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 20: 
        localfau.Nxb = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(117955);
        return 0;
      case 21: 
        localfau.NwH = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 22: 
        localfau.Nxc = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(117955);
        return 0;
      case 23: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dzr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dzr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfau.Nxd = ((dzr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 24: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aev();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aev)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfau.Nxe = ((aev)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 25: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dci();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dci)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfau.Nxf = ((dci)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 26: 
        localfau.MEt = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117955);
        return 0;
      case 27: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aah();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aah)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfau.MlR = ((aah)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new egh();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((egh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localfau.Nxg = ((egh)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117955);
      return 0;
    }
    AppMethodBeat.o(117955);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fau
 * JD-Core Version:    0.7.0.1
 */