package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bmo
  extends cwj
{
  public int GZE;
  public LinkedList<eit> GZR;
  public eit GZS;
  public String GZT;
  public int GZU;
  public String GZV;
  public String GZW;
  public String GZX;
  public String GZY;
  public ehl GoD;
  
  public bmo()
  {
    AppMethodBeat.i(123594);
    this.GZR = new LinkedList();
    AppMethodBeat.o(123594);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123595);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123595);
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
      paramVarArgs.e(3, 8, this.GZR);
      if (this.GZS != null)
      {
        paramVarArgs.lJ(4, this.GZS.computeSize());
        this.GZS.writeFields(paramVarArgs);
      }
      if (this.GZT != null) {
        paramVarArgs.d(5, this.GZT);
      }
      paramVarArgs.aS(6, this.GZU);
      if (this.GZV != null) {
        paramVarArgs.d(7, this.GZV);
      }
      if (this.GZW != null) {
        paramVarArgs.d(8, this.GZW);
      }
      if (this.GZX != null) {
        paramVarArgs.d(9, this.GZX);
      }
      if (this.GZY != null) {
        paramVarArgs.d(10, this.GZY);
      }
      paramVarArgs.aS(11, this.GZE);
      AppMethodBeat.o(123595);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1206;
      }
    }
    label1206:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GoD != null) {
        i = paramInt + f.a.a.a.lI(2, this.GoD.computeSize());
      }
      i += f.a.a.a.c(3, 8, this.GZR);
      paramInt = i;
      if (this.GZS != null) {
        paramInt = i + f.a.a.a.lI(4, this.GZS.computeSize());
      }
      i = paramInt;
      if (this.GZT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GZT);
      }
      i += f.a.a.b.b.a.bz(6, this.GZU);
      paramInt = i;
      if (this.GZV != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GZV);
      }
      i = paramInt;
      if (this.GZW != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GZW);
      }
      paramInt = i;
      if (this.GZX != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GZX);
      }
      i = paramInt;
      if (this.GZY != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GZY);
      }
      paramInt = f.a.a.b.b.a.bz(11, this.GZE);
      AppMethodBeat.o(123595);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GZR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123595);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123595);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bmo localbmo = (bmo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123595);
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
            localbmo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
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
            localbmo.GoD = ((ehl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eit();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eit)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmo.GZR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eit();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eit)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmo.GZS = ((eit)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 5: 
          localbmo.GZT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 6: 
          localbmo.GZU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123595);
          return 0;
        case 7: 
          localbmo.GZV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 8: 
          localbmo.GZW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 9: 
          localbmo.GZX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 10: 
          localbmo.GZY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123595);
          return 0;
        }
        localbmo.GZE = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(123595);
        return 0;
      }
      AppMethodBeat.o(123595);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmo
 * JD-Core Version:    0.7.0.1
 */