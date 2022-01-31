package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aov
  extends buy
{
  public int Height;
  public String URL;
  public int Width;
  public String xeF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10184);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.URL == null)
      {
        paramVarArgs = new b("Not all required fields were included: URL");
        AppMethodBeat.o(10184);
        throw paramVarArgs;
      }
      if (this.xeF == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserAgent");
        AppMethodBeat.o(10184);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.URL != null) {
        paramVarArgs.e(2, this.URL);
      }
      if (this.xeF != null) {
        paramVarArgs.e(3, this.xeF);
      }
      paramVarArgs.aO(4, this.Width);
      paramVarArgs.aO(5, this.Height);
      AppMethodBeat.o(10184);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label633;
      }
    }
    label633:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.URL != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.URL);
      }
      i = paramInt;
      if (this.xeF != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xeF);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.Width);
      int j = e.a.a.b.b.a.bl(5, this.Height);
      AppMethodBeat.o(10184);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.URL == null)
        {
          paramVarArgs = new b("Not all required fields were included: URL");
          AppMethodBeat.o(10184);
          throw paramVarArgs;
        }
        if (this.xeF == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserAgent");
          AppMethodBeat.o(10184);
          throw paramVarArgs;
        }
        AppMethodBeat.o(10184);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aov localaov = (aov)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(10184);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaov.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10184);
          return 0;
        case 2: 
          localaov.URL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10184);
          return 0;
        case 3: 
          localaov.xeF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10184);
          return 0;
        case 4: 
          localaov.Width = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(10184);
          return 0;
        }
        localaov.Height = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(10184);
        return 0;
      }
      AppMethodBeat.o(10184);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aov
 * JD-Core Version:    0.7.0.1
 */