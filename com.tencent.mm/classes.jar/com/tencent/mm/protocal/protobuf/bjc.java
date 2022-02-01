package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bjc
  extends com.tencent.mm.cd.a
{
  public int STm;
  public String STn;
  public String STo;
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
      paramVarArgs.aY(1, this.mediaType);
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.f(3, this.thumbUrl);
      }
      paramVarArgs.i(4, this.width);
      paramVarArgs.i(5, this.height);
      paramVarArgs.aY(6, this.STm);
      if (this.STn != null) {
        paramVarArgs.f(7, this.STn);
      }
      if (this.STo != null) {
        paramVarArgs.f(8, this.STo);
      }
      AppMethodBeat.o(164045);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.mediaType) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.url);
      }
      i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.thumbUrl);
      }
      i = i + (g.a.a.b.b.a.gL(4) + 4) + (g.a.a.b.b.a.gL(5) + 4) + g.a.a.b.b.a.bM(6, this.STm);
      paramInt = i;
      if (this.STn != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.STn);
      }
      i = paramInt;
      if (this.STo != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.STo);
      }
      AppMethodBeat.o(164045);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(164045);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bjc localbjc = (bjc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(164045);
        return -1;
      case 1: 
        localbjc.mediaType = locala.abFh.AK();
        AppMethodBeat.o(164045);
        return 0;
      case 2: 
        localbjc.url = locala.abFh.readString();
        AppMethodBeat.o(164045);
        return 0;
      case 3: 
        localbjc.thumbUrl = locala.abFh.readString();
        AppMethodBeat.o(164045);
        return 0;
      case 4: 
        localbjc.width = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(164045);
        return 0;
      case 5: 
        localbjc.height = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(164045);
        return 0;
      case 6: 
        localbjc.STm = locala.abFh.AK();
        AppMethodBeat.o(164045);
        return 0;
      case 7: 
        localbjc.STn = locala.abFh.readString();
        AppMethodBeat.o(164045);
        return 0;
      }
      localbjc.STo = locala.abFh.readString();
      AppMethodBeat.o(164045);
      return 0;
    }
    AppMethodBeat.o(164045);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjc
 * JD-Core Version:    0.7.0.1
 */