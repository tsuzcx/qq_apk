package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpt
  extends com.tencent.mm.bw.a
{
  public String DYe;
  public String DYf;
  public String DYg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43103);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DYf != null) {
        paramVarArgs.d(1, this.DYf);
      }
      if (this.DYe != null) {
        paramVarArgs.d(2, this.DYe);
      }
      if (this.DYg != null) {
        paramVarArgs.d(3, this.DYg);
      }
      AppMethodBeat.o(43103);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DYf == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.DYf) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DYe != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DYe);
      }
      i = paramInt;
      if (this.DYg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DYg);
      }
      AppMethodBeat.o(43103);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(43103);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bpt localbpt = (bpt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43103);
          return -1;
        case 1: 
          localbpt.DYf = locala.LVo.readString();
          AppMethodBeat.o(43103);
          return 0;
        case 2: 
          localbpt.DYe = locala.LVo.readString();
          AppMethodBeat.o(43103);
          return 0;
        }
        localbpt.DYg = locala.LVo.readString();
        AppMethodBeat.o(43103);
        return 0;
      }
      AppMethodBeat.o(43103);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpt
 * JD-Core Version:    0.7.0.1
 */