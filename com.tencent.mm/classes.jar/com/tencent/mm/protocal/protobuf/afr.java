package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afr
  extends com.tencent.mm.bx.a
{
  public long ZnE;
  public String ZoI;
  public LinkedList<String> ZoJ;
  public int Zox;
  
  public afr()
  {
    AppMethodBeat.i(259906);
    this.ZoJ = new LinkedList();
    AppMethodBeat.o(259906);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259910);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ZnE);
      if (this.ZoI != null) {
        paramVarArgs.g(2, this.ZoI);
      }
      paramVarArgs.e(3, 1, this.ZoJ);
      paramVarArgs.bS(4, this.Zox);
      AppMethodBeat.o(259910);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.ZnE) + 0;
      paramInt = i;
      if (this.ZoI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZoI);
      }
      i = i.a.a.a.c(3, 1, this.ZoJ);
      int j = i.a.a.b.b.a.cJ(4, this.Zox);
      AppMethodBeat.o(259910);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZoJ.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259910);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      afr localafr = (afr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259910);
        return -1;
      case 1: 
        localafr.ZnE = locala.ajGk.aaw();
        AppMethodBeat.o(259910);
        return 0;
      case 2: 
        localafr.ZoI = locala.ajGk.readString();
        AppMethodBeat.o(259910);
        return 0;
      case 3: 
        localafr.ZoJ.add(locala.ajGk.readString());
        AppMethodBeat.o(259910);
        return 0;
      }
      localafr.Zox = locala.ajGk.aar();
      AppMethodBeat.o(259910);
      return 0;
    }
    AppMethodBeat.o(259910);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afr
 * JD-Core Version:    0.7.0.1
 */