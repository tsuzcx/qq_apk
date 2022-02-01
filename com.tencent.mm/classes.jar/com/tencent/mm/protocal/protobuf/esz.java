package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class esz
  extends com.tencent.mm.cd.a
{
  public long Uvb;
  public long Uvp;
  public long Uvq;
  public String mediaId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153014);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.mediaId != null) {
        paramVarArgs.f(1, this.mediaId);
      }
      paramVarArgs.bm(2, this.Uvp);
      paramVarArgs.bm(3, this.Uvq);
      paramVarArgs.bm(4, this.Uvb);
      AppMethodBeat.o(153014);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mediaId == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = g.a.a.b.b.a.g(1, this.mediaId) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.Uvp);
      int j = g.a.a.b.b.a.p(3, this.Uvq);
      int k = g.a.a.b.b.a.p(4, this.Uvb);
      AppMethodBeat.o(153014);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153014);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        esz localesz = (esz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153014);
          return -1;
        case 1: 
          localesz.mediaId = locala.abFh.readString();
          AppMethodBeat.o(153014);
          return 0;
        case 2: 
          localesz.Uvp = locala.abFh.AN();
          AppMethodBeat.o(153014);
          return 0;
        case 3: 
          localesz.Uvq = locala.abFh.AN();
          AppMethodBeat.o(153014);
          return 0;
        }
        localesz.Uvb = locala.abFh.AN();
        AppMethodBeat.o(153014);
        return 0;
      }
      AppMethodBeat.o(153014);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esz
 * JD-Core Version:    0.7.0.1
 */