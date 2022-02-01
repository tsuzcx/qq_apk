package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bal
  extends cwj
{
  public ti GQA;
  public String GQB;
  public int GQC;
  public int GQD;
  public tr GQE;
  public int GQy;
  public tc GQz;
  public int oGt;
  public String oGu;
  public int pqB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218612);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(218612);
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
      if (this.GQz != null)
      {
        paramVarArgs.lJ(6, this.GQz.computeSize());
        this.GQz.writeFields(paramVarArgs);
      }
      if (this.GQA != null)
      {
        paramVarArgs.lJ(7, this.GQA.computeSize());
        this.GQA.writeFields(paramVarArgs);
      }
      if (this.GQB != null) {
        paramVarArgs.d(8, this.GQB);
      }
      paramVarArgs.aS(9, this.GQC);
      paramVarArgs.aS(10, this.GQD);
      if (this.GQE != null)
      {
        paramVarArgs.lJ(11, this.GQE.computeSize());
        this.GQE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(218612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1170;
      }
    }
    label1170:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.pqB) + f.a.a.b.b.a.bz(5, this.GQy);
      paramInt = i;
      if (this.GQz != null) {
        paramInt = i + f.a.a.a.lI(6, this.GQz.computeSize());
      }
      i = paramInt;
      if (this.GQA != null) {
        i = paramInt + f.a.a.a.lI(7, this.GQA.computeSize());
      }
      paramInt = i;
      if (this.GQB != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GQB);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.GQC) + f.a.a.b.b.a.bz(10, this.GQD);
      paramInt = i;
      if (this.GQE != null) {
        paramInt = i + f.a.a.a.lI(11, this.GQE.computeSize());
      }
      AppMethodBeat.o(218612);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(218612);
          throw paramVarArgs;
        }
        AppMethodBeat.o(218612);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bal localbal = (bal)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(218612);
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
            localbal.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218612);
          return 0;
        case 2: 
          localbal.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218612);
          return 0;
        case 3: 
          localbal.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218612);
          return 0;
        case 4: 
          localbal.pqB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218612);
          return 0;
        case 5: 
          localbal.GQy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218612);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbal.GQz = ((tc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218612);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ti();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ti)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbal.GQA = ((ti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218612);
          return 0;
        case 8: 
          localbal.GQB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218612);
          return 0;
        case 9: 
          localbal.GQC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218612);
          return 0;
        case 10: 
          localbal.GQD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218612);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new tr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((tr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbal.GQE = ((tr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(218612);
        return 0;
      }
      AppMethodBeat.o(218612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bal
 * JD-Core Version:    0.7.0.1
 */