package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajs
  extends com.tencent.mm.bw.a
{
  public int Ltf;
  public int Ltg;
  public String Lth;
  public String dQx;
  public String qGB;
  public int xGz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(179487);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Ltf);
      paramVarArgs.aM(2, this.Ltg);
      paramVarArgs.aM(3, this.xGz);
      if (this.dQx != null) {
        paramVarArgs.e(4, this.dQx);
      }
      if (this.qGB != null) {
        paramVarArgs.e(5, this.qGB);
      }
      if (this.Lth != null) {
        paramVarArgs.e(6, this.Lth);
      }
      AppMethodBeat.o(179487);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Ltf) + 0 + g.a.a.b.b.a.bu(2, this.Ltg) + g.a.a.b.b.a.bu(3, this.xGz);
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.dQx);
      }
      i = paramInt;
      if (this.qGB != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.qGB);
      }
      paramInt = i;
      if (this.Lth != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Lth);
      }
      AppMethodBeat.o(179487);
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
      AppMethodBeat.o(179487);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ajs localajs = (ajs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(179487);
        return -1;
      case 1: 
        localajs.Ltf = locala.UbS.zi();
        AppMethodBeat.o(179487);
        return 0;
      case 2: 
        localajs.Ltg = locala.UbS.zi();
        AppMethodBeat.o(179487);
        return 0;
      case 3: 
        localajs.xGz = locala.UbS.zi();
        AppMethodBeat.o(179487);
        return 0;
      case 4: 
        localajs.dQx = locala.UbS.readString();
        AppMethodBeat.o(179487);
        return 0;
      case 5: 
        localajs.qGB = locala.UbS.readString();
        AppMethodBeat.o(179487);
        return 0;
      }
      localajs.Lth = locala.UbS.readString();
      AppMethodBeat.o(179487);
      return 0;
    }
    AppMethodBeat.o(179487);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajs
 * JD-Core Version:    0.7.0.1
 */