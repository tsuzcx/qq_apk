package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvf
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> KKJ;
  public LinkedList<String> MWk;
  
  public dvf()
  {
    AppMethodBeat.i(91685);
    this.KKJ = new LinkedList();
    this.MWk = new LinkedList();
    AppMethodBeat.o(91685);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91686);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.KKJ);
      paramVarArgs.e(2, 1, this.MWk);
      AppMethodBeat.o(91686);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 1, this.KKJ);
      int i = g.a.a.a.c(2, 1, this.MWk);
      AppMethodBeat.o(91686);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KKJ.clear();
      this.MWk.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91686);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dvf localdvf = (dvf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91686);
        return -1;
      case 1: 
        localdvf.KKJ.add(locala.UbS.readString());
        AppMethodBeat.o(91686);
        return 0;
      }
      localdvf.MWk.add(locala.UbS.readString());
      AppMethodBeat.o(91686);
      return 0;
    }
    AppMethodBeat.o(91686);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvf
 * JD-Core Version:    0.7.0.1
 */