package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cok
  extends com.tencent.mm.bw.a
{
  public int LLv;
  public String coverUrl;
  public float height;
  public String thumbUrl;
  public String url;
  public float width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196097);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.e(1, this.url);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.e(2, this.thumbUrl);
      }
      paramVarArgs.E(3, this.width);
      paramVarArgs.E(4, this.height);
      if (this.coverUrl != null) {
        paramVarArgs.e(5, this.coverUrl);
      }
      paramVarArgs.aM(6, this.LLv);
      AppMethodBeat.o(196097);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label468;
      }
    }
    label468:
    for (paramInt = g.a.a.b.b.a.f(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.thumbUrl);
      }
      i = i + (g.a.a.b.b.a.fS(3) + 4) + (g.a.a.b.b.a.fS(4) + 4);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.coverUrl);
      }
      i = g.a.a.b.b.a.bu(6, this.LLv);
      AppMethodBeat.o(196097);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(196097);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cok localcok = (cok)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(196097);
          return -1;
        case 1: 
          localcok.url = locala.UbS.readString();
          AppMethodBeat.o(196097);
          return 0;
        case 2: 
          localcok.thumbUrl = locala.UbS.readString();
          AppMethodBeat.o(196097);
          return 0;
        case 3: 
          localcok.width = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(196097);
          return 0;
        case 4: 
          localcok.height = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(196097);
          return 0;
        case 5: 
          localcok.coverUrl = locala.UbS.readString();
          AppMethodBeat.o(196097);
          return 0;
        }
        localcok.LLv = locala.UbS.zi();
        AppMethodBeat.o(196097);
        return 0;
      }
      AppMethodBeat.o(196097);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cok
 * JD-Core Version:    0.7.0.1
 */