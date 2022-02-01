package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctg
  extends com.tencent.mm.bw.a
{
  public String HEr;
  public String HEs;
  public int HEt;
  public int HyA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91667);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HyA);
      if (this.HEr != null) {
        paramVarArgs.d(2, this.HEr);
      }
      if (this.HEs != null) {
        paramVarArgs.d(3, this.HEs);
      }
      paramVarArgs.aS(4, this.HEt);
      AppMethodBeat.o(91667);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HyA) + 0;
      paramInt = i;
      if (this.HEr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HEr);
      }
      i = paramInt;
      if (this.HEs != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HEs);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.HEt);
      AppMethodBeat.o(91667);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91667);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ctg localctg = (ctg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91667);
        return -1;
      case 1: 
        localctg.HyA = locala.OmT.zc();
        AppMethodBeat.o(91667);
        return 0;
      case 2: 
        localctg.HEr = locala.OmT.readString();
        AppMethodBeat.o(91667);
        return 0;
      case 3: 
        localctg.HEs = locala.OmT.readString();
        AppMethodBeat.o(91667);
        return 0;
      }
      localctg.HEt = locala.OmT.zc();
      AppMethodBeat.o(91667);
      return 0;
    }
    AppMethodBeat.o(91667);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctg
 * JD-Core Version:    0.7.0.1
 */