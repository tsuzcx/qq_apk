package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class beq
  extends cwj
{
  public ti GQA;
  public String GQB;
  public int GQC;
  public int GQD;
  public tr GQE;
  public int GQy;
  public ti GTL;
  public String GTM;
  public String GTN;
  public LinkedList<sv> GiO;
  public int oGt;
  public String oGu;
  public int pqB;
  
  public beq()
  {
    AppMethodBeat.i(218614);
    this.GiO = new LinkedList();
    AppMethodBeat.o(218614);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218615);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(218615);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      paramVarArgs.aS(4, this.pqB);
      paramVarArgs.aS(5, this.GQy);
      paramVarArgs.e(6, 8, this.GiO);
      if (this.GQE != null)
      {
        paramVarArgs.lJ(7, this.GQE.computeSize());
        this.GQE.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.GQC);
      paramVarArgs.aS(9, this.GQD);
      if (this.GQA != null)
      {
        paramVarArgs.lJ(10, this.GQA.computeSize());
        this.GQA.writeFields(paramVarArgs);
      }
      if (this.GQB != null) {
        paramVarArgs.d(11, this.GQB);
      }
      if (this.GTL != null)
      {
        paramVarArgs.lJ(12, this.GTL.computeSize());
        this.GTL.writeFields(paramVarArgs);
      }
      if (this.GTM != null) {
        paramVarArgs.d(13, this.GTM);
      }
      if (this.GTN != null) {
        paramVarArgs.d(14, this.GTN);
      }
      AppMethodBeat.o(218615);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1434;
      }
    }
    label1434:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.pqB) + f.a.a.b.b.a.bz(5, this.GQy) + f.a.a.a.c(6, 8, this.GiO);
      paramInt = i;
      if (this.GQE != null) {
        paramInt = i + f.a.a.a.lI(7, this.GQE.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.GQC) + f.a.a.b.b.a.bz(9, this.GQD);
      paramInt = i;
      if (this.GQA != null) {
        paramInt = i + f.a.a.a.lI(10, this.GQA.computeSize());
      }
      i = paramInt;
      if (this.GQB != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.GQB);
      }
      paramInt = i;
      if (this.GTL != null) {
        paramInt = i + f.a.a.a.lI(12, this.GTL.computeSize());
      }
      i = paramInt;
      if (this.GTM != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.GTM);
      }
      paramInt = i;
      if (this.GTN != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.GTN);
      }
      AppMethodBeat.o(218615);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GiO.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(218615);
          throw paramVarArgs;
        }
        AppMethodBeat.o(218615);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        beq localbeq = (beq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(218615);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbeq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218615);
          return 0;
        case 2: 
          localbeq.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218615);
          return 0;
        case 3: 
          localbeq.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218615);
          return 0;
        case 4: 
          localbeq.pqB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218615);
          return 0;
        case 5: 
          localbeq.GQy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218615);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbeq.GiO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218615);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbeq.GQE = ((tr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218615);
          return 0;
        case 8: 
          localbeq.GQC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218615);
          return 0;
        case 9: 
          localbeq.GQD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218615);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ti();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ti)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbeq.GQA = ((ti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218615);
          return 0;
        case 11: 
          localbeq.GQB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218615);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ti();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ti)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbeq.GTL = ((ti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218615);
          return 0;
        case 13: 
          localbeq.GTM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218615);
          return 0;
        }
        localbeq.GTN = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(218615);
        return 0;
      }
      AppMethodBeat.o(218615);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beq
 * JD-Core Version:    0.7.0.1
 */