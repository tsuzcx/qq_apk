package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bez
  extends com.tencent.mm.bw.a
{
  public int state;
  public String userName;
  public String yVk;
  public String yWG;
  public String yWH;
  public long yWo;
  public String yWp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214291);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.yWo);
      if (this.yWp != null) {
        paramVarArgs.e(2, this.yWp);
      }
      if (this.yVk != null) {
        paramVarArgs.e(3, this.yVk);
      }
      paramVarArgs.aM(4, this.state);
      if (this.yWG != null) {
        paramVarArgs.e(5, this.yWG);
      }
      if (this.userName != null) {
        paramVarArgs.e(6, this.userName);
      }
      if (this.yWH != null) {
        paramVarArgs.e(7, this.yWH);
      }
      AppMethodBeat.o(214291);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.yWo) + 0;
      paramInt = i;
      if (this.yWp != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.yWp);
      }
      i = paramInt;
      if (this.yVk != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.yVk);
      }
      i += g.a.a.b.b.a.bu(4, this.state);
      paramInt = i;
      if (this.yWG != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.yWG);
      }
      i = paramInt;
      if (this.userName != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.userName);
      }
      paramInt = i;
      if (this.yWH != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.yWH);
      }
      AppMethodBeat.o(214291);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(214291);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bez localbez = (bez)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(214291);
        return -1;
      case 1: 
        localbez.yWo = locala.UbS.zl();
        AppMethodBeat.o(214291);
        return 0;
      case 2: 
        localbez.yWp = locala.UbS.readString();
        AppMethodBeat.o(214291);
        return 0;
      case 3: 
        localbez.yVk = locala.UbS.readString();
        AppMethodBeat.o(214291);
        return 0;
      case 4: 
        localbez.state = locala.UbS.zi();
        AppMethodBeat.o(214291);
        return 0;
      case 5: 
        localbez.yWG = locala.UbS.readString();
        AppMethodBeat.o(214291);
        return 0;
      case 6: 
        localbez.userName = locala.UbS.readString();
        AppMethodBeat.o(214291);
        return 0;
      }
      localbez.yWH = locala.UbS.readString();
      AppMethodBeat.o(214291);
      return 0;
    }
    AppMethodBeat.o(214291);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bez
 * JD-Core Version:    0.7.0.1
 */