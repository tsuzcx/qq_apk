package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aez
  extends com.tencent.mm.bx.a
{
  public String link;
  public String title;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260064);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.g(1, this.wording);
      }
      if (this.title != null) {
        paramVarArgs.g(2, this.title);
      }
      if (this.link != null) {
        paramVarArgs.g(3, this.link);
      }
      AppMethodBeat.o(260064);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.wording) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.title);
      }
      i = paramInt;
      if (this.link != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.link);
      }
      AppMethodBeat.o(260064);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260064);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aez localaez = (aez)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260064);
          return -1;
        case 1: 
          localaez.wording = locala.ajGk.readString();
          AppMethodBeat.o(260064);
          return 0;
        case 2: 
          localaez.title = locala.ajGk.readString();
          AppMethodBeat.o(260064);
          return 0;
        }
        localaez.link = locala.ajGk.readString();
        AppMethodBeat.o(260064);
        return 0;
      }
      AppMethodBeat.o(260064);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aez
 * JD-Core Version:    0.7.0.1
 */