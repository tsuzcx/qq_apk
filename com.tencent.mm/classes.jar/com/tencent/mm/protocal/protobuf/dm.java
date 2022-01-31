package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dm
  extends com.tencent.mm.bv.a
{
  public boolean qsG;
  public boolean qsH;
  public boolean qsi;
  public String value;
  public int wjb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155950);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wjb);
      if (this.value != null) {
        paramVarArgs.e(2, this.value);
      }
      paramVarArgs.aS(3, this.qsG);
      paramVarArgs.aS(4, this.qsi);
      paramVarArgs.aS(5, this.qsH);
      AppMethodBeat.o(155950);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wjb) + 0;
      paramInt = i;
      if (this.value != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.value);
      }
      i = e.a.a.b.b.a.eW(3);
      int j = e.a.a.b.b.a.eW(4);
      int k = e.a.a.b.b.a.eW(5);
      AppMethodBeat.o(155950);
      return paramInt + (i + 1) + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(155950);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      dm localdm = (dm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155950);
        return -1;
      case 1: 
        localdm.wjb = locala.CLY.sl();
        AppMethodBeat.o(155950);
        return 0;
      case 2: 
        localdm.value = locala.CLY.readString();
        AppMethodBeat.o(155950);
        return 0;
      case 3: 
        localdm.qsG = locala.CLY.emu();
        AppMethodBeat.o(155950);
        return 0;
      case 4: 
        localdm.qsi = locala.CLY.emu();
        AppMethodBeat.o(155950);
        return 0;
      }
      localdm.qsH = locala.CLY.emu();
      AppMethodBeat.o(155950);
      return 0;
    }
    AppMethodBeat.o(155950);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dm
 * JD-Core Version:    0.7.0.1
 */