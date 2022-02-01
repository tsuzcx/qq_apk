package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class che
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String hFS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43117);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hFS != null) {
        paramVarArgs.d(1, this.hFS);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      AppMethodBeat.o(43117);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hFS == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.hFS) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Title);
      }
      AppMethodBeat.o(43117);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(43117);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        che localche = (che)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43117);
          return -1;
        case 1: 
          localche.hFS = locala.OmT.readString();
          AppMethodBeat.o(43117);
          return 0;
        }
        localche.Title = locala.OmT.readString();
        AppMethodBeat.o(43117);
        return 0;
      }
      AppMethodBeat.o(43117);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.che
 * JD-Core Version:    0.7.0.1
 */