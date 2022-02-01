package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anx
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> KWr;
  public int KWs;
  
  public anx()
  {
    AppMethodBeat.i(124487);
    this.KWr = new LinkedList();
    this.KWs = 1;
    AppMethodBeat.o(124487);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124488);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.KWr);
      paramVarArgs.aM(2, this.KWs);
      AppMethodBeat.o(124488);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 1, this.KWr);
      int i = g.a.a.b.b.a.bu(2, this.KWs);
      AppMethodBeat.o(124488);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KWr.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(124488);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      anx localanx = (anx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124488);
        return -1;
      case 1: 
        localanx.KWr.add(locala.UbS.readString());
        AppMethodBeat.o(124488);
        return 0;
      }
      localanx.KWs = locala.UbS.zi();
      AppMethodBeat.o(124488);
      return 0;
    }
    AppMethodBeat.o(124488);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anx
 * JD-Core Version:    0.7.0.1
 */