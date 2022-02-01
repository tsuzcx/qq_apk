package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlx
  extends com.tencent.mm.bw.a
{
  public String Hvr;
  public String Hxp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117930);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hxp != null) {
        paramVarArgs.d(1, this.Hxp);
      }
      if (this.Hvr != null) {
        paramVarArgs.d(2, this.Hvr);
      }
      AppMethodBeat.o(117930);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hxp == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hxp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hvr != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Hvr);
      }
      AppMethodBeat.o(117930);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117930);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dlx localdlx = (dlx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117930);
          return -1;
        case 1: 
          localdlx.Hxp = locala.OmT.readString();
          AppMethodBeat.o(117930);
          return 0;
        }
        localdlx.Hvr = locala.OmT.readString();
        AppMethodBeat.o(117930);
        return 0;
      }
      AppMethodBeat.o(117930);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlx
 * JD-Core Version:    0.7.0.1
 */