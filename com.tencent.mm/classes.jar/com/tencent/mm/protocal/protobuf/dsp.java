package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dsp
  extends com.tencent.mm.bw.a
{
  public String KZj;
  public String MUS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117919);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KZj != null) {
        paramVarArgs.e(1, this.KZj);
      }
      if (this.MUS != null) {
        paramVarArgs.e(2, this.MUS);
      }
      AppMethodBeat.o(117919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KZj == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.KZj) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MUS != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MUS);
      }
      AppMethodBeat.o(117919);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117919);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dsp localdsp = (dsp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117919);
          return -1;
        case 1: 
          localdsp.KZj = locala.UbS.readString();
          AppMethodBeat.o(117919);
          return 0;
        }
        localdsp.MUS = locala.UbS.readString();
        AppMethodBeat.o(117919);
        return 0;
      }
      AppMethodBeat.o(117919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsp
 * JD-Core Version:    0.7.0.1
 */