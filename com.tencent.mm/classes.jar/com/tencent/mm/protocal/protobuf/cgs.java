package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgs
  extends com.tencent.mm.bv.a
{
  public String ThumbUrl;
  public String jJA;
  public String nrZ;
  public long xRw;
  public int xRx;
  public int xRy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56499);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJA != null) {
        paramVarArgs.e(1, this.jJA);
      }
      paramVarArgs.am(2, this.xRw);
      paramVarArgs.aO(3, this.xRx);
      if (this.ThumbUrl != null) {
        paramVarArgs.e(4, this.ThumbUrl);
      }
      paramVarArgs.aO(5, this.xRy);
      if (this.nrZ != null) {
        paramVarArgs.e(6, this.nrZ);
      }
      AppMethodBeat.o(56499);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJA == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = e.a.a.b.b.a.f(1, this.jJA) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.xRw) + e.a.a.b.b.a.bl(3, this.xRx);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ThumbUrl);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.xRy);
      paramInt = i;
      if (this.nrZ != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.nrZ);
      }
      AppMethodBeat.o(56499);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56499);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cgs localcgs = (cgs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56499);
          return -1;
        case 1: 
          localcgs.jJA = locala.CLY.readString();
          AppMethodBeat.o(56499);
          return 0;
        case 2: 
          localcgs.xRw = locala.CLY.sm();
          AppMethodBeat.o(56499);
          return 0;
        case 3: 
          localcgs.xRx = locala.CLY.sl();
          AppMethodBeat.o(56499);
          return 0;
        case 4: 
          localcgs.ThumbUrl = locala.CLY.readString();
          AppMethodBeat.o(56499);
          return 0;
        case 5: 
          localcgs.xRy = locala.CLY.sl();
          AppMethodBeat.o(56499);
          return 0;
        }
        localcgs.nrZ = locala.CLY.readString();
        AppMethodBeat.o(56499);
        return 0;
      }
      AppMethodBeat.o(56499);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgs
 * JD-Core Version:    0.7.0.1
 */