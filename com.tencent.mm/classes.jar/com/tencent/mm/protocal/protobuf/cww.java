package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cww
  extends com.tencent.mm.cd.a
{
  public int STm;
  public String coverUrl;
  public float height;
  public String thumbUrl;
  public String url;
  public float width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199761);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.f(1, this.url);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.f(2, this.thumbUrl);
      }
      paramVarArgs.i(3, this.width);
      paramVarArgs.i(4, this.height);
      if (this.coverUrl != null) {
        paramVarArgs.f(5, this.coverUrl);
      }
      paramVarArgs.aY(6, this.STm);
      AppMethodBeat.o(199761);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label468;
      }
    }
    label468:
    for (paramInt = g.a.a.b.b.a.g(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.thumbUrl);
      }
      i = i + (g.a.a.b.b.a.gL(3) + 4) + (g.a.a.b.b.a.gL(4) + 4);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.coverUrl);
      }
      i = g.a.a.b.b.a.bM(6, this.STm);
      AppMethodBeat.o(199761);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199761);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cww localcww = (cww)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(199761);
          return -1;
        case 1: 
          localcww.url = locala.abFh.readString();
          AppMethodBeat.o(199761);
          return 0;
        case 2: 
          localcww.thumbUrl = locala.abFh.readString();
          AppMethodBeat.o(199761);
          return 0;
        case 3: 
          localcww.width = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(199761);
          return 0;
        case 4: 
          localcww.height = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(199761);
          return 0;
        case 5: 
          localcww.coverUrl = locala.abFh.readString();
          AppMethodBeat.o(199761);
          return 0;
        }
        localcww.STm = locala.abFh.AK();
        AppMethodBeat.o(199761);
        return 0;
      }
      AppMethodBeat.o(199761);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cww
 * JD-Core Version:    0.7.0.1
 */