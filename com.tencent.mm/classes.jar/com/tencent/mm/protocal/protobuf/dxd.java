package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxd
  extends com.tencent.mm.bw.a
{
  public LinkedList<Integer> GdM;
  public boolean GdN;
  
  public dxd()
  {
    AppMethodBeat.i(32543);
    this.GdM = new LinkedList();
    AppMethodBeat.o(32543);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32544);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 2, this.GdM);
      paramVarArgs.bl(2, this.GdN);
      AppMethodBeat.o(32544);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 2, this.GdM);
      int i = f.a.a.b.b.a.fK(2);
      AppMethodBeat.o(32544);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GdM.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32544);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dxd localdxd = (dxd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32544);
        return -1;
      case 1: 
        localdxd.GdM.add(Integer.valueOf(locala.LVo.xF()));
        AppMethodBeat.o(32544);
        return 0;
      }
      localdxd.GdN = locala.LVo.fZX();
      AppMethodBeat.o(32544);
      return 0;
    }
    AppMethodBeat.o(32544);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxd
 * JD-Core Version:    0.7.0.1
 */