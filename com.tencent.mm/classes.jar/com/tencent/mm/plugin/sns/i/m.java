package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class m
  extends com.tencent.mm.bw.a
{
  public String name;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96164);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.name == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(96164);
        throw paramVarArgs;
      }
      if (this.name != null) {
        paramVarArgs.d(1, this.name);
      }
      paramVarArgs.aS(2, this.type);
      AppMethodBeat.o(96164);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.name) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.type);
      AppMethodBeat.o(96164);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.name == null)
        {
          paramVarArgs = new b("Not all required fields were included: name");
          AppMethodBeat.o(96164);
          throw paramVarArgs;
        }
        AppMethodBeat.o(96164);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96164);
          return -1;
        case 1: 
          localm.name = locala.OmT.readString();
          AppMethodBeat.o(96164);
          return 0;
        }
        localm.type = locala.OmT.zc();
        AppMethodBeat.o(96164);
        return 0;
      }
      AppMethodBeat.o(96164);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.m
 * JD-Core Version:    0.7.0.1
 */