package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajx
  extends com.tencent.mm.cd.a
{
  public String AesKey;
  public int HlG;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104771);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.f(1, this.Url);
      }
      if (this.AesKey != null) {
        paramVarArgs.f(2, this.AesKey);
      }
      paramVarArgs.aY(3, this.HlG);
      AppMethodBeat.o(104771);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.AesKey);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.HlG);
      AppMethodBeat.o(104771);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104771);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ajx localajx = (ajx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104771);
          return -1;
        case 1: 
          localajx.Url = locala.abFh.readString();
          AppMethodBeat.o(104771);
          return 0;
        case 2: 
          localajx.AesKey = locala.abFh.readString();
          AppMethodBeat.o(104771);
          return 0;
        }
        localajx.HlG = locala.abFh.AK();
        AppMethodBeat.o(104771);
        return 0;
      }
      AppMethodBeat.o(104771);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajx
 * JD-Core Version:    0.7.0.1
 */