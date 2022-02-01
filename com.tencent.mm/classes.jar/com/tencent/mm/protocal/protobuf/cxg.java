package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxg
  extends com.tencent.mm.cd.a
{
  public String lmL;
  public String szv;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72514);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.szv != null) {
        paramVarArgs.f(1, this.szv);
      }
      if (this.lmL != null) {
        paramVarArgs.f(2, this.lmL);
      }
      if (this.url != null) {
        paramVarArgs.f(4, this.url);
      }
      AppMethodBeat.o(72514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.szv == null) {
        break label338;
      }
    }
    label338:
    for (int i = g.a.a.b.b.a.g(1, this.szv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lmL != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lmL);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.url);
      }
      AppMethodBeat.o(72514);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72514);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cxg localcxg = (cxg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 3: 
        default: 
          AppMethodBeat.o(72514);
          return -1;
        case 1: 
          localcxg.szv = locala.abFh.readString();
          AppMethodBeat.o(72514);
          return 0;
        case 2: 
          localcxg.lmL = locala.abFh.readString();
          AppMethodBeat.o(72514);
          return 0;
        }
        localcxg.url = locala.abFh.readString();
        AppMethodBeat.o(72514);
        return 0;
      }
      AppMethodBeat.o(72514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxg
 * JD-Core Version:    0.7.0.1
 */