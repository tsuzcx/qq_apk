package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class st
  extends com.tencent.mm.bw.a
{
  public int GhH;
  public int GhI;
  public LinkedList<uc> GhJ;
  public LinkedList<uc> GhK;
  public LinkedList<uc> GhL;
  public LinkedList<String> GhM;
  public int GhN;
  public int GhO;
  public LinkedList<aai> GhP;
  public long GhQ;
  public int GhR;
  public String GhS;
  public aai GhT;
  public LinkedList<bc> GhU;
  public aai GhV;
  public aai GhW;
  public aai GhX;
  public aev GhY;
  public String GhZ;
  public aai Gia;
  public String Gib;
  public aai Gic;
  public boolean Gid;
  public boolean Gie;
  public String code;
  public int status;
  
  public st()
  {
    AppMethodBeat.i(113948);
    this.GhJ = new LinkedList();
    this.GhK = new LinkedList();
    this.GhL = new LinkedList();
    this.GhM = new LinkedList();
    this.GhP = new LinkedList();
    this.GhU = new LinkedList();
    AppMethodBeat.o(113948);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113949);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.status);
      paramVarArgs.aS(2, this.GhH);
      paramVarArgs.aS(3, this.GhI);
      paramVarArgs.e(4, 8, this.GhJ);
      paramVarArgs.e(5, 8, this.GhK);
      paramVarArgs.e(6, 8, this.GhL);
      paramVarArgs.e(7, 1, this.GhM);
      paramVarArgs.aS(8, this.GhN);
      if (this.code != null) {
        paramVarArgs.d(9, this.code);
      }
      paramVarArgs.aS(10, this.GhO);
      paramVarArgs.e(11, 8, this.GhP);
      paramVarArgs.aZ(12, this.GhQ);
      paramVarArgs.aS(13, this.GhR);
      if (this.GhS != null) {
        paramVarArgs.d(14, this.GhS);
      }
      if (this.GhT != null)
      {
        paramVarArgs.lJ(15, this.GhT.computeSize());
        this.GhT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.GhU);
      if (this.GhV != null)
      {
        paramVarArgs.lJ(17, this.GhV.computeSize());
        this.GhV.writeFields(paramVarArgs);
      }
      if (this.GhW != null)
      {
        paramVarArgs.lJ(18, this.GhW.computeSize());
        this.GhW.writeFields(paramVarArgs);
      }
      if (this.GhX != null)
      {
        paramVarArgs.lJ(19, this.GhX.computeSize());
        this.GhX.writeFields(paramVarArgs);
      }
      if (this.GhY != null)
      {
        paramVarArgs.lJ(20, this.GhY.computeSize());
        this.GhY.writeFields(paramVarArgs);
      }
      if (this.GhZ != null) {
        paramVarArgs.d(21, this.GhZ);
      }
      if (this.Gia != null)
      {
        paramVarArgs.lJ(22, this.Gia.computeSize());
        this.Gia.writeFields(paramVarArgs);
      }
      if (this.Gib != null) {
        paramVarArgs.d(23, this.Gib);
      }
      if (this.Gic != null)
      {
        paramVarArgs.lJ(24, this.Gic.computeSize());
        this.Gic.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(25, this.Gid);
      paramVarArgs.bC(26, this.Gie);
      AppMethodBeat.o(113949);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.status) + 0 + f.a.a.b.b.a.bz(2, this.GhH) + f.a.a.b.b.a.bz(3, this.GhI) + f.a.a.a.c(4, 8, this.GhJ) + f.a.a.a.c(5, 8, this.GhK) + f.a.a.a.c(6, 8, this.GhL) + f.a.a.a.c(7, 1, this.GhM) + f.a.a.b.b.a.bz(8, this.GhN);
      paramInt = i;
      if (this.code != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.code);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.GhO) + f.a.a.a.c(11, 8, this.GhP) + f.a.a.b.b.a.p(12, this.GhQ) + f.a.a.b.b.a.bz(13, this.GhR);
      paramInt = i;
      if (this.GhS != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.GhS);
      }
      i = paramInt;
      if (this.GhT != null) {
        i = paramInt + f.a.a.a.lI(15, this.GhT.computeSize());
      }
      i += f.a.a.a.c(16, 8, this.GhU);
      paramInt = i;
      if (this.GhV != null) {
        paramInt = i + f.a.a.a.lI(17, this.GhV.computeSize());
      }
      i = paramInt;
      if (this.GhW != null) {
        i = paramInt + f.a.a.a.lI(18, this.GhW.computeSize());
      }
      paramInt = i;
      if (this.GhX != null) {
        paramInt = i + f.a.a.a.lI(19, this.GhX.computeSize());
      }
      i = paramInt;
      if (this.GhY != null) {
        i = paramInt + f.a.a.a.lI(20, this.GhY.computeSize());
      }
      paramInt = i;
      if (this.GhZ != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.GhZ);
      }
      i = paramInt;
      if (this.Gia != null) {
        i = paramInt + f.a.a.a.lI(22, this.Gia.computeSize());
      }
      paramInt = i;
      if (this.Gib != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.Gib);
      }
      i = paramInt;
      if (this.Gic != null) {
        i = paramInt + f.a.a.a.lI(24, this.Gic.computeSize());
      }
      paramInt = f.a.a.b.b.a.amF(25);
      int j = f.a.a.b.b.a.amF(26);
      AppMethodBeat.o(113949);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GhJ.clear();
      this.GhK.clear();
      this.GhL.clear();
      this.GhM.clear();
      this.GhP.clear();
      this.GhU.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(113949);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      st localst = (st)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(113949);
        return -1;
      case 1: 
        localst.status = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(113949);
        return 0;
      case 2: 
        localst.GhH = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(113949);
        return 0;
      case 3: 
        localst.GhI = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(113949);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new uc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((uc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localst.GhJ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new uc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((uc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localst.GhK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new uc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((uc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localst.GhL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 7: 
        localst.GhM.add(((f.a.a.a.a)localObject1).OmT.readString());
        AppMethodBeat.o(113949);
        return 0;
      case 8: 
        localst.GhN = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(113949);
        return 0;
      case 9: 
        localst.code = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 10: 
        localst.GhO = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(113949);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aai();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aai)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localst.GhP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 12: 
        localst.GhQ = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(113949);
        return 0;
      case 13: 
        localst.GhR = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(113949);
        return 0;
      case 14: 
        localst.GhS = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aai();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aai)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localst.GhT = ((aai)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localst.GhU.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 17: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aai();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aai)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localst.GhV = ((aai)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 18: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aai();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aai)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localst.GhW = ((aai)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 19: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aai();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aai)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localst.GhX = ((aai)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 20: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aev();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aev)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localst.GhY = ((aev)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 21: 
        localst.GhZ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 22: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aai();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aai)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localst.Gia = ((aai)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 23: 
        localst.Gib = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 24: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aai();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aai)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localst.Gic = ((aai)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 25: 
        localst.Gid = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(113949);
        return 0;
      }
      localst.Gie = ((f.a.a.a.a)localObject1).OmT.gvY();
      AppMethodBeat.o(113949);
      return 0;
    }
    AppMethodBeat.o(113949);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.st
 * JD-Core Version:    0.7.0.1
 */