package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnc
  extends com.tencent.mm.bw.a
{
  public String Bri;
  public LinkedList<dqi> GroupUser;
  public int MsU;
  public int MsV;
  public LinkedList<cjs> MsW;
  public LinkedList<ebm> MsX;
  public int MsY;
  public long MsZ;
  public int Mta;
  public LinkedList<Long> Mtb;
  public int Mtc;
  public int Mtd;
  public String Mte;
  public int Mtf;
  public eam Mtg;
  public LinkedList<eas> Mth;
  public String Mti;
  public long Mtj;
  public String Mtk;
  public boolean Mtl;
  public dzk Mtm;
  public cwz Mtn;
  public int Privated;
  public String eam;
  public int egZ;
  public int ibG;
  public String izX;
  public String sessionId;
  public String token;
  
  public cnc()
  {
    AppMethodBeat.i(125744);
    this.MsW = new LinkedList();
    this.MsX = new LinkedList();
    this.Mtb = new LinkedList();
    this.GroupUser = new LinkedList();
    this.Mth = new LinkedList();
    AppMethodBeat.o(125744);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125745);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MsU);
      paramVarArgs.aM(2, this.MsV);
      paramVarArgs.aM(3, this.Privated);
      if (this.izX != null) {
        paramVarArgs.e(4, this.izX);
      }
      paramVarArgs.e(5, 8, this.MsW);
      paramVarArgs.e(6, 8, this.MsX);
      paramVarArgs.aM(7, this.MsY);
      paramVarArgs.aM(8, this.ibG);
      paramVarArgs.bb(9, this.MsZ);
      paramVarArgs.aM(10, this.Mta);
      paramVarArgs.e(11, 3, this.Mtb);
      paramVarArgs.aM(12, this.Mtc);
      paramVarArgs.aM(13, this.Mtd);
      if (this.token != null) {
        paramVarArgs.e(14, this.token);
      }
      if (this.Mte != null) {
        paramVarArgs.e(15, this.Mte);
      }
      paramVarArgs.aM(16, this.Mtf);
      paramVarArgs.e(17, 8, this.GroupUser);
      if (this.Mtg != null)
      {
        paramVarArgs.ni(18, this.Mtg.computeSize());
        this.Mtg.writeFields(paramVarArgs);
      }
      if (this.eam != null) {
        paramVarArgs.e(19, this.eam);
      }
      paramVarArgs.e(20, 8, this.Mth);
      if (this.sessionId != null) {
        paramVarArgs.e(21, this.sessionId);
      }
      if (this.Mti != null) {
        paramVarArgs.e(22, this.Mti);
      }
      if (this.Bri != null) {
        paramVarArgs.e(23, this.Bri);
      }
      paramVarArgs.aM(24, this.egZ);
      paramVarArgs.bb(25, this.Mtj);
      if (this.Mtk != null) {
        paramVarArgs.e(26, this.Mtk);
      }
      paramVarArgs.cc(27, this.Mtl);
      if (this.Mtm != null)
      {
        paramVarArgs.ni(28, this.Mtm.computeSize());
        this.Mtm.writeFields(paramVarArgs);
      }
      if (this.Mtn != null)
      {
        paramVarArgs.ni(29, this.Mtn.computeSize());
        this.Mtn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125745);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.MsU) + 0 + g.a.a.b.b.a.bu(2, this.MsV) + g.a.a.b.b.a.bu(3, this.Privated);
      paramInt = i;
      if (this.izX != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.izX);
      }
      i = paramInt + g.a.a.a.c(5, 8, this.MsW) + g.a.a.a.c(6, 8, this.MsX) + g.a.a.b.b.a.bu(7, this.MsY) + g.a.a.b.b.a.bu(8, this.ibG) + g.a.a.b.b.a.r(9, this.MsZ) + g.a.a.b.b.a.bu(10, this.Mta) + g.a.a.a.c(11, 3, this.Mtb) + g.a.a.b.b.a.bu(12, this.Mtc) + g.a.a.b.b.a.bu(13, this.Mtd);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.token);
      }
      i = paramInt;
      if (this.Mte != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.Mte);
      }
      i = i + g.a.a.b.b.a.bu(16, this.Mtf) + g.a.a.a.c(17, 8, this.GroupUser);
      paramInt = i;
      if (this.Mtg != null) {
        paramInt = i + g.a.a.a.nh(18, this.Mtg.computeSize());
      }
      i = paramInt;
      if (this.eam != null) {
        i = paramInt + g.a.a.b.b.a.f(19, this.eam);
      }
      i += g.a.a.a.c(20, 8, this.Mth);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.sessionId);
      }
      i = paramInt;
      if (this.Mti != null) {
        i = paramInt + g.a.a.b.b.a.f(22, this.Mti);
      }
      paramInt = i;
      if (this.Bri != null) {
        paramInt = i + g.a.a.b.b.a.f(23, this.Bri);
      }
      i = paramInt + g.a.a.b.b.a.bu(24, this.egZ) + g.a.a.b.b.a.r(25, this.Mtj);
      paramInt = i;
      if (this.Mtk != null) {
        paramInt = i + g.a.a.b.b.a.f(26, this.Mtk);
      }
      i = paramInt + (g.a.a.b.b.a.fS(27) + 1);
      paramInt = i;
      if (this.Mtm != null) {
        paramInt = i + g.a.a.a.nh(28, this.Mtm.computeSize());
      }
      i = paramInt;
      if (this.Mtn != null) {
        i = paramInt + g.a.a.a.nh(29, this.Mtn.computeSize());
      }
      AppMethodBeat.o(125745);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MsW.clear();
      this.MsX.clear();
      this.Mtb.clear();
      this.GroupUser.clear();
      this.Mth.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(125745);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cnc localcnc = (cnc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125745);
        return -1;
      case 1: 
        localcnc.MsU = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125745);
        return 0;
      case 2: 
        localcnc.MsV = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125745);
        return 0;
      case 3: 
        localcnc.Privated = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125745);
        return 0;
      case 4: 
        localcnc.izX = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjs();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cjs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcnc.MsW.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ebm();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ebm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcnc.MsX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 7: 
        localcnc.MsY = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125745);
        return 0;
      case 8: 
        localcnc.ibG = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125745);
        return 0;
      case 9: 
        localcnc.MsZ = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(125745);
        return 0;
      case 10: 
        localcnc.Mta = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125745);
        return 0;
      case 11: 
        localcnc.Mtb.add(Long.valueOf(((g.a.a.a.a)localObject1).UbS.zl()));
        AppMethodBeat.o(125745);
        return 0;
      case 12: 
        localcnc.Mtc = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125745);
        return 0;
      case 13: 
        localcnc.Mtd = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125745);
        return 0;
      case 14: 
        localcnc.token = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 15: 
        localcnc.Mte = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 16: 
        localcnc.Mtf = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125745);
        return 0;
      case 17: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcnc.GroupUser.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 18: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eam();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eam)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcnc.Mtg = ((eam)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 19: 
        localcnc.eam = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 20: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eas();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eas)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcnc.Mth.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 21: 
        localcnc.sessionId = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 22: 
        localcnc.Mti = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 23: 
        localcnc.Bri = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 24: 
        localcnc.egZ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125745);
        return 0;
      case 25: 
        localcnc.Mtj = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(125745);
        return 0;
      case 26: 
        localcnc.Mtk = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 27: 
        localcnc.Mtl = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(125745);
        return 0;
      case 28: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dzk();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dzk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcnc.Mtm = ((dzk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cwz();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cwz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localcnc.Mtn = ((cwz)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125745);
      return 0;
    }
    AppMethodBeat.o(125745);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnc
 * JD-Core Version:    0.7.0.1
 */