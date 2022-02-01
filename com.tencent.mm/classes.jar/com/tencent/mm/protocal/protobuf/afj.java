package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class afj
  extends com.tencent.mm.bw.a
{
  public String GvO;
  public String desc;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91437);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.GvO != null) {
        paramVarArgs.d(3, this.GvO);
      }
      AppMethodBeat.o(91437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.GvO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GvO);
      }
      AppMethodBeat.o(91437);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91437);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        afj localafj = (afj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91437);
          return -1;
        case 1: 
          localafj.title = locala.OmT.readString();
          AppMethodBeat.o(91437);
          return 0;
        case 2: 
          localafj.desc = locala.OmT.readString();
          AppMethodBeat.o(91437);
          return 0;
        }
        localafj.GvO = locala.OmT.readString();
        AppMethodBeat.o(91437);
        return 0;
      }
      AppMethodBeat.o(91437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afj
 * JD-Core Version:    0.7.0.1
 */