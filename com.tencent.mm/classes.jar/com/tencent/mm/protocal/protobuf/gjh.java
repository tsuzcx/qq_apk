package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gjh
  extends com.tencent.mm.bx.a
{
  public String abro;
  public String acfB;
  public String pinyin;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152729);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abro != null) {
        paramVarArgs.g(1, this.abro);
      }
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      if (this.pinyin != null) {
        paramVarArgs.g(3, this.pinyin);
      }
      if (this.acfB != null) {
        paramVarArgs.g(4, this.acfB);
      }
      AppMethodBeat.o(152729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abro == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.abro) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wording);
      }
      i = paramInt;
      if (this.pinyin != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.pinyin);
      }
      paramInt = i;
      if (this.acfB != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.acfB);
      }
      AppMethodBeat.o(152729);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152729);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gjh localgjh = (gjh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152729);
          return -1;
        case 1: 
          localgjh.abro = locala.ajGk.readString();
          AppMethodBeat.o(152729);
          return 0;
        case 2: 
          localgjh.wording = locala.ajGk.readString();
          AppMethodBeat.o(152729);
          return 0;
        case 3: 
          localgjh.pinyin = locala.ajGk.readString();
          AppMethodBeat.o(152729);
          return 0;
        }
        localgjh.acfB = locala.ajGk.readString();
        AppMethodBeat.o(152729);
        return 0;
      }
      AppMethodBeat.o(152729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gjh
 * JD-Core Version:    0.7.0.1
 */