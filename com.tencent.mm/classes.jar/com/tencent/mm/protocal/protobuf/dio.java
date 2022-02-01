package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dio
  extends com.tencent.mm.bx.a
{
  public String content;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32456);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.type == null)
      {
        paramVarArgs = new b("Not all required fields were included: type");
        AppMethodBeat.o(32456);
        throw paramVarArgs;
      }
      if (this.type != null) {
        paramVarArgs.d(1, this.type);
      }
      if (this.content != null) {
        paramVarArgs.d(2, this.content);
      }
      AppMethodBeat.o(32456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.type == null) {
        break label334;
      }
    }
    label334:
    for (paramInt = f.a.a.b.b.a.e(1, this.type) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.content != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.content);
      }
      AppMethodBeat.o(32456);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.type == null)
        {
          paramVarArgs = new b("Not all required fields were included: type");
          AppMethodBeat.o(32456);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32456);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dio localdio = (dio)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32456);
          return -1;
        case 1: 
          localdio.type = locala.NPN.readString();
          AppMethodBeat.o(32456);
          return 0;
        }
        localdio.content = locala.NPN.readString();
        AppMethodBeat.o(32456);
        return 0;
      }
      AppMethodBeat.o(32456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dio
 * JD-Core Version:    0.7.0.1
 */