package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbc
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String kWy;
  public String title;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(139630);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.kWy != null) {
        paramVarArgs.e(1, this.kWy);
      }
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(3, this.desc);
      }
      if (this.username != null) {
        paramVarArgs.e(4, this.username);
      }
      AppMethodBeat.o(139630);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kWy == null) {
        break label394;
      }
    }
    label394:
    for (int i = e.a.a.b.b.a.f(1, this.kWy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.desc);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.username);
      }
      AppMethodBeat.o(139630);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(139630);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        dbc localdbc = (dbc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(139630);
          return -1;
        case 1: 
          localdbc.kWy = locala.CLY.readString();
          AppMethodBeat.o(139630);
          return 0;
        case 2: 
          localdbc.title = locala.CLY.readString();
          AppMethodBeat.o(139630);
          return 0;
        case 3: 
          localdbc.desc = locala.CLY.readString();
          AppMethodBeat.o(139630);
          return 0;
        }
        localdbc.username = locala.CLY.readString();
        AppMethodBeat.o(139630);
        return 0;
      }
      AppMethodBeat.o(139630);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbc
 * JD-Core Version:    0.7.0.1
 */