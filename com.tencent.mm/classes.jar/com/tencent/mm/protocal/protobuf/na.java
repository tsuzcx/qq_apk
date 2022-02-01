package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class na
  extends com.tencent.mm.bw.a
{
  public String FZl;
  public int FZm;
  public String FZn;
  public int FZo;
  public int FZp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124415);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FZl != null) {
        paramVarArgs.d(1, this.FZl);
      }
      paramVarArgs.aS(2, this.FZm);
      if (this.FZn != null) {
        paramVarArgs.d(3, this.FZn);
      }
      paramVarArgs.aS(4, this.FZo);
      paramVarArgs.aS(5, this.FZp);
      AppMethodBeat.o(124415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FZl == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = f.a.a.b.b.a.e(1, this.FZl) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FZm);
      paramInt = i;
      if (this.FZn != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FZn);
      }
      i = f.a.a.b.b.a.bz(4, this.FZo);
      int j = f.a.a.b.b.a.bz(5, this.FZp);
      AppMethodBeat.o(124415);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124415);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        na localna = (na)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124415);
          return -1;
        case 1: 
          localna.FZl = locala.OmT.readString();
          AppMethodBeat.o(124415);
          return 0;
        case 2: 
          localna.FZm = locala.OmT.zc();
          AppMethodBeat.o(124415);
          return 0;
        case 3: 
          localna.FZn = locala.OmT.readString();
          AppMethodBeat.o(124415);
          return 0;
        case 4: 
          localna.FZo = locala.OmT.zc();
          AppMethodBeat.o(124415);
          return 0;
        }
        localna.FZp = locala.OmT.zc();
        AppMethodBeat.o(124415);
        return 0;
      }
      AppMethodBeat.o(124415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.na
 * JD-Core Version:    0.7.0.1
 */