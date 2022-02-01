package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eup
  extends com.tencent.mm.bx.a
{
  public String path;
  public int scene;
  public int type;
  public String username;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257492);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.path != null) {
        paramVarArgs.g(2, this.path);
      }
      paramVarArgs.bS(3, this.version);
      paramVarArgs.bS(4, this.scene);
      paramVarArgs.bS(5, this.type);
      AppMethodBeat.o(257492);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.path != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.path);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.version);
      int j = i.a.a.b.b.a.cJ(4, this.scene);
      int k = i.a.a.b.b.a.cJ(5, this.type);
      AppMethodBeat.o(257492);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257492);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eup localeup = (eup)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257492);
          return -1;
        case 1: 
          localeup.username = locala.ajGk.readString();
          AppMethodBeat.o(257492);
          return 0;
        case 2: 
          localeup.path = locala.ajGk.readString();
          AppMethodBeat.o(257492);
          return 0;
        case 3: 
          localeup.version = locala.ajGk.aar();
          AppMethodBeat.o(257492);
          return 0;
        case 4: 
          localeup.scene = locala.ajGk.aar();
          AppMethodBeat.o(257492);
          return 0;
        }
        localeup.type = locala.ajGk.aar();
        AppMethodBeat.o(257492);
        return 0;
      }
      AppMethodBeat.o(257492);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eup
 * JD-Core Version:    0.7.0.1
 */