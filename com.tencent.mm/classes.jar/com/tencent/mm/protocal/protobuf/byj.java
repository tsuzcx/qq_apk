package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byj
  extends com.tencent.mm.bw.a
{
  public String Hlh;
  public String Hli;
  public String Hlj;
  public String hGe;
  public String hGg;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103209);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.hGg != null) {
        paramVarArgs.d(2, this.hGg);
      }
      if (this.hGe != null) {
        paramVarArgs.d(3, this.hGe);
      }
      if (this.Hlh != null) {
        paramVarArgs.d(4, this.Hlh);
      }
      if (this.Hli != null) {
        paramVarArgs.d(5, this.Hli);
      }
      if (this.Hlj != null) {
        paramVarArgs.d(6, this.Hlj);
      }
      AppMethodBeat.o(103209);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hGg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hGg);
      }
      i = paramInt;
      if (this.hGe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hGe);
      }
      paramInt = i;
      if (this.Hlh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hlh);
      }
      i = paramInt;
      if (this.Hli != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Hli);
      }
      paramInt = i;
      if (this.Hlj != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hlj);
      }
      AppMethodBeat.o(103209);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(103209);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        byj localbyj = (byj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(103209);
          return -1;
        case 1: 
          localbyj.title = locala.OmT.readString();
          AppMethodBeat.o(103209);
          return 0;
        case 2: 
          localbyj.hGg = locala.OmT.readString();
          AppMethodBeat.o(103209);
          return 0;
        case 3: 
          localbyj.hGe = locala.OmT.readString();
          AppMethodBeat.o(103209);
          return 0;
        case 4: 
          localbyj.Hlh = locala.OmT.readString();
          AppMethodBeat.o(103209);
          return 0;
        case 5: 
          localbyj.Hli = locala.OmT.readString();
          AppMethodBeat.o(103209);
          return 0;
        }
        localbyj.Hlj = locala.OmT.readString();
        AppMethodBeat.o(103209);
        return 0;
      }
      AppMethodBeat.o(103209);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byj
 * JD-Core Version:    0.7.0.1
 */