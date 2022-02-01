package com.tencent.mm.plugin.multimediareport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class c
  extends com.tencent.mm.bx.a
{
  public int LhN;
  public int LhO;
  public long LhP;
  public long LhQ;
  public double LhR;
  public String LhS;
  public b LhT;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(262701);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      paramVarArgs.bS(2, this.LhN);
      paramVarArgs.bS(3, this.LhO);
      paramVarArgs.bv(4, this.LhP);
      paramVarArgs.bv(5, this.LhQ);
      paramVarArgs.d(6, this.LhR);
      if (this.LhS != null) {
        paramVarArgs.g(7, this.LhS);
      }
      if (this.LhT != null) {
        paramVarArgs.d(8, this.LhT);
      }
      AppMethodBeat.o(262701);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0 + i.a.a.b.b.a.cJ(2, this.LhN) + i.a.a.b.b.a.cJ(3, this.LhO) + i.a.a.b.b.a.q(4, this.LhP) + i.a.a.b.b.a.q(5, this.LhQ) + (i.a.a.b.b.a.ko(6) + 8);
      paramInt = i;
      if (this.LhS != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.LhS);
      }
      i = paramInt;
      if (this.LhT != null) {
        i = paramInt + i.a.a.b.b.a.c(8, this.LhT);
      }
      AppMethodBeat.o(262701);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(262701);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(262701);
        return -1;
      case 1: 
        localc.type = locala.ajGk.aar();
        AppMethodBeat.o(262701);
        return 0;
      case 2: 
        localc.LhN = locala.ajGk.aar();
        AppMethodBeat.o(262701);
        return 0;
      case 3: 
        localc.LhO = locala.ajGk.aar();
        AppMethodBeat.o(262701);
        return 0;
      case 4: 
        localc.LhP = locala.ajGk.aaw();
        AppMethodBeat.o(262701);
        return 0;
      case 5: 
        localc.LhQ = locala.ajGk.aaw();
        AppMethodBeat.o(262701);
        return 0;
      case 6: 
        localc.LhR = Double.longBitsToDouble(locala.ajGk.aay());
        AppMethodBeat.o(262701);
        return 0;
      case 7: 
        localc.LhS = locala.ajGk.readString();
        AppMethodBeat.o(262701);
        return 0;
      }
      localc.LhT = locala.ajGk.kFX();
      AppMethodBeat.o(262701);
      return 0;
    }
    AppMethodBeat.o(262701);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multimediareport.c
 * JD-Core Version:    0.7.0.1
 */