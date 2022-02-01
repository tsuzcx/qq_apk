package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fbi
  extends com.tencent.mm.bw.a
{
  public fbf NxD;
  public String jfi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110859);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jfi == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(110859);
        throw paramVarArgs;
      }
      if (this.NxD == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgConfig");
        AppMethodBeat.o(110859);
        throw paramVarArgs;
      }
      if (this.jfi != null) {
        paramVarArgs.e(1, this.jfi);
      }
      if (this.NxD != null)
      {
        paramVarArgs.ni(2, this.NxD.computeSize());
        this.NxD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110859);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jfi == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = g.a.a.b.b.a.f(1, this.jfi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.NxD != null) {
        i = paramInt + g.a.a.a.nh(2, this.NxD.computeSize());
      }
      AppMethodBeat.o(110859);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.jfi == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(110859);
          throw paramVarArgs;
        }
        if (this.NxD == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fbi localfbi = (fbi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110859);
          return -1;
        case 1: 
          localfbi.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(110859);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fbf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((fbf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfbi.NxD = ((fbf)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbi
 * JD-Core Version:    0.7.0.1
 */