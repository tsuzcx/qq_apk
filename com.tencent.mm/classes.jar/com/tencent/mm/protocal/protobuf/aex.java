package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aex
  extends com.tencent.mm.bx.a
{
  public int ZmT;
  public String ZmU;
  public String ZmV;
  public String ZmW;
  public String ZmX;
  public int ZmY;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260252);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      paramVarArgs.bS(2, this.ZmT);
      if (this.ZmU != null) {
        paramVarArgs.g(3, this.ZmU);
      }
      if (this.ZmV != null) {
        paramVarArgs.g(4, this.ZmV);
      }
      if (this.ZmW != null) {
        paramVarArgs.g(5, this.ZmW);
      }
      if (this.ZmX != null) {
        paramVarArgs.g(6, this.ZmX);
      }
      paramVarArgs.bS(7, this.ZmY);
      AppMethodBeat.o(260252);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ZmT);
      paramInt = i;
      if (this.ZmU != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZmU);
      }
      i = paramInt;
      if (this.ZmV != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.ZmV);
      }
      paramInt = i;
      if (this.ZmW != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZmW);
      }
      i = paramInt;
      if (this.ZmX != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.ZmX);
      }
      paramInt = i.a.a.b.b.a.cJ(7, this.ZmY);
      AppMethodBeat.o(260252);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260252);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aex localaex = (aex)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260252);
          return -1;
        case 1: 
          localaex.title = locala.ajGk.readString();
          AppMethodBeat.o(260252);
          return 0;
        case 2: 
          localaex.ZmT = locala.ajGk.aar();
          AppMethodBeat.o(260252);
          return 0;
        case 3: 
          localaex.ZmU = locala.ajGk.readString();
          AppMethodBeat.o(260252);
          return 0;
        case 4: 
          localaex.ZmV = locala.ajGk.readString();
          AppMethodBeat.o(260252);
          return 0;
        case 5: 
          localaex.ZmW = locala.ajGk.readString();
          AppMethodBeat.o(260252);
          return 0;
        case 6: 
          localaex.ZmX = locala.ajGk.readString();
          AppMethodBeat.o(260252);
          return 0;
        }
        localaex.ZmY = locala.ajGk.aar();
        AppMethodBeat.o(260252);
        return 0;
      }
      AppMethodBeat.o(260252);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aex
 * JD-Core Version:    0.7.0.1
 */