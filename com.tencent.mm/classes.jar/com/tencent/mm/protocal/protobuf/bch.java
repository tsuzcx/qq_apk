package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bch
  extends com.tencent.mm.bw.a
{
  public int LLv;
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
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.mediaType);
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.e(3, this.thumbUrl);
      }
      paramVarArgs.E(4, this.width);
      paramVarArgs.E(5, this.height);
      paramVarArgs.aM(6, this.LLv);
      AppMethodBeat.o(164045);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.mediaType) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.thumbUrl);
      }
      paramInt = g.a.a.b.b.a.fS(4);
      int j = g.a.a.b.b.a.fS(5);
      int k = g.a.a.b.b.a.bu(6, this.LLv);
      AppMethodBeat.o(164045);
      return i + (paramInt + 4) + (j + 4) + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(164045);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bch localbch = (bch)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(164045);
        return -1;
      case 1: 
        localbch.mediaType = locala.UbS.zi();
        AppMethodBeat.o(164045);
        return 0;
      case 2: 
        localbch.url = locala.UbS.readString();
        AppMethodBeat.o(164045);
        return 0;
      case 3: 
        localbch.thumbUrl = locala.UbS.readString();
        AppMethodBeat.o(164045);
        return 0;
      case 4: 
        localbch.width = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(164045);
        return 0;
      case 5: 
        localbch.height = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(164045);
        return 0;
      }
      localbch.LLv = locala.UbS.zi();
      AppMethodBeat.o(164045);
      return 0;
    }
    AppMethodBeat.o(164045);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bch
 * JD-Core Version:    0.7.0.1
 */