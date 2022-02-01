package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bvj
  extends com.tencent.mm.bw.a
{
  public b Hid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215579);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hid != null) {
        paramVarArgs.c(1, this.Hid);
      }
      AppMethodBeat.o(215579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hid == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.b(1, this.Hid) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(215579);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(215579);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bvj localbvj = (bvj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(215579);
          return -1;
        }
        localbvj.Hid = locala.OmT.gCk();
        AppMethodBeat.o(215579);
        return 0;
      }
      AppMethodBeat.o(215579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvj
 * JD-Core Version:    0.7.0.1
 */