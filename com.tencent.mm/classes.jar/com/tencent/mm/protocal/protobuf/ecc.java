package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ecc
  extends com.tencent.mm.bw.a
{
  public String HJs;
  public int IhF;
  public String jge;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32507);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HJs != null) {
        paramVarArgs.d(1, this.HJs);
      }
      if (this.jge != null) {
        paramVarArgs.d(2, this.jge);
      }
      paramVarArgs.aS(3, this.IhF);
      AppMethodBeat.o(32507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HJs == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = f.a.a.b.b.a.e(1, this.HJs) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jge != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.jge);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.IhF);
      AppMethodBeat.o(32507);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32507);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ecc localecc = (ecc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32507);
          return -1;
        case 1: 
          localecc.HJs = locala.OmT.readString();
          AppMethodBeat.o(32507);
          return 0;
        case 2: 
          localecc.jge = locala.OmT.readString();
          AppMethodBeat.o(32507);
          return 0;
        }
        localecc.IhF = locala.OmT.zc();
        AppMethodBeat.o(32507);
        return 0;
      }
      AppMethodBeat.o(32507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecc
 * JD-Core Version:    0.7.0.1
 */