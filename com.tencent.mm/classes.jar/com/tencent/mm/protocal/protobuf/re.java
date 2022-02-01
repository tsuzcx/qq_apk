package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class re
  extends com.tencent.mm.bw.a
{
  public String dEM;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32152);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      if (this.dEM != null) {
        paramVarArgs.d(3, this.dEM);
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
    for (int i = f.a.a.b.b.a.e(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.title);
      }
      i = paramInt;
      if (this.dEM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dEM);
      }
      AppMethodBeat.o(32152);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32152);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        re localre = (re)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32152);
          return -1;
        case 1: 
          localre.url = locala.OmT.readString();
          AppMethodBeat.o(32152);
          return 0;
        case 2: 
          localre.title = locala.OmT.readString();
          AppMethodBeat.o(32152);
          return 0;
        }
        localre.dEM = locala.OmT.readString();
        AppMethodBeat.o(32152);
        return 0;
      }
      AppMethodBeat.o(32152);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.re
 * JD-Core Version:    0.7.0.1
 */