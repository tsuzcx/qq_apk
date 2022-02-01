package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class abl
  extends com.tencent.mm.bw.a
{
  public String Lmp;
  public String yWF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32168);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lmp != null) {
        paramVarArgs.e(1, this.Lmp);
      }
      if (this.yWF != null) {
        paramVarArgs.e(2, this.yWF);
      }
      AppMethodBeat.o(32168);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lmp == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = g.a.a.b.b.a.f(1, this.Lmp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.yWF != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.yWF);
      }
      AppMethodBeat.o(32168);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32168);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        abl localabl = (abl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32168);
          return -1;
        case 1: 
          localabl.Lmp = locala.UbS.readString();
          AppMethodBeat.o(32168);
          return 0;
        }
        localabl.yWF = locala.UbS.readString();
        AppMethodBeat.o(32168);
        return 0;
      }
      AppMethodBeat.o(32168);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abl
 * JD-Core Version:    0.7.0.1
 */