package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hm
  extends com.tencent.mm.cd.a
{
  public String title;
  public String urZ;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123552);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.f(1, this.wording);
      }
      if (this.urZ != null) {
        paramVarArgs.f(2, this.urZ);
      }
      if (this.title != null) {
        paramVarArgs.f(3, this.title);
      }
      AppMethodBeat.o(123552);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.wording) + 0;; i = 0)
    {
      paramInt = i;
      if (this.urZ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.urZ);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.title);
      }
      AppMethodBeat.o(123552);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123552);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        hm localhm = (hm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123552);
          return -1;
        case 1: 
          localhm.wording = locala.abFh.readString();
          AppMethodBeat.o(123552);
          return 0;
        case 2: 
          localhm.urZ = locala.abFh.readString();
          AppMethodBeat.o(123552);
          return 0;
        }
        localhm.title = locala.abFh.readString();
        AppMethodBeat.o(123552);
        return 0;
      }
      AppMethodBeat.o(123552);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hm
 * JD-Core Version:    0.7.0.1
 */