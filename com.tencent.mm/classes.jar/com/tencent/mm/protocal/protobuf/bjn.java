package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bjn
  extends com.tencent.mm.bv.a
{
  public String Title;
  public String ntu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60056);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ntu != null) {
        paramVarArgs.e(1, this.ntu);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      AppMethodBeat.o(60056);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ntu == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.ntu) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.Title);
      }
      AppMethodBeat.o(60056);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(60056);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bjn localbjn = (bjn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(60056);
          return -1;
        case 1: 
          localbjn.ntu = locala.CLY.readString();
          AppMethodBeat.o(60056);
          return 0;
        }
        localbjn.Title = locala.CLY.readString();
        AppMethodBeat.o(60056);
        return 0;
      }
      AppMethodBeat.o(60056);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjn
 * JD-Core Version:    0.7.0.1
 */