package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dyz
  extends com.tencent.mm.bw.a
{
  public dyw Gfo;
  public String hOf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110859);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hOf == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(110859);
        throw paramVarArgs;
      }
      if (this.Gfo == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgConfig");
        AppMethodBeat.o(110859);
        throw paramVarArgs;
      }
      if (this.hOf != null) {
        paramVarArgs.d(1, this.hOf);
      }
      if (this.Gfo != null)
      {
        paramVarArgs.ln(2, this.Gfo.computeSize());
        this.Gfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110859);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hOf == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.b.b.a.e(1, this.hOf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gfo != null) {
        i = paramInt + f.a.a.a.lm(2, this.Gfo.computeSize());
      }
      AppMethodBeat.o(110859);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.hOf == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(110859);
          throw paramVarArgs;
        }
        if (this.Gfo == null)
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
        dyz localdyz = (dyz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110859);
          return -1;
        case 1: 
          localdyz.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(110859);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dyw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dyw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyz.Gfo = ((dyw)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyz
 * JD-Core Version:    0.7.0.1
 */