package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bhk
  extends com.tencent.mm.bv.a
{
  public int FileSize;
  public String fMs;
  public int wAK;
  public int wLO;
  public String xwA;
  public int xwB;
  public String xwC;
  public int xwy;
  public int xwz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28563);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.fMs != null) {
        paramVarArgs.e(1, this.fMs);
      }
      paramVarArgs.aO(2, this.xwy);
      paramVarArgs.aO(3, this.xwz);
      paramVarArgs.aO(4, this.wAK);
      if (this.xwA != null) {
        paramVarArgs.e(5, this.xwA);
      }
      paramVarArgs.aO(6, this.FileSize);
      paramVarArgs.aO(7, this.xwB);
      paramVarArgs.aO(8, this.wLO);
      if (this.xwC != null) {
        paramVarArgs.e(9, this.xwC);
      }
      AppMethodBeat.o(28563);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fMs == null) {
        break label613;
      }
    }
    label613:
    for (paramInt = e.a.a.b.b.a.f(1, this.fMs) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xwy) + e.a.a.b.b.a.bl(3, this.xwz) + e.a.a.b.b.a.bl(4, this.wAK);
      paramInt = i;
      if (this.xwA != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xwA);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.FileSize) + e.a.a.b.b.a.bl(7, this.xwB) + e.a.a.b.b.a.bl(8, this.wLO);
      paramInt = i;
      if (this.xwC != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xwC);
      }
      AppMethodBeat.o(28563);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28563);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bhk localbhk = (bhk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28563);
          return -1;
        case 1: 
          localbhk.fMs = locala.CLY.readString();
          AppMethodBeat.o(28563);
          return 0;
        case 2: 
          localbhk.xwy = locala.CLY.sl();
          AppMethodBeat.o(28563);
          return 0;
        case 3: 
          localbhk.xwz = locala.CLY.sl();
          AppMethodBeat.o(28563);
          return 0;
        case 4: 
          localbhk.wAK = locala.CLY.sl();
          AppMethodBeat.o(28563);
          return 0;
        case 5: 
          localbhk.xwA = locala.CLY.readString();
          AppMethodBeat.o(28563);
          return 0;
        case 6: 
          localbhk.FileSize = locala.CLY.sl();
          AppMethodBeat.o(28563);
          return 0;
        case 7: 
          localbhk.xwB = locala.CLY.sl();
          AppMethodBeat.o(28563);
          return 0;
        case 8: 
          localbhk.wLO = locala.CLY.sl();
          AppMethodBeat.o(28563);
          return 0;
        }
        localbhk.xwC = locala.CLY.readString();
        AppMethodBeat.o(28563);
        return 0;
      }
      AppMethodBeat.o(28563);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhk
 * JD-Core Version:    0.7.0.1
 */