package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class d
  extends com.tencent.mm.bx.a
{
  public boolean OzI;
  public String OzQ;
  public boolean OzR;
  public boolean OzS;
  public int muy;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143831);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.OzQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Value");
        AppMethodBeat.o(143831);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.muy);
      if (this.OzQ != null) {
        paramVarArgs.g(2, this.OzQ);
      }
      paramVarArgs.di(3, this.OzR);
      paramVarArgs.di(4, this.OzI);
      paramVarArgs.bS(5, this.vhJ);
      paramVarArgs.di(6, this.OzS);
      AppMethodBeat.o(143831);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.muy) + 0;
      paramInt = i;
      if (this.OzQ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.OzQ);
      }
      i = i.a.a.b.b.a.ko(3);
      int j = i.a.a.b.b.a.ko(4);
      int k = i.a.a.b.b.a.cJ(5, this.vhJ);
      int m = i.a.a.b.b.a.ko(6);
      AppMethodBeat.o(143831);
      return paramInt + (i + 1) + (j + 1) + k + (m + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.OzQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Value");
        AppMethodBeat.o(143831);
        throw paramVarArgs;
      }
      AppMethodBeat.o(143831);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143831);
        return -1;
      case 1: 
        locald.muy = locala.ajGk.aar();
        AppMethodBeat.o(143831);
        return 0;
      case 2: 
        locald.OzQ = locala.ajGk.readString();
        AppMethodBeat.o(143831);
        return 0;
      case 3: 
        locald.OzR = locala.ajGk.aai();
        AppMethodBeat.o(143831);
        return 0;
      case 4: 
        locald.OzI = locala.ajGk.aai();
        AppMethodBeat.o(143831);
        return 0;
      case 5: 
        locald.vhJ = locala.ajGk.aar();
        AppMethodBeat.o(143831);
        return 0;
      }
      locald.OzS = locala.ajGk.aai();
      AppMethodBeat.o(143831);
      return 0;
    }
    AppMethodBeat.o(143831);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.d
 * JD-Core Version:    0.7.0.1
 */