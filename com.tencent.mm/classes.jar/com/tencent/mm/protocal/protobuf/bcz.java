package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcz
  extends cwj
{
  public byi GQH;
  public bns GSA;
  public bpf GSB;
  public ru GSz;
  public bnu GoP;
  public int oGt;
  public String oGu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72489);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72489);
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
      if (this.GoP != null)
      {
        paramVarArgs.lJ(4, this.GoP.computeSize());
        this.GoP.writeFields(paramVarArgs);
      }
      if (this.GSz != null)
      {
        paramVarArgs.lJ(8, this.GSz.computeSize());
        this.GSz.writeFields(paramVarArgs);
      }
      if (this.GQH != null)
      {
        paramVarArgs.lJ(9, this.GQH.computeSize());
        this.GQH.writeFields(paramVarArgs);
      }
      if (this.GSA != null)
      {
        paramVarArgs.lJ(10, this.GSA.computeSize());
        this.GSA.writeFields(paramVarArgs);
      }
      if (this.GSB != null)
      {
        paramVarArgs.lJ(11, this.GSB.computeSize());
        this.GSB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1254;
      }
    }
    label1254:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt;
      if (this.GoP != null) {
        i = paramInt + f.a.a.a.lI(4, this.GoP.computeSize());
      }
      paramInt = i;
      if (this.GSz != null) {
        paramInt = i + f.a.a.a.lI(8, this.GSz.computeSize());
      }
      i = paramInt;
      if (this.GQH != null) {
        i = paramInt + f.a.a.a.lI(9, this.GQH.computeSize());
      }
      paramInt = i;
      if (this.GSA != null) {
        paramInt = i + f.a.a.a.lI(10, this.GSA.computeSize());
      }
      i = paramInt;
      if (this.GSB != null) {
        i = paramInt + f.a.a.a.lI(11, this.GSB.computeSize());
      }
      AppMethodBeat.o(72489);
      return i;
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
          AppMethodBeat.o(72489);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72489);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcz localbcz = (bcz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        case 7: 
        default: 
          AppMethodBeat.o(72489);
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
            localbcz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        case 2: 
          localbcz.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72489);
          return 0;
        case 3: 
          localbcz.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72489);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcz.GoP = ((bnu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ru();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ru)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcz.GSz = ((ru)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((byi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcz.GQH = ((byi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bns();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bns)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcz.GSA = ((bns)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbcz.GSB = ((bpf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72489);
        return 0;
      }
      AppMethodBeat.o(72489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcz
 * JD-Core Version:    0.7.0.1
 */