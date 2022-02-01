package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bfe
  extends cwj
{
  public dnv GUg;
  public String GUh;
  public boolean GUi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176146);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(176146);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GUg != null)
      {
        paramVarArgs.lJ(2, this.GUg.computeSize());
        this.GUg.writeFields(paramVarArgs);
      }
      if (this.GUh != null) {
        paramVarArgs.d(3, this.GUh);
      }
      paramVarArgs.bC(4, this.GUi);
      AppMethodBeat.o(176146);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GUg != null) {
        paramInt = i + f.a.a.a.lI(2, this.GUg.computeSize());
      }
      i = paramInt;
      if (this.GUh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GUh);
      }
      paramInt = f.a.a.b.b.a.amF(4);
      AppMethodBeat.o(176146);
      return i + paramInt;
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
          AppMethodBeat.o(176146);
          throw paramVarArgs;
        }
        AppMethodBeat.o(176146);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bfe localbfe = (bfe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(176146);
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
            localbfe.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(176146);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfe.GUg = ((dnv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(176146);
          return 0;
        case 3: 
          localbfe.GUh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(176146);
          return 0;
        }
        localbfe.GUi = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(176146);
        return 0;
      }
      AppMethodBeat.o(176146);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfe
 * JD-Core Version:    0.7.0.1
 */