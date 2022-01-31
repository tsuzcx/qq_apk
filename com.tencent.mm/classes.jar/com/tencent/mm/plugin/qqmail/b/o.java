package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class o
  extends com.tencent.mm.bv.a
{
  public String nZR;
  public String name;
  public int pJe;
  public int pJf;
  public String pJg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(67960);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.name == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(67960);
        throw paramVarArgs;
      }
      if (this.nZR == null)
      {
        paramVarArgs = new b("Not all required fields were included: addr");
        AppMethodBeat.o(67960);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.pJe);
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      if (this.nZR != null) {
        paramVarArgs.e(3, this.nZR);
      }
      paramVarArgs.aO(4, this.pJf);
      if (this.pJg != null) {
        paramVarArgs.e(5, this.pJg);
      }
      AppMethodBeat.o(67960);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.pJe) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.name);
      }
      i = paramInt;
      if (this.nZR != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nZR);
      }
      i += e.a.a.b.b.a.bl(4, this.pJf);
      paramInt = i;
      if (this.pJg != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.pJg);
      }
      AppMethodBeat.o(67960);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.name == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(67960);
        throw paramVarArgs;
      }
      if (this.nZR == null)
      {
        paramVarArgs = new b("Not all required fields were included: addr");
        AppMethodBeat.o(67960);
        throw paramVarArgs;
      }
      AppMethodBeat.o(67960);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(67960);
        return -1;
      case 1: 
        localo.pJe = locala.CLY.sl();
        AppMethodBeat.o(67960);
        return 0;
      case 2: 
        localo.name = locala.CLY.readString();
        AppMethodBeat.o(67960);
        return 0;
      case 3: 
        localo.nZR = locala.CLY.readString();
        AppMethodBeat.o(67960);
        return 0;
      case 4: 
        localo.pJf = locala.CLY.sl();
        AppMethodBeat.o(67960);
        return 0;
      }
      localo.pJg = locala.CLY.readString();
      AppMethodBeat.o(67960);
      return 0;
    }
    AppMethodBeat.o(67960);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.o
 * JD-Core Version:    0.7.0.1
 */