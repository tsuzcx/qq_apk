package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alc
  extends com.tencent.mm.bx.a
{
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
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.mediaType);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.d(3, this.thumbUrl);
      }
      paramVarArgs.x(4, this.width);
      paramVarArgs.x(5, this.height);
      AppMethodBeat.o(164045);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.mediaType) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.thumbUrl);
      }
      paramInt = f.a.a.b.b.a.fY(4);
      int j = f.a.a.b.b.a.fY(5);
      AppMethodBeat.o(164045);
      return i + (paramInt + 4) + (j + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(164045);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      alc localalc = (alc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(164045);
        return -1;
      case 1: 
        localalc.mediaType = locala.KhF.xS();
        AppMethodBeat.o(164045);
        return 0;
      case 2: 
        localalc.url = locala.KhF.readString();
        AppMethodBeat.o(164045);
        return 0;
      case 3: 
        localalc.thumbUrl = locala.KhF.readString();
        AppMethodBeat.o(164045);
        return 0;
      case 4: 
        localalc.width = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(164045);
        return 0;
      }
      localalc.height = Float.intBitsToFloat(locala.KhF.fHx());
      AppMethodBeat.o(164045);
      return 0;
    }
    AppMethodBeat.o(164045);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alc
 * JD-Core Version:    0.7.0.1
 */