package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dor
  extends com.tencent.mm.bx.a
{
  public String desc;
  public String nQG;
  public String path;
  public String title;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91539);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nQG != null) {
        paramVarArgs.g(1, this.nQG);
      }
      if (this.title != null) {
        paramVarArgs.g(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(3, this.desc);
      }
      if (this.username != null) {
        paramVarArgs.g(4, this.username);
      }
      if (this.path != null) {
        paramVarArgs.g(5, this.path);
      }
      AppMethodBeat.o(91539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nQG == null) {
        break label450;
      }
    }
    label450:
    for (int i = i.a.a.b.b.a.h(1, this.nQG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.desc);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.username);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.path);
      }
      AppMethodBeat.o(91539);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91539);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dor localdor = (dor)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91539);
          return -1;
        case 1: 
          localdor.nQG = locala.ajGk.readString();
          AppMethodBeat.o(91539);
          return 0;
        case 2: 
          localdor.title = locala.ajGk.readString();
          AppMethodBeat.o(91539);
          return 0;
        case 3: 
          localdor.desc = locala.ajGk.readString();
          AppMethodBeat.o(91539);
          return 0;
        case 4: 
          localdor.username = locala.ajGk.readString();
          AppMethodBeat.o(91539);
          return 0;
        }
        localdor.path = locala.ajGk.readString();
        AppMethodBeat.o(91539);
        return 0;
      }
      AppMethodBeat.o(91539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dor
 * JD-Core Version:    0.7.0.1
 */