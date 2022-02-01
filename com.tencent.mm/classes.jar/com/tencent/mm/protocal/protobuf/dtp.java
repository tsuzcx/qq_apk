package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dtp
  extends com.tencent.mm.bx.a
{
  public int YWM;
  public String Zev;
  public String aaZl;
  public String path;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123630);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.Zev != null) {
        paramVarArgs.g(2, this.Zev);
      }
      if (this.aaZl != null) {
        paramVarArgs.g(3, this.aaZl);
      }
      if (this.path != null) {
        paramVarArgs.g(4, this.path);
      }
      paramVarArgs.bS(5, this.YWM);
      paramVarArgs.bS(6, this.type);
      AppMethodBeat.o(123630);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label482;
      }
    }
    label482:
    for (int i = i.a.a.b.b.a.h(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Zev != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zev);
      }
      i = paramInt;
      if (this.aaZl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaZl);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.path);
      }
      i = i.a.a.b.b.a.cJ(5, this.YWM);
      int j = i.a.a.b.b.a.cJ(6, this.type);
      AppMethodBeat.o(123630);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123630);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dtp localdtp = (dtp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123630);
          return -1;
        case 1: 
          localdtp.username = locala.ajGk.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 2: 
          localdtp.Zev = locala.ajGk.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 3: 
          localdtp.aaZl = locala.ajGk.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 4: 
          localdtp.path = locala.ajGk.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 5: 
          localdtp.YWM = locala.ajGk.aar();
          AppMethodBeat.o(123630);
          return 0;
        }
        localdtp.type = locala.ajGk.aar();
        AppMethodBeat.o(123630);
        return 0;
      }
      AppMethodBeat.o(123630);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtp
 * JD-Core Version:    0.7.0.1
 */