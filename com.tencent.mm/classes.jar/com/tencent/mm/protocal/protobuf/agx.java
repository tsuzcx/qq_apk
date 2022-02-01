package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agx
  extends com.tencent.mm.bw.a
{
  public String desc;
  public String ixw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72473);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.desc != null) {
        paramVarArgs.e(1, this.desc);
      }
      if (this.ixw != null) {
        paramVarArgs.e(2, this.ixw);
      }
      AppMethodBeat.o(72473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.desc == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.desc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ixw != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.ixw);
      }
      AppMethodBeat.o(72473);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72473);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        agx localagx = (agx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72473);
          return -1;
        case 1: 
          localagx.desc = locala.UbS.readString();
          AppMethodBeat.o(72473);
          return 0;
        }
        localagx.ixw = locala.UbS.readString();
        AppMethodBeat.o(72473);
        return 0;
      }
      AppMethodBeat.o(72473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agx
 * JD-Core Version:    0.7.0.1
 */