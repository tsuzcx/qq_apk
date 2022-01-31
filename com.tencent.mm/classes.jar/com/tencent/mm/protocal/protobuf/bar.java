package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bar
  extends com.tencent.mm.bv.a
{
  public String eSL;
  public String eSM;
  public cqz xpW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(2532);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.eSL == null)
      {
        paramVarArgs = new b("Not all required fields were included: cityName");
        AppMethodBeat.o(2532);
        throw paramVarArgs;
      }
      if (this.eSM == null)
      {
        paramVarArgs = new b("Not all required fields were included: poiName");
        AppMethodBeat.o(2532);
        throw paramVarArgs;
      }
      if (this.xpW == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(2532);
        throw paramVarArgs;
      }
      if (this.eSL != null) {
        paramVarArgs.e(1, this.eSL);
      }
      if (this.eSM != null) {
        paramVarArgs.e(2, this.eSM);
      }
      if (this.xpW != null)
      {
        paramVarArgs.iQ(4, this.xpW.computeSize());
        this.xpW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(2532);
      return 0;
    }
    if (paramInt == 1) {
      if (this.eSL == null) {
        break label595;
      }
    }
    label595:
    for (int i = e.a.a.b.b.a.f(1, this.eSL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.eSM != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.eSM);
      }
      i = paramInt;
      if (this.xpW != null) {
        i = paramInt + e.a.a.a.iP(4, this.xpW.computeSize());
      }
      AppMethodBeat.o(2532);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.eSL == null)
        {
          paramVarArgs = new b("Not all required fields were included: cityName");
          AppMethodBeat.o(2532);
          throw paramVarArgs;
        }
        if (this.eSM == null)
        {
          paramVarArgs = new b("Not all required fields were included: poiName");
          AppMethodBeat.o(2532);
          throw paramVarArgs;
        }
        if (this.xpW == null)
        {
          paramVarArgs = new b("Not all required fields were included: matrix");
          AppMethodBeat.o(2532);
          throw paramVarArgs;
        }
        AppMethodBeat.o(2532);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bar localbar = (bar)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(2532);
          return -1;
        case 1: 
          localbar.eSL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(2532);
          return 0;
        case 2: 
          localbar.eSM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(2532);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cqz();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cqz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbar.xpW = ((cqz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(2532);
        return 0;
      }
      AppMethodBeat.o(2532);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bar
 * JD-Core Version:    0.7.0.1
 */