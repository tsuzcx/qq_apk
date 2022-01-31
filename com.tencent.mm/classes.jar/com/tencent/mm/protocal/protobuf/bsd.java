package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsd
  extends com.tencent.mm.bv.a
{
  public String xFC;
  public String xFD;
  public int xFE;
  public int xFF = 0;
  public String xFG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124336);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xFC != null) {
        paramVarArgs.e(1, this.xFC);
      }
      if (this.xFD != null) {
        paramVarArgs.e(2, this.xFD);
      }
      paramVarArgs.aO(3, this.xFE);
      paramVarArgs.aO(4, this.xFF);
      if (this.xFG != null) {
        paramVarArgs.e(5, this.xFG);
      }
      AppMethodBeat.o(124336);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xFC == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = e.a.a.b.b.a.f(1, this.xFC) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xFD != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xFD);
      }
      i = i + e.a.a.b.b.a.bl(3, this.xFE) + e.a.a.b.b.a.bl(4, this.xFF);
      paramInt = i;
      if (this.xFG != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xFG);
      }
      AppMethodBeat.o(124336);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(124336);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bsd localbsd = (bsd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124336);
          return -1;
        case 1: 
          localbsd.xFC = locala.CLY.readString();
          AppMethodBeat.o(124336);
          return 0;
        case 2: 
          localbsd.xFD = locala.CLY.readString();
          AppMethodBeat.o(124336);
          return 0;
        case 3: 
          localbsd.xFE = locala.CLY.sl();
          AppMethodBeat.o(124336);
          return 0;
        case 4: 
          localbsd.xFF = locala.CLY.sl();
          AppMethodBeat.o(124336);
          return 0;
        }
        localbsd.xFG = locala.CLY.readString();
        AppMethodBeat.o(124336);
        return 0;
      }
      AppMethodBeat.o(124336);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsd
 * JD-Core Version:    0.7.0.1
 */