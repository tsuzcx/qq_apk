package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnw
  extends com.tencent.mm.bv.a
{
  public String cyA;
  public String url;
  public String xCf;
  public int xCg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(852);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cyA != null) {
        paramVarArgs.e(1, this.cyA);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.xCf != null) {
        paramVarArgs.e(3, this.xCf);
      }
      paramVarArgs.aO(4, this.xCg);
      AppMethodBeat.o(852);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cyA == null) {
        break label388;
      }
    }
    label388:
    for (int i = e.a.a.b.b.a.f(1, this.cyA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.xCf != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xCf);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.xCg);
      AppMethodBeat.o(852);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(852);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bnw localbnw = (bnw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(852);
          return -1;
        case 1: 
          localbnw.cyA = locala.CLY.readString();
          AppMethodBeat.o(852);
          return 0;
        case 2: 
          localbnw.url = locala.CLY.readString();
          AppMethodBeat.o(852);
          return 0;
        case 3: 
          localbnw.xCf = locala.CLY.readString();
          AppMethodBeat.o(852);
          return 0;
        }
        localbnw.xCg = locala.CLY.sl();
        AppMethodBeat.o(852);
        return 0;
      }
      AppMethodBeat.o(852);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnw
 * JD-Core Version:    0.7.0.1
 */