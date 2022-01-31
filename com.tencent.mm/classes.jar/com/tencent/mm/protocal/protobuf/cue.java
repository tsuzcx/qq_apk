package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cue
  extends com.tencent.mm.bv.a
{
  public String cmA;
  public String cmB;
  public long timestamp;
  public String ycW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102411);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cmA != null) {
        paramVarArgs.e(1, this.cmA);
      }
      if (this.cmB != null) {
        paramVarArgs.e(2, this.cmB);
      }
      if (this.ycW != null) {
        paramVarArgs.e(3, this.ycW);
      }
      paramVarArgs.am(4, this.timestamp);
      AppMethodBeat.o(102411);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cmA == null) {
        break label378;
      }
    }
    label378:
    for (int i = e.a.a.b.b.a.f(1, this.cmA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cmB != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.cmB);
      }
      i = paramInt;
      if (this.ycW != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ycW);
      }
      paramInt = e.a.a.b.b.a.p(4, this.timestamp);
      AppMethodBeat.o(102411);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(102411);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cue localcue = (cue)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(102411);
          return -1;
        case 1: 
          localcue.cmA = locala.CLY.readString();
          AppMethodBeat.o(102411);
          return 0;
        case 2: 
          localcue.cmB = locala.CLY.readString();
          AppMethodBeat.o(102411);
          return 0;
        case 3: 
          localcue.ycW = locala.CLY.readString();
          AppMethodBeat.o(102411);
          return 0;
        }
        localcue.timestamp = locala.CLY.sm();
        AppMethodBeat.o(102411);
        return 0;
      }
      AppMethodBeat.o(102411);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cue
 * JD-Core Version:    0.7.0.1
 */