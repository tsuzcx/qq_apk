package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class age
  extends com.tencent.mm.bx.a
{
  public int Zpm;
  public b Zpn;
  public LinkedList<Long> Zpo;
  
  public age()
  {
    AppMethodBeat.i(259662);
    this.Zpo = new LinkedList();
    AppMethodBeat.o(259662);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259665);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Zpm);
      if (this.Zpn != null) {
        paramVarArgs.d(2, this.Zpn);
      }
      paramVarArgs.e(3, 3, this.Zpo);
      AppMethodBeat.o(259665);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Zpm) + 0;
      paramInt = i;
      if (this.Zpn != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.Zpn);
      }
      i = i.a.a.a.c(3, 3, this.Zpo);
      AppMethodBeat.o(259665);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Zpo.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259665);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      age localage = (age)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259665);
        return -1;
      case 1: 
        localage.Zpm = locala.ajGk.aar();
        AppMethodBeat.o(259665);
        return 0;
      case 2: 
        localage.Zpn = locala.ajGk.kFX();
        AppMethodBeat.o(259665);
        return 0;
      }
      localage.Zpo.add(Long.valueOf(locala.ajGk.aaw()));
      AppMethodBeat.o(259665);
      return 0;
    }
    AppMethodBeat.o(259665);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.age
 * JD-Core Version:    0.7.0.1
 */