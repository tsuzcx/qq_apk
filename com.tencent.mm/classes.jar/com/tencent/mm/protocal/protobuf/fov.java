package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fov
  extends com.tencent.mm.cd.a
{
  public int ChC;
  public String EtG;
  public boolean UMS;
  public String nickname;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153328);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.ChC);
      if (this.EtG != null) {
        paramVarArgs.f(2, this.EtG);
      }
      if (this.nickname != null) {
        paramVarArgs.f(3, this.nickname);
      }
      paramVarArgs.co(4, this.UMS);
      AppMethodBeat.o(153328);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.ChC) + 0;
      paramInt = i;
      if (this.EtG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.EtG);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.nickname);
      }
      paramInt = g.a.a.b.b.a.gL(4);
      AppMethodBeat.o(153328);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(153328);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fov localfov = (fov)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153328);
        return -1;
      case 1: 
        localfov.ChC = locala.abFh.AK();
        AppMethodBeat.o(153328);
        return 0;
      case 2: 
        localfov.EtG = locala.abFh.readString();
        AppMethodBeat.o(153328);
        return 0;
      case 3: 
        localfov.nickname = locala.abFh.readString();
        AppMethodBeat.o(153328);
        return 0;
      }
      localfov.UMS = locala.abFh.AB();
      AppMethodBeat.o(153328);
      return 0;
    }
    AppMethodBeat.o(153328);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fov
 * JD-Core Version:    0.7.0.1
 */