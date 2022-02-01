package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aah
  extends com.tencent.mm.bx.a
{
  public boolean ZiF;
  public String desc;
  public String result;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258736);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      if (this.result != null) {
        paramVarArgs.g(3, this.result);
      }
      paramVarArgs.di(4, this.ZiF);
      AppMethodBeat.o(258736);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label374;
      }
    }
    label374:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.desc);
      }
      i = paramInt;
      if (this.result != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.result);
      }
      paramInt = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(258736);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258736);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aah localaah = (aah)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258736);
          return -1;
        case 1: 
          localaah.title = locala.ajGk.readString();
          AppMethodBeat.o(258736);
          return 0;
        case 2: 
          localaah.desc = locala.ajGk.readString();
          AppMethodBeat.o(258736);
          return 0;
        case 3: 
          localaah.result = locala.ajGk.readString();
          AppMethodBeat.o(258736);
          return 0;
        }
        localaah.ZiF = locala.ajGk.aai();
        AppMethodBeat.o(258736);
        return 0;
      }
      AppMethodBeat.o(258736);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aah
 * JD-Core Version:    0.7.0.1
 */