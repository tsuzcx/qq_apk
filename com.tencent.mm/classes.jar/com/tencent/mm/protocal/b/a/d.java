package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bw.a
{
  public int dXJ;
  public String desc;
  public String tfO;
  public String thumbPath;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94810);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.thumbPath != null) {
        paramVarArgs.e(3, this.thumbPath);
      }
      paramVarArgs.aM(4, this.dXJ);
      if (this.tfO != null) {
        paramVarArgs.e(5, this.tfO);
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
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.thumbPath != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.thumbPath);
      }
      i += g.a.a.b.b.a.bu(4, this.dXJ);
      paramInt = i;
      if (this.tfO != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.tfO);
      }
      AppMethodBeat.o(94810);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
          locald.title = locala.UbS.readString();
          AppMethodBeat.o(94810);
          return 0;
        case 2: 
          locald.desc = locala.UbS.readString();
          AppMethodBeat.o(94810);
          return 0;
        case 3: 
          locald.thumbPath = locala.UbS.readString();
          AppMethodBeat.o(94810);
          return 0;
        case 4: 
          locald.dXJ = locala.UbS.zi();
          AppMethodBeat.o(94810);
          return 0;
        }
        locald.tfO = locala.UbS.readString();
        AppMethodBeat.o(94810);
        return 0;
      }
      AppMethodBeat.o(94810);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.d
 * JD-Core Version:    0.7.0.1
 */