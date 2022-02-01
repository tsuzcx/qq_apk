package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bmj
  extends cwj
{
  public String FUm;
  public String GZA;
  public String GZB;
  public int GZC;
  public String GZD;
  public int GZE;
  public int GZF;
  public cct GZG;
  public String GZv;
  public int GZw;
  public String GZx;
  public LinkedList<cct> GZy;
  public int GZz;
  public String GeE;
  public ehl GoD;
  public String dyI;
  public int nzZ;
  
  public bmj()
  {
    AppMethodBeat.i(123591);
    this.GZy = new LinkedList();
    AppMethodBeat.o(123591);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123592);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123592);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GoD != null)
      {
        paramVarArgs.lJ(2, this.GoD.computeSize());
        this.GoD.writeFields(paramVarArgs);
      }
      if (this.GZv != null) {
        paramVarArgs.d(3, this.GZv);
      }
      paramVarArgs.aS(4, this.GZw);
      paramVarArgs.aS(5, this.nzZ);
      if (this.GZx != null) {
        paramVarArgs.d(6, this.GZx);
      }
      paramVarArgs.e(7, 8, this.GZy);
      paramVarArgs.aS(8, this.GZz);
      if (this.GZA != null) {
        paramVarArgs.d(9, this.GZA);
      }
      if (this.GZB != null) {
        paramVarArgs.d(10, this.GZB);
      }
      paramVarArgs.aS(11, this.GZC);
      if (this.dyI != null) {
        paramVarArgs.d(12, this.dyI);
      }
      if (this.FUm != null) {
        paramVarArgs.d(13, this.FUm);
      }
      if (this.GeE != null) {
        paramVarArgs.d(14, this.GeE);
      }
      if (this.GZD != null) {
        paramVarArgs.d(15, this.GZD);
      }
      paramVarArgs.aS(16, this.GZE);
      paramVarArgs.aS(17, this.GZF);
      if (this.GZG != null)
      {
        paramVarArgs.lJ(18, this.GZG.computeSize());
        this.GZG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123592);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1570;
      }
    }
    label1570:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GoD != null) {
        paramInt = i + f.a.a.a.lI(2, this.GoD.computeSize());
      }
      i = paramInt;
      if (this.GZv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GZv);
      }
      i = i + f.a.a.b.b.a.bz(4, this.GZw) + f.a.a.b.b.a.bz(5, this.nzZ);
      paramInt = i;
      if (this.GZx != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GZx);
      }
      i = paramInt + f.a.a.a.c(7, 8, this.GZy) + f.a.a.b.b.a.bz(8, this.GZz);
      paramInt = i;
      if (this.GZA != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GZA);
      }
      i = paramInt;
      if (this.GZB != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GZB);
      }
      i += f.a.a.b.b.a.bz(11, this.GZC);
      paramInt = i;
      if (this.dyI != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.dyI);
      }
      i = paramInt;
      if (this.FUm != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.FUm);
      }
      paramInt = i;
      if (this.GeE != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.GeE);
      }
      i = paramInt;
      if (this.GZD != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.GZD);
      }
      i = i + f.a.a.b.b.a.bz(16, this.GZE) + f.a.a.b.b.a.bz(17, this.GZF);
      paramInt = i;
      if (this.GZG != null) {
        paramInt = i + f.a.a.a.lI(18, this.GZG.computeSize());
      }
      AppMethodBeat.o(123592);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GZy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123592);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123592);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bmj localbmj = (bmj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123592);
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
            localbmj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmj.GoD = ((ehl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 3: 
          localbmj.GZv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 4: 
          localbmj.GZw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123592);
          return 0;
        case 5: 
          localbmj.nzZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123592);
          return 0;
        case 6: 
          localbmj.GZx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cct();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cct)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmj.GZy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 8: 
          localbmj.GZz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123592);
          return 0;
        case 9: 
          localbmj.GZA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 10: 
          localbmj.GZB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 11: 
          localbmj.GZC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123592);
          return 0;
        case 12: 
          localbmj.dyI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 13: 
          localbmj.FUm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 14: 
          localbmj.GeE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 15: 
          localbmj.GZD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 16: 
          localbmj.GZE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123592);
          return 0;
        case 17: 
          localbmj.GZF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123592);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cct();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cct)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbmj.GZG = ((cct)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123592);
        return 0;
      }
      AppMethodBeat.o(123592);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmj
 * JD-Core Version:    0.7.0.1
 */