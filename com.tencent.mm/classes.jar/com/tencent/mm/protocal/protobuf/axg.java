package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class axg
  extends bvk
{
  public int csV;
  public int xmD;
  public int xmE;
  public axe xmu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96251);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(96251);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xmu != null)
      {
        paramVarArgs.iQ(2, this.xmu.computeSize());
        this.xmu.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.csV);
      paramVarArgs.aO(4, this.xmD);
      paramVarArgs.aO(5, this.xmE);
      AppMethodBeat.o(96251);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xmu != null) {
        i = paramInt + e.a.a.a.iP(2, this.xmu.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(3, this.csV);
      int j = e.a.a.b.b.a.bl(4, this.xmD);
      int k = e.a.a.b.b.a.bl(5, this.xmE);
      AppMethodBeat.o(96251);
      return i + paramInt + j + k;
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
          AppMethodBeat.o(96251);
          throw paramVarArgs;
        }
        AppMethodBeat.o(96251);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        axg localaxg = (axg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96251);
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
            localaxg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96251);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axe();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axe)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaxg.xmu = ((axe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96251);
          return 0;
        case 3: 
          localaxg.csV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96251);
          return 0;
        case 4: 
          localaxg.xmD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96251);
          return 0;
        }
        localaxg.xmE = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(96251);
        return 0;
      }
      AppMethodBeat.o(96251);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axg
 * JD-Core Version:    0.7.0.1
 */