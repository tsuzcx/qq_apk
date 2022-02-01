package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abv
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> Zkr;
  public String Zks;
  public long Zkt;
  public int vhJ;
  
  public abv()
  {
    AppMethodBeat.i(6401);
    this.Zkr = new LinkedList();
    AppMethodBeat.o(6401);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6402);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vhJ);
      paramVarArgs.e(2, 1, this.Zkr);
      if (this.Zks != null) {
        paramVarArgs.g(3, this.Zks);
      }
      paramVarArgs.bv(4, this.Zkt);
      AppMethodBeat.o(6402);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.vhJ) + 0 + i.a.a.a.c(2, 1, this.Zkr);
      paramInt = i;
      if (this.Zks != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Zks);
      }
      i = i.a.a.b.b.a.q(4, this.Zkt);
      AppMethodBeat.o(6402);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Zkr.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(6402);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      abv localabv = (abv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(6402);
        return -1;
      case 1: 
        localabv.vhJ = locala.ajGk.aar();
        AppMethodBeat.o(6402);
        return 0;
      case 2: 
        localabv.Zkr.add(locala.ajGk.readString());
        AppMethodBeat.o(6402);
        return 0;
      case 3: 
        localabv.Zks = locala.ajGk.readString();
        AppMethodBeat.o(6402);
        return 0;
      }
      localabv.Zkt = locala.ajGk.aaw();
      AppMethodBeat.o(6402);
      return 0;
    }
    AppMethodBeat.o(6402);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abv
 * JD-Core Version:    0.7.0.1
 */