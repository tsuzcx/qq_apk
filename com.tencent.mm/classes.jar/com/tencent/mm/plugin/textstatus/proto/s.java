package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
  extends com.tencent.mm.bx.a
{
  public String ext_info;
  public String url;
  public int wuj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290042);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.wuj);
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.ext_info != null) {
        paramVarArgs.g(3, this.ext_info);
      }
      AppMethodBeat.o(290042);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.wuj) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.ext_info != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ext_info);
      }
      AppMethodBeat.o(290042);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(290042);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      s locals = (s)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(290042);
        return -1;
      case 1: 
        locals.wuj = locala.ajGk.aar();
        AppMethodBeat.o(290042);
        return 0;
      case 2: 
        locals.url = locala.ajGk.readString();
        AppMethodBeat.o(290042);
        return 0;
      }
      locals.ext_info = locala.ajGk.readString();
      AppMethodBeat.o(290042);
      return 0;
    }
    AppMethodBeat.o(290042);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.s
 * JD-Core Version:    0.7.0.1
 */