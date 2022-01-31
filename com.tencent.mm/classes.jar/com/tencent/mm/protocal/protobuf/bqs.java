package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bqs
  extends bvk
{
  public long cNd;
  public int oiE;
  public int oiF;
  public String oiG;
  public String oiH;
  public String oiI;
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
  
  public bqs()
  {
    AppMethodBeat.i(56948);
    this.xxI = new LinkedList();
    AppMethodBeat.o(56948);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56949);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56949);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.am(2, this.cNd);
      paramVarArgs.aO(3, this.xxF);
      paramVarArgs.am(4, this.xxG);
      paramVarArgs.aO(5, this.wjZ);
      paramVarArgs.am(6, this.xxH);
      paramVarArgs.aO(9, this.oiF);
      paramVarArgs.e(10, 8, this.xxI);
      if (this.oiG != null) {
        paramVarArgs.e(11, this.oiG);
      }
      if (this.xxJ != null) {
        paramVarArgs.e(12, this.xxJ);
      }
      if (this.xxK != null) {
        paramVarArgs.e(13, this.xxK);
      }
      if (this.xxL != null) {
        paramVarArgs.e(14, this.xxL);
      }
      paramVarArgs.aO(15, this.xxM);
      if (this.oiI != null) {
        paramVarArgs.e(16, this.oiI);
      }
      paramVarArgs.aO(17, this.xxN);
      if (this.oiH != null) {
        paramVarArgs.e(18, this.oiH);
      }
      paramVarArgs.aO(19, this.xxE);
      paramVarArgs.aO(20, this.oiE);
      paramVarArgs.aO(21, this.xxD);
      if (this.xxO != null) {
        paramVarArgs.e(22, this.xxO);
      }
      AppMethodBeat.o(56949);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1426;
      }
    }
    label1426:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.cNd) + e.a.a.b.b.a.bl(3, this.xxF) + e.a.a.b.b.a.p(4, this.xxG) + e.a.a.b.b.a.bl(5, this.wjZ) + e.a.a.b.b.a.p(6, this.xxH) + e.a.a.b.b.a.bl(9, this.oiF) + e.a.a.a.c(10, 8, this.xxI);
      paramInt = i;
      if (this.oiG != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.oiG);
      }
      i = paramInt;
      if (this.xxJ != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.xxJ);
      }
      paramInt = i;
      if (this.xxK != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.xxK);
      }
      i = paramInt;
      if (this.xxL != null) {
        i = paramInt + e.a.a.b.b.a.f(14, this.xxL);
      }
      i += e.a.a.b.b.a.bl(15, this.xxM);
      paramInt = i;
      if (this.oiI != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.oiI);
      }
      i = paramInt + e.a.a.b.b.a.bl(17, this.xxN);
      paramInt = i;
      if (this.oiH != null) {
        paramInt = i + e.a.a.b.b.a.f(18, this.oiH);
      }
      i = paramInt + e.a.a.b.b.a.bl(19, this.xxE) + e.a.a.b.b.a.bl(20, this.oiE) + e.a.a.b.b.a.bl(21, this.xxD);
      paramInt = i;
      if (this.xxO != null) {
        paramInt = i + e.a.a.b.b.a.f(22, this.xxO);
      }
      AppMethodBeat.o(56949);
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
          AppMethodBeat.o(56949);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56949);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bqs localbqs = (bqs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(56949);
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
            localbqs.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56949);
          return 0;
        case 2: 
          localbqs.cNd = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56949);
          return 0;
        case 3: 
          localbqs.xxF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56949);
          return 0;
        case 4: 
          localbqs.xxG = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56949);
          return 0;
        case 5: 
          localbqs.wjZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56949);
          return 0;
        case 6: 
          localbqs.xxH = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56949);
          return 0;
        case 9: 
          localbqs.oiF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56949);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aty();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aty)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbqs.xxI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56949);
          return 0;
        case 11: 
          localbqs.oiG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56949);
          return 0;
        case 12: 
          localbqs.xxJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56949);
          return 0;
        case 13: 
          localbqs.xxK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56949);
          return 0;
        case 14: 
          localbqs.xxL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56949);
          return 0;
        case 15: 
          localbqs.xxM = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56949);
          return 0;
        case 16: 
          localbqs.oiI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56949);
          return 0;
        case 17: 
          localbqs.xxN = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56949);
          return 0;
        case 18: 
          localbqs.oiH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56949);
          return 0;
        case 19: 
          localbqs.xxE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56949);
          return 0;
        case 20: 
          localbqs.oiE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56949);
          return 0;
        case 21: 
          localbqs.xxD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56949);
          return 0;
        }
        localbqs.xxO = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56949);
        return 0;
      }
      AppMethodBeat.o(56949);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqs
 * JD-Core Version:    0.7.0.1
 */