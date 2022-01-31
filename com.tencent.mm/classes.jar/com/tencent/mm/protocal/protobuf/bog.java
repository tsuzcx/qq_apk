package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bog
  extends bvk
{
  public int nNf;
  public String nNg;
  public int nNk;
  public int nNq;
  public int nNr;
  public int nNs;
  public com.tencent.mm.bv.b nNt;
  public int nNv;
  public int nNy;
  public int wQP;
  public long wQQ;
  public LinkedList<bny> wtb;
  public int xCA;
  public long xCm;
  public int xCv;
  public int xCw;
  public LinkedList<bny> xCx;
  public String xCy;
  public com.tencent.mm.bv.b xCz;
  
  public bog()
  {
    AppMethodBeat.i(28582);
    this.wtb = new LinkedList();
    this.xCx = new LinkedList();
    AppMethodBeat.o(28582);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28583);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28583);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wQP);
      paramVarArgs.am(3, this.wQQ);
      paramVarArgs.aO(4, this.xCv);
      paramVarArgs.e(5, 8, this.wtb);
      paramVarArgs.aO(6, this.xCw);
      paramVarArgs.aO(7, this.nNq);
      paramVarArgs.aO(8, this.nNr);
      paramVarArgs.am(9, this.xCm);
      paramVarArgs.aO(10, this.nNs);
      if (this.nNt != null) {
        paramVarArgs.c(11, this.nNt);
      }
      paramVarArgs.aO(12, this.nNk);
      paramVarArgs.aO(13, this.nNf);
      if (this.nNg != null) {
        paramVarArgs.e(14, this.nNg);
      }
      paramVarArgs.aO(15, this.nNv);
      paramVarArgs.e(16, 8, this.xCx);
      paramVarArgs.aO(17, this.nNy);
      if (this.xCy != null) {
        paramVarArgs.e(18, this.xCy);
      }
      if (this.xCz != null) {
        paramVarArgs.c(19, this.xCz);
      }
      paramVarArgs.aO(20, this.xCA);
      AppMethodBeat.o(28583);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1488;
      }
    }
    label1488:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wQP) + e.a.a.b.b.a.p(3, this.wQQ) + e.a.a.b.b.a.bl(4, this.xCv) + e.a.a.a.c(5, 8, this.wtb) + e.a.a.b.b.a.bl(6, this.xCw) + e.a.a.b.b.a.bl(7, this.nNq) + e.a.a.b.b.a.bl(8, this.nNr) + e.a.a.b.b.a.p(9, this.xCm) + e.a.a.b.b.a.bl(10, this.nNs);
      paramInt = i;
      if (this.nNt != null) {
        paramInt = i + e.a.a.b.b.a.b(11, this.nNt);
      }
      i = paramInt + e.a.a.b.b.a.bl(12, this.nNk) + e.a.a.b.b.a.bl(13, this.nNf);
      paramInt = i;
      if (this.nNg != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.nNg);
      }
      i = paramInt + e.a.a.b.b.a.bl(15, this.nNv) + e.a.a.a.c(16, 8, this.xCx) + e.a.a.b.b.a.bl(17, this.nNy);
      paramInt = i;
      if (this.xCy != null) {
        paramInt = i + e.a.a.b.b.a.f(18, this.xCy);
      }
      i = paramInt;
      if (this.xCz != null) {
        i = paramInt + e.a.a.b.b.a.b(19, this.xCz);
      }
      paramInt = e.a.a.b.b.a.bl(20, this.xCA);
      AppMethodBeat.o(28583);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wtb.clear();
        this.xCx.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28583);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28583);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bog localbog = (bog)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28583);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbog.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28583);
          return 0;
        case 2: 
          localbog.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28583);
          return 0;
        case 3: 
          localbog.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(28583);
          return 0;
        case 4: 
          localbog.xCv = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28583);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bny();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bny)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbog.wtb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28583);
          return 0;
        case 6: 
          localbog.xCw = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28583);
          return 0;
        case 7: 
          localbog.nNq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28583);
          return 0;
        case 8: 
          localbog.nNr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28583);
          return 0;
        case 9: 
          localbog.xCm = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(28583);
          return 0;
        case 10: 
          localbog.nNs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28583);
          return 0;
        case 11: 
          localbog.nNt = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(28583);
          return 0;
        case 12: 
          localbog.nNk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28583);
          return 0;
        case 13: 
          localbog.nNf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28583);
          return 0;
        case 14: 
          localbog.nNg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28583);
          return 0;
        case 15: 
          localbog.nNv = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28583);
          return 0;
        case 16: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bny();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bny)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbog.xCx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28583);
          return 0;
        case 17: 
          localbog.nNy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28583);
          return 0;
        case 18: 
          localbog.xCy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28583);
          return 0;
        case 19: 
          localbog.xCz = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(28583);
          return 0;
        }
        localbog.xCA = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28583);
        return 0;
      }
      AppMethodBeat.o(28583);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bog
 * JD-Core Version:    0.7.0.1
 */