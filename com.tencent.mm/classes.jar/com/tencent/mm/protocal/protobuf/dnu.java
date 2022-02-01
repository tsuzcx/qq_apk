package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dnu
  extends cwj
{
  public LinkedList<dnw> HUT;
  public int HUU;
  public int HUV;
  public int HUW;
  
  public dnu()
  {
    AppMethodBeat.i(124567);
    this.HUT = new LinkedList();
    AppMethodBeat.o(124567);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124568);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124568);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.HUT);
      paramVarArgs.aS(3, this.HUU);
      paramVarArgs.aS(4, this.HUV);
      paramVarArgs.aS(5, this.HUW);
      AppMethodBeat.o(124568);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label638;
      }
    }
    label638:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.HUT);
      int j = f.a.a.b.b.a.bz(3, this.HUU);
      int k = f.a.a.b.b.a.bz(4, this.HUV);
      int m = f.a.a.b.b.a.bz(5, this.HUW);
      AppMethodBeat.o(124568);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HUT.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124568);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124568);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dnu localdnu = (dnu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124568);
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
            localdnu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124568);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnu.HUT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124568);
          return 0;
        case 3: 
          localdnu.HUU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124568);
          return 0;
        case 4: 
          localdnu.HUV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124568);
          return 0;
        }
        localdnu.HUW = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(124568);
        return 0;
      }
      AppMethodBeat.o(124568);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnu
 * JD-Core Version:    0.7.0.1
 */