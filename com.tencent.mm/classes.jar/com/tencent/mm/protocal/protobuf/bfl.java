package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfl
  extends com.tencent.mm.bx.a
{
  public int ZPp;
  public String ZPq;
  public int ZPr;
  public String ZPs;
  public int ZPt;
  public String background_color;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258494);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZPp);
      if (this.ZPq != null) {
        paramVarArgs.g(2, this.ZPq);
      }
      paramVarArgs.bS(3, this.ZPr);
      if (this.background_color != null) {
        paramVarArgs.g(4, this.background_color);
      }
      if (this.ZPs != null) {
        paramVarArgs.g(5, this.ZPs);
      }
      paramVarArgs.bS(6, this.ZPt);
      AppMethodBeat.o(258494);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ZPp) + 0;
      paramInt = i;
      if (this.ZPq != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZPq);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.ZPr);
      paramInt = i;
      if (this.background_color != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.background_color);
      }
      i = paramInt;
      if (this.ZPs != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZPs);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.ZPt);
      AppMethodBeat.o(258494);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258494);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bfl localbfl = (bfl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258494);
        return -1;
      case 1: 
        localbfl.ZPp = locala.ajGk.aar();
        AppMethodBeat.o(258494);
        return 0;
      case 2: 
        localbfl.ZPq = locala.ajGk.readString();
        AppMethodBeat.o(258494);
        return 0;
      case 3: 
        localbfl.ZPr = locala.ajGk.aar();
        AppMethodBeat.o(258494);
        return 0;
      case 4: 
        localbfl.background_color = locala.ajGk.readString();
        AppMethodBeat.o(258494);
        return 0;
      case 5: 
        localbfl.ZPs = locala.ajGk.readString();
        AppMethodBeat.o(258494);
        return 0;
      }
      localbfl.ZPt = locala.ajGk.aar();
      AppMethodBeat.o(258494);
      return 0;
    }
    AppMethodBeat.o(258494);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfl
 * JD-Core Version:    0.7.0.1
 */