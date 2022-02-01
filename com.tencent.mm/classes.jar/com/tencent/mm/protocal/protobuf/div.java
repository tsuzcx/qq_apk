package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class div
  extends com.tencent.mm.bw.a
{
  public String MNa;
  public String MNb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133191);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MNa != null) {
        paramVarArgs.e(1, this.MNa);
      }
      if (this.MNb != null) {
        paramVarArgs.e(2, this.MNb);
      }
      AppMethodBeat.o(133191);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MNa == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.MNa) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MNb != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MNb);
      }
      AppMethodBeat.o(133191);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(133191);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        div localdiv = (div)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133191);
          return -1;
        case 1: 
          localdiv.MNa = locala.UbS.readString();
          AppMethodBeat.o(133191);
          return 0;
        }
        localdiv.MNb = locala.UbS.readString();
        AppMethodBeat.o(133191);
        return 0;
      }
      AppMethodBeat.o(133191);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.div
 * JD-Core Version:    0.7.0.1
 */