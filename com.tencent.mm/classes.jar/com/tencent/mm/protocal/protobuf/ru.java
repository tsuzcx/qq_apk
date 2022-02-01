package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ru
  extends com.tencent.mm.bw.a
{
  public String Ggo;
  public String dEJ;
  public String dFs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72426);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ggo != null) {
        paramVarArgs.d(1, this.Ggo);
      }
      if (this.dEJ != null) {
        paramVarArgs.d(2, this.dEJ);
      }
      if (this.dFs != null) {
        paramVarArgs.d(3, this.dFs);
      }
      AppMethodBeat.o(72426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ggo == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.Ggo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dEJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dEJ);
      }
      i = paramInt;
      if (this.dFs != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dFs);
      }
      AppMethodBeat.o(72426);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72426);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ru localru = (ru)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72426);
          return -1;
        case 1: 
          localru.Ggo = locala.OmT.readString();
          AppMethodBeat.o(72426);
          return 0;
        case 2: 
          localru.dEJ = locala.OmT.readString();
          AppMethodBeat.o(72426);
          return 0;
        }
        localru.dFs = locala.OmT.readString();
        AppMethodBeat.o(72426);
        return 0;
      }
      AppMethodBeat.o(72426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ru
 * JD-Core Version:    0.7.0.1
 */