package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class egs
  extends com.tencent.mm.bw.a
{
  public egp IkC;
  public String ikm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110859);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ikm == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(110859);
        throw paramVarArgs;
      }
      if (this.IkC == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgConfig");
        AppMethodBeat.o(110859);
        throw paramVarArgs;
      }
      if (this.ikm != null) {
        paramVarArgs.d(1, this.ikm);
      }
      if (this.IkC != null)
      {
        paramVarArgs.lJ(2, this.IkC.computeSize());
        this.IkC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110859);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ikm == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.b.b.a.e(1, this.ikm) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IkC != null) {
        i = paramInt + f.a.a.a.lI(2, this.IkC.computeSize());
      }
      AppMethodBeat.o(110859);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.ikm == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(110859);
          throw paramVarArgs;
        }
        if (this.IkC == null)
        {
          paramVarArgs = new b("Not all required fields were included: PkgConfig");
          AppMethodBeat.o(110859);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110859);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        egs localegs = (egs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110859);
          return -1;
        case 1: 
          localegs.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(110859);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new egp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((egp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localegs.IkC = ((egp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110859);
        return 0;
      }
      AppMethodBeat.o(110859);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egs
 * JD-Core Version:    0.7.0.1
 */