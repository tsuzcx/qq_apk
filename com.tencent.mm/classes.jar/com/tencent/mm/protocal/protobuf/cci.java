package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cci
  extends com.tencent.mm.bw.a
{
  public String Mim;
  public String Title;
  public String Url;
  public String xMq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32328);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.e(1, this.Url);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.Mim != null) {
        paramVarArgs.e(3, this.Mim);
      }
      if (this.xMq != null) {
        paramVarArgs.e(4, this.xMq);
      }
      AppMethodBeat.o(32328);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label404;
      }
    }
    label404:
    for (int i = g.a.a.b.b.a.f(1, this.Url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.Mim != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Mim);
      }
      paramInt = i;
      if (this.xMq != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xMq);
      }
      AppMethodBeat.o(32328);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32328);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cci localcci = (cci)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32328);
          return -1;
        case 1: 
          localcci.Url = locala.UbS.readString();
          AppMethodBeat.o(32328);
          return 0;
        case 2: 
          localcci.Title = locala.UbS.readString();
          AppMethodBeat.o(32328);
          return 0;
        case 3: 
          localcci.Mim = locala.UbS.readString();
          AppMethodBeat.o(32328);
          return 0;
        }
        localcci.xMq = locala.UbS.readString();
        AppMethodBeat.o(32328);
        return 0;
      }
      AppMethodBeat.o(32328);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cci
 * JD-Core Version:    0.7.0.1
 */