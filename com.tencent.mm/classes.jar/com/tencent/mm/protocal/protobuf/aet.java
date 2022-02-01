package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aet
  extends com.tencent.mm.bw.a
{
  public int Lqc;
  public String Lqd;
  public String Lqe;
  public boolean enable;
  public String lDS;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209320);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.enable);
      paramVarArgs.aM(2, this.Lqc);
      if (this.lDS != null) {
        paramVarArgs.e(3, this.lDS);
      }
      if (this.Lqd != null) {
        paramVarArgs.e(4, this.Lqd);
      }
      if (this.Lqe != null) {
        paramVarArgs.e(5, this.Lqe);
      }
      if (this.title != null) {
        paramVarArgs.e(6, this.title);
      }
      AppMethodBeat.o(209320);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 1 + 0 + g.a.a.b.b.a.bu(2, this.Lqc);
      paramInt = i;
      if (this.lDS != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.lDS);
      }
      i = paramInt;
      if (this.Lqd != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Lqd);
      }
      paramInt = i;
      if (this.Lqe != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Lqe);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.title);
      }
      AppMethodBeat.o(209320);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209320);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aet localaet = (aet)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209320);
        return -1;
      case 1: 
        localaet.enable = locala.UbS.yZ();
        AppMethodBeat.o(209320);
        return 0;
      case 2: 
        localaet.Lqc = locala.UbS.zi();
        AppMethodBeat.o(209320);
        return 0;
      case 3: 
        localaet.lDS = locala.UbS.readString();
        AppMethodBeat.o(209320);
        return 0;
      case 4: 
        localaet.Lqd = locala.UbS.readString();
        AppMethodBeat.o(209320);
        return 0;
      case 5: 
        localaet.Lqe = locala.UbS.readString();
        AppMethodBeat.o(209320);
        return 0;
      }
      localaet.title = locala.UbS.readString();
      AppMethodBeat.o(209320);
      return 0;
    }
    AppMethodBeat.o(209320);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aet
 * JD-Core Version:    0.7.0.1
 */