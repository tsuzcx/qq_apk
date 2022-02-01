package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hg
  extends com.tencent.mm.bw.a
{
  public String name;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123548);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.d(1, this.name);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      AppMethodBeat.o(123548);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.name) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      AppMethodBeat.o(123548);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123548);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        hg localhg = (hg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123548);
          return -1;
        case 1: 
          localhg.name = locala.OmT.readString();
          AppMethodBeat.o(123548);
          return 0;
        }
        localhg.url = locala.OmT.readString();
        AppMethodBeat.o(123548);
        return 0;
      }
      AppMethodBeat.o(123548);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hg
 * JD-Core Version:    0.7.0.1
 */