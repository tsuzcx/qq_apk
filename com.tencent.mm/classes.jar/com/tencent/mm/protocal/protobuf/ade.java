package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ade
  extends com.tencent.mm.bw.a
{
  public String id;
  public long timestamp;
  public int type;
  public boolean vtY = true;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220685);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id == null)
      {
        paramVarArgs = new b("Not all required fields were included: id");
        AppMethodBeat.o(220685);
        throw paramVarArgs;
      }
      if (this.id != null) {
        paramVarArgs.e(1, this.id);
      }
      paramVarArgs.bb(2, this.timestamp);
      paramVarArgs.aM(3, this.type);
      paramVarArgs.cc(4, this.vtY);
      AppMethodBeat.o(220685);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = g.a.a.b.b.a.f(1, this.id) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.r(2, this.timestamp);
      int j = g.a.a.b.b.a.bu(3, this.type);
      int k = g.a.a.b.b.a.fS(4);
      AppMethodBeat.o(220685);
      return paramInt + i + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.id == null)
        {
          paramVarArgs = new b("Not all required fields were included: id");
          AppMethodBeat.o(220685);
          throw paramVarArgs;
        }
        AppMethodBeat.o(220685);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ade localade = (ade)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(220685);
          return -1;
        case 1: 
          localade.id = locala.UbS.readString();
          AppMethodBeat.o(220685);
          return 0;
        case 2: 
          localade.timestamp = locala.UbS.zl();
          AppMethodBeat.o(220685);
          return 0;
        case 3: 
          localade.type = locala.UbS.zi();
          AppMethodBeat.o(220685);
          return 0;
        }
        localade.vtY = locala.UbS.yZ();
        AppMethodBeat.o(220685);
        return 0;
      }
      AppMethodBeat.o(220685);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ade
 * JD-Core Version:    0.7.0.1
 */