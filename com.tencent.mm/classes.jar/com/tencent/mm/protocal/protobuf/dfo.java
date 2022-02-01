package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfo
  extends com.tencent.mm.cd.a
{
  public String mye;
  public String topic;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152646);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.mye != null) {
        paramVarArgs.f(1, this.mye);
      }
      if (this.topic != null) {
        paramVarArgs.f(2, this.topic);
      }
      AppMethodBeat.o(152646);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mye == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.mye) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.topic != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.topic);
      }
      AppMethodBeat.o(152646);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152646);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dfo localdfo = (dfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152646);
          return -1;
        case 1: 
          localdfo.mye = locala.abFh.readString();
          AppMethodBeat.o(152646);
          return 0;
        }
        localdfo.topic = locala.abFh.readString();
        AppMethodBeat.o(152646);
        return 0;
      }
      AppMethodBeat.o(152646);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfo
 * JD-Core Version:    0.7.0.1
 */