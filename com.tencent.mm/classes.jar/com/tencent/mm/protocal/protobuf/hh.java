package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hh
  extends com.tencent.mm.bw.a
{
  public String FSa;
  public String FSb;
  public String dlT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123549);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FSa != null) {
        paramVarArgs.d(1, this.FSa);
      }
      if (this.FSb != null) {
        paramVarArgs.d(2, this.FSb);
      }
      if (this.dlT != null) {
        paramVarArgs.d(3, this.dlT);
      }
      AppMethodBeat.o(123549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FSa == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.FSa) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FSb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FSb);
      }
      i = paramInt;
      if (this.dlT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dlT);
      }
      AppMethodBeat.o(123549);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123549);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        hh localhh = (hh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123549);
          return -1;
        case 1: 
          localhh.FSa = locala.OmT.readString();
          AppMethodBeat.o(123549);
          return 0;
        case 2: 
          localhh.FSb = locala.OmT.readString();
          AppMethodBeat.o(123549);
          return 0;
        }
        localhh.dlT = locala.OmT.readString();
        AppMethodBeat.o(123549);
        return 0;
      }
      AppMethodBeat.o(123549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hh
 * JD-Core Version:    0.7.0.1
 */