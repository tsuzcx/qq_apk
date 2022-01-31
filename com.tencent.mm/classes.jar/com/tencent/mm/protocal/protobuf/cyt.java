package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cyt
  extends com.tencent.mm.bv.a
{
  public String wWA;
  public String wWC;
  public cys yfG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63697);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wWA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Rid");
        AppMethodBeat.o(63697);
        throw paramVarArgs;
      }
      if (this.wWC == null)
      {
        paramVarArgs = new b("Not all required fields were included: MimeType");
        AppMethodBeat.o(63697);
        throw paramVarArgs;
      }
      if (this.yfG == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadInfo");
        AppMethodBeat.o(63697);
        throw paramVarArgs;
      }
      if (this.wWA != null) {
        paramVarArgs.e(1, this.wWA);
      }
      if (this.wWC != null) {
        paramVarArgs.e(2, this.wWC);
      }
      if (this.yfG != null)
      {
        paramVarArgs.iQ(3, this.yfG.computeSize());
        this.yfG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(63697);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wWA == null) {
        break label574;
      }
    }
    label574:
    for (int i = e.a.a.b.b.a.f(1, this.wWA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wWC != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wWC);
      }
      i = paramInt;
      if (this.yfG != null) {
        i = paramInt + e.a.a.a.iP(3, this.yfG.computeSize());
      }
      AppMethodBeat.o(63697);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wWA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Rid");
          AppMethodBeat.o(63697);
          throw paramVarArgs;
        }
        if (this.wWC == null)
        {
          paramVarArgs = new b("Not all required fields were included: MimeType");
          AppMethodBeat.o(63697);
          throw paramVarArgs;
        }
        if (this.yfG == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadInfo");
          AppMethodBeat.o(63697);
          throw paramVarArgs;
        }
        AppMethodBeat.o(63697);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cyt localcyt = (cyt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(63697);
          return -1;
        case 1: 
          localcyt.wWA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(63697);
          return 0;
        case 2: 
          localcyt.wWC = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(63697);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cys();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cys)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcyt.yfG = ((cys)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(63697);
        return 0;
      }
      AppMethodBeat.o(63697);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyt
 * JD-Core Version:    0.7.0.1
 */