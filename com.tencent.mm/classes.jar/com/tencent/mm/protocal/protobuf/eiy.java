package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eiy
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public String ZhN;
  public int Zpl;
  public int abnL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32393);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      if (this.ZhN != null) {
        paramVarArgs.g(2, this.ZhN);
      }
      paramVarArgs.bS(3, this.abnL);
      paramVarArgs.bS(4, this.Zpl);
      AppMethodBeat.o(32393);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label372;
      }
    }
    label372:
    for (paramInt = i.a.a.b.b.a.h(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZhN != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZhN);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.abnL);
      int j = i.a.a.b.b.a.cJ(4, this.Zpl);
      AppMethodBeat.o(32393);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32393);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eiy localeiy = (eiy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32393);
          return -1;
        case 1: 
          localeiy.UserName = locala.ajGk.readString();
          AppMethodBeat.o(32393);
          return 0;
        case 2: 
          localeiy.ZhN = locala.ajGk.readString();
          AppMethodBeat.o(32393);
          return 0;
        case 3: 
          localeiy.abnL = locala.ajGk.aar();
          AppMethodBeat.o(32393);
          return 0;
        }
        localeiy.Zpl = locala.ajGk.aar();
        AppMethodBeat.o(32393);
        return 0;
      }
      AppMethodBeat.o(32393);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eiy
 * JD-Core Version:    0.7.0.1
 */