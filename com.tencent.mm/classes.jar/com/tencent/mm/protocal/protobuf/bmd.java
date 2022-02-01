package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmd
  extends com.tencent.mm.cd.a
{
  public String EAJ;
  public String EAK;
  public long EAr;
  public String EAs;
  public String Ezh;
  public int state;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(271194);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.EAr);
      if (this.EAs != null) {
        paramVarArgs.f(2, this.EAs);
      }
      if (this.Ezh != null) {
        paramVarArgs.f(3, this.Ezh);
      }
      paramVarArgs.aY(4, this.state);
      if (this.EAJ != null) {
        paramVarArgs.f(5, this.EAJ);
      }
      if (this.userName != null) {
        paramVarArgs.f(6, this.userName);
      }
      if (this.EAK != null) {
        paramVarArgs.f(7, this.EAK);
      }
      AppMethodBeat.o(271194);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.EAr) + 0;
      paramInt = i;
      if (this.EAs != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.EAs);
      }
      i = paramInt;
      if (this.Ezh != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Ezh);
      }
      i += g.a.a.b.b.a.bM(4, this.state);
      paramInt = i;
      if (this.EAJ != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.EAJ);
      }
      i = paramInt;
      if (this.userName != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.userName);
      }
      paramInt = i;
      if (this.EAK != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.EAK);
      }
      AppMethodBeat.o(271194);
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
      AppMethodBeat.o(271194);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bmd localbmd = (bmd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(271194);
        return -1;
      case 1: 
        localbmd.EAr = locala.abFh.AN();
        AppMethodBeat.o(271194);
        return 0;
      case 2: 
        localbmd.EAs = locala.abFh.readString();
        AppMethodBeat.o(271194);
        return 0;
      case 3: 
        localbmd.Ezh = locala.abFh.readString();
        AppMethodBeat.o(271194);
        return 0;
      case 4: 
        localbmd.state = locala.abFh.AK();
        AppMethodBeat.o(271194);
        return 0;
      case 5: 
        localbmd.EAJ = locala.abFh.readString();
        AppMethodBeat.o(271194);
        return 0;
      case 6: 
        localbmd.userName = locala.abFh.readString();
        AppMethodBeat.o(271194);
        return 0;
      }
      localbmd.EAK = locala.abFh.readString();
      AppMethodBeat.o(271194);
      return 0;
    }
    AppMethodBeat.o(271194);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmd
 * JD-Core Version:    0.7.0.1
 */