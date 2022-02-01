package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ebn
  extends com.tencent.mm.bw.a
{
  public LinkedList<Long> Nbk;
  public String Nbl;
  
  public ebn()
  {
    AppMethodBeat.i(192790);
    this.Nbk = new LinkedList();
    AppMethodBeat.o(192790);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(192791);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 3, this.Nbk);
      if (this.Nbl != null) {
        paramVarArgs.e(2, this.Nbl);
      }
      AppMethodBeat.o(192791);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.a.c(1, 3, this.Nbk) + 0;
      paramInt = i;
      if (this.Nbl != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Nbl);
      }
      AppMethodBeat.o(192791);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Nbk.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(192791);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ebn localebn = (ebn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(192791);
        return -1;
      case 1: 
        localebn.Nbk.add(Long.valueOf(locala.UbS.zl()));
        AppMethodBeat.o(192791);
        return 0;
      }
      localebn.Nbl = locala.UbS.readString();
      AppMethodBeat.o(192791);
      return 0;
    }
    AppMethodBeat.o(192791);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebn
 * JD-Core Version:    0.7.0.1
 */