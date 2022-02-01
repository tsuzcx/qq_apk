package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cne
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public int Mpa;
  public String MsS;
  public int MsU;
  public int MsV;
  public int Mtd;
  public String Mte;
  public cmw Mtr;
  public int Mts;
  public LinkedList<cmw> Mtt;
  public String Mtu;
  public String Mtv;
  public String Mtw;
  public cly Mtx;
  public int Mty;
  public int Privated;
  public int beK;
  public int dJi;
  public String dNI;
  public int ibG;
  public String md5;
  public String token;
  public String videoPath;
  
  public cne()
  {
    AppMethodBeat.i(125747);
    this.Mtt = new LinkedList();
    AppMethodBeat.o(125747);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125748);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MsU);
      paramVarArgs.aM(2, this.MsV);
      paramVarArgs.aM(3, this.Privated);
      if (this.Mtr != null)
      {
        paramVarArgs.ni(4, this.Mtr.computeSize());
        this.Mtr.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.Mts);
      paramVarArgs.e(6, 8, this.Mtt);
      paramVarArgs.aM(7, this.ibG);
      paramVarArgs.aM(8, this.Mpa);
      if (this.Desc != null) {
        paramVarArgs.e(9, this.Desc);
      }
      if (this.Mtu != null) {
        paramVarArgs.e(10, this.Mtu);
      }
      if (this.token != null) {
        paramVarArgs.e(11, this.token);
      }
      if (this.Mte != null) {
        paramVarArgs.e(12, this.Mte);
      }
      paramVarArgs.aM(13, this.Mtd);
      if (this.videoPath != null) {
        paramVarArgs.e(14, this.videoPath);
      }
      if (this.Mtv != null) {
        paramVarArgs.e(15, this.Mtv);
      }
      if (this.Mtw != null) {
        paramVarArgs.e(16, this.Mtw);
      }
      if (this.md5 != null) {
        paramVarArgs.e(17, this.md5);
      }
      if (this.dNI != null) {
        paramVarArgs.e(18, this.dNI);
      }
      paramVarArgs.aM(19, this.beK);
      paramVarArgs.aM(20, this.dJi);
      if (this.MsS != null) {
        paramVarArgs.e(21, this.MsS);
      }
      if (this.Mtx != null)
      {
        paramVarArgs.ni(22, this.Mtx.computeSize());
        this.Mtx.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(23, this.Mty);
      AppMethodBeat.o(125748);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.MsU) + 0 + g.a.a.b.b.a.bu(2, this.MsV) + g.a.a.b.b.a.bu(3, this.Privated);
      paramInt = i;
      if (this.Mtr != null) {
        paramInt = i + g.a.a.a.nh(4, this.Mtr.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.Mts) + g.a.a.a.c(6, 8, this.Mtt) + g.a.a.b.b.a.bu(7, this.ibG) + g.a.a.b.b.a.bu(8, this.Mpa);
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.Desc);
      }
      i = paramInt;
      if (this.Mtu != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.Mtu);
      }
      paramInt = i;
      if (this.token != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.token);
      }
      i = paramInt;
      if (this.Mte != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.Mte);
      }
      i += g.a.a.b.b.a.bu(13, this.Mtd);
      paramInt = i;
      if (this.videoPath != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.videoPath);
      }
      i = paramInt;
      if (this.Mtv != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.Mtv);
      }
      paramInt = i;
      if (this.Mtw != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.Mtw);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.md5);
      }
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.dNI);
      }
      i = paramInt + g.a.a.b.b.a.bu(19, this.beK) + g.a.a.b.b.a.bu(20, this.dJi);
      paramInt = i;
      if (this.MsS != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.MsS);
      }
      i = paramInt;
      if (this.Mtx != null) {
        i = paramInt + g.a.a.a.nh(22, this.Mtx.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(23, this.Mty);
      AppMethodBeat.o(125748);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Mtt.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(125748);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cne localcne = (cne)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125748);
        return -1;
      case 1: 
        localcne.MsU = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125748);
        return 0;
      case 2: 
        localcne.MsV = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125748);
        return 0;
      case 3: 
        localcne.Privated = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125748);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcne.Mtr = ((cmw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      case 5: 
        localcne.Mts = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125748);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcne.Mtt.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      case 7: 
        localcne.ibG = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125748);
        return 0;
      case 8: 
        localcne.Mpa = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125748);
        return 0;
      case 9: 
        localcne.Desc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 10: 
        localcne.Mtu = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 11: 
        localcne.token = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 12: 
        localcne.Mte = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 13: 
        localcne.Mtd = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125748);
        return 0;
      case 14: 
        localcne.videoPath = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 15: 
        localcne.Mtv = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 16: 
        localcne.Mtw = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 17: 
        localcne.md5 = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 18: 
        localcne.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 19: 
        localcne.beK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125748);
        return 0;
      case 20: 
        localcne.dJi = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125748);
        return 0;
      case 21: 
        localcne.MsS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 22: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cly();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cly)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcne.Mtx = ((cly)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      }
      localcne.Mty = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(125748);
      return 0;
    }
    AppMethodBeat.o(125748);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cne
 * JD-Core Version:    0.7.0.1
 */