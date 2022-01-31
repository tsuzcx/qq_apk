package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class TimeLineObject
  extends com.tencent.mm.bv.a
{
  public int CreateTime;
  public String Id;
  public int dqG;
  public int fgB;
  public String inF;
  public String jJA;
  public String rHA;
  public av rjv;
  public cyl rjx;
  public String sbN;
  public String vSR;
  public String xTP;
  public bap xTQ;
  public du xTR;
  public vi xTS;
  public String xTT;
  public int xTU;
  public int xTV;
  public String xTW;
  public cih xTX;
  public cwk xTY;
  public int xTZ;
  public int xrU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94634);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.e(1, this.Id);
      }
      if (this.jJA != null) {
        paramVarArgs.e(2, this.jJA);
      }
      paramVarArgs.aO(3, this.xrU);
      paramVarArgs.aO(4, this.CreateTime);
      if (this.xTP != null) {
        paramVarArgs.e(5, this.xTP);
      }
      if (this.xTQ != null)
      {
        paramVarArgs.iQ(6, this.xTQ.computeSize());
        this.xTQ.writeFields(paramVarArgs);
      }
      if (this.xTR != null)
      {
        paramVarArgs.iQ(7, this.xTR.computeSize());
        this.xTR.writeFields(paramVarArgs);
      }
      if (this.xTS != null)
      {
        paramVarArgs.iQ(8, this.xTS.computeSize());
        this.xTS.writeFields(paramVarArgs);
      }
      if (this.inF != null) {
        paramVarArgs.e(9, this.inF);
      }
      if (this.vSR != null) {
        paramVarArgs.e(10, this.vSR);
      }
      if (this.xTT != null) {
        paramVarArgs.e(11, this.xTT);
      }
      paramVarArgs.aO(12, this.xTU);
      paramVarArgs.aO(13, this.xTV);
      if (this.xTW != null) {
        paramVarArgs.e(14, this.xTW);
      }
      if (this.rjv != null)
      {
        paramVarArgs.iQ(15, this.rjv.computeSize());
        this.rjv.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(16, this.fgB);
      if (this.xTX != null)
      {
        paramVarArgs.iQ(17, this.xTX.computeSize());
        this.xTX.writeFields(paramVarArgs);
      }
      if (this.rHA != null) {
        paramVarArgs.e(18, this.rHA);
      }
      if (this.sbN != null) {
        paramVarArgs.e(19, this.sbN);
      }
      if (this.xTY != null)
      {
        paramVarArgs.iQ(20, this.xTY.computeSize());
        this.xTY.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(21, this.xTZ);
      if (this.rjx != null)
      {
        paramVarArgs.iQ(22, this.rjx.computeSize());
        this.rjx.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(23, this.dqG);
      AppMethodBeat.o(94634);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label2114;
      }
    }
    label2114:
    for (paramInt = e.a.a.b.b.a.f(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jJA != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.jJA);
      }
      i = i + e.a.a.b.b.a.bl(3, this.xrU) + e.a.a.b.b.a.bl(4, this.CreateTime);
      paramInt = i;
      if (this.xTP != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xTP);
      }
      i = paramInt;
      if (this.xTQ != null) {
        i = paramInt + e.a.a.a.iP(6, this.xTQ.computeSize());
      }
      paramInt = i;
      if (this.xTR != null) {
        paramInt = i + e.a.a.a.iP(7, this.xTR.computeSize());
      }
      i = paramInt;
      if (this.xTS != null) {
        i = paramInt + e.a.a.a.iP(8, this.xTS.computeSize());
      }
      paramInt = i;
      if (this.inF != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.inF);
      }
      i = paramInt;
      if (this.vSR != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.vSR);
      }
      paramInt = i;
      if (this.xTT != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.xTT);
      }
      i = paramInt + e.a.a.b.b.a.bl(12, this.xTU) + e.a.a.b.b.a.bl(13, this.xTV);
      paramInt = i;
      if (this.xTW != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.xTW);
      }
      i = paramInt;
      if (this.rjv != null) {
        i = paramInt + e.a.a.a.iP(15, this.rjv.computeSize());
      }
      i += e.a.a.b.b.a.bl(16, this.fgB);
      paramInt = i;
      if (this.xTX != null) {
        paramInt = i + e.a.a.a.iP(17, this.xTX.computeSize());
      }
      i = paramInt;
      if (this.rHA != null) {
        i = paramInt + e.a.a.b.b.a.f(18, this.rHA);
      }
      paramInt = i;
      if (this.sbN != null) {
        paramInt = i + e.a.a.b.b.a.f(19, this.sbN);
      }
      i = paramInt;
      if (this.xTY != null) {
        i = paramInt + e.a.a.a.iP(20, this.xTY.computeSize());
      }
      i += e.a.a.b.b.a.bl(21, this.xTZ);
      paramInt = i;
      if (this.rjx != null) {
        paramInt = i + e.a.a.a.iP(22, this.rjx.computeSize());
      }
      i = e.a.a.b.b.a.bl(23, this.dqG);
      AppMethodBeat.o(94634);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94634);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        TimeLineObject localTimeLineObject = (TimeLineObject)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94634);
          return -1;
        case 1: 
          localTimeLineObject.Id = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94634);
          return 0;
        case 2: 
          localTimeLineObject.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94634);
          return 0;
        case 3: 
          localTimeLineObject.xrU = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94634);
          return 0;
        case 4: 
          localTimeLineObject.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94634);
          return 0;
        case 5: 
          localTimeLineObject.xTP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94634);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bap();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bap)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localTimeLineObject.xTQ = ((bap)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94634);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new du();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((du)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localTimeLineObject.xTR = ((du)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94634);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vi();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vi)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localTimeLineObject.xTS = ((vi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94634);
          return 0;
        case 9: 
          localTimeLineObject.inF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94634);
          return 0;
        case 10: 
          localTimeLineObject.vSR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94634);
          return 0;
        case 11: 
          localTimeLineObject.xTT = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94634);
          return 0;
        case 12: 
          localTimeLineObject.xTU = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94634);
          return 0;
        case 13: 
          localTimeLineObject.xTV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94634);
          return 0;
        case 14: 
          localTimeLineObject.xTW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94634);
          return 0;
        case 15: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new av();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((av)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localTimeLineObject.rjv = ((av)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94634);
          return 0;
        case 16: 
          localTimeLineObject.fgB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94634);
          return 0;
        case 17: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cih();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cih)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localTimeLineObject.xTX = ((cih)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94634);
          return 0;
        case 18: 
          localTimeLineObject.rHA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94634);
          return 0;
        case 19: 
          localTimeLineObject.sbN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94634);
          return 0;
        case 20: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwk();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localTimeLineObject.xTY = ((cwk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94634);
          return 0;
        case 21: 
          localTimeLineObject.xTZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94634);
          return 0;
        case 22: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyl();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localTimeLineObject.rjx = ((cyl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94634);
          return 0;
        }
        localTimeLineObject.dqG = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94634);
        return 0;
      }
      AppMethodBeat.o(94634);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.TimeLineObject
 * JD-Core Version:    0.7.0.1
 */