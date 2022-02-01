package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ty
  extends com.tencent.mm.bw.a
{
  public abz LcA;
  public agz LcB;
  public String LcC;
  public abz LcD;
  public String LcE;
  public abz LcF;
  public boolean LcG;
  public boolean LcH;
  public int Lck;
  public int Lcl;
  public LinkedList<vj> Lcm;
  public LinkedList<vj> Lcn;
  public LinkedList<vj> Lco;
  public LinkedList<String> Lcp;
  public int Lcq;
  public int Lcr;
  public LinkedList<abz> Lcs;
  public long Lct;
  public int Lcu;
  public String Lcv;
  public abz Lcw;
  public LinkedList<bg> Lcx;
  public abz Lcy;
  public abz Lcz;
  public String code;
  public int status;
  
  public ty()
  {
    AppMethodBeat.i(113948);
    this.Lcm = new LinkedList();
    this.Lcn = new LinkedList();
    this.Lco = new LinkedList();
    this.Lcp = new LinkedList();
    this.Lcs = new LinkedList();
    this.Lcx = new LinkedList();
    AppMethodBeat.o(113948);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113949);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.status);
      paramVarArgs.aM(2, this.Lck);
      paramVarArgs.aM(3, this.Lcl);
      paramVarArgs.e(4, 8, this.Lcm);
      paramVarArgs.e(5, 8, this.Lcn);
      paramVarArgs.e(6, 8, this.Lco);
      paramVarArgs.e(7, 1, this.Lcp);
      paramVarArgs.aM(8, this.Lcq);
      if (this.code != null) {
        paramVarArgs.e(9, this.code);
      }
      paramVarArgs.aM(10, this.Lcr);
      paramVarArgs.e(11, 8, this.Lcs);
      paramVarArgs.bb(12, this.Lct);
      paramVarArgs.aM(13, this.Lcu);
      if (this.Lcv != null) {
        paramVarArgs.e(14, this.Lcv);
      }
      if (this.Lcw != null)
      {
        paramVarArgs.ni(15, this.Lcw.computeSize());
        this.Lcw.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.Lcx);
      if (this.Lcy != null)
      {
        paramVarArgs.ni(17, this.Lcy.computeSize());
        this.Lcy.writeFields(paramVarArgs);
      }
      if (this.Lcz != null)
      {
        paramVarArgs.ni(18, this.Lcz.computeSize());
        this.Lcz.writeFields(paramVarArgs);
      }
      if (this.LcA != null)
      {
        paramVarArgs.ni(19, this.LcA.computeSize());
        this.LcA.writeFields(paramVarArgs);
      }
      if (this.LcB != null)
      {
        paramVarArgs.ni(20, this.LcB.computeSize());
        this.LcB.writeFields(paramVarArgs);
      }
      if (this.LcC != null) {
        paramVarArgs.e(21, this.LcC);
      }
      if (this.LcD != null)
      {
        paramVarArgs.ni(22, this.LcD.computeSize());
        this.LcD.writeFields(paramVarArgs);
      }
      if (this.LcE != null) {
        paramVarArgs.e(23, this.LcE);
      }
      if (this.LcF != null)
      {
        paramVarArgs.ni(24, this.LcF.computeSize());
        this.LcF.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(25, this.LcG);
      paramVarArgs.cc(26, this.LcH);
      AppMethodBeat.o(113949);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.status) + 0 + g.a.a.b.b.a.bu(2, this.Lck) + g.a.a.b.b.a.bu(3, this.Lcl) + g.a.a.a.c(4, 8, this.Lcm) + g.a.a.a.c(5, 8, this.Lcn) + g.a.a.a.c(6, 8, this.Lco) + g.a.a.a.c(7, 1, this.Lcp) + g.a.a.b.b.a.bu(8, this.Lcq);
      paramInt = i;
      if (this.code != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.code);
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.Lcr) + g.a.a.a.c(11, 8, this.Lcs) + g.a.a.b.b.a.r(12, this.Lct) + g.a.a.b.b.a.bu(13, this.Lcu);
      paramInt = i;
      if (this.Lcv != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.Lcv);
      }
      i = paramInt;
      if (this.Lcw != null) {
        i = paramInt + g.a.a.a.nh(15, this.Lcw.computeSize());
      }
      i += g.a.a.a.c(16, 8, this.Lcx);
      paramInt = i;
      if (this.Lcy != null) {
        paramInt = i + g.a.a.a.nh(17, this.Lcy.computeSize());
      }
      i = paramInt;
      if (this.Lcz != null) {
        i = paramInt + g.a.a.a.nh(18, this.Lcz.computeSize());
      }
      paramInt = i;
      if (this.LcA != null) {
        paramInt = i + g.a.a.a.nh(19, this.LcA.computeSize());
      }
      i = paramInt;
      if (this.LcB != null) {
        i = paramInt + g.a.a.a.nh(20, this.LcB.computeSize());
      }
      paramInt = i;
      if (this.LcC != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.LcC);
      }
      i = paramInt;
      if (this.LcD != null) {
        i = paramInt + g.a.a.a.nh(22, this.LcD.computeSize());
      }
      paramInt = i;
      if (this.LcE != null) {
        paramInt = i + g.a.a.b.b.a.f(23, this.LcE);
      }
      i = paramInt;
      if (this.LcF != null) {
        i = paramInt + g.a.a.a.nh(24, this.LcF.computeSize());
      }
      paramInt = g.a.a.b.b.a.fS(25);
      int j = g.a.a.b.b.a.fS(26);
      AppMethodBeat.o(113949);
      return i + (paramInt + 1) + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lcm.clear();
      this.Lcn.clear();
      this.Lco.clear();
      this.Lcp.clear();
      this.Lcs.clear();
      this.Lcx.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(113949);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ty localty = (ty)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(113949);
        return -1;
      case 1: 
        localty.status = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(113949);
        return 0;
      case 2: 
        localty.Lck = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(113949);
        return 0;
      case 3: 
        localty.Lcl = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(113949);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new vj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((vj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localty.Lcm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new vj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((vj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localty.Lcn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new vj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((vj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localty.Lco.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 7: 
        localty.Lcp.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(113949);
        return 0;
      case 8: 
        localty.Lcq = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(113949);
        return 0;
      case 9: 
        localty.code = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 10: 
        localty.Lcr = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(113949);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localty.Lcs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 12: 
        localty.Lct = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(113949);
        return 0;
      case 13: 
        localty.Lcu = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(113949);
        return 0;
      case 14: 
        localty.Lcv = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 15: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localty.Lcw = ((abz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 16: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localty.Lcx.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 17: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localty.Lcy = ((abz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 18: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localty.Lcz = ((abz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 19: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localty.LcA = ((abz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 20: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new agz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((agz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localty.LcB = ((agz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 21: 
        localty.LcC = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 22: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localty.LcD = ((abz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 23: 
        localty.LcE = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 24: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localty.LcF = ((abz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 25: 
        localty.LcG = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(113949);
        return 0;
      }
      localty.LcH = ((g.a.a.a.a)localObject1).UbS.yZ();
      AppMethodBeat.o(113949);
      return 0;
    }
    AppMethodBeat.o(113949);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ty
 * JD-Core Version:    0.7.0.1
 */