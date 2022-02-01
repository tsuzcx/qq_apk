package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ari
  extends com.tencent.mm.bx.a
{
  public int Gph;
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
      paramVarArgs.z(4, this.width);
      paramVarArgs.z(5, this.height);
      paramVarArgs.aS(6, this.Gph);
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
      paramInt = f.a.a.b.b.a.alU(4);
      int j = f.a.a.b.b.a.alU(5);
      int k = f.a.a.b.b.a.bz(6, this.Gph);
      AppMethodBeat.o(164045);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(164045);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ari localari = (ari)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(164045);
        return -1;
      case 1: 
        localari.mediaType = locala.NPN.zc();
        AppMethodBeat.o(164045);
        return 0;
      case 2: 
        localari.url = locala.NPN.readString();
        AppMethodBeat.o(164045);
        return 0;
      case 3: 
        localari.thumbUrl = locala.NPN.readString();
        AppMethodBeat.o(164045);
        return 0;
      case 4: 
        localari.width = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(164045);
        return 0;
      case 5: 
        localari.height = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(164045);
        return 0;
      }
      localari.Gph = locala.NPN.zc();
      AppMethodBeat.o(164045);
      return 0;
    }
    AppMethodBeat.o(164045);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ari
 * JD-Core Version:    0.7.0.1
 */