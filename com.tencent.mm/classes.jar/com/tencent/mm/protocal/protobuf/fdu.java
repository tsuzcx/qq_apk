package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fdu
  extends com.tencent.mm.bw.a
{
  public int Gaz;
  public boolean Nzp;
  public String nickname;
  public String yPH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153328);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Gaz);
      if (this.yPH != null) {
        paramVarArgs.e(2, this.yPH);
      }
      if (this.nickname != null) {
        paramVarArgs.e(3, this.nickname);
      }
      paramVarArgs.cc(4, this.Nzp);
      AppMethodBeat.o(153328);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Gaz) + 0;
      paramInt = i;
      if (this.yPH != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.yPH);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.nickname);
      }
      paramInt = g.a.a.b.b.a.fS(4);
      AppMethodBeat.o(153328);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(153328);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fdu localfdu = (fdu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153328);
        return -1;
      case 1: 
        localfdu.Gaz = locala.UbS.zi();
        AppMethodBeat.o(153328);
        return 0;
      case 2: 
        localfdu.yPH = locala.UbS.readString();
        AppMethodBeat.o(153328);
        return 0;
      case 3: 
        localfdu.nickname = locala.UbS.readString();
        AppMethodBeat.o(153328);
        return 0;
      }
      localfdu.Nzp = locala.UbS.yZ();
      AppMethodBeat.o(153328);
      return 0;
    }
    AppMethodBeat.o(153328);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdu
 * JD-Core Version:    0.7.0.1
 */