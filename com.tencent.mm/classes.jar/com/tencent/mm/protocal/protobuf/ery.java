package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ery
  extends com.tencent.mm.cd.a
{
  public String Soo;
  public String Sop;
  public String jump_url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250560);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Soo != null) {
        paramVarArgs.f(1, this.Soo);
      }
      if (this.Sop != null) {
        paramVarArgs.f(2, this.Sop);
      }
      if (this.jump_url != null) {
        paramVarArgs.f(3, this.jump_url);
      }
      AppMethodBeat.o(250560);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Soo == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.Soo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Sop != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Sop);
      }
      i = paramInt;
      if (this.jump_url != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.jump_url);
      }
      AppMethodBeat.o(250560);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(250560);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ery localery = (ery)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(250560);
          return -1;
        case 1: 
          localery.Soo = locala.abFh.readString();
          AppMethodBeat.o(250560);
          return 0;
        case 2: 
          localery.Sop = locala.abFh.readString();
          AppMethodBeat.o(250560);
          return 0;
        }
        localery.jump_url = locala.abFh.readString();
        AppMethodBeat.o(250560);
        return 0;
      }
      AppMethodBeat.o(250560);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ery
 * JD-Core Version:    0.7.0.1
 */