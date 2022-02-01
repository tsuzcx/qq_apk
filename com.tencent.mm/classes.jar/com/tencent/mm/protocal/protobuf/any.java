package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class any
  extends com.tencent.mm.bw.a
{
  public boolean LzD;
  public String dQx;
  public String id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152991);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.e(1, this.id);
      }
      if (this.dQx != null) {
        paramVarArgs.e(2, this.dQx);
      }
      paramVarArgs.cc(3, this.LzD);
      AppMethodBeat.o(152991);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dQx != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.dQx);
      }
      paramInt = g.a.a.b.b.a.fS(3);
      AppMethodBeat.o(152991);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152991);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        any localany = (any)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152991);
          return -1;
        case 1: 
          localany.id = locala.UbS.readString();
          AppMethodBeat.o(152991);
          return 0;
        case 2: 
          localany.dQx = locala.UbS.readString();
          AppMethodBeat.o(152991);
          return 0;
        }
        localany.LzD = locala.UbS.yZ();
        AppMethodBeat.o(152991);
        return 0;
      }
      AppMethodBeat.o(152991);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.any
 * JD-Core Version:    0.7.0.1
 */