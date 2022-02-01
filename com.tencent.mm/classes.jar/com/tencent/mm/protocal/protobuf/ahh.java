package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ahh
  extends com.tencent.mm.bx.a
{
  public String DjX;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153271);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title == null)
      {
        paramVarArgs = new b("Not all required fields were included: title");
        AppMethodBeat.o(153271);
        throw paramVarArgs;
      }
      if (this.DjX == null)
      {
        paramVarArgs = new b("Not all required fields were included: jumpurl_prefix");
        AppMethodBeat.o(153271);
        throw paramVarArgs;
      }
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.DjX != null) {
        paramVarArgs.d(2, this.DjX);
      }
      AppMethodBeat.o(153271);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DjX != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DjX);
      }
      AppMethodBeat.o(153271);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.title == null)
        {
          paramVarArgs = new b("Not all required fields were included: title");
          AppMethodBeat.o(153271);
          throw paramVarArgs;
        }
        if (this.DjX == null)
        {
          paramVarArgs = new b("Not all required fields were included: jumpurl_prefix");
          AppMethodBeat.o(153271);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153271);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ahh localahh = (ahh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153271);
          return -1;
        case 1: 
          localahh.title = locala.KhF.readString();
          AppMethodBeat.o(153271);
          return 0;
        }
        localahh.DjX = locala.KhF.readString();
        AppMethodBeat.o(153271);
        return 0;
      }
      AppMethodBeat.o(153271);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahh
 * JD-Core Version:    0.7.0.1
 */