package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bw.a
{
  public int month;
  public String vxO;
  public int year;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91260);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.year);
      paramVarArgs.aR(2, this.month);
      if (this.vxO != null) {
        paramVarArgs.d(3, this.vxO);
      }
      AppMethodBeat.o(91260);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.year) + 0 + f.a.a.b.b.a.bx(2, this.month);
      paramInt = i;
      if (this.vxO != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.vxO);
      }
      AppMethodBeat.o(91260);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91260);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91260);
        return -1;
      case 1: 
        locald.year = locala.LVo.xF();
        AppMethodBeat.o(91260);
        return 0;
      case 2: 
        locald.month = locala.LVo.xF();
        AppMethodBeat.o(91260);
        return 0;
      }
      locald.vxO = locala.LVo.readString();
      AppMethodBeat.o(91260);
      return 0;
    }
    AppMethodBeat.o(91260);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.d
 * JD-Core Version:    0.7.0.1
 */