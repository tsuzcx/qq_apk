package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bsi
  extends com.tencent.mm.bx.a
{
  public String content;
  public String lang;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117534);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.lang == null)
      {
        paramVarArgs = new b("Not all required fields were included: lang");
        AppMethodBeat.o(117534);
        throw paramVarArgs;
      }
      if (this.content == null)
      {
        paramVarArgs = new b("Not all required fields were included: content");
        AppMethodBeat.o(117534);
        throw paramVarArgs;
      }
      if (this.lang != null) {
        paramVarArgs.d(1, this.lang);
      }
      if (this.content != null) {
        paramVarArgs.d(2, this.content);
      }
      AppMethodBeat.o(117534);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lang == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.lang) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.content != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.content);
      }
      AppMethodBeat.o(117534);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.lang == null)
        {
          paramVarArgs = new b("Not all required fields were included: lang");
          AppMethodBeat.o(117534);
          throw paramVarArgs;
        }
        if (this.content == null)
        {
          paramVarArgs = new b("Not all required fields were included: content");
          AppMethodBeat.o(117534);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117534);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bsi localbsi = (bsi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117534);
          return -1;
        case 1: 
          localbsi.lang = locala.KhF.readString();
          AppMethodBeat.o(117534);
          return 0;
        }
        localbsi.content = locala.KhF.readString();
        AppMethodBeat.o(117534);
        return 0;
      }
      AppMethodBeat.o(117534);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsi
 * JD-Core Version:    0.7.0.1
 */