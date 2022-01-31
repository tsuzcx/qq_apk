package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class auj
  extends buy
{
  public auh wvw;
  public int xjt;
  public SKBuiltinBuffer_t xju;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28518);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wvw == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(28518);
        throw paramVarArgs;
      }
      if (this.xju == null)
      {
        paramVarArgs = new b("Not all required fields were included: AuthBuffer");
        AppMethodBeat.o(28518);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wvw != null)
      {
        paramVarArgs.iQ(2, this.wvw.computeSize());
        this.wvw.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.xjt);
      if (this.xju != null)
      {
        paramVarArgs.iQ(4, this.xju.computeSize());
        this.xju.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(28518);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label772;
      }
    }
    label772:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wvw != null) {
        i = paramInt + e.a.a.a.iP(2, this.wvw.computeSize());
      }
      i += e.a.a.b.b.a.bl(3, this.xjt);
      paramInt = i;
      if (this.xju != null) {
        paramInt = i + e.a.a.a.iP(4, this.xju.computeSize());
      }
      AppMethodBeat.o(28518);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wvw == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(28518);
          throw paramVarArgs;
        }
        if (this.xju == null)
        {
          paramVarArgs = new b("Not all required fields were included: AuthBuffer");
          AppMethodBeat.o(28518);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28518);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        auj localauj = (auj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28518);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localauj.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28518);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new auh();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((auh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localauj.wvw = ((auh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28518);
          return 0;
        case 3: 
          localauj.xjt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28518);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localauj.xju = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28518);
        return 0;
      }
      AppMethodBeat.o(28518);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auj
 * JD-Core Version:    0.7.0.1
 */