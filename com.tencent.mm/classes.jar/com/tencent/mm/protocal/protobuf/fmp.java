package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fmp
  extends com.tencent.mm.cd.a
{
  public String ULo;
  public String Uam;
  public String pinyin;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152729);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Uam != null) {
        paramVarArgs.f(1, this.Uam);
      }
      if (this.wording != null) {
        paramVarArgs.f(2, this.wording);
      }
      if (this.pinyin != null) {
        paramVarArgs.f(3, this.pinyin);
      }
      if (this.ULo != null) {
        paramVarArgs.f(4, this.ULo);
      }
      AppMethodBeat.o(152729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Uam == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.g(1, this.Uam) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.wording);
      }
      i = paramInt;
      if (this.pinyin != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.pinyin);
      }
      paramInt = i;
      if (this.ULo != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ULo);
      }
      AppMethodBeat.o(152729);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152729);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fmp localfmp = (fmp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152729);
          return -1;
        case 1: 
          localfmp.Uam = locala.abFh.readString();
          AppMethodBeat.o(152729);
          return 0;
        case 2: 
          localfmp.wording = locala.abFh.readString();
          AppMethodBeat.o(152729);
          return 0;
        case 3: 
          localfmp.pinyin = locala.abFh.readString();
          AppMethodBeat.o(152729);
          return 0;
        }
        localfmp.ULo = locala.abFh.readString();
        AppMethodBeat.o(152729);
        return 0;
      }
      AppMethodBeat.o(152729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmp
 * JD-Core Version:    0.7.0.1
 */