package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cfz
  extends com.tencent.mm.bw.a
{
  public String key;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72511);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.key != null) {
        paramVarArgs.e(1, this.key);
      }
      if (this.value != null) {
        paramVarArgs.e(2, this.value);
      }
      AppMethodBeat.o(72511);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.value != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.value);
      }
      AppMethodBeat.o(72511);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72511);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cfz localcfz = (cfz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72511);
          return -1;
        case 1: 
          localcfz.key = locala.UbS.readString();
          AppMethodBeat.o(72511);
          return 0;
        }
        localcfz.value = locala.UbS.readString();
        AppMethodBeat.o(72511);
        return 0;
      }
      AppMethodBeat.o(72511);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfz
 * JD-Core Version:    0.7.0.1
 */