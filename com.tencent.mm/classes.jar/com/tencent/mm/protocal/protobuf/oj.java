package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oj
  extends com.tencent.mm.bv.a
{
  public String code;
  public int status;
  public int wDM;
  public int wDN;
  public LinkedList<pn> wDO;
  public LinkedList<pn> wDP;
  public LinkedList<pn> wDQ;
  public LinkedList<String> wDR;
  public int wDS;
  public int wDT;
  public LinkedList<uo> wDU;
  public long wDV;
  public int wDW;
  public String wDX;
  public uo wDY;
  public LinkedList<ax> wDZ;
  public uo wEa;
  public uo wEb;
  public uo wEc;
  public yf wEd;
  public String wEe;
  public uo wEf;
  public String wEg;
  public uo wEh;
  public boolean wEi;
  public boolean wEj;
  
  public oj()
  {
    AppMethodBeat.i(89019);
    this.wDO = new LinkedList();
    this.wDP = new LinkedList();
    this.wDQ = new LinkedList();
    this.wDR = new LinkedList();
    this.wDU = new LinkedList();
    this.wDZ = new LinkedList();
    AppMethodBeat.o(89019);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89020);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.status);
      paramVarArgs.aO(2, this.wDM);
      paramVarArgs.aO(3, this.wDN);
      paramVarArgs.e(4, 8, this.wDO);
      paramVarArgs.e(5, 8, this.wDP);
      paramVarArgs.e(6, 8, this.wDQ);
      paramVarArgs.e(7, 1, this.wDR);
      paramVarArgs.aO(8, this.wDS);
      if (this.code != null) {
        paramVarArgs.e(9, this.code);
      }
      paramVarArgs.aO(10, this.wDT);
      paramVarArgs.e(11, 8, this.wDU);
      paramVarArgs.am(12, this.wDV);
      paramVarArgs.aO(13, this.wDW);
      if (this.wDX != null) {
        paramVarArgs.e(14, this.wDX);
      }
      if (this.wDY != null)
      {
        paramVarArgs.iQ(15, this.wDY.computeSize());
        this.wDY.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.wDZ);
      if (this.wEa != null)
      {
        paramVarArgs.iQ(17, this.wEa.computeSize());
        this.wEa.writeFields(paramVarArgs);
      }
      if (this.wEb != null)
      {
        paramVarArgs.iQ(18, this.wEb.computeSize());
        this.wEb.writeFields(paramVarArgs);
      }
      if (this.wEc != null)
      {
        paramVarArgs.iQ(19, this.wEc.computeSize());
        this.wEc.writeFields(paramVarArgs);
      }
      if (this.wEd != null)
      {
        paramVarArgs.iQ(20, this.wEd.computeSize());
        this.wEd.writeFields(paramVarArgs);
      }
      if (this.wEe != null) {
        paramVarArgs.e(21, this.wEe);
      }
      if (this.wEf != null)
      {
        paramVarArgs.iQ(22, this.wEf.computeSize());
        this.wEf.writeFields(paramVarArgs);
      }
      if (this.wEg != null) {
        paramVarArgs.e(23, this.wEg);
      }
      if (this.wEh != null)
      {
        paramVarArgs.iQ(24, this.wEh.computeSize());
        this.wEh.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(25, this.wEi);
      paramVarArgs.aS(26, this.wEj);
      AppMethodBeat.o(89020);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.status) + 0 + e.a.a.b.b.a.bl(2, this.wDM) + e.a.a.b.b.a.bl(3, this.wDN) + e.a.a.a.c(4, 8, this.wDO) + e.a.a.a.c(5, 8, this.wDP) + e.a.a.a.c(6, 8, this.wDQ) + e.a.a.a.c(7, 1, this.wDR) + e.a.a.b.b.a.bl(8, this.wDS);
      paramInt = i;
      if (this.code != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.code);
      }
      i = paramInt + e.a.a.b.b.a.bl(10, this.wDT) + e.a.a.a.c(11, 8, this.wDU) + e.a.a.b.b.a.p(12, this.wDV) + e.a.a.b.b.a.bl(13, this.wDW);
      paramInt = i;
      if (this.wDX != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.wDX);
      }
      i = paramInt;
      if (this.wDY != null) {
        i = paramInt + e.a.a.a.iP(15, this.wDY.computeSize());
      }
      i += e.a.a.a.c(16, 8, this.wDZ);
      paramInt = i;
      if (this.wEa != null) {
        paramInt = i + e.a.a.a.iP(17, this.wEa.computeSize());
      }
      i = paramInt;
      if (this.wEb != null) {
        i = paramInt + e.a.a.a.iP(18, this.wEb.computeSize());
      }
      paramInt = i;
      if (this.wEc != null) {
        paramInt = i + e.a.a.a.iP(19, this.wEc.computeSize());
      }
      i = paramInt;
      if (this.wEd != null) {
        i = paramInt + e.a.a.a.iP(20, this.wEd.computeSize());
      }
      paramInt = i;
      if (this.wEe != null) {
        paramInt = i + e.a.a.b.b.a.f(21, this.wEe);
      }
      i = paramInt;
      if (this.wEf != null) {
        i = paramInt + e.a.a.a.iP(22, this.wEf.computeSize());
      }
      paramInt = i;
      if (this.wEg != null) {
        paramInt = i + e.a.a.b.b.a.f(23, this.wEg);
      }
      i = paramInt;
      if (this.wEh != null) {
        i = paramInt + e.a.a.a.iP(24, this.wEh.computeSize());
      }
      paramInt = e.a.a.b.b.a.eW(25);
      int j = e.a.a.b.b.a.eW(26);
      AppMethodBeat.o(89020);
      return i + (paramInt + 1) + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wDO.clear();
      this.wDP.clear();
      this.wDQ.clear();
      this.wDR.clear();
      this.wDU.clear();
      this.wDZ.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(89020);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      oj localoj = (oj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(89020);
        return -1;
      case 1: 
        localoj.status = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(89020);
        return 0;
      case 2: 
        localoj.wDM = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(89020);
        return 0;
      case 3: 
        localoj.wDN = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(89020);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pn();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localoj.wDO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89020);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pn();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localoj.wDP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89020);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pn();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localoj.wDQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89020);
        return 0;
      case 7: 
        localoj.wDR.add(((e.a.a.a.a)localObject1).CLY.readString());
        AppMethodBeat.o(89020);
        return 0;
      case 8: 
        localoj.wDS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(89020);
        return 0;
      case 9: 
        localoj.code = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(89020);
        return 0;
      case 10: 
        localoj.wDT = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(89020);
        return 0;
      case 11: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new uo();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((uo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localoj.wDU.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89020);
        return 0;
      case 12: 
        localoj.wDV = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(89020);
        return 0;
      case 13: 
        localoj.wDW = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(89020);
        return 0;
      case 14: 
        localoj.wDX = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(89020);
        return 0;
      case 15: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new uo();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((uo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localoj.wDY = ((uo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89020);
        return 0;
      case 16: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ax();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ax)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localoj.wDZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89020);
        return 0;
      case 17: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new uo();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((uo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localoj.wEa = ((uo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89020);
        return 0;
      case 18: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new uo();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((uo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localoj.wEb = ((uo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89020);
        return 0;
      case 19: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new uo();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((uo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localoj.wEc = ((uo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89020);
        return 0;
      case 20: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yf();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localoj.wEd = ((yf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89020);
        return 0;
      case 21: 
        localoj.wEe = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(89020);
        return 0;
      case 22: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new uo();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((uo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localoj.wEf = ((uo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89020);
        return 0;
      case 23: 
        localoj.wEg = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(89020);
        return 0;
      case 24: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new uo();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((uo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localoj.wEh = ((uo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89020);
        return 0;
      case 25: 
        localoj.wEi = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(89020);
        return 0;
      }
      localoj.wEj = ((e.a.a.a.a)localObject1).CLY.emu();
      AppMethodBeat.o(89020);
      return 0;
    }
    AppMethodBeat.o(89020);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oj
 * JD-Core Version:    0.7.0.1
 */