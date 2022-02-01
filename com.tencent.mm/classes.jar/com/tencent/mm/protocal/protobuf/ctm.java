package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctm
  extends com.tencent.mm.bw.a
{
  public String FVh;
  public int HBJ;
  public String qkD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32411);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qkD != null) {
        paramVarArgs.d(1, this.qkD);
      }
      if (this.FVh != null) {
        paramVarArgs.d(2, this.FVh);
      }
      paramVarArgs.aS(3, this.HBJ);
      AppMethodBeat.o(32411);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qkD == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = f.a.a.b.b.a.e(1, this.qkD) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FVh != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FVh);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HBJ);
      AppMethodBeat.o(32411);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32411);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ctm localctm = (ctm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32411);
          return -1;
        case 1: 
          localctm.qkD = locala.OmT.readString();
          AppMethodBeat.o(32411);
          return 0;
        case 2: 
          localctm.FVh = locala.OmT.readString();
          AppMethodBeat.o(32411);
          return 0;
        }
        localctm.HBJ = locala.OmT.zc();
        AppMethodBeat.o(32411);
        return 0;
      }
      AppMethodBeat.o(32411);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctm
 * JD-Core Version:    0.7.0.1
 */