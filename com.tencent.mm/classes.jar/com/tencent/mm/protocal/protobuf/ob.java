package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ob
  extends com.tencent.mm.bw.a
{
  public String iFF;
  public String key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212232);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(212232);
        throw paramVarArgs;
      }
      if (this.iFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: val");
        AppMethodBeat.o(212232);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.e(1, this.key);
      }
      if (this.iFF != null) {
        paramVarArgs.e(2, this.iFF);
      }
      AppMethodBeat.o(212232);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.b.b.a.f(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.iFF != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.iFF);
      }
      AppMethodBeat.o(212232);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(212232);
          throw paramVarArgs;
        }
        if (this.iFF == null)
        {
          paramVarArgs = new b("Not all required fields were included: val");
          AppMethodBeat.o(212232);
          throw paramVarArgs;
        }
        AppMethodBeat.o(212232);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ob localob = (ob)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212232);
          return -1;
        case 1: 
          localob.key = locala.UbS.readString();
          AppMethodBeat.o(212232);
          return 0;
        }
        localob.iFF = locala.UbS.readString();
        AppMethodBeat.o(212232);
        return 0;
      }
      AppMethodBeat.o(212232);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ob
 * JD-Core Version:    0.7.0.1
 */