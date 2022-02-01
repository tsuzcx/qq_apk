package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ay
  extends com.tencent.mm.bw.a
{
  public long Btl;
  public String Btm;
  public String Btn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198643);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Btl);
      if (this.Btm != null) {
        paramVarArgs.e(2, this.Btm);
      }
      if (this.Btn != null) {
        paramVarArgs.e(3, this.Btn);
      }
      AppMethodBeat.o(198643);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.Btl) + 0;
      paramInt = i;
      if (this.Btm != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Btm);
      }
      i = paramInt;
      if (this.Btn != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Btn);
      }
      AppMethodBeat.o(198643);
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
      AppMethodBeat.o(198643);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ay localay = (ay)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(198643);
        return -1;
      case 1: 
        localay.Btl = locala.UbS.zl();
        AppMethodBeat.o(198643);
        return 0;
      case 2: 
        localay.Btm = locala.UbS.readString();
        AppMethodBeat.o(198643);
        return 0;
      }
      localay.Btn = locala.UbS.readString();
      AppMethodBeat.o(198643);
      return 0;
    }
    AppMethodBeat.o(198643);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.ay
 * JD-Core Version:    0.7.0.1
 */