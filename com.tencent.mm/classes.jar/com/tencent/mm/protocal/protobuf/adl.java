package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class adl
  extends com.tencent.mm.cd.a
{
  public boolean Aaj = true;
  public String id;
  public long timestamp;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256061);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id == null)
      {
        paramVarArgs = new b("Not all required fields were included: id");
        AppMethodBeat.o(256061);
        throw paramVarArgs;
      }
      if (this.id != null) {
        paramVarArgs.f(1, this.id);
      }
      paramVarArgs.bm(2, this.timestamp);
      paramVarArgs.aY(3, this.type);
      paramVarArgs.co(4, this.Aaj);
      AppMethodBeat.o(256061);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = g.a.a.b.b.a.g(1, this.id) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.timestamp);
      int j = g.a.a.b.b.a.bM(3, this.type);
      int k = g.a.a.b.b.a.gL(4);
      AppMethodBeat.o(256061);
      return paramInt + i + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.id == null)
        {
          paramVarArgs = new b("Not all required fields were included: id");
          AppMethodBeat.o(256061);
          throw paramVarArgs;
        }
        AppMethodBeat.o(256061);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        adl localadl = (adl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(256061);
          return -1;
        case 1: 
          localadl.id = locala.abFh.readString();
          AppMethodBeat.o(256061);
          return 0;
        case 2: 
          localadl.timestamp = locala.abFh.AN();
          AppMethodBeat.o(256061);
          return 0;
        case 3: 
          localadl.type = locala.abFh.AK();
          AppMethodBeat.o(256061);
          return 0;
        }
        localadl.Aaj = locala.abFh.AB();
        AppMethodBeat.o(256061);
        return 0;
      }
      AppMethodBeat.o(256061);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adl
 * JD-Core Version:    0.7.0.1
 */