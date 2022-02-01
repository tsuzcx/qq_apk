package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class civ
  extends com.tencent.mm.bw.a
{
  public int Gaz;
  public boolean KNv;
  public int LIa;
  public int LXG;
  public boolean Lml;
  public String LpF;
  public int MnH;
  public String MnI;
  public LinkedList<String> MnJ;
  public boolean MnK;
  public String MnL;
  public String MnM;
  public String MnN;
  public String MnO;
  public int MnP;
  public xf MnQ;
  public long hyH;
  public int pSb;
  public int status;
  
  public civ()
  {
    AppMethodBeat.i(207498);
    this.MnJ = new LinkedList();
    AppMethodBeat.o(207498);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207499);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.hyH);
      if (this.LpF != null) {
        paramVarArgs.e(2, this.LpF);
      }
      paramVarArgs.aM(3, this.Gaz);
      paramVarArgs.aM(4, this.pSb);
      paramVarArgs.aM(5, this.status);
      paramVarArgs.aM(6, this.LIa);
      paramVarArgs.aM(7, this.MnH);
      paramVarArgs.aM(8, this.LXG);
      if (this.MnI != null) {
        paramVarArgs.e(9, this.MnI);
      }
      paramVarArgs.e(10, 1, this.MnJ);
      paramVarArgs.cc(11, this.KNv);
      paramVarArgs.cc(12, this.Lml);
      paramVarArgs.cc(13, this.MnK);
      if (this.MnL != null) {
        paramVarArgs.e(14, this.MnL);
      }
      if (this.MnM != null) {
        paramVarArgs.e(15, this.MnM);
      }
      if (this.MnN != null) {
        paramVarArgs.e(16, this.MnN);
      }
      if (this.MnO != null) {
        paramVarArgs.e(17, this.MnO);
      }
      paramVarArgs.aM(18, this.MnP);
      if (this.MnQ != null)
      {
        paramVarArgs.ni(19, this.MnQ.computeSize());
        this.MnQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(207499);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.hyH) + 0;
      paramInt = i;
      if (this.LpF != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LpF);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.Gaz) + g.a.a.b.b.a.bu(4, this.pSb) + g.a.a.b.b.a.bu(5, this.status) + g.a.a.b.b.a.bu(6, this.LIa) + g.a.a.b.b.a.bu(7, this.MnH) + g.a.a.b.b.a.bu(8, this.LXG);
      paramInt = i;
      if (this.MnI != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.MnI);
      }
      i = paramInt + g.a.a.a.c(10, 1, this.MnJ) + (g.a.a.b.b.a.fS(11) + 1) + (g.a.a.b.b.a.fS(12) + 1) + (g.a.a.b.b.a.fS(13) + 1);
      paramInt = i;
      if (this.MnL != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.MnL);
      }
      i = paramInt;
      if (this.MnM != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.MnM);
      }
      paramInt = i;
      if (this.MnN != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.MnN);
      }
      i = paramInt;
      if (this.MnO != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.MnO);
      }
      i += g.a.a.b.b.a.bu(18, this.MnP);
      paramInt = i;
      if (this.MnQ != null) {
        paramInt = i + g.a.a.a.nh(19, this.MnQ.computeSize());
      }
      AppMethodBeat.o(207499);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MnJ.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(207499);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      civ localciv = (civ)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(207499);
        return -1;
      case 1: 
        localciv.hyH = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(207499);
        return 0;
      case 2: 
        localciv.LpF = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(207499);
        return 0;
      case 3: 
        localciv.Gaz = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(207499);
        return 0;
      case 4: 
        localciv.pSb = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(207499);
        return 0;
      case 5: 
        localciv.status = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(207499);
        return 0;
      case 6: 
        localciv.LIa = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(207499);
        return 0;
      case 7: 
        localciv.MnH = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(207499);
        return 0;
      case 8: 
        localciv.LXG = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(207499);
        return 0;
      case 9: 
        localciv.MnI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(207499);
        return 0;
      case 10: 
        localciv.MnJ.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(207499);
        return 0;
      case 11: 
        localciv.KNv = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(207499);
        return 0;
      case 12: 
        localciv.Lml = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(207499);
        return 0;
      case 13: 
        localciv.MnK = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(207499);
        return 0;
      case 14: 
        localciv.MnL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(207499);
        return 0;
      case 15: 
        localciv.MnM = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(207499);
        return 0;
      case 16: 
        localciv.MnN = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(207499);
        return 0;
      case 17: 
        localciv.MnO = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(207499);
        return 0;
      case 18: 
        localciv.MnP = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(207499);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new xf();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((xf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localciv.MnQ = ((xf)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(207499);
      return 0;
    }
    AppMethodBeat.o(207499);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.civ
 * JD-Core Version:    0.7.0.1
 */