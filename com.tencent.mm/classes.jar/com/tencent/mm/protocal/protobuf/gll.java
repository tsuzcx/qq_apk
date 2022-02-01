package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gll
  extends com.tencent.mm.bx.a
{
  public int YWM;
  public String Zev;
  public String path;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123705);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.Zev != null) {
        paramVarArgs.g(2, this.Zev);
      }
      paramVarArgs.bS(3, this.YWM);
      if (this.path != null) {
        paramVarArgs.g(4, this.path);
      }
      AppMethodBeat.o(123705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label374;
      }
    }
    label374:
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Zev != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Zev);
      }
      i += i.a.a.b.b.a.cJ(3, this.YWM);
      paramInt = i;
      if (this.path != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.path);
      }
      AppMethodBeat.o(123705);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123705);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gll localgll = (gll)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123705);
          return -1;
        case 1: 
          localgll.username = locala.ajGk.readString();
          AppMethodBeat.o(123705);
          return 0;
        case 2: 
          localgll.Zev = locala.ajGk.readString();
          AppMethodBeat.o(123705);
          return 0;
        case 3: 
          localgll.YWM = locala.ajGk.aar();
          AppMethodBeat.o(123705);
          return 0;
        }
        localgll.path = locala.ajGk.readString();
        AppMethodBeat.o(123705);
        return 0;
      }
      AppMethodBeat.o(123705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gll
 * JD-Core Version:    0.7.0.1
 */