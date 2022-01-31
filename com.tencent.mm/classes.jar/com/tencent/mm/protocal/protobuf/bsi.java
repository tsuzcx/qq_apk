package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bsi
  extends com.tencent.mm.bv.a
{
  public String iFH;
  public String iFI;
  public String iFJ;
  public String iFK;
  public int iFL;
  public String iFM;
  public String kWF;
  public double score;
  public int xFK;
  public String xFL;
  public String xFM;
  public String xFN;
  public String xFO;
  public String xFP;
  public atj xFQ;
  public String xFR;
  public String xFS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134439);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.iFL);
      paramVarArgs.aO(2, this.xFK);
      if (this.xFL != null) {
        paramVarArgs.e(3, this.xFL);
      }
      if (this.iFJ != null) {
        paramVarArgs.e(4, this.iFJ);
      }
      if (this.iFK != null) {
        paramVarArgs.e(5, this.iFK);
      }
      if (this.xFM != null) {
        paramVarArgs.e(6, this.xFM);
      }
      if (this.kWF != null) {
        paramVarArgs.e(7, this.kWF);
      }
      if (this.xFN != null) {
        paramVarArgs.e(8, this.xFN);
      }
      if (this.xFO != null) {
        paramVarArgs.e(9, this.xFO);
      }
      paramVarArgs.f(10, this.score);
      if (this.xFP != null) {
        paramVarArgs.e(11, this.xFP);
      }
      if (this.iFH != null) {
        paramVarArgs.e(12, this.iFH);
      }
      if (this.xFQ != null)
      {
        paramVarArgs.iQ(14, this.xFQ.computeSize());
        this.xFQ.writeFields(paramVarArgs);
      }
      if (this.iFI != null) {
        paramVarArgs.e(15, this.iFI);
      }
      if (this.xFR != null) {
        paramVarArgs.e(16, this.xFR);
      }
      if (this.xFS != null) {
        paramVarArgs.e(17, this.xFS);
      }
      if (this.iFM != null) {
        paramVarArgs.e(18, this.iFM);
      }
      AppMethodBeat.o(134439);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.iFL) + 0 + e.a.a.b.b.a.bl(2, this.xFK);
      paramInt = i;
      if (this.xFL != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.xFL);
      }
      i = paramInt;
      if (this.iFJ != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.iFJ);
      }
      paramInt = i;
      if (this.iFK != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.iFK);
      }
      i = paramInt;
      if (this.xFM != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xFM);
      }
      paramInt = i;
      if (this.kWF != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.kWF);
      }
      i = paramInt;
      if (this.xFN != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.xFN);
      }
      paramInt = i;
      if (this.xFO != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xFO);
      }
      i = paramInt + (e.a.a.b.b.a.eW(10) + 8);
      paramInt = i;
      if (this.xFP != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.xFP);
      }
      i = paramInt;
      if (this.iFH != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.iFH);
      }
      paramInt = i;
      if (this.xFQ != null) {
        paramInt = i + e.a.a.a.iP(14, this.xFQ.computeSize());
      }
      i = paramInt;
      if (this.iFI != null) {
        i = paramInt + e.a.a.b.b.a.f(15, this.iFI);
      }
      paramInt = i;
      if (this.xFR != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.xFR);
      }
      i = paramInt;
      if (this.xFS != null) {
        i = paramInt + e.a.a.b.b.a.f(17, this.xFS);
      }
      paramInt = i;
      if (this.iFM != null) {
        paramInt = i + e.a.a.b.b.a.f(18, this.iFM);
      }
      AppMethodBeat.o(134439);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(134439);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bsi localbsi = (bsi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 13: 
      default: 
        AppMethodBeat.o(134439);
        return -1;
      case 1: 
        localbsi.iFL = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(134439);
        return 0;
      case 2: 
        localbsi.xFK = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(134439);
        return 0;
      case 3: 
        localbsi.xFL = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(134439);
        return 0;
      case 4: 
        localbsi.iFJ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(134439);
        return 0;
      case 5: 
        localbsi.iFK = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(134439);
        return 0;
      case 6: 
        localbsi.xFM = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(134439);
        return 0;
      case 7: 
        localbsi.kWF = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(134439);
        return 0;
      case 8: 
        localbsi.xFN = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(134439);
        return 0;
      case 9: 
        localbsi.xFO = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(134439);
        return 0;
      case 10: 
        localbsi.score = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
        AppMethodBeat.o(134439);
        return 0;
      case 11: 
        localbsi.xFP = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(134439);
        return 0;
      case 12: 
        localbsi.iFH = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(134439);
        return 0;
      case 14: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new atj();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((atj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbsi.xFQ = ((atj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(134439);
        return 0;
      case 15: 
        localbsi.iFI = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(134439);
        return 0;
      case 16: 
        localbsi.xFR = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(134439);
        return 0;
      case 17: 
        localbsi.xFS = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(134439);
        return 0;
      }
      localbsi.iFM = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(134439);
      return 0;
    }
    AppMethodBeat.o(134439);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsi
 * JD-Core Version:    0.7.0.1
 */