package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class esg
  extends com.tencent.mm.bx.a
{
  public String IdD;
  public int YPt;
  public int status;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258433);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.IdD != null) {
        paramVarArgs.g(2, this.IdD);
      }
      paramVarArgs.bS(3, this.status);
      paramVarArgs.bS(4, this.YPt);
      AppMethodBeat.o(258433);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IdD != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IdD);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.status);
      int j = i.a.a.b.b.a.cJ(4, this.YPt);
      AppMethodBeat.o(258433);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258433);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        esg localesg = (esg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258433);
          return -1;
        case 1: 
          localesg.title = locala.ajGk.readString();
          AppMethodBeat.o(258433);
          return 0;
        case 2: 
          localesg.IdD = locala.ajGk.readString();
          AppMethodBeat.o(258433);
          return 0;
        case 3: 
          localesg.status = locala.ajGk.aar();
          AppMethodBeat.o(258433);
          return 0;
        }
        localesg.YPt = locala.ajGk.aar();
        AppMethodBeat.o(258433);
        return 0;
      }
      AppMethodBeat.o(258433);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esg
 * JD-Core Version:    0.7.0.1
 */