package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckl
  extends com.tencent.mm.cd.a
{
  public String CQz;
  public String TrZ;
  public String Url;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32328);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.f(1, this.Url);
      }
      if (this.fwr != null) {
        paramVarArgs.f(2, this.fwr);
      }
      if (this.TrZ != null) {
        paramVarArgs.f(3, this.TrZ);
      }
      if (this.CQz != null) {
        paramVarArgs.f(4, this.CQz);
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
    for (int i = g.a.a.b.b.a.g(1, this.Url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fwr);
      }
      i = paramInt;
      if (this.TrZ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TrZ);
      }
      paramInt = i;
      if (this.CQz != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CQz);
      }
      AppMethodBeat.o(32328);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32328);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ckl localckl = (ckl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32328);
          return -1;
        case 1: 
          localckl.Url = locala.abFh.readString();
          AppMethodBeat.o(32328);
          return 0;
        case 2: 
          localckl.fwr = locala.abFh.readString();
          AppMethodBeat.o(32328);
          return 0;
        case 3: 
          localckl.TrZ = locala.abFh.readString();
          AppMethodBeat.o(32328);
          return 0;
        }
        localckl.CQz = locala.abFh.readString();
        AppMethodBeat.o(32328);
        return 0;
      }
      AppMethodBeat.o(32328);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckl
 * JD-Core Version:    0.7.0.1
 */