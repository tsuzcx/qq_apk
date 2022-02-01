package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bx.a
{
  public String AiA;
  public String desc;
  public int hXx;
  public String thumbPath;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94810);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      if (this.thumbPath != null) {
        paramVarArgs.g(3, this.thumbPath);
      }
      paramVarArgs.bS(4, this.hXx);
      if (this.AiA != null) {
        paramVarArgs.g(5, this.AiA);
      }
      AppMethodBeat.o(94810);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label434;
      }
    }
    label434:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.desc);
      }
      i = paramInt;
      if (this.thumbPath != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.thumbPath);
      }
      i += i.a.a.b.b.a.cJ(4, this.hXx);
      paramInt = i;
      if (this.AiA != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.AiA);
      }
      AppMethodBeat.o(94810);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(94810);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(94810);
          return -1;
        case 1: 
          locald.title = locala.ajGk.readString();
          AppMethodBeat.o(94810);
          return 0;
        case 2: 
          locald.desc = locala.ajGk.readString();
          AppMethodBeat.o(94810);
          return 0;
        case 3: 
          locald.thumbPath = locala.ajGk.readString();
          AppMethodBeat.o(94810);
          return 0;
        case 4: 
          locald.hXx = locala.ajGk.aar();
          AppMethodBeat.o(94810);
          return 0;
        }
        locald.AiA = locala.ajGk.readString();
        AppMethodBeat.o(94810);
        return 0;
      }
      AppMethodBeat.o(94810);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.d
 * JD-Core Version:    0.7.0.1
 */