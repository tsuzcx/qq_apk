package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dif
  extends com.tencent.mm.bx.a
{
  public String appId;
  public String path;
  public String query;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257360);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.g(1, this.appId);
      }
      if (this.path != null) {
        paramVarArgs.g(2, this.path);
      }
      if (this.query != null) {
        paramVarArgs.g(3, this.query);
      }
      AppMethodBeat.o(257360);
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
      if (this.path != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.path);
      }
      i = paramInt;
      if (this.query != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.query);
      }
      AppMethodBeat.o(257360);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257360);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dif localdif = (dif)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257360);
          return -1;
        case 1: 
          localdif.appId = locala.ajGk.readString();
          AppMethodBeat.o(257360);
          return 0;
        case 2: 
          localdif.path = locala.ajGk.readString();
          AppMethodBeat.o(257360);
          return 0;
        }
        localdif.query = locala.ajGk.readString();
        AppMethodBeat.o(257360);
        return 0;
      }
      AppMethodBeat.o(257360);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dif
 * JD-Core Version:    0.7.0.1
 */