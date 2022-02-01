package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class arx
  extends com.tencent.mm.bw.a
{
  public int GIx;
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
      paramVarArgs.aS(1, this.mediaType);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.d(3, this.thumbUrl);
      }
      paramVarArgs.y(4, this.width);
      paramVarArgs.y(5, this.height);
      paramVarArgs.aS(6, this.GIx);
      AppMethodBeat.o(164045);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.mediaType) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.thumbUrl);
      }
      paramInt = f.a.a.b.b.a.amE(4);
      int j = f.a.a.b.b.a.amE(5);
      int k = f.a.a.b.b.a.bz(6, this.GIx);
      AppMethodBeat.o(164045);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(164045);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      arx localarx = (arx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(164045);
        return -1;
      case 1: 
        localarx.mediaType = locala.OmT.zc();
        AppMethodBeat.o(164045);
        return 0;
      case 2: 
        localarx.url = locala.OmT.readString();
        AppMethodBeat.o(164045);
        return 0;
      case 3: 
        localarx.thumbUrl = locala.OmT.readString();
        AppMethodBeat.o(164045);
        return 0;
      case 4: 
        localarx.width = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(164045);
        return 0;
      case 5: 
        localarx.height = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(164045);
        return 0;
      }
      localarx.GIx = locala.OmT.zc();
      AppMethodBeat.o(164045);
      return 0;
    }
    AppMethodBeat.o(164045);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arx
 * JD-Core Version:    0.7.0.1
 */