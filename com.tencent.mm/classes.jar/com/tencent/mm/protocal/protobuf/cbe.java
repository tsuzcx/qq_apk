package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbe
  extends com.tencent.mm.bw.a
{
  public int KTQ;
  public String Lot;
  public long Mbx;
  public String MgB;
  public cbf MgC;
  public String MgD;
  public int MgE;
  public int MgF;
  public long MgG;
  public String MgH;
  public String MgI;
  public int MgJ;
  public String MgK;
  public String MgL;
  public String MgM;
  public String MgN;
  public String MgO;
  public int MgP;
  public String MgQ;
  public String MgR;
  public String MgS;
  public int dfT;
  public int iwy;
  public int subType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91520);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MgB != null) {
        paramVarArgs.e(1, this.MgB);
      }
      paramVarArgs.aM(2, this.subType);
      if (this.Lot != null) {
        paramVarArgs.e(3, this.Lot);
      }
      if (this.MgC != null)
      {
        paramVarArgs.ni(4, this.MgC.computeSize());
        this.MgC.writeFields(paramVarArgs);
      }
      if (this.MgD != null) {
        paramVarArgs.e(5, this.MgD);
      }
      paramVarArgs.aM(6, this.MgE);
      paramVarArgs.aM(7, this.MgF);
      paramVarArgs.bb(8, this.MgG);
      paramVarArgs.aM(9, this.iwy);
      paramVarArgs.aM(10, this.KTQ);
      if (this.MgH != null) {
        paramVarArgs.e(11, this.MgH);
      }
      if (this.MgI != null) {
        paramVarArgs.e(12, this.MgI);
      }
      paramVarArgs.aM(13, this.MgJ);
      if (this.MgK != null) {
        paramVarArgs.e(14, this.MgK);
      }
      if (this.MgL != null) {
        paramVarArgs.e(15, this.MgL);
      }
      if (this.MgM != null) {
        paramVarArgs.e(16, this.MgM);
      }
      if (this.MgN != null) {
        paramVarArgs.e(17, this.MgN);
      }
      if (this.MgO != null) {
        paramVarArgs.e(18, this.MgO);
      }
      paramVarArgs.aM(19, this.MgP);
      paramVarArgs.bb(20, this.Mbx);
      paramVarArgs.aM(21, this.dfT);
      if (this.MgQ != null) {
        paramVarArgs.e(22, this.MgQ);
      }
      if (this.MgR != null) {
        paramVarArgs.e(23, this.MgR);
      }
      if (this.MgS != null) {
        paramVarArgs.e(24, this.MgS);
      }
      AppMethodBeat.o(91520);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MgB == null) {
        break label1558;
      }
    }
    label1558:
    for (paramInt = g.a.a.b.b.a.f(1, this.MgB) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.subType);
      paramInt = i;
      if (this.Lot != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Lot);
      }
      i = paramInt;
      if (this.MgC != null) {
        i = paramInt + g.a.a.a.nh(4, this.MgC.computeSize());
      }
      paramInt = i;
      if (this.MgD != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MgD);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.MgE) + g.a.a.b.b.a.bu(7, this.MgF) + g.a.a.b.b.a.r(8, this.MgG) + g.a.a.b.b.a.bu(9, this.iwy) + g.a.a.b.b.a.bu(10, this.KTQ);
      paramInt = i;
      if (this.MgH != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.MgH);
      }
      i = paramInt;
      if (this.MgI != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.MgI);
      }
      i += g.a.a.b.b.a.bu(13, this.MgJ);
      paramInt = i;
      if (this.MgK != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.MgK);
      }
      i = paramInt;
      if (this.MgL != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.MgL);
      }
      paramInt = i;
      if (this.MgM != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.MgM);
      }
      i = paramInt;
      if (this.MgN != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.MgN);
      }
      paramInt = i;
      if (this.MgO != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.MgO);
      }
      i = paramInt + g.a.a.b.b.a.bu(19, this.MgP) + g.a.a.b.b.a.r(20, this.Mbx) + g.a.a.b.b.a.bu(21, this.dfT);
      paramInt = i;
      if (this.MgQ != null) {
        paramInt = i + g.a.a.b.b.a.f(22, this.MgQ);
      }
      i = paramInt;
      if (this.MgR != null) {
        i = paramInt + g.a.a.b.b.a.f(23, this.MgR);
      }
      paramInt = i;
      if (this.MgS != null) {
        paramInt = i + g.a.a.b.b.a.f(24, this.MgS);
      }
      AppMethodBeat.o(91520);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91520);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cbe localcbe = (cbe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91520);
          return -1;
        case 1: 
          localcbe.MgB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 2: 
          localcbe.subType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91520);
          return 0;
        case 3: 
          localcbe.Lot = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cbf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcbe.MgC = ((cbf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91520);
          return 0;
        case 5: 
          localcbe.MgD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 6: 
          localcbe.MgE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91520);
          return 0;
        case 7: 
          localcbe.MgF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91520);
          return 0;
        case 8: 
          localcbe.MgG = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91520);
          return 0;
        case 9: 
          localcbe.iwy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91520);
          return 0;
        case 10: 
          localcbe.KTQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91520);
          return 0;
        case 11: 
          localcbe.MgH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 12: 
          localcbe.MgI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 13: 
          localcbe.MgJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91520);
          return 0;
        case 14: 
          localcbe.MgK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 15: 
          localcbe.MgL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 16: 
          localcbe.MgM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 17: 
          localcbe.MgN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 18: 
          localcbe.MgO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 19: 
          localcbe.MgP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91520);
          return 0;
        case 20: 
          localcbe.Mbx = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91520);
          return 0;
        case 21: 
          localcbe.dfT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91520);
          return 0;
        case 22: 
          localcbe.MgQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 23: 
          localcbe.MgR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91520);
          return 0;
        }
        localcbe.MgS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91520);
        return 0;
      }
      AppMethodBeat.o(91520);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbe
 * JD-Core Version:    0.7.0.1
 */