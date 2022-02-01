package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zh
  extends com.tencent.mm.cd.a
{
  public String GHJ;
  public String IoR;
  public int Slx;
  public String title;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72459);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.wording != null) {
        paramVarArgs.f(2, this.wording);
      }
      if (this.GHJ != null) {
        paramVarArgs.f(3, this.GHJ);
      }
      if (this.IoR != null) {
        paramVarArgs.f(4, this.IoR);
      }
      paramVarArgs.aY(5, this.Slx);
      AppMethodBeat.o(72459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label438;
      }
    }
    label438:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.wording);
      }
      i = paramInt;
      if (this.GHJ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.GHJ);
      }
      paramInt = i;
      if (this.IoR != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.IoR);
      }
      i = g.a.a.b.b.a.bM(5, this.Slx);
      AppMethodBeat.o(72459);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72459);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        zh localzh = (zh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72459);
          return -1;
        case 1: 
          localzh.title = locala.abFh.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 2: 
          localzh.wording = locala.abFh.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 3: 
          localzh.GHJ = locala.abFh.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 4: 
          localzh.IoR = locala.abFh.readString();
          AppMethodBeat.o(72459);
          return 0;
        }
        localzh.Slx = locala.abFh.AK();
        AppMethodBeat.o(72459);
        return 0;
      }
      AppMethodBeat.o(72459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zh
 * JD-Core Version:    0.7.0.1
 */