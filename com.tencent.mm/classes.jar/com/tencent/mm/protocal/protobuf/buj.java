package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class buj
  extends cwj
{
  public int GQu;
  public LinkedList<bue> GQv;
  public int HhH;
  public int HhI;
  public int HhJ;
  public int zyQ;
  
  public buj()
  {
    AppMethodBeat.i(89927);
    this.GQv = new LinkedList();
    AppMethodBeat.o(89927);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89928);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(89928);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GQu);
      paramVarArgs.e(3, 8, this.GQv);
      paramVarArgs.aS(4, this.zyQ);
      paramVarArgs.aS(5, this.HhH);
      paramVarArgs.aS(6, this.HhI);
      paramVarArgs.aS(7, this.HhJ);
      AppMethodBeat.o(89928);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label734;
      }
    }
    label734:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GQu);
      int j = f.a.a.a.c(3, 8, this.GQv);
      int k = f.a.a.b.b.a.bz(4, this.zyQ);
      int m = f.a.a.b.b.a.bz(5, this.HhH);
      int n = f.a.a.b.b.a.bz(6, this.HhI);
      int i1 = f.a.a.b.b.a.bz(7, this.HhJ);
      AppMethodBeat.o(89928);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GQv.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(89928);
          throw paramVarArgs;
        }
        AppMethodBeat.o(89928);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        buj localbuj = (buj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89928);
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
            localbuj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89928);
          return 0;
        case 2: 
          localbuj.GQu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(89928);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bue();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bue)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbuj.GQv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89928);
          return 0;
        case 4: 
          localbuj.zyQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(89928);
          return 0;
        case 5: 
          localbuj.HhH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(89928);
          return 0;
        case 6: 
          localbuj.HhI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(89928);
          return 0;
        }
        localbuj.HhJ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(89928);
        return 0;
      }
      AppMethodBeat.o(89928);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buj
 * JD-Core Version:    0.7.0.1
 */