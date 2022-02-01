package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class azi
  extends com.tencent.mm.cd.a
{
  public String SKj;
  public int SKk;
  public String SLh;
  public String SLi;
  public String SLj;
  public int status;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231018);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.status);
      if (this.title != null) {
        paramVarArgs.f(2, this.title);
      }
      if (this.SKj != null) {
        paramVarArgs.f(3, this.SKj);
      }
      if (this.SLh != null) {
        paramVarArgs.f(4, this.SLh);
      }
      if (this.SLi != null) {
        paramVarArgs.f(5, this.SLi);
      }
      paramVarArgs.aY(6, this.SKk);
      if (this.SLj != null) {
        paramVarArgs.f(7, this.SLj);
      }
      AppMethodBeat.o(231018);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.status) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.title);
      }
      i = paramInt;
      if (this.SKj != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SKj);
      }
      paramInt = i;
      if (this.SLh != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SLh);
      }
      i = paramInt;
      if (this.SLi != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SLi);
      }
      i += g.a.a.b.b.a.bM(6, this.SKk);
      paramInt = i;
      if (this.SLj != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.SLj);
      }
      AppMethodBeat.o(231018);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(231018);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      azi localazi = (azi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(231018);
        return -1;
      case 1: 
        localazi.status = locala.abFh.AK();
        AppMethodBeat.o(231018);
        return 0;
      case 2: 
        localazi.title = locala.abFh.readString();
        AppMethodBeat.o(231018);
        return 0;
      case 3: 
        localazi.SKj = locala.abFh.readString();
        AppMethodBeat.o(231018);
        return 0;
      case 4: 
        localazi.SLh = locala.abFh.readString();
        AppMethodBeat.o(231018);
        return 0;
      case 5: 
        localazi.SLi = locala.abFh.readString();
        AppMethodBeat.o(231018);
        return 0;
      case 6: 
        localazi.SKk = locala.abFh.AK();
        AppMethodBeat.o(231018);
        return 0;
      }
      localazi.SLj = locala.abFh.readString();
      AppMethodBeat.o(231018);
      return 0;
    }
    AppMethodBeat.o(231018);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azi
 * JD-Core Version:    0.7.0.1
 */