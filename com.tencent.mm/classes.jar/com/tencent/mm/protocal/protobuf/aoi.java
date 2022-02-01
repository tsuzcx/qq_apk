package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aoi
  extends com.tencent.mm.bw.a
{
  public String LAp;
  public String LAq;
  public String LAr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196087);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LAp != null) {
        paramVarArgs.e(1, this.LAp);
      }
      if (this.LAq != null) {
        paramVarArgs.e(2, this.LAq);
      }
      if (this.LAr != null) {
        paramVarArgs.e(3, this.LAr);
      }
      AppMethodBeat.o(196087);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LAp == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.LAp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LAq != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LAq);
      }
      i = paramInt;
      if (this.LAr != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LAr);
      }
      AppMethodBeat.o(196087);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(196087);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aoi localaoi = (aoi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(196087);
          return -1;
        case 1: 
          localaoi.LAp = locala.UbS.readString();
          AppMethodBeat.o(196087);
          return 0;
        case 2: 
          localaoi.LAq = locala.UbS.readString();
          AppMethodBeat.o(196087);
          return 0;
        }
        localaoi.LAr = locala.UbS.readString();
        AppMethodBeat.o(196087);
        return 0;
      }
      AppMethodBeat.o(196087);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoi
 * JD-Core Version:    0.7.0.1
 */