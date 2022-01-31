package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dq
  extends com.tencent.mm.bv.a
{
  public String fKw;
  public int jKs;
  public int wpF;
  public String wpG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96190);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.fKw != null) {
        paramVarArgs.e(1, this.fKw);
      }
      paramVarArgs.aO(2, this.jKs);
      paramVarArgs.aO(3, this.wpF);
      if (this.wpG != null) {
        paramVarArgs.e(4, this.wpG);
      }
      AppMethodBeat.o(96190);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fKw == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = e.a.a.b.b.a.f(1, this.fKw) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jKs) + e.a.a.b.b.a.bl(3, this.wpF);
      paramInt = i;
      if (this.wpG != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wpG);
      }
      AppMethodBeat.o(96190);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96190);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        dq localdq = (dq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96190);
          return -1;
        case 1: 
          localdq.fKw = locala.CLY.readString();
          AppMethodBeat.o(96190);
          return 0;
        case 2: 
          localdq.jKs = locala.CLY.sl();
          AppMethodBeat.o(96190);
          return 0;
        case 3: 
          localdq.wpF = locala.CLY.sl();
          AppMethodBeat.o(96190);
          return 0;
        }
        localdq.wpG = locala.CLY.readString();
        AppMethodBeat.o(96190);
        return 0;
      }
      AppMethodBeat.o(96190);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dq
 * JD-Core Version:    0.7.0.1
 */