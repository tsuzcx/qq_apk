package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class blm
  extends com.tencent.mm.bv.a
{
  public String title;
  public String xAi;
  public String xAj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56900);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.xAi != null) {
        paramVarArgs.e(2, this.xAi);
      }
      if (this.xAj != null) {
        paramVarArgs.e(3, this.xAj);
      }
      AppMethodBeat.o(56900);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label334;
      }
    }
    label334:
    for (int i = e.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xAi != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xAi);
      }
      i = paramInt;
      if (this.xAj != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xAj);
      }
      AppMethodBeat.o(56900);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56900);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        blm localblm = (blm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56900);
          return -1;
        case 1: 
          localblm.title = locala.CLY.readString();
          AppMethodBeat.o(56900);
          return 0;
        case 2: 
          localblm.xAi = locala.CLY.readString();
          AppMethodBeat.o(56900);
          return 0;
        }
        localblm.xAj = locala.CLY.readString();
        AppMethodBeat.o(56900);
        return 0;
      }
      AppMethodBeat.o(56900);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blm
 * JD-Core Version:    0.7.0.1
 */