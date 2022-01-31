package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cjv
  extends com.tencent.mm.bv.a
{
  public int eTj;
  public int eTk;
  public String text;
  public int textColor;
  public cqz xpW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(2533);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.text == null)
      {
        paramVarArgs = new b("Not all required fields were included: text");
        AppMethodBeat.o(2533);
        throw paramVarArgs;
      }
      if (this.xpW == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(2533);
        throw paramVarArgs;
      }
      if (this.text != null) {
        paramVarArgs.e(1, this.text);
      }
      paramVarArgs.aO(2, this.textColor);
      paramVarArgs.aO(3, this.eTj);
      if (this.xpW != null)
      {
        paramVarArgs.iQ(4, this.xpW.computeSize());
        this.xpW.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.eTk);
      AppMethodBeat.o(2533);
      return 0;
    }
    if (paramInt == 1) {
      if (this.text == null) {
        break label613;
      }
    }
    label613:
    for (paramInt = e.a.a.b.b.a.f(1, this.text) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.textColor) + e.a.a.b.b.a.bl(3, this.eTj);
      paramInt = i;
      if (this.xpW != null) {
        paramInt = i + e.a.a.a.iP(4, this.xpW.computeSize());
      }
      i = e.a.a.b.b.a.bl(5, this.eTk);
      AppMethodBeat.o(2533);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.text == null)
        {
          paramVarArgs = new b("Not all required fields were included: text");
          AppMethodBeat.o(2533);
          throw paramVarArgs;
        }
        if (this.xpW == null)
        {
          paramVarArgs = new b("Not all required fields were included: matrix");
          AppMethodBeat.o(2533);
          throw paramVarArgs;
        }
        AppMethodBeat.o(2533);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cjv localcjv = (cjv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(2533);
          return -1;
        case 1: 
          localcjv.text = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(2533);
          return 0;
        case 2: 
          localcjv.textColor = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(2533);
          return 0;
        case 3: 
          localcjv.eTj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(2533);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cqz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcjv.xpW = ((cqz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(2533);
          return 0;
        }
        localcjv.eTk = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(2533);
        return 0;
      }
      AppMethodBeat.o(2533);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjv
 * JD-Core Version:    0.7.0.1
 */