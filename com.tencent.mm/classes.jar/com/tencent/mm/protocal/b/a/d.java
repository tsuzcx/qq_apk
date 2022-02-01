package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.cd.a
{
  public String desc;
  public int fRA;
  public String thumbPath;
  public String title;
  public String wMd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94810);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.f(2, this.desc);
      }
      if (this.thumbPath != null) {
        paramVarArgs.f(3, this.thumbPath);
      }
      paramVarArgs.aY(4, this.fRA);
      if (this.wMd != null) {
        paramVarArgs.f(5, this.wMd);
      }
      AppMethodBeat.o(94810);
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
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.desc);
      }
      i = paramInt;
      if (this.thumbPath != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.thumbPath);
      }
      i += g.a.a.b.b.a.bM(4, this.fRA);
      paramInt = i;
      if (this.wMd != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.wMd);
      }
      AppMethodBeat.o(94810);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(94810);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(94810);
          return -1;
        case 1: 
          locald.title = locala.abFh.readString();
          AppMethodBeat.o(94810);
          return 0;
        case 2: 
          locald.desc = locala.abFh.readString();
          AppMethodBeat.o(94810);
          return 0;
        case 3: 
          locald.thumbPath = locala.abFh.readString();
          AppMethodBeat.o(94810);
          return 0;
        case 4: 
          locald.fRA = locala.abFh.AK();
          AppMethodBeat.o(94810);
          return 0;
        }
        locald.wMd = locala.abFh.readString();
        AppMethodBeat.o(94810);
        return 0;
      }
      AppMethodBeat.o(94810);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.d
 * JD-Core Version:    0.7.0.1
 */