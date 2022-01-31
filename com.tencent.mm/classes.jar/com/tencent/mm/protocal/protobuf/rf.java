package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.b.f;
import e.a.a.b;
import java.util.LinkedList;

public final class rf
  extends bvk
{
  public int op;
  public long wJv;
  public f wJw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(112419);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(112419);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.op);
      paramVarArgs.am(3, this.wJv);
      if (this.wJw != null)
      {
        paramVarArgs.iQ(4, this.wJw.computeSize());
        this.wJw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(112419);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.op) + e.a.a.b.b.a.p(3, this.wJv);
      paramInt = i;
      if (this.wJw != null) {
        paramInt = i + e.a.a.a.iP(4, this.wJw.computeSize());
      }
      AppMethodBeat.o(112419);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(112419);
          throw paramVarArgs;
        }
        AppMethodBeat.o(112419);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        rf localrf = (rf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(112419);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localrf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(112419);
          return 0;
        case 2: 
          localrf.op = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(112419);
          return 0;
        case 3: 
          localrf.wJv = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(112419);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localrf.wJw = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(112419);
        return 0;
      }
      AppMethodBeat.o(112419);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rf
 * JD-Core Version:    0.7.0.1
 */