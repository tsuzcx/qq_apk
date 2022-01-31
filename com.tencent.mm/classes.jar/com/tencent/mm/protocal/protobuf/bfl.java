package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class bfl
  extends com.tencent.mm.bv.a
{
  public String content;
  public String lang;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90694);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.lang == null)
      {
        paramVarArgs = new b("Not all required fields were included: lang");
        AppMethodBeat.o(90694);
        throw paramVarArgs;
      }
      if (this.content == null)
      {
        paramVarArgs = new b("Not all required fields were included: content");
        AppMethodBeat.o(90694);
        throw paramVarArgs;
      }
      if (this.lang != null) {
        paramVarArgs.e(1, this.lang);
      }
      if (this.content != null) {
        paramVarArgs.e(2, this.content);
      }
      AppMethodBeat.o(90694);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lang == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = e.a.a.b.b.a.f(1, this.lang) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.content != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.content);
      }
      AppMethodBeat.o(90694);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.lang == null)
        {
          paramVarArgs = new b("Not all required fields were included: lang");
          AppMethodBeat.o(90694);
          throw paramVarArgs;
        }
        if (this.content == null)
        {
          paramVarArgs = new b("Not all required fields were included: content");
          AppMethodBeat.o(90694);
          throw paramVarArgs;
        }
        AppMethodBeat.o(90694);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bfl localbfl = (bfl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(90694);
          return -1;
        case 1: 
          localbfl.lang = locala.CLY.readString();
          AppMethodBeat.o(90694);
          return 0;
        }
        localbfl.content = locala.CLY.readString();
        AppMethodBeat.o(90694);
        return 0;
      }
      AppMethodBeat.o(90694);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfl
 * JD-Core Version:    0.7.0.1
 */