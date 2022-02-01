package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqp
  extends com.tencent.mm.bw.a
{
  public String link;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168952);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.link != null) {
        paramVarArgs.e(1, this.link);
      }
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      AppMethodBeat.o(168952);
      return 0;
    }
    if (paramInt == 1) {
      if (this.link == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.link) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.title);
      }
      AppMethodBeat.o(168952);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168952);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aqp localaqp = (aqp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(168952);
          return -1;
        case 1: 
          localaqp.link = locala.UbS.readString();
          AppMethodBeat.o(168952);
          return 0;
        }
        localaqp.title = locala.UbS.readString();
        AppMethodBeat.o(168952);
        return 0;
      }
      AppMethodBeat.o(168952);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqp
 * JD-Core Version:    0.7.0.1
 */