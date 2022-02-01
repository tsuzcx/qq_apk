package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends com.tencent.mm.bx.a
{
  public int Njs;
  public String Njt;
  public int Nju;
  public long Njv;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122660);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Njs);
      if (this.Njt != null) {
        paramVarArgs.g(2, this.Njt);
      }
      paramVarArgs.bS(3, this.vhk);
      paramVarArgs.bS(4, this.Nju);
      paramVarArgs.bv(5, this.Njv);
      AppMethodBeat.o(122660);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Njs) + 0;
      paramInt = i;
      if (this.Njt != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Njt);
      }
      i = i.a.a.b.b.a.cJ(3, this.vhk);
      int j = i.a.a.b.b.a.cJ(4, this.Nju);
      int k = i.a.a.b.b.a.q(5, this.Njv);
      AppMethodBeat.o(122660);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(122660);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122660);
        return -1;
      case 1: 
        locale.Njs = locala.ajGk.aar();
        AppMethodBeat.o(122660);
        return 0;
      case 2: 
        locale.Njt = locala.ajGk.readString();
        AppMethodBeat.o(122660);
        return 0;
      case 3: 
        locale.vhk = locala.ajGk.aar();
        AppMethodBeat.o(122660);
        return 0;
      case 4: 
        locale.Nju = locala.ajGk.aar();
        AppMethodBeat.o(122660);
        return 0;
      }
      locale.Njv = locala.ajGk.aaw();
      AppMethodBeat.o(122660);
      return 0;
    }
    AppMethodBeat.o(122660);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.e
 * JD-Core Version:    0.7.0.1
 */