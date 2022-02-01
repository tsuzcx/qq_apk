package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bio
  extends com.tencent.mm.bx.a
{
  public String Kru;
  public int YEX;
  public int ZRM;
  public String ZRN;
  public String icon_url;
  public String igN;
  public String wording;
  public int wuj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257323);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YEX);
      paramVarArgs.bS(2, this.ZRM);
      paramVarArgs.bS(3, this.wuj);
      if (this.Kru != null) {
        paramVarArgs.g(4, this.Kru);
      }
      if (this.icon_url != null) {
        paramVarArgs.g(5, this.icon_url);
      }
      if (this.wording != null) {
        paramVarArgs.g(6, this.wording);
      }
      if (this.ZRN != null) {
        paramVarArgs.g(7, this.ZRN);
      }
      if (this.igN != null) {
        paramVarArgs.g(8, this.igN);
      }
      AppMethodBeat.o(257323);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YEX) + 0 + i.a.a.b.b.a.cJ(2, this.ZRM) + i.a.a.b.b.a.cJ(3, this.wuj);
      paramInt = i;
      if (this.Kru != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Kru);
      }
      i = paramInt;
      if (this.icon_url != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.icon_url);
      }
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.wording);
      }
      i = paramInt;
      if (this.ZRN != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZRN);
      }
      paramInt = i;
      if (this.igN != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.igN);
      }
      AppMethodBeat.o(257323);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257323);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bio localbio = (bio)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257323);
        return -1;
      case 1: 
        localbio.YEX = locala.ajGk.aar();
        AppMethodBeat.o(257323);
        return 0;
      case 2: 
        localbio.ZRM = locala.ajGk.aar();
        AppMethodBeat.o(257323);
        return 0;
      case 3: 
        localbio.wuj = locala.ajGk.aar();
        AppMethodBeat.o(257323);
        return 0;
      case 4: 
        localbio.Kru = locala.ajGk.readString();
        AppMethodBeat.o(257323);
        return 0;
      case 5: 
        localbio.icon_url = locala.ajGk.readString();
        AppMethodBeat.o(257323);
        return 0;
      case 6: 
        localbio.wording = locala.ajGk.readString();
        AppMethodBeat.o(257323);
        return 0;
      case 7: 
        localbio.ZRN = locala.ajGk.readString();
        AppMethodBeat.o(257323);
        return 0;
      }
      localbio.igN = locala.ajGk.readString();
      AppMethodBeat.o(257323);
      return 0;
    }
    AppMethodBeat.o(257323);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bio
 * JD-Core Version:    0.7.0.1
 */