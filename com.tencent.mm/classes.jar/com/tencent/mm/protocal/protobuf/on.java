package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class on
  extends com.tencent.mm.bv.a
{
  public String wEJ;
  public String wEK;
  public String wEL;
  public String wEM;
  public LinkedList<om> wEN;
  public int wEO;
  public String wEP;
  public ou wEQ;
  public String wER;
  public LinkedList<ol> wES;
  public String wET;
  public String wEU;
  public ou wEV;
  public om wEW;
  public int wEX;
  public int wEY;
  public int wEZ;
  public long wFa;
  
  public on()
  {
    AppMethodBeat.i(89025);
    this.wEN = new LinkedList();
    this.wES = new LinkedList();
    AppMethodBeat.o(89025);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89026);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wEJ != null) {
        paramVarArgs.e(1, this.wEJ);
      }
      if (this.wEK != null) {
        paramVarArgs.e(2, this.wEK);
      }
      if (this.wEL != null) {
        paramVarArgs.e(3, this.wEL);
      }
      if (this.wEM != null) {
        paramVarArgs.e(4, this.wEM);
      }
      paramVarArgs.e(5, 8, this.wEN);
      paramVarArgs.aO(6, this.wEO);
      if (this.wEP != null) {
        paramVarArgs.e(7, this.wEP);
      }
      if (this.wEQ != null)
      {
        paramVarArgs.iQ(8, this.wEQ.computeSize());
        this.wEQ.writeFields(paramVarArgs);
      }
      if (this.wER != null) {
        paramVarArgs.e(9, this.wER);
      }
      paramVarArgs.e(10, 8, this.wES);
      if (this.wET != null) {
        paramVarArgs.e(11, this.wET);
      }
      if (this.wEU != null) {
        paramVarArgs.e(12, this.wEU);
      }
      if (this.wEV != null)
      {
        paramVarArgs.iQ(13, this.wEV.computeSize());
        this.wEV.writeFields(paramVarArgs);
      }
      if (this.wEW != null)
      {
        paramVarArgs.iQ(14, this.wEW.computeSize());
        this.wEW.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(15, this.wEX);
      paramVarArgs.aO(16, this.wEY);
      paramVarArgs.aO(17, this.wEZ);
      paramVarArgs.am(18, this.wFa);
      AppMethodBeat.o(89026);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wEJ == null) {
        break label1630;
      }
    }
    label1630:
    for (int i = e.a.a.b.b.a.f(1, this.wEJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wEK != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wEK);
      }
      i = paramInt;
      if (this.wEL != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wEL);
      }
      paramInt = i;
      if (this.wEM != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wEM);
      }
      i = paramInt + e.a.a.a.c(5, 8, this.wEN) + e.a.a.b.b.a.bl(6, this.wEO);
      paramInt = i;
      if (this.wEP != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wEP);
      }
      i = paramInt;
      if (this.wEQ != null) {
        i = paramInt + e.a.a.a.iP(8, this.wEQ.computeSize());
      }
      paramInt = i;
      if (this.wER != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.wER);
      }
      i = paramInt + e.a.a.a.c(10, 8, this.wES);
      paramInt = i;
      if (this.wET != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.wET);
      }
      i = paramInt;
      if (this.wEU != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.wEU);
      }
      paramInt = i;
      if (this.wEV != null) {
        paramInt = i + e.a.a.a.iP(13, this.wEV.computeSize());
      }
      i = paramInt;
      if (this.wEW != null) {
        i = paramInt + e.a.a.a.iP(14, this.wEW.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(15, this.wEX);
      int j = e.a.a.b.b.a.bl(16, this.wEY);
      int k = e.a.a.b.b.a.bl(17, this.wEZ);
      int m = e.a.a.b.b.a.p(18, this.wFa);
      AppMethodBeat.o(89026);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wEN.clear();
        this.wES.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89026);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        on localon = (on)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89026);
          return -1;
        case 1: 
          localon.wEJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89026);
          return 0;
        case 2: 
          localon.wEK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89026);
          return 0;
        case 3: 
          localon.wEL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89026);
          return 0;
        case 4: 
          localon.wEM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89026);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new om();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((om)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localon.wEN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89026);
          return 0;
        case 6: 
          localon.wEO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89026);
          return 0;
        case 7: 
          localon.wEP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89026);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ou();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ou)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localon.wEQ = ((ou)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89026);
          return 0;
        case 9: 
          localon.wER = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89026);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ol();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ol)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localon.wES.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89026);
          return 0;
        case 11: 
          localon.wET = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89026);
          return 0;
        case 12: 
          localon.wEU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89026);
          return 0;
        case 13: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ou();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ou)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localon.wEV = ((ou)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89026);
          return 0;
        case 14: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new om();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((om)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localon.wEW = ((om)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89026);
          return 0;
        case 15: 
          localon.wEX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89026);
          return 0;
        case 16: 
          localon.wEY = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89026);
          return 0;
        case 17: 
          localon.wEZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89026);
          return 0;
        }
        localon.wFa = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(89026);
        return 0;
      }
      AppMethodBeat.o(89026);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.on
 * JD-Core Version:    0.7.0.1
 */