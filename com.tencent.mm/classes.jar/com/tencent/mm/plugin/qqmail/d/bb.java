package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bb
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> Btu;
  public long Btv;
  public long uin;
  
  public bb()
  {
    AppMethodBeat.i(198647);
    this.Btu = new LinkedList();
    AppMethodBeat.o(198647);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198648);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.uin);
      paramVarArgs.e(2, 1, this.Btu);
      paramVarArgs.bb(3, this.Btv);
      AppMethodBeat.o(198648);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.uin);
      int i = g.a.a.a.c(2, 1, this.Btu);
      int j = g.a.a.b.b.a.r(3, this.Btv);
      AppMethodBeat.o(198648);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Btu.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(198648);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bb localbb = (bb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(198648);
        return -1;
      case 1: 
        localbb.uin = locala.UbS.zl();
        AppMethodBeat.o(198648);
        return 0;
      case 2: 
        localbb.Btu.add(locala.UbS.readString());
        AppMethodBeat.o(198648);
        return 0;
      }
      localbb.Btv = locala.UbS.zl();
      AppMethodBeat.o(198648);
      return 0;
    }
    AppMethodBeat.o(198648);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.bb
 * JD-Core Version:    0.7.0.1
 */