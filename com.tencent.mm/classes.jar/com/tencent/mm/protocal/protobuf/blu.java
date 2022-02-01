package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class blu
  extends cwj
{
  public String Desc;
  public int GYA;
  public LinkedList<ecc> GYB;
  public String GYO;
  public String GYP;
  public String GYQ;
  public String GYR;
  public String GYS;
  public String GYT;
  public eci GYU;
  public String GYV;
  public String GYW;
  public String GYX;
  public String GYY;
  public String GYZ;
  public String Title;
  public String urq;
  
  public blu()
  {
    AppMethodBeat.i(32308);
    this.GYB = new LinkedList();
    AppMethodBeat.o(32308);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32309);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32309);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GYO != null) {
        paramVarArgs.d(2, this.GYO);
      }
      if (this.urq != null) {
        paramVarArgs.d(3, this.urq);
      }
      if (this.Title != null) {
        paramVarArgs.d(4, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(5, this.Desc);
      }
      if (this.GYP != null) {
        paramVarArgs.d(6, this.GYP);
      }
      if (this.GYQ != null) {
        paramVarArgs.d(7, this.GYQ);
      }
      if (this.GYR != null) {
        paramVarArgs.d(8, this.GYR);
      }
      if (this.GYS != null) {
        paramVarArgs.d(9, this.GYS);
      }
      if (this.GYT != null) {
        paramVarArgs.d(10, this.GYT);
      }
      if (this.GYU != null)
      {
        paramVarArgs.lJ(11, this.GYU.computeSize());
        this.GYU.writeFields(paramVarArgs);
      }
      if (this.GYV != null) {
        paramVarArgs.d(12, this.GYV);
      }
      if (this.GYW != null) {
        paramVarArgs.d(13, this.GYW);
      }
      if (this.GYX != null) {
        paramVarArgs.d(14, this.GYX);
      }
      if (this.GYY != null) {
        paramVarArgs.d(15, this.GYY);
      }
      if (this.GYZ != null) {
        paramVarArgs.d(16, this.GYZ);
      }
      paramVarArgs.aS(17, this.GYA);
      paramVarArgs.e(18, 8, this.GYB);
      AppMethodBeat.o(32309);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1590;
      }
    }
    label1590:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GYO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GYO);
      }
      i = paramInt;
      if (this.urq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.urq);
      }
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Title);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Desc);
      }
      paramInt = i;
      if (this.GYP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GYP);
      }
      i = paramInt;
      if (this.GYQ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GYQ);
      }
      paramInt = i;
      if (this.GYR != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GYR);
      }
      i = paramInt;
      if (this.GYS != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GYS);
      }
      paramInt = i;
      if (this.GYT != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GYT);
      }
      i = paramInt;
      if (this.GYU != null) {
        i = paramInt + f.a.a.a.lI(11, this.GYU.computeSize());
      }
      paramInt = i;
      if (this.GYV != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.GYV);
      }
      i = paramInt;
      if (this.GYW != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.GYW);
      }
      paramInt = i;
      if (this.GYX != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.GYX);
      }
      i = paramInt;
      if (this.GYY != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.GYY);
      }
      paramInt = i;
      if (this.GYZ != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.GYZ);
      }
      i = f.a.a.b.b.a.bz(17, this.GYA);
      int j = f.a.a.a.c(18, 8, this.GYB);
      AppMethodBeat.o(32309);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GYB.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32309);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32309);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        blu localblu = (blu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32309);
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
            localblu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32309);
          return 0;
        case 2: 
          localblu.GYO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 3: 
          localblu.urq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 4: 
          localblu.Title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 5: 
          localblu.Desc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 6: 
          localblu.GYP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 7: 
          localblu.GYQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 8: 
          localblu.GYR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 9: 
          localblu.GYS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 10: 
          localblu.GYT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eci();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eci)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblu.GYU = ((eci)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32309);
          return 0;
        case 12: 
          localblu.GYV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 13: 
          localblu.GYW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 14: 
          localblu.GYX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 15: 
          localblu.GYY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 16: 
          localblu.GYZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 17: 
          localblu.GYA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32309);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ecc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ecc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localblu.GYB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32309);
        return 0;
      }
      AppMethodBeat.o(32309);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blu
 * JD-Core Version:    0.7.0.1
 */