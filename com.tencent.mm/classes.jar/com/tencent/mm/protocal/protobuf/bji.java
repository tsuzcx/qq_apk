package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bji
  extends bvk
{
  public long cNd;
  public int oiE;
  public int oiF;
  public String oiG;
  public String oiH;
  public String oiI;
  public bry wIk;
  public int wjZ;
  public int xxD;
  public int xxE;
  public int xxF;
  public long xxG;
  public long xxH;
  public LinkedList<aty> xxI;
  public String xxJ;
  public String xxK;
  public String xxL;
  public int xxM;
  public int xxN;
  public String xxO;
  
  public bji()
  {
    AppMethodBeat.i(56874);
    this.xxI = new LinkedList();
    AppMethodBeat.o(56874);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56875);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56875);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xxD);
      paramVarArgs.aO(3, this.xxE);
      paramVarArgs.aO(4, this.oiE);
      paramVarArgs.am(5, this.cNd);
      paramVarArgs.aO(6, this.xxF);
      paramVarArgs.am(7, this.xxG);
      paramVarArgs.aO(8, this.wjZ);
      paramVarArgs.am(9, this.xxH);
      paramVarArgs.aO(10, this.oiF);
      paramVarArgs.e(11, 8, this.xxI);
      if (this.oiG != null) {
        paramVarArgs.e(12, this.oiG);
      }
      if (this.xxJ != null) {
        paramVarArgs.e(13, this.xxJ);
      }
      if (this.xxK != null) {
        paramVarArgs.e(14, this.xxK);
      }
      if (this.xxL != null) {
        paramVarArgs.e(15, this.xxL);
      }
      paramVarArgs.aO(16, this.xxM);
      if (this.oiI != null) {
        paramVarArgs.e(17, this.oiI);
      }
      paramVarArgs.aO(18, this.xxN);
      if (this.oiH != null) {
        paramVarArgs.e(19, this.oiH);
      }
      if (this.wIk != null)
      {
        paramVarArgs.iQ(20, this.wIk.computeSize());
        this.wIk.writeFields(paramVarArgs);
      }
      if (this.xxO != null) {
        paramVarArgs.e(21, this.xxO);
      }
      AppMethodBeat.o(56875);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1570;
      }
    }
    label1570:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xxD) + e.a.a.b.b.a.bl(3, this.xxE) + e.a.a.b.b.a.bl(4, this.oiE) + e.a.a.b.b.a.p(5, this.cNd) + e.a.a.b.b.a.bl(6, this.xxF) + e.a.a.b.b.a.p(7, this.xxG) + e.a.a.b.b.a.bl(8, this.wjZ) + e.a.a.b.b.a.p(9, this.xxH) + e.a.a.b.b.a.bl(10, this.oiF) + e.a.a.a.c(11, 8, this.xxI);
      paramInt = i;
      if (this.oiG != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.oiG);
      }
      i = paramInt;
      if (this.xxJ != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.xxJ);
      }
      paramInt = i;
      if (this.xxK != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.xxK);
      }
      i = paramInt;
      if (this.xxL != null) {
        i = paramInt + e.a.a.b.b.a.f(15, this.xxL);
      }
      i += e.a.a.b.b.a.bl(16, this.xxM);
      paramInt = i;
      if (this.oiI != null) {
        paramInt = i + e.a.a.b.b.a.f(17, this.oiI);
      }
      i = paramInt + e.a.a.b.b.a.bl(18, this.xxN);
      paramInt = i;
      if (this.oiH != null) {
        paramInt = i + e.a.a.b.b.a.f(19, this.oiH);
      }
      i = paramInt;
      if (this.wIk != null) {
        i = paramInt + e.a.a.a.iP(20, this.wIk.computeSize());
      }
      paramInt = i;
      if (this.xxO != null) {
        paramInt = i + e.a.a.b.b.a.f(21, this.xxO);
      }
      AppMethodBeat.o(56875);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xxI.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56875);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56875);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bji localbji = (bji)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56875);
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
            localbji.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56875);
          return 0;
        case 2: 
          localbji.xxD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56875);
          return 0;
        case 3: 
          localbji.xxE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56875);
          return 0;
        case 4: 
          localbji.oiE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56875);
          return 0;
        case 5: 
          localbji.cNd = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56875);
          return 0;
        case 6: 
          localbji.xxF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56875);
          return 0;
        case 7: 
          localbji.xxG = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56875);
          return 0;
        case 8: 
          localbji.wjZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56875);
          return 0;
        case 9: 
          localbji.xxH = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56875);
          return 0;
        case 10: 
          localbji.oiF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56875);
          return 0;
        case 11: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aty();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aty)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbji.xxI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56875);
          return 0;
        case 12: 
          localbji.oiG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56875);
          return 0;
        case 13: 
          localbji.xxJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56875);
          return 0;
        case 14: 
          localbji.xxK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56875);
          return 0;
        case 15: 
          localbji.xxL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56875);
          return 0;
        case 16: 
          localbji.xxM = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56875);
          return 0;
        case 17: 
          localbji.oiI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56875);
          return 0;
        case 18: 
          localbji.xxN = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56875);
          return 0;
        case 19: 
          localbji.oiH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56875);
          return 0;
        case 20: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bry();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bry)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbji.wIk = ((bry)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56875);
          return 0;
        }
        localbji.xxO = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56875);
        return 0;
      }
      AppMethodBeat.o(56875);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bji
 * JD-Core Version:    0.7.0.1
 */