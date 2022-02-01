package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.bx.a
{
  public int pHo;
  public int pHp;
  public int pHq;
  public long pHr;
  public long pHs;
  public String pHt;
  public String pHu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91323);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.pHo);
      paramVarArgs.bS(2, this.pHp);
      paramVarArgs.bS(3, this.pHq);
      paramVarArgs.bv(4, this.pHr);
      paramVarArgs.bv(5, this.pHs);
      if (this.pHt != null) {
        paramVarArgs.g(6, this.pHt);
      }
      if (this.pHu != null) {
        paramVarArgs.g(7, this.pHu);
      }
      AppMethodBeat.o(91323);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.pHo) + 0 + i.a.a.b.b.a.cJ(2, this.pHp) + i.a.a.b.b.a.cJ(3, this.pHq) + i.a.a.b.b.a.q(4, this.pHr) + i.a.a.b.b.a.q(5, this.pHs);
      paramInt = i;
      if (this.pHt != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.pHt);
      }
      i = paramInt;
      if (this.pHu != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.pHu);
      }
      AppMethodBeat.o(91323);
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
      AppMethodBeat.o(91323);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91323);
        return -1;
      case 1: 
        localo.pHo = locala.ajGk.aar();
        AppMethodBeat.o(91323);
        return 0;
      case 2: 
        localo.pHp = locala.ajGk.aar();
        AppMethodBeat.o(91323);
        return 0;
      case 3: 
        localo.pHq = locala.ajGk.aar();
        AppMethodBeat.o(91323);
        return 0;
      case 4: 
        localo.pHr = locala.ajGk.aaw();
        AppMethodBeat.o(91323);
        return 0;
      case 5: 
        localo.pHs = locala.ajGk.aaw();
        AppMethodBeat.o(91323);
        return 0;
      case 6: 
        localo.pHt = locala.ajGk.readString();
        AppMethodBeat.o(91323);
        return 0;
      }
      localo.pHu = locala.ajGk.readString();
      AppMethodBeat.o(91323);
      return 0;
    }
    AppMethodBeat.o(91323);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.o
 * JD-Core Version:    0.7.0.1
 */