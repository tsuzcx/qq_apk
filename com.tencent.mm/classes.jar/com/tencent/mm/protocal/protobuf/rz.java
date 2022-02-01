package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rz
  extends com.tencent.mm.cd.a
{
  public String icon;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32152);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.f(1, this.url);
      }
      if (this.title != null) {
        paramVarArgs.f(2, this.title);
      }
      if (this.icon != null) {
        paramVarArgs.f(3, this.icon);
      }
      AppMethodBeat.o(32152);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label343;
      }
    }
    label343:
    for (int i = g.a.a.b.b.a.g(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.title);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.icon);
      }
      AppMethodBeat.o(32152);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32152);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        rz localrz = (rz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32152);
          return -1;
        case 1: 
          localrz.url = locala.abFh.readString();
          AppMethodBeat.o(32152);
          return 0;
        case 2: 
          localrz.title = locala.abFh.readString();
          AppMethodBeat.o(32152);
          return 0;
        }
        localrz.icon = locala.abFh.readString();
        AppMethodBeat.o(32152);
        return 0;
      }
      AppMethodBeat.o(32152);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rz
 * JD-Core Version:    0.7.0.1
 */