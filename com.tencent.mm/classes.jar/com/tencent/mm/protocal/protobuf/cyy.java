package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyy
  extends com.tencent.mm.bv.a
{
  public String cwc;
  public int wAy;
  public String yfW;
  public String yfX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10250);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cwc != null) {
        paramVarArgs.e(1, this.cwc);
      }
      paramVarArgs.aO(2, this.wAy);
      if (this.yfW != null) {
        paramVarArgs.e(3, this.yfW);
      }
      if (this.yfX != null) {
        paramVarArgs.e(4, this.yfX);
      }
      AppMethodBeat.o(10250);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cwc == null) {
        break label388;
      }
    }
    label388:
    for (paramInt = e.a.a.b.b.a.f(1, this.cwc) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wAy);
      paramInt = i;
      if (this.yfW != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.yfW);
      }
      i = paramInt;
      if (this.yfX != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.yfX);
      }
      AppMethodBeat.o(10250);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(10250);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cyy localcyy = (cyy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(10250);
          return -1;
        case 1: 
          localcyy.cwc = locala.CLY.readString();
          AppMethodBeat.o(10250);
          return 0;
        case 2: 
          localcyy.wAy = locala.CLY.sl();
          AppMethodBeat.o(10250);
          return 0;
        case 3: 
          localcyy.yfW = locala.CLY.readString();
          AppMethodBeat.o(10250);
          return 0;
        }
        localcyy.yfX = locala.CLY.readString();
        AppMethodBeat.o(10250);
        return 0;
      }
      AppMethodBeat.o(10250);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyy
 * JD-Core Version:    0.7.0.1
 */