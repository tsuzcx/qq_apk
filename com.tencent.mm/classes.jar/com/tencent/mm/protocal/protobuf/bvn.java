package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvn
  extends com.tencent.mm.cd.a
{
  public String path;
  public String qpi;
  public String title;
  public int type;
  public String ufC;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123579);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ufC != null) {
        paramVarArgs.f(1, this.ufC);
      }
      if (this.title != null) {
        paramVarArgs.f(2, this.title);
      }
      paramVarArgs.aY(3, this.type);
      if (this.qpi != null) {
        paramVarArgs.f(4, this.qpi);
      }
      if (this.username != null) {
        paramVarArgs.f(5, this.username);
      }
      if (this.path != null) {
        paramVarArgs.f(6, this.path);
      }
      AppMethodBeat.o(123579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ufC == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = g.a.a.b.b.a.g(1, this.ufC) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.title);
      }
      i += g.a.a.b.b.a.bM(3, this.type);
      paramInt = i;
      if (this.qpi != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.qpi);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.username);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.path);
      }
      AppMethodBeat.o(123579);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123579);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bvn localbvn = (bvn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123579);
          return -1;
        case 1: 
          localbvn.ufC = locala.abFh.readString();
          AppMethodBeat.o(123579);
          return 0;
        case 2: 
          localbvn.title = locala.abFh.readString();
          AppMethodBeat.o(123579);
          return 0;
        case 3: 
          localbvn.type = locala.abFh.AK();
          AppMethodBeat.o(123579);
          return 0;
        case 4: 
          localbvn.qpi = locala.abFh.readString();
          AppMethodBeat.o(123579);
          return 0;
        case 5: 
          localbvn.username = locala.abFh.readString();
          AppMethodBeat.o(123579);
          return 0;
        }
        localbvn.path = locala.abFh.readString();
        AppMethodBeat.o(123579);
        return 0;
      }
      AppMethodBeat.o(123579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvn
 * JD-Core Version:    0.7.0.1
 */