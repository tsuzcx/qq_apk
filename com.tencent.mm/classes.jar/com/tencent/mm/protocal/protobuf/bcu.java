package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bcu
  extends com.tencent.mm.bw.a
{
  public String IFO;
  public String LLO;
  public int LLP;
  public int LLQ;
  public boolean LLR;
  public int LLS;
  public String LLT;
  public bdb LLU;
  public bcv LLV;
  public LinkedList<bcv> LLW;
  public bcv LLX;
  public bcv LLY;
  public bcv LLZ;
  public bcv LMa;
  public String LrN;
  public long id;
  public LinkedList<FinderObject> object;
  public String sessionBuffer;
  public int tQR;
  public int tQT;
  public String tQU;
  public b tVe;
  public boolean uOm;
  public long uOx;
  
  public bcu()
  {
    AppMethodBeat.i(209682);
    this.object = new LinkedList();
    this.LLW = new LinkedList();
    AppMethodBeat.o(209682);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209683);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.uOx);
      if (this.IFO != null) {
        paramVarArgs.e(2, this.IFO);
      }
      if (this.LLO != null) {
        paramVarArgs.e(3, this.LLO);
      }
      paramVarArgs.aM(4, this.LLP);
      paramVarArgs.e(5, 8, this.object);
      paramVarArgs.aM(6, this.LLQ);
      if (this.tVe != null) {
        paramVarArgs.c(7, this.tVe);
      }
      paramVarArgs.aM(8, this.tQR);
      paramVarArgs.cc(9, this.LLR);
      paramVarArgs.aM(10, this.LLS);
      paramVarArgs.cc(11, this.uOm);
      if (this.tQU != null) {
        paramVarArgs.e(12, this.tQU);
      }
      paramVarArgs.aM(13, this.tQT);
      if (this.LLT != null) {
        paramVarArgs.e(14, this.LLT);
      }
      paramVarArgs.bb(15, this.id);
      if (this.sessionBuffer != null) {
        paramVarArgs.e(16, this.sessionBuffer);
      }
      if (this.LLU != null)
      {
        paramVarArgs.ni(17, this.LLU.computeSize());
        this.LLU.writeFields(paramVarArgs);
      }
      if (this.LLV != null)
      {
        paramVarArgs.ni(18, this.LLV.computeSize());
        this.LLV.writeFields(paramVarArgs);
      }
      paramVarArgs.e(19, 8, this.LLW);
      if (this.LLX != null)
      {
        paramVarArgs.ni(20, this.LLX.computeSize());
        this.LLX.writeFields(paramVarArgs);
      }
      if (this.LLY != null)
      {
        paramVarArgs.ni(21, this.LLY.computeSize());
        this.LLY.writeFields(paramVarArgs);
      }
      if (this.LrN != null) {
        paramVarArgs.e(22, this.LrN);
      }
      if (this.LLZ != null)
      {
        paramVarArgs.ni(23, this.LLZ.computeSize());
        this.LLZ.writeFields(paramVarArgs);
      }
      if (this.LMa != null)
      {
        paramVarArgs.ni(24, this.LMa.computeSize());
        this.LMa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209683);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.uOx) + 0;
      paramInt = i;
      if (this.IFO != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.IFO);
      }
      i = paramInt;
      if (this.LLO != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LLO);
      }
      i = i + g.a.a.b.b.a.bu(4, this.LLP) + g.a.a.a.c(5, 8, this.object) + g.a.a.b.b.a.bu(6, this.LLQ);
      paramInt = i;
      if (this.tVe != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.tVe);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.tQR) + (g.a.a.b.b.a.fS(9) + 1) + g.a.a.b.b.a.bu(10, this.LLS) + (g.a.a.b.b.a.fS(11) + 1);
      paramInt = i;
      if (this.tQU != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.tQU);
      }
      i = paramInt + g.a.a.b.b.a.bu(13, this.tQT);
      paramInt = i;
      if (this.LLT != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.LLT);
      }
      i = paramInt + g.a.a.b.b.a.r(15, this.id);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.sessionBuffer);
      }
      i = paramInt;
      if (this.LLU != null) {
        i = paramInt + g.a.a.a.nh(17, this.LLU.computeSize());
      }
      paramInt = i;
      if (this.LLV != null) {
        paramInt = i + g.a.a.a.nh(18, this.LLV.computeSize());
      }
      i = paramInt + g.a.a.a.c(19, 8, this.LLW);
      paramInt = i;
      if (this.LLX != null) {
        paramInt = i + g.a.a.a.nh(20, this.LLX.computeSize());
      }
      i = paramInt;
      if (this.LLY != null) {
        i = paramInt + g.a.a.a.nh(21, this.LLY.computeSize());
      }
      paramInt = i;
      if (this.LrN != null) {
        paramInt = i + g.a.a.b.b.a.f(22, this.LrN);
      }
      i = paramInt;
      if (this.LLZ != null) {
        i = paramInt + g.a.a.a.nh(23, this.LLZ.computeSize());
      }
      paramInt = i;
      if (this.LMa != null) {
        paramInt = i + g.a.a.a.nh(24, this.LMa.computeSize());
      }
      AppMethodBeat.o(209683);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.object.clear();
      this.LLW.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209683);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bcu localbcu = (bcu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209683);
        return -1;
      case 1: 
        localbcu.uOx = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209683);
        return 0;
      case 2: 
        localbcu.IFO = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209683);
        return 0;
      case 3: 
        localbcu.LLO = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209683);
        return 0;
      case 4: 
        localbcu.LLP = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209683);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderObject();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbcu.object.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209683);
        return 0;
      case 6: 
        localbcu.LLQ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209683);
        return 0;
      case 7: 
        localbcu.tVe = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(209683);
        return 0;
      case 8: 
        localbcu.tQR = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209683);
        return 0;
      case 9: 
        localbcu.LLR = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(209683);
        return 0;
      case 10: 
        localbcu.LLS = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209683);
        return 0;
      case 11: 
        localbcu.uOm = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(209683);
        return 0;
      case 12: 
        localbcu.tQU = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209683);
        return 0;
      case 13: 
        localbcu.tQT = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209683);
        return 0;
      case 14: 
        localbcu.LLT = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209683);
        return 0;
      case 15: 
        localbcu.id = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209683);
        return 0;
      case 16: 
        localbcu.sessionBuffer = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209683);
        return 0;
      case 17: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bdb();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bdb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbcu.LLU = ((bdb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209683);
        return 0;
      case 18: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcv();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bcv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbcu.LLV = ((bcv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209683);
        return 0;
      case 19: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcv();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bcv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbcu.LLW.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209683);
        return 0;
      case 20: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcv();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bcv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbcu.LLX = ((bcv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209683);
        return 0;
      case 21: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcv();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bcv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbcu.LLY = ((bcv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209683);
        return 0;
      case 22: 
        localbcu.LrN = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209683);
        return 0;
      case 23: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcv();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bcv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbcu.LLZ = ((bcv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209683);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bcv();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bcv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localbcu.LMa = ((bcv)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(209683);
      return 0;
    }
    AppMethodBeat.o(209683);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcu
 * JD-Core Version:    0.7.0.1
 */