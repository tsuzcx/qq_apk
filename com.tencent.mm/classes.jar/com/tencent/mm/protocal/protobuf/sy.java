package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sy
  extends com.tencent.mm.bw.a
{
  public String GiA;
  public ti GiB;
  public String GiC;
  public String GiJ;
  public String GiK;
  public String GiL;
  public String GiM;
  public LinkedList<sw> GiN;
  public LinkedList<sv> GiO;
  public String GiP;
  public String GiQ;
  public ti GiR;
  public sw GiS;
  public int GiT;
  public int GiU;
  public int GiV;
  public long GiW;
  public int Giz;
  
  public sy()
  {
    AppMethodBeat.i(113954);
    this.GiN = new LinkedList();
    this.GiO = new LinkedList();
    AppMethodBeat.o(113954);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113955);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GiJ != null) {
        paramVarArgs.d(1, this.GiJ);
      }
      if (this.GiK != null) {
        paramVarArgs.d(2, this.GiK);
      }
      if (this.GiL != null) {
        paramVarArgs.d(3, this.GiL);
      }
      if (this.GiM != null) {
        paramVarArgs.d(4, this.GiM);
      }
      paramVarArgs.e(5, 8, this.GiN);
      paramVarArgs.aS(6, this.Giz);
      if (this.GiA != null) {
        paramVarArgs.d(7, this.GiA);
      }
      if (this.GiB != null)
      {
        paramVarArgs.lJ(8, this.GiB.computeSize());
        this.GiB.writeFields(paramVarArgs);
      }
      if (this.GiC != null) {
        paramVarArgs.d(9, this.GiC);
      }
      paramVarArgs.e(10, 8, this.GiO);
      if (this.GiP != null) {
        paramVarArgs.d(11, this.GiP);
      }
      if (this.GiQ != null) {
        paramVarArgs.d(12, this.GiQ);
      }
      if (this.GiR != null)
      {
        paramVarArgs.lJ(13, this.GiR.computeSize());
        this.GiR.writeFields(paramVarArgs);
      }
      if (this.GiS != null)
      {
        paramVarArgs.lJ(14, this.GiS.computeSize());
        this.GiS.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(15, this.GiT);
      paramVarArgs.aS(16, this.GiU);
      paramVarArgs.aS(17, this.GiV);
      paramVarArgs.aZ(18, this.GiW);
      AppMethodBeat.o(113955);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GiJ == null) {
        break label1630;
      }
    }
    label1630:
    for (int i = f.a.a.b.b.a.e(1, this.GiJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GiK != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GiK);
      }
      i = paramInt;
      if (this.GiL != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GiL);
      }
      paramInt = i;
      if (this.GiM != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GiM);
      }
      i = paramInt + f.a.a.a.c(5, 8, this.GiN) + f.a.a.b.b.a.bz(6, this.Giz);
      paramInt = i;
      if (this.GiA != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GiA);
      }
      i = paramInt;
      if (this.GiB != null) {
        i = paramInt + f.a.a.a.lI(8, this.GiB.computeSize());
      }
      paramInt = i;
      if (this.GiC != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GiC);
      }
      i = paramInt + f.a.a.a.c(10, 8, this.GiO);
      paramInt = i;
      if (this.GiP != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GiP);
      }
      i = paramInt;
      if (this.GiQ != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GiQ);
      }
      paramInt = i;
      if (this.GiR != null) {
        paramInt = i + f.a.a.a.lI(13, this.GiR.computeSize());
      }
      i = paramInt;
      if (this.GiS != null) {
        i = paramInt + f.a.a.a.lI(14, this.GiS.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(15, this.GiT);
      int j = f.a.a.b.b.a.bz(16, this.GiU);
      int k = f.a.a.b.b.a.bz(17, this.GiV);
      int m = f.a.a.b.b.a.p(18, this.GiW);
      AppMethodBeat.o(113955);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GiN.clear();
        this.GiO.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(113955);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sy localsy = (sy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113955);
          return -1;
        case 1: 
          localsy.GiJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 2: 
          localsy.GiK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 3: 
          localsy.GiL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 4: 
          localsy.GiM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsy.GiN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 6: 
          localsy.Giz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(113955);
          return 0;
        case 7: 
          localsy.GiA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ti();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ti)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsy.GiB = ((ti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 9: 
          localsy.GiC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsy.GiO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 11: 
          localsy.GiP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 12: 
          localsy.GiQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ti();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ti)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsy.GiR = ((ti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsy.GiS = ((sw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 15: 
          localsy.GiT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(113955);
          return 0;
        case 16: 
          localsy.GiU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(113955);
          return 0;
        case 17: 
          localsy.GiV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(113955);
          return 0;
        }
        localsy.GiW = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(113955);
        return 0;
      }
      AppMethodBeat.o(113955);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sy
 * JD-Core Version:    0.7.0.1
 */