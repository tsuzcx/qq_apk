package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fmy
  extends com.tencent.mm.cd.a
{
  public String Tll;
  public eae Tln;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133209);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Tln == null)
      {
        paramVarArgs = new b("Not all required fields were included: VerifyBuff");
        AppMethodBeat.o(133209);
        throw paramVarArgs;
      }
      if (this.Tll != null) {
        paramVarArgs.f(1, this.Tll);
      }
      if (this.Tln != null)
      {
        paramVarArgs.oE(2, this.Tln.computeSize());
        this.Tln.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133209);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Tll == null) {
        break label396;
      }
    }
    label396:
    for (paramInt = g.a.a.b.b.a.g(1, this.Tll) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Tln != null) {
        i = paramInt + g.a.a.a.oD(2, this.Tln.computeSize());
      }
      AppMethodBeat.o(133209);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Tln == null)
        {
          paramVarArgs = new b("Not all required fields were included: VerifyBuff");
          AppMethodBeat.o(133209);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133209);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fmy localfmy = (fmy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133209);
          return -1;
        case 1: 
          localfmy.Tll = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(133209);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eae localeae = new eae();
          if ((localObject != null) && (localObject.length > 0)) {
            localeae.dd((byte[])localObject);
          }
          localfmy.Tln = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(133209);
        return 0;
      }
      AppMethodBeat.o(133209);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmy
 * JD-Core Version:    0.7.0.1
 */