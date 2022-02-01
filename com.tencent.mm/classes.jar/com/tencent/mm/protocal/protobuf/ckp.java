package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckp
  extends com.tencent.mm.bx.a
{
  public String icon_url;
  public String path;
  public String title;
  public String ttL;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123579);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.icon_url != null) {
        paramVarArgs.g(1, this.icon_url);
      }
      if (this.title != null) {
        paramVarArgs.g(2, this.title);
      }
      paramVarArgs.bS(3, this.type);
      if (this.ttL != null) {
        paramVarArgs.g(4, this.ttL);
      }
      if (this.username != null) {
        paramVarArgs.g(5, this.username);
      }
      if (this.path != null) {
        paramVarArgs.g(6, this.path);
      }
      AppMethodBeat.o(123579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.icon_url == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = i.a.a.b.b.a.h(1, this.icon_url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.title);
      }
      i += i.a.a.b.b.a.cJ(3, this.type);
      paramInt = i;
      if (this.ttL != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ttL);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.username);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.path);
      }
      AppMethodBeat.o(123579);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123579);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ckp localckp = (ckp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123579);
          return -1;
        case 1: 
          localckp.icon_url = locala.ajGk.readString();
          AppMethodBeat.o(123579);
          return 0;
        case 2: 
          localckp.title = locala.ajGk.readString();
          AppMethodBeat.o(123579);
          return 0;
        case 3: 
          localckp.type = locala.ajGk.aar();
          AppMethodBeat.o(123579);
          return 0;
        case 4: 
          localckp.ttL = locala.ajGk.readString();
          AppMethodBeat.o(123579);
          return 0;
        case 5: 
          localckp.username = locala.ajGk.readString();
          AppMethodBeat.o(123579);
          return 0;
        }
        localckp.path = locala.ajGk.readString();
        AppMethodBeat.o(123579);
        return 0;
      }
      AppMethodBeat.o(123579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckp
 * JD-Core Version:    0.7.0.1
 */