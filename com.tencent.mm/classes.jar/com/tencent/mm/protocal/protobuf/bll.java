package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bll
  extends com.tencent.mm.bx.a
{
  public String Kru;
  public boolean ZUD;
  public String icon_url;
  public String wording;
  public int wuj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259295);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.ZUD);
      if (this.icon_url != null) {
        paramVarArgs.g(2, this.icon_url);
      }
      if (this.wording != null) {
        paramVarArgs.g(3, this.wording);
      }
      paramVarArgs.bS(4, this.wuj);
      if (this.Kru != null) {
        paramVarArgs.g(5, this.Kru);
      }
      AppMethodBeat.o(259295);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 1 + 0;
      paramInt = i;
      if (this.icon_url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.icon_url);
      }
      i = paramInt;
      if (this.wording != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.wording);
      }
      i += i.a.a.b.b.a.cJ(4, this.wuj);
      paramInt = i;
      if (this.Kru != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Kru);
      }
      AppMethodBeat.o(259295);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259295);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bll localbll = (bll)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259295);
        return -1;
      case 1: 
        localbll.ZUD = locala.ajGk.aai();
        AppMethodBeat.o(259295);
        return 0;
      case 2: 
        localbll.icon_url = locala.ajGk.readString();
        AppMethodBeat.o(259295);
        return 0;
      case 3: 
        localbll.wording = locala.ajGk.readString();
        AppMethodBeat.o(259295);
        return 0;
      case 4: 
        localbll.wuj = locala.ajGk.aar();
        AppMethodBeat.o(259295);
        return 0;
      }
      localbll.Kru = locala.ajGk.readString();
      AppMethodBeat.o(259295);
      return 0;
    }
    AppMethodBeat.o(259295);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bll
 * JD-Core Version:    0.7.0.1
 */