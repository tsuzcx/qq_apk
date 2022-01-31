package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cyn
  extends bvk
{
  public String wAa;
  public int wzS;
  public int xHS;
  public int xpM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124388);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wAa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Json");
        AppMethodBeat.o(124388);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xpM);
      paramVarArgs.aO(3, this.wzS);
      if (this.wAa != null) {
        paramVarArgs.e(4, this.wAa);
      }
      paramVarArgs.aO(5, this.xHS);
      AppMethodBeat.o(124388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xpM) + e.a.a.b.b.a.bl(3, this.wzS);
      paramInt = i;
      if (this.wAa != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wAa);
      }
      i = e.a.a.b.b.a.bl(5, this.xHS);
      AppMethodBeat.o(124388);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wAa == null)
        {
          paramVarArgs = new b("Not all required fields were included: Json");
          AppMethodBeat.o(124388);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124388);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cyn localcyn = (cyn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124388);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcyn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124388);
          return 0;
        case 2: 
          localcyn.xpM = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(124388);
          return 0;
        case 3: 
          localcyn.wzS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(124388);
          return 0;
        case 4: 
          localcyn.wAa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124388);
          return 0;
        }
        localcyn.xHS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124388);
        return 0;
      }
      AppMethodBeat.o(124388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyn
 * JD-Core Version:    0.7.0.1
 */