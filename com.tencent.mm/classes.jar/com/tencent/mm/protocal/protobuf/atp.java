package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class atp
  extends com.tencent.mm.bw.a
{
  public String GKx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152994);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GKx != null) {
        paramVarArgs.d(1, this.GKx);
      }
      AppMethodBeat.o(152994);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GKx == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.GKx) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(152994);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152994);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        atp localatp = (atp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152994);
          return -1;
        }
        localatp.GKx = locala.OmT.readString();
        AppMethodBeat.o(152994);
        return 0;
      }
      AppMethodBeat.o(152994);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atp
 * JD-Core Version:    0.7.0.1
 */