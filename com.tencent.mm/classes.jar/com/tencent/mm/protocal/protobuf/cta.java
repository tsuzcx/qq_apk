package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cta
  extends com.tencent.mm.bw.a
{
  public String seq;
  public String token;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(222857);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.seq != null) {
        paramVarArgs.e(1, this.seq);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.token != null) {
        paramVarArgs.e(3, this.token);
      }
      AppMethodBeat.o(222857);
      return 0;
    }
    if (paramInt == 1) {
      if (this.seq == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.seq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.token);
      }
      AppMethodBeat.o(222857);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(222857);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cta localcta = (cta)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(222857);
          return -1;
        case 1: 
          localcta.seq = locala.UbS.readString();
          AppMethodBeat.o(222857);
          return 0;
        case 2: 
          localcta.url = locala.UbS.readString();
          AppMethodBeat.o(222857);
          return 0;
        }
        localcta.token = locala.UbS.readString();
        AppMethodBeat.o(222857);
        return 0;
      }
      AppMethodBeat.o(222857);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cta
 * JD-Core Version:    0.7.0.1
 */