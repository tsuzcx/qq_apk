package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends com.tencent.mm.bv.a
{
  public int id;
  public String name;
  public int value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56628);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.id);
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      paramVarArgs.aO(3, this.value);
      AppMethodBeat.o(56628);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.id) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.name);
      }
      i = e.a.a.b.b.a.bl(3, this.value);
      AppMethodBeat.o(56628);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56628);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56628);
        return -1;
      case 1: 
        locale.id = locala.CLY.sl();
        AppMethodBeat.o(56628);
        return 0;
      case 2: 
        locale.name = locala.CLY.readString();
        AppMethodBeat.o(56628);
        return 0;
      }
      locale.value = locala.CLY.sl();
      AppMethodBeat.o(56628);
      return 0;
    }
    AppMethodBeat.o(56628);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.e
 * JD-Core Version:    0.7.0.1
 */