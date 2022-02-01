package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dha
  extends cwj
{
  public int HNU;
  public LinkedList<Integer> HNW;
  public int HNX;
  public int HNY;
  public LinkedList<die> HNZ;
  
  public dha()
  {
    AppMethodBeat.i(125800);
    this.HNW = new LinkedList();
    this.HNZ = new LinkedList();
    AppMethodBeat.o(125800);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125801);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125801);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HNU);
      paramVarArgs.f(3, 2, this.HNW);
      paramVarArgs.aS(4, this.HNX);
      paramVarArgs.aS(5, this.HNY);
      paramVarArgs.e(6, 8, this.HNZ);
      AppMethodBeat.o(125801);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label713;
      }
    }
    label713:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.HNU);
      int j = f.a.a.a.d(3, 2, this.HNW);
      int k = f.a.a.b.b.a.bz(4, this.HNX);
      int m = f.a.a.b.b.a.bz(5, this.HNY);
      int n = f.a.a.a.c(6, 8, this.HNZ);
      AppMethodBeat.o(125801);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HNW.clear();
        this.HNZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125801);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125801);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dha localdha = (dha)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125801);
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
            localdha.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125801);
          return 0;
        case 2: 
          localdha.HNU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125801);
          return 0;
        case 3: 
          localdha.HNW = new f.a.a.a.a(((f.a.a.a.a)localObject1).OmT.gCk().zr, unknownTagHandler).OmT.gCi();
          AppMethodBeat.o(125801);
          return 0;
        case 4: 
          localdha.HNX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125801);
          return 0;
        case 5: 
          localdha.HNY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125801);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new die();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((die)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdha.HNZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125801);
        return 0;
      }
      AppMethodBeat.o(125801);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dha
 * JD-Core Version:    0.7.0.1
 */