package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bbr
  extends cwj
{
  public LinkedList<el> FQQ;
  public int GRB;
  public int GRC;
  public LinkedList<Integer> GRD;
  public LinkedList<ahz> GRE;
  public int GRG;
  
  public bbr()
  {
    AppMethodBeat.i(122505);
    this.GRD = new LinkedList();
    this.GRE = new LinkedList();
    this.FQQ = new LinkedList();
    AppMethodBeat.o(122505);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(122506);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GRB);
      paramVarArgs.aS(3, this.GRC);
      paramVarArgs.e(4, 2, this.GRD);
      paramVarArgs.e(5, 8, this.GRE);
      paramVarArgs.aS(6, this.GRG);
      paramVarArgs.e(7, 8, this.FQQ);
      AppMethodBeat.o(122506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label845;
      }
    }
    label845:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GRB);
      int j = f.a.a.b.b.a.bz(3, this.GRC);
      int k = f.a.a.a.c(4, 2, this.GRD);
      int m = f.a.a.a.c(5, 8, this.GRE);
      int n = f.a.a.b.b.a.bz(6, this.GRG);
      int i1 = f.a.a.a.c(7, 8, this.FQQ);
      AppMethodBeat.o(122506);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GRD.clear();
        this.GRE.clear();
        this.FQQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(122506);
          throw paramVarArgs;
        }
        AppMethodBeat.o(122506);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbr localbbr = (bbr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122506);
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
            localbbr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122506);
          return 0;
        case 2: 
          localbbr.GRB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122506);
          return 0;
        case 3: 
          localbbr.GRC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122506);
          return 0;
        case 4: 
          localbbr.GRD.add(Integer.valueOf(((f.a.a.a.a)localObject1).OmT.zc()));
          AppMethodBeat.o(122506);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbr.GRE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122506);
          return 0;
        case 6: 
          localbbr.GRG = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122506);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new el();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((el)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbbr.FQQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122506);
        return 0;
      }
      AppMethodBeat.o(122506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbr
 * JD-Core Version:    0.7.0.1
 */