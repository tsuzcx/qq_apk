package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byt
  extends com.tencent.mm.bx.a
{
  public String ZTY;
  public String aahQ;
  public int aahR;
  public int style;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257932);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      paramVarArgs.bS(2, this.style);
      if (this.ZTY != null) {
        paramVarArgs.g(3, this.ZTY);
      }
      if (this.aahQ != null) {
        paramVarArgs.g(4, this.aahQ);
      }
      paramVarArgs.bS(5, this.aahR);
      AppMethodBeat.o(257932);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.style);
      paramInt = i;
      if (this.ZTY != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZTY);
      }
      i = paramInt;
      if (this.aahQ != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aahQ);
      }
      paramInt = i.a.a.b.b.a.cJ(5, this.aahR);
      AppMethodBeat.o(257932);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257932);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        byt localbyt = (byt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257932);
          return -1;
        case 1: 
          localbyt.title = locala.ajGk.readString();
          AppMethodBeat.o(257932);
          return 0;
        case 2: 
          localbyt.style = locala.ajGk.aar();
          AppMethodBeat.o(257932);
          return 0;
        case 3: 
          localbyt.ZTY = locala.ajGk.readString();
          AppMethodBeat.o(257932);
          return 0;
        case 4: 
          localbyt.aahQ = locala.ajGk.readString();
          AppMethodBeat.o(257932);
          return 0;
        }
        localbyt.aahR = locala.ajGk.aar();
        AppMethodBeat.o(257932);
        return 0;
      }
      AppMethodBeat.o(257932);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byt
 * JD-Core Version:    0.7.0.1
 */