package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eha
  extends com.tencent.mm.bw.a
{
  public int FYj;
  public String IkL;
  public String IkM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123682);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FYj);
      if (this.IkL != null) {
        paramVarArgs.d(2, this.IkL);
      }
      if (this.IkM != null) {
        paramVarArgs.d(3, this.IkM);
      }
      AppMethodBeat.o(123682);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FYj) + 0;
      paramInt = i;
      if (this.IkL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.IkL);
      }
      i = paramInt;
      if (this.IkM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.IkM);
      }
      AppMethodBeat.o(123682);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(123682);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eha localeha = (eha)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123682);
        return -1;
      case 1: 
        localeha.FYj = locala.OmT.zc();
        AppMethodBeat.o(123682);
        return 0;
      case 2: 
        localeha.IkL = locala.OmT.readString();
        AppMethodBeat.o(123682);
        return 0;
      }
      localeha.IkM = locala.OmT.readString();
      AppMethodBeat.o(123682);
      return 0;
    }
    AppMethodBeat.o(123682);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eha
 * JD-Core Version:    0.7.0.1
 */