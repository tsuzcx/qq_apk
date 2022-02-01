package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvj
  extends com.tencent.mm.bx.a
{
  public String HaI;
  public int aacR;
  public String aacS;
  public float height;
  public int mediaType;
  public String thumbUrl;
  public String url;
  public float width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(164045);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.mediaType);
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.g(3, this.thumbUrl);
      }
      paramVarArgs.l(4, this.width);
      paramVarArgs.l(5, this.height);
      paramVarArgs.bS(6, this.aacR);
      if (this.HaI != null) {
        paramVarArgs.g(7, this.HaI);
      }
      if (this.aacS != null) {
        paramVarArgs.g(8, this.aacS);
      }
      AppMethodBeat.o(164045);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.mediaType) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.thumbUrl);
      }
      i = i + (i.a.a.b.b.a.ko(4) + 4) + (i.a.a.b.b.a.ko(5) + 4) + i.a.a.b.b.a.cJ(6, this.aacR);
      paramInt = i;
      if (this.HaI != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.HaI);
      }
      i = paramInt;
      if (this.aacS != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.aacS);
      }
      AppMethodBeat.o(164045);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(164045);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bvj localbvj = (bvj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(164045);
        return -1;
      case 1: 
        localbvj.mediaType = locala.ajGk.aar();
        AppMethodBeat.o(164045);
        return 0;
      case 2: 
        localbvj.url = locala.ajGk.readString();
        AppMethodBeat.o(164045);
        return 0;
      case 3: 
        localbvj.thumbUrl = locala.ajGk.readString();
        AppMethodBeat.o(164045);
        return 0;
      case 4: 
        localbvj.width = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(164045);
        return 0;
      case 5: 
        localbvj.height = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(164045);
        return 0;
      case 6: 
        localbvj.aacR = locala.ajGk.aar();
        AppMethodBeat.o(164045);
        return 0;
      case 7: 
        localbvj.HaI = locala.ajGk.readString();
        AppMethodBeat.o(164045);
        return 0;
      }
      localbvj.aacS = locala.ajGk.readString();
      AppMethodBeat.o(164045);
      return 0;
    }
    AppMethodBeat.o(164045);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvj
 * JD-Core Version:    0.7.0.1
 */