package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vp
  extends com.tencent.mm.bx.a
{
  public String text;
  public String url;
  public int wuj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113947);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.wuj);
      if (this.text != null) {
        paramVarArgs.g(2, this.text);
      }
      if (this.url != null) {
        paramVarArgs.g(3, this.url);
      }
      AppMethodBeat.o(113947);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.wuj) + 0;
      paramInt = i;
      if (this.text != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.text);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.url);
      }
      AppMethodBeat.o(113947);
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
      AppMethodBeat.o(113947);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      vp localvp = (vp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113947);
        return -1;
      case 1: 
        localvp.wuj = locala.ajGk.aar();
        AppMethodBeat.o(113947);
        return 0;
      case 2: 
        localvp.text = locala.ajGk.readString();
        AppMethodBeat.o(113947);
        return 0;
      }
      localvp.url = locala.ajGk.readString();
      AppMethodBeat.o(113947);
      return 0;
    }
    AppMethodBeat.o(113947);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vp
 * JD-Core Version:    0.7.0.1
 */