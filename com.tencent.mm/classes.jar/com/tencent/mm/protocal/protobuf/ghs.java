package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ghs
  extends com.tencent.mm.bx.a
{
  public String appId;
  public String mup;
  public String pkgPath;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258809);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.g(1, this.appId);
      }
      if (this.pkgPath != null) {
        paramVarArgs.g(2, this.pkgPath);
      }
      if (this.mup != null) {
        paramVarArgs.g(3, this.mup);
      }
      AppMethodBeat.o(258809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.appId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pkgPath != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.pkgPath);
      }
      i = paramInt;
      if (this.mup != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.mup);
      }
      AppMethodBeat.o(258809);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258809);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ghs localghs = (ghs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258809);
          return -1;
        case 1: 
          localghs.appId = locala.ajGk.readString();
          AppMethodBeat.o(258809);
          return 0;
        case 2: 
          localghs.pkgPath = locala.ajGk.readString();
          AppMethodBeat.o(258809);
          return 0;
        }
        localghs.mup = locala.ajGk.readString();
        AppMethodBeat.o(258809);
        return 0;
      }
      AppMethodBeat.o(258809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ghs
 * JD-Core Version:    0.7.0.1
 */