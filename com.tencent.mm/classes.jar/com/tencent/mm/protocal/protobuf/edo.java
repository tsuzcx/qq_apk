package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edo
  extends com.tencent.mm.bw.a
{
  public String IiA;
  public String urq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121117);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.urq != null) {
        paramVarArgs.d(1, this.urq);
      }
      if (this.IiA != null) {
        paramVarArgs.d(2, this.IiA);
      }
      AppMethodBeat.o(121117);
      return 0;
    }
    if (paramInt == 1) {
      if (this.urq == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.urq) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IiA != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.IiA);
      }
      AppMethodBeat.o(121117);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(121117);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        edo localedo = (edo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(121117);
          return -1;
        case 1: 
          localedo.urq = locala.OmT.readString();
          AppMethodBeat.o(121117);
          return 0;
        }
        localedo.IiA = locala.OmT.readString();
        AppMethodBeat.o(121117);
        return 0;
      }
      AppMethodBeat.o(121117);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edo
 * JD-Core Version:    0.7.0.1
 */