package com.tencent.mm.plugin.multimediareport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bw.a
{
  public long createtime;
  public String fileid;
  public String gTB;
  public int hyI;
  public String md5;
  public String pPz;
  public String qwo;
  public int source;
  public String uuid;
  public long zGI;
  public int zGJ;
  public long zGK;
  public String zGL;
  public String zGM;
  public int zGN;
  public int zGO;
  public int zGP;
  public int zGQ;
  public String zGR;
  public String zGS;
  public int zGT;
  public b zGU;
  public LinkedList<a> zGV;
  
  public d()
  {
    AppMethodBeat.i(194274);
    this.zGV = new LinkedList();
    AppMethodBeat.o(194274);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194275);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.zGI);
      paramVarArgs.aM(2, this.zGJ);
      paramVarArgs.aM(3, this.source);
      paramVarArgs.bb(4, this.zGK);
      if (this.pPz != null) {
        paramVarArgs.e(5, this.pPz);
      }
      if (this.zGL != null) {
        paramVarArgs.e(6, this.zGL);
      }
      if (this.fileid != null) {
        paramVarArgs.e(7, this.fileid);
      }
      if (this.zGM != null) {
        paramVarArgs.e(8, this.zGM);
      }
      if (this.md5 != null) {
        paramVarArgs.e(9, this.md5);
      }
      paramVarArgs.bb(10, this.createtime);
      paramVarArgs.aM(11, this.zGN);
      paramVarArgs.aM(12, this.zGO);
      if (this.gTB != null) {
        paramVarArgs.e(13, this.gTB);
      }
      paramVarArgs.aM(14, this.zGP);
      paramVarArgs.aM(15, this.hyI);
      paramVarArgs.aM(16, this.zGQ);
      if (this.zGR != null) {
        paramVarArgs.e(17, this.zGR);
      }
      if (this.zGS != null) {
        paramVarArgs.e(18, this.zGS);
      }
      if (this.qwo != null) {
        paramVarArgs.e(19, this.qwo);
      }
      paramVarArgs.aM(20, this.zGT);
      if (this.uuid != null) {
        paramVarArgs.e(21, this.uuid);
      }
      if (this.zGU != null) {
        paramVarArgs.c(22, this.zGU);
      }
      paramVarArgs.e(23, 8, this.zGV);
      AppMethodBeat.o(194275);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.zGI) + 0 + g.a.a.b.b.a.bu(2, this.zGJ) + g.a.a.b.b.a.bu(3, this.source) + g.a.a.b.b.a.r(4, this.zGK);
      paramInt = i;
      if (this.pPz != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.pPz);
      }
      i = paramInt;
      if (this.zGL != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.zGL);
      }
      paramInt = i;
      if (this.fileid != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.fileid);
      }
      i = paramInt;
      if (this.zGM != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.zGM);
      }
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.md5);
      }
      i = paramInt + g.a.a.b.b.a.r(10, this.createtime) + g.a.a.b.b.a.bu(11, this.zGN) + g.a.a.b.b.a.bu(12, this.zGO);
      paramInt = i;
      if (this.gTB != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.gTB);
      }
      i = paramInt + g.a.a.b.b.a.bu(14, this.zGP) + g.a.a.b.b.a.bu(15, this.hyI) + g.a.a.b.b.a.bu(16, this.zGQ);
      paramInt = i;
      if (this.zGR != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.zGR);
      }
      i = paramInt;
      if (this.zGS != null) {
        i = paramInt + g.a.a.b.b.a.f(18, this.zGS);
      }
      paramInt = i;
      if (this.qwo != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.qwo);
      }
      i = paramInt + g.a.a.b.b.a.bu(20, this.zGT);
      paramInt = i;
      if (this.uuid != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.uuid);
      }
      i = paramInt;
      if (this.zGU != null) {
        i = paramInt + g.a.a.b.b.a.b(22, this.zGU);
      }
      paramInt = g.a.a.a.c(23, 8, this.zGV);
      AppMethodBeat.o(194275);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.zGV.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(194275);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(194275);
        return -1;
      case 1: 
        locald.zGI = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(194275);
        return 0;
      case 2: 
        locald.zGJ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(194275);
        return 0;
      case 3: 
        locald.source = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(194275);
        return 0;
      case 4: 
        locald.zGK = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(194275);
        return 0;
      case 5: 
        locald.pPz = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194275);
        return 0;
      case 6: 
        locald.zGL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194275);
        return 0;
      case 7: 
        locald.fileid = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194275);
        return 0;
      case 8: 
        locald.zGM = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194275);
        return 0;
      case 9: 
        locald.md5 = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194275);
        return 0;
      case 10: 
        locald.createtime = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(194275);
        return 0;
      case 11: 
        locald.zGN = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(194275);
        return 0;
      case 12: 
        locald.zGO = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(194275);
        return 0;
      case 13: 
        locald.gTB = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194275);
        return 0;
      case 14: 
        locald.zGP = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(194275);
        return 0;
      case 15: 
        locald.hyI = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(194275);
        return 0;
      case 16: 
        locald.zGQ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(194275);
        return 0;
      case 17: 
        locald.zGR = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194275);
        return 0;
      case 18: 
        locald.zGS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194275);
        return 0;
      case 19: 
        locald.qwo = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194275);
        return 0;
      case 20: 
        locald.zGT = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(194275);
        return 0;
      case 21: 
        locald.uuid = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194275);
        return 0;
      case 22: 
        locald.zGU = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(194275);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new a();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        locald.zGV.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(194275);
      return 0;
    }
    AppMethodBeat.o(194275);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multimediareport.d
 * JD-Core Version:    0.7.0.1
 */