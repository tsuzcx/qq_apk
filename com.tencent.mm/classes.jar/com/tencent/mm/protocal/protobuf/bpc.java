package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bpc
  extends cwj
{
  public LinkedList<bpd> HcA;
  public cla HcB;
  public cwv HcC;
  public boolean HcD;
  public iu HcE;
  public int oGt;
  public String oGu;
  
  public bpc()
  {
    AppMethodBeat.i(72502);
    this.HcA = new LinkedList();
    AppMethodBeat.o(72502);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72503);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72503);
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
      paramVarArgs.e(4, 8, this.HcA);
      if (this.HcB != null)
      {
        paramVarArgs.lJ(5, this.HcB.computeSize());
        this.HcB.writeFields(paramVarArgs);
      }
      if (this.HcC != null)
      {
        paramVarArgs.lJ(6, this.HcC.computeSize());
        this.HcC.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(7, this.HcD);
      if (this.HcE != null)
      {
        paramVarArgs.lJ(8, this.HcE.computeSize());
        this.HcE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1110;
      }
    }
    label1110:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.HcA);
      paramInt = i;
      if (this.HcB != null) {
        paramInt = i + f.a.a.a.lI(5, this.HcB.computeSize());
      }
      i = paramInt;
      if (this.HcC != null) {
        i = paramInt + f.a.a.a.lI(6, this.HcC.computeSize());
      }
      i += f.a.a.b.b.a.amF(7);
      paramInt = i;
      if (this.HcE != null) {
        paramInt = i + f.a.a.a.lI(8, this.HcE.computeSize());
      }
      AppMethodBeat.o(72503);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HcA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72503);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72503);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bpc localbpc = (bpc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72503);
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
            localbpc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 2: 
          localbpc.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72503);
          return 0;
        case 3: 
          localbpc.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72503);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpc.HcA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cla();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cla)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpc.HcB = ((cla)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpc.HcC = ((cwv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 7: 
          localbpc.HcD = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(72503);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new iu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((iu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpc.HcE = ((iu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72503);
        return 0;
      }
      AppMethodBeat.o(72503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpc
 * JD-Core Version:    0.7.0.1
 */