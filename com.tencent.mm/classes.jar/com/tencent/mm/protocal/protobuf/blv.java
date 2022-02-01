package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class blv
  extends com.tencent.mm.bx.a
{
  public String CFE;
  public String CFF;
  public String CFG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43103);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CFF != null) {
        paramVarArgs.d(1, this.CFF);
      }
      if (this.CFE != null) {
        paramVarArgs.d(2, this.CFE);
      }
      if (this.CFG != null) {
        paramVarArgs.d(3, this.CFG);
      }
      AppMethodBeat.o(43103);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CFF == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.CFF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CFE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CFE);
      }
      i = paramInt;
      if (this.CFG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CFG);
      }
      AppMethodBeat.o(43103);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(43103);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        blv localblv = (blv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43103);
          return -1;
        case 1: 
          localblv.CFF = locala.KhF.readString();
          AppMethodBeat.o(43103);
          return 0;
        case 2: 
          localblv.CFE = locala.KhF.readString();
          AppMethodBeat.o(43103);
          return 0;
        }
        localblv.CFG = locala.KhF.readString();
        AppMethodBeat.o(43103);
        return 0;
      }
      AppMethodBeat.o(43103);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blv
 * JD-Core Version:    0.7.0.1
 */